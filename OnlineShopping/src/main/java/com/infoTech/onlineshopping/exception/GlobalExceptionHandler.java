package com.infoTech.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundExcepiton(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","The page is not constructed");
		mv.addObject("errorDescription","The Page you are looking for is not avaialable right now");
		mv.addObject("title","404 not found");
		
		return mv;
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProudctNotFoundExcepiton(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Product not Available");
		mv.addObject("errorDescription","The Product you are looking for is not avaialable right now");
		mv.addObject("title","Proudct Not Available");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerExcepiton(Exception ex){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Contact your admisnistration");
		
		/* only for debugging your application*/
		/* only for debugging your application*/
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","error");
		
		return mv;
	}
}
