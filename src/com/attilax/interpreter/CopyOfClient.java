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

	// 定义的表达式

	private AbstractExpression expression;

	public static void main(String[] args) throws CantFindRitBrack {
		CopyOfClient clt = new CopyOfClient("");
		@SuppressWarnings("unused")
		Object rzt = clt.run();
 System.out.println(JsonUtil4jackjson.buildNormalBinder().toJson(				rzt));
		
	}

	// 构造函数传参,并解析

	public CopyOfClient(String expStr) throws CantFindRitBrack {

		// 定义一个堆栈，安排运算的先后顺序

		Stack<AbstractExpression> stack = ctx.stack;

		// 表达式拆分为字符数组

		List<Token> tokenList = (List<Token>) fsmx.getTokenList();

		// 运算

		//AbstractExpression left = null;

	//	AbstractExpression right = null;

		for (int i =0; i < tokenList.size(); i++) {
			Token tk = tokenList.get(i);
			switch (tk.value) {

			// case "=": // eq
			//
			// // 加法结果放到堆栈中
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

			default: // var in gonsi 公式中的变量
				AbstractExpression left2 =new AnnoExpression(tokenList.get(i).value);
				//i++;
//				new CommaItemExpression(
//						new AttrNameExpression(tokenList.get(i).value),
//						new EqxlExpression(tokenList.get(++i).value),
//						new AttValExpression(tokenList.get(++i).value));

				stack.push(left2);

			}

		}

		// 把运算结果抛出来

		this.expression = stack.pop();

	}

	private int getnextRitBrackIdx(int start, List<Token> tokenList) throws CantFindRitBrack {
	
		 for (int i=start;i<tokenList.size();i++) {
			if(tokenList.get(i).value.equals(")"))
					return i;
			
		}
		 throw new CantFindRitBrack("");
	}

	// start calc开始运算

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