package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.sql.interpreter.Context4sqlUpExp;

public class NormalState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		Context4sqlUpExp ctt = (Context4sqlUpExp) context;
	//	Context ctt=  context;
	    char curchar=ctt.curchar;
	  //  if(curchar!=' ')
	    	ctt.curToken.value+=curchar;
	    ctt.curcharIndex++;

	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}

 

}
