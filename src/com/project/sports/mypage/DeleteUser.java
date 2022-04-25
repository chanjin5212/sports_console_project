package com.project.sports.mypage;

import java.util.Scanner;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.main.UserAdminDivide;
import com.project.sports.user.UserFunction;
import com.project.sports.user.UserLogin;

/**
 * 회원을 탈퇴하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class DeleteUser {
	
	/**
	 * 회원을 탈퇴하는 메소드 입니다.
	 */
	public static void deleteUser() {
		while (true) {
			System.out.println("\t\t\t\t\t탈퇴하시려면 비밀번호를 입력하세요.(0. 뒤로가기)");
			System.out.print("\t\t\t\t\t\t입력:");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.equals("0")) {
				return;
			} else if (UserLogin.userData.getPassword().equals(input)) {
				User u = null;
				for (User s : Data.userList) {
					if (UserLogin.userData.getId().equals(s.getId())) {
						u = s;
					}
				}
				Data.userList.remove(u);
				System.out.println("\t\t\t\t\t탈퇴가 완료되었습니다.");
				System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
				MypageMenu.myPageMenuFlag = false;
				UserAdminDivide.loginFlag = false;
				UserFunction.successFlag = false;
				input = sc.nextLine();
				return;
			} else {
				System.out.println("\t\t\t\t\t틀린 비밀번호를 입력하셨습니다.");
			}
			
		}
	}

}
