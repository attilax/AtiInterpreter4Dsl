package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

/**
 * non termina exp
 * @author Administrator
 *
 */
public class CommaItemExpression  extends  AbstractExpression {

	 

      public AttrNameExpression getAttNameExp() {
		return attNameExp;
	}


	public void setAttNameExp(AttrNameExpression attNameExp) {
		this.attNameExp = attNameExp;
	}


	public EqxlExpression getEqExp() {
		return eqExp;
	}


	public void setEqExp(EqxlExpression eqExp) {
		this.eqExp = eqExp;
	}


	public AttValExpression getAttValExp() {
		return attValExp;
	}


	public void setAttValExp(AttValExpression attValExp) {
		this.attValExp = attValExp;
	}

	public AttrNameExpression  attNameExp;
  	public EqxlExpression  eqExp;
  	public AttValExpression  attValExp;

    
	public CommaItemExpression(AttrNameExpression attrNameExpression,
			EqxlExpression eqxlExpression, AttValExpression attValExpression) {
		attNameExp =attrNameExpression;
		eqExp=eqxlExpression;attValExp=attValExpression;
	}


	@Override
	public Object interpret(Context ctx) {
		// (
			Attr a=new Attr();
			a.key=(String) attNameExp.interpret(ctx);
			a.val=(String) attValExp.interpret(ctx);
	 	//  ctx.curAnno_AttrList.add(a);
	 	 return a;
		
	}
	
	public String toString()
	{
		return attNameExp.toString()+eqExp.toString()+attValExp.toString();
		
	}


}
