package com.project.sports.user.rank;

import java.util.Calendar;
import java.util.Scanner;
/**
 * 순위 카테고리
 * @author 안수아
 *
 */
public class RankMenu {
	
	public static int year = 0;
	public static int currentYear = 0;
	
	/**
	 * 순위 카테고리의 하위 메뉴
	 */
	public static void rankMenu() { // 순위 메뉴
		
		Calendar c = Calendar.getInstance();
		currentYear = c.get(Calendar.YEAR);
		
		Scanner sc = new Scanner(System.in);
		boolean rankMenuFlag = true;
		
		while (rankMenuFlag) { 
			
			RankByYear.mainRank(currentYear);
			
			RankOutput.printRankMenu();
			String input = sc.nextLine();
			
			if (input.equals("1")) { // 개인 순위
				selectPosition();
			} else if (input.equals("2")) { // 연도 검색
				searchByYear();
			} else if (input.equals("0")) {
				com.project.sports.output.Output.backMsg();
				rankMenuFlag = false;
			} else {
				System.out.println("\t\t\t\t\t\t 올바르지 않은 메뉴 번호입니다.");
				System.out.println();
			}
			
		}
	}

	/**
	 * 포지션 선택 메뉴
	 */
	private static void selectPosition() { // 포지션 메뉴
		
		Scanner sc = new Scanner(System.in);
		boolean positionFlag = true;
		
		while (positionFlag) { 
			
			RankOutput.printPositionMenu();
			String input = sc.nextLine();
			
			if (input.equals("1")) { // 타자
				PersonalBatter.selectBatterType();
				
			} else if (input.equals("2")) { // 투수
				PersonalPitcher.selectPitcherType();
				
			} else if (input.equals("0")) {
				positionFlag = false;
				
			} else {
				System.out.println("\t\t\t\t\t\t 올바르지 않은 메뉴 번호입니다.");
				System.out.println();
			}
			
		}
	}
	
	/**
	 * 연도를 입력받아 그 해의 팀 순위를 출력
	 */
	private static void searchByYear() { // 연도 검색
		
		boolean yearFlag = true;
		
		while (yearFlag) {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("\t\t\t\t\t\t 연도: ");
			year = sc.nextInt();
			
			if (year == 0) {
				com.project.sports.output.Output.backMsg();
				break;
			}
			
			if (RankByYear.hasResult(year)) {
				RankByYear.mainRank(year);
				yearSearchMenu();
			} else {
				System.out.println("\t\t\t\t\t\t 해당 년도에 결과가 존재하지 않습니다.");
				System.out.println();
			}
			
		}
		
	}

	/**
	 * 연도 검색의 포지션 선택 메뉴
	 */
	private static void yearSearchMenu() { // 연도 검색 페이지 메뉴
		
		Scanner sc = new Scanner(System.in);
		boolean yearMenuFlag = true;
		
		while (yearMenuFlag) {
			RankOutput.printYearMenu();
			String input = sc.nextLine();
			
			if (input.equals("1")) {
				YearPersonal.rank();
			} else if (input.equals("0")) {
				yearMenuFlag = false;
			} else {
				System.out.println("\t\t\t\t\t\t 올바르지 않은 메뉴 번호입니다.");
				System.out.println();
			}
			
		}
		
	}

}
