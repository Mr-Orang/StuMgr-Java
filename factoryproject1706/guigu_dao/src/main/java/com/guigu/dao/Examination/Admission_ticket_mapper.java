package com.guigu.dao.Examination;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.guigu.domain.Examination.Admission_ticket_dom;

@Mapper
public interface Admission_ticket_mapper {



	

	/**
	 * 查询准考证是否存在
	 * @param adm_id
	 * @param stu_cid
	 * @param admission_ticket_dom
	 * @return
	 */
	Object queryAdmission(@Param("adm_id") String adm_id,@Param("stu_cid")String stu_cid);
}
