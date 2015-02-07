package com.attilax.interpreter.fsm;

public class AtState implements State {

 
	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
	    char curchar=ctt.curchar;
   
	    if(ctt.lastKeystate instanceof iniState || ctt.lastKeystate instanceof RightBrackt)
	    {
	    Token tk=new Token();
	    tk.value=ctt.curToken.value;
	    ctt.tokenList.add(tk); 
	    ctt.curToken=new Token();
	    ctt.lastKeystate=new AtState();
	    }
	    
	    ctt.curToken.value+=curchar;
	    ctt.curcharIndex++;
		
	}

}
