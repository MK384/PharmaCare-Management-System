package dynamic.area;

import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;
import dynamic.area.head.ProductStockImp;

import java.io.IOException;
import java.util.*;

public class StockData implements Iterable<ProductStock> {
   private Map <Product, ProductStock> stockList;
   private List <Order> salesList;
   private   List <Order> purchasesList;


   public StockData (Map<Product,ProductStock> stockList, List<Order> salesList, List<Order> purchasesList){
      this.stockList = stockList;
      this.salesList = salesList;
      this.purchasesList = purchasesList;
   }

   public ProductStock search(Product product){
      return stockList.get(product);
   }


   public boolean isAvailable(Product product , int required){
      if (!stockList.containsKey(product))
         return false;

      ProductStock ps = search(product);
      return ps.totalQuantity()>=required;
   }

   public void update(Product p, Pack pack){
      ProductStock ps = search(p);
      if (ps == null)
      {
         ProductStock newPS = new ProductStockImp(p);
         newPS.addPack(pack);
         stockList.put(p,newPS);
      }
      else {
      ps.addPack(pack);
      stockList.put(p,ps);}
   }

   public List<ProductStock> retrieveAllStock() {
      return new ArrayList<>(stockList.values());
   }

   public List<Pack> extractQuantity(Product p , int quantity){
      ProductStock ps = search(p);
      List<Pack> packList = ps.extract(quantity);
      stockList.put(p,ps);
      return packList;
   }

   public Boolean addPS(ProductStock productStock){
      stockList.put(productStock.getProduct(), productStock);
      return true;
   }
   public Boolean addSaleOrder(Order order){
      salesList.add(order);
      return true;
   }
   public Boolean addPurchaseOrder(Order order){
      purchasesList.add(order);
      return true;
   }
   public List<Order> salesHistory(){
      return salesList;
   }
   public List<Order> purchasesHistory(){
      return purchasesList;
   }

   public Iterator<ProductStock> iterator(){ return stockList.values().iterator();}

   public void setStockList(Map<Product, ProductStock> stockList) {
      this.stockList = stockList;
   }

   public void setSalesList(List<Order> salesList) {
      this.salesList = salesList;
   }

   public List<Order> getPurchasesList() {
      return purchasesList;
   }

   public void setPurchasesList(List<Order> purchasesList) {
      this.purchasesList = purchasesList;
   }
}
