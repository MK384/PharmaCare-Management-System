package dynamic.area;

import dynamic.area.head.Order;
import dynamic.area.head.ProductStock;

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

   public StockData() {
      this.stockList = new HashMap<>();
      this.purchasesList = new ArrayList<>();
      this.salesList = new ArrayList<>();

   }

   public ProductStock search(Product product){
      return stockList.get(product);
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
