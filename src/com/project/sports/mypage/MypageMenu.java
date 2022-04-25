package com.project.sports.mypage;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.MyTeam;
import com.project.sports.input.Player;
import com.project.sports.input.Schedule;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.user.Output;
import com.project.sports.user.UserLogin;

/**
 * 마이페이지 메뉴와 마이팀을 볼 수 있는 클래스 입니다.
 * @author 김찬진
 *
 */
public class MypageMenu {
	
	public static int select;
	public static boolean myTeamTypeFlag = true;
	public static boolean myPageMenuFlag = true;
	
	/**
	 * 마이페이지 메뉴를 보여주는 메소드 입니다.
	 */
	public static void myPageMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(myPageMenuFlag) {
			Output.myPageMenu();
			String input = sc.nextLine();
			if (input.equals("1")) {
				MyInfo.MyInfoMenu();
			} else if (input.equals("2")) {
				myTeam();
			} else if (input.equals("0")) {
				break;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
			
		}
		
	}

	/**
	 * 마이팀을 볼 수 있는 메소드 입니다.
	 */
	public static void myTeam() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			ArrayList<String> teamList = new ArrayList<String>();
			System.out.println();
			int a = 1;
			
			System.out.println("\t\t\t\t\t  ===================================");
			System.out.println("\t\t\t\t\t  [번호]		[마이팀]		[종목]");
			System.out.println("\t\t\t\t\t  ===================================");
			for (MyTeam m : Data.myTeamList) {
				if (m.getId().equals(UserLogin.userData.getId())) {
					System.out.printf("\t\t\t\t\t  %d		%s	%s\n", a, m.getTeamName(), m.getType());	
					teamList.add(m.getTeamName());
					a++;
				}
				
			}
			System.out.println("\t\t\t\t\t  ------------------------------------");
			Output.myPageMyTeam();
			String input = sc.nextLine();
			if (input.equals("1")) {
				if (teamList.size() == 0) {
					System.out.println("\t\t\t\t\t선택하신 팀이 없습니다.");
				} else {
					myTeamSearch();					
				}
			} else if (input.equals("2")) {
				myTeamTypeFlag = true;
				myTeamType();
				
			} else if (input.equals("3")) {
				myTeamDelete();
			} else if (input.equals("0")) {
				break;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
		}
	}

	//넘기기 기능
	/**
	 * 마이팀을 검색하는 메소드 입니다.
	 */
	public static void myTeamSearch() {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("\t\t\t\t\t     My Team 번호 (0.뒤로가기) :");
			String input = sc.nextLine();
			select = Integer.parseInt(input)-1;
			if (input.equals("0")) {
				return;
			}
			System.out.println();
			
			ArrayList<String> teamList = new ArrayList<String>();
			for (MyTeam m : Data.myTeamList) {
				if (m.getId().equals(UserLogin.userData.getId())) {
					teamList.add(m.getTeamName());
				}
			}
			
			ArrayList<String> scList = new ArrayList<String>();//한줄씩 리스트에 저장
			
			for (Schedule s : Data.scheduleList) { //리스트에 저장할 한줄씩 받아오는 반복문
				
				if (teamList.get(Integer.parseInt(input)-1).equals(s.getTeam1())
						|| teamList.get(Integer.parseInt(input)-1).equals(s.getTeam2())) {
					
					Calendar today = Calendar.getInstance();
					Calendar c = Calendar.getInstance();
					c.add(Calendar.DATE, -7);
					if (s.getDate().compareTo(c) > 0) {
						if (s.getDate().compareTo(today) < 0) {
							
							scList.add(String.format("\t\t\t\t%tF\t%s %d:%d %s		%s"
									, s.getDate()
									, s.getTeam1()
									, s.getTeam1Score()
									, s.getTeam2Score()
									, s.getTeam2()
									, s.getPlace()));
							
						} else {
							scList.add(String.format("\t\t\t\t%tF\t%s vs %s		%s"
									, s.getDate()
									, s.getTeam1()
									, s.getTeam2()
									, s.getPlace()));	
						}		
					}
					
				}
				
				
			}
			//10개씩 페이지를 해서 i<=리스트.size()/10 를 하거나 i<(리스트.size/10)+1 까지 i 범위를 정한다.
			for (int i=0; i<(scList.size()/10)+1;) { 
				System.out.println("\t\t\t\t==============================================================");
				System.out.println("\t\t\t\t[경기 날짜]		[경기팀]			[경기장]");
				System.out.println("\t\t\t\t==============================================================");
				//첫번째 페이지면 j가0~9 2번째 페이지면 j가 10~19 이런식으로 출력
				for (int j=0+i*10; j<10+i*10; j++) { 
					if (j>=scList.size()) { //j가 리스트보다 크면 에러나기 때문에 >=일때 종료
						break;
					}
					System.out.println(scList.get(j));
				}
				System.out.printf("\t\t\t\t[%d페이지]\n", i+1);
				System.out.println("\t\t\t\t--------------------------------------------------------------");
				Output.myPagePlayer();
				input = sc.nextLine();
				if (input.equals(">")) {
					if (i == scList.size()/10) { //마지막 페이지인지 확인하는 if문
						System.out.println("\t\t\t\t\t마지막 페이지 입니다.");
						System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
						input = sc.nextLine();
					} else { //마지막 페이지가 아니면 i++를 해줘서 다음 페이지
						i++;
					}
				} else if (input.equals("<")) { 
					if (i == 0) { //첫페이지인지 확인하는 if문
						System.out.println("\t\t\t\t\t이전 페이지가 없습니다.");
						System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
						input = sc.nextLine();
					} else { //첫페이지가 아니면 i-- 해줘서 이전 페이지
						i--;
					}
				} else if (input.equals("1")) {
					playerList();
					break;
				} else if (input.equals("0")) {
					return;
				} else {
					System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
				}
				
				
				
			}
			
		} catch (Exception e) {
			System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
			Scanner sc = new Scanner(System.in);
			String a = sc.nextLine();
		}
		
			
	}
	
	/**
	 * 마이팀의 선수 목록을 보여주는 메소드입니다.
	 */
	private static void playerList() {
		int a = 0;
		ArrayList<String> teamList = new ArrayList<String>();
		for (MyTeam m : Data.myTeamList) {
			if (m.getId().equals(UserLogin.userData.getId())) {
				teamList.add(m.getTeamName());
			}
		}
		for (YearTeam y : Data.yearTeamList) {
			if (y.getTeamName().equals(teamList.get(select))) {
				a = y.getSeq();
			}
		}
		Calendar c = Calendar.getInstance();
		System.out.println("\t\t\t\t\t\t========================");
		System.out.println("\t\t\t\t\t\t[선수번호]	[포지션]	[선수이름]");
		System.out.println("\t\t\t\t\t\t========================");
		for (Player p : Data.playerList) {
			if (c.get(Calendar.YEAR) == Integer.parseInt(p.getYear()) && a == p.getTeamSeq()) {
				System.out.printf("\t\t\t\t\t\t%s	%s	%s\n", p.getPlayerNum(), p.getPosition(), p.getName());
			}
		}
		System.out.println("\t\t\t\t\t\t------------------------");
		System.out.println("\t\t\t\t\t계속 하시려면 엔터(Enter)를 누르세요.");
		Scanner sc = new Scanner(System.in);
		String b = sc.nextLine();
		
	}
	
	/**
	 * 마이팀 종목을 선택하는 메소드 입니다.
	 */
	private static void myTeamType() {
		
		Scanner sc = new Scanner(System.in);
		
		while (myTeamTypeFlag) {
			com.project.sports.output.Output.selectTypeMenu();
			String input = sc.nextLine();
			if (input.equals("1")) {
				myTeamAdd(input);
			} else if (input.equals("0")) {
				return;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}	
		}
		
	}
	
	/**
	 * 마이팀을 추가하는 메소드 입니다.
	 * @param input 선택한 마이팀의 번호를 저장하는 변수 입니다.
	 */
	private static void myTeamAdd(String input) {
		
		ArrayList<YearTeam> team = new ArrayList<YearTeam>();
		
		if (input.equals("1")) {
			int a = 1;
			System.out.println("\t\t\t\t\t\t==================");
			System.out.println("\t\t\t\t\t\t[번호]	[팀이름]");
			System.out.println("\t\t\t\t\t\t==================");
			for (YearTeam y : Data.yearTeamList) {
				if (y.getType().equals("야구")) {
					System.out.printf("\t\t\t\t\t\t%d	%s\n", a, y.getTeamName());
					team.add(y);
				}
				a++;
			}
			System.out.println("\t\t\t\t\t\t------------------");
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t\t\t\t팀 번호 (0.뒤로가기) :");
		String input1 = sc.nextLine();
		MyTeam result = null;
		for (MyTeam m : Data.myTeamList) {
			if (m.getId().equals(UserLogin.userData.getId()) 
					&& team.get(Integer.parseInt(input1)-1).getTeamName().equals(m.getTeamName())) {
				result = m;
			}
		}
		
		if (result != null) {
			System.out.println("\t\t\t\t\t이미 추가된 마이팀 입니다.");
			System.out.println("\t\t\t\t\t계속 하시려면 엔터(Enter)를 누르세요.");
			String a1 = sc.nextLine();
		} else {
			System.out.printf("\t\t\t\t\t%s를 마이팀으로 추가할까요? (Y/N) :", team.get(Integer.parseInt(input1)-1).getTeamName());
			String in = sc.nextLine();
			in.toLowerCase();
			if (in.equals("y")) {
				System.out.printf("\t\t\t\t\t%s를 마이팀으로 추가했습니다.\n", team.get(Integer.parseInt(input1)-1).getTeamName());
				int num = Data.myTeamList.get(Data.myTeamList.size()-1).getSeq();
				
				MyTeam m = new MyTeam(num+1, 
						UserLogin.userData.getId()
						, team.get(Integer.parseInt(input1)-1).getSeq()
						, team.get(Integer.parseInt(input1)-1).getTeamName()
						, "야구");
				Data.myTeamList.add(m);
				System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
				in = sc.nextLine();
				myTeamTypeFlag = false;
				return;
			} else if (in.equals("n")) {
				System.out.println("\t\t\t\t\t취소하셨습니다.");
				System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
				in = sc.nextLine();
				myTeamTypeFlag = false;
				return;
			}
			
		}
		
		
		
	}
	
	/**
	 * 마이팀을 제거하는 메소드 입니다.
	 */
	public static void myTeamDelete() {
		
		ArrayList<String> teamList = new ArrayList<String>();
		for (MyTeam m : Data.myTeamList) {
			if (m.getId().equals(UserLogin.userData.getId())) {
				teamList.add(m.getTeamName());
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t\t\t삭제할 마이팀 번호 (0.뒤로가기) :");
		String number = sc.nextLine();
		if (number.equals("0")) {
			return;
		} else if (Integer.parseInt(number) > teamList.size()) {
			System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			return;
		}
		
		System.out.printf("\t\t\t\t\t%s을 마이팀에서 삭제할까요? (Y/N) : ", teamList.get(Integer.parseInt(number)-1));
		String input1 = sc.nextLine();
		input1.toLowerCase();
		if (input1.equals("y")) {
			System.out.printf("\t\t\t\t\t%s를 마이팀에서 삭제했습니다.\n", teamList.get(Integer.parseInt(number)-1));
			MyTeam a = null;
			for (MyTeam m : Data.myTeamList) {
				if (m.getId().equals(UserLogin.userData.getId()) && m.getTeamName().equals(teamList.get(Integer.parseInt(number)-1))) {
					a = m;
				}
			}
			Data.myTeamList.remove(a);
			System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
			number = sc.nextLine();
		} else if (input1.equals("n")) {
			return;
		}
		
		System.out.println();
		
	}
		
}















