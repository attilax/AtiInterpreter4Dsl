package com.attilax.interpreter;

public class Attr {
	public String key;
	public String val;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String toString()
	{
		return key+"="+val;
		
	}

}
