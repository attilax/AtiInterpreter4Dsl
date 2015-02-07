package com.attilax.annoInterpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import net.sf.json.JSONObject;

import com.attilax.interpreter.ASTrootExpress;
import com.attilax.interpreter.AnnoExpression;
import com.attilax.interpreter.AttValExpression;
import com.attilax.interpreter.AttrNameExpression;
import com.attilax.interpreter.BracktExpression;
import com.attilax.interpreter.BracktItemExpression;
import com.attilax.interpreter.CantFindRitBrack;
import com.attilax.interpreter.CommaExpression;
import com.attilax.interpreter.CommaItemExpression;
import com.attilax.interpreter.Context;
import com.attilax.interpreter.EqxlExpression;
import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.exam.VarExpression;
import com.attilax.interpreter.fsm.Token;
import com.attilax.interpreter.fsm.fsmx;
import com.attilax.json.JsonUtil4jackjson;

public class Client {

	public Context ctx = new Context();

	// 定义的表达式

	public AbstractExpression expression;
	
	public AbstractExpression astRoot;
	@SuppressWarnings("all")
	public static void main(String[] args) throws CantFindRitBrack {
		Client clt = new Client("");		
		Object rzt = clt.run();
		System.out.println(JSONObject.fromObject(clt.astRoot).toString(10));
		
		
		System.out.println(JsonUtil4jackjson.buildNormalBinder().toJson(rzt));

	}

	// 构造函数传参,并解析

	public Client(String expStr) throws CantFindRitBrack {

		ini();

	}

	private void ini() throws CantFindRitBrack {
		// 定义一个堆栈，安排运算的先后顺序

		Stack<AbstractExpression> stack = ctx.stack;

		List<Token> tokenList = (List<Token>) fsmx.getTokenList();

		// 运算

		for (int i = 0; i < tokenList.size(); i++) {
			Token tk = tokenList.get(i);
			switch (tk.value) {

			case "(": // comma exp

				AnnoDeclaration annoDeclar = (AnnoDeclaration) stack.pop();
				int nextRitBrackIdx = getnextRitBrackIdx(i, tokenList);
				List sub = tokenList.subList(i + 1, nextRitBrackIdx);
				annoDeclar.setAssList(sub, ctx);
				stack.push(annoDeclar);
				i = nextRitBrackIdx;
				break;

			default: // var in gonsi 公式中的变量
				AbstractExpression left2 = new AnnoDeclaration(
						tokenList.get(i).value);

				stack.push(left2);

			}

		}

		// 把运算结果抛出来

		this.expression = stack.pop();

	}

	private int getnextRitBrackIdx(int start, List<Token> tokenList)
			throws CantFindRitBrack {

		for (int i = start; i < tokenList.size(); i++) {
			if (tokenList.get(i).value.equals(")"))
				return i;

		}
		throw new CantFindRitBrack("");
	}

	// start calc开始运算

	public Object run() {
		System.out.println("--");
		// CommaExpression ce=(CommaExpression) expression;
		
		AbstractExpression AST = new ASTrootExpress(expression,
				new AnnoExpression("tt"));
		this.astRoot=AST;
		
		// json
		// System.out.println(JsonUtil4jackjson.buildNormalBinder().toJson(
		// ce));
		return this.expression.interpret(this.ctx);

	}

}