package com.guigu.controller.marketing;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guigu.common.marketing.BoardHelp;
import com.guigu.common.marketing.BoardNotView;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormType;
import com.guigu.domain.marketing.Migrate;
import com.guigu.service.marketing.IDormService;
import com.guigu.util.PageHelpVO;

@RestController
@RequestMapping("/marketing/dorm")
public class DormController {
	@Autowired
	private IDormService dormServiceImpl;

	@RequestMapping("/queryBoard")
	public PageHelpVO queryBoard(BoardHelp boardHelp, Integer page, Integer rows) {
		try {
			return this.dormServiceImpl.queryBoard(boardHelp, page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryClass")
	public List<Classes> queryClass() {
		try {
			return this.dormServiceImpl.queryClass();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryMigrate")
	public List<Migrate> queryMigrate() {
		try {
			return this.dormServiceImpl.queryMigrate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryAbleChangeDorm")
	public List<Dorm> queryAbleChangeDorm(String classID, String tdmID, String sex) {
		try {
			return this.dormServiceImpl.queryAbleChangeDorm(classID, tdmID, sex);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryDorm")
	public List<Dorm> queryDorm() {
		try {
			return this.dormServiceImpl.queryDorm();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryBoardNoOK")
	public PageHelpVO queryBoardNoOK(String classID, String sex, Integer page, Integer rows) {
		try {
			return this.dormServiceImpl.queryBoardNoOK(classID, sex, page, rows);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/addBoard")
	public String addBoard(String[] stuIDs, String tdmID) {
		try {
			this.dormServiceImpl.addBoard(stuIDs, tdmID);
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@RequestMapping("/queryNotBoardClass")
	public List<Classes> queryNotBoardClass(HttpServletRequest request) {
		try {
			return this.dormServiceImpl.queryNotBoardClass(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping("/queryDormType")
	public List<DormType> queryDormType() {
		try {
			return this.dormServiceImpl.queryDormType();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/queryDormAbleNumber")
	public int queryDormAbleNumber(String tdm_id){
		try {
			return this.dormServiceImpl.queryDormAbleNumber(tdm_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("/queryClassByEmpID")
	public List<Classes> queryClassByEmpID(HttpServletRequest request){
		try {
			return this.dormServiceImpl.queryClassByEmpID(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	@RequestMapping("/queryDormByEmpID")
	public List<Dorm> queryDormByEmpID(HttpServletRequest request){
		try {
			return this.dormServiceImpl.queryDormByEmpID(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("/queryHaveApplyByStuID")
	public int queryHaveApplyByStuID(String stuID){
		try {
			return this.dormServiceImpl.queryHaveApplyByStuID(stuID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("/queryDormIDByStuID")
	public String queryDormIDByStuID(String stuID){
		try {
			return this.dormServiceImpl.queryDormIDByStuID(stuID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
