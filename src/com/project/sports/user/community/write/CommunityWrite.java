package com.project.sports.user.community.write;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.BannedWord;
import com.project.sports.input.BlackList;
import com.project.sports.input.Post;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;
import com.project.sports.user.community.OutCommunityMenu;

/**
 * 커뮤니티에 글 쓰기 클래스입니다.
 * @author 김영석
 *
 */
public class CommunityWrite {
	
	/**
	 * 커뮤니티에서 글 쓰기 메소드입니다.
	 * 글 말머리와 제목 내용을 입력 받고 글 목록 ArrayList에 저장하는 메소드입니다.
	 */
	public static void writeMenu() {
		
		Scanner sc = new Scanner(System.in);
		String newsubject = "";
		
		boolean subjectFlag = true;
		
		while(subjectFlag) { //말머리 입력 반복
			
			if (!UserLogin.userData.getId().equals("관리자")) {
				OutCommunityMenu.outWriteSubject(); //말머리 입력 받기
				String insubject = sc.nextLine();
				
				if (insubject.equals("1")) {
					newsubject = "잡담";
				} else if(insubject.equals("2")) {
					newsubject = "이벤트";
				} else if(insubject.equals("3")) {
					newsubject = "직관";
				} else if(insubject.equals("4")) {
					newsubject = "질문";
				} else if(insubject.equals("0")) {
					break;
				} else {
					OutCommunityMenu.outMenuError();
					subjectFlag = false;
					//writeMenu();
				}
				
			} else {
				newsubject = "공지";
			}
			
			boolean titleFlag = true;
			while (titleFlag) { //제목 입력 반복
				
				OutCommunityMenu.outWriteTitle();
				String newtitle = sc.nextLine();
				
				if (newtitle.equals("")) { // 제목에 아무 글자도 입력되지 않았을 때
					OutCommunityMenu.outNewTitleError();
				} else if (newtitle.equals("0")){
					titleFlag = false;
				}
				
				boolean contentFlag = false;
				
				if (titleFlag) {
					contentFlag = true;
				} else {
					contentFlag = false;
				}
				
				while (contentFlag) { //내용 입력 반복
				
					OutCommunityMenu.outWriteContent();
					String newcontent = sc.nextLine();
					
					if (newcontent.equals("")) { // 내용에 아무 글자도 입력되지 않았을 때
						OutCommunityMenu.outNewContentError();
						
					} else if (newcontent.equals("0")) {
						contentFlag = false;
						
					} else {
						
						//최대값 계산
						int max = getSeq();
						int maxbk = getSeqBk();
						
						//System.out.println(Data.postList.get(Data.postList.size()-1).getSeq());
						//System.out.println(max);
						//System.out.println(maxbk);
						
						Calendar today = Calendar.getInstance();
						//System.out.println(UserLogin.userData.getWarningCount()); //금지어 확인용
						
						//금지어를 찾고 금지어가 있으면 회원데이터에 금지어횟수 1번만 추가
						for (BannedWord bw : Data.bannedWordList) {
							if (newsubject.contains(bw.getBannedWord()) || newtitle.contains(bw.getBannedWord()) || newcontent.contains(bw.getBannedWord())) {
								UserLogin.userData.setWarningCount(UserLogin.userData.getWarningCount() + 1);
								
								if (UserLogin.userData.getWarningCount() >= 5) {
									int lastBlack = Data.blackListList.get(Data.blackListList.size()-1).getSeq();
									BlackList addBk = new BlackList(maxbk+1
											, UserLogin.userData.getName()
											, UserLogin.userData.getId()
											, UserLogin.userData.getWarningCount()
											, "금지어사용");
									//System.out.println(addBk); //4번에서 5번으로 올라가면서 블랙리스트가 됐는지 확인
									Data.blackListList.add(addBk);
								}
								
								break;
							}
						}
						int lastPost = Data.postList.get(Data.postList.size()-1).getSeq();
						
						
						Post newWrite = new Post(max+1, today, UserLogin.userData.getId(), newsubject, newtitle, newcontent, 0);
						int i = max;
						Data.postList.add(newWrite); //글 추가
						
						OutCommunityMenu.outWriteContentAfter(); //완료메시지
						return;
																
						
					}
				}//내용입력 while
			}//제목입력 while
		}//말머리입력 while
		
		
		
	}
	
	
	
	/**
	 * 새로 쓸 글의 글번호를 반환합니다. 
	 * @return 새로 쓸 글번호
	 */
	private static int getSeq() { 
		int max = 0;
		
		for(Post p : Data.postList) {
			int seq = p.getSeq();
			
			if(seq > max) {
				max = seq;
			}
		}
		return max;
	}
	
	//Black seq(번호)의 최대값을 알아내서 다음 글 번호를 찾는다.
	/**
	 * 블랙리스트로 새로 추가될 회원의 블랙리스트 고유번호를 반화합니다.
	 * @return 블랙리스트 번호
	 */
	private static int getSeqBk() { 
		int max = 0;
		
		for(BlackList bl : Data.blackListList) {
			int seq = bl.getSeq();
			
			if(seq > max) {
				max = seq;
			}
		}
		return max;
	}
	
}
