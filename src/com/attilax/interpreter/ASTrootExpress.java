package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

public class ASTrootExpress extends AbstractExpression {
	AbstractExpression 	rootExp;
//	AbstractExpression 	annoExpression;
	public ASTrootExpress(AbstractExpression expression, AnnoExpression annoExpression) {
		this.rootExp=expression;
		//this.annoExpression=annoExpression;
	}

 
//
//	public AbstractExpression getAnnoExpression() {
//		return annoExpression;
//	}
//
//	public void setAnnoExpression(AbstractExpression annoExpression) {
//		this.annoExpression = annoExpression;
//	}

	public AbstractExpression getRootExp() {
		return rootExp;
	}


	public void setRootExp(AbstractExpression rootExp) {
		this.rootExp = rootExp;
	}


	@Override
	public Object interpret(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

}
