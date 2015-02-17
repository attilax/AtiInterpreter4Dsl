package com.attilax.sql.interpreter;

import java.util.ArrayList;
import java.util.List;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.designpatter.statepatter.State;
import com.attilax.dsm.state.DoubleQuoeState;
import com.attilax.dsm.state.FinishState;
import com.attilax.dsm.state.LeftBrackt;
 
import com.attilax.dsm.state.RightBrackt;
import com.attilax.dsm.state.semicolonState;
 
import com.attilax.dsm.state.iniState;
import com.attilax.interpreter.fsm.Token;
import com.attilax.sql.interpreter.state.CommaState;
import com.attilax.sql.interpreter.state.EqxState;
import com.attilax.sql.interpreter.state.NormalState;
import com.attilax.sql.interpreter.state.SingleQuoeState;

 

public class Context4sqlUpExp  extends Context {
	 //����һ��State���͵Ķ���ʵ��
   
    public State lastKeystate; 
	public Object rzt;
	public Token curToken=new Token();
	public List<Token> tokenList=new ArrayList<Token>();
	public char curchar;
	public char[] charArr;
	public int   curcharIndex;
	public int leftBracktCount;
	public int rightBracktCount;
	public int SingleQuoeCount;
 
  
    /**
     * �û�����Ȥ�Ľӿڷ���
     */
    public void request(String sampleParameter) {
    	if( state instanceof iniState )
    	{
    		 state.handle(sampleParameter, this);
    		 return;
    	}
    	//del char 
    	state=new NormalState();
    	if(curcharIndex>=sampleParameter.length())
    	{
    		state=new FinishState();
    	 	 state.handle(sampleParameter, this);
    		 return;
    		 
    	}
    	 
    	curchar=charArr[curcharIndex];
    	//def todox if to swithc oao
    	
    	//if(curchar=='@')   //keyword
    	//	state=new AtState();
     
//    	if(curchar=='(')  //op word
//    		state=new LeftBrackt();
//    	if(curchar==')')
//    		state=new RightBrackt();
    	if(curchar=='=')
    		state=new EqxState();
    	if(curchar==',')
    	 	state=new CommaState();
    	if(curchar=='\'')   //splittor word
     		state=new SingleQuoeState();
//     	if(curchar==';')
//    	 	state=new semicolonState();
//     
    	
        //ת��state������
        state.handle(sampleParameter, this);
    }
}
