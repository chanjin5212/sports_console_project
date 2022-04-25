package com.project.sports.mypage;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 회원의 예매내역을 보여주는 클래스입니다.
 * @author 김찬진
 *
 */
public class MyTicketing {

	/**
	 * 회원의 예매내역을 확인하고 취소할 수 있는 메소드입니다.
	 */
	public static void myTicketing() {
		while (true) {
			ArrayList<Ticketing> ticketingList = new ArrayList<Ticketing>();
			ArrayList<Schedule> scheduleList = new ArrayList<Schedule>();
			System.out.println("\t\t========================================================================================");
			System.out.println("\t\t[번호]	[경기 날짜]		[경기 정보]		[경기장]		[구역]	[좌석번호]");
			System.out.println("\t\t========================================================================================");
			int seq = 1;
			for (Ticketing t : Data.ticketingList) {
				if (UserLogin.userData.getId().equals(t.getId())) {
					for (Schedule s : Data.scheduleList) {
						if (t.getScheduleSeq() == s.	getSeq()) {
							System.out.printf("\t\t%d	%tF	%s vs %s		%-11s	%s	   %s\n",
									seq, s.getDate(), s.getTeam1(), s.getTeam2(), s.getPlace(),
									t.getBlock(), t.getSeatNum());
							ticketingList.add(t);
							scheduleList.add(s);
							seq++;
						}
					}
				}
			}
			System.out.println("\t\t----------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │       1. 예매 내역 취소하기	    │");
			System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			Output.input();
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input.equals("1")) {
				boolean cancelFlag = true;
				while (cancelFlag) {
					System.out.print("\t\t\t\t\t취소할 경기의 번호를 입력하시오(0.뒤로가기) :");
					input = sc.nextLine();
					if (input.equals("0")) {
						break;
					} else if (Integer.parseInt(input) > ticketingList.size()) {
						System.out.println("\t\t\t\t\t올바르지 않은 번호입니다.");
					} else {
						Schedule pick1 = scheduleList.get(Integer.parseInt(input) - 1);
						Ticketing pick2 = ticketingList.get(Integer.parseInt(input) - 1);
						System.out.println("\t\t========================================================================================");
						System.out.println("\t\t[번호]	[경기 날짜]		[경기 정보]		[경기장]		[구역]	[좌석번호]");
						System.out.println("\t\t========================================================================================");
						System.out.printf("\t\t%d	%tF	%s vs %s		%s		%s	%s\n"
								, Integer.parseInt(input),
								pick1.getDate(), pick1.getTeam1(), pick1.getTeam2(),
								pick1.getPlace(), pick2.getBlock(), pick2.getSeatNum());
						System.out.println("\t\t----------------------------------------------------------------------------------------");
						while (true) {
							System.out.print("\t\t\t\t해당 경기의 예매를 취소하시려면 비밀번호를 입력하시오. (0.뒤로가기) :");
							input = sc.nextLine();
							if (input.equals("0")) {
								break;
							} else if (input.equals(UserLogin.userData.getPassword())) {
								Ticketing a = null;
								for (Ticketing t : Data.ticketingList) {
									if (t.equals(pick2)) {
										a = t;
									}
								}
								Data.ticketingList.remove(a);
								System.out.println("\t\t\t\t\t정상적으로 취소되었습니다.");
								System.out.println("\t\t\t\t\t엔터(Enter)를 누르면 이전 메뉴로 돌아갑니다.");
								input = sc.nextLine();
								cancelFlag = false;
								break;
							} else {
								System.out.println("\t\t\t\t\t올바르지 않은 비밀번호 입니다.");
							}

						}

					}

				}
			} else if (input.equals("0")) {
				return;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
				break;
			}



		}


	}

}
