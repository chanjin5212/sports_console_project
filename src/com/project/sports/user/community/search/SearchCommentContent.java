package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.user.community.DetailCommentId;

/**
 * 댓글 내용을 기준으로 검색하는 클래스입니다.
 * @author 김영석
 *
 */
public class SearchCommentContent {
	
	/**
	 * 댓글 내용을 입력합니다.
	 */
	public static void searchCommentContent() {
		
		
		System.out.print("\t\t\t\t\t\t 검색할 댓글내용을 입력해주세요.:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DetailCommentId.detail(input);
	}

}
