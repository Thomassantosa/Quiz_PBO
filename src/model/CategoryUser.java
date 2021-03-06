package model;

public class CategoryUser {
    private int idCategory;
    private String name;

    public CategoryUser() {
    }

    public CategoryUser(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public int getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
            " idCategory='" + getIdCategory() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }
}
