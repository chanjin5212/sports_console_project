package com.project.sports.user.community.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Post;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.community.DetailId;
import com.project.sports.user.community.DetailTitle;

/**
 * 제목을 기준으로 글 검색하는 클래스입니다.
 * @author 김영석
 *
 */
public class SearchTitle {
	
	/**
	 * 검색할 제목을 입력합니다.
	 */
	public static void searchTitle() { // 제목으로 검색하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t\t\t\t 검색하실 제목을 입력해 주세요.:");
		String id = sc.nextLine();
		DetailTitle.detail(id);
		
		
	}

}
