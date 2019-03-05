package com.guigu.domain.materials;

/**
 * 物资和报价实体类
 */
public class MaterialAndQuotation {
    private String providerId;
    private String proName;
    private double price;

    public MaterialAndQuotation() {

    }

    public MaterialAndQuotation(String providerId, String proName, double price) {
        this.providerId = providerId;
        this.proName = proName;
        this.price = price;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
