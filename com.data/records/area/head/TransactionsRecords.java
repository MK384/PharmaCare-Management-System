package records.area.head;

import dynamic.area.head.Order;
import records.area.transactions.TransFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface TransactionsRecords {


    TransFile storeTransaction(Order order) throws IOException;

    List<Order> retrieveAll() throws IOException, ClassNotFoundException;

    List<Order> retrieve(LocalDate date) throws IOException, ClassNotFoundException;

    Order retrieve(File file) throws IOException, ClassNotFoundException;

    List<Order> retrieve(String client) throws IOException, ClassNotFoundException;

}
