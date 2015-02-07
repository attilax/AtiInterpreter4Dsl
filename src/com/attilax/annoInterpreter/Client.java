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

	// ����ı��ʽ

	public AbstractExpression expression;
	
	public AbstractExpression astRoot;
	@SuppressWarnings("all")
	public static void main(String[] args) throws CantFindRitBrack {
		Client clt = new Client("");		
		Object rzt = clt.run();
		System.out.println(JSONObject.fromObject(clt.astRoot).toString(10));
		
		
		System.out.println(JsonUtil4jackjson.buildNormalBinder().toJson(rzt));

	}

	// ���캯������,������

	public Client(String expStr) throws CantFindRitBrack {

		ini();

	}

	private void ini() throws CantFindRitBrack {
		// ����һ����ջ������������Ⱥ�˳��

		Stack<AbstractExpression> stack = ctx.stack;

		List<Token> tokenList = (List<Token>) fsmx.getTokenList();

		// ����

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

			default: // var in gonsi ��ʽ�еı���
				AbstractExpression left2 = new AnnoDeclaration(
						tokenList.get(i).value);

				stack.push(left2);

			}

		}

		// ���������׳���

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

	// start calc��ʼ����

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