package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.user.community.DetailId;

/**
 * 작성자 아이디를 기준으로 검색하는 클래스입니다.
 * @author 김영석
 *
 */
public class SearchId {
	
	/**
	 * 검색할 아이디를 입력합니다.
	 */
	public static void searchId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t\t\t\t 검색하실 아이디를 입력해 주세요.:");
		String id = sc.nextLine();
		DetailId.detail(id);
	}

}
