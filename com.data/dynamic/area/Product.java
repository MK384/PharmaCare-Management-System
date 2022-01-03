package dynamic.area;


import java.util.Objects;

public abstract class Product {
    protected String name;
    protected int ID;
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setID(int id);
    public abstract int getID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return ID == product.ID && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ID);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                '}';
    }
}
