# 종합 스포츠 플랫폼 :basketball::soccer::baseball:
#### Project topic : 파일 입출력 기반의 데이터 처리 JAVA 콘솔 프로젝트
#### Project execution period : 2022-04-06~2022-04-18
-----------------------
### 1. 개발 환경
<img src="https://img.shields.io/badge/Windows10-0078D6?style=flat&logo=Windows&logoColor=white"/><img src="https://img.shields.io/badge/JAVA-007396?style=flat&logo=Java&logoColor=white"/><img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat&logo=Eclipse&logoColor=white"/>

-	Platform : Window10
-	Language : Java(JDK11)
-	IDE : Eclipse
-----------------------
### 2. 기능 요약
-	기존 스포츠 페이지의 기술(일정, 순위, 정보, 커뮤니티)에 타 사이트 페이지의 기술(예매)를 추가하였다.
-----------------------
### 3. 핵심 기술
#### - BufferedReader/BufferedWriter
- load() 메소드란 데이터 파일의 Class를 만들어 BufferedReader로 프로그램이 시작될 때 데이터파일을 읽어와 List<Class>에 각 데이터를 저장하는 메소드이다.
- load()메소드를 만든 이유
  
  1.	BufferedReader는 일회성이기 때문에 한번 사용 후 재작성을 해야하므로 코드의 중복이 발생한다. 이때 load() 메소드를 만들어 사용하면 데이터를 읽어올 때마다 BufferedReader를 사용하지 않고 필요한 정보를 List에서 가져올 수 있다.
  
  2.	load() 메소드를 사용하면 코드가 단축되어 개발자가 편리하고 프로그램의 성능이 향상된다.

#### - ArrayList 사용 이유
- 데이터를 읽어올 때 순차적으로 접근한다. 
-	데이터의 추가/수정/삭제가 발생하므로 가변형 배열이 필요했다.

-----------------------
### 4.	핵심 기술이 들어간 구동화면
-	관리자 – 팀/선수 정보 추가/수정/삭제
  
![2](https://user-images.githubusercontent.com/97499271/165006185-43ee3246-0473-4dd2-917f-5ba5d6013f79.png)

-----------------------
### 5. feedback
- 전체적인 프로그램의 흐름을 반영한 순서도에 아쉬운 부분들이 존재하였으며, 조금 더 효율적인 로직을 짰다면 화면 이동과 출력이 자연스러웠을 것 같다.

-	데이터 설계 당시 순서도를 보며 각 기능에 필요한 데이터를 작성하였지만 코드를 작성하면서 데이터의 구조 및 형식에 부족한 부분을 발견하여 데이터를 계속 수정하게되었다. 이를 통해 데이터 초기 설계의 중요성을 알게되었다.

-	save()메소드는 프로그램 종료 시 List에 있는 항목을 데이터 파일에 저장하는 메소드로 이번 프로젝트에서 사용하였다. 개발자의 편의를 위해 save() 메소드를 사용하였으나 데이터 저장의 안정성을 위해 작업(데이터의 추가/수정/삭제)를 할때마다 BufferedWriter을 작성하는 것이 더 좋아보인다.

-	경기관련 데이터가 실시간 반영이 되었어야했지만 자바만으로는 구현이 힘들어 랜덤으로 데이터를 생성해서 받아오는 식으로 하였다. 다른 기술과 접목하여 사용하면 더 좋은 프로그램이 될 것 같다.
  
-----------------------
### 6. 담당 업무

|팀원|담당업무|
|------|-------------|
|강지윤|[메인] 팀/선수 정보 구현</br>[관리자] 로그인, 예매 관리, 커뮤니티 관리 구현|
|김유정|[메인] 경기 일정 구현|
|김영석|[메인] 커뮤니티 구현</br>[관리자] 커뮤니티 구현|
|김찬진|[메인] 마이페이지, 경기 일정 기능 구현, 예매하기, 커뮤니티 구현</br>[관리자] 경기 관리 구현|
|서주예|[메인] 회원가입, 아이디/비밀번호 찾기, 승부 예측 구현</br>[관리자] 팀/선수 정보 관리 구현|
|안수아|[메인] 순위 구현, 커뮤니티 구현</br>[관리자] 회원 관리 구현|
 

 
