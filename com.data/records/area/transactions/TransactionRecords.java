package records.area.transactions;

import dynamic.area.head.Order;
import records.area.handelers.StockFilesManager;
import records.area.head.FilesManager;
import records.area.head.TransactionsRecords;

import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class TransactionRecords implements TransactionsRecords {

   private final FilesManager filesManager;

    private static List<File> transFiles;


    public TransactionRecords(String path) {
        this.filesManager = new StockFilesManager(path);
        transFiles = filesManager.getAllFiles();
    }

    @Override
    public TransFile storeTransaction(Order order) throws IOException {

        File newFile = filesManager.createFile(order.toString());

        FileOutputStream fileOutputStream = new FileOutputStream(newFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(order);
        objectOutputStream.close();
        fileOutputStream.close();

        transFiles.add(newFile);
        return new TransFile(order.getClient(),order.getOrderingDate(),newFile);
    }

    @Override
    public List<Order> retrieveAll() throws IOException, ClassNotFoundException {
        List<Order> transactionsList = new LinkedList<>();
        for (File f: transFiles)
            transactionsList.add(retrieve(f));

        return transactionsList;
    }

    @Override
    public List<Order> retrieve(LocalDate date) throws IOException, ClassNotFoundException {
        List<Order> transactionsList = retrieveAll();
        List<Order> orders = new LinkedList<>();
        for (Order o: transactionsList)
            if (o.getOrderingDate().equals(date))
            {
                orders.add(o);
            }
        return orders;
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
