package com.wsxd.main.utils;

import java.nio.charset.Charset;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wsxd.main.entity.BaseReqBean;
import com.wsxd.main.entity.ResultBean;

public class RestTemplateUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(RestTemplateUtils.class);
	
	private static class SingletonRestTemplate {
		/**
		 * 单例对象实例
		 */
		static final RestTemplate INSTANCE = new RestTemplate();
	}

	private RestTemplateUtils() {

	}
	
	/**
	 * 单例实例
	 */
	public static RestTemplate getInstance() {
		return SingletonRestTemplate.INSTANCE;
	}

	/**
	 * 
	 * 发送post请求
	 * 
	 * @param url
	 *            请求URL地址
	 * @param data
	 *            json数据
	 * 
	 */
	public static ResultBean post(String url, String data)
			throws Exception {
		HttpHeaders headers = new HttpHeaders();

		headers.add("Accept", "application/json");
		headers.add("Accpet-Encoding", "gzip");
		headers.add("Content-Encoding", "UTF-8");
		headers.add("Content-Type", "application/json; charset=UTF-8");

		HttpEntity<String> formEntity = new HttpEntity<String>(data, headers);
		return RestTemplateUtils.getInstance().postForObject(url, formEntity, ResultBean.class);
	}
	

	
	/**
	 * get根据url获取对象
	 */
	public static String get(String url) {
		return RestTemplateUtils.getInstance().getForObject(url, String.class,
				new Object[] {});
	}

	/**
	 * getById根据ID获取对象
	 */
	public String getById(String url, String id) {
		return RestTemplateUtils.getInstance().getForObject(url, String.class,
				id);
	}


	/**
	 * put修改对象
	 */
	public static void put(String url, String data) {
		RestTemplateUtils.getInstance().put(url, null, data);
	}

	/**
	 * delete根据BaseReqBean删除对象
	 */
	public static ResultBean delete(String url, BaseReqBean brb) {
		return exchange(url, brb, HttpMethod.DELETE, ResultBean.class);
	}
	
    /**
     * 发送/获取 服务端数据 (主要用于解决发送put,delete方法无返回值问题).
     * @param url      绝对地址
     * @param method   请求方式
     * @param bodyType 返回类型
     * @param <T>      返回类型
     * @return 返回结果(响应体)
     */
    private static <T> T exchange(String url, Object request, HttpMethod method, Class<T> bodyType) {
        HttpHeaders headers = new HttpHeaders();
        MimeType mimeType = MimeTypeUtils.parseMimeType("application/json");
        MediaType mediaType = new MediaType(mimeType.getType(), mimeType.getSubtype(), Charset.forName("UTF-8"));
        headers.setContentType(mediaType);
        ObjectMapper om=new ObjectMapper();
        String jsonString = null;
        try {
			jsonString=om.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        HttpEntity<String> entity = new HttpEntity<>(jsonString, headers);
        RestTemplate restTemplate = RestTemplateUtils.getInstance();
        logger.info("requestUrl:{},method:{},params:{}", url, method, jsonString);
        ResponseEntity<T> resultEntity = restTemplate.exchange(url, method, entity, bodyType);
        logger.info("returnData:{}", resultEntity);
        return resultEntity.getBody();
    }
    
	public static void main(String[] args) {
		
	}
}
