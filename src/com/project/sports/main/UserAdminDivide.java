package com.project.sports.main;

import java.util.Scanner;
import com.project.sports.admin.AdminLogin;
import com.project.sports.input.User;
import com.project.sports.output.Output;
import com.project.sports.user.UserFunction;
import com.project.sports.user.UserLogin;


/**
 * 관리자와 회원으로 나뉘는 클래스입니다.
 * @author 김찬진
 *
 */
public class UserAdminDivide {
	
	public static boolean loginFlag = true;
	
	/**
	 * 관리자와 회원 중 선택하는 메소드 입니다.
	 * @param input 회원이 선택한 번호 입니다.
	 */
	public static void loginType(String input) {
		
		Scanner sc = new Scanner(System.in);
		UserLogin userLogin = new UserLogin();
		
		while(loginFlag) {
			Output.loginMenu();
			input = sc.nextLine(); // 회원/관리자 여부 받기

			if(input.equals("1")) { //회원
				userLogin.loginInfo();
				//실행되는 메소드
			} else if(input.equals("2")) { //관리자
				for (User u : Data.userList) {
					if (u.getId().equals("관리자"));
					UserLogin.userData = u;
				}
				AdminLogin.adminLogin();
			}else if(input.equals("0")){
				loginFlag = false;
			} else { //유효성검사
				
			}
		}
		
	}
	

}
