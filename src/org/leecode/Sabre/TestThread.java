package org.leecode.Sabre;

public class TestThread {
	void startThread(){
		Thread thread = new Thread(new MyRunnable());
		//thread.setDaemon(true);
		thread.start();
	}
	
	public static void main(String[] args){
		new TestThread().startThread();
		
	}
	
	private static class MyRunnable implements Runnable{
		@Override
		public void run(){
			while(true){}
		}
	}
}
