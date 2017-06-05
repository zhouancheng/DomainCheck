package com.learnworld;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class DomainRunner implements Runnable {

	private ArrayBlockingQueue<String> domainQueue;
	private LinkedBlockingQueue<String> resultQueue;
	private CountDownLatch downLatch;
	private AtomicInteger count;
	private CloseableHttpClient httpClient;
	
	public DomainRunner(ArrayBlockingQueue<String> domainQueue,
			LinkedBlockingQueue<String> resultQueue, CountDownLatch downLatch,
			AtomicInteger count, CloseableHttpClient httpClient) {
		super();
		this.domainQueue = domainQueue;
		this.resultQueue = resultQueue;
		this.downLatch = downLatch;
		this.count = count;
		this.httpClient = httpClient;
	}

	@Override
	public void run() {
		String domain = null;
		while ((domain = domainQueue.poll()) != null) {
				boolean isDomainAvailable = false;
		        
		        RequestConfig requestConfig = RequestConfig.custom()
		                .setSocketTimeout(5000)
		                .setConnectTimeout(5000)
		                .setConnectionRequestTimeout(5000)
		                .build();
		        
				HttpGet httpGet = new HttpGet("http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=" + domain);
				httpGet.setConfig(requestConfig);
				httpGet.setHeader("Connection", "close");
				HttpContext context = new BasicHttpContext();
				CloseableHttpResponse response = null;
				try {
					response = httpClient.execute(httpGet, context);
					HttpEntity entity = response.getEntity();
		            int status = response.getStatusLine().getStatusCode();
		           // System.out.println("status:"+status);
		            if (status >= 200 && status < 300) {
		            	String resultXml = EntityUtils.toString(entity);
		            	isDomainAvailable = DomainValidator.isAvailableDomainForResponse(resultXml);
		            	EntityUtils.consumeQuietly(entity); 
		            } else {
		            	System.out.println(domain + " check error.");
		            }
				} catch (Exception e) {
				    e.printStackTrace();
				} finally {
					try {
						httpGet.releaseConnection();
						if (response != null) {
							response.close();
						}
						
					} catch (IOException e) {
						e.printStackTrace();
					}		
				}
			
			// result handle
			if(isDomainAvailable) {
				resultQueue.offer(domain);
			} else {
				int totalInvalid = count.addAndGet(1);
				if (totalInvalid % 100 == 0) {
					System.out.println(totalInvalid + " " + Calendar.getInstance().getTime());
				}
			}
		}
		
		downLatch.countDown();
		
	}
	
}
