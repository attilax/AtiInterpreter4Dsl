package com.attilax.designpatter.statepatter;

import java.util.ArrayList;
import java.util.List;

import com.attilax.interpreter.fsm.Token;

public class Context {
    //����һ��State���͵Ķ���ʵ��
    public State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * �û�����Ȥ�Ľӿڷ���
     */
    public void request(String sampleParameter) {
        //ת��state������
        state.handle(sampleParameter);
    }
    
    
    //-----------------------p24------------
//    public State lastKeystate; 
//	public Object rzt;
//	public Token curToken=new Token();
//	public List<Token> tokenList=new ArrayList<Token>();
//	public char curchar;
//	public char[] charArr;
//	public int   curcharIndex;
}