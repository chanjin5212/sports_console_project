package com.project.sports.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
import com.project.sports.input.Schedule;
import com.project.sports.input.YearTeam;
import com.project.sports.main.Data;

/**
 * 관리자가 경기를 관리하는 클래스 입니다.
 * @author 김찬진
 *
 */
public class AdminSchedule {
	
	/**
	 * 관리자가 경기를 관리하는 메뉴를 선택하는 메소드 입니다.
	 */
	public static void adminSchedule() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			AdminOutput.scheduleMenu();
			String input = sc.nextLine();
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				scheduleAdd();
			} else if (input.equals("2")) {
				scheduleEdit();
			} else if (input.equals("3")) {  
				scheduleDelete();
			} else {
				System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
			}
		}

	}
	
	/**
	 * 관리자가 경기를 삭제하는 메소드 입니다.
	 */
	public static void scheduleDelete() {
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			ArrayList<Schedule> schList = new ArrayList<Schedule>();
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -1);
			for (Schedule s : Data.scheduleList) {
				if (s.getDate().compareTo(c) > 0) {
					schList.add(s);
				}
			}
			
			int seq = 1;
			for (int i = 0; i < schList.size() / 10 + 1;) {
				System.out.println("\t\t\t===============================================================================");
				System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
				System.out.println("\t\t\t===============================================================================");
				for (int j = 0 + i * 10; j < 10 + i * 10; j++) {
					if (j >= schList.size()) {
						break;
					}
					System.out.printf("\t\t\t%d	%s	%s vs %s	 %s	    %s\n", seq,
							String.format("%tF", schList.get(j).getDate()),
							schList.get(j).getTeam1(), schList.get(j).getTeam2(),
							schList.get(j).getPlace(), schList.get(j).getTime());
					seq++;

				}
				System.out.printf("\t\t\t[%d페이지]\n", i + 1);
				System.out.println("\t\t\t-------------------------------------------------------------------------------");
				AdminOutput.scheduleEditMenu();
				String input = sc.nextLine();
				if (input.equals(">")) {
					if (i == schList.size() / 10) {
						seq = schList.size() - (schList.size() % 10) + 1;
						System.out.println("\t\t\t\t\t마지막 페이지 입니다.");
						System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
						input = sc.nextLine();
					} else {
						i++;

					}
				} else if (input.equals("<")) {
					if (i == 0) { // 첫페이지인지 확인하는 if문
						seq = 1;
						System.out.println("\t\t\t\t\t이전 페이지가 없습니다.");
						System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
						input = sc.nextLine();
					} else { // 첫페이지가 아니면 i-- 해줘서 이전 페이지
						i--;
						if (seq == schList.size() + 1 || seq == schList.size()) {
							seq -= 10 + (schList.size() % 10);
						} else {
							seq -= 20;
						}
					}
				} else if (input.equals("1")) {
					if (seq == schList.size() + 1 || seq == schList.size()) {
						seq -= schList.size() % 10;
					} else {
						seq -= 10;
					}
					boolean dateFlag = true;
					while (dateFlag) {
						System.out.println("\t\t\t\t\t경기 날짜는 \"-\"으로 구분하여 입력하세요. (예시:2022-04-07)");
						System.out.print("\t\t\t\t\t경기 날짜 입력(0.뒤로가기):");
						String date = sc.nextLine();
						if (date.equals("0")) {
							break;
						}
						boolean flag = true;
						while (flag) {
							if (formatCheck(date)) {
								
								ArrayList<Schedule> scheList = new ArrayList<Schedule>();
								ArrayList<String> inputList = new ArrayList<String>();
								int seq1 = 1;
								for (Schedule s : Data.scheduleList) {
									String sDate = String.format("%tF", s.getDate());
									if (date.equals(sDate)) {
										scheList.add(s);
										inputList.add(String.format("\t\t\t%d	%s	%s vs %s	 %s	    %s\n", seq1,
												String.format("%tF", s.getDate()), s.getTeam1(),
												s.getTeam2(), s.getPlace(), s.getTime()));
										seq1++;
									}
								}
								
								if (scheList.size() == 0) {
									System.out.println("\t\t\t\t\t경기가 없습니다.");
									break;
								} else {
									System.out.println("\t\t\t===============================================================================");
									System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
									System.out.println("\t\t\t===============================================================================");
									for (String s : inputList) {
										System.out.println(s);
									}
									System.out.println("\t\t\t-------------------------------------------------------------------------------");
									
									System.out.print("\t\t\t\t\t경기 리스트 선택(0.뒤로가기):");
									final String REGEX = "[0-9]+";
									input = sc.nextLine();
									if (input.matches(REGEX)) {
										if (input.equals("0")) {
											dateFlag = false;
											break;
										} else if (Integer.parseInt(input) <= scheList.size()) {
											while (true) {
												System.out.println("\t\t\t===============================================================================");
												System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
												System.out.println("\t\t\t===============================================================================");
												System.out.printf("\t\t\t%d	%s	%s vs %s	 %s	    %s\n",
														Integer.parseInt(input),
														String.format("%tF",scheList.get(Integer.parseInt(input) - 1).getDate()),
														scheList.get(Integer.parseInt(input) - 1).getTeam1(),
														scheList.get(Integer.parseInt(input) - 1).getTeam2(),
														scheList.get(Integer.parseInt(input) - 1).getPlace(),
														scheList.get(Integer.parseInt(input) - 1).getTime());
												System.out.println("\t\t\t-------------------------------------------------------------------------------");
												System.out.print("\t\t\t\t\t삭제하시려는 정보가 맞습니까?(y/n)");
												String yesNo = sc.nextLine().toLowerCase();
												if (yesNo.equals("y")) {
													Schedule result = null;
													for (Schedule s : Data.scheduleList) {
														if (s.getSeq() == scheList.get(Integer.parseInt(input) - 1).getSeq()) {
															result = s;
														}
													}
													Data.scheduleList.remove(result); 
													schList.remove(result);
													System.out.println("\t\t\t\t\t삭제가 완료되었습니다.");
													System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
													String asdf = sc.nextLine();
													break;
												} else if (yesNo.equals("n")) {
													break;
												} else {
													System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
												}
											}
											
										} else if (scheList.size() == 0) {
											System.out.println("\t\t\t\t\t경기가 없습니다.");
											
										} else {
											System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
											
										}
										
									}
									
									
								}
							} else if (date.equals("0")) {
								break;
							} else {
								System.out.println("\t\t\t\t\t올바르지 않은 날짜입니다.");
								break;
							}
							
						}
					}
				} else if (input.equals("2")) {
					if (seq == schList.size() + 1 || seq == schList.size()) {
						seq -= schList.size() % 10;
					} else {
						seq -= 10;
					}
					boolean listFlag = true;
					while (listFlag) {
						System.out.print("\t\t\t\t\t경기 리스트 선택(0.뒤로가기):");
						final String REGEX = "[0-9]+";
						input = sc.nextLine();
						if (input.matches(REGEX)) {
							if (input.equals("0")) {
								break;
							} else if (Integer.parseInt(input) <= Data.scheduleList.size()) {
								while (true) {
									System.out.println("\t\t\t===============================================================================");
									System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
									System.out.println("\t\t\t===============================================================================");
									System.out.printf("\t\t\t%d	%s	%s vs %s	 %s	    %s\n",
											Integer.parseInt(input),
											String.format("%tF",schList.get(Integer.parseInt(input) - 1).getDate()),
											schList.get(Integer.parseInt(input) - 1).getTeam1(),
											schList.get(Integer.parseInt(input) - 1).getTeam2(),
											schList.get(Integer.parseInt(input) - 1).getPlace(),
											schList.get(Integer.parseInt(input) - 1).getTime());
									System.out.println("\t\t\t-------------------------------------------------------------------------------");
									System.out.print("\t\t\t\t\t삭제하시려는 정보가 맞습니까?(y/n)");
									String yesNo = sc.nextLine().toLowerCase();
									if (yesNo.equals("y")) {
										Schedule result = null;
										for (Schedule s : Data.scheduleList) {
											if (s.getSeq() == schList.get(Integer.parseInt(input) - 1).getSeq()) {
												result = s;
											}
										}
										Data.scheduleList.remove(result);
										schList.remove(result);
										System.out.println("\t\t\t\t\t삭제가 완료되었습니다.");
										System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
										String asdf = sc.nextLine();
										listFlag = false;
										break;
									} else if (yesNo.equals("n")) {
										listFlag = false;
										break;
									} else {
										System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
									}
									
								}
								
							} else {
								System.out.println("\t\t\t\t\t잘못 입력 하셨습니다.");
							}
							
						} else {
							System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
						}
						
					}

				} else if (input.equals("0")) {
					return;
				} else {
					System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
					seq -= 10;
				}



			}
		}
		
		
	}
	
	/**
	 * 관리자가 경기를 수정하는 메소드 입니다.
	 */
	public static void scheduleEdit() {

		Scanner sc = new Scanner(System.in);
		while (true) {
			ArrayList<Schedule> schList = new ArrayList<Schedule>();
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, -1);
			for (Schedule s : Data.scheduleList) {
				if (s.getDate().compareTo(c) > 0) {
					schList.add(s);
				}
			}
			int seq = 1;
			for (int i = 0; i < schList.size() / 10 + 1;) {
				System.out.println("\t\t\t===============================================================================");
				System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
				System.out.println("\t\t\t===============================================================================");
				for (int j = 0 + i * 10; j < 10 + i * 10; j++) {
					if (j >= schList.size()) {
						break;
					}
					System.out.printf("\t\t\t%d	%s	%s vs %s	 %s	    %s\n", seq,
							String.format("%tF", schList.get(j).getDate()),
							schList.get(j).getTeam1(), schList.get(j).getTeam2(),
							schList.get(j).getPlace(), schList.get(j).getTime());
					seq++;

				}
				System.out.printf("\t\t\t[%d페이지]\n", i + 1);
				System.out.println("\t\t\t-------------------------------------------------------------------------------");
				AdminOutput.scheduleEditMenu();
				String input = sc.nextLine();
				if (input.equals(">")) {
					if (i == schList.size() / 10) {
						seq = schList.size() - (schList.size() % 10) + 1;
						System.out.println("\t\t\t\t\t마지막 페이지 입니다.");
						System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
						input = sc.nextLine();
					} else {
						i++;

					}
				} else if (input.equals("<")) {
					if (i == 0) { // 첫페이지인지 확인하는 if문
						seq = 1;
						System.out.println("\t\t\t\t\t이전 페이지가 없습니다.");
						System.out.println("\t\t\t\t\t다시 입력하시려면 엔터(Enter)를 누르세요.");
						input = sc.nextLine();
					} else { // 첫페이지가 아니면 i-- 해줘서 이전 페이지
						i--;
						if (seq == schList.size() + 1) {
							seq -= 10 + (schList.size() % 10);
						} else {
							seq -= 20;
						}
					}
				} else if (input.equals("1")) {
					if (seq == schList.size() + 1 || seq == schList.size()) {
						seq -= schList.size() % 10;
					} else {
						seq -= 10;
					}
					boolean dateFlag = true;
					while (dateFlag) {
						System.out.println("\t\t\t\t\t경기 날짜는 \"-\"으로 구분하여 입력하세요. (예시:2022-04-07)");
						System.out.print("\t\t\t\t\t경기 날짜 입력(0.뒤로가기):");
						String date = sc.nextLine();
						if (formatCheck(date)) {

							ArrayList<Schedule> scheList = new ArrayList<Schedule>();
							ArrayList<String> inputList = new ArrayList<String>();
							int seq1 = 1;
							for (Schedule s : Data.scheduleList) {
								String sDate = String.format("%tF", s.getDate());
								if (date.equals(sDate)) {
									scheList.add(s);
									inputList.add(String.format("\t\t\t%d	%s	%s vs %s	 %s	    %s", seq1,
											String.format("%tF", s.getDate()), s.getTeam1(),
											s.getTeam2(), s.getPlace(), s.getTime()));
									seq1++;
								}
							}

							if (scheList.size() == 0) {
								System.out.println("\t\t\t\t\t경기가 없습니다.");
							} else {
								while (true) {
									System.out.println("\t\t\t===============================================================================");
									System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
									System.out.println("\t\t\t===============================================================================");
									for (String s : inputList) {
										System.out.println(s);
									}
									System.out.println("\t\t\t-------------------------------------------------------------------------------");
									
									System.out.print("\t\t\t\t\t경기 리스트 선택(0.뒤로가기):");
									final String REGEX = "[0-9]+";
									
									input = sc.nextLine();
									if (input.equals("0")) {
										dateFlag = false;
										break;
									}
									if (input.matches(REGEX)) {
										if (Integer.parseInt(input) <= scheList.size()) {
											while (true) {
												System.out.println("\t\t\t===============================================================================");
												System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
												System.out.println("\t\t\t===============================================================================");
												System.out.printf("\t\t\t%d	%s	%s vs %s	 %s	    %s\n",
														Integer.parseInt(input),
														String.format("%tF",scheList.get(Integer.parseInt(input) - 1).getDate()),
														scheList.get(Integer.parseInt(input) - 1).getTeam1(),
														scheList.get(Integer.parseInt(input) - 1).getTeam2(),
														scheList.get(Integer.parseInt(input) - 1).getPlace(),
														scheList.get(Integer.parseInt(input) - 1).getTime());
												System.out.println("\t\t\t-------------------------------------------------------------------------------");
												AdminOutput.scheduleEditSelect();
												String input1 = sc.nextLine().toLowerCase();
												if (input1.equals("0")) {
													break;
												} else if (input1.equals("1")) {
													boolean team1Flag = true;
													while (team1Flag) {
														System.out.print("\t\t\t\t\t\t팀1 이름 입력(0.뒤로가기):");
														String team1Name = sc.nextLine();
														
														YearTeam result = null;
														for (YearTeam y : Data.yearTeamList) {
															if (team1Name.equals(y.getTeamName())) {
																result = y;
															}
														}
														if (team1Name.equals("0")) {
															break;
														} else if (result != null) {
															while (true) {
																System.out.print("\t\t\t\t\t\t팀2 이름 입력(0.뒤로가기):");
																String team2Name = sc.nextLine();
																result = null;
																for (YearTeam y : Data.yearTeamList) {
																	if (team2Name.equals(y.getTeamName())) {
																		result = y;
																	}
																}
																if (team1Name.equals("0")) {
																	break;
																} else if (result != null) {
																	System.out.printf("\t\t\t\t\t\t변경 전:%s vs %s\n"
																			, scheList.get(Integer.parseInt(input) - 1).getTeam1()
																			, scheList.get(Integer.parseInt(input) - 1).getTeam2());
																	System.out.printf("\t\t\t\t\t\t변경 후:%s vs %s\n", team1Name, team2Name);
																	
																	System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
																	String yesNo = sc.nextLine().toLowerCase();
																	if (yesNo.equals("y")) {
																		
																		for (Schedule d : Data.scheduleList) {
																			if (d.equals(scheList.get(Integer.parseInt(input) - 1))) {
																				d.setTeam1(team1Name);
																				d.setTeam2(team2Name);
																			}
																		}
																		System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
																		System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
																		String asda = sc.nextLine();
																		team1Flag = false;
																		dateFlag = false;
																		break;
																	} else if (yesNo.equals("n")) {
																		break;
																	}
																	
																} else {
																	System.out.println("\t\t\t\t\t팀 목록에 없는 팀이름 입니다.");
																}
															}
														} else {
															System.out.println("\t\t\t\t\t팀 목록에 없는 팀이름 입니다.");
														}
													}
												} else if (input1.equals("2")) {
													while (true) {
														System.out.println("\t\t\t\t\t경기 날짜는 \"-\"으로 구분하여 입력하세요. (예시:2022-04-07)");
														System.out.print("\t\t\t\t\t\t경기 날짜 입력(0.뒤로가기):");
														input1 = sc.nextLine();
														if (formatCheck(input1)) {
															System.out.printf("\t\t\t\t\t\t변경 전:%s\n",
																	String.format("%tF", scheList.get(Integer.parseInt(input) - 1).getDate()));
															System.out.printf("\t\t\t\t\t\t변경 후:%s\n", input1);
															System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
															input1 = sc.nextLine();
															if (input1.equals("y")) {
																c = Calendar.getInstance();
																c.set(Integer.parseInt(String.format("%tF",scheList.get(Integer.parseInt(input) - 1).getDate()).split("-")[0]),
																		Integer.parseInt(String.format("%tF", scheList.get(Integer.parseInt(input) - 1).getDate()).split("-")[1]) - 1,
																		Integer.parseInt(String.format("%tF", scheList.get(Integer.parseInt(input) - 1).getDate()).split("-")[2]));
																
																for (Schedule d : Data.scheduleList) {
																	if (d.equals(scheList.get(Integer.parseInt(input) - 1))) {
																		d.setDate(c);
																	}
																}
																System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
																System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
																String asda = sc.nextLine();
																dateFlag = false;
																break;
																
															} else if (input1.equals("n")) {
																break;
															} else {
																System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
															}
														} else if (input1.equals("0")) {
															break;
														} else {
															System.out.println("\t\t\t\t\t잘못 입력 하셨습니다.");
														}
														
													}
												} else if (input1.equals("3")) {
													while (true) {
														System.out.println("\t\t\t\t\t경기 시간은 \":\"으로 구분하여 입력하세요. (예시: 14:00)");
														System.out.print("\t\t\t\t\t\t경기 시간 입력(0.뒤로가기):");
														String time = sc.nextLine();
														if (time.equals("0")) {
															break;
														} else if (time.contains(":")
																&& Integer.parseInt(time.split(":")[0]) < 24
																&& Integer.parseInt(time.split(":")[1]) < 60) {
															
															System.out.printf("\t\t\t\t\t\t변경 전:%s\n",scheList.get(Integer.parseInt(input) - 1).getTime());
															System.out.printf("\t\t\t\t\t\t변경 후:%s\n", time);
															System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
															input1 = sc.nextLine();
															if (input1.equals("y")) {
																
																
																for (Schedule d : Data.scheduleList) {
																	if (d.equals(scheList.get(
																			Integer.parseInt(input) - 1))) {
																		d.setTime(time);
																	}
																}
																System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
																System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
																String asda = sc.nextLine();
																dateFlag = false;
																break;
															} else if (input1.equals("n")) {
																break;
															} else {
																System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
															}
															
														} else {
															System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
														}
														
													}
												} else if (input1.equals("4")) {
													while (true) {
														System.out.print("\t\t\t\t\t\t경기장 입력(0.뒤로가기):");
														String place = sc.nextLine();
														if (place.equals("0")) {
															break;
														} else {
															
															System.out.printf("\t\t\t\t\t\t변경 전:%s\n",scheList.get(Integer.parseInt(input) - 1).getPlace());
															System.out.printf("\t\t\t\t\t\t변경 후:%s\n", place);
															System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
															input1 = sc.nextLine();
															if (input1.equals("y")) {
																
																for (Schedule d : Data.scheduleList) {
																	if (d.equals(scheList.get(
																			Integer.parseInt(input) - 1))) {
																		d.setPlace(place);
																	}
																}
																System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
																System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
																String asda = sc.nextLine();
																dateFlag = false;
																break;
															} else if (input1.equals("n")) {
																break;
															} else {
																System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
															}
															
														}
														
													}
												} else {
													System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
												}
												
											}
											
										} else if (scheList.size() == 0) {
											System.out.println("\t\t\t\t\t경기가 없습니다.");
											break;
										} else {
											System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
										}
										
									}
									if (input.equals("0")) {
										break;
									}
									
									
								}

							}
						} else if (date.equals("0")) {
							break;
						} else {
							System.out.println("\t\t\t\t\t올바르지 않은 날짜입니다.");
						}
					}
				} else if (input.equals("2")) {
					if (seq == schList.size() + 1 || seq == schList.size()) {
						seq -= schList.size() % 10;
					} else {
						seq -= 10;
					}
					System.out.print("\t\t\t\t\t\t경기 리스트 선택(0.뒤로가기):");
					final String REGEX = "[0-9]+";
					input = sc.nextLine();
					if (input.matches(REGEX)) {
						if (input.equals("0")) {
							break;
						} else if (Integer.parseInt(input) <= Data.scheduleList.size()) {
							while (true) {
								System.out.println("\t\t\t===============================================================================");
								System.out.println("\t\t\t[번호]	[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
								System.out.println("\t\t\t===============================================================================");
								System.out.printf("\t\t\t%d	%s	%s vs %s	 %s	    %s\n",
										Integer.parseInt(input),
										String.format("%tF",schList.get(Integer.parseInt(input) - 1).getDate()),
										schList.get(Integer.parseInt(input) - 1).getTeam1(),
										schList.get(Integer.parseInt(input) - 1).getTeam2(),
										schList.get(Integer.parseInt(input) - 1).getPlace(),
										schList.get(Integer.parseInt(input) - 1).getTime());
								System.out.println("\t\t\t-------------------------------------------------------------------------------");
								AdminOutput.scheduleEditSelect();
								String input1 = sc.nextLine().toLowerCase();
								if (input1.equals("0")) {
									break;
								} else if (input1.equals("1")) {
									boolean team1Flag = true;
									while (team1Flag) {
										System.out.print("\t\t\t\t\t\t팀1 이름 입력(0.뒤로가기):");
										String team1Name = sc.nextLine();
										
										YearTeam result = null;
										for (YearTeam y : Data.yearTeamList) {
											if (team1Name.equals(y.getTeamName())) {
												result = y;
											}
										}
										if (team1Name.equals("0")) {
											break;
										} else if (result != null) {
											while (true) {
												System.out.print("\t\t\t\t\t\t팀2 이름 입력(0.뒤로가기):");
												String team2Name = sc.nextLine();
												result = null;
												for (YearTeam y : Data.yearTeamList) {
													if (team2Name.equals(y.getTeamName())) {
														result = y;
													}
												}
												if (team1Name.equals("0")) {
													break;
												} else if (result != null) {
													System.out.printf("\t\t\t\t\t\t변경 전:%s vs %s\n"
															, schList.get(Integer.parseInt(input) - 1).getTeam1()
															, schList.get(Integer.parseInt(input) - 1).getTeam2());
													System.out.printf("\t\t\t\t\t\t변경 후:%s vs %s\n", team1Name, team2Name);
													
													System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
													String yesNo = sc.nextLine().toLowerCase();
													if (yesNo.equals("y")) {
														
														for (Schedule d : Data.scheduleList) {
															if (d.equals(schList.get(Integer.parseInt(input) - 1))) {
																d.setTeam1(team1Name);
																d.setTeam2(team2Name);
															}
														}
														System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
														System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
														String asda = sc.nextLine();
														team1Flag = false;
														break;
													} else if (yesNo.equals("n")) {
														break;
													}
													
												} else {
													System.out.println("\t\t\t\t\t팀 목록에 없는 팀이름 입니다.");
												}
											}
										} else {
											System.out.println("\t\t\t\t\t팀 목록에 없는 팀이름 입니다.");
										}
									}
								} else if (input1.equals("2")) {
									while (true) {
										System.out.println("\t\t\t\t\t경기 날짜는 \"-\"으로 구분하여 입력하세요. (예시:2022-04-07)");
										System.out.print("\t\t\t\t\t\t경기 날짜 입력(0.뒤로가기):");
										input1 = sc.nextLine();
										
										if (formatCheck(input1)) {
											System.out.printf("\t\t\t\t\t\t변경 전:%s\n", String.format("%tF",schList.get(Integer.parseInt(input) - 1).getDate()));
											System.out.printf("\t\t\t\t\t\t변경 후:%s\n", input1);
											System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
											input1 = sc.nextLine();
											if (input1.equals("y")) {
												c = Calendar.getInstance();
												c.set(Integer.parseInt(String.format("%tF",schList.get(Integer.parseInt(input) - 1).getDate()).split("-")[0]),
														Integer.parseInt(String.format("%tF",schList.get(Integer.parseInt(input) - 1).getDate()).split("-")[1]) - 1,
														Integer.parseInt(String.format("%tF", schList.get(Integer.parseInt(input) - 1).getDate()).split("-")[2]));
												
												for (Schedule d : Data.scheduleList) {
													if (d.equals(schList.get(Integer.parseInt(input) - 1))) {
														d.setDate(c);
													}
												}
												System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
												System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
												String asda = sc.nextLine();
											} else if (input1.equals("n")) {
												break;
											} else {
												System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
											}
										} else if (input1.equals("0")) {
											break;
										} else {
											System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
										}
										
									}
								} else if (input1.equals("3")) {
									while (true) {
										System.out.println("\t\t\t\t\t경기 시간은 \":\"으로 구분하여 입력하세요. (예시: 14:00)");
										System.out.print("\t\t\t\t\t\t경기 시간 입력(0.뒤로가기):");
										String time = sc.nextLine();
										if (time.equals("0")) {
											break;
										} else if (time.contains(":")
												&& Integer.parseInt(time.split(":")[0]) < 24
												&& Integer.parseInt(time.split(":")[1]) < 60) {
											
											System.out.printf("\t\t\t\t\t\t변경 전:%s\n",schList.get(Integer.parseInt(input) - 1).getTime());
											System.out.printf("\t\t\t\t\t\t변경 후:%s\n", time);
											System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
											input1 = sc.nextLine();
											if (input1.equals("y")) {
												
												
												for (Schedule d : Data.scheduleList) {
													if (d.equals(schList.get(Integer.parseInt(input) - 1))) {
														d.setTime(time);
													}
												}
												System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
												System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
												String asda = sc.nextLine();
											} else if (input1.equals("n")) {
												break;
											} else {
												System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
											}
											
										} else {
											System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
										}
										
									}
								} else if (input1.equals("4")) {
									while (true) {
										System.out.print("\t\t\t\t\t\t경기장 입력(0.뒤로가기):");
										String place = sc.nextLine();
										if (place.equals("0")) {
											break;
										} else {
											
											System.out.printf("\t\t\t\t\t\t변경 전:%s\n",schList.get(Integer.parseInt(input) - 1).getPlace());
											System.out.printf("\t\t\t\t\t\t변경 후:%s\n", place);
											System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n)");
											input1 = sc.nextLine();
											if (input1.equals("y")) {
												
												
												for (Schedule d : Data.scheduleList) {
													if (d.equals(schList.get(Integer.parseInt(input) - 1))) {
														d.setPlace(place);
													}
												}
												System.out.println("\t\t\t\t\t변경이 완료되었습니다.");
												System.out.println("\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
												String asda = sc.nextLine();
											} else if (input1.equals("n")) {
												break;
											} else {
												System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
											}
											
										}
										
									}
								} else {
									System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
								}
								
							}
							
						} else {
							System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
						}
						
					} else {
						System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
					}

				} else if (input.equals("0")) {
					return;
				} else {
					System.out.println("\t\t\t\t\t잘못 입력하셨습니다.");
					seq -= 10;
				}



			}
		}

	}
	
	/**
	 * 관리자가 경기를 추가하는 메소드 입니다.
	 */
	public static void scheduleAdd() {
		Scanner sc = new Scanner(System.in);
		boolean team1Flag = true;
		boolean team2Flag = true;
		boolean dateFlag = true;
		boolean timeFlag = true;
		boolean placeFlag = true;
		while (team1Flag) {
			System.out.print("\t\t\t\t\t\t팀1 이름 입력(0.뒤로가기):");
			String team1Name = sc.nextLine();

			YearTeam result = null;
			for (YearTeam y : Data.yearTeamList) {
				if (team1Name.equals(y.getTeamName())) {
					result = y;
				}
			}

			if (team1Name.equals("0")) {
				break;
			} else if (result != null) {
				while (team2Flag) {
					System.out.print("\t\t\t\t\t\t팀2 이름 입력(0.뒤로가기):");
					String team2Name = sc.nextLine();
					result = null;
					for (YearTeam y : Data.yearTeamList) {
						if (team2Name.equals(y.getTeamName())) {
							result = y;
						}
					}
					if (team1Name.equals("0")) {
						break;
					} else if (result != null) {
						while (dateFlag) {
							System.out.println("\t\t\t\t\t\t경기 날짜는 \"-\"으로 구분하여 입력하세요. (예시:2022-04-07)");
							System.out.print("\t\t\t\t\t\t경기 날짜 입력(0.뒤로가기):");
							String date = sc.nextLine();

							if (formatCheck(date)) {

								while (timeFlag) {
									System.out.println("\t\t\t\t\t\t경기 시간은 \":\"으로 구분하여 입력하세요. (예시: 14:00)");
									System.out.print("\t\t\t\t\t\t경기 시간 입력(0.뒤로가기):");
									String time = sc.nextLine();
									if (time.contains(":")
											&& Integer.parseInt(time.split(":")[0]) < 24
											&& Integer.parseInt(time.split(":")[1]) < 60) {

										while (placeFlag) {
											System.out.print("\t\t\t\t\t\t경기장 입력(0.뒤로가기):");
											String place = sc.nextLine();
											if (place.equals("0")) {
												break;
											} else {
												System.out.println("\t\t\t===============================================================================");
												System.out.println("\t\t\t[경기 날짜]	   [경기 정보]		 [경기장]		  [시간]");
												System.out.println("\t\t\t===============================================================================");
												System.out.printf("\t\t\t%s	%s vs %s	 %s	    	%s\n",date, team1Name, team2Name, place, time);
												System.out.println("\t\t\t-------------------------------------------------------------------------------");
												while (true) {
													System.out.print("\t\t\t\t\t\t입력하신 정보가 맞습니까?(y/n): ");
													String input = sc.nextLine().toLowerCase();
													if (input.equals("y")) {
														String starting1 = "";
														String starting2 = "";
														for (YearTeam y : Data.yearTeamList) {
															if (team1Name.equals(y.getTeamName())) {
																starting1 = y.getStarting();
															} else if (team2Name.equals(y.getTeamName())) {
																starting2 = y.getStarting();
															}
														}
														String[] weather ={"맑음", "흐림", "비", "맑음", "맑음"};
														Random rnd = new Random();
														Calendar c = Calendar.getInstance();
														c.set(Integer.parseInt(date.split("-")[0]),
																Integer.parseInt(date.split("-")[1])- 1,
																Integer.parseInt(date.split("-")[2]));
														int last = Data.scheduleList.get(Data.scheduleList.size() - 1).getSeq();
														Schedule s = new Schedule(last + 1,
																team1Name, team2Name, starting1,
																starting2, place, c, time,
																weather[rnd.nextInt(6)], 0, 0);
														Data.scheduleList.add(s);
														System.out.println("\t\t\t\t\t\t추가가 완료되었습니다.");
														System.out.println("\t\t\t\t\t\tEnter(엔터)를 누르면 이전 메뉴로 돌아갑니다.");
														input = sc.nextLine();
														return;
													} else if (input.equals("n")) {
														return;
													} else {
														System.out.println("\t\t\t\t\t\t잘못 입력하셨습니다.");
													}
												}
											}

										}

									} else if (time.equals("0")) {
										break;
									} else {
										System.out.println("\t\t\t\t\t\t올바르지 않은 시간입니다.");
									}
								}
							} else {
								System.out.println("\t\t\t\t\t\t올바르지 않은 날짜입니다.");
							}

						}

					} else {
						System.out.println("\t\t\t\t\t\t팀 목록에 없는 팀이름 입니다.");
					}

				}

			} else {
				System.out.println("\t\t\t\t\t\t팀 목록에 없는 팀이름 입니다.");
			}
			
		
		}
		
	}
	
	/**
	 * 입력된 날짜가 유효한 날짜인지 확인하는 메소드 입니다.
	 * @param 사용자가 입력한 날짜
	 * @return 입력한 날짜가 올바르면 true 올바르지 않으면 false를 반환합니다.
	 */
	public static boolean formatCheck(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			sdf.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}


}
