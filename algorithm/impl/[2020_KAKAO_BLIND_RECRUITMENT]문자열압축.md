# [[๋ฌธ์ ]](https://programmers.co.kr/learn/courses/30/lessons/60057)

## ๐ฉ ์ฃผ์ ํค์๋

---

-   ์์ถ ์๊ณ ๋ฆฌ์ฆ์ ๊ตฌํํด์ผ ํ๋ค.

```java
private static String pressure(List<String> list) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        String prev = "";
        for (String cur : list) {
            // ํ์ฌ ์คํธ๋ง์ด ์ด์  ์คํธ๋ง๊ณผ ๊ฐ๋ค๋ฉด
            if (cur.equals(prev)) {
                count++;
            } else {
                if (count == 0 || count == 1) sb.append(prev);
                else sb.append(count + prev);

                count = 1;
            }
            prev = cur;
        }
        if (count == 0 || count == 1) sb.append(prev);
        else sb.append(count + prev);

        String temp = sb.toString();
        return temp;
    }
```

## ๐ ํ์ด

---

-   ์๋ ฅ์ผ๋ก ๋ฐ์ ๋ฌธ์์ด์ substring์ผ๋ก ๋๋๋ค. ์ด ๋ substring์ ๊ธธ์ด๋ 1๋ถํฐ ์์ํด์ 1์ฉ ์ฆ๊ฐํ๋ค. ์ด substring์ ๋ฆฌ์คํธ์ ๋ฃ์ด๋๋ค.
-   ์์ถ ์๊ณ ๋ฆฌ์ฆ์ ๊ตฌํํด์ list์ ์ ๋ณด๋ฅผ ์ด์ฉํด์ ๋ฌธ์์ด์ ์์ถํ๊ณ , ๊ทธ ์์ถํ ๋ฌธ์์ด์ ๋ฆฌํดํ๋ค.
-   ๋ฆฌํดํ ๋ฌธ์์ด์ ๊ธธ์ด๋ฅผ ์ฒดํฌํ๋ค.

## ํ๊ธฐ

---

์์ถํ๋ ์๊ณ ๋ฆฌ์ฆ์ ์์  ํ๋์ฝ๋ฉํด์ ๊ตฌํํ๋ค... ์กฐ๊ธ ๋ ์ข์ ๋ฐฉ๋ฒ์ด ์์์ ๊ฒ ๊ฐ์๋ฐ ์์ด๋์ด๊ฐ ๋ ์ค๋ฅด์ง ์์,,

# [[์ ์ฒด ์ฝ๋]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_๋ฌธ์์ด์์ถ.java)
