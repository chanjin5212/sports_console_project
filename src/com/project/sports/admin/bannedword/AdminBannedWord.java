package com.project.sports.admin.bannedword;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.sports.admin.AdminOutput;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 금지어 관리 메뉴 클래스입니다.
 * @author 강지윤
 *
 */
public class AdminBannedWord {
	

	public static List<BannedWord> BannedWordList = new ArrayList<BannedWord>();
	/**
	 * 금지어 관리 메뉴를 출력하고 사용자가 선택한 메뉴로 이동합니다.
	 */
	public static void bannedWord() {
	//ArrayList<BannedWord> bannedWordList;
		
		
		Scanner sc = new Scanner(System.in);
		boolean bannedWordFlag = true;

		while (bannedWordFlag) { // 금지어 관리를 눌렀을때
			
			
			
			//금지어 목록 출력
			
			BannedWordList = new ArrayList<BannedWord>();
			
			System.out.println();
			System.out.println("\t\t\t\t\t\t\t============");
			System.out.println("\t\t\t\t\t\t\t번호 금지어");
			System.out.println("\t\t\t\t\t\t\t============");
			for (BannedWord b : Data.bannedWordList) {
	
				System.out.printf("\t\t\t\t\t\t\t%d %s\n", b.getSeq(), b.getBannedWord());
				BannedWordList.add(b); //다 넣기
				
				
			}
			
			System.out.println("\t\t\t\t\t\t\t------------");
			
			System.out.println();
			System.out.println();
			
			// 금지어 관리 메뉴 보여주기
			
			AdminOutput.bannedWordMenu();
			
			String input = sc.nextLine(); // 금지어 관리 메뉴 번호 입력받기

			if (input.equals("1")) { // 1. 금지어 등록
				
				AddBannedWord.addBannedWord();

			} else if (input.equals("2")) { // 2. 금지어 수정

				EditBannedWord.editBannedWord();
				
			} else if (input.equals("3")) { //3. 금지어 삭제
				
				DeleteBannedWord.deleteBannedWord();
				
			} else if (input.equals("0")) {
				
				Output.backMsg();
				bannedWordFlag = false;

			} else { // 유효성검사

			}
		}
		
		
		
		
	}
}
