package com.project.sports.user.ticketingmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.project.sports.output.Output;
/**
 * 구역을 선택하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class Area {
	
	public static String area = "";
	public List<String> seat = new ArrayList<String>();
	public static boolean AreaSelectFlag = true;
	/**
	 * 구역을 선택하는 메소드 입니다.
	 */
	public static void areaSelect() {
		
		while (AreaSelectFlag) {
			System.out.println();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\t\t\t\t\t                          \r\n"
					+ "\t\t\t\t\t           ■■■■■■■■■■■■■        \r\n"
					+ "\t\t\t\t\t       ■         ■        ■     \r\n"
					+ "\t\t\t\t\t     ■           ■          ■   \r\n"
					+ "\t\t\t\t\t    ■     A      ■      B    ■  \r\n"
					+ "\t\t\t\t\t   ■          ■■■■■■■         ■ \r\n"
					+ "\t\t\t\t\t  ■         ■        ■         ■ \r\n"
					+ "\t\t\t\t\t  ■        ■           ■       ■ \r\n"
					+ "\t\t\t\t\t  ■■■■■■■■■■           ■■■■■■■■■ \r\n"
					+ "\t\t\t\t\t  ■        ■           ■       ■ \r\n"
					+ "\t\t\t\t\t  ■         ■         ■        ■ \r\n"
					+ "\t\t\t\t\t   ■          ■     ■         ■ \r\n"
					+ "\t\t\t\t\t    ■    C       ■     D     ■  \r\n"
					+ "\t\t\t\t\t     ■           ■          ■   \r\n"
					+ "\t\t\t\t\t      ■          ■         ■     \r\n"
					+ "\t\t\t\t\t        ■■■      ■      ■■■       \r\n"
					+ "\t\t\t\t\t            ■■■■■■■■■■■           \r\n"
					+ "");
			
			System.out.print("\t\t\t\t\t\t구역 선택(A,B,C,D)(0.뒤로가기):");
			String input = sc.nextLine();
			if (input.equals("0")) {
				Output.backMsg();
				break;
			} else if (input.equals("A") 
					|| input.equals("B")
					|| input.equals("C")
					|| input.equals("D")) {
				area = input;
				Seat.seatFlag = true;
				Seat.seat(input);
			} else {
				System.out.println("\t\t\t\t\t잘못된 구역 입력입니다.");
			}
			
		}
		
	}

}
