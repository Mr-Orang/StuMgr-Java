package com.guigu.controller.materials.purchasingman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.TemplateEngine;

import com.guigu.common.materials.PageInfo;
import com.guigu.common.materials.tools.email.SimpleMailSendTools;
import com.guigu.domain.marketing.Employee;
import com.guigu.domain.materials.DataGrid;
import com.guigu.domain.materials.Protocal;
import com.guigu.domain.materials.Provider;
import com.guigu.service.materials.IMailService;
import com.guigu.service.materials.IPurchaseContractManagementService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 合同审核处理类
 */
@Controller
@RequestMapping("/purchaseContractManagementController")
public class PurchaseContractManagementController {
	@Autowired
	private IPurchaseContractManagementService iPurchaseContractManagementService;

	@Autowired
	private IMailService imailService;

	@Autowired
	private TemplateEngine templateEngine;

	@Value("${spring.mail.username}")
	private String from;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private SimpleMailSendTools simpleMailSendTools;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 合同审批处理
	 */
	@RequestMapping("/queryProtocal")
	public @ResponseBody PageInfo queryProtocal(int page, int rows) {
		PageInfo pageinfo = null;
		try {
			pageinfo = this.iPurchaseContractManagementService.queryProtocal(page, rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageinfo;
	}

	/**
	 * 查询该合同的供应商和总金额
	 */
	@RequestMapping("/queryTheSupplierAndTotalAmountOfTheContract")
	public @ResponseBody DataGrid queryTheSupplierAndTotalAmountOfTheContract(String protdId) {
		DataGrid dataGrid = new DataGrid();
		List<Map<String, Object>> list = null;
		try {
			list = this.iPurchaseContractManagementService.queryTheSupplierAndTotalAmountOfTheContract(protdId);
			dataGrid.setRows(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataGrid;
	}

	/**
	 * 处理合同审批结果 protId 合同编号
	 */
	@RequestMapping("/handleContractApprovalResults")
	public @ResponseBody String handleContractApprovalResults(String protId, String ApprovalResults,
			String Disagreewiththereason, HttpServletRequest request) {
		// 获取当前登录的供应商信息
		Employee emplyee = (Employee) request.getSession().getAttribute("emplyee");
		Protocal protocal = null;
		// 判断审批结果
		if ("0".equals(ApprovalResults)) {
			// 同意合同
			protocal = new Protocal(protId, null, "2", null, emplyee.getTe_id(), null, 0);
			// 发送邮件
			try {
				List<Provider> providers = this.iPurchaseContractManagementService.ApprovalContract(protocal);
				for (Provider providers2 : providers) {
					MimeMessage message = mailSender.createMimeMessage();
					try {
						MimeMessageHelper helper = new MimeMessageHelper(message, true);
						helper.setFrom(from);
						helper.setSubject("硅谷云科技采购合同签约成功通知");
						helper.setTo(providers2.getEmail());
						helper.setText(
								this.simpleMailSendTools.template(providers2.getContractNO(), providers2.getProName()),
								true);
						mailSender.send(message);
						logger.info("采购合同通知已经发送邮箱");
					} catch (MessagingException e) {
						logger.info("采购合同通知发送邮箱异常");
						e.printStackTrace();
					}
				}
				return "yes";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if ("1".equals(ApprovalResults)) {
			// 不同意
			protocal = new Protocal(protId, null, "1", null, emplyee.getTe_id(), Disagreewiththereason, 0);
			return "yes";
		}
		return null;
	}
}
