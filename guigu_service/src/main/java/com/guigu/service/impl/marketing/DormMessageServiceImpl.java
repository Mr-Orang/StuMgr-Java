package com.guigu.service.impl.marketing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.marketing.DormMessage;
import com.guigu.dao.marketing.DormMessageMapper;
import com.guigu.domain.marketing.Dorm;
import com.guigu.domain.marketing.DormFloor;
import com.guigu.service.marketing.DormMessageService;
import com.guigu.util.PageHelpVO;
/**
 * 宿舍信息service实现类
 * @author lijianghua
 *
 */
@Service
public class DormMessageServiceImpl implements DormMessageService{
	@Autowired
	private DormMessageMapper dormMeaageMapper;

	@Override
	public PageHelpVO quereyDormMessages(DormMessage dorm, int page, int rows) throws Exception {
		// TODO Auto-generated method stub
		PageHelpVO hp = new PageHelpVO();
		Page p = PageHelper.startPage(page, rows, true);
		hp.setRows(this.dormMeaageMapper.quereyDormMessages(dorm));
		hp.setTotal(p.getTotal());
		return hp;
	}

	@Override
	public List<DormFloor> queryDromFloor() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMeaageMapper.queryDromFloor();
	}

	@Override
	public void addDormMessages(Dorm dorm) throws Exception {
		// TODO Auto-generated method stub
		this.dormMeaageMapper.addDormMessages(dorm);
	}

	@Override
	public List<DormFloor> queryDromFloorBeD() throws Exception {
		// TODO Auto-generated method stub
		return this.dormMeaageMapper.queryDromFloorBeD();
	}
	
	

}
