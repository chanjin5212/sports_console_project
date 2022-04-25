package com.project.sports.main;

import java.util.Scanner;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;
import com.project.sports.user.findlogininfo.FindMenu;
import com.project.sports.user.makeuser.MakeUser;

/**
 * 프로젝트 시작 클래스 입니다.
 * @author 김찬진
 *
 */
public class Main {
	
	/**
	 * 메인 메소드로 시작하는 메소드 입니다.
	 * @param args 메인 메소드 입니다.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Data.load();
		DataAdd.dataAdd();
		boolean flag = true;
		
		//초기화면
		while(flag) { 
			Output.mainLogo();
			Output.startMenu();
			Output.input();
			
			String input = sc.nextLine(); //메뉴번호 입력받기
			
			if(input.equals("1")) { //로그인
				
				UserAdminDivide.loginFlag = true;
				UserAdminDivide.loginType(input);
				
			} else if(input.equals("2")) { //회원가입
				MakeUser.makeUser();
			} else if(input.equals("3")) { //아이디 비밀번호 찾기
				FindMenu.findMenu();
			} else if(input.equals("4")) { //프로그램 종료
				flag = false;
				Data.save();
			} else { //유효성 검사
				
			}
		}
		
		
	}

}
