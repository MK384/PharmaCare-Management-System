package records.area.stockroom;

import dynamic.area.Product;
import dynamic.area.head.ProductStock;
import records.area.handelers.StockFilesManager;
import records.area.head.FilesManager;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockRecords {

    private static List<File> stockFiles;
    private static FilesManager fileManager;

    public StockRecords(String stockPath) {
        fileManager = new StockFilesManager(stockPath);
        stockFiles = fileManager.getAllFiles();
    }

    public StockRecords() {
        this("C:\\Users\\moham\\Documents");
    }

    public StockFile storePS(ProductStock ps) throws IOException {

        File file = fileManager.createFile(ps.getProduct().toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(ps);
        out.close();
        fileOutputStream.close();

        stockFiles.add(file);
        return new StockFile(ps.getProduct(), file);
    }

    public Map<Product, ProductStock> retrieve() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream;
        ObjectInputStream input;
        Map<Product, ProductStock> stock = new HashMap<>();
        for (File f : stockFiles) {
            fileInputStream = new FileInputStream(f);
            input = new ObjectInputStream(fileInputStream);

            ProductStock ps = (ProductStock) input.readObject();
            stock.put(ps.getProduct(), ps);

            fileInputStream.close();
            input.close();

        }
        return stock;
    }

    public StockFile update(ProductStock ps) throws IOException {

        if (!fileManager.isExist(ps.getProduct().toString()))
            return null;

        File file = fileManager.search(ps.getProduct().toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(ps);
        out.close();
        fileOutputStream.close();

        return new StockFile(ps.getProduct(), file);
    }
}
