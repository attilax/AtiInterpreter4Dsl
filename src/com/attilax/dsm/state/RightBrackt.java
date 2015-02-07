package com.attilax.dsm.state;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.ContextAti;
import com.attilax.interpreter.fsm.Token;

public class RightBrackt implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
	
		ContextAti ctt=(ContextAti) context;
		ctt.rightBracktCount++;
	    char curchar=ctt.curchar;
//	    Token tk=new Token();
//	    tk.value=ctt.curToken.value;
//	    ctt.tokenList.add(tk);
	    if(ctt.leftBracktCount<ctt.rightBracktCount)
	    {
	    	throw new RuntimeException(" ( expected after this token ") ; 
	    }
	    if( ctt.leftBracktCount==ctt.rightBracktCount)//new token
	    {
	    	addTmpToken2list(ctt);
	    	
		    ctt.tokenList.add(new Token(){{ this.value=")" ; }});
		    ctt.curToken=new Token();
		    
		    ctt.leftBracktCount=0;
		    ctt.rightBracktCount=0;
		    ctt.lastKeystate=new RightBrackt();
	    }else
	    {
	    	ctt.curToken.value=ctt.curToken.value+new StringBuffer().append(ctt.curchar).toString();
	    }
	    
	 //   ctt.curToken.value+=curchar;
	    ctt.curcharIndex++;
	  
		
	}

	private void addTmpToken2list(ContextAti ctt) {
	//	ctt.curToken.value=ctt.curToken.value+new StringBuffer().append(ctt.curchar).toString();
		Token tk = new Token();
		tk.value = ctt.curToken.value;
		ctt.tokenList.add(tk);
		
	}

	@Override
	public void handle(String sampleParameter) {
		 
	//	new String "aaa");
	}

	 

}
