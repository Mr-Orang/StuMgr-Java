package com.guigu.controller.materials.businessman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.materials.PageInfo;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.Provider;
import com.guigu.service.materials.ISupplyOfMaterials;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 供应商可供物资处理类
 */
@Controller
@RequestMapping("/supplyOfMaterialsController")
public class SupplyOfMaterialsController {
	@Autowired
	private ISupplyOfMaterials iSupplyOfMaterials;

	// 加载当前供应商可供物资列表
	@RequestMapping("/queryGoodsMaterials")
	@ResponseBody
	public PageInfo queryGoodsMaterials(HttpServletRequest request, int page, int rows) {
		// 获取当前供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		PageInfo pageInfo = null;
		try {
			pageInfo = this.iSupplyOfMaterials.queryGoodsMaterials(provider.getProviderId(), page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	// 查询所有可以供应的物资，不包括禁用的物资
	@RequestMapping("/queryMaterials")
	@ResponseBody
	public PageInfo queryMaterials(int page, int rows, HttpServletRequest request) {
		// 获取当前供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		PageInfo pageInfo = null;
		try {
			pageInfo = this.iSupplyOfMaterials.queryMaterial(page, rows, provider.getProviderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageInfo;
	}

	// 异步判断该供应商是否已经添加了该物资
	@RequestMapping("/queryIsAdd")
	@ResponseBody
	public String queryIsAdd(String id, HttpServletRequest request) {
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		boolean boo = false;
		try {
			boo = this.iSupplyOfMaterials.queryIsAdd(id, provider.getProviderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	// 添加供应物资
	@RequestMapping("/addSupplies")
	@ResponseBody
	public String addSupplies(String[] idArrayMatro, HttpServletRequest request) {
		// 获取当前供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		// 封装物资id
		List<Goods> goodsList = new ArrayList<Goods>();
		for (int i = 0; i < idArrayMatro.length; i++) {
			Goods goods1 = new Goods();
			goods1.setGoodsId(idArrayMatro[i]);
			goods1.setBrand(provider.getProviderId());
			goodsList.add(goods1);
		}
		boolean boo = false;
		try {
			boo = this.iSupplyOfMaterials.addSupplies(goodsList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}

	// 移除可供应的物资
	@RequestMapping("/removalOfSuppliesAvailable")
	@ResponseBody
	public String removalOfSuppliesAvailable(String id, HttpServletRequest request) {
		// 获取供应商信息
		Provider provider = (Provider) request.getSession().getAttribute("provider");
		boolean boo = false;
		try {
			boo = this.iSupplyOfMaterials.removalOfSuppliesAvailable(id, provider.getProviderId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (boo) {
			return "yes";
		}
		return "no";
	}
}
