package com.attilax.dsm.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.sql.interpreter.Context4sqlUpExp;

public class iniState implements State {

 

	@Override
	public void handle(String sampleParameter, Context context) {
		Context4sqlUpExp ctt = (Context4sqlUpExp) context;
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
