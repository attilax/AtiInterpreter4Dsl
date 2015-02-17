package com.attilax.sql.interpreter.state;

 

import java.util.List;

import com.attilax.designpatter.statepatter.ConcreteStateB;
import com.attilax.designpatter.statepatter.Context;
 

public class fsmx {

	public static void main(String[] args) {
		 
		getTokenList();
	//	System.out.println(context.rzt );
	}

	public static List getTokenList() {
		String s = "@QueryAdptr(sqlwhere=\" clo1='@p' \",prop2=\"v2\") @Nofilt";
		s="@qu(at1=\"v1\" , at2 = \" v2 abc \",at3=\"v3\" ) ";
		// ��������
		AnnoPaserContext context = new AnnoPaserContext();
		// ��״̬���õ�������
		// ����״̬
	 
	 	context.setState(new iniState());
 	
		 
		int n=0;
		while(!( context.state instanceof FinishState))
		{
		// 	System.out.println(n);
		// ����
		context.request(s);
		n++;
		if(n>200)
			break;
		}
		
		for (Token tk : context.tokenList) {
		//	if(tk.value.trim().length()>0)
			System.out.println(tk.value+"");
		}
		return (List) context.tokenList;
	}

}
