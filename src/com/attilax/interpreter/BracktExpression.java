package com.attilax.interpreter;

import java.util.List;

import com.attilax.interpreter.exam.AbstractExpression;

public class BracktExpression extends AbstractExpression {
	AbstractExpression nameExp;
AbstractExpression centerExp;
	public BracktExpression(AbstractExpression left3, AbstractExpression center) {
		 this.nameExp=left3;this.centerExp=center;
	}

	@Override
	public Object interpret(Context ctx) {
		 Anno anno = new Anno();
		ctx.curAnno=anno;
		 ctx.curAnno.name=(String) this.nameExp.interpret(ctx);
		 anno.attrList=(List<Attr>) this.centerExp.interpret(ctx);
		return  ctx.curAnno;
	}

 

	public AbstractExpression getNameExp() {
		return nameExp;
	}

	public void setNameExp(AbstractExpression nameExp) {
		this.nameExp = nameExp;
	}

	public AbstractExpression getCenterExp() {
		return centerExp;
	}

	public void setCenterExp(AbstractExpression centerExp) {
		this.centerExp = centerExp;
	}

 

}
