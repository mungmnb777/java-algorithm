# [[문제]](https://programmers.co.kr/learn/courses/30/lessons/42888)

## 🚩 주요 키워드

-   클래스를 Log와 User로 나누고 Map을 DB처럼 사용해서 풀었음
-   로그 클래스에는 User 객체가 저장됨
-   Map을 이용해서 같은 아이디의 객체를 어플리케이션 계층에서 하나만 유지시키도록 만듦

## 🔑 풀이

-   Log 클래스. toString을 따로 구현해둬서 마지막에 결과값으로 로그 전체를 반환할 때 stream을 이용해서 편하게 리턴하도록 구현

```java
static class Log {
    String action;
    User user;

    public Log(String action, User user) {
        this.action = action;
        this.user = user;
    }

    @Override
    public String toString() {
        if (action.equals("Enter")) {
            return user.name + "님이 들어왔습니다.";
        } else if (action.equals("Leave")) {
            return user.name + "님이 나갔습니다.";
        }

        return "error";
    }
}
```

-   주요 알고리즘 (주석에 설명 달아놓음)

```java
 for (String s : record) {
    // 0 : action, 1 : userID, 2: username
    String[] r = s.split(" ");

    // 만약 user DB에 아이디가 없다면 db에 넣는다.
    if (!userdb.containsKey(r[1])) userdb.put(r[1], new User(r[1], r[2]));

    // action이 Leave일 때를 제외하고는 이름을 바꿔줌
    if (!r[0].equals("Leave")) userdb.get(r[1]).name = r[2];

    // action이 Change일 때를 제외하고 Log 리스트에 넣어주기
    if (!r[0].equals("Change")) {
        logList.add(new Log(r[0], userdb.get(r[1])));
    }
}
```

## 후기

이 문제는 크게 어렵지 않았던 것 같다

# [[전체 코드]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_오픈채팅방.java)
