package com.guigu.domain.materials;

import java.util.List;
import java.util.Map;

public class DataGrid {
    private int page = 1;// 当前页
    private List<Map<String, Object>> rows;// 结果集
    private int pageSize = 10;//每页显示的数据的条数
    private int total;// 总记录数

    public DataGrid() {

    }

    public DataGrid(int page, List<Map<String, Object>> rows, int pageSize, int total) {
        this.page = page;
        this.rows = rows;
        this.pageSize = pageSize;
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
