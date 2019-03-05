package com.guigu.service.examination;

import com.guigu.domain.examination.Admission_ticket_dom;
import java.util.*;
/**
 * 准考号查询业务
 * @author Samsung
 *
 */
public interface Admission_ticket_service {
	/**
	 * 学生端准考证号登录
	 * @param 
	 */
	Object Enquiry_admission(String adm_id,String stu_cid);

	
}
