package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

public class AttrNameExpression  extends AbstractExpression{

	public String getAttname() {
		return attname;
	}
	public void setAttname(String attname) {
		this.attname = attname;
	}

	public String attname;
	public AttrNameExpression(String value) {
		attname=value;
	}
	@Override
	public Object interpret(Context ctx) {
		return attname;
		 
		
	}
	
	public String toString()
	{
		return attname;
		
	}

}
