package com.guigu.dao.eduoffice;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.guigu.domain.authority.vo.MenuVO;
import com.guigu.domain.eduoffice.EmpCourse;
/**
 * 授课菜单问接口
 * @author FIVFI
 *
 */
public interface CuedMenuMapper {
	/**
	 * 授课管理系统的菜单系统
	 * @return
	 */
	List<MenuVO> queryMenu_cued(@Param("roleId") String roleId,@Param("modelId") String modelId );
}
