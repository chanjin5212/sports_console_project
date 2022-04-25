package com.project.sports.user;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Record;
import com.project.sports.input.RelativeRecord;
import com.project.sports.input.Schedule;
import com.project.sports.input.Team;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.mypage.MypageMenu;
import com.project.sports.output.Output;
import com.project.sports.user.community.Community;
import com.project.sports.user.infoMenu.InfoMenu;
import com.project.sports.user.predict.PredictFunction;
import com.project.sports.user.predict.PredictMenu;
import com.project.sports.user.rank.RankMenu;
import com.project.sports.user.ticketingmenu.TicketingMenu;

public class UserFunction {

	/**
	 * 로그인 성공 후 사용자에게 보여지는 메뉴화면의 클래스
	 * @author 서주예
	 */
	public static boolean successFlag = true;

	/**
	 * 로그인 성공 후 마이페이지/종목선택하기의 메뉴가 보여주고 응답을 받는 메소드
	 */
	public static void loginSuccessMenu() {
		
		Scanner sc = new Scanner(System.in);
		
        while(successFlag) { //로그인 성공시 메뉴 출력 및 선택
     	   Output.typeMenu(); //마이페이지/종목선택하기
	           String input = sc.nextLine(); //메뉴 입력받기
	  
	           if(input.equals("1")){ //마이페이지
	        	   
	        	   MypageMenu.myPageMenuFlag = true;
	        	   MypageMenu.myPageMenu();
	        	   
	           } else if(input.equals("2")) { //종목선택하기
	        	   typeSelectMenu();
		        	   
		        	   
		        	   
	           } else if(input.equals("0")) {
	        	   successFlag = false;
	           } else { //유효성 검사
	        	   
	           }
        }
		
	}
	
	/**
	 * 사용자가 종목선택하기를 선택한 경우 종목 메뉴가 출력되는 메소드
	 */
	public static void typeSelectMenu() {
		Scanner sc = new Scanner(System.in);
		boolean typeSelectMenuFlag = true;
		while(typeSelectMenuFlag) {
			Output.selectTypeMenu();
			String input = sc.nextLine();
			
			if(input.equals("0")) {
				break;
			}
			
			if(input.equals("1")) { //야구선택
				
				mainMenu();
				
			} else if(input.equals("2")) { //축구
				
			} else if (input.equals("3")) { //농구
				
			} else if(input.equals("4")) { //배구
				
			} else if(input.equals("0")) {
				typeSelectMenuFlag = false;
			} else { //유효성
				
			}
		}
		}
	
	/**
	 * 종목선택 후 메인메뉴가 출력되는 메소드
	 */
	public static void mainMenu() {
		
		Scanner sc = new Scanner(System.in);
		boolean menuFlag = true;
		while(menuFlag) { 
			
			realTimeRank();
			bigMatch();
			Output.mainMenu(); //메인메뉴 선택
			String input = sc.nextLine();
			
			if(input.equals("1")) { //정보
				InfoMenu.selectInfo();
			} else if(input.equals("2")) { //일정 
				ScheduleMenu.scheduleFuction();
			} else if(input.equals("3")) { //순위
				RankMenu.rankMenu();
			} else if(input.equals("4")) { //예매
				TicketingMenu.userTicketingFlag = true;
				TicketingMenu.UserTicketing();
			} else if(input.equals("5")) { //승부예측
				PredictFunction.predictFunctionFlag = true;
				PredictMenu.selectPredictMenu();
			} else if(input.equals("6")) { //커뮤니티
				Community.communityMenu();
			} else if(input.equals("0")){
				menuFlag = false;
			} else {
				System.out.println("오류");
				
			}
		}
		
	}

	/**
	 * 오늘의 빅매치를 출력하는 메소드
	 * 산출방식은 상대전적 차이가 적고, 순위가 높을 팀
	 */
	private static void bigMatch() {
		
		
		Calendar c = Calendar.getInstance();
		String today = String.format("%tF", c);
		RelativeRecord team1 = null;
		Record score = null;
		Schedule asd = null;
		for (Schedule s : Data.scheduleList) {
			
			if (String.format("%tF", s.getDate()).equals(today)) {
				
				for (RelativeRecord r : Data.relativeRecordList) {
					
					for (Record d : r.getList()) {
						
						int a = Math.abs(d.getWin() - d.getLose());
						
						if (score == null) {
							team1 = r;
							score = d;
							asd = s;
						} else if (Math.abs(d.getWin() - d.getLose()) > a) {
							team1 = r;
							score = d;
							asd = s;
						}
						
					}
					
				}
				
			}
			
		}
		System.out.println("\t\t\t\t\t\t  [오늘의 빅매치]");
		System.out.printf("\t\t\t\t★★★★★★★%s : %s  상대전적 %d : %d★★★★★★★★\n"
				, asd.getTeam1()
				, asd.getTeam2()
				, score.getWin()
				, score.getLose());
		System.out.println();
		
	}

	/**
	 * 실시간 순위(TOP3)가 출력되는 메소드
	 */
	private static void realTimeRank() {
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		sb.append("\t\t\t\t\t\t  [실시간 순위]\n");
		sb.append("\t\t=============================================================================================\n");
		sb.append("\t\t[순위]\t\t[팀]\t\t\t[경기]\t\t[승]\t\t[패]\t\t[승률]\n");
		sb.append("\t\t=============================================================================================\n");
			
		Data.teamList.sort(new Comparator<Team>() {

			@Override
			public int compare(Team t1, Team t2) {
				
				Double t1WinRate = t1.getWin() / (double)(t1.getWin() + t1.getLose()); 
				Double t2WinRate = t2.getWin() / (double)(t2.getWin() + t2.getLose());
				
				return t2WinRate.compareTo(t1WinRate);
			} 

		});
			
		int rank = 1;
		
		for (int i = 0 ; i < Data.teamList.size() ; i ++) {
		
			if (Data.teamList.get(i).getYear() == year) {
			Team t = Data.teamList.get(i);
				
				sb.append(String.format("\t\t%d\t\t%-10s\t\t%d\t\t%d\t\t%d\t\t%-5.3f\n"
						, rank++
						, t.getTeamName()
						, t.getWin() + t.getLose()
						, t.getWin() 
						, t.getLose()
						, t.getWin() / (double)(t.getWin() + t.getLose())));
				
				if (rank == 4) {
					sb.append("\t\t---------------------------------------------------------------------------------------------\n");
					break;
				}
			}
				
		}
		
		System.out.println(sb);
	}
	
	

}
