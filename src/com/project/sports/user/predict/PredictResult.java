package com.project.sports.user.predict;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Point;
import com.project.sports.input.Predict;
import com.project.sports.input.Schedule;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 승부예측결과를 확인하는 클래스
 * @author 서주예
 */
public class PredictResult {

	
	/**
	 * 사용자의 승부예측 결과를 출력하는 클래스
	 */
	public static void predictResult() {
		
		Calendar c = Calendar.getInstance();
		Calendar monday = Calendar.getInstance();
		Calendar first = Calendar.getInstance();
		first.set(Calendar.DATE, 1);
		monday.add(Calendar.DATE, -c.get(Calendar.DAY_OF_WEEK) + 2);
		
		c.add(Calendar.DATE, -1);
		String yesterday = String.format("%tF", c); //2022-04-14
		
		
		//유저아이디와 일치하는 predict 부분을 찾아온다.
		
		Scanner sc = new Scanner(System.in);
		int seq = 1;
		int point = 0;
		int pointSum = 0; //누적 변수
		int weekPoint = 0;
		int monthPoint = 0;
		String predictTeam = "";
		String predictResult = "";
		String teamName1 = "";
		String teamName2 = "";
		String date = "";
		boolean predictResultFlag = true;
		
		System.out.println();
		Output.oneLine();
		System.out.println();
		System.out.printf("\t\t\t\t\t\t<%tF의 경기 예측 결과>\n", c);
		System.out.println("\t\t\t\t=============================================================");
		System.out.printf("\t\t\t\t번호\t\t경기\t\t  승리 예측 팀\t예측결과\t포인트\n");
		System.out.println("\t\t\t\t=============================================================");
		
		while(predictResultFlag) {
		//predict에서 예측한 팀이름과 예측 결과를 가져온다.
		for(Predict p : Data.predictList) {
			
			//아이디 dlhl9ry
			if(UserLogin.userData.getId().equals(p.getId())) { //로그인한 아이디 = 승부예측에 참여한 아이디
				predictTeam = p.getTeamName(); //승리예측한 팀
				predictResult = p.getResult(); //예측 결과(1/2/3)
				int gameSeq = p.getScheduleSeq(); //승부예측데이터에서 찾아온 승부예측에 참여한 경기고유번호
						
				//아이디가 일치한 상태 + schedule에서 일치한 경기 가져오기
				for(Schedule s : Data.scheduleList) {
					
					if(s.getSeq() == gameSeq) { //경기일정의 경기 고유 번호 == 승부예측에 참여한 경기 고유 번호
						teamName1 = s.getTeam1(); //경기일정에서 팀1 이름 받아오기
						teamName2 = s.getTeam2(); //경기일정에서 팀2 이름 받아오기
						date = String.format("%tF",s.getDate()); //경기 날짜 받아오기
						
						if(monday.compareTo(s.getDate())<0 && c.compareTo(s.getDate())>0) { //이번주 포인트 합산
							
							if(p.getResult().equals("1")) {
								weekPoint += 10;
							}
							
						}
						
						if(first.compareTo(s.getDate())<0 && monday.compareTo(s.getDate())>0) {
							
							if(p.getResult().equals("1")) {
								monthPoint += 10;
								
							}
						}
					}
				}//for-schedule
				
				if(date.equals(yesterday)) {
					
					String result = predictResult.equals("1")?"성공" : "실패";
					point = predictResult.equals("1")? 10 : 0; //성공 10p, 실패 0p
					pointSum += point;
					
					String line = String.format("\t\t\t\t%d\t%svs%s\t  %s\t %s\t%dp"
							, seq
							, teamName1
							, teamName2
							, predictTeam
							, result //1 = 성공, 2 = 실패
							, point);
					System.out.println(line);
					System.out.println("\t\t\t\t-------------------------------------------------------------");
					inputPointList(point, c); //리스트에 포인트 추가하기(하나씩 해줘야함 - 위치가여기가 맞음?)
					seq++;
					
				}
				

				
				
			}
				
			
		}//for-predict
		
		if(teamName1.equals("")) {
			System.out.println("승부예측 데이터가 없습니다.");
		}
		
		printPoint(pointSum, weekPoint, monthPoint); //총 획득 포인트를 출력하는 메소드
		String answer = sc.nextLine();
		
		if(answer.equals("")) {
			predictResultFlag = false;
		}
		}//while
		
	}//predictResult
	
	/**
	 * 사용자가 승부예측으로 획득한 포인트를 출력하는 메소드
	 * @param pointSum 일일 포인트를 합산한 매개변수
	 * @param weekPoint 일주일 포인트를 합산한 매개변수
	 * @param monthPoint 한달 포인트를 합산한 매개변수
	 */
	public static void printPoint(int pointSum, int weekPoint, int monthPoint) {
		
		//총 획득 포인트 출력하기
		System.out.println();
		System.out.printf("\t\t\t\t\t\t 총 획득 포인트 :  %d\n", pointSum);
		System.out.printf("\t\t\t\t\t\t 이번 주 획득 포인트 : %d\n", weekPoint);
		System.out.printf("\t\t\t\t\t\t 이번 달 획득 포인트 : %d\n", monthPoint + weekPoint);
		System.out.println();
		System.out.println("\t\t\t\t\t\t 계속하시려면 [엔터]를 입력하세요.");
		//seq●id●point●"경기 예측 보상" - 고정
		
	}
	
	/**
	 * 사용자의 포인트를 데이터파일에 저장하기 위해 List에 추가하는 메소드
	 * @param point 포인트
	 * @param c 포인트 획득 날짜
	 */
	public static void inputPointList(int point, Calendar c) {
		//얻은 포인트 -> 포인트 내역 리스트에 넣기
		
		int last = Data.pointList.get(Data.pointList.size()-1).getSeq();
		Point inputPoint = new Point(last+1, UserLogin.userData.getId(), "+"+point+"", "경기 예측 보상", c);
		Data.pointList.add(inputPoint);
	}
	
}//PredictResult
