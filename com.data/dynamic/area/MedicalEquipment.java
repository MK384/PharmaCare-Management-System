package dynamic.area;

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
    public void setID(int id) {
        this.ID = id;
    }

    @Override
    public int getID() {
        return this.ID;
    }
}
