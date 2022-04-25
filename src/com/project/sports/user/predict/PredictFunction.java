package com.project.sports.user.predict;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Predict;
import com.project.sports.input.Schedule;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 승부예측하기 기능이 구현된 클래스
 * @author 서주예
 */
public class PredictFunction {
	
	
//	public static Schedule predictTeamInfo;
	public static List<Integer> predictTeam;
	public static boolean selectWinTeamFlag = true;
	public static boolean predictFunctionFlag = true;
	public static boolean selectPredictGame = true;

	/**
	 * 승부예측이 가능한 경기 출력과 승부예측 진행할 경기 번호를 입력받는 메소드
	 */
	public static void predictFunction() {
		
		//1. 승부예측하기
		Scanner sc = new Scanner(System.in);
		Calendar c = Calendar.getInstance(); //접속한 날(오늘) 날짜 받아오기
		int listSeq = 1;
		
		//데이터파일에서 읽어오기
		String date = String.format("%tF", c); //오늘날짜 string으로 만들기 2022-04-14
		
		//화면에 출력				
		while(predictFunctionFlag) { //해당 경기 리스트가 나오는 부분
			System.out.println();
			Output.oneLine();
			System.out.printf("\t\t\t\t\t    <%s의 승부예측 가능한 경기>\n", date);
			System.out.println();
			System.out.println("\t\t\t   =======================================================================");
			System.out.println("\t\t\t    번호\t\t\t\t팀\t\t\t\t선발");
			System.out.println("\t\t\t   =======================================================================");
			
			//해당 날짜의 경기의 고유 seq 번호를 저장하는 배열 
			predictTeam = new ArrayList<Integer>();
			
			for(Schedule s : Data.scheduleList) {
				
				String date2 = String.format("%tF", s.getDate());
				
				//오늘날짜 == txt파일에서의 날짜
				if(date.equals(date2)) {
					
					//조건에 맞는 경기의 seq를 배열에 넣기
					predictTeam.add(s.getSeq());
					
					//리스트 출력
					String line = String.format("\t\t\t     %d\t\t\t%svs%7s\t\t    %svs%s"
							, listSeq
							, s.getTeam1()
							, s.getTeam2()
							, s.getStarting1()
							, s.getStarting2());
					System.out.println(line);
					listSeq++;
				}//if			
			}//for
			
			System.out.print("\t\t\t   ------------------------------------------------------------------------\n");
			Output.menuBack();
			System.out.println("\t\t\t\t\t\t승부 예측할 경기를 선택해주세요.");
			Output.input();
			String input = sc.nextLine();
	
			if(input.equals("0")) {
				predictFunctionFlag = false; //여기까진 작동
				Output.backMsg();
			} else {
				if(input.equals("1")) {
					selectWinTeam(predictTeam, predictTeam.get(0));
				} else if(input.equals("2")) {
					selectWinTeam(predictTeam, predictTeam.get(1));
				} else if(input.equals("3")) {
					selectWinTeam(predictTeam, predictTeam.get(2));
				} else if(input.equals("4")) {
					selectWinTeam(predictTeam, predictTeam.get(3));
				} else if(input.equals("5")) {
					selectWinTeam(predictTeam, predictTeam.get(4));
				}  else {
					//유효성 검사
				}	
				Output.backMsg();
			}
		
		}//while
		
	}//predictFunction
	

	/**
	 * 선택한 경기의 팀 목록을 출력하는 메소드
	 * @param predictTeam 예측할 팀을 입력받는 매개변수
	 * @param input 사용자가 선택한 경기번호를 입력받는 매개변수
	 */
	public static void selectWinTeam(List<Integer> predictTeam, Integer input) {
		
		Scanner sc = new Scanner(System.in);
		
		//승리할 팀 고르기
		
		//데이터 파일과 비교하기
		
		while(selectWinTeamFlag) {
			
			for(Schedule s : Data.scheduleList) {
				
				if(s.getSeq() == input) {
					
					System.out.println();
					System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
					System.out.println(String.format("\t\t\t\t\t │             1. %s\t    │", s.getTeam1()));
					System.out.println(String.format("\t\t\t\t\t │             2. %s\t    │", s.getTeam2()));
					System.out.print("\t\t\t\t\t │\t       ");
					Output.back();
					System.out.print("\t\t    │\n");
					System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
					
					Output.menuBack();
					System.out.println();
				
					
					System.out.print("\t\t\t\t\t    승리할 것으로 예상되는 팀을 선택해주세요 : ");
					String select = sc.nextLine();
					if(select.equals("0")) {
						selectWinTeamFlag = false;
					}
					
					if(select.equals("1")) { //1번팀을 선택하는 경우
						
						selectWinTeam(s.getTeam1(), s.getSeq());
						
						
						
					} else if(select.equals("2")) { //2번팀을 선택하는 경우
						
						selectWinTeam(s.getTeam2(), s.getSeq());
						
					} else if(select.equals("0")) {
						selectWinTeamFlag = false;
						
					} else {
						//유효성 검사
					}
				}
				
			}
		}
		
		
		
	}
	
	/**
	 * 승부예측한 팀을 확인받는 메소드
	 * @param teamName 승리할 것으로 선택한 팀의 이름을 받는 매개변수
	 * @param seq 승리할 것으로 선택한 팀의 고유번호를 받는 매개변수
	 */
	public static void selectWinTeam(String teamName, int seq) {
		//확인받기
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.println(String.format("\t\t\t\t\t\t       <%s>", teamName));
		System.out.print("\t\t\t\t\t    승리할 것으로 예측한 팀이 맞습니까?(y/n) : ");
		String answer = sc.nextLine(); //y/n받기
		if(answer.equals("y")) {
			
			//승부예측 결과 저장하기
			int last = Data.predictList.get(Data.predictList.size()-1).getSeq();
			Predict predict = new Predict(last + 1, UserLogin.userData.getId(), seq, teamName, "3");
			Data.predictList.add(predict);
			
			System.out.println();
			System.out.println("\t\t\t\t\t\t    승부예측이 완료되었습니다.");
			Output.pause();
			selectWinTeamFlag = false;
			predictFunctionFlag = false;
			
			
			
			
		} else if(answer.equals("n")) {
			System.out.println();
			System.out.println("\t\t\t\t\t\t    승부예측이 취소되었습니다.");
			Output.pause();
			Output.backMsg();
			selectWinTeamFlag = false;

		} else {
			//유효성검사
		}
	}
	
}//PredictFunction
