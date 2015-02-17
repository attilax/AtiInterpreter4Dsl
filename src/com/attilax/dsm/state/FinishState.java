package com.attilax.dsm.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.sql.interpreter.Context4sqlUpExp;

public class FinishState  implements State {

	 

	@Override
	public void handle(String sampleParameter, Context context) {
		Context4sqlUpExp ctt = (Context4sqlUpExp) context;
		if(ctt.curToken.value.trim().length()>0)
			ctt.tokenList.add(ctt.curToken);
	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}
 

}
