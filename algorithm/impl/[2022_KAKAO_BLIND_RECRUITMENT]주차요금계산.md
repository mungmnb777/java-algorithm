# [[๋ฌธ์ ]](https://programmers.co.kr/learn/courses/30/lessons/92341)

## ๐ฉ ์ฃผ์ ํค์๋

---

-   ๊ตฌํ ๋ฌธ์ 

## ๐ ํ์ด

---

Map์ ์ฌ์ฉํด์ record์ ๋ํ ์ ๋ณด๋ฅผ ์ ์ฅํ๋ค.

-   ์ค๋ ์ถ์ฐจํ์ง ์์ ์ฐจ๋ ์๊ฐ ์ ์ฐ ๋ก์ง

```java
Set<String> inCarNumber = inMinuteMap.keySet();

for (String carNumber : inCarNumber) {
    if (!parkingMinuteMap.containsKey(carNumber)) {
        parkingMinuteMap.put(carNumber, parseMinute("23:59") - inMinuteMap.get(carNumber));
    } else {
        parkingMinuteMap.put(carNumber, parkingMinuteMap.get(carNumber) + parseMinute("23:59") - inMinuteMap.get(carNumber));
    }
}
```

์ถ์ฐจ๋ฅผ ํ๊ฒ ๋๋ฉด `inMinuteMap`์์ ์ฐจ๋ ์ ๋ณด๊ฐ ์ ๊ฑฐ๋๋๋ก ๊ตฌํํ๊ธฐ ๋๋ฌธ์ Map์ key๊ฐ ์๋ค๋ฉด ์ค๋ ์ถ์ฐจํ์ง ์์๋ค๋ ๋ป์ด๋ค. ์ด๋ฌํ ์ฐจ๋์ ๋ํ ์๊ฐ์ ์ ์ฐํ๋ ๋ก์ง์ด๋ค.

-   ์ฃผ์ฐจ ๋น์ฉ ์ ์ฐ ๋ก์ง

```java
// ์ ์ฐํ๊ธฐ
for (String car : parkingCarNumber) {
    int parkingMinute = parkingMinuteMap.get(car);

    // ์ฃผ์ฐจ ์๊ฐ์ด ๊ธฐ๋ณธ ์๊ฐ ์ดํ๋ผ๋ฉด
    if (parkingMinute <= fees[0]) {
        answer.add(fees[1]);
    }
    // ๊ทธ๋ ์ง ์์ผ๋ฉด
    else {
        // ๊ธฐ๋ณธ ์๊ฐ๋งํผ ๋บ ๊ฐ์์ ๋จ์ ์๊ฐ ๋น ๊ธ์ก์ ๊ณ์ฐํด์ผํจ
        int unitMinute;

        if ((parkingMinute - fees[0]) % fees[2] == 0) {
            unitMinute = (parkingMinute - fees[0]) / fees[2];
        } else {
            unitMinute = (parkingMinute - fees[0]) / fees[2] + 1;
        }

        // ๊ธฐ๋ณธ ์๊ธ์ ๋จ์ ์๊ฐ ๋น ์๊ธ ์ถ๊ฐ
        answer.add(unitMinute * fees[3] + fees[1]);
    }
}
```

์ฃผ์ฐจ ๋น์ฉ์ ์ ์ฐํ๋ ๋ก์ง์ด๋ค. ๋ฌธ์  ์กฐ๊ฑด์ ๋ง์ถฐ ๊ตฌํํ๋ค.

## ํ๊ธฐ

---

ํด๋์ค๋ ๊ฐ์ด ์ฌ์ฉํด์ ๊ตฌํํ์ผ๋ฉด ๋์ฑ ์ฝ๊ฒ ํ ์ ์์ง ์์์๊น...

# [[์ ์ฒด ์ฝ๋]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_์ฃผ์ฐจ์๊ธ๊ณ์ฐ.java)
