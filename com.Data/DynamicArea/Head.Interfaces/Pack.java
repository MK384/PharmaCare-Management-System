package DynamicArea.Head.Interfaces;

import DynamicArea.Product;

import java.util.Date;

/**
 * this interface type holds all the plain info about a package of product.
 */
public interface Pack {

    /**
     * Getter Methods.
     */

    public Product getProduct();

    public int getQuantity();

    public Date getExpDate();

    public Date getLoadDate();

    public String getProvider();

    public double getPrice();


    /**
     * Setter Methods.
     */

    public void setProduct(Product product);

    public void setQuantity(int quantity);

    public void setExpDate(Date expDate);

    public void setLoadDate(Date loadDate);

    public void setProvider(String provider);

    public void setPrice(double price);


}
