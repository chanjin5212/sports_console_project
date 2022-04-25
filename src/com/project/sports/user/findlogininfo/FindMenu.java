package com.project.sports.user.findlogininfo;

import java.util.Scanner;
import com.project.sports.output.Output;

/**
 * 아이디/비밀번호 찾기 메뉴를 출력하는 클래스
 * @author 서주예
 */
public class FindMenu {

	
	/**
	 * 아이디/비밀번호 찾기 메뉴를 출력하는 메소드
	 */
	public static void findMenu() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean findMenuFlag = true;
		while(findMenuFlag) {
			
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │           1. 아이디 찾기	    │");
			System.out.println("\t\t\t\t\t │           2. 비밀번호 찾기	    │");
			System.out.print("\t\t\t\t\t │\t       ");
			Output.back();
			System.out.print("\t    	    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			Output.input();
			
			String input = sc.nextLine();
			
			if(input.equals("1")) { //아이디 찾기
				FindId.findId();
			} else if(input.equals("2")) { //비밀번호 찾기
				FindPassword.findPassword();
			} else if(input.equals("0")){ //뒤로가기
				break;
			} else {
				//유효성 검사
			}
			
			
		}
	}
}
