package dynamic.area;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;


/**
 * this interface type holds all the plain info about a package of product.
 */

public class Pack implements Serializable , Comparable<Pack> {



   private Product product;
   private int quantity;
   private String provider;
   private LocalDate expDate;
   private LocalDate loadDate;
   private double discount;


   public void setDiscount(double discount) {
      this.discount = discount;
   }

   public double getDiscount() {
      return discount;
   }

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

   public double getCost() {
      return product.getPrice()*getQuantity();
   }

   public String getProvider() {
      return provider;
   }

   public void setProvider(String provider) {
      this.provider = provider;
   }

   public LocalDate getExpDate() {
      return expDate;
   }

   public void setExpDate(LocalDate expDate) {
      this.expDate = expDate;
   }

   public LocalDate getLoadDate() {
      return loadDate;
   }

   public void setLoadDate(LocalDate loadDate) {
      this.loadDate = loadDate;
   }

   public boolean removeQuantity (int q){
      if (this.quantity >= q){
         this.quantity-=q;
         return true;
      }
      else return false;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Pack)) return false;
      Pack pack = (Pack) o;
      return quantity == pack.quantity && product.equals(pack.product) && Objects.equals(provider, pack.provider) && Objects.equals(expDate, pack.expDate) && Objects.equals(loadDate, pack.loadDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(product, quantity, provider, expDate, loadDate);
   }

   @Override
   public int compareTo(Pack o) {
      return  (this.getExpDate().compareTo(o.getExpDate()));
   }
   }

