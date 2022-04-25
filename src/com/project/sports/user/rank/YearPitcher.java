package com.project.sports.user.rank;

import java.util.Comparator;
import java.util.List;
import com.project.sports.input.Player;
import com.project.sports.input.Team;
import com.project.sports.main.Data;

/**
 * 연도별 투수 순위
 * @author 안수아
 *
 */
public class YearPitcher { 
	
	public static List<Player> pitcherList = Data.playerList;
	public static List<Team> teamList = Data.teamList;
	
	/**
	 * 평균 자책 순위
	 */
	public static void earnedRunAvgRank() { 
		
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
		
		String teamName = "";
		int rank = 1;
		boolean hasPitcher = false;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.year) {
				
				hasPitcher = true;
			
				for (Team t : teamList) { 
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				
				if (hasPitcher) {
					sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%.2f\n", rank ++, pitcher.getName(), teamName ,pitcher.getEarnedRunAvg()));
					if (rank == 6) break;
				}
			}
		}
		
		if (!hasPitcher) {
			System.out.println("\t\t\t\t\t\t검색 결과가 존재하지 않습니다.");
		}
		sb.append("\t\t\t\t------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

	/**
	 * 승수 순위
	 */
	public static void winRank() { 
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[승수]\n");
		sb.append("\t\t\t\t======================================================\n");
		pitcherList.sort(new Comparator<Player>() { // 승수 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getWin() - p1.getWin();
			}
		});
		
		String teamName = "";
		int rank = 1;
		boolean hasPitcher = false;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.year) {
				
				hasPitcher = true;
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				
				if (hasPitcher) {
					sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, pitcher.getName(), teamName ,pitcher.getWin()));
					if (rank == 6) break;
					
				}
			}
		}
		
		if (!hasPitcher) {
			System.out.println("\t\t\t\t\t\t검색 결과가 존재하지 않습니다.");
		}
		sb.append("\t\t\t\t------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

	/**
	 * 탈삼진 순위
	 */
	public static void threeOutRank() { 
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[탈삼진]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		pitcherList.sort(new Comparator<Player>() { // 탈삼진 내림차순 출력
			
			@Override
			public int compare(Player p1, Player p2) {
				return p2.getThreeOut() - p1.getThreeOut();
			}
		});
		
		String teamName = "";
		int rank = 1;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.year) {
				
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, pitcher.getName(), teamName ,pitcher.getWin()));
				if (rank == 6) break;
			}
					
		}
		sb.append("\t\t\t\t------------------------------------------------------\n");
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

	/**
	 * 이닝 순위
	 */
	public static void inningRank() { 
		
		StringBuilder sb = new StringBuilder("\t\t\t\t======================================================\n");
		sb.append("\t\t\t\t[순위]\t\t[이름]\t\t[팀]\t\t[이닝]\n");
		sb.append("\t\t\t\t======================================================\n");
		
		pitcherList.sort(new Comparator<Player>() { // 이닝 내림차순으로 정렬

			@Override
			public int compare(Player p1, Player p2) {
				return p2.getInning() - p1.getInning();
			}
		});
		
		String teamName = "";
		int rank = 1;
		
		for (int i = 0 ; i < pitcherList.size() ; i ++) {
			
			Player pitcher = pitcherList.get(i);
			
			if (Integer.parseInt(pitcher.getYear()) == RankMenu.year) {
				for (Team t : teamList) { // batter의 팀 이름 가져오기
					if (pitcher.getTeamSeq() == t.getSeq()) {
						teamName = t.getTeamName();
					}
				}
				sb.append(String.format("\t\t\t\t%d\t\t%s\t\t%-10s\t%d\n", rank ++, pitcher.getName(), teamName ,pitcher.getInning()));
				if (rank == 6) break;
			}
			
		}
		sb.append("\t\t\t\t------------------------------------------------------\n");
		
		System.out.println(sb);
		com.project.sports.output.Output.pause();	
	}

}
