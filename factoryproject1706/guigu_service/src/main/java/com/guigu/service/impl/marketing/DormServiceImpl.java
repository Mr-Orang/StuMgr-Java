package com.guigu.service.impl.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.marketing.BoardHelp;
import com.guigu.dao.marketing.DormMapper;
import com.guigu.domain.marketing.Classes;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.Migrate;
import com.guigu.service.marketing.IDormService;
import com.guigu.util.PageHelpVO;
/**
 * 宿舍业务接口实现类
 * @author maomao
 *
 */
@Service
public class DormServiceImpl implements IDormService {
	@Autowired
	private DormMapper dormMapper;
	
	@Override
	public PageHelpVO queryBoard(BoardHelp boardHelp, Integer page, Integer rows) throws Exception {
		PageHelpVO hp = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		hp.setRows(this.dormMapper.queryBoard(boardHelp));
		hp.setTotal(p.getTotal());
		return hp;
	}

	@Override
	public List<Classes> queryClass() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryClass();
	}

	@Override
	public List<Migrate> queryMigrate() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryMigrate();
	}

	@Override
	public List<Dorm> queryAbleChangeDorm(String classID, String tdmID) throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryAbleChangeDorm(classID, tdmID);
	}

	@Override
	public List<Dorm> queryDorm() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMapper.queryDorm();
	}

}
