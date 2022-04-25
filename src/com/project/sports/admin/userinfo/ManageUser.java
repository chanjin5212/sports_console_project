package com.project.sports.admin.userinfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.project.sports.admin.AdminOutput;
import com.project.sports.input.BlackList;
import com.project.sports.input.Schedule;
import com.project.sports.input.Ticketing;
import com.project.sports.input.User;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 관리자 회원 관리 카테고리
 * @author 안수아
 *
 */
public class ManageUser {
	
	public static List<User> userList = Data.userList;
	public static boolean mFlag = true;
	
	/**
	 * 회원 관리 메인
	 */
	public static void manageUserMain() { 
		
		Scanner sc = new Scanner(System.in);
		
		while (mFlag) {
			
			printUserList();
			
		}
	}

	/**
	 * 모든 회원 정보 출력
	 */
	public static void printUserList() { 
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> scList = new ArrayList<String>();//한줄씩 리스트에 저장
		String input = "";
		
		for (User u : userList) {
			scList.add(String.format("\t\t\t\t%s\t\t\t%s\t\t\t%s\n", u.getSeq(), u.getName(), u.getId()));
		}
		
		//10개씩 페이지를 해서 i<=리스트.size()/10 를 하거나 i<(리스트.size/10)+1 까지 i 범위를 정한다.
		for (int i=0; i<(scList.size()/10)+1;) { 
			System.out.println("\t\t\t\t============================================================");
			System.out.println("\t\t\t\t[회원번호]\t\t\t[이름]\t\t\t[아이디]");
			System.out.println("\t\t\t\t============================================================");
			
			//첫번째 페이지면 j가0~9 2번째 페이지면 j가 10~19 이런식으로 출력
			for (int j=0+i*10; j<10+i*10; j++) { 
				if (j>=scList.size()) { //j가 리스트보다 크면 에러나기 때문에 >=일때 종료
					break;
				}
				System.out.print(scList.get(j));
			}
			System.out.println("\t\t\t\t------------------------------------------------------------");
			System.out.printf("\t\t\t\t\t\t\t\t%d페이지\n", i+1);
			System.out.println();
			
			AdminOutput.AdminManageUserMenu();
			input = sc.nextLine();
			if (input.equals(">")) {
				if (i == scList.size()/10) { //마지막 페이지인지 확인하는 if문
					System.out.println("\t\t\t\t\t\t마지막 페이지 입니다.");
					System.out.println("\t\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
					input = sc.nextLine();
				} else { //마지막 페이지가 아니면 i++를 해줘서 다음 페이지
					i++;
				}
			} else if (input.equals("<")) { 
				if (i == 0) { //첫페이지인지 확인하는 if문
					System.out.println("\t\t\t\t\t\t이전 페이지가 없습니다.");
					System.out.println("\t\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
					input = sc.nextLine();
				} else { //첫페이지가 아니면 i-- 해줘서 이전 페이지
					i--;
				}
			} else if (input.equals("1")) { // 회원 상세 정보 보기
				userDetail();
			} else if (input.equals("2")) { // 블랙리스트 관리
				ManageBlackList.manageBlackList();
			} else if (input.equals("3")) { // 블랙리스트 추가
				addBlackList();
			} else if (input.equals("0")) {
				Output.backMsg();
				mFlag = false;
				break;
			} else {
				System.out.println("\t\t\t\t\t\t올바르지 않은 메뉴 번호입니다.");
			}
			
		}
	}

	/**
	 * 입력받은 회원의 상세 정보 보기
	 */
	public static void userDetail() { 
		
		Scanner sc = new Scanner(System.in);
		boolean dFlag = true;
		
		while(dFlag) {
			
			System.out.print("\t\t\t\t\t\t회원 번호를 입력하세요. (0. 뒤로 가기): ");
			int input = sc.nextInt();
			
			if (input == 0) {
				Output.backMsg();
				dFlag = false;
			}
			
			User result = null;
			
			for (User u : userList) {
				if (input == u.getSeq()) {
					result = u;
				}
			}
			
			if (result != null) {
				printUserDetail(result); // 회원의 정보와 예매 내역 출력
				Output.pause();
			} else {
				System.out.println("\t\t\t\t\t\t올바르지 않은 회원 번호입니다.");
			}
			
		}
	}
	
	/**
	 * 회원 개인 정보, 회원의 예매 내역 출력
	 * @param user
	 */
	private static void printUserDetail(User user) { 
		
		List<Ticketing> tempList = new ArrayList<>();
		
		// 회원의 개인 정보 출력
		System.out.println("\t\t===================================================================================================");
		System.out.println("\t\t[회원번호]\t\t[이름]\t[아이디]\t\t\t[주민등록번호]\t[전화번호]\t\t[포인트]\t[비밀번호]");
		System.out.println("\t\t===================================================================================================");
		System.out.printf("\t\t%d\t\t%s\t%-20s%s*****\t%s\t%d\t%s\n", user.getSeq()
													, user.getName()
													, user.getId()
													, user.getJumin()
													, user.getNumber()
													, user.getPoint()
													, user.getPassword());
		System.out.println("\t\t---------------------------------------------------------------------------------------------------"); 
		
		System.out.println();
		
		// 회원의 예매 내역 출력
		StringBuilder sb = new StringBuilder(String.format("\t\t\t\t\t\t\t'%s'님의 예매내역\n", user.getName()));
		sb.append("\t\t\t\t===============================================================\n");
		sb.append("\t\t\t\t[번호]\t\t[경기명]\t\t[날짜]\t\t[시간]\t[경기장]\n");
		sb.append("\t\t\t\t===============================================================\n");
		
		boolean hasTicket = false;
		for (Ticketing t : Data.ticketingList) {
			if (t.getId().equals(user.getId())) {
				tempList.add(t);
				hasTicket = true;
			}
		}
		
		if (!hasTicket) {
			System.out.printf("\t\t\t\t\t\t'%s'님의 예매내역이 존재하지 않습니다.\n", user.getName());
			return;
		}
		
		for (int i = 0 ; i < tempList.size() ; i ++) {
			
			Ticketing t = tempList.get(i);
			
			for (Schedule s : Data.scheduleList) {
				if (t.getScheduleSeq() == s.getSeq()) {
					sb.append(String.format("\t\t\t\t%d\t%s vs %s\t%tF\t%s\t%s\n", i+1 
																		, s.getTeam1()
																		, s.getTeam2()
																		, s.getDate()
																		, s.getTime()
																		, s.getPlace()));
				}
				 
			}
			
		}
		sb.append("\t\t\t\t---------------------------------------------------------------\n");
		System.out.println(sb);
		
	}
	
	/**
	 * 블랙리스트 추가
	 */
	private static void addBlackList() {
		
		Scanner sc = new Scanner(System.in);
		boolean mFlag = true;
		
		while (mFlag) { // 아이디 입력받기
			
			System.out.print("\t\t\t\t\t\t블랙리스트에 등록할 아이디: ");
			String id = sc.nextLine();
			
			if (id.equals("0")) { // 0 들어오면 뒤로가기
				Output.backMsg();
				break;
			}
			
			User result = null;
			
			for (User u : Data.userList) { // 입력으로 들어온 회원의 아이디가 회원 리스트에 존재하는지 확인
				if (id.equals(u.getId())) {
					result = u;
				}
			}
			
			boolean existBlack = false;
			boolean rFlag = false;
			
			if (result != null) { // 회원이 존재할 때
				
				for (BlackList b : Data.blackListList) { // 블래리스트 중복 체크
					
					if (result.getId().equals(b.getId())) {
						existBlack = true;
					}
					if (!existBlack) { // 블랙 리스트에 중복 회원이 존재하지 않을 때 추가 단계로 넘어감
						rFlag = true;
					} else { // 중복회원이 존재할 때
						System.out.println("\t\t\t\t\t\t해당 회원이 이미 블랙리스트에 존재합니다.");
						Output.pause();
					}
				}
			} else {
				System.out.println("\t\t\t\t\t\t해당 회원이 존재하지 않습니다.");
			}
				
			while (rFlag) {
				
				if (result != null) { // 입력으로 들어온 아이디를 가진 회원이 존재하면
					
					System.out.println("\t\t\t\t===========================================================");
					System.out.println("\t\t\t\t[회원번호]\t\t\t[이름]\t\t\t[아이디]");
					System.out.println("\t\t\t\t===========================================================");
					System.out.printf("\t\t\t\t%d\t\t\t%s\t\t\t%s\n", result.getSeq()
							, result.getName()
							, result.getId());
					System.out.println("\t\t\t\t-----------------------------------------------------------");
				
				System.out.print("\t\t\t\t\t\t해당 회원이 맞습니까? (Y/N): ");
				String answer = sc.nextLine();
				
				if (answer.toUpperCase().equals("Y")) { // 아이디 확인
					
					boolean dFlag = true;
					
					while (dFlag) { // 블랙리스트 추가 사유 입력받음
						System.out.print("\t\t\t\t\t\t블랙리스트 추가 사유 : ");
						String detail = sc.nextLine();
						
						if (detail.equals("0")) { // 0이면 뒤로가기
							dFlag = false;
						}
						
						System.out.println("\t\t\t\t===========================================================");
						System.out.println("\t\t\t\t[회원번호]\t\t[이름]\t\t[아이디]\t\t[사유]"); 
						System.out.println("\t\t\t\t===========================================================");
						System.out.printf("\t\t\t\t%d\t\t%s\t\t%s\t\t%s\n", result.getSeq()
								, result.getName()
								, result.getId()
								, detail);
						System.out.println("\t\t\t\t-----------------------------------------------------------");
						
						boolean checkFlag = true;
						while (checkFlag) { // 회원 + 사유까지 확인
							
							System.out.print("\t\t\t\t\t\t해당 회원을 블랙리스트에 추가하시겠습니까? (Y/N) : ");
							String answer2 = sc.nextLine();
							
							if (answer2.toUpperCase().equals("Y")) { // 회원 + 사유 확인
								
								int max = 0;
								
								for (BlackList b : Data.blackListList) { 
									
									if (max < b.getSeq()) { // 블랙 리스트 seq 번호 
										max = b.getSeq();
									}
									
								}
								
								// 블랙 리스트에 추가
								BlackList black = new BlackList(max, result.getName(), result.getId(), 0, detail);
								Data.blackListList.add(black);
								
								System.out.println("\t\t\t\t\t\t추가되었습니다.");
								
								Output.pause();
								checkFlag = false;
								dFlag = false;
								rFlag = false;
								mFlag = false;
									
								
							} else if (answer2.toUpperCase().equals("N")) { // 회원 + 사유 확인 실패
								System.out.println("\t\t\t\t\t\t취소되었습니다.");
								checkFlag = false;
								dFlag = false;
								rFlag = false;
								mFlag = false;
							} else {
								System.out.println("\t\t\t\t\t\tY 또는 N을 입력해주세요.");
							}
							
						}
						
					}
					
					
				} else if (answer.toUpperCase().equals("N")) { // 아이디 확인 실패
					rFlag = false;
				} else {
					System.out.println("\t\t\t\t\t\tY 또는 N을 입력해주세요.");
				}
				
			} else {
				System.out.println("\t\t\t\t\t\t올바르지 않은 아이디입니다.");
			}
			
		}
			
		}
	}


}
