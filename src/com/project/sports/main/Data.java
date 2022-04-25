package com.project.sports.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.project.sports.input.BannedWord;
import com.project.sports.input.BlackList;
import com.project.sports.input.Comment;
import com.project.sports.input.MyTeam;
import com.project.sports.input.Player;
import com.project.sports.input.Point;
import com.project.sports.input.Post;
import com.project.sports.input.Predict;
import com.project.sports.input.Record;
import com.project.sports.input.RelativeRecord;
import com.project.sports.input.Schedule;
import com.project.sports.input.Team;
import com.project.sports.input.Ticketing;
import com.project.sports.input.User;
import com.project.sports.input.YearTeam;

public class Data {
	
	public static List<User> userList = new ArrayList<User>();
	public static List<Ticketing> ticketingList = new ArrayList<Ticketing>();
	public static List<Team> teamList = new ArrayList<Team>();
	public static List<Schedule> scheduleList = new ArrayList<Schedule>();
	public static List<Predict> predictList = new ArrayList<Predict>();
	public static List<Post> postList = new ArrayList<Post>();
	public static List<Point> pointList = new ArrayList<Point>();
	public static List<Player> playerList = new ArrayList<Player>();
	public static List<MyTeam> myTeamList = new ArrayList<MyTeam>();
	public static List<Comment> commentList = new ArrayList<Comment>();
	public static List<BlackList> blackListList = new ArrayList<BlackList>();
	public static List<BannedWord> bannedWordList = new ArrayList<BannedWord>();
	public static List<YearTeam> yearTeamList = new ArrayList<YearTeam>();
	public static List<RelativeRecord> relativeRecordList = new ArrayList<RelativeRecord>();
	
