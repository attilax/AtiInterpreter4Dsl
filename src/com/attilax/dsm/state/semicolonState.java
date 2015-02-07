package com.attilax.dsm.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
 
 
import com.attilax.dsm.ContextAti;
import com.attilax.interpreter.fsm.Token;

public class semicolonState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		ContextAti ctt=(ContextAti) context;
	    char curchar=ctt.curchar;
	    
	   // if(ctt.lastKeystate instanceof DoubleQuoetStartState)
	    {
//	    Token tk=new Token();
//	    tk.value=ctt.curToken.value;
//	    ctt.tokenList.add(tk);
	    ctt.tokenList.add(new Token(){{ this.value=";" ; }});
	    ctt.curToken=new Token();
	    }
	    
	 //   ctt.curToken.value+=curchar;
	    ctt.curcharIndex++;
ctt.lastKeystate=new semicolonState();
	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}

 

}
