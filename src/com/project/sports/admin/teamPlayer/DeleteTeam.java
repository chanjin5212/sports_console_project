package com.project.sports.admin.teamPlayer;

import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.input.Team;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 팀을 삭제하는 클래스
 * @author 서주예
 */

public class DeleteTeam {

	/**
	 * 팀을 삭제하고 List에서도 삭제하는 메소드
	 */
	public static void deleteTeam() {

		boolean deleteTeamFlag = true;
		Scanner sc = new Scanner(System.in);
		while (deleteTeamFlag) {

			// 삭제할 팀 고르기
			Output.menuBack();
			System.out.print("\t\t\t\t\t    삭제할 팀 번호를 선택하세요. : ");
			String input = sc.nextLine();

			if (input.equals("0")) {
				Output.backMsg();
				deleteTeamFlag = false;
				break;
			}

			boolean deleteNameFlag = true;
			while (deleteNameFlag) {
				// 확인 받기
				System.out.println();
				System.out.printf("\t\t\t\t\t<%s>\n",
						TeamPlayer.teamList.get(Integer.parseInt(input) - 1).getTeamName());
				System.out.print("\t\t\t\t\t삭제하시려는 팀명이 맞습니까?(y/n) : ");
				String answer = sc.nextLine().toUpperCase();
				
				if(answer.equals("Y")) {
					
					for (int i=0; i<Data.teamList.size(); i++) { //team지우기

						Team t = Data.teamList.get(i);
						if (TeamPlayer.team.get(Integer.parseInt(input) - 1)
								.getSeq() == t.getSeq()) {

							Data.teamList.remove(t); //올해팀도 지우고 팀리스트도 지우고 선수도 지우고
						}

					}
					
					for(int i=0;i<Data.yearTeamList.size(); i++) { //yearTeam 지우기
						
						YearTeam y = Data.yearTeamList.get(i);
						if (TeamPlayer.teamList.get(Integer.parseInt(input) - 1)
								.getSeq() == y.getSeq()) {

							Data.yearTeamList.remove(y); //올해팀도 지우고 팀리스트도 지우고 선수도 지우고
						}
						
					}
					
					
					System.out.println();
					System.out.println("\t\t\t\t\t삭제가 완료되었습니다.");
					System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
					String enter = sc.nextLine();
					deleteNameFlag = false;
					deleteTeamFlag = false;
					break;
					
					
				} else if(answer.equals("N")) {
					
					System.out.println();
					System.out.println("\t\t\t\t\t삭제가 취소되었습니다.");
					System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
					String enter = sc.nextLine();
					deleteNameFlag = false;
					deleteTeamFlag = false;
					break;
					
				}
				// 완료하기
			}
		}
	}
}
