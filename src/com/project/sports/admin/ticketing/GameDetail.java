package com.project.sports.admin.ticketing;

import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 예매내역 상세보기 클래스입니다.
 * @author 강지윤
 *
 */
public class GameDetail {
	/**
	 * 전체 경기 일정을 출력하고 사용자가 선택한 경기의 예매내역을 출력합니다.
	 */
	public static void gameDetail() {
		
		
		Scanner sc = new Scanner(System.in);
		boolean gameDetailFlag = true;
		int gameSeq = 0;
		int ticketingSeq = 0;

		while(gameDetailFlag) {	//예매 확인 - 경기 예매내역 상세보기를 눌렀을때
				//번호\t\t
				//%d\t
			
			
			
			
				AdminOutput.ticketListDetail(); //경기번호 고르라는 메세지와 입력창
				String input = sc.nextLine(); // 경기번호 입력받기
				
				boolean hasGame = false;
		
				for (Schedule s : Data.scheduleList) {
					
					if (input.equals(Integer.toString(s.getSeq()))) { //입력받은 경기번호와 같은 경기일정 출력
						gameSeq += 1;
						hasGame = true;
						System.out.println("\t\t\t\t  ===============================================================");
						System.out.println("\t\t\t\t\t   경기\t\t\t날짜\t    시간\t    경기장");
						System.out.println("\t\t\t\t  ===============================================================");
						System.out.printf("\t\t\t\t%9s vs %-9s   %-10tF    %s   %-10s\n", 
								//gameSeq,
								s.getTeam1(),
								s.getTeam2(),
								s.getDate(),
								s.getTime(),
								s.getPlace());
						
						System.out.println();
						
						
						
					}
				}
				
				
				//그 경기일정을 예매한 사람 내역 출력 + 예매한 사람이 없으면 "예매한 회원이 없습니다" 출력
				//37, 35, 38, 29 경기
				
				boolean ticketingUser = false;
				
				
				for (Ticketing t : Data.ticketingList) {
					//[seq][이름][아이디][예매좌석]
					if (input.equals(Integer.toString(t.getScheduleSeq()))) {
						ticketingUser = true; //그 경기를 예매한 사람이 있으면
						ticketingSeq += 1;
						String ticketId = t.getId(); //예매한 아이디 저장
						String ticketName = "";
						
						
						
						for (User u : Data.userList) {
							
							if (ticketId.equals(u.getId())) {
								ticketName = u.getName();
								
							}
							
						}
						
						
						System.out.println();
						System.out.println("\t\t\t\t          =============================================");
						System.out.println("\t\t\t\t\t     번호      이름\t   아이디\t\t 예매좌석");
						System.out.println("\t\t\t\t          =============================================");
						System.out.printf("\t\t\t\t\t     %d       %s\t%-16s %s %s\n",
											ticketingSeq,
											ticketName,
											t.getId(),
											t.getBlock(),
											t.getSeatNum());
					} 
					
				}
				
				System.out.println();
				
				if(input.equals("")){
					
					System.out.println("\t\t\t\t\t\t 내용을 입력해주세요.");
					System.out.println();
					
				} else if(input.equals("0")) {
					
					Output.backMsg();
					gameDetailFlag = false;
					
				} else if (hasGame == false) { //입력한 경기번호와 일치하는 경기가 없는경우
					System.out.println("\t\t\t\t\t\t 해당 경기가 존재하지 않습니다.");
					System.out.println();
				}
				
				
				if (ticketingUser == false) {		//그 경기를 예매한 사람이 없으면
					if (!input.equals("0")) {		//근데 0을 누르지 않았을때 (뒤로가기를 누르면 이 출력문 안나옴)
						if (hasGame == true) {		//입력한 경기가 경기일정리스트와 일치할때만!
							System.out.println();
							System.out.println("\t\t\t\t\t\t 해당 경기를 예매한 회원이 없습니다.");
							System.out.println();
						}	
					}
				}
				
				Output.pause();
				
		
		}
		
		
		
		
	}
}
