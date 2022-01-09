package records.area.stockroom;

import dynamic.area.Pack;
import dynamic.area.Product;
import dynamic.area.head.ProductStock;
import dynamic.area.head.ProductStockImp;
import records.area.handelers.StockFilesManager;
import records.area.head.FilesManager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StockRecords {


    private final FilesManager fileManager;

    public StockRecords(String stockPath) {
        fileManager = new StockFilesManager(stockPath);
    }

    public void storeNewPS(ProductStock ps) throws IOException {

        File file = fileManager.createFile(ps.getProduct().toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(ps);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public Map<Product, ProductStock> retrieveAll() throws IOException, ClassNotFoundException {
        Map<Product, ProductStock> map = new HashMap<>();
        for (File f : fileManager.getAllFiles()
        ) {
            ProductStock ps = retrieve(f);
            map.put(ps.getProduct(), ps);
        }
        return map;
    }

    public void update(ProductStock ps) throws IOException {

        if (!fileManager.isExist(ps.getProduct().toString())) {
            storeNewPS(ps);
            return;
        }

        File file = fileManager.search(ps.getProduct().toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        out.writeObject(ps);

        out.close();
        fileOutputStream.close();
    }

    public void update(Pack p) throws IOException, ClassNotFoundException {
        if (p == null)
            return;
        ProductStock ps = retrieve(p.getProduct());
        if (ps == null) {
            ps = new ProductStockImp(p.getProduct());
            ps.addPack(p);
        } else
            ps.addPack(p);
        update(ps);
    }

    public ProductStock retrieve(File f) throws IOException, ClassNotFoundException {
        if (f == null)
            return null;
        return (ProductStock) new ObjectInputStream(new FileInputStream(f)).readObject();
    }

    public ProductStock retrieve(Product p) throws IOException, ClassNotFoundException {
        if (p == null)
            return null;
        return retrieve(fileManager.search(p.toString()));
    }


}
