package com.baleru.concept.controllers;

public interface IOrderControllers {
	
	
	void init();
	
	void preProcces(); 
	
	void validation(); 
	
	void process();
	
	void afterProcess(); 
}
