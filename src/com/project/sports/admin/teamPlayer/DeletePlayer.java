package com.project.sports.admin.teamPlayer;

import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 선수를 삭제하는 클래스
 * @author 서주예
 */
public class DeletePlayer {

	
	/**
	 * 선수를 삭제하고 List에서도 삭제하는 메소드
	 */
	public static void deletePlayer() {
		
		Scanner sc = new Scanner(System.in);
		
		boolean deletePlayerFlag = true;
		while(deletePlayerFlag) {
			
			//삭제할 선수 입력받기
			System.out.print("\t\t\t\t\t    삭제할 선수를 선택하세요. : ");
			String input = sc.nextLine();
			
			if(input.equals("0")) {
				Output.backMsg();
				break;
			}
			
			System.out.println();
			System.out.printf("\t\t\t\t\t<%s>\n" , SelectTeam.playerList.get(Integer.parseInt(input) - 1).getName());
			System.out.print("\t\t\t\t\t삭제할 선수가 맞습니까?(y/n) : ");
			String answer = sc.nextLine().toUpperCase();
			
			if(answer.equals("Y")) {
				
				for (int i=0; i<Data.playerList.size(); i++) {

					Player player = Data.playerList.get(i);
					
					if (SelectTeam.playerList.get(Integer.parseInt(input) - 1)
							.getSeq() == player.getSeq()) {

						Data.playerList.remove(player);
					}

				}
				
				System.out.println();
				System.out.println("\t\t\t\t\t삭제가 완료되었습니다.");
				System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
				String enter = sc.nextLine();
				break;
				
			} else if(answer.equals("N")) {
				
				System.out.println();
				System.out.println("\t\t\t\t\t삭제가 취소되었습니다.");
				System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
				String enter = sc.nextLine();
				break;
			}
			
			//확인받기(y/n)
			//계속하시려면 엔터받기
		}
		
		
	}
}
