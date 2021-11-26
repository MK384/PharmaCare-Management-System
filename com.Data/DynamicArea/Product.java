package DynamicArea;

/**
 * this POJO class type holds the basic info about any item in the inventory.
 */
public abstract class Product {

    protected String name;
    protected Integer ID;

    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setID(Integer id);
    public abstract Integer getID();
}
