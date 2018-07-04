package org.kh.member.controller;

public class ViewResolver {
	public String prefix;
	public String suffix;
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getView(String viewName) {
		
		//ex) loginSuccess 글자가 왔다면
		return prefix+viewName+suffix;
		
		//ex) ./loginSuccess.jsp 로 리턴
	}
}
