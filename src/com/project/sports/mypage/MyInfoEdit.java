package com.project.sports.mypage;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 회원 정보를 변경하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class MyInfoEdit {
	
	/**
	 * 회원 정보를 변경하는 메소드 입니다.
	 */
	public static void myInfoEdit() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.printf("\t\t\t\t\t │	      1. 이름:%s	    │\n", UserLogin.userData.getName());
			System.out.printf("\t\t\t\t\t │	 2.전화번호:%s	    │\n", UserLogin.userData.getNumber());
			System.out.printf("\t\t\t\t\t │	      3. 비밀번호     	    │\n");
			System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			Output.input();
			Pattern p;
			Matcher m;
			String input = sc.nextLine();
			if (input.equals("1")) {
				boolean nameFlag = true;
				while (nameFlag) {
					System.out.print("\t\t\t\t\t변경할 이름을 입력하시오(0.뒤로가기):");
					input = sc.nextLine();
					if (input.equals("0")) {
						break;
					}
					
					p = Pattern.compile("^[가-힣]{2,6}$");
			        m = p.matcher(input);
					
			        if (!m.find()) {
			        	System.out.println("\t\t\t\t\t유효하지 않은 이름입니다.");
			        } else {
			        	System.out.printf("\t\t\t\t\t수정 이름 : <%s>\n", input);
			        	System.out.print("\t\t\t\t\t수정할 내용이 맞습니까?(Y/N) :");
			        	String input1 = sc.nextLine();
			        	input1 = input1.toLowerCase();
			        	if (input1.equals("y")) {
			        		UserLogin.userData.setName(input);
			        		nameFlag = false;
			        		System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
			        		System.out.println("\t\t\t\t\t계속 하시려면 엔터(Enter)를 누르세요.");
			        		input = sc.nextLine();
			        		
			        	} else if (input1.equals("n")) {
			        		System.out.println("\t\t\t\t\t취소하셨습니다.");
			        		break;
			        	} else {
			        		System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			        	}
			        }
			        
			        
				}
			} else if (input.equals("2")) {
				boolean numberFalg = true;
				while(numberFalg) {
					System.out.println("\t\t\t\t\t\"-\"으로 구분해주세요.");
					System.out.print("\t\t\t\t\t변경할 전화번호를 입력하시오(0.뒤로가기) :");
					input = sc.nextLine();
					if (input.equals("0")) {
						break;
					}
					p = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");
					m = p.matcher(input);
					if (!m.find()) {
						System.out.println("\t\t\t\t\t유효하지 않은 전화번호입니다.");
					} else {
						System.out.printf("\t\t\t\t\t수정 전화번호 : <%s>\n", input);
						System.out.print("\t\t\t\t\t수정할 내용이 맞습니까?(Y/N) :");
						String input1 = sc.nextLine();
						input1 = input1.toLowerCase();
						if (input1.equals("y")) {
							UserLogin.userData.setNumber(input);
							numberFalg = false;
							System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
							System.out.println("\t\t\t\t\t계속 하시려면 엔터(Enter)를 누르세요.");
							input = sc.nextLine();
							
						} else if (input1.equals("n")) {
							System.out.println("\t\t\t\t\t취소하셨습니다.");
							break;
						} else {
							System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
						}
					}
					
				}
				
			} else if (input.equals("3")) {
				//소문자 대문자 8~16
				boolean passwordFalg = true;
				while(passwordFalg) {
					System.out.print("\t\t\t\t\t기존 비밀번호를 입력하세요(0.뒤로가기) :");
					input = sc.nextLine();
					if (input.equals(UserLogin.userData.getPassword())) {
						System.out.print("\t\t\t\t\t변경할 비밀번호를 입력하시오(0.뒤로가기) :");
						input = sc.nextLine();
						p = Pattern.compile("^[a-zA-Z0-9]{8,16}$");
						m = p.matcher(input);
						if (!m.find()) {
							System.out.println("\t\t\t\t\t유효하지 않은 비밀번호입니다.");
						} else {
							System.out.printf("\t\t\t\t\t수정 비밀번호 : <%s>\n", input);
							System.out.print("\t\t\t\t\t수정할 내용이 맞습니까?(Y/N) :");
							String input1 = sc.nextLine();
							input1 = input1.toLowerCase();
							if (input1.equals("y")) {
								UserLogin.userData.setPassword(input);
								passwordFalg = false;
								System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
								System.out.println("\t\t\t\t\t계속 하시려면 엔터(Enter)를 누르세요.");
								input = sc.nextLine();
								
							} else if (input1.equals("n")) {
								System.out.println("\t\t\t\t\t취소하셨습니다.");
								break;
							} else {
								System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
							}
						}
						
					} else if (input.equals("0")){
						break;
					} else {
						System.out.println("\t\t\t\t\t틀린 비밀번호를 입력하셨습니다.");
					}
					
				}
			} else if (input.equals("0")) {
				return;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
			
		}
		
	}

}
