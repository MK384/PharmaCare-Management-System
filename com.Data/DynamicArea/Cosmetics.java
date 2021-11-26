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
    public void setID(Integer id) {
        this.ID = id;
    }

    @Override
    public Integer getID() {
        return this.ID;
    }
}
