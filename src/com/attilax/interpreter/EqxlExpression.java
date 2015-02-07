package com.attilax.interpreter;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.attilax.interpreter.exam.AbstractExpression;

/**
 * ternima exp
 * @author Administrator
 *
 */
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY)
public class EqxlExpression  extends  AbstractExpression {

 

     
public EqxlExpression(String value) {
		// TODO Auto-generated constructor stub
	}

	//public String 
	@Override
	public Object interpret(Context ctx) {
		return null;
	
		
	}
	public String toString()
	{
		return "=";
		
	}
}
