package com.guigu.service.materials.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guigu.common.materials.PageInfo;
import com.guigu.dao.materials.PickingManageMapper;
import com.guigu.domain.materials.Goods;
import com.guigu.domain.materials.Use;
import com.guigu.domain.materials.UseAndEmpView;
import com.guigu.domain.materials.UseDetail;
import com.guigu.service.materials.IPickingManageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 领取实现类
 */
@Service
public class PickingManageImpl implements IPickingManageService {
	@Autowired
	private PickingManageMapper pickingManageMapper;

	@Override
	public List<Use> queryIPickingMan(String EmpId) throws Exception {
		return this.pickingManageMapper.queryPickingManage(EmpId);
	}

	@Override
	public PageInfo queryPickupDetails(String id, int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pageInfo1 = PageHelper.startPage(page, rows).doSelectPageInfo(() -> {
			try {
				this.pickingManageMapper.queryGoodsDetail(id);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public PageInfo queryGoods(int currentPage, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pageInfo1 = PageHelper.startPage(currentPage, pageSize, true)
				.doSelectPageInfo(() -> {
					try {
						this.pickingManageMapper.quertGoods();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public boolean insertMateriData(Use use, List<UseDetail> useDetailList) throws Exception {
		try {
			// 执行插入操作
			this.pickingManageMapper.insertUse(use);
			for (UseDetail useDetail : useDetailList) {
				useDetail.setUseId(use.getUseId());
			}
			// 插入明细表
			this.pickingManageMapper.insertUseDetail(useDetailList);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 查询还没有进行审批的申请订单
	 *
	 * @return
	 */
	@Override
	public PageInfo queryUseANdEmp(int currentPage, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<UseAndEmpView> pageInfo1 = PageHelper.startPage(currentPage, pageSize, true)
				.doSelectPageInfo(() -> {
					try {
						this.pickingManageMapper.queryUserAndEmp();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public boolean updateUse(Use use) throws Exception {
		try {
			this.pickingManageMapper.updateUse(use);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PageInfo queryApplicationInquiry(String id, int page, int rows) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Goods> pageInfo1 = PageHelper.startPage(page, rows)
				.doSelectPageInfo(() -> {
					try {
						this.pickingManageMapper.queryapplyForGoods(id);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public PageInfo queryApplicationInformation(int currentPage, int pageSize, String empId) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Use> pageInfo1 = PageHelper.startPage(currentPage, pageSize)
				.doSelectPageInfo(() -> {
					try {
						this.pickingManageMapper.queryUse(empId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}

	@Override
	public PageInfo queryHistoryApprovalRecords(int currentPage, int pageSize) throws Exception {
		PageInfo pageInfo = new PageInfo();
		com.github.pagehelper.PageInfo<Use> pageInfo1 = PageHelper.startPage(currentPage, pageSize)
				.doSelectPageInfo(() -> {
					try {
						this.pickingManageMapper.queryUsesgo();
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
		pageInfo.setRows(pageInfo1.getList());
		pageInfo.setTotal(pageInfo1.getTotal());
		return pageInfo;
	}
}
