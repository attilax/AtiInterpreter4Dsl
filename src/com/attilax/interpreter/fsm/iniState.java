package com.attilax.interpreter.fsm;

public class iniState implements State {

 

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
	    char curchar=ctt.curchar;
	    ctt.charArr=sampleParameter.toCharArray();
		ctt.curcharIndex=0;
		  System.out.println(sampleParameter);
		ctt.  lastKeystate=new iniState();
		ctt.state=new iniOkState();
		
	}

}
