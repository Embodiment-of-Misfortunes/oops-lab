package com.lucienevans.resource;

public class Multithreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=1;i<3;i++) {
			
		RandomThread thr=new RandomThread(i);
		//Thread myThread=new Thread(thr);
		thr.start();
       //myThread.start();   
		}
	}

}
