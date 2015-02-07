package com.attilax.interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import net.sf.json.JSONObject;

import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.exam.VarExpression;
import com.attilax.interpreter.fsm.Token;
import com.attilax.interpreter.fsm.fsmx;
import com.attilax.json.JsonUtil4jackjson;

public class CopyOfClient {

	public Context ctx=new Context();

	// ����ı��ʽ

	private AbstractExpression expression;

	public static void main(String[] args) throws CantFindRitBrack {
		CopyOfClient clt = new CopyOfClient("");
		@SuppressWarnings("unused")
		Object rzt = clt.run();
 System.out.println(JsonUtil4jackjson.buildNormalBinder().toJson(				rzt));
		
	}

	// ���캯������,������

	public CopyOfClient(String expStr) throws CantFindRitBrack {

		// ����һ����ջ������������Ⱥ�˳��

		Stack<AbstractExpression> stack = ctx.stack;

		// ���ʽ���Ϊ�ַ�����

		List<Token> tokenList = (List<Token>) fsmx.getTokenList();

		// ����

		//AbstractExpression left = null;

	//	AbstractExpression right = null;

		for (int i =0; i < tokenList.size(); i++) {
			Token tk = tokenList.get(i);
			switch (tk.value) {

			// case "=": // eq
			//
			// // �ӷ�����ŵ���ջ��
			//
			// left = stack.pop();
			//
			// right = new VarExpression(String.valueOf(tk.value));
			//
			// stack.push(new EqxlExpression(left, right));
			//
			// break;
			case ",": // comma exp

				AbstractExpression	left = stack.pop();

				AbstractExpression	right = new CommaItemExpression(new AttrNameExpression(
						tokenList.get(++i).value), new EqxlExpression(
						tokenList.get(++i).value), new AttValExpression(
						tokenList.get(++i).value));

				stack.push(new CommaExpression(left, right));

				break;
				
			case "(": // comma exp

		    	AbstractExpression	left3 = stack.pop();
				int nextRitBrackIdx=getnextRitBrackIdx(i,tokenList);
				List sub=tokenList.subList(i+1, nextRitBrackIdx);
				AbstractExpression	center = new BracktItemExpression(sub,ctx);
				center=stack.pop();
				stack.push(new BracktExpression(left3, center));
				i=nextRitBrackIdx;
				break;

			// case '-':
			//
			// left = stack.pop();
			//
			// right = new VarExpression(String.valueOf(tokenList[++i]));
			//
			// stack.push(new SubExpression(left, right));
			//
			// break;

			default: // var in gonsi ��ʽ�еı���
				AbstractExpression left2 =new AnnoExpression(tokenList.get(i).value);
				//i++;
//				new CommaItemExpression(
//						new AttrNameExpression(tokenList.get(i).value),
//						new EqxlExpression(tokenList.get(++i).value),
//						new AttValExpression(tokenList.get(++i).value));

				stack.push(left2);

			}

		}

		// ���������׳���

		this.expression = stack.pop();

	}

	private int getnextRitBrackIdx(int start, List<Token> tokenList) throws CantFindRitBrack {
	
		 for (int i=start;i<tokenList.size();i++) {
			if(tokenList.get(i).value.equals(")"))
					return i;
			
		}
		 throw new CantFindRitBrack("");
	}

	// start calc��ʼ����

	public Object run() {
		System.out.println("--");
	//	CommaExpression ce=(CommaExpression) expression;
		AbstractExpression  AST=new ASTrootExpress(expression,new AnnoExpression("tt"));
		System.out.println(JSONObject.fromObject(AST).toString(15));
		//json
//		System.out.println(JsonUtil4jackjson.buildNormalBinder().toJson(
//				ce));
		return this.expression.interpret(this.ctx);

	}

}