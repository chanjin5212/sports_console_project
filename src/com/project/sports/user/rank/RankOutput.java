package com.project.sports.user.rank;

import com.project.sports.output.Output;

/**
 * 순위 카테고리의 메인 메뉴와 하위 메뉴를 출력
 * @author 안수아
 *
 */
public class RankOutput {

	/**
	 * 순위 카테고리의 메인 메뉴 출력
	 */
	public static void printRankMenu() { 
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 개인 순위\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 연도 검색\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
		
	}
	
	/**
	 * 포지션 선택 메뉴 출력
	 */
	public static void printPositionMenu() { 
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │              1. 타자		    │");
		System.out.println("\t\t\t\t\t │              2. 투수		    │");
		System.out.print("\t\t\t\t\t │\t        "); Output.back(); System.out.print("\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	/**
	 * 개인 순위 타자 항목 선택 메뉴 출력
	 */
	public static void printBatterMenu() { 
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │              1. 안타		    │");
		System.out.println("\t\t\t\t\t │              2. 홈런		    │");
		System.out.println("\t\t\t\t\t │              3. 타점		    │");
		System.out.print("\t\t\t\t\t │\t        "); Output.back(); System.out.print("\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	/**
	 * 개인 순위 투수 항목 선택 메뉴 출력
	 */
	public static void printPitcherMenu() {
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 평균 자책\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 승수\t\t    │");
		System.out.println("\t\t\t\t\t │            3. 탈삼진\t\t    │");
		System.out.println("\t\t\t\t\t │            4. 이닝\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	/**
	 * 연도 검색의 하위 메뉴 출력
	 */
	public static void printYearMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 개인 순위\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	/**
	 * 연도별 개인 순위 타자 항목 선택 메뉴 출력
	 */
	public static void printYearBatterMenu() {
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 안타\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 홈런\t\t    │");
		System.out.println("\t\t\t\t\t │            3. 타점\t\t    │");
		System.out.println("\t\t\t\t\t │            4. 선수 검색\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
		
	}
	
	/**
	 * 연도별 개인 순위 투수 항목 선택 메뉴 출력
	 */
	public static void printYearPitcherMenu() { 
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 평균 자책\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 승수\t\t    │");
		System.out.println("\t\t\t\t\t │            3. 탈삼진\t\t    │");
		System.out.println("\t\t\t\t\t │            4. 이닝\t\t    │");
		System.out.println("\t\t\t\t\t │            5. 선수 검색\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
}
