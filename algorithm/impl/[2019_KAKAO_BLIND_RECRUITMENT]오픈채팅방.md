# [[๋ฌธ์ ]](https://programmers.co.kr/learn/courses/30/lessons/42888)

## ๐ฉ ์ฃผ์ ํค์๋

-   ํด๋์ค๋ฅผ Log์ User๋ก ๋๋๊ณ  Map์ DB์ฒ๋ผ ์ฌ์ฉํด์ ํ์์
-   ๋ก๊ทธ ํด๋์ค์๋ User ๊ฐ์ฒด๊ฐ ์ ์ฅ๋จ
-   Map์ ์ด์ฉํด์ ๊ฐ์ ์์ด๋์ ๊ฐ์ฒด๋ฅผ ์ดํ๋ฆฌ์ผ์ด์ ๊ณ์ธต์์ ํ๋๋ง ์ ์ง์ํค๋๋ก ๋ง๋ฆ

## ๐ ํ์ด

-   Log ํด๋์ค. toString์ ๋ฐ๋ก ๊ตฌํํด๋ฌ์ ๋ง์ง๋ง์ ๊ฒฐ๊ณผ๊ฐ์ผ๋ก ๋ก๊ทธ ์ ์ฒด๋ฅผ ๋ฐํํ  ๋ stream์ ์ด์ฉํด์ ํธํ๊ฒ ๋ฆฌํดํ๋๋ก ๊ตฌํ

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
            return user.name + "๋์ด ๋ค์ด์์ต๋๋ค.";
        } else if (action.equals("Leave")) {
            return user.name + "๋์ด ๋๊ฐ์ต๋๋ค.";
        }

        return "error";
    }
}
```

-   ์ฃผ์ ์๊ณ ๋ฆฌ์ฆ (์ฃผ์์ ์ค๋ช ๋ฌ์๋์)

```java
 for (String s : record) {
    // 0 : action, 1 : userID, 2: username
    String[] r = s.split(" ");

    // ๋ง์ฝ user DB์ ์์ด๋๊ฐ ์๋ค๋ฉด db์ ๋ฃ๋๋ค.
    if (!userdb.containsKey(r[1])) userdb.put(r[1], new User(r[1], r[2]));

    // action์ด Leave์ผ ๋๋ฅผ ์ ์ธํ๊ณ ๋ ์ด๋ฆ์ ๋ฐ๊ฟ์ค
    if (!r[0].equals("Leave")) userdb.get(r[1]).name = r[2];

    // action์ด Change์ผ ๋๋ฅผ ์ ์ธํ๊ณ  Log ๋ฆฌ์คํธ์ ๋ฃ์ด์ฃผ๊ธฐ
    if (!r[0].equals("Change")) {
        logList.add(new Log(r[0], userdb.get(r[1])));
    }
}
```

## ํ๊ธฐ

์ด ๋ฌธ์ ๋ ํฌ๊ฒ ์ด๋ ต์ง ์์๋ ๊ฒ ๊ฐ๋ค

# [[์ ์ฒด ์ฝ๋]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_์คํ์ฑํ๋ฐฉ.java)
