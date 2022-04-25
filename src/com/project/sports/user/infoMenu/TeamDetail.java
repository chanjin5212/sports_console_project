package com.project.sports.user.infoMenu;

import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 팀 상세보기 클래스입니다.
 * @author 강지윤
 *
 */
public class TeamDetail {

	//팀 상세보기
	
	//public static List<Team>teamList;
	
	/**
	 * 상세보기를 할 팀의 번호를 입력받고, 그 팀의 선수 목록을 출력합니다.
	 */
	public static void teamDetailInfo() {
		
		
		
		Scanner sc = new Scanner(System.in);
		boolean teamDetailFlag = true;
		
		while(teamDetailFlag) {	//정보 메뉴에서 팀 상세보기를 눌렀을때
			
				InfoOutput.teamDetailMessage();
				String input = sc.nextLine(); // 상세보기를 할 팀 번호 입력받기
		
				if(input.equals("1")) { 
					//1. LG트윈스
					twinsDetail();
					
				} else if(input.equals("2")) { 
					//2. 두산 베어스
					bearsDetail();
					
				} else if(input.equals("3")) {
					//3. 롯데 자이언츠
					giantsDetail();
					
				} else if(input.equals("4")) {
					//4. SSG 랜더스
					landersDetail();
					
				} else if(input.equals("5")) {
					//5. KIA타이거즈
					tigersDetail();
					
				} else if(input.equals("6")) {
					//6. 키움히어로즈
					
					heroesDetail();
					
				} else if(input.equals("7")) {
					//7.NC 다이노스
					dinosDetail();
					
					
				} else if(input.equals("8")) {
					//8.Kt 위즈
					wizDetail();
					
				} else if(input.equals("9")) {
					//9.삼성라이온즈
					lionsDetail();
					
				} else if(input.equals("10")) {
					//10.한화이글스
					eaglesDetail();
					
				} else if(input.equals("0")){
					
					Output.backMsg();
					teamDetailFlag = false;
					
				} else { //유효성검사
					
					System.out.println("올바른 번호를 입력해주세요.");
				}
				
				Output.pause();
			}
		
	}//teamDetail.info
	
	//2022년 선수단 목록 [선수번호][이름][포지션]
	/**
	 * 엘지 트윈스 선수단 목록입니다.
	 */
	public static void twinsDetail ()  {
		
		
		System.out.println("\t\t\t\t\t\t   1. LG 트윈스 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t [선수번호]  [이름]    [포지션]");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//LG트윈스 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 1 && p.getYear().equals("2022")) { //팀이 1(lg)이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}
	
	/** 
	 * 두산 베어스 선수단 목록입니다.
	 */
	private static void bearsDetail() {
		
		System.out.println("\t\t\t\t\t\t   2. 두산 베어스 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//두산 베어스 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 2 && p.getYear().equals("2022")) { //팀이 2이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}
	
	/**
	 * 롯데 자이언츠 선수단 목록입니다.
	 */
	private static void giantsDetail() {
		
		System.out.println("\t\t\t\t\t\t 3. 롯데 자이언츠 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		
		//롯데 자이언츠 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 3 && p.getYear().equals("2022")) { //팀이 3이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
	}
	
	/**
	 * SSG 랜더스 선수단 목록입니다.
	 */
	private static void landersDetail() {
		
		System.out.println("\t\t\t\t\t\t 4. SSG 랜더스 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		
		//SSG 랜더스 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 4 && p.getYear().equals("2022")) { //팀이 4이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
	}
	
	/**
	 * 기아 타이거즈 선수단 목록입니다.
	 */
	private static void tigersDetail() {
		
		System.out.println("\t\t\t\t\t\t 5. KIA 타이거즈 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//KIA 타이거즈 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 5 && p.getYear().equals("2022")) { //팀이5이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println();
		
	}
	
	/**
	 * 키움 히어로즈 선수단 목록입니다.
	 */
	private static void heroesDetail() {
		
		System.out.println("\t\t\t\t\t\t 6. 키움 히어로즈 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//키움 히어로즈 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 6 && p.getYear().equals("2022")) { //팀이 6이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}
	
	/**
	 * NC 다이노스 선수단 목록입니다.
	 */
	private static void dinosDetail() {

		System.out.println("\t\t\t\t\t\t 7. NC 다이노스 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");

		
		//NC 다이노스 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 7 && p.getYear().equals("2022")) { //팀이 7이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}
	
	/**
	 * KT 위즈 선수단 목록입니다.
	 */
	private static void wizDetail() {
		
		System.out.println("\t\t\t\t\t\t 8. KT 위즈 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//KT 위즈 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 8 && p.getYear().equals("2022")) { //팀이 8이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}
	
	/**
	 * 삼성 라이온즈 선수단 목록입니다.
	 */
	private static void lionsDetail() {

		System.out.println("\t\t\t\t\t\t 9. 삼성 라이온즈 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//삼성 라이온즈 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 9 && p.getYear().equals("2022")) { //팀이 9이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}
	
	/**
	 * 한화 이글스 선수단 목록입니다.
	 */
	private static void eaglesDetail() {
		
		System.out.println("\t\t\t\t\t\t 10. 한화 이글스 선수 목록");
		System.out.println("\t\t\t\t\t\t===========================");
		System.out.println("\t\t\t\t\t\t  선수번호   이름      포지션");
		System.out.println("\t\t\t\t\t\t===========================");
		
		//한화 이글스 선수단 목록(2022년)
		for (Player p : Data.playerList) {
			
			if (p.getTeamSeq() == 10 && p.getYear().equals("2022")) { //팀이 10이고, 2022년일때
				
				System.out.printf("\t\t\t\t\t\t  %3s     %3s     %3s\n",
									p.getPlayerNum(), 	//선수번호
									p.getName(),		//이름
									p.getPosition());	//포지션
			}
		}
		
		System.out.println("\t\t\t\t\t\t---------------------------");
		System.out.println();
		
	}


	

	

	

	

	

	

	
	
	
	
	
	
}//teamDetail





