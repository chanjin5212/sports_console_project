package com.project.sports.admin.bannedword;

import java.util.Scanner;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
/**
 * 금지어 등록 클래스입니다.
 * @author 강지윤
 *
 */
public class AddBannedWord {
	
	/**
	 * 등록할 금지어를 입력받고 금지어 리스트에 추가합니다.
	 */
	public static void addBannedWord () {
		//등록됨. -> txt파일에 save하는건 아직 안함!
		
		
		Scanner sc = new Scanner(System.in);
		boolean addBannedWordFlag = true;

		while (addBannedWordFlag) {
			
			//등록할 금지어 받기
			
			System.out.print("\t\t\t\t\t    등록할 금지어를 입력하세요. (0.뒤로가기) : ");
			String input = sc.nextLine(); // 등록할 금지어 받기
			


			if (input.equals("")) { 
				
				System.out.println("\t\t\t\t\t\t내용을 입력해주세요.");
				
			} else if (input.equals("0")) {
				
				Output.backMsg();
				break;
				
			} else { // 유효성검사

			}
			
			//확인
			System.out.printf("\t\t\t\t\t\t\t    \"%s\"\n", input);
			System.out.print("\t\t\t\t\t\t   등록할 금지어가 맞습니까?(Y/N): ");
			String answer = sc.nextLine().toUpperCase();
			
			int lastSeq = Data.bannedWordList.get(Data.bannedWordList.size()-1).getSeq() + 1;
			
			
			if(answer.equals("Y")) {
				
				BannedWord bannedWord = new BannedWord(lastSeq, input);
				Data.bannedWordList.add(bannedWord);
				System.out.println("\t\t\t\t\t\t      등록이 완료되었습니다.");
				System.out.println("\t\t\t\t\t     엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
				Scanner scanner = new Scanner(System.in);
			    scanner.nextLine();
			    addBannedWordFlag = false;
				
			} else if (answer.equals("N")) {
				System.out.println("\t\t\t\t\t\t\t등록을 취소합니다.");
				System.out.println("\t\t\t\t\t엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
				Scanner scanner = new Scanner(System.in);
			    scanner.nextLine();
			    addBannedWordFlag = false;
			} 
			
			
			
			System.out.println();
			
		}
		
	}
}
