package com.attilax.dsm;

import java.util.List;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.dsm.interpreter.Tokener;
import com.attilax.dsm.state.FinishState;
import com.attilax.dsm.state.iniState;
import com.attilax.interpreter.fsm.Token;

public class DslItprtr extends Tokener{

	public static void main(String[] args) {
		String s = " sql( select from table(aa)values('val') ) ; method1(param1);\r\n method2(param2); \r\n method3 (param3) ;";

	//	List li = getTokenList(s);

	}

	public   List getTokenList(String s) {
		// DslPaserContext context = new DslPaserContext();
		ContextAti context = new ContextAti();
		context.setState(new iniState());

		int n = 0;
		while (!(context.state instanceof FinishState)) {
			// System.out.println(n);
			// ����
			context.request(s);
			n++;
			if (n > 200)
				break;
		}

		for (Token tk : context.tokenList) {
			// if(tk.value.trim().length()>0)
			System.out.println(tk.value + "==");
		}
		return (List) context.tokenList;
	}

}
