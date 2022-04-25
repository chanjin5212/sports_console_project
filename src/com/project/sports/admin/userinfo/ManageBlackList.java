package com.project.sports.admin.userinfo;

import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.input.BlackList;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 블랙리스트 관리
 * @author 안수아
 *
 */
public class ManageBlackList {
	
	/**
	 * 블랙리스트 관리
	 */
	public static void manageBlackList() { 
		
		Scanner sc = new Scanner(System.in);
		boolean bFlag = true;
		
		while(bFlag) {
			
			printBlackList(); // 블랙 리스트 출력
			
			AdminOutput.AdminBlacklistMenu();
			
			String input = sc.nextLine();
			
			if (input.equals("1")) { // 블랙리스트 회원 상세보기
				blackListDetail();
			} else if (input.equals("2")) { // 블랙리스트 삭제
				deleteBlackList();
			} else if (input.equals("0")) {
				Output.backMsg();
				bFlag = false;
			} else {
				System.out.println("\t\t\t\t\t\t 올바르지 않은 메뉴 번호입니다.\n");
			}
			
		}
	}

	/**
	 * 블랙리스트 출력
	 */
	public static void printBlackList() { 
		
		StringBuilder sb = new StringBuilder("\t\t\t\t===========================================================\n");
		sb.append("\t\t\t\t[회원번호]\t\t\t[이름]\t\t\t[아이디]\n");
		sb.append("\t\t\t\t===========================================================\n");
		
		for (BlackList b : Data.blackListList) {
			
			for (User u : Data.userList) {
				
				if (b.getId().equals(u.getId())) {
					sb.append(String.format("\t\t\t\t%d\t\t\t%s\t\t\t%s\n", u.getSeq()
															  , u.getName()
															  , u.getId()));	
				}
				
			}
			
		}
		sb.append("\t\t\t\t-----------------------------------------------------------\n");
		System.out.println(sb);
		
	}
	
	/**
	 * 블랙리스트 상세 보기
	 */
	private static void blackListDetail() {
		
		Scanner sc = new Scanner(System.in);
		boolean bdFlag = true;
		
		while (bdFlag) {
			System.out.print("\t\t\t\t\t\t 회원 번호를 입력하세요. (0. 뒤로가기) : ");
			int input = sc.nextInt();
			
			if (input == 0) {
				Output.backMsg();
				break;
			}
			
			StringBuilder sb = new StringBuilder("\t\t\t\t===========================================================\n");
			sb.append("\t\t\t\t[회원번호]\t\t[이름]\t\t[아이디]\t\t[사유]\n");
			sb.append("\t\t\t\t===========================================================\n");
			
			boolean hasUser = false;
			
			int seq = 0;
			String name = "";
			String id = "";
			String detail = "";
			
			for (BlackList b : Data.blackListList) {
				
				for (User u : Data.userList) {
					
					if (input == u.getSeq() && b.getId().equals(u.getId())) {
						
						hasUser = true;
						
						seq = u.getSeq();
						name = u.getName();
						id = u.getId();
						detail = b.getDetail();
																								
					}
					
				}
				
			}
			
			if (hasUser) {
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%s\t%s\n", seq
														  , name
														  , id
														  , detail));
				sb.append("\t\t\t\t-----------------------------------------------------------\n");
				System.out.println(sb);
				Output.pause();
			} else {
				System.out.println("\t\t\t\t\t\t 올바르지 않은 회원 번호입니다.\n");
			}
			
		}
		
	}
	
	/**
	 * 블랙리스트 삭제
	 */
	private static void deleteBlackList() {
		
		Scanner sc = new Scanner(System.in);
		boolean dbFlag = true;
		
		while (dbFlag) {
			System.out.print("\t\t\t\t\t\t삭제할 회원 번호를 입력하세요. (0. 뒤로가기) : ");
			int input = sc.nextInt();
			
			if (input == 0) {
				Output.backMsg();
				break;
			}
			
			StringBuilder sb = new StringBuilder("\t\t\t\t===========================================================\n");
			sb.append("\t\t\t\t[회원번호]\t\t\t[이름]\t\t\t[아이디]\n");
			sb.append("\t\t\t\t===========================================================\n");
			
			boolean hasUser = false;
			BlackList select = null;
			
			for (BlackList b : Data.blackListList) {
				
				for (User u : Data.userList) {
					
					if (input == u.getSeq() && b.getId().equals(u.getId())) {
						
						hasUser = true;
						select = b;
						sb.append(String.format("\t\t\t\t%d\t\t\t%s\t\t\t%s\n", u.getSeq()
																  , u.getName()
																  , u.getId()));
						
					}
					
				}
				
			}
			
			if (hasUser) {
				
				sb.append("\t\t\t\t-----------------------------------------------------------\n");
				System.out.println(sb);
				
				boolean checkFlag = true;
				
				while(checkFlag) {
					
					System.out.print("\t\t\t\t\t\t삭제할 회원이 맞습니까? (Y/N) : ");
					String checkInput = sc.next();
					checkInput = checkInput.toUpperCase();
					
					if (checkInput.equals("Y")) {
						
						Data.blackListList.remove(select);
						System.out.println("\t\t\t\t\t\t 삭제가 완료되었습니다.\n");
						Output.pause();
						checkFlag = false;
						dbFlag = false;
						
					} else if (checkInput.equals("N")) {
						System.out.println("\t\t\t\t\t\t 삭제가 취소되었습니다.\n");
						break;
					} else {
						System.out.println("\t\t\t\t\t\t Y 또는 N을 입력해주세요.\n");
					}
				}
				
			} else {
				System.out.println("\t\t\t\t\t\t 올바르지 않은 회원 번호입니다.\n");
			}
			
		}
		
	}

}
