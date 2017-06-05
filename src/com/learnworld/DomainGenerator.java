package com.learnworld;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class DomainGenerator {

	public static void main(String[] args){
	    // pinyin list, read from pinyin.txt
		List<String> items = new ArrayList<String>();
		// domain list, which need to check
	    ArrayBlockingQueue<String> taskQueue = new ArrayBlockingQueue<String>(163620);
	    // available domain list, which need to save into file
	    LinkedBlockingQueue<String> resultQueue = new LinkedBlockingQueue<String>();
	    // counter, need to count unavailable domain statistical information
	    AtomicInteger count = new AtomicInteger(0);
	    
	    // Httpclient initialization
	    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(20);
        cm.setDefaultMaxPerRoute(20);
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
	    
		try {
			
			 // domain.txt, used to save all available domain result
            BufferedWriter writer = new BufferedWriter(new FileWriter("domain.txt"));
            
            
            
            
<<<<<<< HEAD
		   /* // pinyin.txt, used to save all available pinyin
=======
		    // pinyin.txt, used to save all available pinyin
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
           BufferedReader reader = new BufferedReader(new FileReader("pinyin.txt"));
            
            String item = null;
           while((item = reader.readLine()) != null){
              items.add(item);
            }
            
            // generate domain list
            for (String item1 : items){
                for (String item2 : items) {
                    taskQueue.offer(item1 + item2 + ".com");
                }
<<<<<<< HEAD
            }*/
            
            
            
            String item = null;
            BufferedReader reader = new BufferedReader(new FileReader("letter.txt"));
            while((item = reader.readLine()) != null){
            	 taskQueue.offer(item+".com");
              }
            
            
            
         /*   
              System.out.println("kaishi");
=======
            }
            
            
            
            
            /*   System.out.println("kaishi");
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
            List<String> va = Arrange.getVlues();
            System.out.println(va.size());
            for (String item1 : va) {
            	//System.out.println("²é¿´"+item1);
                     taskQueue.offer(item1+".com");
                 }*/
			
<<<<<<< HEAD
            int domainThreadNum = 50;
=======
            int domainThreadNum = 3;
>>>>>>> a3ec2eb1e850c867c3e46d4951784485026a6990
            CountDownLatch downLatch = new CountDownLatch(domainThreadNum);
			ExecutorService executor = Executors.newFixedThreadPool(domainThreadNum + 1); 
			
			// start domain check thread
			for(int i = 0; i < domainThreadNum; i++){
				executor.execute(new DomainRunner(taskQueue, resultQueue, downLatch, count, httpClient));
			}
			
			// start result writer thread
			executor.execute(new ResultRunner(resultQueue, writer));
			
			downLatch.await();
			System.out.println("All tasks are done!");
			
			// TODO, suggest use volatile flag to control ResultRunner
			executor.shutdownNow();
			
			//reader.close();
			writer.close();
			httpClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
