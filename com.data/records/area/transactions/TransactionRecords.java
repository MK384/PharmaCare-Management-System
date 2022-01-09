package records.area.transactions;

import dynamic.area.head.Order;
import records.area.handelers.StockFilesManager;
import records.area.head.FilesManager;
import records.area.head.TransactionsRecords;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class TransactionRecords implements TransactionsRecords {

   private final FilesManager filesManager;

    //private static Map< LocalDate,File> transFiles;


    public TransactionRecords(String path){
        this.filesManager = new StockFilesManager(path);
    }

    @Override
    public void storeTransaction(Order order) throws IOException {

        File newFile = filesManager.createFile(order.toString());

        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(order);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    @Override
    public List<Order> retrieveAll() throws IOException, ClassNotFoundException {

        List<Order> orderList = new ArrayList<>();
        for (File file: filesManager.getAllFiles())
           orderList.add(retrieve(file));
        return orderList;
    }

    @Override
    public List<Order> retrieve(LocalDate date) throws IOException, ClassNotFoundException {
        List<Order> orderList = retrieveAll();
        orderList.removeIf(o -> !o.getOrderingDate().equals(date));
        return orderList;
    }

    @Override
    public Order retrieve(File file) throws IOException, ClassNotFoundException {
        if (!file.isFile())
            return null;
        return (Order) new ObjectInputStream( new FileInputStream(file)).readObject();
    }

    @Override
    public List<Order> retrieve(String client) throws IOException, ClassNotFoundException {
        List<Order> transactionsList = retrieveAll();
        List<Order> orders = new LinkedList<>();
        for (Order o: transactionsList)
            if (o.getClient().equalsIgnoreCase(client))
            {
                orders.add(o);
            }
        return orders;
    }

}
