package com.guigu.service.materials;

import java.util.List;

import com.guigu.domain.materials.Goods;

/**
 * 数据追踪
 */
public class DataTrackingView {
    //总导入条数
    private int totalNumberOfImportedBars;
    //重复数据集合
    private List<Goods> duplicateDataCollection;
    //正常数据集合
    private List<Goods> normalDataCollection;

    public DataTrackingView() {

    }

    public DataTrackingView(int totalNumberOfImportedBars, List<Goods> duplicateDataCollection, List<Goods> normalDataCollection) {
        this.totalNumberOfImportedBars = totalNumberOfImportedBars;
        this.duplicateDataCollection = duplicateDataCollection;
        this.normalDataCollection = normalDataCollection;
    }

    public int getTotalNumberOfImportedBars() {
        return totalNumberOfImportedBars;
    }

    public void setTotalNumberOfImportedBars(int totalNumberOfImportedBars) {
        this.totalNumberOfImportedBars = totalNumberOfImportedBars;
    }

    public List<Goods> getDuplicateDataCollection() {
        return duplicateDataCollection;
    }

    public void setDuplicateDataCollection(List<Goods> duplicateDataCollection) {
        this.duplicateDataCollection = duplicateDataCollection;
    }

    public List<Goods> getNormalDataCollection() {
        return normalDataCollection;
    }

    public void setNormalDataCollection(List<Goods> normalDataCollection) {
        this.normalDataCollection = normalDataCollection;
    }
}
