package com.guigu.service.info;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.guigu.common.info.ReturnVo;
import com.guigu.domain.info.Returns;
import com.guigu.domain.info.Student;
import com.guigu.util.PageHelpVO;
/**
 * 复学业务处理接口
 * @author Administrator
 *
 */
public interface IReturnsService {
		//根据学号和身份证查询
		List<Student> SelStucid(String stuid,String stucid);
		//复学申请
		void InsertReturn(Returns returns);
		//点击复学申请查看复学记录根据id查看
		ReturnVo SertReturn(String return_id);
/*---------------------------------------------------------*/
		//根据休学id查看休学的信息分页(学生看的信息)
		PageHelpVO SReturnVo(String LEAVE_ID,Integer page,Integer rows);
		//（老师）查看休学信息
		PageHelpVO SReturnVos(String LEAVE_ID,Integer page,Integer rows);
		
}
