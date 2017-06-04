package com.learnworld;

import java.io.BufferedWriter;
import java.util.concurrent.LinkedBlockingQueue;

public class ResultRunner implements Runnable{

	private LinkedBlockingQueue<String> resultQueue;
	BufferedWriter writer;
	
	public ResultRunner(LinkedBlockingQueue<String> resultQueue,
			BufferedWriter writer) {
		super();
		this.resultQueue = resultQueue;
		this.writer = writer;
	}

	@Override
	public void run() {
		String result = null;
		try {
			while ((result = resultQueue.take()) != null) {
				System.out.println("Î´×¢²á"+result);
				writer.write(result);
				writer.newLine();
				writer.flush();			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
