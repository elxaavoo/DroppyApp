package es.ieslavereda.droppyapp.Model;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String poblation;
    private String address;
    private String image;
    private Type type;
    private String CP;
    private int phoneNumber;

    public User(String name, String email, String password, String poblation, String address, String image, Type type, String CP, int phoneNumber) {
        this.id = "user_" + UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
        this.poblation = poblation;
        this.address = address;
        this.image = image;
        this.type = type;
        this.CP = CP;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoblation() {
        return poblation;
    }

    public void setPoblation(String poblation) {
        this.poblation = poblation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Type getType() {
        return type;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
