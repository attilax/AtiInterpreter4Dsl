package com.attilax.interpreter.fsm;

public class NormalState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
	    char curchar=ctt.curchar;
	  //  if(curchar!=' ')
	    	ctt.curToken.value+=curchar;
	    ctt.curcharIndex++;

	}

}
