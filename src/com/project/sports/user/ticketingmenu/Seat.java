package com.project.sports.user.ticketingmenu;

import java.util.ArrayList;
import java.util.Scanner;
import com.project.sports.input.Ticketing;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 좌석을 선택하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class Seat {
	
	public static String seat;
	public static boolean seatFlag = true;
	
	/**
	 * 사용자가 입력한 구역에 저장된 예매가 있는지 확인하고 좌석을 선택하는 메소드 입니다.
	 * @param in 사용자가 입력한 구역
	 */
	public static void seat(String in) {
		System.out.println();
		System.out.println("\t\t\t\t\t=============================================");
		Scanner sc = new Scanner(System.in);
		
		while (seatFlag) {
			ArrayList<String> userSeat = new ArrayList<String>();
			String[][] seatsArray = new String[8][9];
			
			for(int i = 0; i < seatsArray.length; i++ ) {
				for(int j = 0; j < seatsArray[0].length; j++) {
					for(Ticketing t : Data.ticketingList) {
							if (t.getScheduleSeq() == DateSearch.select) {
								if (t.getBlock().equals(Area.area + "구역")) {
								
								int row = (int)(t.getSeatNum().charAt(0)) - 65 ;
								int col = Integer.parseInt(t.getSeatNum().substring(1,t.getSeatNum().length())) - 1;
								seatsArray[row][col] = "■"; 
								userSeat.add(t.getSeatNum());
							}
						}
						
					}
				}
			}
			
			for(int i = 0; i < seatsArray.length; i++ ) {
				for(int j = 0; j < seatsArray[0].length; j++) {
					if(seatsArray[i][j] == null) {
						seatsArray[i][j] = "□";
					}else {
						continue;
					}
				}
			}
			
			System.out.println("\t\t\t\t\t   1    2    3    4    5    6    7    8    9    ");
			//좌석 보여주는 코드
			for(int i = 0; i < seatsArray.length; i++ ) {
				System.out.print("\t\t\t\t\t");
				System.out.print((char)(i + 65) + "  ");
				for(int j = 0; j < seatsArray[0].length; j++) {
					System.out.printf(seatsArray[i][j] + "    ");
				}
				System.out.println();
			}
			System.out.println("\t\t\t\t\t=============================================");
			System.out.println("\t\t\t\t\t■:예매 불가");
			System.out.println("\t\t\t\t\t□:예매 가능");
			System.out.print("\t\t\t\t\t\t입력(예시:F8)(0.뒤로가기):");
			String input = sc.nextLine();
			if (input.equals("0")) {
				Output.backMsg();
				break;
			} else if (userSeat.contains(input)) {
				System.out.println("\t\t\t\t\t예매 불가능한 좌석입니다.");
				System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
				String stop = sc.nextLine();
			} else if (input.length() == 2
					&& input.charAt(0) >= 65
					&& input.charAt(0) <= 90) {
				seat = input;
				Payment.paymentFlag = true;
				Payment.payment();
				return;
			} else {
				System.out.println("\t\t\t\t\t잘못된 좌석 번호 입니다.");
			}
						
		}
		
		
	}

}
