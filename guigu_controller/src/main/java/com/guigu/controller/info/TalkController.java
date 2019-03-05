package com.guigu.controller.info;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guigu.common.info.ClassVo;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.info.Student;
import com.guigu.service.info.ITalkService;
import com.guigu.util.PageHelpVO;

@Controller
@RequestMapping("/talk")
public class TalkController {

	@Autowired
	private ITalkService italkService;
	
	/**
	 * 查询班级阶段和班级信息
	 * @param page
	 * @param rows
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querytalkclass.action")
	public @ResponseBody PageHelpVO Querytalkclass(Integer page,Integer rows){
		try {
			return this.italkService.Querytalkclass(page, rows);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 查询班级信息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryclass.action")
	public @ResponseBody List<ClassVo> Queryclass(){
		try {
			return this.italkService.Queryclass();
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 根据班级编号查询本班全部学生信息
	 * @param class_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryStudentInformation.action")
	public @ResponseBody List<Student> QueryStudentInformation(String class_id) {
		try {
			return this.italkService.QueryStudentInformation(class_id);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 保存谈话信息和详情信息
	 * @param account
	 * @param stu_id
	 * @param talk_content
	 * @param talk_type
	 * @return
	 */
	@RequestMapping("/saveStudentTalkInformation.action")
	public @ResponseBody String SaveStudentTalkInformation(String account,String stu_id,String talk_content,String talk_type){
		System.out.println(account);
		System.out.println(stu_id);
		System.out.println(talk_content);
		System.out.println(talk_type);
		String fag="0";
		try {
			this.italkService.SaveStudentTalkinformation(account, stu_id, talk_content, talk_type);
			fag="1";
		} catch (Exception e) {
			fag="2";
		}
		return fag;
	}
	
	/**
	 * 根据班级名称和班主任编号查询全部显示谈话信息
	 * @param page
	 * @param rows
	 * @param emp_id
	 * @param tc_name
	 * @return
	 */
	@RequestMapping("/queryClassStudentTalkdetail.action")
	public @ResponseBody PageHelpVO QueryClassStudentTalkdetail(Integer page,Integer rows,String emp_id,String tc_name){
		try {
			return this.italkService.QueryClassStudentTalkdetail(page, rows, emp_id, tc_name);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 查询学生个人谈话详情记录
	 * @param page
	 * @param rows
	 * @param stu_id
	 * @param emp_ids
	 * @return
	 */
	@RequestMapping("/queryStudentTalkrecord.action")
	public @ResponseBody PageHelpVO QueryStudentTalkrecord(Integer page,Integer rows,String stu_id,String emp_ids){
		try {
			return this.italkService.QueryStudentTalkrecord(page, rows, stu_id, emp_ids);
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/queryStudentTalk.action")
	public @ResponseBody LayUiPageInfo QueryStudentTalk(Integer page,Integer limit,String stu_id,String viewpoint){
		try {
			return this.italkService.QueryStudentTalk(page, limit, stu_id,viewpoint);
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping("/updateStudentAgreeTalk.action")
	public @ResponseBody String UpdateStudentAgreeTalk(String talk_details_id){
		String fag="0";
		try {
			this.italkService.UpdateStudentAgreeTalk(talk_details_id);
			fag="1";
			return fag;
		} catch (Exception e) {
			return fag;
		}
	}
	
	@RequestMapping("/updateStudentNoAgreeTalk.action")
	public @ResponseBody String UpdateStudentNoAgreeTalk(String talk_details_id,String reason){
		//System.out.println(talk_details_id+","+reason);
		String fag="0";
		try {
			this.italkService.UpdateStudentNoAgreeTalk(talk_details_id,reason);
			fag="1";
			return fag;
		} catch (Exception e) {
			return fag;
		}
	}
}
