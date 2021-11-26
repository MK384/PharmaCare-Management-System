package DynamicArea;
import java.util.Date;


/**
 * this interface type holds all the plain info about a package of product.
 */

public class Pack {



   private Product product;
   private Integer quantity;
   private Integer price;
   private String provider;
   private Date expDate;
   private Date loadDate;


   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public Integer getPrice() {
      return price;
   }

   public void setPrice(Integer price) {
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
