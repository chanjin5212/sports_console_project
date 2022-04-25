package com.project.sports.admin.teamPlayer;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 선수 정보를 추가하는 클래스
 * @author 서주예
 */
public class AddPlayer {

	
	/**
	 * 선수 정보를 추가하고 List에 저장하는 메소드
	 */
	public static void addPlayer() {

		Scanner sc = new Scanner(System.in);
		String position = "";
		String playerNum = "";
		String name = "";
		String height = "";
		String weight = "";

		boolean addPlayerFlag = true;
		while (addPlayerFlag) {


			System.out.print("\t\t\t\t\t    포지션(0. 뒤로가기) : ");
			position = sc.nextLine();
			if (position.equals("0")) {
				break;
			}

			System.out.print("\t\t\t\t\t    선수 번호 : ");
			playerNum = sc.nextLine();
			System.out.print("\t\t\t\t\t    선수 이름 : ");
			name = sc.nextLine();
			System.out.print("\t\t\t\t\t    키 : ");
			height = sc.nextLine();
			System.out.print("\t\t\t\t\t    몸무게 : ");
			weight = sc.nextLine();

			System.out.println();
			System.out.println("\t\t\t\t\t==================================");
			System.out.println("\t\t\t\t\t포지션\t선수번호\t선수 이름\t키    몸무게\t");
			System.out.println("\t\t\t\t\t==================================");
			System.out.printf("\t\t\t\t\t%s\t%s\t%s\t%s\t%s\n", position, playerNum, name, height, weight);
			System.out.println("\t\t\t\t\t----------------------------------");
			System.out.println();
			System.out.print("\t\t\t\t\t입력한 정보가 맞습니까?(y/n) : ");
			String answer = sc.nextLine().toUpperCase();

			if (answer.equals("Y")) {

				Calendar c = Calendar.getInstance();
				int last = Data.playerList.get(Data.playerList.size() - 1).getSeq();

				if (position.equals("타자")) {
					
					Player player = new Player(last + 1, TeamPlayer.teamList.get(SelectTeam.input - 1).getSeq(), c.get(Calendar.YEAR) + "", position, playerNum, name, height, weight, 0, 0, 0, 0, 0);
					Data.playerList.add(player);
					SelectTeam.playerList.add(player);

				} else if (position.equals("투수")) {
					Player player = new Player(last + 1, TeamPlayer.teamList.get(SelectTeam.input - 1).getSeq(), c.get(Calendar.YEAR) + "", position, playerNum, name, height, weight, 0, 0, 0, 0);
					Data.playerList.add(player);
					SelectTeam.playerList.add(player);

				}
				
				System.out.println();
				System.out.println("\t\t\t\t\t등록이 완료되었습니다.");
				System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
				String enter = sc.nextLine();
				break;

			} else if (answer.equals("N")) {
				System.out.println();
				System.out.println("\t\t\t\t\t등록이 취소되었습니다.");
				System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
				String enter = sc.nextLine();
				break;
				
			} else {

			}
			// 입력한 정보 확인받기(y/n)
		}

	}
}
