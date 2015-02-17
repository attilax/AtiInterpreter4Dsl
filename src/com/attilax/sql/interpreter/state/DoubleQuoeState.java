package com.attilax.sql.interpreter.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.interpreter.fsm.Token;

public class DoubleQuoeState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		ContextAti ctt=(ContextAti) context;
	    char curchar=ctt.curchar; 
	   
	    
	 //   ctt.curToken.value+=curchar;
	    
	    
	    //sec queot 
	    if(ctt.lastKeystate instanceof DoubleQuoetStartState)
	    {
		    Token tk=new Token();
		    tk.value=ctt.curToken.value;
		    ctt.tokenList.add(tk);
		//    ctt.tokenList.add(new Token(){{ this.value="," ; }});
		    ctt.curToken=new Token();
		    ctt.lastKeystate=new DoubleQuoeEndState();
	    }
	    else  //first queot
	    {
	    	ctt.lastKeystate=new DoubleQuoetStartState();
	    	  ctt.curToken=new Token();
	    }

	    
	    
	    ctt.curcharIndex++;
	    
	    
	  
		
	}

	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub
		
	}

 

}
