package com.project.sports.admin.ticketing;

import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.output.Output;

/**
 * 예매관리 클래스입니다.
 * @author 강지윤
 *
 */
public class AdminTicketing {
	/**
	 * 예매 관리 메뉴를 출력받고, 사용자가 선택한 메뉴로 이동합니다.
	 */
	public static void adminTicketing() {

		
		Scanner sc = new Scanner(System.in);
		boolean adminTicketingFlag = true;

		while (adminTicketingFlag) { // 예매관리를 눌렀을때

			AdminOutput.AdminTicketingMenu(); // 예매 관리 메뉴 보여주기

			String input = sc.nextLine(); // 예매 관리 메뉴 번호 입력받기

			if (input.equals("1")) { // 1. 예매 내역 확인

				// 예매내역 확인 메소드 (클래스)
				SelectTicketingList.selectTicketingList();;

			} else if (input.equals("2")) { // 2. 매출 확인

				// 매출 확인 메소드 (클래스)
				SelectSalesList.selectSales();
				
			} else if (input.equals("0")) {

				Output.backMsg();
				adminTicketingFlag = false;

			} else { // 유효성검사

			}
		}

	}
}
