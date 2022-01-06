package dynamic.area;


import java.io.Serializable;
import java.util.Objects;

public  class Product implements Serializable {

    protected String name;
    protected int ID;
    protected int price;


    public Product() {
        name = null;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getPrice() {
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
         if (name == null && ID != 0)
            return Objects.hash(ID);
        else if (name != null && ID == 0)
            return Objects.hash(name);
        else return Objects.hash(name, ID);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
