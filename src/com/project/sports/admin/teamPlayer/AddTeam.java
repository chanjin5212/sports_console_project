package com.project.sports.admin.teamPlayer;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Team;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 팀을 등록하는 클래스
 * @author 서주예
 */
public class AddTeam {

	
	/**
	 * 팀을 등록하고 List에 저장하는 메소드
	 */
	public static void addTeam() {

		Scanner sc = new Scanner(System.in);
		boolean addFlag = true;
		
		while (addFlag) {

			// 팀 입력받기
			Output.menuBack();
			System.out.print("\t\t\t\t\t팀 명 : ");
			String name = sc.nextLine();

			if (name.equals("0")) {
				Output.backMsg();
				break;
			}
			
			boolean addTeamFlag = true;
			while (addTeamFlag) {
				
				Output.menuBack();
				System.out.print("\t\t\t\t\t경기장 : ");
				String place = sc.nextLine();
				
				if (name.equals("0")) {
					Output.backMsg();
					break;
				}
				

				// 확인받기
				System.out.println();
				System.out.printf("\t\t\t\t\t<팀명 : %s, 경기장 : %s>\n", name, place);
				System.out.print("\t\t\t\t\t입력하신 정보 맞습니까?(y/n) : ");
				String answer = sc.nextLine().toUpperCase();

				int last2 = Data.yearTeamList.get(Data.yearTeamList.size() - 1).getSeq();
				int last = Data.teamList.get(Data.teamList.size() - 1).getSeq();
				Calendar c = Calendar.getInstance();

				if (answer.equals("Y")) {

					YearTeam yearTeam = new YearTeam(last2 +1, "야구", name, ""); //등록한 팀 yearTeamList에 넣기
					Data.yearTeamList.add(yearTeam);
					TeamPlayer.teamList.add(yearTeam);
					
					Team team = new Team(last + 1, c.get(Calendar.YEAR), "야구", name, 0, 0, place); //등록한 팀 TeamList에 넣기
					Data.teamList.add(team);
					TeamPlayer.team.add(team);

					
					System.out.println();
					System.out.println("\t\t\t\t\t등록이 완료되었습니다.");
					System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
					String enter = sc.nextLine();
					addTeamFlag = false;
					addFlag = false;

				} else if (answer.equals("N")) {
					System.out.println();
					System.out.println("\t\t\t\t\t등록이 취소되었습니다.");
					System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
					String enter = sc.nextLine();
					addTeamFlag = false;
					addFlag = false;
				}
				// 완료
			}
		}
	}
}
