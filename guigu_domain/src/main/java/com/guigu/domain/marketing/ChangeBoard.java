package com.guigu.domain.marketing;

import java.io.Serializable;
import java.sql.Date;

/**
 * 宿舍更换详情实体类
 * @author maomao
 *
 */
public class ChangeBoard implements Serializable {
	private String tch_id;//	VARCHAR2	10	Not null		迁移编号，（主键）
	private String tch_stuid;//	VARCHAR2	10			学生编号，（t_student）
	private String tch_changeid;//	VARCHAR2	10			更换编号（t_changeboardApply）
	private String tch_formerboardid;//	VARCHAR2	10			原宿舍编号，
	private String tch_aimboardid;//	VARCHAR2	10			目标宿舍编号，
	private Date tch_date;//					迁出日期
	private Integer tm_id;//	Number	2			迁出类型（t_migrate）
	public ChangeBoard() {
		super();
	}
	public ChangeBoard(String tch_id, String tch_stuid, String tch_changeid, String tch_formerboardid,
			String tch_aimboardid, Date tch_date, Integer tm_id) {
		super();
		this.tch_id = tch_id;
		this.tch_stuid = tch_stuid;
		this.tch_changeid = tch_changeid;
		this.tch_formerboardid = tch_formerboardid;
		this.tch_aimboardid = tch_aimboardid;
		this.tch_date = tch_date;
		this.tm_id = tm_id;
	}
	public String getTch_id() {
		return tch_id;
	}
	public void setTch_id(String tch_id) {
		this.tch_id = tch_id;
	}
	public String getTch_stuid() {
		return tch_stuid;
	}
	public void setTch_stuid(String tch_stuid) {
		this.tch_stuid = tch_stuid;
	}
	public String getTch_changeid() {
		return tch_changeid;
	}
	public void setTch_changeid(String tch_changeid) {
		this.tch_changeid = tch_changeid;
	}
	public String getTch_formerboardid() {
		return tch_formerboardid;
	}
	public void setTch_formerboardid(String tch_formerboardid) {
		this.tch_formerboardid = tch_formerboardid;
	}
	public String getTch_aimboardid() {
		return tch_aimboardid;
	}
	public void setTch_aimboardid(String tch_aimboardid) {
		this.tch_aimboardid = tch_aimboardid;
	}
	public Date getTch_date() {
		return tch_date;
	}
	public void setTch_date(Date tch_date) {
		this.tch_date = tch_date;
	}
	public Integer getTm_id() {
		return tm_id;
	}
	public void setTm_id(Integer tm_id) {
		this.tm_id = tm_id;
	}
	
	
}
