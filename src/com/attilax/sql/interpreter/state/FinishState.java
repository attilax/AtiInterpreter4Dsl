package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;

public class FinishState  implements State {

	 

	@Override
	public void handle(String sampleParameter, Context context) {
		ContextAti ctt=(ContextAti) context;
		if(ctt.curToken.value.trim().length()>0)
			ctt.tokenList.add(ctt.curToken);
	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}
 

}
