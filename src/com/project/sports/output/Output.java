package com.project.sports.output;

import java.util.Scanner;

public class Output {

	public static void mainLogo() {
		System.out.println(
				"\t   _____  .__  .__          ___.                  __      _________                     __          \r\n"
						+ "\t  /  _  \\ |  | |  |   _____ \\_ |__   ____  __ ___/  |_   /   _____/_____   ____________/  |_  ______\r\n"
						+ "\t /  /_\\  \\|  | |  |   \\__  \\ | __ \\ /  _ \\|  |  \\   __\\  \\_____  \\\\____ \\ /  _ \\_  __ \\   __\\/  ___/\r\n"
						+ "\t/    |    \\  |_|  |__  / __ \\| \\_\\ (  <_> )  |  /|  |    /        \\  |_> >  <_> )  | \\/|  |  \\___ \\ \r\n"
						+ "\t\\____|__  /____/____/ (____  /___  /\\____/|____/ |__|   /_______  /   __/ \\____/|__|   |__| /____  >\r\n"
						+ "        \\/                 \\/    \\/                             \\/|__|                           \\/ "
						+ "\r\n");
	}

	public static void startMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 로그인	            │");
		System.out.println("\t\t\t\t\t │            2. 회원가입		    │");
		System.out.println("\t\t\t\t\t │       3. 아이디/비밀번호 찾기	    │");
		System.out.println("\t\t\t\t\t │            4. 프로그램 종료	    │");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
	}

	public static void input() {


		System.out.print("\t\t\t\t\t\t 메뉴 번호 : ");
	}

	public static void loginMenu() {

		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │             1. 회원		    │");
		System.out.println("\t\t\t\t\t │             2. 관리자	   	    │");
		System.out.print("\t\t\t\t\t │\t       ");
		back();
		System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");

		input();
	}

	public static void typeMenu() {

		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │           1. 마이페이지		    │");
		System.out.println("\t\t\t\t\t │           2. 종목 선택하기	    │");
		System.out.print("\t\t\t\t\t │\t     ");
		back();
		System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");

		input();
	}

	public static void back() {
		System.out.print("0. 뒤로가기");
	}

	public static void selectTypeMenu() {

		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │              1. 야구		    │");
		System.out.println("\t\t\t\t\t │              2. 축구		    │");
		System.out.println("\t\t\t\t\t │              3. 배구		    │");
		System.out.println("\t\t\t\t\t │              4. 농구		    │");
		System.out.print("\t\t\t\t\t │\t        ");
		back();
		System.out.print("\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");

		input();
	}

	public static void mainMenu() {

		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │             1. 정보		    │");
		System.out.println("\t\t\t\t\t │             2. 일정		    │");
		System.out.println("\t\t\t\t\t │             3. 순위		    │");
		System.out.println("\t\t\t\t\t │             4. 예매		    │");
		System.out.println("\t\t\t\t\t │             5. 승부예측		    │");
		System.out.println("\t\t\t\t\t │             6. 커뮤니티		    │");
		System.out.print("\t\t\t\t\t │\t       ");
		back();
		System.out.print("\t    	    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");

		input();
	}

	public static void backMsg() {
		System.out.println();
		System.out.println("\t\t\t\t\t\t      뒤로 이동합니다.");
		System.out.println();
		System.out.println();
	}

	public static void pause() {
		System.out.println("\t\t\t\t\t\t 계속하시려면 [엔터]를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}

	public static void line() {

		System.out.println(
				"===========================================================================================================================");

	}

	public static void menuBack() {

		System.out.print("\t\t\t\t\t \t       ");
		back();
		System.out.print("\t\t    \n");

	}

	public static void oneLine() {
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------");
	}
	

}
