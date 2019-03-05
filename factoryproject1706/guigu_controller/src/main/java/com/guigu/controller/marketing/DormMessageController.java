package com.guigu.controller.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 宿舍信息controller类
 * @author lijianghua
 *
 */

import com.guigu.common.marketing.DormMessage;
import com.guigu.common.marketing.StudentConsult;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormFloor;
import com.guigu.service.marketing.DormMessageService;
import com.guigu.util.PageHelpVO;
@RestController
public class DormMessageController {
	@Autowired
	private DormMessageService dormMessageService;
	

	/**
	 * 查询宿舍信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/quereyDormMessages")
	PageHelpVO quereyDormMessages(DormMessage dorm,int page, int rows){
		PageHelpVO pageinfo = null;
		try {
			pageinfo = this.dormMessageService.quereyDormMessages(dorm, page, rows);
			System.out.println("pageinfo:"+pageinfo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
		
	}
	
	/**
	 * 查询宿舍楼层信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryDromFloor")
	List<DormFloor> queryDromFloor(){
		List<DormFloor> list=null;
		try {
			list=this.dormMessageService.queryDromFloor();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * 添加宿舍信息
	 * @param dorm
	 * @throws Exception
	 */
	@RequestMapping("/addDormMessages")
	String addDormMessages(Dorm dorm) {
		String str="no";
		try {
			this.dormMessageService.addDormMessages(dorm);
			str="ok";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return str;
	}
	
	
	/**
	 * 查询宿舍床位
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryDromFloorBeD")
	List<DormFloor> queryDromFloorBeD(){
		List<DormFloor> list=null;
		try {
			list=this.dormMessageService.queryDromFloorBeD();
			System.out.println("list"+list.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
}
