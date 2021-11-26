package DynamicArea;

public class MedicalEquipment extends Product{
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
