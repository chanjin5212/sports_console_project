package com.project.sports.user.community.search;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Scanner;
import com.project.sports.input.Comment;
import com.project.sports.input.Post;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;
import com.project.sports.user.community.Community;
import com.project.sports.user.community.DetailSubject;
import com.project.sports.user.community.OutCommunityMenu;

/**
 * 말머리를 기준으로 글을 검색하는 클래스
 * @author 김영석
 *
 */
public class SearchSubject {

	/**
	 * 검색할 말머리의 종류를 입력 받습니다.
	 */
	public static void searchSubject() {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("===========================================================================================================================");
			System.out.println("\t\t\t  ┌───────────────────────────────────────────────────────────────────────┐");
			System.out.println("\t\t\t  │    말머리를 입력해 주세요. (1.공지, 2.잡담, 3.이벤트, 4.직관, 5.질문, 0.뒤로가기)\t  │");
			System.out.println("\t\t\t  └───────────────────────────────────────────────────────────────────────┘");
			Output.input();
			String inSubjMenu = sc.nextLine();
			System.out.println("---------------------------------------------------------------------------------------------------------------------------");
			String subjectTxt = "";
			
			//어떤 말머리를 검색하려는지 찾기
			if (inSubjMenu.equals("1")) {
				subjectTxt = "공지";
			} else if (inSubjMenu.equals("2")) {
				subjectTxt = "잡담";
			} else if (inSubjMenu.equals("3")) {
				subjectTxt = "이벤트";
			} else if (inSubjMenu.equals("4")) {
				subjectTxt = "직관";
			} else if (inSubjMenu.equals("5")) {
				subjectTxt = "질문";
			} else if (inSubjMenu.equals("0")) {
				break;
			} else {
				OutCommunityMenu.outMenuError(); //오류메시지
//				OutCommunityMenu.outContinuMsg();
//				sc.nextLine();
			}
			
			DetailSubject.detail(subjectTxt);
			
		}
	}



}
