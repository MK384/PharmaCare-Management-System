package DynamicArea;


public abstract class Product {
    protected String name;
    protected Integer ID;
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setID(Integer id);
    public abstract Integer getID();
}
