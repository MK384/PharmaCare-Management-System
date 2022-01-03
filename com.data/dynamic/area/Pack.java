package dynamic.area;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * this interface type holds all the plain info about a package of product.
 */

public class Pack implements Serializable {



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
      return quantity == pack.quantity && Double.compare(pack.price, price) == 0 && product.equals(pack.product) && Objects.equals(provider, pack.provider) && Objects.equals(expDate, pack.expDate) && Objects.equals(loadDate, pack.loadDate);
   }

   @Override
   public int hashCode() {
      return Objects.hash(product, quantity, price, provider, expDate, loadDate);
   }
}
