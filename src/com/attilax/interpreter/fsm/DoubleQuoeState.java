package com.attilax.interpreter.fsm;

public class DoubleQuoeState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt=(AnnoPaserContext) context;
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

 

}
