# [[๋ฌธ์ ]](https://programmers.co.kr/learn/courses/30/lessons/42889)

## ๐ฉ ์ฃผ์ ํค์๋

-   Stage ํด๋์ค๋ฅผ ๋ง๋ค์ด์ ๊ตฌํํ์๋ค.
-   Comparable์ ์ด์ฉํด ์คํจ์จ์ ๋ฐ๋ผ ๋ด๋ฆผ์ฐจ์ํ๊ณ , ์คํจ์จ์ด ๊ฐ๋ค๋ฉด ์คํ์ด์ง ์์ผ๋ก ์ค๋ฆ์ฐจ์ํ๋ค.

```java
public int compareTo(Stage o) {
    int result = Float.compare(o.getFailureRate(), getFailureRate());
    return result == 0 ? num - o.num : result;
}
```

-   Stage ํด๋์ค์ ๋ฐฐ์ด์ ๋ง๋ค์ด์ ๋ชจ๋  ์คํ์ด์ง์ ๋ํ ์ ๋ณด๋ฅผ ๋ด์๋๋๋ฐ, ์ธ๋ฑ์ค๊ฐ 0์ผ ๋์ N + 1์ผ ๊ฒฝ์ฐ๋ฅผ ๊ด๋ฆฌํด์ฃผ์ด์ผ ํ๋ค.

```java
for (int i = 0; i < N + 2; i++) {
    if (array[i].num == 0 || array[i].num == N + 1) continue;
    list.add(array[i].num);
}
```

-   arrivalCount๊ฐ 0์ผ ๊ฒฝ์ฐ์๋ ์คํจ์จ์ 0์ผ๋ก ๋ง๋ค์ด์ค๋ค.

```java
private float getFailureRate() {
    if (arrivalCount == 0) return 0;
    return (float) failureCount / arrivalCount;
}
```

## ๐ ํ์ด

-   Stage ํด๋์ค์ ๋ฐฐ์ด์ ์ด N+2 ๊ธธ์ด๋งํผ ๋ง๋ ๋ค.
-   ํ๋ผ๋ฏธํฐ๋ก ๋ฐ์ stage๊ฐ๋ณด๋ค ์๊ฑฐ๋ ๊ฐ์ ์ธ๋ฑ์ค๋ arrivalCount๋ฅผ 1 ๋๋ ค์ค๋ค.
-   failureCount๋ stage๊ฐ๊ณผ ๊ฐ์ ์ธ๋ฑ์ค๋ง ๋๋ ค์ค๋ค.
-   ๊ทธ ํ `Arrays.sort()`๋ฅผ ์ด์ฉํ๋ฉด ์คํจ์จ์ ๋ฐ๋ผ ์ ๋ ฌ์ด ๋๋ค.
-   ๊ทธ๋ฆฌ๊ณ  answer์ ๋์ํ๋ฉด ๋๋๋ฐ, ์ด ๋ num์ด 0์ผ ๊ฒฝ์ฐ์ N+1์ผ ๊ฒฝ์ฐ๋ ์ ์ธํ๋ค. (0์ padding๊ฐ์ด๊ณ , n+1์ ์ค์  ์กด์ฌํ๋ ์คํ์ด์ง๊ฐ ์๋๋ค.)

## ํ๊ธฐ

์ค์๊ฐ ๋ง์์ ๋๋ฒ๊น์ ๋ง์ด ํ์ด์ผ ํ๋ค. ๋๋ฌด ์์ฌ์ด ๋ฌธ์ ์๋ค. ใ 

# [[์ ์ฒด ์ฝ๋]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_์คํจ์จ.java)
