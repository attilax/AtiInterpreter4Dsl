package com.attilax.interpreter.exam;

import com.attilax.interpreter.Context;

public class NonterminalExpression  extends  AbstractExpression {

	  
	@Override
	public Object interpret(Context ctx) {
		return ctx;
		
	}

}
