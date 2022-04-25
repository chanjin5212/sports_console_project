package com.project.sports.user.ticketingmenu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.output.Output;

/**
 * 예매를 시작하는 클래스입니다.
 * @author 김찬진
 *
 */
public class TicketingMenu {

	public static boolean userTicketingFlag = true;
	
	/**
	 * 예매가 가능한 날짜를 보여주고 입력된 날짜가 가능한지 구분하는 메소드입니다.
	 */
	public static void UserTicketing() {
		Scanner sc = new Scanner(System.in);
		while(userTicketingFlag) { //날짜 선택
			
			Calendar sunDay = Calendar.getInstance();
			Calendar today = Calendar.getInstance();
			
			sunDay.add(Calendar.DATE, -today.get(Calendar.DAY_OF_WEEK) + 1); // 오늘이 포함된 주의 일요일 찾기
			System.out.println();
			System.out.printf("   \t\t\t\t%d년\n", sunDay.get(Calendar.YEAR));
			System.out.println("   \t\t\t\t======================================================");
			System.out.println("   \t\t\t\t[일]	[월]	[화]	[수]	[목]	[금]	[토]"); 
			System.out.println("   \t\t\t\t======================================================");
			
			StringBuilder br = new StringBuilder(); // 일요일 ~ 토요일 날짜 추가
			br.append("   \t\t\t\t");
			int a = 0;
			for (int i=0; i<14; i++) {
				
				if (sunDay.get(Calendar.DATE) == today.get(Calendar.DATE)) {
					a++;
				}
				
				if (a > 0 && a < 8) {
					br.append("*");
					a++;
				}
				
				br.append(String.format("%tF", sunDay).split("-")[1]);
				br.append(".");
				br.append(String.format("%tF", sunDay).split("-")[2]);
				br.append("\t");
				
				if (i == 6) {
					br.append("\n\t\t\t\t");
				}
				
				sunDay.add(Calendar.DATE, 1);
				
			}
			System.out.println(br);
			System.out.println("   \t\t\t\t------------------------------------------------------");
			System.out.println("   \t\t\t\t* 표시된 날짜로 예매가 가능합니다.");
			System.out.println("   \t\t\t\t날짜를 입력시에는 월,일 사이에 \"-\"을 입력해 주세요.\r\n"
					+ "   \t\t\t\t(예시:04-07)");
			System.out.print("   \t\t\t\t\t\t날짜 입력(0.뒤로가기):");
			String input = sc.nextLine();
			
			ArrayList<String> cList = new ArrayList<String>(); //예매 가능한 날짜 추가
			
			for (int i=0; i<7; i++) {
				
				String[] temp = String.format("%tF", today).split("-");
				String possible = temp[1] + "-" + temp[2]; 
				cList.add(possible);
				today.add(Calendar.DATE, 1);
			}
			
			today = Calendar.getInstance();
			if (input.equals("0")) {
				userTicketingFlag = false;
				Output.backMsg();
			} else if (cList.contains(input)) { // 예매 가능한 날짜를 입력
				DateSearch.gameFlag = true;
				DateSearch.game(input);
				
			} else {
				System.out.println("\t\t\t\t\t입력하신 날짜는 예매 불가능한 날짜입니다.");
				System.out.println("\t\t\t\t\t계속 하시려면 엔터(Enter)를 입력하세요.");
				input = sc.nextLine();
				
			}
		}
		
		
	}

}
