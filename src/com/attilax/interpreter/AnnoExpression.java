package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

public class AnnoExpression extends AbstractExpression {

	String value;
	public AnnoExpression(String value) {
		this.value=value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Object interpret(Context ctx) {
		// TODO Auto-generated method stub
		return value;
	}
	
	public String toString()
	{
		return value;
		
	}

}
