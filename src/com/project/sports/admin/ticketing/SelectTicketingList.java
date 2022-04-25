package com.project.sports.admin.ticketing;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.input.Schedule;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 예매내역 확인 메뉴 클래스입니다.
 * @author 강지윤
 *
 */
public class SelectTicketingList {

	//예매내역 클래스
	//예매내역 확인을 선택했을 때
	/**
	 * 예매내역 확인 메뉴와 경기일정 리스트를 출력합니다.
	 */
	public static void selectTicketingList() {
		
		
		
		//제일 처음 예매 내역 리스트 나옴

		Scanner sc = new Scanner(System.in);
		boolean selectTListFlag = true;
		while(selectTListFlag) {	//예매내역 확인 메뉴 눌렀을때
			
			
			boolean gameListFlag = true;
			while(gameListFlag) {	//경기일정 페이지가 나옴
				ArrayList<String> gameList = new ArrayList<String>();
			
			
	
				for (Schedule s : Data.scheduleList) {
					
					//[경기seq][경기][날짜][시간][경기장]
					
						//gameSeq += 1;
						gameList.add(String.format("\t\t\t  %d\t%-8s vs %-8s    \t%-10tF    %s    %-12s\n",
																	s.getSeq(),
																	s.getTeam1(),
																	s.getTeam2(),
																	s.getDate(),
																	s.getTime(),
																	s.getPlace()));
				
				} //for
				
				for (int i=0; i<(gameList.size()/10)+1;) {
					
					System.out.println();
					System.out.println("\t\t\t===============================================================================");
					System.out.println("\t\t\t 번호\t\t경기\t\t\t   날짜         시간\t   경기장");
					System.out.println("\t\t\t===============================================================================");
					for (int j=0+i*10; j<10+i*10; j++) {
						if (j>=gameList.size()) {
							break;
						}
						System.out.print(gameList.get(j)); //10줄씩 출력
						
					}
					
					System.out.println("\t\t\t------------------------------------------------------------------------------");
					System.out.println("\t\t\t\t\t\t< 이전 페이지 \t\t 다음 페이지 >");
					System.out.println();
					AdminOutput.ticketListMenu();
					
					String input = sc.nextLine(); //
					if (input.equals(">")) {
						if(i == gameList.size()/10) {
							System.out.println("마지막 페이지입니다.");
							System.out.println("다시 입력하시려면 엔터(Enter)를 누르세요.");
							input = sc.nextLine();
						} else {
							i++;
						}
					} else if(input.equals("<")) {
						if(i==0) {
							System.out.println("이전 페이지가 없습니다.");
							System.out.println("다시 입력하시려면 엔터(Enter)를 누르세요.");
							input = sc.nextLine();
						} else {
							i--;
						}
					} else if(input.equals("0")) {
						Output.backMsg();
						gameListFlag = false;
						selectTListFlag = false;
						return;
						
					} else if(input.equals("1")) { //예매내역 확인을 하고싶은 경기 번호 고르기
						//예매 내역 상세보기
						GameDetail.gameDetail();	//고른 경기번호의 일정을 한번 더 출력하고 그 경기의 예매내역 출력
						
					} else if(input.equals("2")) {
						//아이디 검색
						TicketingListId.idSearch();
						
						
					} else if(input.equals("3")) {
						//날짜 검색
						TicketingListDate.dateSearch();
						
					} else if(input.equals("")) {
						
						System.out.println("내용을 입력해주세요.");
						Output.pause();
						
					}	else {
						System.out.println("올바른 번호를 입력해주세요.");
						Output.pause();
					}
				}
			
				
			
			
		}//작은 while
			
			/*
			if(input.equals("1")) { //1. 예매 내역 상세 보기
				
				//예매내역 상세보기 메소드
				System.out.println("경기 번호 입력 : ");
				GameDetail.gameDetail();
				
			
			} else if(input.equals("0")){
			
			Output.backMsg();
			Output.pause();
			selectTListFlag = false;
			return;
			
			} else { //유효성검사
				System.out.println("올바른 번호를 입력해주세요.");
				
			}
			*/
		
		}
	
	}

	
}
