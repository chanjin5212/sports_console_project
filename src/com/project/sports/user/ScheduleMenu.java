package com.project.sports.user;

import java.util.Calendar;
import java.util.Scanner;

import com.project.sports.input.Record;
import com.project.sports.input.RelativeRecord;
import com.project.sports.input.Schedule;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
/**
 * 경기 일정 클래스
 * @author 김유정
 *
 */
public class ScheduleMenu {
	/**
	 * 경기 일정 출력
	 */
	public static void scheduleFuction() {
		System.out.println();
		Calendar c = Calendar.getInstance();
		
		while (true) {
			System.out.printf("\t\t[%tF 경기]\n", c);
			String c1 = String.format("%tF", c);
			System.out.println("\t\t====================================================================================");
			System.out.println("\t\t[팀]\t\t\t\t[선발]\t\t [경기장]\t\t [시간]\t[상대전적]\t[날씨]");
			System.out.println("\t\t====================================================================================");
			for (Schedule s : Data.scheduleList) {
				
				int team1Num = 0;
				int team2Num = 0;
				
				if (c1.equals(String.format("%tF", s.getDate()))) {
					
					for (YearTeam y : Data.yearTeamList) {
						if (y.getTeamName().equals(s.getTeam1())) {
							team1Num = y.getSeq();
						} else if (y.getTeamName().equals(s.getTeam2())) {
							team2Num = y.getSeq();
						}
					}
					
					for (RelativeRecord r : Data.relativeRecordList) {
						
						if (r.getSeq() == team1Num) {
							
							for (Record d : r.getList()) {
								
								if (d.getTeamSeq() == team2Num) {
									
									System.out.printf("\t\t%s vs %s\t\t%s vs %s\t %s\t %s\t%d승 %d패\t%s\n"
											, s.getTeam1()
											, s.getTeam2()
											, s.getStarting1()
											, s.getStarting2()
											, s.getPlace()
											, s.getTime()
											, d.getWin()
											, d.getLose()
											, s.getWeather());
									
								}
							}
							
						}
						
						
						
					}
					
				}
				
				
				
			}
			System.out.println("\t\t------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t <이전 경기                    다음 경기>");
			System.out.println();
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │	   페이지 변경 <,> 입력	    │");
			System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			System.out.print("\t\t\t\t\t\t메뉴 번호 입력:");
			
			Scanner sc = new Scanner(System.in);
			String in = sc.nextLine();
			System.out.println();
			if (in.equals(">")) {
				c.add(Calendar.DATE, 1);
			} else if (in.equals("<")) {
				c.add(Calendar.DATE, -1);
			} else if (in.equals("0")) {
				break;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
			
		}

		
	}
}


