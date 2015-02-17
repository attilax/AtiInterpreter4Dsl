package com.attilax.sql.interpreter;

import java.util.List;

import com.attilax.designpatter.statepatter.Context;
import com.attilax.dsm.interpreter.Tokener;
import com.attilax.dsm.state.FinishState;
import com.attilax.dsm.state.iniState;
import com.attilax.interpreter.fsm.Token;
import com.attilax.json.JsonX;

public class SqlUpExpTokener extends Tokener {

	public static void main(String[] args) {
		String s = " sql( select from table(aa)values('val') ) ; method1(param1);\r\n method2(param2); \r\n method3 (param3) ;";
		s = "fld1=1,fld2='at''t,lax',fld3='val3'";
		List li = new SqlUpExpTokener().getTokenList(s);
		System.out.println(JsonX.toJsonStrO88(li));
		System.out.println("--");
	}

	public List getTokenList(String s) {
		// DslPaserContext context = new DslPaserContext();
		Context4sqlUpExp context = new Context4sqlUpExp();
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
			System.out.println(tk.value + "===");
		}
		return (List) context.tokenList;
	}

}
