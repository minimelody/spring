package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{

	@Override
	public void powerOn() {
		System.out.println("AppleSpeaker ==> 전원이 켜졌습니다.");
	}

	@Override
	public void powerOff() {
		System.out.println("AppleSpeaker ==> 전원이 꺼졌습니다.");
	}

}
