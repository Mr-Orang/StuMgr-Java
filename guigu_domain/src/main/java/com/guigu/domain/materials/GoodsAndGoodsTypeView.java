package com.guigu.domain.materials;

public class GoodsAndGoodsTypeView {
    //物资id
    private String goodsId;
    //物资描述
    private String description;
    //类型名称
    private String typeName;
    //下限
    private int floorStore;
    //-------------------------------
    private String brand;
    //上限
    private double upStore;
    //库存数量
    private double goodsStock;

    public GoodsAndGoodsTypeView() {

    }

    public GoodsAndGoodsTypeView(String goodsId, String description, String typeName, int floorStore, String brand, double upStore, double goodsStock) {
        this.goodsId = goodsId;
        this.description = description;
        this.typeName = typeName;
        this.floorStore = floorStore;
        this.brand = brand;
        this.upStore = upStore;
        this.goodsStock = goodsStock;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getFloorStore() {
        return floorStore;
    }

    public void setFloorStore(int floorStore) {
        this.floorStore = floorStore;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getUpStore() {
        return upStore;
    }

    public void setUpStore(double upStore) {
        this.upStore = upStore;
    }

    public double getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(double goodsStock) {
        this.goodsStock = goodsStock;
    }
}
