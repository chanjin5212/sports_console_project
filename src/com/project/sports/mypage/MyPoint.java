package com.project.sports.mypage;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Point;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 회원의 포인트를 관리하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class MyPoint {
	/**
	 * 회원의 포인트를 충전하거나 충전 내역을 볼 수 있는 메소드 입니다.
	 */
	public static void myPoint() {
		while (true) {
			System.out.println("\t\t\t\t\t\t=====================");
			System.out.printf("\t\t\t\t\t\t[현재 포인트 잔액]:%,dP\n", UserLogin.userData.getPoint());
			System.out.println("\t\t\t\t\t\t=====================");
			
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │            1. 포인트 충전	    │");
			System.out.println("\t\t\t\t\t │            2. 포인트 내역	    │");
			System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			Output.input();
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.equals("0")) {
				return;
			} else if (input.equals("1")) {
				while (true) {
					final String REGEX = "[0-9]+";
					System.out.print("\t\t\t\t\t충전 포인트 (최소 1,000p) (0.뒤로가기) :");
					String money = sc.nextLine();
					if (money.equals("0")) {
						break;
					} else if (Integer.parseInt(money) < 1000) {
						System.out.println("\t\t\t\t\t최소 충전 포인트는 1,000P 입니다.");
						
					} else if (money.matches(REGEX)) {
						
						System.out.println("\t\t\t\t\t\t=====================");
						System.out.printf("\t\t\t\t\t\t[충전 포인트]:%,d\n", Integer.parseInt(money));
						System.out.println("\t\t\t\t\t\t=====================");
						System.out.printf("\t\t\t\t\t%,dP 충전이 맞습니까?(충전 후 잔액 %,dP)(Y/N) :"
								, Integer.parseInt(money)
								, UserLogin.userData.getPoint() + Integer.parseInt(money));
						input = sc.nextLine().toLowerCase();
						if (input.equals("y")) {
							UserLogin.userData.setPoint(UserLogin.userData.getPoint() + Integer.parseInt(money));
							Calendar c = Calendar.getInstance();
							int last = Data.pointList.get(Data.pointList.size()-1).getSeq();
							Point p = new Point(last+1
												, UserLogin.userData.getId()
												, "+" + money
												, "포인트 충전"
												, c);
							Data.pointList.add(p);
							System.out.println("\t\t\t\t\t충전이 완료되었습니다.");
							System.out.println("\t\t\t\t\t엔터(Enter)를 누르면 이전 메뉴로 돌아갑니다.");
							input = sc.nextLine();
							break;
						} else if (input.equals("n")) {
							break;
						} else {
							System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
						}
					} else {
						System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
					}
					
				}
			} else if (input.equals("2")) {
				int num = 0;
				System.out.println("\t\t\t\t\t======================================");
				System.out.println("\t\t\t\t\t[날짜]		[내역]		[포인트]");
				System.out.println("\t\t\t\t\t======================================");
				for (Point p : Data.pointList) {
					if (UserLogin.userData.getId().equals(p.getId())) {
						
						System.out.printf("\t\t\t\t\t%tF	%-7s	 %s\n", p.getDate(), p.getDetail(), p.getChangePoint());
						num++;
						
					} 
				}
				System.out.println("\t\t\t\t\t--------------------------------------");
				System.out.println("\t\t\t\t\t엔터(Enter)를 누르면 이전 메뉴로 돌아갑니다.");
				input = sc.nextLine();
				if (num == 0) {
					System.out.println("\t\t\t\t\t사용 내역이 없습니다.");
				}
				
				
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
			
		}
	}

}
