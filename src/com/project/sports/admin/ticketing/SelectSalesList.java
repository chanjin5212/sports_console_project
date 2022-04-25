package com.project.sports.admin.ticketing;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.main.Data;

/**
 * 매출 확인 클래스입니다.
 * @author 강지윤
 *
 */
public class SelectSalesList {

	//매출 확인을 선택했을때
	
	/**
	 * 일매출, 월매출, 연매출이 출력됩니다.
	 */
	public static void selectSales () {
		
		//일매출
		//월매출
		//연매출 
		//리스트 나옴
		
		Calendar c = Calendar.getInstance();
		
		
		String today = String.format("%tF", c); //오늘 날짜 string 
		String year = today.substring(0,4);	 //-> 2022-04-12에서 연도('2022')만 빼기
		String month = today.substring(5,7); //-> 2022-04-12에서 월('04')만 빼기
		
		int ticketingSeq = 0; 	//예매 내역에 있는 경기번호를 담을 변수 생성
		int todayCount = 0; 	//오늘 경기 예매 횟수
		int yearCount = 0; 		//이번 연도 경기 예매 횟수
		int monthCount = 0;		//이번 달 경기 예매 횟수
		
		
		for (Ticketing t : Data.ticketingList) {
			
			ticketingSeq = t.getScheduleSeq(); //예매 내역에 있는 경기번호 옮기기
			
			for (Schedule s : Data.scheduleList) {
				
				if (ticketingSeq == s.getSeq()) { //그 경기번호와 일치하는 경기들 중에서 (예매한 경기들 중에서)
					
					
					if(year.equals((String.format("%tF", s.getDate()).substring(0,4)))) { //이번 연도와 같은 연도의 경기 예매 횟수
						
						yearCount += 1; //이번 연도 경기 예매 횟수 카운트
						
					}
					
					if (month.equals((String.format("%tF", s.getDate()).substring(5,7)))) { //이번 달과 같은 달의 경기 예매 횟수
						
						monthCount += 1; //이번 달 경기 예매 횟수 카운트
						
					}
					
					if (today.equals(String.format("%tF", s.getDate()))) { //오늘 예매 횟수
						
						todayCount += 1; //오늘 경기 예매 횟수 카운트
					}
					
				}
				
			}
		}
		
		//매출 : 예매경기횟수 * 10000
		
		
		System.out.println();
		System.out.println();
		System.out.printf("\t\t\t\t\t\t\t 일매출 : %,d원\n", todayCount * 10000);
		System.out.println();
		
		
		System.out.printf("\t\t\t\t\t\t\t 월매출 : %,d원\n", monthCount * 10000);
		System.out.println();
		
		
		System.out.printf("\t\t\t\t\t\t\t 총매출 : %,d원\n", yearCount * 10000);
		System.out.println();
		System.out.println();
		
		//엔터를 누르면 이전으로 돌아가기
		System.out.println("\t\t\t\t\t\t 엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
	    Scanner scanner = new Scanner(System.in);
	    scanner.nextLine();
		
	}
}
