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
    private boolean available;
    private int stock;

    private String state;

    public Cloth(){}

    public Cloth(String name, double price, Size size, List<Photo> images, String description, String idSeller, Category category, Brand brand, int stock, String state) {
        this.idCloth = Generator.generateClothId();
        this.price = price;
        this.name = name;
        this.size = size;
        this.images = images;
        this.description = description;
        this.idSeller = idSeller;
        this.category = category;
        this.brand = brand;
        this.available = true;
        this.stock = stock;
        this.state = state;
    }

    public Cloth(String name, double price, Size size, List<Photo> images, String description, String idSeller, Category category, Brand brand, String state) {
        this.idCloth = Generator.generateClothId();
        this.price = price;
        this.name = name;
        this.size = size;
        this.images = images;
        this.description = description;
        this.idSeller = idSeller;
        this.category = category;
        this.brand = brand;
        this.available = true;
        this.stock = 1;
        this.state = state;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
