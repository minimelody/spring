package org.kh.bean.model.vo;

import java.util.List;

public class CollectionBean {
	private List<String> nameList;

	public CollectionBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionBean(List<String> nameList) {
		super();
		this.nameList = nameList;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
	
	
}
