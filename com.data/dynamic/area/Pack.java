package dynamic.area;
import java.util.Date;


/**
 * this interface type holds all the plain info about a package of product.
 */

public class Pack {



   private Product product;
   private int quantity;
   private double price;
   private String provider;
   private Date expDate;
   private Date loadDate;

   public Pack (Product product , int quantity){
      this.product = product;
      this.quantity = quantity;
   }

   public Pack(Product product) {this.product = product;}

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getProvider() {
      return provider;
   }

   public void setProvider(String provider) {
      this.provider = provider;
   }

   public Date getExpDate() {
      return expDate;
   }

   public void setExpDate(Date expDate) {
      this.expDate = expDate;
   }

   public Date getLoadDate() {
      return loadDate;
   }

   public void setLoadDate(Date loadDate) {
      this.loadDate = loadDate;
   }


}
