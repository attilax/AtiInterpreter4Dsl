package com.attilax.annoInterpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.attilax.interpreter.AttValExpression;
import com.attilax.interpreter.AttrNameExpression;
import com.attilax.interpreter.CommaExpression;
import com.attilax.interpreter.CommaItemExpression;
import com.attilax.interpreter.Context;
import com.attilax.interpreter.EqxlExpression;
import com.attilax.interpreter.exam.AbstractExpression;
import com.attilax.interpreter.fsm.Token;

public class AnnoDeclaration extends AbstractExpression{

	String name;
	List<Assignment> assignments=new ArrayList<Assignment>();
 

	public AnnoDeclaration(String value) {
	 name=value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object interpret(Context ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAssList(List subTokenList, Context ctx) {
		Stack<AbstractExpression> stack =  new Stack<AbstractExpression>();
		List<Token> tokenList = subTokenList;

		for (int i = 0; i < tokenList.size(); i++) {
			Token tk = tokenList.get(i);
			switch (tk.value) {

 
			case ",": // comma exp
 
				AbstractExpression right = new Assignment(tokenList.get(++i).value,tokenList.get(++i).value,tokenList.get(++i).value);
				this.assignments.add((Assignment) right); 

			 
				break;
 

			default: // var in gonsi 公式中的变量
				AbstractExpression left2 =new Assignment(tokenList.get(i).value,tokenList.get(++i).value,tokenList.get(++i).value);
				this.assignments.add((Assignment) left2) ;
				//stack.push(left2);

			}
		}
		//this.setAssList((List<Assignment>) stack.pop());
		
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

}
