package com.project.sports.admin.teamPlayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.input.Team;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 팀 목록을 출력하는 클래스
 * @author 서주예
 */
public class TeamPlayer {

	public static List<YearTeam> teamList = new ArrayList<YearTeam>(); // 팀 리스트
	public static List<Team> team = new ArrayList<Team>();


	/**
	 * 올해팀을 출력하고 해당 팀을 List에 저장하는 메소드
	 */
	public static void teamPlyaer() {

		Calendar c = Calendar.getInstance();
		teamList = new ArrayList<YearTeam>();
		Scanner sc = new Scanner(System.in);
		boolean teamPlayerFlag = true;
		while (teamPlayerFlag) {

			int listSeq = 1;
			// 팀 목록 나오기
			System.out.println("\t\t\t\t\t\t==========================");
			System.out.println("\t\t\t\t\t\t   번호\t    팀이름");
			System.out.println("\t\t\t\t\t\t==========================");
			
			teamList = new ArrayList<YearTeam>();
			for (YearTeam y : Data.yearTeamList) {//올해팀만 있는 리스트

				

					String line = String.format("\t\t\t\t\t\t    %d\t    %s", listSeq, y.getTeamName());

					
					teamList.add(y); // 조건에 만족하는 팀이 들어가있음

					// 배열에 출력된 팀 = 조건에 맞는 팀 = 리스트에 넣기

					System.out.println(line);
					listSeq++;
				

			}
			System.out.println("\t\t\t\t\t\t--------------------------");
			team = new ArrayList<Team>();
			for(Team t : Data.teamList) {
				
				if(t.getYear() == c.get(Calendar.YEAR)) {
					team.add(t);
				}
			}

			// 상세 메뉴 나오기 -> 나중에 아웃풋으로 빼기
			System.out.println();
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │             1. 팀 선수 보기\t    │");
			System.out.println("\t\t\t\t\t │             2. 팀 등록\t	    │");
			System.out.println("\t\t\t\t\t │             3. 팀 수정\t	    │");
			System.out.println("\t\t\t\t\t │             4. 팀 삭제\t	    │");
			System.out.print("\t\t\t\t\t │\t       ");
			Output.back();
			System.out.print("\t\t    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");

			System.out.print("\t\t\t\t\t\t메뉴 번호 입력 : ");
			// 입력받기 -> 분기
			String input = sc.nextLine();
			System.out.println();

			if (input.equals("1")) {
				SelectTeam.selectTeam();
			} else if (input.equals("2")) {
				AddTeam.addTeam(); // 팀 등록
			} else if (input.equals("3")) {
				// 팀 수정
				UpdateTeam.updateTeam();
			} else if (input.equals("4")) {
				// 팀 삭제
				DeleteTeam.deleteTeam();
			} else if (input.equals("0")) { // 뒤로가기
				Output.backMsg();
				break;
			} else {
				// 유효성 검사
			}

			// 상세메뉴 선택하기

		}

	}



}
