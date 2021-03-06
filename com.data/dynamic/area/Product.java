package dynamic.area;


import java.io.Serializable;
import java.util.Objects;

public  class Product implements Serializable {

    protected String name;
    protected int ID;
    protected double price;
    protected String partPlace;

    public void setPartPlace(String partPlace) {
        this.partPlace = partPlace;
    }

    public String getPartPlace() {
        return partPlace;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
        name = null;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return ID == product.ID || name.equals(product.name);
    }

    @Override
    public int hashCode() {
            return Objects.hash(ID);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
