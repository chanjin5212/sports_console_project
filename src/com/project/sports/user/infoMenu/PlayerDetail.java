package com.project.sports.user.infoMenu;

import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 선수검색 클래스입니다.
 * @author 강지윤
 *
 */
public class PlayerDetail {
	/**
	 * 선수 이름을 입력받고, 그 선수의 정보를 출력합니다.
	 */
	public static void playerSearch() {
		
		
		Scanner sc = new Scanner(System.in);
		boolean playerSearchFlag = true;
		
		while(playerSearchFlag) {	//정보 메뉴에서 선수검색을 눌렀을때
			
				InfoOutput.playerDetailMessage(); //선수검색 메세지 출력

				String input = sc.nextLine(); // 선수번호 / 이름 입력받기
		
				Boolean hasPlayer = false;
				
				for (Player p : Data.playerList) {
					
					
						
						if (input.equals(p.getName())) { //입력받은 선수이름과 같은 이름이 있으면
							
							hasPlayer = true;	//선수가 존재하면
							
							if (p.getYear().equals("2022")) {  //2022년 정보만
							
						
							//[선수번호, 이름, 키, 몸무게, 포지션]
							//맨 앞에 팀이름 추가
							
							System.out.println("\t\t\t\t ===============================================================");
							System.out.println("\t\t\t\t\t  [팀] \t [선수번호]  [이름]    [키]  [몸무게]  [포지션]");
							System.out.println("\t\t\t\t ===============================================================");
							//System.out.print(); //팀이름
							
							int teamSeq = p.getTeamSeq(); //팀 번호를 받고 TeamName()으로 이동
							
							System.out.printf("\t\t\t\t      %-7s   %3s \t   %3s     %3s   %3s     %3s\n",
												TeamName(teamSeq),
												p.getPlayerNum(),
												p.getName(),
												p.getHeight(),
												p.getWeight(),
												p.getPosition());
							System.out.println();
							System.out.println();
							
							
							
							//이젠 기록 정보
							// 포지션이 타자일때 투수일때
							// 타자 - 타율, 홈런, 안타, 타점, 득점 (엄철일, 이이광, 노홍별)
							// 투수 - 평균자책, 승수, 이닝, 탈삼진 (조하홍, 임준형, 추솔도)
								
								if (p.getPosition().equals("타자")) { //포지션이 타자일때
									
									System.out.println("\t\t\t\t ===============================================================");
									System.out.println("\t\t\t\t\t\t[타율]\t[홈런]\t[안타]\t[타점]\t[득점]");
									System.out.println("\t\t\t\t ===============================================================");
									System.out.printf("\t\t\t\t\t\t %.2f\t%3d\t%3d\t%3d\t%3d\n", 
															p.getBattingAvg(),
															p.getHomeRun(),
															p.getHit(),
															p.getHitScore(),
															p.getMakeScore());
									System.out.println();
									//System.out.println("\t\t\t\t ---------------------------------------------------------------");
									
								} else if(p.getPosition().equals("투수")) { //포지션이 투수일때
									
									System.out.println("\t\t\t\t ===============================================================");
									System.out.println("\t\t\t\t\t\t[평균자책]\t  [승수]\t[이닝]\t[탈삼진]");
									System.out.println("\t\t\t\t ===============================================================");
									System.out.printf("\t\t\t\t\t\t %.2f\t  %3d\t%3d\t%3d\n", 
															p.getEarnedRunAvg(),
															p.getWin(),
															p.getInning(),
															p.getThreeOut());
									System.out.println();
									//System.out.println("\t\t\t\t ---------------------------------------------------------------");
								} 
							} 
						} //이름이 일치하는지 확인하는 if문
					}
				
				
				
				if(input.equals("")){
					
					System.out.println("내용을 입력해주세요.");
					
				} else if(input.equals("0")) {
					
					Output.backMsg();
					playerSearchFlag = false;
					
				} else if (hasPlayer == false) { //선수가 존재하지 않으면
					System.out.println("일치하는 선수가 없습니다.");
				}
						
			}
		
	
	

	
		
	}//playerSearch
	
	
	public static String TeamName(int teamSeq) {
		
			//받은 팀번호에 따라 맞는 팀 이름 반환
		
			if (teamSeq == 1) {
				return "LG 트윈스";
			} else if (teamSeq ==2 ) {
				return "두산 베어스";
			} else if (teamSeq == 3) {
				return "롯데 자이언츠";
			} else if (teamSeq == 4) {
				return "SSG 랜더스";
			} else if (teamSeq == 5) {
				return "KIA 타이거즈";
			} else if (teamSeq == 6) {
				return "키움 히어로즈";
			} else if (teamSeq == 7) {
				return "NC 다이노스";
			} else if (teamSeq == 8) {
				return "KT 위즈";
			} else if (teamSeq == 9) {
				return "삼성 라이온즈";
			} 
				return "한화 이글스";
			
		
		
		
	}
	
	
}//class
