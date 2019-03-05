package com.guigu.service.eduoffice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.domain.authority.vo.MenuVO;
import com.guigu.domain.eduoffice.LayUiPageInfo;
import com.guigu.domain.marketing.PageInfo;
/**
 * 授课业务接口
 * @author FIVFI
 *
 */
public interface CuedMenuService {
	/**
	 * 授课管理系统的菜单系统
	 * @return
	 */
	List<MenuVO> queryMenu_cued(String roleId,String modelId);
}
