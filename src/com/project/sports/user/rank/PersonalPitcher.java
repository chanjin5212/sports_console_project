package com.project.sports.user.rank;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.input.Team;
import com.project.sports.main.Data;

/**
 * 투수 개인 순위 클래스
 * @author 안수아
 *
 */
public class PersonalPitcher {
	
	public static List<Player> pitcherList = Data.playerList;
	public static List<Team> teamList = Data.teamList;
	
	/**
	 * 투수 항목 선택 메뉴
	 */
	public static void selectPitcherType() {
		
		Scanner sc = new Scanner(System.in);
		boolean pitcherFlag = true;
		
		while (pitcherFlag) { // 투수 선택
			
			RankOutput.printPitcherMenu();
			String input = sc.nextLine();
			
			if (input.equals("1")) { // 평균 자책
				earnedRunAvgRank();
			} else if (input.equals("2")) { // 승수
				winRank();
			} else if (input.equals("3")) { // 탈삼진
				threeOutRank();
			} else if (input.equals("4")) { // 이닝
				inningRank();
			} else if (input.equals("0")) {
				com.project.sports.output.Output.backMsg();
				pitcherFlag = false;
			} else {
				System.out.println("\t\t\t\t\t\t올바르지 않은 메뉴 번호입니다.");
			}
			
		}
	}
	
	/**
	 * 평균 자책 순위 출력
	 */
	private static void earnedRunAvgRank() {
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[평균 자책]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		pitcherList.sort(new Comparator<Player>() { // 평균 자책 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				if (p1.getEarnedRunAvg() > p2.getEarnedRunAvg()) {
					return 1;
				} else if (p1.getEarnedRunAvg() < p2.getEarnedRunAvg()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		int rank = 1;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			String teamName = "";
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.currentYear) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%.2f\n", rank ++, pitcher.getName(), teamName ,pitcher.getEarnedRunAvg()));
				if (rank == 6) break;
			}
			
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

	/**
	 * 승수 순위 출력
	 */
	private static void winRank() { // 승수 순위
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[승수]\n");
		sb.append("\t\t\t\t======================================================\n");
		pitcherList.sort(new Comparator<Player>() { // 승수 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getWin() - p1.getWin();
			}
		});
		
		int rank = 1;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			String teamName = "";
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.currentYear) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, pitcher.getName(), teamName ,pitcher.getWin()));
				if (rank == 6) break;
			}
			
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

	/**
	 * 탈삼진 순위 출력
	 */
	private static void threeOutRank() { // 탈삼진 순위
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[탈삼진]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		pitcherList.sort(new Comparator<Player>() { // 탈삼진 내림차순 출력
			
			@Override
			public int compare(Player p1, Player p2) {
				return p2.getThreeOut() - p1.getThreeOut();
			}
		});
		
		int rank = 1;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			String teamName = "";
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.currentYear) {
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, pitcher.getName(), teamName ,pitcher.getThreeOut()));
				if (rank == 6) break;
			}
			
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

	/**
	 * 이닝 순위 출력
	 */
	private static void inningRank() { // 이닝 순위
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[이닝]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		pitcherList.sort(new Comparator<Player>() { // 이닝 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getInning() - p1.getInning();
			}
		});
		
		int rank = 1;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			String teamName = "";
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.currentYear) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, pitcher.getName(), teamName ,pitcher.getInning()));
				if (rank == 6) break;
			}
			
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

}
