package com.project.sports.user.community;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Comment;
import com.project.sports.input.Post;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.UserLogin;

/**
 * 접속한 아이디의 활동을 보는 클래스입니다.
 * @author 김영석
 *
 */
public class MyActivities {
	/**
	 * 로그인한 아이디로 활동한 글목록과 댓글 목록을 볼 수 있습니다.
	 */
	public static void Myactivities() {
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │             1. 글목록		    │");
			System.out.println("\t\t\t\t\t │             2. 댓글목록		    │");
			System.out.print("\t\t\t\t\t │\t       "); Output.back(); System.out.print("\t    	    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			Output.input();
			String input = sc.nextLine();
			
			
			if (input.equals("0")) {
				break;
			} else if (input.equals("1")) {
				
				List<Post> poList = new ArrayList<Post>();
				boolean dFlag = true;
				while (dFlag) {
					int num = 1;
					System.out.println("\t       ================================================================================================");
					System.out.println("\t\t[글번호] [말머리]\t\t[제목]\t\t\t[작성자]\t\t\t  [작성일]       \t[조회수]");
					System.out.println("\t       ================================================================================================");
					
					for (Post p : Data.postList) {
						
						if (p.getId().equals(UserLogin.userData.getId())) {
							poList.add(p);
							
							String title = "";
							if (p.getTitle().length() > 20) {
								title = p.getTitle().substring(0,19) + "..";
							} else {
								title = p.getTitle();
							}
							
							for (int i=0; i<Community.blist.size(); i++) {
								title = title.replaceAll(Community.blist.get(i), "**");
							}
							
							
							
							System.out.printf("\t\t%3s\t%s\t\t%s\t\t\t%-20s\t%tF\t%4s\n"
									, num
									, p.getSubject()
									, title
									, p.getId()
									, p.getDate()
									, p.getView());
							num++;
						}
					}
					//System.out.println();
					System.out.println("\t       ------------------------------------------------------------------------------------------------");
					if (poList.size() == 0) {						
						System.out.println("---------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\t\t\t\t\t\t 글이 없습니다.");
						System.out.println("---------------------------------------------------------------------------------------------------------------------------");
						break;
					}
					
					System.out.print("\t\t\t\t\t\t 글 번호 입력:(0.뒤로가기)");
					String number = sc.nextLine();
					if (number.equals("0")) {
						break;
					} else {
						boolean cFlag = true;
						while (cFlag) {
							String title = poList.get(Integer.parseInt(number)-1).getTitle();
							String content = poList.get(Integer.parseInt(number)-1).getContent();
							
							for (int i=0; i<Community.blist.size(); i++) {
								title = title.replaceAll(Community.blist.get(i), "**");
								content = content.replaceAll(Community.blist.get(i), "**");
							}
							for (Post p : Data.postList) {
								if (poList.get(Integer.parseInt(number)-1).getSeq() == p.getSeq()) {
									p.setView(p.getView()+1);
								}
							}
							System.out.println();
							System.out.println("\t       ================================================================================================");											
							System.out.printf("\t\t\t제목: %s\n", title); //금지어 마스킹 완료 문구
							System.out.printf("\t\t\t작성자: %s\n", poList.get(Integer.parseInt(number)-1).getId());
							System.out.printf("\t\t\t내용: %s\n", content); //금지어 마스킹 완료 문구
							System.out.println("\t       ------------------------------------------------------------------------------------------------");
							List<Comment> coList = new ArrayList<Comment>();
							for (Comment c : Data.commentList) {
								if (poList.get(Integer.parseInt(number)-1).getSeq() == c.getPostSeq()) { //글 번호 == 댓글목록의 글번호 > 일 경우
									System.out.printf("\t\t\t\t└> %s: %s | 댓글 작성일자: %tF\n"
											, c.getId()
											, c.getContent()
											, c.getDate());
									coList.add(c);
									
								}
							}
							
							System.out.println("\t       ------------------------------------------------------------------------------------------------");
							
							System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
							System.out.println("\t\t\t\t\t │             1.댓글 작성	            │");
							List<Comment> cList = new ArrayList<Comment>();
							
							for (Comment c : Data.commentList) {
								if (poList.get(Integer.parseInt(number)-1).getSeq() == c.getPostSeq()) {
									cList.add(c);
								}
							}
							List<Comment> csList = new ArrayList<Comment>();
							
							for (Comment c : Data.commentList) {
								if (poList.get(Integer.parseInt(number)-1).getSeq() == c.getPostSeq()
										&& c.getId().equals(UserLogin.userData.getId())) {
									csList.add(c);
								}
							}
							
							if (csList.size() != 0) {
								System.out.println("\t\t\t\t\t │             2.댓글 수정	            │");
								System.out.println("\t\t\t\t\t │             3.댓글 삭제	            │");
							}
							
							if (poList.get(Integer.parseInt(number)-1).getId().equals(UserLogin.userData.getId())) {
								System.out.println("\t\t\t\t\t │             4.글 수정	            │");
								System.out.println("\t\t\t\t\t │             5.글 삭제	            │");
								
							}
							System.out.print("\t\t\t\t\t │\t       "); Output.back(); System.out.print("\t    	    │\n");
							System.out.println("\t\t\t\t\t └──────────────────────────────────┘");

							Output.input();
							String nb = sc.nextLine();
							
							if (nb.equals("0")) {
								break;
							} else if (nb.equals("1")) {
								boolean coFlag = true;
								while (coFlag) {
									System.out.println("---------------------------------------------------------------------------------------------------------------------------");
									System.out.print("\t\t\t\t\t\t 댓글 입력(0.뒤로가기): ");
									String inCommentCo = sc.nextLine();
									if (inCommentCo.equals("0")) {
										break;
									} else {
										boolean commentCheck = true;
										//boolean cocomentCheck = true;
										while(commentCheck) {
											Calendar c1 = Calendar.getInstance();
											System.out.printf("\t\t\t\t\t\t 내용: %s\n",inCommentCo);
											System.out.print("\t\t\t\t\t\t 해당 댓글을 등록하시겠습니까? (Y/N): ");
											String coCheck = sc.nextLine().toLowerCase();
											if (coCheck.equals("y")) {
												int last = Data.commentList.get(Data.commentList.size()-1).getSeq();
												Comment c = new Comment(last+1
														, poList.get(Integer.parseInt(number)-1).getSeq()
														, c1
														, UserLogin.userData.getId()
														, inCommentCo);
												Data.commentList.add(c);
												coFlag = false;
												break;
											} else if (coCheck.equals("n")) {
												
												break;
											} else {
												System.out.println("\t\t\t\t\t\t 잘못 입력하셨습니다.");
											}
										}
									}
								}
							} else if (nb.equals("2")) {
								
								if (csList.size() == 0) {
									System.out.println("---------------------------------------------------------------------------------------------------------------------------");
									System.out.println("\t\t\t\t\t\t 수정할 댓글이 없습니다.");
									Output.pause();
									System.out.println("---------------------------------------------------------------------------------------------------------------------------");
								} else {
									
									while (true) {
										System.out.println("\t       ================================================================================================");
										
										System.out.println("\t\t\t[번호] [작성자]\t\t\t[내용]\t\t\t  [작성일자]");
										int num2 = 1;
										for (Comment c : csList) {
											
											System.out.printf("\t\t\t%3d\t%s\t  %20s\t\t\t%tF\n", num2, c.getId(), c.getContent(), c.getDate());
											num2++;
											
										}
										
										System.out.println("\t       ------------------------------------------------------------------------------------------------");
										System.out.println("\t\t\t\t\t\t 수정할 댓글의 번호를 입력해주세요.");
										System.out.print("\t\t\t\t\t\t 번호(0.뒤로가기): ");
										String inedit = sc.nextLine();
										if (inedit.equals("0")) {
											break;
										} else {
											while (true) {
												System.out.println("\t       ------------------------------------------------------------------------------------------------");
												System.out.print("\t\t\t\t\t\t 수정할 내용을 입력해주세요.(0.뒤로가기): ");
												String editcontent = sc.nextLine();
												System.out.println("\t       ------------------------------------------------------------------------------------------------");
												if (editcontent.equals("0")) {
													break;
												} else {
													System.out.printf("\t\t\t\t\t\t 수정할 내용: <%s>\n", editcontent);
													System.out.printf("\t\t\t\t\t\t 수정하시겠습니까?(Y/N):");
													String inCheck = sc.nextLine().toLowerCase();
													if (inCheck.equals("y")) {
														for (Comment c : Data.commentList) {
															if (csList.get(Integer.parseInt(inedit)-1).getSeq() == c.getSeq()) {
																c.setContent(editcontent);
															}
														}
														System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");												
														Output.pause();
														System.out.println("---------------------------------------------------------------------------------------------------------------------------");
														System.out.println();
														break;
													} else if (inCheck.equals("n")) {
														break;
													}
													
												}
											}
										}
										
										
										
									}
								}
								
							} else if (nb.equals("3")) {
								if (csList.size() == 0) {
									System.out.println("\t\t\t\t\t\t 삭제할 댓글이 없습니다.");
									System.out.println("\t\t\t\t\t\t 계속하시려면 엔터(Enter)를 입력하세요.");
									String stop = sc.nextLine();
								} else {
									while (true) {
										System.out.println("\t       ================================================================================================");
										
										System.out.println("\t\t\t[번호] [작성자]\t\t\t[내용]\t\t\t  [작성일자]");
										int num2 = 1;
										for (Comment c : csList) {
											
											System.out.printf("\t\t\t%3d\t%s\t  %20s\t\t\t%tF\n", num2, c.getId(), c.getContent(), c.getDate());
											num2++;
											
										}
										
										System.out.println("\t       ------------------------------------------------------------------------------------------------");
										System.out.println("\t\t\t\t\t\t 삭제할 댓글의 번호를 입력해주세요.");
										System.out.println("\t       ------------------------------------------------------------------------------------------------");
										System.out.print("\t\t\t\t\t\t 번호(0.뒤로가기): ");
										String inedit = sc.nextLine();
										if (inedit.equals("0")) {
											break;
										} else {
											Comment result = null;
											for (Comment c : Data.commentList) {
												if (csList.get(Integer.parseInt(inedit)-1).getSeq() == c.getSeq()) {
													result = c;
												}
											}
											Data.commentList.remove(result);
											System.out.println("\t\t\t\t\t\t 삭제가 완료되었습니다.");
											System.out.println("---------------------------------------------------------------------------------------------------------------------------");
											Output.pause();
											break;
										}
									}
									
								}
								
								
							} else if (nb.equals("4")) {
								
								while (true) {
									System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
									System.out.println("\t\t\t\t\t │             1. 말머리		    │");
									System.out.println("\t\t\t\t\t │             2. 제목		    │");
									System.out.println("\t\t\t\t\t │             3. 내용		    │");
									System.out.print("\t\t\t\t\t │\t       "); Output.back(); System.out.print("\t    	    │\n");
									System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
									
									System.out.print("\t\t\t\t\t\t 메뉴 번호 입력: ");
									
									String menu = sc.nextLine();
									
									if (menu.equals("0")) {
										break;
									} else if (menu.equals("1")) {
										while (true) {
											System.out.println("\t\t\t  ┌─────────────────────────────────────────────────────────────────────┐");
											System.out.println("\t\t\t  │   수정할 말머리를 입력해 주세요. (1.잡담, 2.이벤트, 3.직관, 4.질문, 0.뒤로가기)    \t│");
											System.out.println("\t\t\t  └─────────────────────────────────────────────────────────────────────┘");
											Output.input();
											String ins = sc.nextLine();
											if (ins.equals("1")) {
												if (poList.get(Integer.parseInt(number)-1).getSubject().equals("잡담")) {
													System.out.println("\t\t\t\t\t\t 기존과 동일한 말머리입니다.");
												} else {
													for (Post q : Data.postList) {
														if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
															q.setSubject("잡담");
														}
													}
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													Output.pause();
													break;
												}
											} else if (ins.equals("2")) {
												if (poList.get(Integer.parseInt(number)-1).getSubject().equals("이벤트")) {
													System.out.println("\t\t\t\t\t\t 기존과 동일한 말머리입니다.");
												} else {
													for (Post q : Data.postList) {
														if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
															q.setSubject("이벤트");
														}
													}
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
													System.out.println("---------------------------------------------------------------------------------------");
													Output.pause();
													break;
												}
											} else if (ins.equals("3")) {
												if (poList.get(Integer.parseInt(number)-1).getSubject().equals("직관")) {
													System.out.println("\t\t\t\t\t\t 기존과 동일한 말머리입니다.");
												} else {
													for (Post q : Data.postList) {
														if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
															q.setSubject("직관");
														}
														
													}
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													Output.pause();
													break;
												}
											} else if (ins.equals("4")) {
												if (poList.get(Integer.parseInt(number)-1).getSubject().equals("질문")) {
													System.out.println("\t\t\t\t\t\t 기존과 동일한 말머리입니다.");
												} else {
													for (Post q : Data.postList) {
														if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
															q.setSubject("질문");
														}
													}
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
													System.out.println("---------------------------------------------------------------------------------------------------------------------------");
													Output.pause();
													break;
												}
											} else if (ins.equals("0")) {
												break;
											}
											
										}
									} else if (menu.equals("2")) {
										while (true) {
											System.out.print("\t\t\t\t\t\t 수정할 제목을 입력해주세요.(0. 뒤로가기): ");	
											String title1 = sc.nextLine();
											System.out.printf("\t\t\t\t\t\t 수정할 제목:<%s>\n", title1);
											
											System.out.print("\t\t\t\t\t\t 수정할 내용이 맞습니까?(y/n):");
											String yn = sc.nextLine().toLowerCase();
											if (yn.equals("y")) {
												
												for (Post q : Data.postList) {
													if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
														q.setTitle(title1);
													}
												}
												System.out.println("---------------------------------------------------------------------------------------------------------------------------");
												System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
												System.out.println("---------------------------------------------------------------------------------------------------------------------------");
												Output.pause();
												break;
												
											} else if (yn.equals("n")) {
												break;
											}
										}
									} else if (menu.equals("3")) {
										while (true) {
											System.out.print("\t\t\t\t\t\t 수정할 내용을 입력해주세요. (0. 뒤로가기) : ");	
											String content1 = sc.nextLine();
											System.out.printf("\t\t\t\t\t\t 수정할 내용:<%s>\n", content1);
											
											System.out.print("\t\t\t\t\t\t 수정할 내용이 맞습니까?(y/n):");
											String yn = sc.nextLine().toLowerCase();
											if (yn.equals("y")) {
												
												for (Post q : Data.postList) {
													if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
														q.setContent(content1);
													}
												}
												System.out.println("---------------------------------------------------------------------------------------------------------------------------");
												System.out.println("\t\t\t\t\t\t 수정이 완료되었습니다.");
												System.out.println("---------------------------------------------------------------------------------------------------------------------------");
												Output.pause();
												break;
												
											} else if (yn.equals("n")) {
												break;
											}
										}
									}
 									
								}
								
							} else if (nb.equals("5")) {
								
								while (true) {
									System.out.print("\t\t\t\t\t\t 해당 글을 삭제하시겠습니까?(y/n):");									
									String yn = sc.nextLine();
									if (yn.equals("y")) {
										
										Post a = null;
										for (Post q : Data.postList) {
											if (poList.get(Integer.parseInt(number)-1).getSeq() == q.getSeq()) {
												a = q;
											}
										}
										Data.postList.remove(a);
										cFlag = false;
										dFlag = false;
										poList.remove(Integer.parseInt(number)-1);
										
										System.out.println("---------------------------------------------------------------------------------------------------------------------------");
										System.out.println("\t\t\t\t\t\t 삭제가 완료되었습니다.");
										System.out.println("---------------------------------------------------------------------------------------------------------------------------");
										
										
										break;
									} else if (yn.equals("n")) {
										break;
									} else {
										System.out.println("---------------------------------------------------------------------------------------------------------------------------");
										System.out.println("잘못 입력하셨습니다.");
										System.out.println("---------------------------------------------------------------------------------------------------------------------------");
									}
									
								}
								
							} else {
								System.out.println("---------------------------------------------------------------------------------------------------------------------------");
								System.out.println("잘못 입력하셨습니다.");
								System.out.println("---------------------------------------------------------------------------------------------------------------------------");
							}
							
							
						}
					}
					
					
				}
				
			} else if (input.equals("2")) {
				
				while (true) {
					List<Comment> commList = new ArrayList<Comment>();
					
					int num = 1;
					System.out.println("\t       ================================================================================================");
					System.out.println("\t\t       [댓글번호]\t\t[내용]\t\t\t[작성자]\t\t\t  [작성일]  ");
					System.out.println("\t       ================================================================================================");
					
					for (Comment p : Data.commentList) {
						
						if (p.getId().equals(UserLogin.userData.getId())) {
							commList.add(p);
							
							String content = p.getContent();
							
							for (int i=0; i<Community.blist.size(); i++) {
								content = content.replaceAll(Community.blist.get(i), "**");
							}
							
							
							
							System.out.printf("\t\t\t%3s\t%s\t%-20s\t%tF\n"
									, num
									, p.getContent()
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
					if (number.equals("0")) {
						break;
					} else {
						while (true) {
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
		
		
		
	}

}
