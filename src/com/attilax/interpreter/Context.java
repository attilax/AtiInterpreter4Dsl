package com.attilax.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import com.attilax.annoInterpreter.AnnoDeclaration;
import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.fsm.Token;
import com.attilax.interpreter.fsm.fsmx;

public class Context {
	
	// ����ı��ʽ

		private AbstractExpression expression;
	
	public Stack<AbstractExpression> stack = new Stack<AbstractExpression>();
	public List<Anno> annoList=new ArrayList<Anno>();
	public Anno  curAnno=new Anno();
	// private HashMap map = new HashMap();
	public List<Attr> curAnno_AttrList=new ArrayList<Attr>();
	
	
	
	
//     public void assign(String key, String value) {
//
//         //������������ֵ
//
//     }

//public String  lookup(String key) {
//	return key;
//
//         //��ȡ�洢�ڻ������е�ֵ
//
//     }
}
