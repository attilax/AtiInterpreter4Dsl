/**
 * 
 */
package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.interpreter.fsm.Token;
import com.attilax.sql.interpreter.Context4sqlUpExp;

/**
 * @author ASIMO
 * 
 */
public class CommaState implements State {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.attilax.designpatter.statepatter.State#handle(java.lang.String)
	 */
	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.attilax.designpatter.statepatter.State#handle(java.lang.String,
	 * com.attilax.designpatter.statepatter.Context)
	 */
	@Override
	public void handle(String sampleParameter, Context context) {
		
		
		
		Context4sqlUpExp ctt = (Context4sqlUpExp) context;
		char curchar = ctt.curchar;

		  if(ctt.lastKeystate instanceof EqxState  )
		{
			  //
			  Token tk=new Token();
			  tk.value=ctt.curToken.value.trim();
			  ctt.tokenList.add(tk);
			  
			ctt.tokenList.add(new Token() {
				{
					this.value = ",";
				}
			});
			ctt.curToken = new Token();
			
			ctt.lastKeystate = new CommaState();
		}
		  else if(  ctt.lastKeystate instanceof SingleQuoeEndState)
		  {
				ctt.tokenList.add(new Token() {
					{
						this.value = ",";
					}
				});
				ctt.curToken = new Token();
				
				ctt.lastKeystate = new CommaState(); 
				 ctt. SingleQuoeCount=0;
		  }
		  else
		{
			 ctt.curToken.value+=curchar;
		}

		// ctt.curToken.value+=curchar;
		ctt.curcharIndex++;
		

	}

}
