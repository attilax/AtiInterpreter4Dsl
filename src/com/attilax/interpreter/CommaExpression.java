package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

/**
 * non termina exp
 * @author Administrator
 *
 */
public class CommaExpression  extends  AbstractExpression {

	public  AbstractExpression leftComma;

	 public  AbstractExpression rightCommaExp;
     public  CommaExpression(AbstractExpression left,AbstractExpression right) {

         this.leftComma=left;

         this.rightCommaExp=right;

  }
	@Override
	public Object interpret(Context ctx) {
		// (
		Object obj=leftComma.interpret(ctx);
		if(obj instanceof Attr)
		{
			Attr at1= (Attr) leftComma.interpret(ctx);
			ctx.curAnno_AttrList.add(at1);
		}else
		{
			//commExp
			
		}
		Object Rit_obj=rightCommaExp.interpret(ctx);
		if(Rit_obj instanceof Attr)
		{
			Attr at2= (Attr) rightCommaExp.interpret(ctx);
			
			 ctx.curAnno_AttrList.add(at2);
		}
		
	
		 return ctx.curAnno_AttrList ;
		
	}
	public AbstractExpression getLeftComma() {
		return leftComma;
	}
	public void setLeftComma(AbstractExpression leftComma) {
		this.leftComma = leftComma;
	}
	public AbstractExpression getRightCommaExp() {
		return rightCommaExp;
	}
	public void setRightCommaExp(AbstractExpression rightCommaExp) {
		this.rightCommaExp = rightCommaExp;
	}
	 

}
