package com.attilax.interpreter.fsm;

import java.util.ArrayList;
import java.util.List;

import com.attilax.dsm.state.commaState;

 

public class AnnoPaserContext  extends Context {
	 //����һ��State���͵Ķ���ʵ��
    public State state;
    public State lastKeystate; 
	public Object rzt;
	public Token curToken=new Token();
	public List<Token> tokenList=new ArrayList<Token>();
	public char curchar;
	public char[] charArr;
	public int   curcharIndex;
    public void setState(State state) {
        this.state = state;
    }
    
    public AnnoPaserContext() {
    	// state = new iniState();
    	// state.handle(sampleParameter, context);
	}
    /**
     * �û�����Ȥ�Ľӿڷ���
     */
    public void request(String sampleParameter) {
    	if( state instanceof iniState )
    	{
    		 state.handle(sampleParameter, this);
    		 return;
    	}
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
    	if(curchar=='"')   //splittor word
    		state=new DoubleQuoeState();
    	if(curchar=='(')  //op word
    		state=new LeftBrackt();
    	if(curchar==')')
    		state=new RightBrackt();
    	if(curchar=='=')
    		state=new EqxState();
    
     	if(curchar==',')
    	 	state=new commaState();
     
    	
        //ת��state������
        state.handle(sampleParameter, this);
    }
}
