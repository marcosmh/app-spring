package com.std.springapp.librerias.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerData {

    public CustomerData() {

    }

    private String rfc;
    private String buc;

    @JsonProperty("producto")
    private String product;

    @JsonProperty("subproducto")
    private String subProduct;

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getBuc() {
        return buc;
    }

    public void setBuc(String buc) {
        this.buc = buc;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSubProduct() {
        return subProduct;
    }

    public void setSubProduct(String subProduct) {
        this.subProduct = subProduct;
    }

    @Override
    public String toString() {
        return "CustomerData{" +
                "rfc='" + rfc + '\'' +
                ", buc='" + buc + '\'' +
                ", product='" + product + '\'' +
                ", subProduct='" + subProduct + '\'' +
                '}';
    }
}
