package com.project.sports.admin.bannedword;

import java.util.Scanner;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 금지어 수정 클래스입니다.
 * @author 강지윤
 *
 */
public class EditBannedWord {

	/**
	 * 수정할 금지어의 번호와 내용을 입력받고, 그 금지어를 입력받은 내용으로 수정합니다.
	 */
	public static void editBannedWord() {

		Scanner sc = new Scanner(System.in);
		boolean editBannedNumFlag = true;

		while (editBannedNumFlag) {

			System.out.print("\t\t\t\t\t  수정할 금지어의 번호를 선택하세요. (0. 뒤로가기) : ");
			String editNum = sc.nextLine();

			if (editNum.equals("")) {
				System.out.println("\t\t\t\t\t\t\t내용을 입력해주세요.");

			} else if (editNum.equals("0")) {
				Output.backMsg();
				break;

			} else { // 유효성검사

			}


			boolean editBannedWordFlag = true;
			while (editBannedWordFlag) {

				System.out.print("\t\t\t\t\t    수정할 금지어를 입력하세요. (0. 뒤로가기) : ");
				String editWord = sc.nextLine();


				if (editWord.equals("")) {
					System.out.println("\t\t\t\t\t\t\t내용을 입력해주세요.");

				} else if (editWord.equals("0")) {
					Output.backMsg();
					break;

				} else { // 유효성검사

				}
				

					System.out.print("\t\t\t\t\t\t금지어를 수정하시겠습니까? (Y/N) : ");
					String answer = sc.nextLine().toUpperCase();

					if (answer.equals("Y")) {


						for (BannedWord b : Data.bannedWordList) {
							
					
							if (b.getSeq() == AdminBannedWord.BannedWordList
									.get(Integer.parseInt(editNum) - 1).getSeq()) {
								
								
								b.setBannedWord(editWord);

							}

						}
						
						System.out.println("\t\t\t\t\t\t      수정이 완료되었습니다.");
						System.out.println("\t\t\t\t\t     엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
						Scanner scanner = new Scanner(System.in);
						scanner.nextLine();
						editBannedWordFlag = false;
						editBannedNumFlag = false;
						break;



					} else if (answer.equals("N")) {

						System.out.println("\t\t\t\t\t\t      수정을 취소합니다.");
						System.out.println("\t\t\t\t\t     엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
						Scanner scanner = new Scanner(System.in);
						scanner.nextLine();
						editBannedWordFlag = false;
						editBannedNumFlag = false;
						break;
					

				}


			}

		}

	}
}
