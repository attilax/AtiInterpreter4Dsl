package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;

public class iniState implements State {

 

	@Override
	public void handle(String sampleParameter, Context context) {
		ContextAti ctt=(ContextAti) context;
	    char curchar=ctt.curchar;
	    ctt.charArr=sampleParameter.toCharArray();
		ctt.curcharIndex=0;
		  System.out.println(sampleParameter);
		ctt.  lastKeystate=new iniState();
		ctt.state=new iniOkState();
		
	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}

}
