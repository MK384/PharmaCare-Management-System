package records.area.stockroom;

import dynamic.area.Pack;
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
    private final FilesManager fileManager;

    public StockRecords(String stockPath) {
        fileManager = new StockFilesManager(stockPath);
        stockFiles = fileManager.getAllFiles();
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

    public Map<Product, ProductStock> retrieveAll() throws IOException, ClassNotFoundException {
        Map<Product, ProductStock> map = new HashMap<>();
        for (File f : stockFiles
        ) {
            ProductStock ps = retrieve(f);
            map.put(ps.getProduct(), ps);
        }
        return map;
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

    public StockFile update(Pack p) throws IOException, ClassNotFoundException {

        if (p == null)
            return null;
        ProductStock ps = retrieve(p.getProduct());
        ps.addPack(p);
        return update(ps);
    }

    public ProductStock retrieve(File f) throws IOException, ClassNotFoundException {
        if (!f.isFile())
            return null;
        return (ProductStock) new ObjectInputStream(new FileInputStream(f)).readObject();
    }

    public ProductStock retrieve(Product p) throws IOException, ClassNotFoundException {
        if (p == null)
            return null;
        return retrieve(fileManager.search(p.toString()));
    }


}
