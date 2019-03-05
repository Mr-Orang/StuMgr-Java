package com.guigu.service.materials;

import java.util.List;

import com.guigu.domain.materials.TableNameView;

/**
 * 工具服务类
 */
public interface IToolsService {
    //查询可选类型
    String[] queryTypeName() throws Exception;

    //查询表中字段
    List<TableNameView> queryTableName()  throws Exception;

    //验证物资是否存在(品牌，规格，说明)
    String queryMaIfGo(String info)  throws Exception;

    //批处理表格数据
    void insertTableData(DataTrackingView dataTrackingView) throws Exception;
}
