package com.attilax.interpreter;

import java.util.List;

 

public class Anno {
   public List<Attr> attrList;
public String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Attr> getAttrList() {
	return attrList;
}

public void setAttrList(List<Attr> attrList) {
	this.attrList = attrList;
}
}
