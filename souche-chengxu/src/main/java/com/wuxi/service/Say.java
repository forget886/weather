package com.wuxi.service;

public class Say {

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
}
