package org.kh.bean.model.vo;

import java.util.Map;

public class MapBean {
	private Map<String,String> addressMap;

	public MapBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapBean(Map<String, String> addressMap) {
		super();
		this.addressMap = addressMap;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}
	
}
