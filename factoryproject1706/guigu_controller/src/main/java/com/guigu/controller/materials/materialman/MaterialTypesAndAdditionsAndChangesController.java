package com.guigu.controller.materials.materialman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.domain.materials.GoodsTypView;
import com.guigu.domain.materials.ReturnView;
import com.guigu.service.materials.IMaterialTypesChangesService;

import java.util.List;

/**
 * 物资类型增删改查
 */
@Controller
@RequestMapping("/materialType")
public class MaterialTypesAndAdditionsAndChangesController {
	@Autowired
	private IMaterialTypesChangesService iMaterialTypesChangesService;

	// 查询所有类型
	@RequestMapping("/queryTypeData")
	@ResponseBody
	public List<GoodsTypView> queryTypeData() {
		List<GoodsTypView> list = null;
		try {
			list = this.iMaterialTypesChangesService.queryParentMaterial();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 拖拽处理函数

	/**
	 * @param id
	 * @param targetId
	 * @param point
	 * @return 1.情况一：一个元素添加到另一个元素的里面 --> append 2.情况二：一个里面的元素与父元素同级 --> append
	 *         3.情况三:一个元素和他的顶层父元素同级， -->buttom 4.情况四：一个元素在他的顶层父类的上面（第一个） --> top
	 */
	@RequestMapping("/dropProcessingFunctions")
	public void dropProcessingFunctions(String id, String targetId, String point) {
		try {
			this.iMaterialTypesChangesService.dragAndDropTheParentTypeOfTheModifiedSubtype(id, targetId, point);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 更新处理函数
	@RequestMapping("/updateHandler")
	public void updateHandler(String id, String text) {
		try {
			this.iMaterialTypesChangesService.updateNode(id, text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 添加节点
	@RequestMapping("/addNode")
	@ResponseBody
	public ReturnView addNode(ReturnView returnView) {
		String choose = null;
		try {
			choose = this.iMaterialTypesChangesService.addNode(returnView);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (choose != null) {
			return new ReturnView(choose, returnView.getText(), returnView.getParentId());
		}
		return null;
	}

	/**
	 * 1.被禁用的节点禁止拖拽，如果父节点被禁用则全部子节点禁止被拖拽 2.被禁止的节点颜色渲染为红色
	 */
	// 禁用节点（修改状态）
	@RequestMapping("/modifyStatus")
	@ResponseBody
	public String modifyStatus(String id) {
		try {
			this.iMaterialTypesChangesService.modifyStatus(id, "1");
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}

	@RequestMapping("/startUsing")
	@ResponseBody
	public String startUsing(String id) {
		try {
			this.iMaterialTypesChangesService.modifyStatus(id, "0");
		} catch (Exception e) {
			e.printStackTrace();
			return "no";
		}
		return "yes";
	}
}
