package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.user.community.DetailContent;

/**
 * 글의 내용을 기준으로 글을 검색하는 클래스입니다.
 * @author 김영석
 *
 */
public class SearchContent {
	
	/**
	 * 검색할 내용을 입력합니다.
	 */
	public static void searchContent() {
		
		System.out.print("\t\t\t\t\t\t 검색할 내용을 입력해주세요.:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DetailContent.detail(input);
		
	}

}
