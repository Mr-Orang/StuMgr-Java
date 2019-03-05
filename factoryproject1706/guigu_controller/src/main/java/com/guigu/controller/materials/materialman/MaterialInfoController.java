package com.guigu.controller.materials.materialman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.GoodsType;
import com.guigu.service.materials.ImaterialInfoService;

import java.util.List;

/**
 * 物资信息管理
 * 
 * @author ExcellentLiuYang
 *
 */
@Controller
@RequestMapping("/materialInfo")
public class MaterialInfoController {
	@Autowired
	private ImaterialInfoService imaterialInfoService;

	// 物资详细信息分页
	@RequestMapping("/queryMaterialInfo")
	public @ResponseBody PageInfo queryMaterialInfo(String page, String rows) {
		int currentPage = 1;
		int pageSize = 5;
		try {
			currentPage = Integer.parseInt(page);
			pageSize = Integer.parseInt(rows);
		} catch (NumberFormatException e) {
			currentPage = 1;
			pageSize = 5;
		}
		PageInfo pageInfo = null;
		try {
			pageInfo = this.imaterialInfoService.querymaterial(currentPage, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	// 查询物资类型
	@RequestMapping("/queryGoodsType")
	public @ResponseBody List<GoodsType> queryGoodsType() {
		List<GoodsType> goodsType = null;
		try {
			goodsType = this.imaterialInfoService.queryGoodsType();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goodsType;
	}

	// 查询具体的物资信息
	@RequestMapping("/queryMJ")
	public @ResponseBody Goods queryGoods(String id) {
		Goods goods = null;
		try {
			goods = this.imaterialInfoService.queryGoods(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return goods;
	}

	// 保存修改的物资
	@RequestMapping("/updateMJ")
	public @ResponseBody String updateGood(Goods goods) {
		try {
			this.imaterialInfoService.updateGoods(goods);
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}

	// 下架物资
	@RequestMapping("/removeGoods")
	public @ResponseBody String removeGoods(String id) {
		try {
			this.imaterialInfoService.updateGoodsId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}

	// 上架物资
	@RequestMapping("/addGoods")
	public @ResponseBody String addGoods(String id) {
		try {
			this.imaterialInfoService.addGoodsId(id);
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}

	// 添加物资
	@RequestMapping("/addGoodsGogs")
	public @ResponseBody String addGoodsa(Goods goods) {
		try {
			this.imaterialInfoService.addgs(goods);
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}
}
