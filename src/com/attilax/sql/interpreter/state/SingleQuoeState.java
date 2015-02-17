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
public class SingleQuoeState implements State {

	/* (non-Javadoc)
	 * @see com.attilax.designpatter.statepatter.State#handle(java.lang.String)
	 */
	@Override
	public void handle(String sampleParameter) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.attilax.designpatter.statepatter.State#handle(java.lang.String, com.attilax.designpatter.statepatter.Context)
	 */
	@Override
	public void handle(String sampleParameter, Context context) {
		Context4sqlUpExp ctt = (Context4sqlUpExp) context;
	    char curchar=ctt.curchar; 
	   
	   ctt. SingleQuoeCount++;
	 //   ctt.curToken.value+=curchar;
	    
	    
	    //sec queot 
	    if( nextAlsoSq(ctt) &&  ctt. SingleQuoeCount%2==0 )
	    {
	    	ctt.curToken.value=ctt.curToken.value+new StringBuffer().append(curchar).toString();
	    	ctt.curcharIndex++;
	    return;
	    	
	    }
	    else   if( preAlsoSq(ctt) &&  ctt. SingleQuoeCount%2==1 )
	    {
	    	ctt.curToken.value=ctt.curToken.value+new StringBuffer().append(curchar).toString();
	    	ctt.curcharIndex++;
	    return;
	    }
	    
	    else if(ctt.lastKeystate instanceof EqxState)
	    {
	    	
	    	  ctt.curToken=new Token();
	    	  ctt.lastKeystate=new SingleQuoetStartState();
		  
	    }
	    else if (ctt.lastKeystate instanceof SingleQuoetStartState )//first queot
	    {
	    	  Token tk=new Token();
			    tk.value=ctt.curToken.value;
			    ctt.tokenList.add(tk);
			//    ctt.tokenList.add(new Token(){{ this.value="," ; }});
			    ctt.curToken=new Token();
			    ctt.lastKeystate=new SingleQuoeEndState();
	    }

	    
	    
	    ctt.curcharIndex++;
	    

	}

			/**
		@author attilax 老哇的爪子
		@since   p2g m_n_5
		 
		 */
	private boolean preAlsoSq(Context4sqlUpExp ctt) {
		if(	 ctt.charArr[ctt.curcharIndex-1]=='\'')
			return true;
		else
			return false;
	}

		/**
		@author attilax 老哇的爪子
		 * @param ctt 
		@since   p2g m_c_s
		 
		 */
	private boolean nextAlsoSq(Context4sqlUpExp ctt) {
		try {
			if(	 ctt.charArr[ctt.curcharIndex+1]=='\'')
				return true;
			else
				return false;
			 
		
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	
	}
}
