package com.attilax.interpreter;

import java.util.List;
import java.util.Stack;

import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.fsm.Token;

public class BracktItemExpression extends AbstractExpression {

	public BracktItemExpression(List sub2, Context ctx) {
		Stack<AbstractExpression> stack = ctx.stack;
		List<Token> tokenList = sub2;

		for (int i = 0; i < tokenList.size(); i++) {
			Token tk = tokenList.get(i);
			switch (tk.value) {

 
			case ",": // comma exp

				AbstractExpression left = stack.pop();

				AbstractExpression right = new CommaItemExpression(
						new AttrNameExpression(tokenList.get(++i).value),
						new EqxlExpression(tokenList.get(++i).value),
						new AttValExpression(tokenList.get(++i).value));

				stack.push(new CommaExpression(left, right));

				break;
 

			default: // var in gonsi 公式中的变量
				AbstractExpression left2 = new CommaItemExpression(
						new AttrNameExpression(tokenList.get(i).value),
						new EqxlExpression(tokenList.get(++i).value),
						new AttValExpression(tokenList.get(++i).value));

				stack.push(left2);

			}
		}

	}

	private int getnextRitBrackIdx(int i, List<Token> tokenList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object interpret(Context ctx) {
		 
		return ctx.curAnno_AttrList;
	}

}
