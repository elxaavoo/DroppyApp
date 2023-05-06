package es.ieslavereda.droppyapp.Model;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Discount {

    private String idDiscount;
    private boolean state;
    private String code;
    private String idInfluencer;
    private double discount;

    public Discount() {}

    public Discount(boolean state, String code, String idInfluencer, double discount) {
        this.idDiscount = Generator.generateDiscountId();
        this.state = state;
        this.code = code;
        this.idInfluencer = idInfluencer;
        this.discount = discount;
    }

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdInfluencer() {
        return idInfluencer;
    }

    public void setIdInfluencer(String idInfluencer) {
        this.idInfluencer = idInfluencer;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
