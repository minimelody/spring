package org.kh.bean.model.vo;

import java.util.Set;

public class SetBean {
	private Set<String> nameList;

	public SetBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SetBean(Set<String> nameList) {
		super();
		this.nameList = nameList;
	}

	public Set<String> getNameList() {
		return nameList;
	}

	public void setNameList(Set<String> nameList) {
		this.nameList = nameList;
	}
	
	
}
