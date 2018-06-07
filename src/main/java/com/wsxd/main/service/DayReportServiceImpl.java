package com.wsxd.main.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsxd.main.dao.DayReportMapper;
import com.wsxd.main.entity.DayReport;
import com.wsxd.main.entity.DayReportExample;
import com.wsxd.main.entity.ResultBean;
import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RestTemplateUtils;

@Service
public class DayReportServiceImpl implements DayReportService{
	@Autowired
	DayReportMapper drm;
	
	private String url=PropertyUtil.getProperty("url")+"day-report";
	
	private String trustcode=PropertyUtil.getProperty("trustcode");
	
	private static final Logger logger = LoggerFactory.getLogger(DayReportServiceImpl.class);
	
	/**
	 * 批量上报日结信息
	 */
	@Override
	public Map<String,ResultBean> reportDayReport(List<DayReport> drl) {
		// TODO Auto-generated method stub
		Map<String,ResultBean> resultmap=new HashMap<String, ResultBean>();
		ObjectMapper om=new ObjectMapper();
		om.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		
		for(DayReport dr:drl) {
			try {
				String drs=om.writeValueAsString(dr);
				ResultBean rb = RestTemplateUtils.post(url, drs);
				//上报成功后修改对应Flag
				if(rb.getResultCode().equals("0")){
					DayReportExample dre=new DayReportExample();
					//依据ID更新
					dre.createCriteria().andCheckDateEqualTo(dr.getCheckDate());

					DayReport dr2=new DayReport();
					dr2.setFlag(1);
					int su=drm.updateByExampleSelective(dr2, dre);
					logger.info("日结日期:{}上报成功! {}",dr.getCheckDate(),su);
				}else {
					logger.info("日结日期:{}上传失败! {}",dr.getCheckDate(),rb.getResultMsg());
				}
				//以主键为key，返回结果为result存入map
				resultmap.put(dr.getCheckDate(), rb);
				logger.info("DayReport: {}",dr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultmap;
	}
	
	
	/**
	 * 获取未上传的日结数据
	 */
	@Override
	public List<DayReport> getUnflagDayReportData() {
		
		DayReportExample dre=new DayReportExample();
		dre.createCriteria().andFlagIsNull();
		dre.or(dre.createCriteria().andFlagEqualTo(0));
		List<DayReport> drl=drm.selectByExample(dre);
		
		for(DayReport dr:drl) {
			String reqId=trustcode+"DR"+dr.getCheckDate();
			dr.setReqId(reqId);
			logger.info("DayReport_reqId:{}",reqId);
			
			//组装签名
			String str="checkDate="+dr.getCheckDate()+"&clientId="+dr.getClientId()+"&dayCount="+dr.getDayCount()+"&dayLoan="+dr.getDayLoan()+"&dayMoney="+dr.getDayMoney()+"&dayRepay="+dr.getDayRepay()+"&loanBalance="+dr.getLoanBalance()+"&loanCount="+dr.getLoanCount()+"&loanMoney="+dr.getLoanMoney()+"&reqId="+dr.getReqId()+"&roundStr="+dr.getRoundStr()+"&token="+dr.getToken()+"&appKey="+dr.getAppKey();
			logger.info("DayReport签名字段：{}",str);
			String sign=Md5ToolUtil.getMd5Code(str);
			dr.setSign(sign);
			logger.info("DayReport签名结果：{}",sign);
		}
		return drl;
	}
}
