package com.project.sports.admin.teamPlayer;

import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.input.Team;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 팀 정보를 수정하는 클래스
 * @author 서주예
 */
public class UpdateTeam {

	
	/**
	 * 팀 정보를 수정하는 메소드
	 */
	public static void updateTeam() {

		Scanner sc = new Scanner(System.in);
		boolean updateTeamFlag = true;
		while (updateTeamFlag) {

			// 수정할 팀 번호 받기
			Output.menuBack();
			System.out.print("\t\t\t\t\t    수정할 팀 번호를 선택하세요. : ");
			String input = sc.nextLine();
			if (input.equals("0")) {
				Output.backMsg();
				break;
			}

			boolean updateNameFlag = true;
			while (updateNameFlag) {
				// 수정할 팀 이름 받기
				System.out.println();
				Output.menuBack();
				System.out.printf("\t\t\t\t\t선택한 팀명 : %s\n",
						TeamPlayer.teamList.get(Integer.parseInt(input) - 1).getTeamName());
				System.out.print("\t\t\t\t\t수정할 팀명 : ");
				String name = sc.nextLine();
				
				if(name.equals("0")) {
					Output.backMsg();
					updateTeamFlag = false;
					break;
				}
				
				System.out.println();
				System.out.printf("\t\t\t\t\t변경 전 <%s>\n", TeamPlayer.teamList.get(Integer.parseInt(input) - 1).getTeamName());
				System.out.printf("\t\t\t\t\t변경 후 <%s>\n", name);
				System.out.print("\t\t\t\t\t입력하신 팀명으로 수정하시겠습니까?(y/n) : ");
				String answer = sc.nextLine().toUpperCase();
				
				
				
				if(answer.equals("Y")) {
					
					for (Team t : Data.teamList) {

						if (TeamPlayer.team.get(Integer.parseInt(input) - 1).getSeq() == t.getSeq()) {

							t.setTeamName(name); 
						}
						
						

					}
					
					for (YearTeam y : Data.yearTeamList) {
						
						if (TeamPlayer.teamList.get(Integer.parseInt(input) - 1).getSeq() == y.getSeq()) {

							y.setTeamName(name); //사용자가 선택한 팀이 아니라 전체가 다 바뀜 >>??? > 해결
						}
						
					}
					
					System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
					System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
					String enter = sc.nextLine();
					updateNameFlag = false;
					updateTeamFlag = false;
					break;
					
				} else if(answer.equals("N")) {
					System.out.println("\t\t\t\t\t수정이 취소되었습니다.");
					System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
					String enter = sc.nextLine();
					updateNameFlag = false;
					updateTeamFlag = false;
					break;
				}

				// 확인받기
				// 완료하기
			}
		}
	}
}
