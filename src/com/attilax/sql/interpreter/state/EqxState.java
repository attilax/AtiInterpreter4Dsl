package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.interpreter.fsm.Token;
import com.attilax.sql.interpreter.Context4sqlUpExp;

public class EqxState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		Context4sqlUpExp ctt = (Context4sqlUpExp) context;
		char curchar = ctt.curchar;

		if (ctt.lastKeystate instanceof CommaState || ctt.lastKeystate instanceof CommaState || ctt.lastKeystate instanceof com.attilax.dsm.state.iniState) {
			Token tk = new Token();
			tk.value = ctt.curToken.value.trim();
			ctt.tokenList.add(tk);
			ctt.tokenList.add(new Token() {
				{
					this.value = "=";
				}
			});
			ctt.curToken = new Token();
			ctt.lastKeystate=new EqxState();
		} else
			ctt.curToken.value += curchar;
			ctt.curcharIndex++;

	}

	/* (non-Javadoc)
	 * @see com.attilax.designpatter.statepatter.State#handle(java.lang.String)
	 */
	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}

}
