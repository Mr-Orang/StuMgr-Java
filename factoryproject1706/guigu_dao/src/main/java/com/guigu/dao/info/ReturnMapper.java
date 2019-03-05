package com.guigu.dao.info;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.common.info.ReturnVo;
import com.guigu.domain.info.Returns;
import com.guigu.domain.info.Student;

/**
 * 复学模块
 * @author Administrator
 *
 */
public interface ReturnMapper {
	/**
	 * 根据学号和身份证查看是否休学
	 * @param stuid 学号
	 * @param stucid 身份证
	 */
	List<Student> SelStucid(@Param("stuid")String stuid,@Param("stucid")String stucid);
	//复学申请查看
	void InsertReturn(Returns returns);
	//点击复学申请查看复学记录根据id查看
	ReturnVo SertReturn(String leave_id);
	//根据休学id查看休学申请(老师看的信息)
	List<ReturnVo> SReturnVos(String leave_id);
	//根据休学id查看休学的信息(学生看的信息)
	List<ReturnVo> SReturnVo(String leave_id);
}
