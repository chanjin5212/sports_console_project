package com.project.sports.admin.teamPlayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 상세보기할 팀을 선택하는 클래스
 * @author 서주예
 */
public class SelectTeam {
	public static int input = 0;

	public static List<Player> playerList = new ArrayList<Player>(); //선수 리스트
	
	/**
	 * 상세정보를 확인할 팀을 선택하는 메소드
	 */
	public static void selectTeam() {


		Scanner sc = new Scanner(System.in);

		// 팀 선택하기
		boolean selectTeam = true;
		while (selectTeam) {

			System.out.print("\t\t\t\t\t\t팀 번호 : ");
			input = sc.nextInt();

			if(input == 0) {
				break;
			}
			//뒤로가기

			// 선수 목록 보여주기		
			
			boolean subMenuFlag = true;
			while (subMenuFlag) {

				Output.oneLine();
				lookTeamPlayer(input);
				sc = new Scanner(System.in);
				//상세메뉴 보여주기
				System.out.println();
				System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
				System.out.println("\t\t\t\t\t │             1. 선수 등록\t    │");
				System.out.println("\t\t\t\t\t │             2. 선수 수정\t    │");
				System.out.println("\t\t\t\t\t │             3. 선수 삭제\t    │");
				System.out.print("\t\t\t\t\t │\t       ");
				Output.back();
				System.out.print("\t\t    │\n");
				System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
				System.out.print("\t\t\t\t\t    메뉴 번호 입력 : ");
				String menuNum = sc.nextLine();

				if (menuNum.equals("1")) {
					// 선수 등록
					AddPlayer.addPlayer();
				} else if (menuNum.equals("2")) {
					// 선수 수정
					UpdatePlayer.updatePlayer();
				} else if (menuNum.equals("3")) {
					// 선수 삭제
					DeletePlayer.deletePlayer();
				} else if (menuNum.equals("0")) {
					// 뒤로가기
					selectTeam = false;
					break;
				} else {
					// 유효성 검사
				}
			}



		}

	}

	/**
	 * 선택한 팀 번호의 선수를 보여주고 List에 저장하는 메소드
	 * @param input 상요자가 입력한 팀 번호를 받는 매개변수
	 */
	public static void lookTeamPlayer(int input) { // 사용자가 입력한 팀 번호 매개변수로 받기

		Calendar c = Calendar.getInstance();
		playerList = new ArrayList<Player>();
		int listSeq = 1;

		System.out.printf("\t\t\t\t\t      <%s>\n", TeamPlayer.teamList.get(input - 1).getTeamName());
		System.out.println("\t\t\t\t\t=============================================");
		System.out.println("\t\t\t\t\t번호\t포지션\t선수번호\t이름\t키\t몸무게");
		System.out.println("\t\t\t\t\t=============================================");

		for (Player p : Data.playerList) { // 선수 정보 가져오기 

			if (p.getYear().equals(Integer.toString(c.get(Calendar.YEAR)))) { // 선수가 2022년 선수이면 > 캘린더 변수의 Year로 받기 > 해결

				if (p.getTeamSeq() == TeamPlayer.teamList.get(input - 1).getSeq()) { // 사용자 입력 번호 == 팀 고유 번호

					String line =
							String.format("\t\t\t\t\t%d\t%s\t%s\t%s\t%s\t%s\t", listSeq, p.getPosition(),
									p.getPlayerNum(), p.getName(), p.getHeight(), p.getWeight());

					listSeq++;
					playerList.add(p);
					System.out.println(line);

				}



			}

		}
		System.out.println("\t\t\t\t\t---------------------------------------------");



	}
	
}
