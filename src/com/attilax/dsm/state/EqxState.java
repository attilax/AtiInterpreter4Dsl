package com.attilax.dsm.state;

public class EqxState implements State {

	@Override
	public void handle(String sampleParameter, Context context) {
		AnnoPaserContext ctt = (AnnoPaserContext) context;
		char curchar = ctt.curchar;

		if (ctt.lastKeystate instanceof LeftBrackt || ctt.lastKeystate instanceof commaState || ctt.lastKeystate instanceof iniState) {
			Token tk = new Token();
			tk.value = ctt.curToken.value.trim();
			ctt.tokenList.add(tk);
			ctt.tokenList.add(new Token() {
				{
					this.value = "=";
				}
			});
			ctt.curToken = new Token();
		} else
			ctt.curToken.value += curchar;
		ctt.curcharIndex++;

	}

}
