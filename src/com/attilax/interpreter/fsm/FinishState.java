package com.attilax.interpreter.fsm;

public class FinishState  implements State {

	 

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
		if(ctt.curToken.value.trim().length()>0)
			ctt.tokenList.add(ctt.curToken);
	}

}
