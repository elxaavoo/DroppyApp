package es.ieslavereda.droppyapp.Model;

import java.util.List;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Drop {

    private String idDrop;
    private String idCreatorDrop;
    private double price;
    private List<Cloth> clothes;
    private String dropName;

    public Drop(){}

    public Drop(String idCreatorDrop, double price, List<Cloth> clothes, String dropName) {
        this.idDrop = Generator.generateDropId();
        this.idCreatorDrop = idCreatorDrop;
        this.price = price;
        this.clothes = clothes;
        this.dropName = dropName;
    }

    public String getIdDrop() {
        return idDrop;
    }

    public void setIdDrop(String idDrop) {
        this.idDrop = idDrop;
    }

    public String getIdCreatorDrop() {
        return idCreatorDrop;
    }

    public void setIdCreatorDrop(String idCreatorDrop) {
        this.idCreatorDrop = idCreatorDrop;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Cloth> getClothes() {
        return clothes;
    }

    public void setClothes(List<Cloth> clothes) {
        this.clothes = clothes;
    }

    public String getDropName() {
        return dropName;
    }

    public void setDropName(String dropName) {
        this.dropName = dropName;
    }
}
