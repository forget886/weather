package com.wuxi.service;

public class Say {

	private static int count = 1;
	public String getAdvice(int option){
		String food = "";
		switch (option) {
		case 1:
			food = "dog";
			break;
		case 2:
			food = "cat";
		default:
			break;
		}
		
		return food;
	}
	
	public static int getCount(){
		return ++count;
	}
}
