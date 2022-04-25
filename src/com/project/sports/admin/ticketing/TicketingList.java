package com.project.sports.admin.ticketing;


import java.util.Calendar;
import com.project.sports.input.Schedule;
import com.project.sports.main.Data;

public class TicketingList {

	public static void ticketingList() {
		
		//당일 경기 5개 리스트만! 보여주는 클래스 (나중에 삭제 예정***)
		
		Calendar c = Calendar.getInstance(); //오늘 날짜
		c.set(2022, 3, 18);
		String today = String.format("%tF", c);
		int gameSeq = 0;
		
		//System.out.println(today);

		
		System.out.println("번호\t\t경기\t\t\t   날짜\t   시간\t  경기장");
		for (Schedule s : Data.scheduleList) {
			
			//[경기seq]
			
			//[경기][날짜][시간][경기장]
			
			String getDay = String.format("%tF",s.getDate());
			
			if (getDay.equals(today)) {
				
				gameSeq += 1;
				System.out.printf("%d\t%-9s vs %-9s\t%-10tF %s %-12s\n",
															gameSeq,
															s.getTeam1(),
															s.getTeam2(),
															s.getDate(),
															s.getTime(),
															s.getPlace());
			
			} else {
				//System.out.println("날짜 오류");
			}
			
			
		}
		
		System.out.println("\t\t< 이전 페이지 \t\t 다음 페이지 >");
		System.out.println();

		
		
	}
}
