package dynamic.area;

import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;

import java.util.*;

public class StockData {
   private Map <Product, ProductStock> stockList  = new TreeMap<>();
   private List <Order> salesList = new ArrayList<>();
   private   List <Order> purchasesList = new ArrayList<>();
   private Product product;

   public StockData (Map stockList, List salesList, List purchasesList){
      this.stockList = stockList;
      this.salesList = salesList;
      this.purchasesList = purchasesList;
   }
   public ProductStock search(Product product){
      return stockList.get(product);
   }
   public Boolean addPS(ProductStock productStock){
      stockList.put(productStock.getProduct(), productStock);
      return true;
   }
   public Boolean addOrder(Order order){
      salesList.add(order);
      return true;
   }
   public Boolean purchaseOrder(Order order){
      purchasesList.add(order);
      return true;
   }
   public List<Order> salesHistory(){
      return salesList;
   }
   public List<Order> purchasesHistory(){
      return purchasesList;
   }

   Iterator<Map.Entry<Product, ProductStock>> iterator(){
      Iterator<Map.Entry<Product, ProductStock>> stockIterator = stockList.entrySet().iterator();
      return stockIterator;
   }

   public Map<Product, ProductStock> getStockList() {
      return stockList;
   }

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
