package com.project.sports.user.predict;

import com.project.sports.output.Output;

/**
 * 승부예측 메뉴의 모든 출력문을 가진 클래스
 * @author 서주예
 */
public class Print {

	
	/**
	 * 승부예측 메뉴를 출력하는 메소드
	 */
	public static void predictMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │          1. 승부 예측하기	    │");
		System.out.println("\t\t\t\t\t │          2. 예측 결과 보기	    │");
		System.out.print("\t\t\t\t\t │\t    ");
		Output.back();
		System.out.print("\t    	    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
	}
	
}
