# [[๋ฌธ์ ]](https://programmers.co.kr/learn/courses/30/lessons/17687)

## ๐ฉ ์ฃผ์ ํค์๋

-   ์ด์ง์๋ก ๋ฐ๊พธ๋ ๋ฉ์๋๋ง ๋ง๋ค๋ฉด ๋๋ค.

```java
private String getNumberFormat(int n, int num) {
    StringBuilder sb = new StringBuilder();

    if (num == 0) {
        return "0";
    }

    while (num != 0) {
        int mod = num % n;

        if (mod >= 10) {
            sb.append((char) ('A' + mod - 10));
        } else {
            sb.append(num % n);
        }

        num /= n;
    }

    return sb.reverse().toString();
}
```

## ๐ ํ์ด

`getNumberFormat()` ๋ฉ์๋๋ฅผ ํตํด ๋ฐ๊พผ ๋ฌธ์์ด์ ํ๋ธ์ ์์๊ฐ ์ค๋ฉด `charAt()`์ผ๋ก ๊ฐ์ ธ๊ฐ๊ณ  StringBuilder์ ์ํ๋ ๊ฐฏ์๋งํผ ์ป๊ฒ๋๋ฉด ๋ฐ๋ณต๋ฌธ์ ํ์ถํ์ฌ ๊ฐ์ ๋ฆฌํดํ๋ค.

## ํ๊ธฐ

์ด๋ ต์ง ์์๋ ๊ฒ ๊ฐ๋ค.

# [[์ฝ๋]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_n์ง์๊ฒ์.java)
