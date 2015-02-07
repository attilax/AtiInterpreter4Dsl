package com.attilax.annoInterpreter;

import com.attilax.interpreter.Context;

public class Assignment extends  com.attilax.interpreter.exam.AbstractExpression{
    String left;
    String operator;
    String right;
	public Assignment(String value, String value2, String value3) {
		left=value;
		operator=value2;
		right=value3;
	}
	public String getLeft() {
		return left;
	}
	public void setLeft(String left) {
		this.left = left;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getRight() {
		return right;
	}
	public void setRight(String right) {
		this.right = right;
	}
	@Override
	public Object interpret(Context ctx) {
		 
		return null;
	}

	
	public String toString()
	{
		return left+operator+right;
		
	}

}
