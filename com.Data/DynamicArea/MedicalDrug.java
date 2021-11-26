package DynamicArea;

public class MedicalDrug extends Product{
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
