package com.attilax.interpreter.fsm;

public class RightBrackt implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
	    char curchar=ctt.curchar;
//	    Token tk=new Token();
//	    tk.value=ctt.curToken.value;
//	    ctt.tokenList.add(tk);
	    ctt.tokenList.add(new Token(){{ this.value=")" ; }});
	    ctt.curToken=new Token();
	    
	 //   ctt.curToken.value+=curchar;
	    ctt.curcharIndex++;
	    ctt.lastKeystate=new RightBrackt();
		
	}

	 

}
