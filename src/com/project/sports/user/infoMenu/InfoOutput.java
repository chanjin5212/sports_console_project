package com.project.sports.user.infoMenu;

/**
 * 정보메뉴 출력문 클래스입니다.
 * @author 강지윤
 *
 */
public class InfoOutput {
	/**
	 * 정보 메뉴를 출력합니다.
	 */
	public static void infoMenu() { //1.팀 정보 상세보기 //2. 선수 검색
		System.out.println("\t\t\t\t\t\t ┌─────────────────────────┐");
		System.out.println("\t\t\t\t\t\t │     1. 팀 정보 상세보기	   │");
		System.out.println("\t\t\t\t\t\t │     2. 선수 검색	   │");
		System.out.println("\t\t\t\t\t\t │     0. 뒤로가기		   │");
		System.out.println("\t\t\t\t\t\t └─────────────────────────┘");
		System.out.print("\t\t\t\t\t\t\t 메뉴 번호 : ");

	
		
	}
	
	
	/**
	 * 상세정보 확인 팀 입력문을 출력합니다.
	 */
	public static void teamDetailMessage() {
		

		
		System.out.println("\t\t\t\t ┌──────────────────────────────────────────────────────────────┐");
	    System.out.println("\t\t\t\t │\t상세 정보를 보고싶은 팀의 번호를 입력해주세요. (0. 뒤로가기)\t	│");
		System.out.println("\t\t\t\t └──────────────────────────────────────────────────────────────┘");
	    System.out.print("\t\t\t\t\t\t\t 팀 번호 입력 : ");
		
		
	}
	
	/**
	 * 검색할 선수 이름 입력문을 출력합니다.
	 */
	public static void playerDetailMessage() {
		
		
		System.out.println("\t\t\t\t ┌──────────────────────────────────────────────────────┐");
	    System.out.println("\t\t\t\t │\t검색하고싶은 선수의 이름을 입력해주세요. (0. 뒤로가기)\t│");
		System.out.println("\t\t\t\t └──────────────────────────────────────────────────────┘");
	    System.out.print("\t\t\t\t\t\t\t 선수 입력 : ");
		
		
	}
	
	/**
	 * 전체 팀 목록을 출력합니다.
	 */
	public static void teamList() {
		

		
		System.out.println("\t\t\t\t\t\t ┌─────────────────────────┐");
		System.out.println("\t\t\t\t\t\t │\t 1. LG 트윈스	   │");
		System.out.println("\t\t\t\t\t\t │\t 2. 두산 베어스	   │");
		System.out.println("\t\t\t\t\t\t │\t 3. 롯데 자이언츠	   │");
		System.out.println("\t\t\t\t\t\t │\t 4. SSG 랜더스 	   │");
		System.out.println("\t\t\t\t\t\t │\t 5. KIA 타이거즈	   │");
		System.out.println("\t\t\t\t\t\t │\t 6. 키움 히어로즈	   │");
		System.out.println("\t\t\t\t\t\t │\t 7. NC 다이노스 	   │");
		System.out.println("\t\t\t\t\t\t │\t 8. KT 위즈 	   │");
		System.out.println("\t\t\t\t\t\t │\t 9. 삼성 라이온즈	   │");
		System.out.println("\t\t\t\t\t\t │\t 10. SSG 랜더스	   │");
		System.out.println("\t\t\t\t\t\t └─────────────────────────┘");
		
		

		
	}
		
		
	
}
