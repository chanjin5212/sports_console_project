package com.project.sports.user.community;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import com.project.sports.input.BannedWord;
import com.project.sports.input.BlackList;
import com.project.sports.input.Post;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;
import com.project.sports.user.community.search.CommunityDetail;
import com.project.sports.user.community.search.CommunitySearch;
import com.project.sports.user.community.write.CommunityWrite;
/**
 * 
 * @author 김영석
 *
 */
public class Community {

	public static ArrayList<String> blist = new ArrayList<String>(); //금지어리스트를 담을 위치
	

	/**
	 * 커뮤니티 게시글을 출력합니다.
	 * 메뉴 번호를 입력 받아 번호에 맞는 클래스의 메소드로 이동합니다.
	 * 블랙리스트에 있을 경우 접근이 제한됩니다.
	 */
	public static void communityMenu() { //커뮤니티 화면
		
		try {
			
			for (BlackList b : Data.blackListList) {
                if (b.getId().equals(UserLogin.userData.getId())) {
                   System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                   System.out.println("\t\t\t\t\t\t 접근이 제한된 사용자입니다.");
                   Output.pause();
                   System.out.println("---------------------------------------------------------------------------------------------------------------------------");
                   return;
                }
             }
			
			
			
			Scanner sc = new Scanner(System.in);
			
			boolean flag = true;
			 
			while (flag) {
				
				int seq = 1;
				for (BannedWord bw : Data.bannedWordList) {
					blist.add(bw.getBannedWord()); //금지어리스트
				}
				
				// postList 정렬
				Data.postList.sort(new Comparator<Post>() { // 최신순으로 정렬
					
					@Override
					public int compare(Post o1, Post o2) {
						return o2.getDate().compareTo(o1.getDate());
					}				
				});
				
				Data.postList.sort((Post p1,Post p2) -> { // "공지"가 가장 위에 오도록 정렬
					
					if (p1.getSubject().equals("공지") && p2.getSubject().equals("잡담")) {
						return -1;
					} else if (p1.getSubject().equals("공지") && p2.getSubject().equals("이벤트")) {
						return -1;
					} else if (p1.getSubject().equals("공지") && p2.getSubject().equals("직관")) {
						return -1;
					} else if (p1.getSubject().equals("공지") && p2.getSubject().equals("질문")) {
						return -1;
					} else {
						return 0;
					}
					
				});
				
				String title = "";
				ArrayList<String> scList = new ArrayList<String>(); // 넘기기 부분: 한줄씩 리스트에 저장
				
				//커뮤니티 글 출력
				//int seq = 1;
				
				
				
				if (seq == 1) {
					
					for (Post p : Data.postList) {
						//욕설 **표시
		                  title = p.getTitle();
		                                                   
		                  for (int i=0; i<Community.blist.size(); i++) {
		                     
		                     title = title.replaceAll(Community.blist.get(i), "**");
		                     
		                     
		                  }
							
						if (p.getTitle().length() > 20) {
							title = title.substring(0,19) + "..";
						} else {
							
							
							if (title.length() <= 20) {
								for (int i=title.length(); i<24; i++) {
									title += " "; 
								}
							}
							
						}
						
						String subjectOut = p.getSubject();
						String idOut = p.getId();
						//출력 글자 길이 통일				
						if (p.getSubject().length() < 3) {
							for (int i=p.getSubject().length(); i<3; i++) {
								subjectOut += " "; 
							}
						}
						
						if (p.getId().length() < 16) {
							for (int i=p.getId().length(); i<16; i++) {
								idOut += " "; 
							}
						}
						
						// 출력할 리스트에 한줄씩 담음
						scList.add(String.format("\t\t%3s\t%s\t%s\t%-20s\t%tF\t%4s" 
								, seq
								, subjectOut
								, title
								, idOut
								, p.getDate()
								, p.getView()));
						
						seq++;
						
					}
					
					for (int i=0; i<(scList.size()/10) + 1;) {
						System.out.println("\t       ================================================================================================");
						System.out.println("\t\t[글번호] [말머리]\t\t[제목]\t\t\t[작성자]\t\t\t  [작성일]       \t[조회수]");
						System.out.println("\t       ================================================================================================");
						
						for (int j = 0 + i * 10; j < 10 + i*10; j ++) {
							if (j>=scList.size()) {
								break;
							}
							System.out.println(scList.get(j)); // 글 리스트 출력
						}						
						System.out.println("\t       ------------------------------------------------------------------------------------------------");
						
						OutCommunityMenu.communityMenu(); // 커뮤니티 메뉴 출력 > 1.글쓰기, 2.검색하기, 3.글상세보기...
						System.out.print("\t\t\t\t\t     기호 또는 글 번호 입력(0.뒤로가기): ");
						
						String input = sc.nextLine();
						
						if (input.equals(">")) {
							if (i == scList.size()/10) {
								System.out.println("\t       ------------------------------------------------------------------------------------------------");
								System.out.println("\t\t\t\t\t\t   마지막 페이지 입니다.");
								System.out.print("\t\t\t\t\t    다시 입력하시려면 엔터(Enter)를 누르세요.");								
								input = sc.nextLine();
								System.out.println("\t       ------------------------------------------------------------------------------------------------");
								System.out.println();
							} else {
								i++;
							}
						} else if(input.equals("<")) {
							if (i == 0) {
								System.out.println("\t       ------------------------------------------------------------------------------------------------");
								System.out.println("\t\t\t\t\t\t   이전 페이지가 없습니다.");
								System.out.print("\t\t\t\t\t    다시 입력하시려면 엔터(Enter)를 누르세요.");
								input = sc.nextLine();
								System.out.println("\t       ------------------------------------------------------------------------------------------------");
								System.out.println();
							} else {
								i--;
							}
						} else if (input.equals("1")) { // 글쓰기
							CommunityWrite.writeMenu();
							break; // break 걸어줘야 커뮤니티 글 리스트에 작성 내용이 반영됨
						} else if (input.equals("2")) { //검색하기
							CommunitySearch.searchMenu();
							break;
						} else if (input.equals("3")) { //글 상세보기
							CommunityDetail.communityDetail();
							break;
						} else if (input.equals("4")) { //나의 활동
							MyActivities.Myactivities();
							
						} else if (input.equals("0")) { //뒤로 가기
							Output.backMsg();
							return;
						} else { //유효성 검사
							System.out.println("\t\t\t\t\t올바르지 않은 메뉴 번호입니다.");
							Output.pause();
						}
						
					}
					
				}
			}
			

			
			
			
		} catch (Exception e) {
			
			System.out.println("Community.communityMenu");
			e.printStackTrace();
		}

		
	}
	
	
	
	
	
			
}
