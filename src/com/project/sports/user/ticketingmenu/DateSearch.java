package com.project.sports.user.ticketingmenu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Schedule;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 예매할 날짜를 선택하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class DateSearch {
	
	public static ArrayList<Integer> numList = new ArrayList<Integer>();
	public static int select;
	public static boolean gameFlag = true;
	/**
	 * 	선택한 날짜로 예매가 가능한지 구분하는 메소드입니다.
	 * @param input 선택한 날짜를 저장하는 변수입니다.
	 */
	public static void game(String input) {
		System.out.println();
		
		if (input.equals("0")) {
			return;
		}
		Scanner sc = new Scanner(System.in);
		while (gameFlag) {
			
			String[] temp = input.split("-");
			
			Calendar c = Calendar.getInstance();
			c.set(Calendar.MONTH, Integer.parseInt(temp[0])-1); //04-13
			c.set(Calendar.DATE, Integer.parseInt(temp[1]));
			String date = String.format("%tF", c); //2022-04-13
			System.out.println("\t\t\t===============================================================================");
			System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
			System.out.println("\t\t\t===============================================================================");
			int num = 1;
			ArrayList<Integer> numList = new ArrayList<Integer>();
			for (Schedule s : Data.scheduleList) {
				
				String date1 = String.format("%tF", s.getDate());
				
				if (date.equals(date1)) {
					System.out.printf("\t\t\t%d	%tF	%s vs %s	 %s	    %s\n", num
							, s.getDate()
							, s.getTeam1()
							, s.getTeam2()
							, s.getPlace()
							, s.getTime());
					numList.add(s.getSeq());
					num++;
				}
				
			}
			System.out.println("\t\t\t-------------------------------------------------------------------------------");
			if (num == 1) {
				System.out.println("\t\t\t\t\t입력하신 날짜는 예매 불가능한 날짜입니다.");
			}
			System.out.print("\t\t\t\t\t\t   번호 (0.뒤로가기): ");
			input = sc.nextLine();
			if (input.equals("0")) {
				Output.backMsg();
				break;
			} else if (Integer.parseInt(input) <= numList.size()) {
				select = numList.get(Integer.parseInt(input)-1);
				Area.AreaSelectFlag = true;
				Area.areaSelect();
				return;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
			
			
		}
		
		
		
	}

}
