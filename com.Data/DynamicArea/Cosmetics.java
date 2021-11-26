package DynamicArea;

public class Cosmetics extends Product{
        private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setID(int id) {
        this.ID = id;
    }

    @Override
    public int getID() {
        return this.ID;
    }
}
