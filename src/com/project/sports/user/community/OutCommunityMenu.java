package com.project.sports.user.community;

import com.project.sports.output.Output;

public class OutCommunityMenu {

	public static void communityMenu() {
		
		System.out.println("                                               < 이전 페이지          다음 페이지 >");
		
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            페이지 변경 <,>	    │");
		System.out.println("\t\t\t\t\t │             1. 글쓰기		    │");
		System.out.println("\t\t\t\t\t │             2. 검색하기		    │");
		System.out.println("\t\t\t\t\t │             3. 글 상세보기	    │");
		System.out.println("\t\t\t\t\t │             4. 나의 활동	    │");
		System.out.print("\t\t\t\t\t │\t       "); Output.back(); System.out.print("\t    	    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		
	}
	
	public static void outWriteSubject() {
		//System.out.println("말머리를 입력해주세요. (1.잡답  2.이벤트  3.직관  4.질문  0.뒤로가기)");
		Output.line();
		System.out.println("\t\t\t  ┌───────────────────────────────────────────────────────────────┐");
		System.out.println("\t\t\t  │    말머리를 입력해주세요. (1.잡답  2.이벤트  3.직관  4.질문  0.뒤로가기)\t  │");
		System.out.println("\t\t\t  └───────────────────────────────────────────────────────────────┘");
		System.out.print("\t\t\t\t\t\t      말머리: ");
	}
	
	public static void outWriteTitle() {		
		System.out.println("  \t\t\t\t\t┌─────────────────────────────────┐");
		System.out.println("  \t\t\t\t\t│      제목을 입력해주세요.(0.뒤로가기)  │");
		System.out.println("  \t\t\t\t\t└─────────────────────────────────┘");
		System.out.print("\t\t\t\t\t\t      제목: ");
	}
	
	
	public static void outWriteContent() {		
		System.out.println("  \t\t\t\t\t┌─────────────────────────────────┐");
		System.out.println("  \t\t\t\t\t│      내용을 입력해주세요.(0.뒤로가기)  │");
		System.out.println("  \t\t\t\t\t└─────────────────────────────────┘");
		System.out.print("\t\t\t\t\t\t      내용: ");
	}
	
	public static void outWriteContentAfter() {
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t\t작성이 완료되었습니다.");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		Output.pause();
		System.out.println();
	}
	
	public static void outNewTitleError() {
		System.out.println("글자를 입력해주세요.");
		System.out.println();
	}
	
	public static void outMenuError() {
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t\t\t\t올바르지 않은 메뉴 번호 입니다.");
		Output.pause();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
	}
	
	public static void outNewContentError() {
		System.out.println("글자를 입력해주세요.");	
		System.out.println();
	}
	
	//글쓰기
	public static void outSearchMenu() {
		Output.line();
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            페이지 변경 <,>	    │");
		System.out.println("\t\t\t\t\t │             1.말머리		    │");
		System.out.println("\t\t\t\t\t │             2.제목		    │");
		System.out.println("\t\t\t\t\t │             3.작성자\t\t    │");
		System.out.println("\t\t\t\t\t │             4.본문 내용	            │");
		System.out.println("\t\t\t\t\t │             5.댓글 작성자	    │");
		System.out.println("\t\t\t\t\t │             6.댓글 내용	            │");
		System.out.print("\t\t\t\t\t │\t       "); Output.back(); System.out.print("\t    	    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
		
	}
		
	public static void outSearchSubject() {
		
		System.out.println("검색할 말머리를 입력해주세요.(1.공지,  2.잡담,  3.이벤트,  4.직관,  5.질문,  0.뒤로가기");
		System.out.print("메뉴번호: ");
	}
	
	
	public static void outSubjectMenu() {
		System.out.println("                                           < 이전 페이지          다음 페이지 >");
		System.out.println("페이지 변경 <,> 입력");
		System.out.println("기호 또는 글 번호 입력(0.뒤로가기)");
		System.out.print("입력: ");
	}
	
	public static void outContinuMsg() {
		System.out.print("계속하시려면 Enter를 입력해주세요..");
	}
	
	
}
