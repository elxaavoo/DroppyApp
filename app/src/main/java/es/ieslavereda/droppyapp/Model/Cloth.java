package es.ieslavereda.droppyapp.Model;

import java.util.List;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Cloth {
    private String idCloth;
    private double price;
    private String name;
    private Size size;
    private List<Photo> images;
    private String description;
    private String idSeller;
    private Category category;
    private Brand brand;

    public Cloth(){}

    public Cloth(String name, double price, Size size, List<Photo> images, String description, String idSeller, Category category, Brand brand) {
        this.idCloth = Generator.generateClothId();
        this.price = price;
        this.name = name;
        this.size = size;
        this.images = images;
        this.description = description;
        this.idSeller = idSeller;
        this.category = category;
        this.brand = brand;
    }

    public String getIdCloth() {
        return idCloth;
    }

    public void setIdCloth(String idCloth) {
        this.idCloth = idCloth;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public List<Photo> getImages() {
        return images;
    }

    public void setImages(List<Photo> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdSeller() {
        return idSeller;
    }

    public void setIdSeller(String idSeller) {
        this.idSeller = idSeller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
