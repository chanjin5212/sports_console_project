package com.project.sports.user.rank;

import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
/**
 * 연도별 개인 순위
 * @author 안수아
 *
 */
public class YearPersonal {
	
	/**
	 * 연도별 개인 순위 포지션 선택
	 */
	public static void rank() {  
		
		boolean yearPersonalFlag = true;
		
		while (yearPersonalFlag) {
			
			RankOutput.printPositionMenu();
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			 
			if(input.equals("1")) { // 타자
				selectBatterType();
			} else if(input.equals("2")) { // 투수
				selectPitcherType();
			} else if(input.equals("0")) {
				yearPersonalFlag = false;
			}
			
		}
		
	}

	/**
	 * 타자 항목 선택 메뉴
	 */
	private static void selectBatterType() {
		
		boolean batterFlag = true;
		
		while (batterFlag) {
			
			RankOutput.printYearBatterMenu();
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			 
			if(input.equals("1")) { // 안타
				YearBatter.hitRank();
			} else if(input.equals("2")) { // 홈런
				YearBatter.homeRunRank();
			} else if(input.equals("3")) { // 타점
				YearBatter.hitScoreRank();
			} else if(input.equals("4")) { // 선수검색
				searchBatterPlayer();
			} else if(input.equals("0")) {
				batterFlag = false;
			} else {
				System.out.println("\t\t\t\t\t\t올바른 메뉴 번호를 입력해주세요.");
			}
			
		}
		
	}

	/**
	 * 투수 항목 선택 메뉴
	 */
	private static void selectPitcherType() { 
		
		boolean pitcherFlag = true;
		
		while (pitcherFlag) {
			
			RankOutput.printYearPitcherMenu();
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			 
			if(input.equals("1")) { // 평균 자책
				YearPitcher.earnedRunAvgRank();
			} else if(input.equals("2")) { // 승수 
				YearPitcher.winRank();
			} else if(input.equals("3")) { // 탈삼진
				YearPitcher.threeOutRank();
			} else if(input.equals("4")) { // 이닝
				YearPitcher.inningRank();
			} else if(input.equals("5")) { // 선수검색
				searchPitcherPlayer();
			} else if(input.equals("0")) {
				pitcherFlag = false;
			} else {
				System.out.println("\t\t\t\t\t\t올바른 메뉴 번호를 입력해주세요.");
			}
			
		}
	}
	
	/**
	 * 타자 선수 검색
	 */
	private static void searchBatterPlayer() { 
		
		Scanner sc = new Scanner(System.in);
		List<Player> playerList = Data.playerList;
		
		
		boolean flag = true;
		while (flag) {
				
			StringBuilder sb = new StringBuilder("\t\t======================================================================================================\n");
			sb.append("\t\t[번호]\t\t[포지션]\t\t[타율]\t\t[홈런]\t\t[안타]\t\t[타점]\t\t[득점]\n");
			sb.append("\t\t======================================================================================================\n");
				
				System.out.println("\t\t\t\t\t\t검색하실 선수의 이름을 입력하세요.");
				System.out.print("\t\t\t\t\t\t이름: ");
				String inputName = sc.nextLine();
				
				if (inputName.equals("")) {
					System.out.println("\t\t\t\t\t\t선수의 이름을 입력해주세요");
					break;
				} else if (inputName.equals("0")) {
					com.project.sports.output.Output.backMsg();
					break;
				}
				
				boolean hasPlayer = false;
				
				for (Player p : playerList) {
					
					if (p.getName().contains(inputName)
							&& p.getPosition().equals("타자")
							&& Integer.parseInt(p.getYear()) == RankMenu.year) {
						
						sb.append(String.format("\t\t%s\t\t%s\t\t%.3f\t\t%d\t\t%d\t\t%d\t\t%d\n"
													,p.getPlayerNum()
													,p.getPosition()
													,p.getBattingAvg()
													,p.getHomeRun()
													,p.getHit()
													,p.getHitScore()
													,p.getMakeScore()));
						hasPlayer = true;
						break;
					}
				}
				
				if (!hasPlayer) {
					System.out.println("\t\t\t\t\t\t입력하신 선수가 없습니다.");
				} else {
					sb.append("\t\t------------------------------------------------------------------------------------------------------\n");
					System.out.println(sb);
					com.project.sports.output.Output.pause();
				}
				
			} 
		}
	
	/**
	 * 타자 선수 검색
	 */
	private static void searchPitcherPlayer() {
		
		Scanner sc = new Scanner(System.in);
		List<Player> playerList = Data.playerList;
		
		
		boolean flag = true;
		while (flag) {
		
			StringBuilder sb = new StringBuilder("\t\t======================================================================================================\n");
			sb.append("\t\t[번호]\t\t[포지션]\t\t[평균자책]\t\t[승수]\t\t[이닝]\t\t[탈삼진]\n");
			sb.append("\t\t======================================================================================================\n");
			
			System.out.println("\t\t\t\t\t\t검색하실 선수의 이름을 입력하세요.");
			System.out.print("\t\t\t\t\t\t이름: ");
			String inputName = sc.nextLine();
			
			if (inputName.equals("")) {
				System.out.println("\t\t\t\t\t\t선수의 이름을 입력해주세요");
				break;
			} else if (inputName.equals("0")) {
				com.project.sports.output.Output.backMsg();
				break;
			}
			
			boolean hasPlayer = false;
			
			for (Player p : playerList) {
				
				if (p.getName().contains(inputName)
						&& p.getPosition().equals("투수")
						&& Integer.parseInt(p.getYear()) == RankMenu.year) {
					
					sb.append(String.format("\t\t%s\t\t%s\t\t%.2f\t\t%d\t\t%d\t\t%d\n"
												,p.getPlayerNum()
												,p.getPosition()
												,p.getEarnedRunAvg()
												,p.getWin()
												,p.getInning()
												,p.getThreeOut()));
					hasPlayer = true;
					break;
				}
			}
			
			if (!hasPlayer) {
				System.out.println("\t\t\t\t\t\t입력하신 선수가 없습니다.");
			} else {
				sb.append("\t\t------------------------------------------------------------------------------------------------------\n");
				System.out.println(sb);
				com.project.sports.output.Output.pause();
			}
		}
	}

}
