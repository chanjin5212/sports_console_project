package com.project.sports.user.rank;

import java.util.Comparator;
import java.util.List;
import com.project.sports.input.Team;
import com.project.sports.main.Data;
/**
 * 순위 카테고리의 메인 순위 출력
 * @author 안수아
 *
 */
public class RankByYear {
	
	public static List<Team> teamList = Data.teamList;
	
	/**
	 * 연도를 입력 받아 팀 순위를 출력
	 * @param year
	 */
	public static void mainRank(int year) {
		
		StringBuilder sb = new StringBuilder("\n");
		sb.append(String.format("\t\t\t\t\t\t   [%d년 팀 순위]\n", year));
		sb.append("\t\t=============================================================================================\n");
		sb.append("\t\t[순위]\t\t[팀]\t\t\t[경기]\t\t[승]\t\t[패]\t\t[승률]\n");
		sb.append("\t\t=============================================================================================\n");
		
		teamList.sort(new Comparator<Team>() {

			@Override
			public int compare(Team t1, Team t2) {
				
				Double t1WinRate = t1.getWin() / (double)(t1.getWin() + t1.getLose()); 
				Double t2WinRate = t2.getWin() / (double)(t2.getWin() + t2.getLose());
				
				return t2WinRate.compareTo(t1WinRate);
			} 

		});
		
		int rank = 1;
		
		for (int i = 0 ; i < teamList.size() ; i ++) {
		
			if (teamList.get(i).getYear() == year) {
			Team t = teamList.get(i);
				
				sb.append(String.format("\t\t%d\t\t%-10s\t\t%d\t\t%d\t\t%d\t\t%-5.3f\n"
						, rank++
						, t.getTeamName()
						, t.getWin() + t.getLose()
						, t.getWin() 
						, t.getLose()
						, t.getWin() / (double)(t.getWin() + t.getLose())));
			}
				
		}
		sb.append("\t\t---------------------------------------------------------------------------------------------\n");
		System.out.println(sb);
	}
	
	/**
	 * 입력으로 들어온 연도의 경기 결과가 존재하는 지 여부 확인
	 * @param year
	 * @return
	 */
	public static boolean hasResult(int year) { 
		
		for (int i = 0 ; i < teamList.size() ; i ++) {
			
			if (teamList.get(i).getYear() == year) {
				return true;
			}
		}
		return false;
	}

}
