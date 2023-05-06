package es.ieslavereda.droppyapp.Model;

import java.util.List;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Basket {

    private String idBasket;
    private List<Cloth> clothes;
    private List<Drop> drops;
    private String idBuyUser;

    public Basket(){}

    public Basket(List<Cloth> clothes, List<Drop> drops, String idBuyUser) {
        this.idBasket = Generator.generateBasketId();
        this.clothes = clothes;
        this.drops = drops;
        this.idBuyUser = idBuyUser;
    }

    public String getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(String idBasket) {
        this.idBasket = idBasket;
    }

    public List<Cloth> getClothes() {
        return clothes;
    }

    public void setClothes(List<Cloth> clothes) {
        this.clothes = clothes;
    }

    public List<Drop> getDrops() {
        return drops;
    }

    public void setDrops(List<Drop> drops) {
        this.drops = drops;
    }

    public String getIdBuyUser() {
        return idBuyUser;
    }

    public void setIdBuyUser(String idBuyUser) {
        this.idBuyUser = idBuyUser;
    }
}
