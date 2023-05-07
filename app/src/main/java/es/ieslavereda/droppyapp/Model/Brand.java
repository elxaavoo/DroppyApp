package es.ieslavereda.droppyapp.Model;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Brand {

    private String idBrand;
    private String brandName;

    public Brand(){}

    public Brand(String brandName) {
        this.idBrand = Generator.generateBrandId();
        this.brandName = brandName;
    }

    public String getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(String idBrand) {
        this.idBrand = idBrand;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return brandName;
    }
}
