# 종합 스포츠 플랫폼
#### Project topic : 파일 입출력 기반의 데이터 처리 JAVA 콘솔 프로젝트
#### Project execution period : 2022-04-06~2022-04-18
-----------------------
### 1. 개발 환경
-	Platform : Window10
-	Language : Java(JDK1.11),
-	IDE : Eclipse
### 2. 기능 요약
-	기존 스포츠 페이지의 기술(일정, 순위, 정보, 커뮤니티)에 타 사이트 페이지의 기술(예매)를 추가하였다.
### 3. 핵심 기술
#### BufferedReader/BufferedWriter
- load() 메소드란 데이터 파일의 Class를 만들어 BufferedReader로 프로그램이 시작될 때 데이터파일을 읽어와 List<Class>에 각 데이터를 저장하는 메소드이다.
- load()메소드를 만든 이유
  I.	BufferedReader는 일회성이기 때문에 한번 사용 후 재작성을 해야하므로 코드의 중복이 발생한다. 이때 load() 메소드를 만들어 사용하면 데이터를 읽어올 때마다 BufferedReader를 사용하지 않고 필요한 정보를 List에서 가져올 수 있다.
