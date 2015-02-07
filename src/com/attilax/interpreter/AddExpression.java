package com.attilax.interpreter;

import java.util.HashMap;

import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.exam.NonterminalExpression;

public class AddExpression extends NonterminalExpression {
 
public AddExpression(AbstractExpression _left,AbstractExpression _right){
 
 
}
 
//把左右两个表达式运算的结果加起来
 
public int interpreter(Context ctx) {
	return 0;
 
//return super.left.interpreter(var) + super.right.interpreter(var);
 
}
 
}