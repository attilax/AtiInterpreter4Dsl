package com.attilax.interpreter;

import com.attilax.interpreter.exam.AbstractExpression;

public class BracktlExpression  extends  AbstractExpression {

	  private  AbstractExpression left;

      private  AbstractExpression right;

     

      public  BracktlExpression(AbstractExpression left,AbstractExpression right) {

             this.left=left;

             this.right=right;

      }
	@Override
	public Object interpret(Context ctx) {
		return ctx;
		// TODO Auto-generated method stub
		
	}

}