	public static void load() {
		
		try {
			
			
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.USER));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				User u = new User(Integer.parseInt(temp[0])
								, temp[1]
								, temp[2]
								, temp[3]
								, temp[4]
								, temp[5]
								, Integer.parseInt(temp[6])
								, Integer.parseInt(temp[7]));
				userList.add(u);
				
			}
			
			reader.close();
			
			
			reader = new BufferedReader(new FileReader(DataPath.TICKETING));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				Ticketing t = new Ticketing(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]), temp[3], temp[4]);
				
				ticketingList.add(t);
				
			}
			
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.TEAM));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				Team t = new Team(Integer.parseInt(temp[0]),
									Integer.parseInt(temp[1]),
									temp[2],
									temp[3],
									Integer.parseInt(temp[4]),
									Integer.parseInt(temp[5]),
									temp[6]);
				
				teamList.add(t);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.SCHEDULE));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(temp[6].split("-")[0])
						, Integer.parseInt(temp[6].split("-")[1])-1
						, Integer.parseInt(temp[6].split("-")[2]));
				
				Schedule s = new Schedule(Integer.parseInt(temp[0])
										, temp[1]
										, temp[2]
										, temp[3]
										, temp[4]
										, temp[5]
										, c
										, temp[7]
										, temp[8]
										, Integer.parseInt(temp[9])
										, Integer.parseInt(temp[10]));
				
				scheduleList.add(s);
				
			}
			reader.close();
			
			
			reader = new BufferedReader(new FileReader(DataPath.PREDICT));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				Predict p = new Predict(Integer.parseInt(temp[0])
										, temp[1]
										, Integer.parseInt(temp[2])
										, temp[3]
										, temp[4]);
				predictList.add(p);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.POST));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(temp[1].split("-")[0])
										, Integer.parseInt(temp[1].split("-")[1])-1
										, Integer.parseInt(temp[1].split("-")[2]));
				Post p = new Post(Integer.parseInt(temp[0])
									, c
									, temp[2]
									, temp[3]
									, temp[4]
									, temp[5]
									, Integer.parseInt(temp[6]));
				postList.add(p);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.POINT));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				Calendar c = Calendar.getInstance();
				c.set(Integer.parseInt(temp[4].split("-")[0])
						, Integer.parseInt(temp[4].split("-")[1])-1
						, Integer.parseInt(temp[4].split("-")[2]));
				Point p = new Point(Integer.parseInt(temp[0])
									, temp[1]
									, temp[2]
									, temp[3]
									, c);
				
				pointList.add(p);
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.PLAYER));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				//타자
				if (temp[3].equals("타자")) {
					Player p = new Player(Integer.parseInt(temp[0])
										, Integer.parseInt(temp[1])
										, temp[2]
										, temp[3]
										, temp[4]
										, temp[5]
										, temp[6]
										, temp[7]
										, Double.parseDouble(temp[8])
										, Integer.parseInt(temp[9])
										, Integer.parseInt(temp[10])
										, Integer.parseInt(temp[11])
										, Integer.parseInt(temp[12]));
					playerList.add(p);
				//투수
				} else {
					Player p = new Player(Integer.parseInt(temp[0])
							, Integer.parseInt(temp[1])
							, temp[2]
							, temp[3]
							, temp[4]
							, temp[5]
							, temp[6]
							, temp[7]
							, Double.parseDouble(temp[8])
							, Integer.parseInt(temp[9])
							, Integer.parseInt(temp[10])
							, Integer.parseInt(temp[11]));
					playerList.add(p);
					
				}
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.MYTEAM));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				MyTeam m = new MyTeam(Integer.parseInt(temp[0])
									, temp[1]
									, Integer.parseInt(temp[2])
									, temp[3]
									, temp[4]);
				
				myTeamList.add(m);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.COMMENT));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				Calendar d = Calendar.getInstance();
				d.set(Integer.parseInt(temp[2].split("-")[0])
						, Integer.parseInt(temp[2].split("-")[1])-1
						, Integer.parseInt(temp[2].split("-")[2]));
				
				Comment c = new Comment(Integer.parseInt(temp[0])
									, Integer.parseInt(temp[1])
									, d
									, temp[3]
									, temp[4]);
				
				commentList.add(c);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.BLACKLIST));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				BlackList b = new BlackList(Integer.parseInt(temp[0])
											, temp[1]
											, temp[2]
											, Integer.parseInt(temp[3])
											, temp[4]);
				
				blackListList.add(b);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.BANNEDWORD));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				BannedWord b = new BannedWord(Integer.parseInt(temp[0]), temp[1]);
				
				bannedWordList.add(b);
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.YEARTEAM));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				
				YearTeam y = new YearTeam(Integer.parseInt(temp[0])
										, temp[1]
										, temp[2]
										, temp[3]);
				yearTeamList.add(y);
				
			}
			reader.close();
			
			reader = new BufferedReader(new FileReader(DataPath.RELATIVERECORD));
			
			line = null;
			
			while ((line = reader.readLine()) != null) {
				String[] temp = line.split("●");
				List<Record> record = new ArrayList<Record>();
				for (int i=1; i<temp.length; i++) {
					String[] a = temp[i].split(",");
					Record r = new Record(Integer.parseInt(a[0])
										, Integer.parseInt(a[1])
										, Integer.parseInt(a[2]));
					record.add(r);
				}
				RelativeRecord r = new RelativeRecord(Integer.parseInt(temp[0])
														, record);
				relativeRecordList.add(r);
				
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			System.out.println("Data.load");
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.USER));
			
			for (User s : userList) {
				
				String line = String.format("%d●%s●%s●%s●%s●%s●%d●%d\n"
											, s.getSeq()
											, s.getName()
											, s.getJumin()
											, s.getNumber()
											, s.getId()
											, s.getPassword()
											, s.getPoint()
											, s.getWarningCount());
				
				writer.write(line);
				
			}
			
			writer.close();
			
			writer = new BufferedWriter(new FileWriter(DataPath.TICKETING));
			
			for (Ticketing s : ticketingList) {
				
				String line = String.format("%d●%s●%d●%s●%s\n"
											, s.getSeq()
											, s.getId()
											, s.getScheduleSeq()
											, s.getBlock()
											, s.getSeatNum());
				
				writer.write(line);
				
			}
			
			writer.close();
			
			writer = new BufferedWriter(new FileWriter(DataPath.TEAM));
			
			for (Team s : teamList) {
				
				String line = String.format("%d●%d●%s●%s●%d●%d●%s\n"
											, s.getSeq()
											, s.getYear()
											, s.getType()
											, s.getTeamName()
											, s.getWin()
											, s.getLose()
											, s.getPlace());

				writer.write(line);
				
			}
			
			writer.close();
			
			writer = new BufferedWriter(new FileWriter(DataPath.SCHEDULE));
			
			for (Schedule s : scheduleList) {
				
				String line = String.format("%d●%s●%s●%s●%s●%s●%tF●%s●%s●%d●%d\n"
											, s.getSeq()
											, s.getTeam1()
											, s.getTeam2()
											, s.getStarting1()
											, s.getStarting2()
											, s.getPlace()
											, s.getDate()
											, s.getTime()
											, s.getWeather()
											, s.getTeam1Score()
											, s.getTeam2Score());

				writer.write(line);
				
			}
			writer.close();
			
			writer = new BufferedWriter(new FileWriter(DataPath.PREDICT));
			
			for (Predict s : predictList) {
				
				String line = String.format("%d●%s●%d●%s●%s\n"
											, s.getSeq()
											, s.getId()
											, s.getScheduleSeq()
											, s.getTeamName()
											, s.getResult());
			

				writer.write(line);
				
			}
			
			writer.close();
			
			
			writer = new BufferedWriter(new FileWriter(DataPath.POST));
			
			for (Post s : postList) {
				
				String line = String.format("%d●%tF●%s●%s●%s●%s●%d\n"
											, s.getSeq()
											, s.getDate()
											, s.getId()
											, s.getSubject()
											, s.getTitle()
											, s.getContent()
											, s.getView());
				writer.write(line);
				
			}
			
			writer.close();
			
			writer = new BufferedWriter(new FileWriter(DataPath.POINT));
			
			for (Point s : pointList) {
				
				String line = String.format("%d●%s●%s●%s●%tF\n"
											, s.getSeq()
											, s.getId()
											, s.getChangePoint()
											, s.getDetail()
											, s.getDate());
				writer.write(line);
				
			}
			
			writer.close();
			
			
			writer = new BufferedWriter(new FileWriter(DataPath.MYTEAM));
	           
	           for (MyTeam s : myTeamList) {
	              
	              //seq●아이디●Tseq●팀명●종목
	              String line = String.format("%d●%s●%s●%s●%s\n"
	                                   , s.getSeq()
	                                   , s.getId()
	                                   , s.getTeamSeq()
	                                   , s.getTeamName()
	                                   , s.getType());
	              writer.write(line);
	              
	           }
	           
	           writer.close();
	           
	           writer = new BufferedWriter(new FileWriter(DataPath.BANNEDWORD));
	           
	           for(BannedWord b : bannedWordList) {
	              String line = String.format("%d●%s\n"
	                                   ,b.getSeq()
	                                   ,b.getBannedWord());
	              writer.write(line);
	           }
	           
	           writer.close();
	           
	           writer = new BufferedWriter(new FileWriter(DataPath.BLACKLIST));
	           
	           for(BlackList b : blackListList) {
	              String line = String.format("%d●%s●%s●%d●%s\n"
	                                   , b.getSeq()
	                                   , b.getName()
	                                   , b.getId()
	                                   , b.getWarningCount()
	                                   , b.getDetail());
	              writer.write(line);
	           }
	           writer.close();
	           
	           writer = new BufferedWriter(new FileWriter(DataPath.COMMENT));
	           
	           for(Comment b : commentList) {
	              String line = String.format("%d●%d●%tF●%s●%s\n"
	                                   , b.getSeq()
	                                   , b.getPostSeq()
	                                   , b.getDate()
	                                   , b.getId()
	                                   , b.getContent());
	              writer.write(line);
	           }
	           writer.close();
	           
	           writer = new BufferedWriter(new FileWriter(DataPath.PLAYER));
	           
	           for(Player p : playerList) {
	              
	              if(p.getPosition().equals("타자")) {
	                 
	                 String line = String.format("%d●%d●%s●%s●%s●%s●%s●%s●%.2f●%d●%d●%d●%d\n"
	                                      , p.getSeq()
	                                      , p.getTeamSeq()
	                                      , p.getYear()
	                                      , p.getPosition()
	                                      , p.getPlayerNum()
	                                      , p.getName()
	                                      , p.getHeight()
	                                      , p.getWeight()
	                                      , p.getBattingAvg()
	                                      , p.getHomeRun()
	                                      , p.getHit()
	                                      , p.getHitScore()
	                                      , p.getMakeScore());
	                 writer.write(line);
	                 
	              } else {
	                 String line = String.format("%d●%d●%s●%s●%s●%s●%s●%s●%.2f●%d●%d●%d\n"
	                                      , p.getSeq()
	                                      , p.getTeamSeq()
	                                      , p.getYear()
	                                      , p.getPosition()
	                                      , p.getPlayerNum()
	                                      , p.getName()
	                                      , p.getHeight()
	                                      , p.getWeight()
	                                      , p.getEarnedRunAvg()
	                                      , p.getWin()
	                                      , p.getInning()
	                                      , p.getThreeOut());
	                 writer.write(line);
	              }
	           }
	           writer.close();
	           
	           writer = new BufferedWriter(new FileWriter(DataPath.YEARTEAM));
	           
	           for (YearTeam s : yearTeamList) {
	              String line = String.format("%d●%s●%s●%s\n"
	            		  								, s.getSeq()
	            		  								, s.getType()
	            		  								, s.getTeamName()
	            		  								, s.getStarting());
	              writer.write(line);
	           }
	           writer.close();
	           
	           writer = new BufferedWriter(new FileWriter(DataPath.RELATIVERECORD));
	           
	           for (RelativeRecord s : relativeRecordList) {
	        	   
	        	   StringBuilder builder = new StringBuilder();
	        	   
	        	   //첫번째 팀 고유번호
	        	   builder.append(String.format("%d", s.getSeq()));
	        	   
	        	   //2~size번째 팀 상대 전적
	        	   for (int i=0; i<s.getList().size(); i++) {
	        		   String line = String.format("●%d,%d,%d"
	        				   , s.getList().get(i).getTeamSeq()
	        				   , s.getList().get(i).getWin()
	        				   , s.getList().get(i).getLose());	  
	        		   builder.append(line);
	        	   }
	        	   builder.append("\n");
	        	   
	          
	              writer.write(builder.toString());
	           }
	           writer.close();
			
	           
		} catch (Exception e) {
			System.out.println("Data.save");
			e.printStackTrace();
		}
		
	}

}
