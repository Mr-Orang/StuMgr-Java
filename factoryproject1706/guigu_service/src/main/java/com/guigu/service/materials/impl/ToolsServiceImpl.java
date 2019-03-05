package com.guigu.service.materials.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guigu.dao.materials.ToolsMapper;
import com.guigu.domain.materials.GoodsType;
import com.guigu.domain.materials.TableNameView;
import com.guigu.service.materials.DataTrackingView;
import com.guigu.service.materials.IToolsService;

import java.util.List;

/**
 * 工具服务实现类
 */
@Service
public class ToolsServiceImpl implements IToolsService {
	@Autowired
	private ToolsMapper toolsMapper;

	@Override
	public String[] queryTypeName() throws Exception {
		List<GoodsType> goodsType = this.toolsMapper.queryGoodsType();
		String[] str = new String[goodsType.size()];
		for (int i = 0; i < goodsType.size(); i++) {
			str[i] = goodsType.get(i).getTypeId().substring(7) + "-" + goodsType.get(i).getTypeName();
		}
		return str;
	}

	@Override
	public List<TableNameView> queryTableName() throws Exception {
		List<TableNameView> list = this.toolsMapper.queryTableName();
		// 错误 java.util.ConcurrentModificationException 跌倒时不允许被修改！！！
//        for (TableNameView tableNameView : list) {
//            //修改类型
//            if (tableNameView.getTableName().equals("TYPEID")) {
//                tableNameView.setTableName("GOODSTYPE");
//            }
//            //删除主键字段
//            if (tableNameView.getTableName().equals("GOODSID")) {
//                list.remove(tableNameView);
//            }
//        }
		for (int i = 0; i < list.size(); i++) {
			// 修改类型
			if (list.get(i).getTableName().equals("TYPEID")) {
				list.get(i).setTableName("GOODSTYPE");
			}
			// 删除主键字段
			if (list.get(i).getTableName().equals("GOODSID")) {
				list.remove(list.get(i));
			}
			// 删除状态
			if (list.get(i).getTableName().equals("STATUS")) {
				list.remove(list.get(i));
			}
			// 库存
			if (list.get(i).getTableName().equals("GOODSTOCK")) {
				list.remove(list.get(i));
			}
		}
		return list;
	}

	// 验证字符串是否存在
	@Override
	public String queryMaIfGo(String info) throws Exception {
		return this.toolsMapper.checkGo(info);
	}

	// 批量插入数据表格
	@Override
	public void insertTableData(DataTrackingView dataTrackingView) throws Exception {
		// 解析类型id
		for (int i = 0; i < dataTrackingView.getNormalDataCollection().size(); i++) {
			String[] strings = dataTrackingView.getNormalDataCollection().get(i).getTypeName().split("-");
			dataTrackingView.getNormalDataCollection().get(i).setTypeId("typeId_" + strings[0].trim());
		}
		if (dataTrackingView.getNormalDataCollection().size() == 0) {
			return;
		}
		this.toolsMapper.insertData(dataTrackingView.getNormalDataCollection());
	}
}
