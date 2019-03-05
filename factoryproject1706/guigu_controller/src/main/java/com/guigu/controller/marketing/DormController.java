package com.guigu.controller.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.marketing.BoardHelp;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.Migrate;
import com.guigu.service.marketing.IDormService;
import com.guigu.util.PageHelpVO;

@RestController
@RequestMapping("/marketing/dorm")
public class DormController {
	@Autowired
	private IDormService dormServiceImpl;
	
	@RequestMapping("/queryBoard")
	public PageHelpVO queryBoard(BoardHelp boardHelp,Integer page,Integer rows){
		try {
			return this.dormServiceImpl.queryBoard(boardHelp, page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/queryClass")
	public List<Classes> queryClass(){
		try {
			return this.dormServiceImpl.queryClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/queryMigrate")
	public List<Migrate> queryMigrate(){
		try {
			return this.dormServiceImpl.queryMigrate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/queryAbleChangeDorm")
	public List<Dorm> queryAbleChangeDorm(String classID, String tdmID){
		try {
			return this.dormServiceImpl.queryAbleChangeDorm(classID, tdmID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/queryDorm")
	public List<Dorm> queryDorm(){
		try {
			return this.dormServiceImpl.queryDorm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
