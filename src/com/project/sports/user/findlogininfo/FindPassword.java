package com.project.sports.user.findlogininfo;

import java.util.Scanner;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 비밀번호를 찾는 클래스
 * @author 서주예
 */
public class FindPassword {

	
	/**
	 * 비밀번호를 찾는 메소드
	 */
	public static void findPassword() {

		String name = "";
		String id = "";
		String phoneNumber = "";
		Scanner sc = new Scanner(System.in);

		boolean findPasswordFlag = true;
		while (findPasswordFlag) {

			System.out.println();
			Output.oneLine();
			System.out.println("\t\t\t\t\t\t[비밀번호 찾기]");
			System.out.println("\t\t\t\t\t\t회원가입시 등록한 아이디, 이름, 전화번호를 입력하세요.");
			System.out.println("\t\t\t\t\t\t0을 입력하면 작업을 취소하고 뒤로 갑니다.");

			boolean findIdFlag = true;
			while (findIdFlag) {

				System.out.print("\t\t\t\t\t\tID : ");
				id = sc.nextLine();

				if (id.equals("0")) {
					findIdFlag = false;
					findPasswordFlag = false;
					Output.backMsg();
					break;
				}

				boolean findNameFlag = true;
				while (findNameFlag) {

					System.out.print("\t\t\t\t\t\t이름 : ");
					name = sc.nextLine();

					if (name.equals("0")) {
						findNameFlag = false;
						Output.backMsg();
						break;
					}

					boolean findPhoneNumberFlag = true;
					while (findPhoneNumberFlag) {

						System.out.print("\t\t\t\t\t\t전화번호 : ");
						phoneNumber = sc.nextLine();

						if (phoneNumber.equals("0")) {
							findPhoneNumberFlag = false;
							Output.backMsg();
							break;
						}

						User user = null;
						for (User u : Data.userList) {

							if (u.getName().equals(name) && u.getId().equals(id)
									&& u.getNumber().equals(phoneNumber)) {

								// 이름, 전화번호, 아이디가 모두 일치하면
								user = u;
							}

						}

						if (user == null) {

							System.out.println();
							System.out.println("\t\t\t\t\t\t일치하는 비밀번호가 없습니다.");
							findPhoneNumberFlag = false;
							findNameFlag = false;
							findIdFlag = false;
							findPasswordFlag = false;
							Output.backMsg();
							break;

						} else {
							String line =
									String.format("\t\t\t\t\t\t가입한 비밀번호 : %s", user.getPassword());
							System.out.println();
							System.out.println(line);
							System.out.println("\t\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
							String input = sc.nextLine();
							findPhoneNumberFlag = false;
							findNameFlag = false;
							findIdFlag = false;
							findPasswordFlag = false;
							Output.backMsg();
						}
					}

				}


			}

		}


	}
}
