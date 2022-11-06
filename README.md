# 스프링 복습

## 11.06 오브젝트와 의존관계

### 1. 복습 범위
1. 관심사의 분리
2. 커넥션 만들기의 추출 : 중복 코드의 메소드 추출, 추상 클래스와 상속을 통한 독립 및 확장
3. 클래스의 분리
4. DAO의 확장 
  - 인터페이스의 도입
  - 관계 설정 책임의 분리

### 2. 다시 이해한 부분
1. JDBC를 이용하는 작업의 일반적 순서 = 템플릿 메소드 패턴
    - DB 연결을 위한 커넥션 가져오기
    - SQL Statement 만들기
    - Statement 실행
    - 반환
      - 조회: 쿼리 실행 결과를 ResultSet에 받아 정보를 저장할 오브젝트(User)에 옮김
      - 작업 중 생성된 리소스는 작업을 마친 후 꼭 닫아주기
    - 예외처리
2. 자바빈 규약
3. 관심사의 분리
   - 메소드 하나에서 서로 다른 관심사를 다른 메소드/클래스로 분리하는 것
   - 이유: 코드의 중복 방지. 변화에 유연한 코드 만들기
   - 여기에서는 DB 커넥션을 분리해 줌
4. DAO의 확장
   - 클래스의 분리에도 자유로운 확장이 가능하게 하려면, 인터페이스를 통해 추상화를 거쳐야 함
   - UserDao는 Connection 오브젝트가 만들어지는 방법, 내부 동작 방식에 상관없이 필요한 기능을 Connection 인터페이스를 통해 사용하기만 하면 된다.
   - 관계 설정 책임의 분리 : 서비스 - 클라이언트 오브젝트. UserDao가 어떤 구현체를 사용할 지 결정하게 하는 것
     - 불필요한 의존관계를 없애야 한다.
     - 여기에서 UserDao의 모든 코드는 ConnectionMakr 인터페이스 외에는 어떤 클래스와도 관계를 가져서는 안 되게 해야 한다.


### 느낀 점, 모르겠는 것
관계설정 책임의 분리 부분이 잘 이해가 안간다. 서비스 - 클라이언트 관계가 잘 와닿지 않는 듯
