package com.project.sports.main;

import java.util.Calendar;
import java.util.Random;
import com.project.sports.input.Predict;
import com.project.sports.input.Record;
import com.project.sports.input.RelativeRecord;
import com.project.sports.input.Schedule;
import com.project.sports.input.Team;
import com.project.sports.input.YearTeam;

/**
 * 날짜가 지난 데이터를 수정해주는 클래스 입니다.
 * @author 김찬진
 *
 */
public class DataAdd {
	
	/**
	 * 현재의 날짜를 기준으로 날짜가 지난 데이터를 수정하는 메소드 입니다.
	 */
	public static void dataAdd() {
		
		Calendar c = Calendar.getInstance(); //오늘 날짜
		c.add(Calendar.DATE, -1); 
		//c.set(2022, 3, 18); //테스트용 오늘의 날짜 바꾸기
		Random rnd = new Random();
		for (Schedule s : Data.scheduleList) {
			int t1 = 0;
			int t2 = 0;
			while (t1 == t2) {
				t1 = rnd.nextInt(10)+1;
				t2 = rnd.nextInt(10)+1;
			}
			
			int team1Seq = 0;
			int team2Seq = 0;
			if (s.getDate().compareTo(c) < 0 && s.getTeam1Score() == 0) { //지난 날짜 찾기
				s.setTeam1Score(t1); //지난 날짜의 팀1 점수 랜덤으로 받은거 대입
				s.setTeam2Score(t2); //지난 날짜의 팀2 점수 랜덤으로 받은거 대입
				for (YearTeam y : Data.yearTeamList) { //스케쥴의 팀 이름 고유번호 찾아서 저장
					if (s.getTeam1().equals(y.getTeamName())) {
						team1Seq = y.getSeq();
					} else if (s.getTeam2().equals(y.getTeamName())) {
						team2Seq = y.getSeq();
					}
				}
				for (Team t : Data.teamList) { 
					if (c.get(Calendar.YEAR) == t.getYear() && s.getTeam1().equals(t.getTeamName())) {
						//같은 년도에 팀1 고유 번호가 같은걸 팀 목록.txt에서 찾기
						if (t1 > t2) {
							t.setWin(t.getWin()+1); //팀1 이겼으면 승 추가
						} else {
							t.setLose(t.getLose()+1); //팀1 졌으면 패 추가							
						}
					}
					if (c.get(Calendar.YEAR) == t.getYear() && s.getTeam2().equals(t.getTeamName())) {
						//같은 년도에 팀2 고유 번호가 같은걸 팀 목록.txt에서 찾기
						if (t1 > t2) {
							t.setLose(t.getLose()+1); //팀2가 졌으면 패 추가
						} else {
							t.setWin(t.getWin()+1); //팀2가 이겼으면 승 추가
						}
					}
				}
				for (Predict p : Data.predictList) {
					if (s.getSeq() == p.getScheduleSeq()) { //승부예측
						//스케쥴 고유번호로 승부예측.txt에서 찾아서 결과에 따른 값(승1,패2) 저장
						if (t1 > t2) {
							if (s.getTeam1().equals(p.getTeamName())) {
								p.setResult("1"); 
							} else {
								p.setResult("2");
							}
						} else {
							if (s.getTeam1().equals(p.getTeamName())) {
								p.setResult("2");
							} else {
								p.setResult("1");
							}
						}
					}
				}
				//상대전적 추가
				for (RelativeRecord r : Data.relativeRecordList) {
					if (r.getSeq() == team1Seq) {
						for (Record re : r.getList()) {
							if (re.getTeamSeq() == team2Seq) {
								if (t1 > t2) {
									re.setWin(re.getWin()+1);
								} else {
									re.setLose(re.getLose()+1);
								}
							}
						}
					} else if (r.getSeq() == team2Seq) {
						for (Record re : r.getList()) {
							if (re.getTeamSeq() == team1Seq) {
								if (t2 > t1) {
									re.setWin(re.getWin()+1);
								} else {
									re.setLose(re.getLose()+1);
								}
							}
						}
					}
				}
				
			}
			
		}
		
		
		
	}

}
