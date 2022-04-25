package com.project.sports.admin.ticketing;

import java.util.Scanner;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 날짜 검색 클래스입니다.
 * @author 강지윤
 *
 */
public class TicketingListDate {
	/**
	 * 사용자가 입력한 날짜의 경기 예매내역을 출력합니다.
	 */
	public static void dateSearch() { //날짜 검색
		
		
		//사용자가 입력받은 날짜를 경기 일정 txt에서 찾아서 있으면 그 경기번호를 가져오고
        //그 경기번호가 예매내역txt에 있으면
        //그 경기번를 예매한 사람들 내역 출력
		
		
		Scanner sc = new Scanner(System.in);
		boolean dateSearchFlag = true;
		
		while(dateSearchFlag) {	//예매 내역 확인에서 날짜 검색을 선택했을 때
			
				System.out.println("\t\t\t\t ┌──────────────────────────────────────────────────────────────┐");
				System.out.println("\t\t\t\t │\t예매내역을 확인할 경기의 날짜를 검색해주세요. (0. 뒤로가기)\t	│");
				System.out.println("\t\t\t\t │\t날짜를 \\\"-\\\"로 구분하여 입력해주세요. (예시 : 04-08)\t	│");
				System.out.println("\t\t\t\t └──────────────────────────────────────────────────────────────┘");
				System.out.print("\t\t\t\t\t\t\t 날짜 입력 : ");
			

				String input = sc.nextLine(); // 날짜 입력받기
				//날짜 입력시 유효성 검사는 안함(04-01형식을 지키지 않아도 진행됨.)
				
				
				Boolean hasGame = false; //해당 날짜의 경기가 존재하는지
				Boolean hasTicketing = false; //해당 날짜의 예매가 존재하는지

			
				int ticketingSeq = 0;
				
				String getDate = "";
				int gameNum = 0;
				
				
				String inputFull = ""; //날짜 full
				
				inputFull = String.format("%s%s", "2022-",input); //"2022-" + 입력날짜(mm-dd) 
			
				
				for (Schedule s : Data.scheduleList) {
					
					getDate = String.format("%tF", s.getDate()); //경기 목록의 날짜를 getDate에 저장
					
					if (inputFull.equals(getDate)) { //경기목록 txt에서 입력한 날짜와 같은 날짜가 있으면
						
						hasGame = true;
						gameNum = s.getSeq(); //그 날짜의 경기번호를 gameNum에 저장
						
					
						for (Ticketing t : Data.ticketingList) {
							
							
							if(gameNum == t.getScheduleSeq()) {
								
								hasTicketing = true;
								ticketingSeq += 1;
								
								//예매내역 출력
								//번호(단순seq), 아이디, 경기(경기번호), 구역, 좌석
								
								//경기번호를 -> 경기 일정으로 출력 (경기 경기/ 시간 / 경기장 )
								// 경기 경기 날짜 시간 경기장
								//번호 아이디 구역 좌석
								
								System.out.println();
								
								System.out.println("\t\t\t\t\t===================================================");
								System.out.println("\t\t\t\t\t\t     경기\t    \t\t  시간\t    경기장");
								System.out.println("\t\t\t\t\t===================================================");
								System.out.printf("\t\t\t\t\t %-9s vs   %-9s   %s   %s", 
																		s.getTeam1(),
																		s.getTeam2(),
																		s.getTime(),
																		s.getPlace());
								System.out.println();
								System.out.println();
								System.out.println("\t\t\t\t\t\t==================================");
								System.out.println("\t\t\t\t\t\t 번호  \t아이디\t\t구역  좌석");
								System.out.println("\t\t\t\t\t\t==================================");
								System.out.printf("\t\t\t\t\t\t  %d\t%-16s%s  %s", 
																		ticketingSeq,
																		t.getId(),
																		t.getBlock(),
																		t.getSeatNum());
								System.out.println();
								
								System.out.println("\t\t\t\t\t\t----------------------------------");
								
								System.out.println();
								
							} 
							
						}
						
					
				}
					
					
				}	
				
				
				
				
				if(input.equals("")){
					System.out.println();
					System.out.println("\t\t\t\t\t\t      내용을 입력해주세요.");
					System.out.println();
					
				} else if(input.equals("0")) {
					
					Output.backMsg();
					dateSearchFlag = false;
					
				} else if (hasGame == false) {
					System.out.println();
					System.out.println("\t\t\t\t\t\t  해당 날짜의 경기가 존재하지 않습니다.");
					System.out.println();
					Output.pause();
					
				} else if (hasTicketing == false) { //예매내역이 존재하지 않으면
					System.out.println();
					System.out.println("\t\t\t\t\t\t  예매 내역이 존재하지 않습니다.");
					System.out.println();
					Output.pause();
				} else {
					System.out.println();
					Output.pause();
				}
		
				
		}
		
	}
}
