package com.project.sports.user.ticketingmenu;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Point;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.main.Data;
import com.project.sports.user.UserLogin;

/**
 * 입력된 것을 기준으로 결제를 하는 클래스입니다.
 * @author 김찬진
 *
 */
public class Payment {
	
	public static boolean paymentFlag = true;
	/**
	 * 결제 정보를 확인하고 포인트가 부족하면 충전하는 메소드입니다.
	 */
	public static void payment() {
		System.out.println();
		Scanner sc = new Scanner(System.in);
		
		Schedule result = null;
		
		for (Schedule s : Data.scheduleList) {
			if (DateSearch.select == s.getSeq()) {
				result = s;
				break;
			}
		}
		while (paymentFlag) {
			System.out.println("\t\t====================================================================================");
			System.out.println("\t\t[경기 날짜]		[경기 정보]		[경기장]		[구역]	[좌석번호]");
			System.out.println("\t\t====================================================================================");
			System.out.printf("\t\t%tF	%s vs %s		%s		%s	%s\n"
					, result.getDate()
					, result.getTeam1()
					, result.getTeam2()
					, result.getTime()
					, Area.area
					, Seat.seat);
			System.out.println("\t\t------------------------------------------------------------------------------------");
			System.out.println();
			System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n):");
			String input = sc.nextLine();	
			input.toLowerCase();
			if (input.equals("y")) {
				pay();
			} else if (input.equals("n")) {
				break;
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
			
		} 
		
		
		
	}
	
	public static void pay() {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("\t\t\t\t\t\t결제 시 필요 포인트는 10,000p 입니다.");
			System.out.println("\t\t\t\t\t\t=====================");
			System.out.printf("\t\t\t\t\t\t[현재 포인트 잔액]:%,dP\n", UserLogin.userData.getPoint());
			System.out.println("\t\t\t\t\t\t=====================");
			if (UserLogin.userData.getPoint() < 10000) {
				boolean payFlag = true; 
				while(payFlag) {
					System.out.print("\t\t\t\t\t\t포인트가 부족합니다. 충전하시겠습니까?(y/n): ");
					String input = sc.nextLine();
					input.toLowerCase();
					if (input.equals("y")) {
						
						boolean moneyFlag = true;
						while(moneyFlag) {
							System.out.print("\t\t\t\t\t\t금액을 입력하세요(0.뒤로가기):");
							String money = sc.nextLine();
							if (money.equals("0")) {
								break;
							}
							final String REGEX = "[0-9]+";
							
							if (money.matches(REGEX)) {
								System.out.println("\t\t\t\t\t\t=====================");
								System.out.printf("\t\t\t\t\t\t[충전 포인트]:%,dP\n", Integer.parseInt(money));
								System.out.println("\t\t\t\t\t\t=====================");
								while(true) {
									System.out.print("\t\t\t\t\t\t입력하신 금액이 맞습니까?(y/n): ");
									input = sc.nextLine();
									input = input.toLowerCase();
									if (input.equals("y")) {
										UserLogin.userData.setPoint(UserLogin.userData.getPoint()+Integer.parseInt(money));
										Calendar c = Calendar.getInstance();
										int last = Data.pointList.get(Data.pointList.size()-1).getSeq();
										Point p = new Point(last+1
															, UserLogin.userData.getId()
															, "+" + money
															, "포인트 충전"
															, c);
										Data.pointList.add(p);
										System.out.println("\t\t\t\t\t\t충전이 완료되었습니다.");
										moneyFlag = false;
										payFlag = false;
										break;
									} else if (input.equals("n")) {
										break;
									} else {
										System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
									}
									
								}
							} else {
								System.out.println("\t\t\t\t\t숫자만 입력하세요.");
							}	
						}
					} else if (input.equals("n")) {
						return;
					} else {
						System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
					}		
				}
			} else {
				
				System.out.print("\t\t\t\t\t\t결제 하시겠습니까?(y/n):");
				String input = sc.nextLine();
				input.toLowerCase();
				if (input.equals("y")) {
					UserLogin.userData.setPoint(UserLogin.userData.getPoint() - 10000);
					Schedule result = null;
					
					for (Schedule s : Data.scheduleList) {
						if (DateSearch.select == s.getSeq()) {
							result = s;
							break;
						}
					}
					System.out.println();
					System.out.println("\t\t====================================================================================");
					System.out.println("\t\t[경기 날짜]		[경기 정보]		[경기장]		[구역]	[좌석번호]");
					System.out.println("\t\t====================================================================================");
					System.out.printf("\t\t%tF	%s vs %s		%s		%s	%s\n"
							
							, result.getDate()
							, result.getTeam1()
							, result.getTeam2()
							, result.getTime()
							, Area.area
							, Seat.seat);
					System.out.println("\t\t------------------------------------------------------------------------------------");
					System.out.println("\t\t\t\t\t입력하신 정보로 결제가 완료되었습니다.");
					System.out.println("\t\t\t\t\t엔터(Enter)를 누르면 이전 메뉴로 돌아갑니다.");
					int last = Data.ticketingList.get(Data.ticketingList.size()-1).getSeq();
					Ticketing t = new Ticketing(last + 1
											, UserLogin.userData.getId()
											, DateSearch.select
											, Area.area + "구역"
											, Seat.seat);
					
					Data.ticketingList.add(t);
					
					Calendar c = Calendar.getInstance();
					int last1 = Data.pointList.get(Data.pointList.size()-1).getSeq();
					Point p = new Point(last1+1
										, UserLogin.userData.getId()
										, "-" + 10000
										, "경기 예매"
										, c);
					Data.pointList.add(p);
					input = sc.nextLine();
					TicketingMenu.userTicketingFlag = false;
					Seat.seatFlag = false;
					DateSearch.gameFlag = false;
					Area.AreaSelectFlag = false;
					paymentFlag = false;
					return;
					
				} else {
					System.out.println("\t\t\t\t결제를 취소하셨습니다. 엔터(Enter)를 누르면 이전 메뉴로 돌아갑니다.");
					input = sc.nextLine();
					TicketingMenu.userTicketingFlag = false;
					Seat.seatFlag = false;
					DateSearch.gameFlag = false;
					Area.AreaSelectFlag = false;
					paymentFlag = false;
					return;
				}
				
			}	
		}
		
	}

}
