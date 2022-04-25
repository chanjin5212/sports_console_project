package com.project.sports.admin;

import java.util.Scanner;

/**
 * 관리자 로그인 클래스입니다.
 * @author 강지윤
 *
 */
public class AdminLogin {
	/**
	 * 관리자 번호를 입력 받아 로그인합니다.
	 */
	public static void adminLogin() {
		Scanner sc = new Scanner(System.in);
		Boolean adminLoginFlag = true;
		String adminNum = "1234";
		
		while(adminLoginFlag) {
			System.out.print("\t\t\t\t\t\t관리자 번호 : ");
			String input = sc.nextLine(); //관리자 번호 입력받기
			
			if (input.equals(adminNum)) { //관리자 번호가 일치하면
		           
		           System.out.println("\t\t\t\t\t\t로그인 성공");
	        	   adminLoginFlag = false;
	        	   
	        	   AdminOutput.selectTypeMenu();
	        	   input = sc.nextLine();
	        	   if (input.equals("1")) {
	        		   AdminMenu.selectAdminMenu();
	        	   } else {
	        		   System.out.println("\t\t\t\t\t\t잘못 입력하셨습니다.");
	        	   }
	        	   
	        	   //관리자 메뉴
		          		           
		           
		        } else {
		           System.out.println("\t\t\t\t\t\t\t관리자 번호가 틀렸습니다.");
		           adminLoginFlag = false;
		        }
		
		}
	}
}
