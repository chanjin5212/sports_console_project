package com.project.sports.user.findlogininfo;

import java.util.Scanner;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 아이디를 찾는 클래스
 * @author 서주예
 */
public class FindId {

	
	/**
	 * 아이디를 찾는 메소드
	 */
	public static void findId() {

		Scanner sc = new Scanner(System.in);
		String name = "";
		String phoneNumber = "";

		boolean findIdFlag = true;
		while (findIdFlag) {

			System.out.println();
			Output.oneLine();
			System.out.println("\t\t\t\t\t\t       [아이디 찾기]");
			System.out.println("\t\t\t\t\t    회원가입시 등록한 이름과 전화번호를 입력하세요.");
			System.out.println("\t\t\t\t\t    0을 입력하면 작업을 취소하고 뒤로 돌아갑니다.");

			boolean findNameFlag = true;
			while (findNameFlag) {

				System.out.print("\t\t\t\t\t\t이름 : ");
				name = sc.nextLine();
				if (name.equals("0")) {
					Output.backMsg();
					findIdFlag = false;
					break;
				}

				boolean isphoneNumberFlag = true;
				while (isphoneNumberFlag) {

					System.out.print("\t\t\t\t\t\t전화번호 : ");
					phoneNumber = sc.nextLine();
					if (phoneNumber.equals("0")) {
						findNameFlag = false;
						Output.backMsg();
						break;
					} else { // 전화번호를 입력하면

						User user = null;
						for (User u : Data.userList) {

							if (u.getName().equals(name) && u.getNumber().equals(phoneNumber)) {
								
								user = u;						

							} 
						}
						
						if(user == null) { // 일치하는 정보가 없는 경우
							System.out.println();
							System.out.println("\t\t\t\t\t    일치하는 아이디가 없습니다.");
							System.out.println("\t\t\t\t\t    Enter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
							String input = sc.nextLine();
							isphoneNumberFlag = false;
							findNameFlag = false;
							findIdFlag = false;
							Output.backMsg();

							break;
						} else {
							String line = String.format("\t\t\t\t\t    회원가입한 아이디는 %s 입니다.", user.getId());
							System.out.println();
							System.out.println(line);
							System.out.println("\t\t\t\t\t    Enter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
							String input = sc.nextLine();
							isphoneNumberFlag = false;
							findNameFlag = false;
							findIdFlag = false;
							Output.backMsg();
						}

					}

				}
			}

		}


	}
}

