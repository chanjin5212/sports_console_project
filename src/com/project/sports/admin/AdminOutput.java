package com.project.sports.admin;

import com.project.sports.output.Output;

/** 
 * 관리자 출력문 클래스입니다.
 * @author 강지윤
 *
 */
public class AdminOutput {
	
	/**
	 * 관리자 메뉴를 출력합니다.
	 */
	public static void AdminMenu() { 
		
		System.out.println("\t\t\t\t\t\t ┌──────────────────────────┐");
		System.out.println("\t\t\t\t\t\t │     1. 팀/선수 정보 관리	    │");
		System.out.println("\t\t\t\t\t\t │     2. 회원 관리	    │");
		System.out.println("\t\t\t\t\t\t │     3. 예매 관리	    │");
		System.out.println("\t\t\t\t\t\t │     4. 경기 관리	    │");
		System.out.println("\t\t\t\t\t\t │     5. 커뮤니티 관리	    │");
		System.out.println("\t\t\t\t\t\t │     0. 뒤로가기		    │");
		System.out.println("\t\t\t\t\t\t └──────────────────────────┘");
		System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");
	}
	
	/**
	 * 예매 관리 메뉴를 출력합니다.
	 */
	public static void AdminTicketingMenu() {
		
		System.out.println("\t\t\t\t\t\t ┌─────────────────────────┐");
		System.out.println("\t\t\t\t\t\t │     1. 예매 내역 확인	   │");
		System.out.println("\t\t\t\t\t\t │     2. 매출 확인	   │");
		System.out.println("\t\t\t\t\t\t │     0. 뒤로가기		   │");
		System.out.println("\t\t\t\t\t\t └─────────────────────────┘");
		System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");
		
	}
	
	/**
	 * 종목 선택하기를 출력합니다.
	 */
	public static void selectTypeMenu() {
		System.out.println("\t\t\t\t\t\t  ┌──────────────────────┐");
		System.out.println("\t\t\t\t\t\t  │      1. 야구	         │");
		System.out.println("\t\t\t\t\t\t  │      2. 축구	         │");
		System.out.println("\t\t\t\t\t\t  │      3. 배구	         │");
		System.out.println("\t\t\t\t\t\t  │      4. 농구	         │");
		System.out.println("\t\t\t\t\t\t  │      0. 뒤로가기	 │");
		System.out.println("\t\t\t\t\t\t  └──────────────────────┘");
		System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");
	}
	
	/**
	 * 경기 관리 메뉴를 출력합니다.
	 */
	public static void scheduleMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 경기 등록  	    │");
		System.out.println("\t\t\t\t\t │            2. 경기 수정  	    │");
		System.out.println("\t\t\t\t\t │            3. 경기 삭제  	    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	/**
	 * 경기 검색 메뉴를 출력합니다.
	 */
	public static void scheduleEditMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │	   페이지 변경 <,> 입력	    │");
		System.out.println("\t\t\t\t\t │            1. 날짜 검색  	    │");
		System.out.println("\t\t\t\t\t │            2. 경기 번호 입력	    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		Output.input();
		
	}
	
	/**
	 * 경기 수정 메뉴를 출력합니다.
	 */
	public static void scheduleEditSelect() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │             1. 경기팀	   	    │");
		System.out.println("\t\t\t\t\t │             2. 날짜		    │");
		System.out.println("\t\t\t\t\t │             3. 시간		    │");
		System.out.println("\t\t\t\t\t │             4. 경기장	   	    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		Output.input();
	}
	
	/**
	 * 블랙리스트 메뉴를 출력합니다.
	 */
	public static void AdminBlacklistMenu() {
	      
		System.out.println("\t\t\t\t\t ┌────────────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │           1. 블랙리스트 회원 상세정보 보기	  │");
		System.out.println("\t\t\t\t\t │           2. 블랙리스트 삭제		  │");
		System.out.print("\t\t\t\t\t │\t        "); Output.back(); System.out.print("\t\t  │\n");
		System.out.println("\t\t\t\t\t └────────────────────────────────────────┘");

		Output.input();

	      
	}
	
	/**
	 * 회원관리 메뉴를 출력합니다.
	 */
   public static void AdminManageUserMenu() {
	      
	   System.out.println("\t\t\t\t\t ┌────────────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │           	페이지 변경 <,>	    	  │");
		System.out.println("\t\t\t\t\t │           	1. 회원 상세정보 보기	  │");
		System.out.println("\t\t\t\t\t │           	2. 블랙리스트 관리	    \t  │");
		System.out.println("\t\t\t\t\t │           	3. 블랙리스트 추가하기    \t  │");
		System.out.print("\t\t\t\t\t │\t        "); Output.back(); System.out.print("\t\t  │\n");
		System.out.println("\t\t\t\t\t └────────────────────────────────────────┘");

		System.out.print("\t\t\t\t\t\t기호 또는 메뉴 번호 : ");
   }
   
   /**
    * 예매내역 확인 경기번호 입력문을 출력합니다.
    */
   public static void ticketListDetail() {
	      
	   	  System.out.println("\t\t\t\t ┌──────────────────────────────────────────────────────────────┐");
	      System.out.println("\t\t\t\t │\t예매 내역을 확인하고 싶은 경기 번호를 입력해주세요. (0.뒤로가기)\t│");
		  System.out.println("\t\t\t\t └──────────────────────────────────────────────────────────────┘");
	      System.out.print("\t\t\t\t\t\t\t 경기 번호 입력 : ");
	      
   }
   
   /**
    * 예매내역 확인 메뉴를 출력합니다.
    */
   public static void ticketListMenu() {
	      
	    System.out.println("\t\t\t\t\t\t  ┌─────────────────────────────┐");
		System.out.println("\t\t\t\t\t\t  │\t  페이지 변경 <, > 입력\t│");
		System.out.println("\t\t\t\t\t\t  │       1. 예매 내역 상세보기\t│");
		System.out.println("\t\t\t\t\t\t  │       2. 아이디 검색	        │");
		System.out.println("\t\t\t\t\t\t  │       3. 날짜 검색	        │");
		System.out.println("\t\t\t\t\t\t  │       0. 뒤로가기	        │");
		System.out.println("\t\t\t\t\t\t  └─────────────────────────────┘");
		System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");
	      
	      
	   }
   /**
    * 금지어 관리메뉴를 출력합니다.
    */
   public static void bannedWordMenu() {
	   	  
	    System.out.println("\t\t\t\t\t\t  ┌─────────────────────────────┐");
	    System.out.println("\t\t\t\t\t\t  │       1. 금지어 등록	        │");
	    System.out.println("\t\t\t\t\t\t  │       2. 금지어 수정	        │");
	    System.out.println("\t\t\t\t\t\t  │       3. 금지어 삭제	        │");
	    System.out.println("\t\t\t\t\t\t  │       0. 뒤로가기	        │");
		System.out.println("\t\t\t\t\t\t  └─────────────────────────────┘");
		System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");
	      
	   }
   
   /**
    * 커뮤니티 관리 메뉴를 출력합니다.
    */
   public static void commubityorBannedWord() {
	   
	   System.out.println("\t\t\t\t\t\t  ┌─────────────────────────────┐");
	   System.out.println("\t\t\t\t\t\t  │       1. 커뮤니티 관리	    	│");
	   System.out.println("\t\t\t\t\t\t  │       2. 금지어 수정	        │");
	   System.out.println("\t\t\t\t\t\t  │       0. 뒤로가기	        │");
	   System.out.println("\t\t\t\t\t\t  └─────────────────────────────┘");
	   System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");
		
	   
   }
}
