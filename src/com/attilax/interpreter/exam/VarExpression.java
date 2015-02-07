package com.attilax.interpreter.exam;

import java.util.HashMap;

import com.attilax.interpreter.Context;

public class VarExpression extends AbstractExpression {

	private String key;

	public VarExpression(String _key) {

		this.key = _key;

	}

	// 从map中取之

	public int interpreter(HashMap<String, Integer> var) {

		return var.get(this.key);

	}

	@Override
	public Object interpret(Context ctx) {
		return ctx;
	 

	}

}