package com.project.sports.admin.teamPlayer;

import java.util.Calendar;
import java.util.Scanner;
import com.project.sports.input.Player;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

/**
 * 선수 정보를 수정하는 클래스
 * @author 서주예
 */
public class UpdatePlayer {

	
	/**
	 * 선수 정보를 수정하는 메소드
	 */
	public static void updatePlayer() {


		boolean updatePlayerFlag = true;
		while (updatePlayerFlag) {


			Scanner sc = new Scanner(System.in);

			// 선수 번호 입력받기
			System.out.print("\t\t\t\t\t    수정할 선수를 선택하세요. : ");
			String input = sc.nextLine();

			// 선택한 선수만 보여주기
			System.out.println();
			System.out.println("\t\t\t\t\t=========================================");
			System.out.println("\t\t\t\t\t포지션\t선수번호\t선수이름\t키\t몸무게");
			System.out.println("\t\t\t\t\t=========================================");
			System.out.printf("\t\t\t\t\t%s\t%s\t%s\t%s\t%s\n",
					SelectTeam.playerList.get(Integer.parseInt(input) - 1).getPosition(),
					SelectTeam.playerList.get(Integer.parseInt(input) - 1).getPlayerNum(),
					SelectTeam.playerList.get(Integer.parseInt(input) - 1).getName(),
					SelectTeam.playerList.get(Integer.parseInt(input) - 1).getHeight(),
					SelectTeam.playerList.get(Integer.parseInt(input) - 1).getWeight());



			System.out.println();
			// 세부메뉴 보여주기
			System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
			System.out.println("\t\t\t\t\t │             1. 포지션\t   \t    │");
			System.out.println("\t\t\t\t\t │             2. 선수 번호\t    │");
			System.out.println("\t\t\t\t\t │             3. 선수 이름\t    │");
			System.out.println("\t\t\t\t\t │             4. 키\t   \t    │");
			System.out.println("\t\t\t\t\t │             5. 몸무게\t   \t    │");
			System.out.print("\t\t\t\t\t │\t       ");
			Output.back();
			System.out.print("\t    	    │\n");
			System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
			while (true) {
				// 세부메뉴 선택 받기
				System.out.print("\t\t\t\t\t메뉴 번호 입력 : ");
				String menuNum = sc.nextLine();
				if (menuNum.equals("0")) {
					break;
				} else if (menuNum.equals("1")) {

					// 포지션
					System.out.print("\t\t\t\t\t수정할 내용을 입력하세요. : ");
					String position = sc.nextLine();

					// 전후 내용 보여주고 확인받기
					System.out.printf("\t\t\t\t\t변경 전 : %s\n",
							SelectTeam.playerList.get(Integer.parseInt(input) - 1).getPosition());
					System.out.printf("\t\t\t\t\t변경 후 : %s\n", position);

					System.out.print("\t\t\t\t\t입력한 정보가 맞습니까?(y/n) : ");
					String answer = sc.nextLine().toUpperCase();

					if (answer.equals("Y")) {

						Calendar c = Calendar.getInstance();
						int last = Data.playerList.get(Data.playerList.size() - 1).getSeq();

						if (position.equals("타자")) {

							Player player = new Player(last + 1,
									TeamPlayer.teamList.get(SelectTeam.input - 1).getSeq(),
									c.get(Calendar.YEAR) + "", position,
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getPlayerNum(),
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getName(),
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getHeight(),
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getWeight(),
									0, 0, 0, 0, 0);

							Data.playerList.add(player);

							for (Player p : Data.playerList) {

								if (SelectTeam.playerList.get(Integer.parseInt(input) - 1)
										.getSeq() == p.getSeq()) {

									Data.playerList.remove(p);
								}

							}


						} else if (position.equals("투수")) {

							Player player = new Player(last + 1,
									TeamPlayer.teamList.get(SelectTeam.input - 1).getSeq(),
									c.get(Calendar.YEAR) + "", position,
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getPlayerNum(),
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getName(),
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getHeight(),
									SelectTeam.playerList.get(Integer.parseInt(input) - 1)
											.getWeight(),
									0, 0, 0, 0);

							Data.playerList.add(player);

							for (Player p : Data.playerList) {

								if (SelectTeam.playerList.get(Integer.parseInt(input) - 1)
										.getSeq() == p.getSeq()) {

									Data.playerList.remove(p);
								}

							}


						}

						System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					} else if (answer.equals("N")) {

						System.out.println("\t\t\t\t\t수정이 취소되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					}

				} else if (menuNum.equals("2")) {
					// 선수번호
					System.out.print("\t\t\t\t\t수정할 내용을 입력하세요. : ");
					String playerNum = sc.nextLine();

					// 전후 내용 보여주고 확인받기
					System.out.println();
					System.out.printf("\t\t\t\t\t변경 전 : %s\n",
							SelectTeam.playerList.get(Integer.parseInt(input) - 1).getPlayerNum());
					System.out.printf("\t\t\t\t\t변경 후 : %s\n", playerNum);

					System.out.print("\t\t\t\t\t입력한 정보가 맞습니까?(y/n) : ");
					String answer = sc.nextLine().toUpperCase();

					if (answer.equals("Y")) {

						for (Player p : Data.playerList) {

							if (SelectTeam.playerList.get(Integer.parseInt(input) - 1).getSeq() == p
									.getSeq()) {

								p.setPlayerNum(playerNum);
							}

						}

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					} else if (answer.equals("N")) {

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 취소되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					}

				} else if (menuNum.equals("3")) {
					// 선수이름
					System.out.print("\t\t\t\t\t수정할 내용을 입력하세요. : ");
					String name = sc.nextLine();

					System.out.println();
					// 전후 내용 보여주고 확인받기
					System.out.printf("\t\t\t\t\t변경 전 : %s\n",
							SelectTeam.playerList.get(Integer.parseInt(input) - 1).getName());
					System.out.printf("\t\t\t\t\t변경 후 : %s\n", name);

					System.out.print("\t\t\t\t\t입력한 정보가 맞습니까?(y/n) : ");
					String answer = sc.nextLine().toUpperCase();

					if (answer.equals("Y")) {

						for (Player p : Data.playerList) {

							if (SelectTeam.playerList.get(Integer.parseInt(input) - 1).getSeq() == p
									.getSeq()) {

								p.setName(name);
							}

						}

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					} else if (answer.equals("N")) {

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 취소되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					}



				} else if (menuNum.equals("4")) {
					// 키
					System.out.print("\t\t\t\t\t수정할 내용을 입력하세요. : ");
					String height = sc.nextLine();

					// 전후 내용 보여주고 확인받기
					System.out.println();
					System.out.printf("\t\t\t\t\t변경 전 : %s\n",
							SelectTeam.playerList.get(Integer.parseInt(input) - 1).getHeight());
					System.out.printf("\t\t\t\t\t변경 후 : %s\n", height);

					System.out.print("\t\t\t\t\t입력한 정보가 맞습니까?(y/n) : ");
					String answer = sc.nextLine().toUpperCase();

					if (answer.equals("Y")) {

						for (Player p : Data.playerList) {

							if (SelectTeam.playerList.get(Integer.parseInt(input) - 1).getSeq() == p
									.getSeq()) {

								p.setHeight(height);
							}

						}

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					} else if (answer.equals("N")) {

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 취소되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					}

				} else if (menuNum.equals("5")) {
					// 몸무게
					System.out.print("\t\t\t\t\t수정할 내용을 입력하세요. : ");
					String weight = sc.nextLine();

					// 전후 내용 보여주고 확인받기
					System.out.println();
					System.out.printf("\t\t\t\t\t변경 전 : %s\n",
							SelectTeam.playerList.get(Integer.parseInt(input) - 1).getWeight());
					System.out.printf("\t\t\t\t\t변경 후 : %s\n", weight);

					System.out.print("\t\t\t\t\t입력한 정보가 맞습니까?(y/n) : ");
					String answer = sc.nextLine().toUpperCase();

					if (answer.equals("Y")) {

						for (Player p : Data.playerList) {

							if (SelectTeam.playerList.get(Integer.parseInt(input) - 1).getSeq() == p
									.getSeq()) {

								p.setWeight(weight);
							}

						}

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 완료되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					} else if (answer.equals("N")) {

						System.out.println();
						System.out.println("\t\t\t\t\t수정이 취소되었습니다.");
						System.out.println("\t\t\t\t\t계속하시려면 [엔터]를 입력하세요.");
						String enter = sc.nextLine();
						updatePlayerFlag = false;
						break;

					}
				}

			}
		}
	}
}
