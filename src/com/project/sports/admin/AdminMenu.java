package com.project.sports.admin;

import java.util.Scanner;
import com.project.sports.admin.bannedword.AdminBannedWord;
import com.project.sports.admin.teamPlayer.TeamPlayer;
import com.project.sports.admin.ticketing.AdminTicketing;
import com.project.sports.admin.userinfo.ManageUser;
import com.project.sports.output.Output;
import com.project.sports.user.community.Community;

/**
 * 관리자 메뉴 클래스입니다.
 * @author 강지윤
 *
 */
public class AdminMenu {
	/**
	 * 관리자 메뉴를 출력하고 사용자가 선택한 메뉴로 이동합니다.
	 */
	public static void selectAdminMenu() {
		
	Scanner sc = new Scanner(System.in);
	boolean AdminMenuFlag = true;
	
	while(AdminMenuFlag) {	//관리자 로그인 성공시 
			
			//관리자 메뉴 보여주기
			AdminOutput.AdminMenu();
			
			String input = sc.nextLine(); // 관리자 메뉴 번호 입력받기
	
			if(input.equals("1")) { //1. 팀/선수 정보관리
				
				TeamPlayer.teamPlyaer();
				
			} else if(input.equals("2")) { //2.회원 관리
				ManageUser.mFlag = true;
				ManageUser.manageUserMain();
				
			} else if(input.equals("3")) { //3. 예매 관리
				
				AdminTicketing.adminTicketing(); //예매 관리 메뉴로
				
			} else if(input.equals("4")) { //4. 경기 관리
				
				AdminSchedule.adminSchedule();
				
			} else if (input.equals("5")) { //5. 커뮤니티 관리
				
				while (true) {
					
					AdminOutput.commubityorBannedWord();
					input = sc.nextLine();
					if (input.equals("1")) {
						Community.communityMenu();					
					} else if (input.equals("2")) {
						AdminBannedWord.bannedWord();
					} else if (input.equals("0")) {
						break;
					} else {
						System.out.println("잘못 입력하셨습니다.");
					}
				}
				
			} else if(input.equals("0")){
				
				Output.backMsg();
				AdminMenuFlag = false;
				
			} else { //유효성검사
				
			}
		}
	}
	
}
	
	
	

