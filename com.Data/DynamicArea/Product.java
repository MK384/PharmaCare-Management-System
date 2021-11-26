package DynamicArea;


public abstract class Product {
    protected String name;
    protected int ID;
    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setID(int id);
    public abstract int getID();
}
