package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.interpreter.fsm.Token;

public class LeftBrackt implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		ContextAti ctt = (ContextAti) context;
		char curchar = ctt.curchar;
		ctt.leftBracktCount++;

		if (ctt.lastKeystate instanceof iniState
				|| ctt.lastKeystate instanceof semicolonState) {
			Token tk = new Token();
			tk.value = ctt.curToken.value.trim();
			ctt.tokenList.add(tk);
			
			ctt.tokenList.add(new Token() {
				{
					this.value = "(";
				}
			});
			ctt.curToken = new Token();

			// ctt.curToken.value+=curchar;
		
			ctt.lastKeystate = new LeftBrackt();
		} else {
			// pass
			ctt.curToken.value=ctt.curToken.value+new StringBuffer().append(	curchar).toString();
			 
		}
		
		ctt.curcharIndex++;

	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub

	}

}
