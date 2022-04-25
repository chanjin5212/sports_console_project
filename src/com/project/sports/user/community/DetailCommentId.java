package com.project.sports.user.community;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Comment;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 댓글 작성자의 아이디 또는 댓글 내용을 기준으로 검색하는 클래스
 * @author user
 *
 */
public class DetailCommentId {
	
	/**
	 * 입력한 아이디 또는 댓글 내용으로 작성된 댓글을 보여주고
	 * 해당 조건의 댓글을 선택하면 
	 * 댓글 쓰기, 수정, 삭제가 가능합니다.
	 * @param input
	 */
	public static void detail(String input) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			List<Comment> commList = new ArrayList<Comment>();
			
			int num = 1;
			System.out.println();
			System.out.println();
			System.out.println("\t       ================================================================================================");
			System.out.println("\t\t       [댓글번호]\t\t[내용]\t\t\t[작성자]\t\t\t  [작성일]  ");
			System.out.println("\t       ================================================================================================");
			for (Comment p : Data.commentList) {
				
				if (p.getId().equals(input)) {
					commList.add(p);
					
					String content = p.getContent();
					
					for (int i=0; i<Community.blist.size(); i++) {
						content = content.replaceAll(Community.blist.get(i), "**");
					}
					
					if (content.length() <= 20) {
						for (int i=content.length(); i<24; i++) {
							content += " "; 
						}
					}					
					
					
					System.out.printf("\t\t\t%3s\t%s\t%-20s\t%tF\n"
							, num
							, content
							, p.getId()
							, p.getDate());
					num++;
				}
			}
			System.out.println("\t       ------------------------------------------------------------------------------------------------");
			
			if (commList.size() == 0) {
				System.out.println("\t\t\t\t\t\t 댓글이 없습니다.");
				break;
			}
			
			System.out.print("\t\t\t\t\t\t 댓글 번호 입력:(0.뒤로가기)");			
			String number = sc.nextLine();
			System.out.println("\t       ------------------------------------------------------------------------------------------------");
			if (number.equals("0")) {
				break;
			} else {
				while (true) {
					//System.out.println("      \t[내용]        [작성자]                [작성일]  ");
					System.out.println("\t       ================================================================================================");
					System.out.println("\t\t\t       [내용]\t\t\t[작성자]\t\t\t  [작성일]  ");
					System.out.println("\t       ================================================================================================");
					System.out.printf("\t\t\t%s\t\t%-20s\t%tF\n"
							, commList.get(Integer.parseInt(number)-1).getContent()
							, commList.get(Integer.parseInt(number)-1).getId()
							, commList.get(Integer.parseInt(number)-1).getDate());
					
					System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
					if (commList.get(Integer.parseInt(number)-1).getId().equals(UserLogin.userData.getId())) {
						
						System.out.println("\t\t\t\t\t │             1.수정 하기	            │");
						System.out.println("\t\t\t\t\t │             2.삭제 하기	            │");
					}
					System.out.print("\t\t\t\t\t │\t       "); Output.back(); System.out.print("\t    	    │\n");
					System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
					Output.input();
					String con = sc.nextLine();
					if (con.equals("0")) {
						break;
					} else if (con.equals("1")) {
						
						if (commList.get(Integer.parseInt(number)-1).getId().equals(UserLogin.userData.getId())) {
							System.out.print("\t\t\t\t\t\t 수정할 내용을 입력하세요.:");
							String comme = sc.nextLine();
							System.out.println("\t       ------------------------------------------------------------------------------------------------");
							for (Comment c : Data.commentList) {
								if (commList.get(Integer.parseInt(number)-1).getSeq() == c.getSeq()) {
									c.setContent(comme);
								}
							}
							System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
							System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							Output.pause();
							System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							break;
							
						} else {
							System.out.println("\t\t\t\t\t\t 수정 할 수 없습니다.");
							System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							break;
						}
						
					} else if (con.equals("2")) {
						if (commList.get(Integer.parseInt(number)-1).getId().equals(UserLogin.userData.getId())) {
							
							Comment result = null;
							for (Comment c : Data.commentList) {
								if (commList.get(Integer.parseInt(number)-1).getSeq() == c.getSeq()) {
									result = c;
								}
							}
							Data.commentList.remove(result);
							System.out.println("\t\t\t\t\t\t 삭제가 완료되었습니다.");
							System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							Output.pause();
							System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							break;
						} else {
							System.out.println("\t\t\t\t\t\t 삭제 할 수 없습니다.");
							System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							break;
						}
						
					} else {
						System.out.println("\t\t\t\t\t\t 잘못 입력하셨습니다.");
						System.out.println("---------------------------------------------------------------------------------------------------------------------------");
					}
					
				}
				
				
				
			}
			
		}
	}

}
