package com.project.sports.user;

import java.util.Scanner;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

public class UserLogin {
	/**
	 * 사용자가 로그인을 진행하는 클래스
	 * @author 서주예
	 */
	public static User userData;
	
	/**
	 * 아이디, 비밀번호를 입력받고 데이터 파일의 유저 정보와 비교하는 메소드
	 */
	public void loginInfo() {
		Scanner sc = new Scanner(System.in);
		boolean idFlag = true;
		
		while(idFlag) { //아이디 확인
			System.out.println();
			System.out.print("\t\t\t\t\t\t    아이디 : ");
			String id = sc.nextLine(); //아이디 입력받기
			if(id.equals("0")) {
				break;
			}
			
			boolean passwordFlag = true;
			while(passwordFlag) {
				System.out.print("\t\t\t\t\t\t   비밀번호 : ");
				String password = sc.nextLine(); //비밀번호 입력받기
				
				
				if(password.equals("0")) {
					break;
				}
				
				User result = null;
		        
		        for (User s : Data.userList) { //데이터파일과 유저 정보 비교
		           
		           if (s.getId().equals(id) && s.getPassword().equals(password)) {
		              result = s;
		              userData = s;
		              break;
		           }
		        }
		        
		        if (result != null) { //데이터파일에 유저 정보가 있는 경우
		           
		           System.out.println("\t\t\t\t\t\t     로그인 성공");
	        	   passwordFlag = false;
	        	   idFlag = false;
	        	   UserFunction.successFlag = true;
	        	   UserFunction.loginSuccessMenu();
	        	   
		           
		        } else {
		           System.out.println("\t\t\t\t\t     아이디 혹은 비밀번호가 다릅니다.");
		           passwordFlag = false;
		        }
			}
			}
			
		
	}//loginInfo
	
}

