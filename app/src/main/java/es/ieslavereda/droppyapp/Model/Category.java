package es.ieslavereda.droppyapp.Model;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Category {

    private String idCategory;
    private String name;
    private String description;

    public Category(){}

    public Category(String name, String description) {
        this.idCategory = Generator.generateCategoryId();
        this.name = name;
        this.description = description;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
