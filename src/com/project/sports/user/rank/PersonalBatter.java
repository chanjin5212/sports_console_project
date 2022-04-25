package com.project.sports.user.rank;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.input.Team;
import com.project.sports.main.Data;

/**
 * 타자 개인 순위 클래스
 * @author 안수아
 *
 */
public class PersonalBatter {
	
	public static List<Player> batterList = Data.playerList;
	public static List<Team> teamList = Data.teamList;
	
	/**
	 * 타자 항목 선택 메뉴
	 */
	public static void selectBatterType() {
		
		Scanner sc = new Scanner(System.in);
		boolean batterFlag = true;
		
		while (batterFlag) { // 포지션 선택
			
			RankOutput.printBatterMenu();
			String input = sc.nextLine();
			
			if (input.equals("1")) { // 안타
				hitRank();
			} else if (input.equals("2")) { // 홈런
				homeRunRank();
			} else if (input.equals("3")) { // 타점
				hitScoreRank();
			} else if (input.equals("0")) {
				com.project.sports.output.Output.backMsg();
				batterFlag = false;
			} else {
				System.out.println("올바르지 않은 메뉴 번호입니다.");
			}
			
		}
	}

	/**
	 * 안타 순위 출력
	 */
	private static void hitRank() {
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[안타]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		batterList.sort(new Comparator<Player>() { // 배열 안타 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getHit() - p1.getHit();
			}
		});
		
		String teamName = "";
		int rank = 1;
		
		for (int i = 0 ; i < batterList.size() ; i ++) {
			
			Player batter = batterList.get(i);
			
			if (Integer.parseInt(batter.getYear()) == RankMenu.currentYear) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (batter.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, batter.getName(), teamName ,batter.getHit()));
				if(rank == 6) break;
			}
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();
	}

	/**
	 * 홈런 순위 출력
	 */
	private static void homeRunRank() {
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[홈런]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		batterList.sort(new Comparator<Player>() { // 홈런 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getHomeRun() - p1.getHomeRun();
			}
		});
		
		String teamName = "";
		int rank = 1;
		
		for (int i = 0 ; i < batterList.size() ; i ++) {
			
			Player batter = batterList.get(i);
			
			if (Integer.parseInt(batter.getYear()) == RankMenu.currentYear) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (batter.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, batter.getName(), teamName ,batter.getHomeRun()));
				if (rank == 6) break;
			}
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();
		
	}

	/**
	 * 타점 순위 출력
	 */
	private static void hitScoreRank() { 
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[타점]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		batterList.sort(new Comparator<Player>() { // 타점 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getHitScore() - p1.getHitScore();
			}
		});
		
		String teamName = "";
		int rank = 1;
		
		for (int i = 0 ; i < batterList.size() ; i ++) {
			
			Player batter = batterList.get(i);
			
			if (Integer.parseInt(batter.getYear()) == RankMenu.currentYear) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (batter.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, batter.getName(), teamName ,batter.getHitScore()));
				if (rank == 6) break;
			}
			
		}
		sb.append("\t\t\t\t----------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();		
	}
	
	
}
