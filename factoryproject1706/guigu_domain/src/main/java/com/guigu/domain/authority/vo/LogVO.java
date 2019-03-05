package com.guigu.domain.authority.vo;

public class LogVO {

	/*
	 * 操作日志实体类
	 */
	
	//日志编号
	private String log_Id;
	//请求Url
	private String request_Url;
	//员工编号
	private String te_Id;
	//操作时间
	private String operation_Date;
	//权限编号
	private String ra_Id;
	
	//有参构造方法
	public LogVO(String log_Id, String request_Url, String te_Id, String operation_Date, String ra_Id) {
		super();
		this.log_Id = log_Id;
		this.request_Url = request_Url;
		this.te_Id = te_Id;
		this.operation_Date = operation_Date;
		this.ra_Id = ra_Id;
	}

	//无参构造方法
	public LogVO() {
		super();
	}

	//实体类的get和set方法
	public String getLog_Id() {
		return log_Id;
	}

	public void setLog_Id(String log_Id) {
		this.log_Id = log_Id;
	}

	public String getRequest_Url() {
		return request_Url;
	}

	public void setRequest_Url(String request_Url) {
		this.request_Url = request_Url;
	}

	public String getTe_Id() {
		return te_Id;
	}

	public void setTe_Id(String te_Id) {
		this.te_Id = te_Id;
	}

	public String getOperation_Date() {
		return operation_Date;
	}

	public void setOperation_Date(String operation_Date) {
		this.operation_Date = operation_Date;
	}

	public String getRa_Id() {
		return ra_Id;
	}

	public void setRa_Id(String ra_Id) {
		this.ra_Id = ra_Id;
	}
	
	
}
