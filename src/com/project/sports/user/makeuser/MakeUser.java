package com.project.sports.user.makeuser;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 회원가입하는 클래스
 * @author 서주예
 */
public class MakeUser {

	
	// 회원가입
	/**
	 * 회원가입하는 메소드
	 */
	public static void makeUser() {

		boolean juminFlag = false;
		boolean idFlag = false;
		boolean passwordFlag = false;
		boolean phoneNumberFlag = false;
		boolean checkFlag = false;

		Pattern p;
		Matcher m;
		String name = "";
		String jumin = "";
		String id = "";
		String password = "";
		String phoneNumber = "";

		// **
		Scanner sc = new Scanner(System.in);

		// 이름
		boolean nameFlag = true;
		while (nameFlag) { //***

			Output.oneLine();;
			Output.menuBack();
			System.out.println();
			System.out.print("\t\t\t\t\t\t이름(2~6글자, 한글만) : "); //%%
			name = sc.nextLine();
			p = Pattern.compile("^[가-힣]{2,6}$");
			m = p.matcher(name);

			if (name.equals("0")) { // 뒤로가기 **
				Output.backMsg();
				break;
			}

			boolean isName = true;
			while (isName) {
				if (m.find()) { // 유효성 검사에 통과하면 

					isName = false; //^^
					juminFlag = true;

				} else if (!m.find()) { // 유효성 검사 통과 못하면 %%
					System.out.println("\t\t\t\t\t\t유효한 이름을 입력해주세요!");
					System.out.println();
					isName = false;
				}
			}


			// 주민등록번호
			nameFlag = true;
			while (juminFlag) { //^^ -> 유효성 검사를 통과해야지만 true로 바뀜 (원래는 false)
				
				//이름 유효성 검사를 성공해서 넘어옴
				System.out.println();
				Output.menuBack();
				System.out.print("\t\t\t\t\t\t주민등록번호 : ");
				jumin = sc.nextLine();
				p = Pattern.compile("^[0-9]{6}-?([1-2]{1})$");
				m = p.matcher(jumin);

				if (jumin.equals("0")) { // 뒤로가기
					Output.backMsg();
					break; //***
				}
				
				boolean isJumin = true;
				while(isJumin) {
					
					if (m.find()) {
						isJumin = false;
						juminFlag = false;
						idFlag = true;
					} else if(!m.find()) {
						System.out.println("\t\t\t\t\t\t잘못 입력하였습니다. 다시 입력해주세요.");
						System.out.println();
						isJumin = false;
					}
					
				}

				juminFlag = true;
				while (idFlag) {

					boolean flag = true;
					System.out.println();
					Output.menuBack();
					System.out.print("\t\t\t\t\t\tID : ");
					id = sc.nextLine();
					p = Pattern.compile("^[a-zA-Z0-9]{4,16}$");
					m = p.matcher(id);
					
					if (id.equals("0")) { // 뒤로가기
						Output.backMsg();
						break;
					}
					
					boolean isIdFlag = true;
					while(isIdFlag) {
						
						if (m.find()) { //유효성 검사를 통과하면 해당 id가 있는지 list와 비교

							for (User user : Data.userList) {

								if (id.equals(user.getId())) { //아이디가 같은 게 있으면
									System.out.println("\t\t\t\t\t\t중복되는 아이디입니다."); 
									break;
								} else { //유효성검사도 통과 + 중복 아이디도 없음
									isIdFlag = false;
									passwordFlag = true;
								}
							}

						} else if(!m.find()) { //유효성 검사가 일치하지 않으면
							
							System.out.println("\t\t\t\t\t\t잘못 입력하였습니다. 다시 입력해주세요.");
							System.out.println();
							isIdFlag = false;
						}
						
					}

					idFlag = true;
					while (passwordFlag) {

						System.out.println();
						Output.menuBack();
						System.out.print("\t\t\t\t\t\tPassword : ");
						password = sc.nextLine();
						p = Pattern.compile("^[a-zA-Z0-9]{8,16}$");
						m = p.matcher(password);

						if (password.equals("0")) { // 뒤로가기
							Output.backMsg();
							break;
						}
						
						boolean isPasswordFlag = true;
						while(isPasswordFlag) {
							if (m.find()) {
								isPasswordFlag = false;
								passwordFlag = false;
								phoneNumberFlag = true;
								break;
							} else if(!m.find()) {
								System.out.println("\t\t\t\t\t\t잘못 입력하였습니다. 다시 입력해주세요.");
								System.out.println();
								isPasswordFlag = false;
							}

						}
						
						passwordFlag = true;
						while (phoneNumberFlag) {

							System.out.println();
							Output.menuBack();
							System.out.print("\t\t\t\t\t\t전화번호 : ");
							phoneNumber = sc.nextLine();

							p = Pattern.compile("^(010)-?([0-9]{4})-?([0-9]{4})$");
							m = p.matcher(phoneNumber);
							
							if (phoneNumber.equals("0")) { // 뒤로가기
								Output.backMsg();
								break;
							}

							boolean isPhoneNumberFlag = true;
							while(isPhoneNumberFlag) {
								if (m.find()) {
									phoneNumber = String.format("%s-%s-%s", m.group(1), m.group(2),
											m.group(3));
									isPhoneNumberFlag = false;
									phoneNumberFlag = false;
									checkFlag = true;
								} else if (!m.find()) {
									System.out.println("\t\t\t\t\t\t잘못 입력하였습니다. 다시 입력해주세요.");
									System.out.println();
									isPhoneNumberFlag = false;
								}
							}

							phoneNumberFlag = true;
							while (checkFlag) {
								System.out.println();
								System.out.print("\t\t\t\t\t\t회원가입하시겠습니까?(y/n) : ");
								String answer = sc.nextLine();

								if (answer.equals("y")) {

									// 경고누적회수는 모두다 0으로 설정

									int last = Data.userList.get(Data.userList.size() - 1).getSeq();
									User user = new User(last, name, phoneNumber, phoneNumber, id,
											password, 0, 0);
									Data.userList.add(user);

									System.out.println();
									System.out.println("\t\t\t\t\t\t회원가입이 완료되었습니다.");
									System.out.println();
									checkFlag = false;
									phoneNumberFlag = false;
									passwordFlag = false;
									juminFlag = false;
									idFlag = false;
									nameFlag = false;


								} else if (answer.equals("n")) {

									System.out.println();
									System.out.println("\t\t\t\t\t\t회원가입이 취소되었습니다.");
									System.out.println();
									checkFlag = false;
									phoneNumberFlag = false;
									passwordFlag = false;
									juminFlag = false;
									idFlag = false;
									nameFlag = false;

								}
							}
						}
					}
				} // while
			} // while-jumin

		} // while-name



	}// makeUser

}
