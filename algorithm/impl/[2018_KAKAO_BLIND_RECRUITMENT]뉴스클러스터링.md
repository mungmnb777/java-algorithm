# [[λ¬Έμ ]](https://programmers.co.kr/learn/courses/30/lessons/17677)

## π© μ£Όμ ν€μλ

- μλ° Collection APIμ String APIλ₯Ό νμ©ν΄μ λ¨μνκ² κ΅¬ννμμ
- μ£Όμ λ©μλ
    - λ¬Έμμ΄μ κΈΈμ΄ 2μΈ λ¬Έμλ‘ λλκΈ° μν `addSet()` λ©μλ
        
        ```java
        private static void addSet(String str, List<String> set) {
          int length = str.length() - 1;
        
          for (int i = 0; i < length; i++) {
              // λ λ€ μνλ²³μΈ κ²½μ°μλ§ μ€ν
              if (isAlphabet(str.charAt(i)) && isAlphabet(str.charAt(i + 1))) {
                  // κΈΈμ΄ 2μ λ¬Έμμ΄λ‘ λλμ΄μ μ§ν©μ μ μ₯
                  String s = "" + str.charAt(i) + str.charAt(i + 1);
                  set.add(s);
              }
          }
        }
        ```
        
    - κ΅μ§ν©
        
        ```java
        // stringSet2μ λ¬Έμμ΄μ stringSet1κ³Ό λΉκ΅
        for (int i = 0; i < stringSet2.size(); i++) {
            String cur = stringSet2.get(i);
            // λ§μ½ cur λ¬Έμμ΄μ΄ stringSet1μ μμΌλ©΄
            if (stringSet1.contains(cur)) {
                stringSet1.remove(cur);
                intersect.add(cur);
            }
        }
        ```
        

## π νμ΄

1. λμλ¬Έμλ₯Ό κ΅¬λ³νμ§ μλλ€κ³  νμΌλ―λ‘ μ λΆ μλ¬Έμλ‘ ν΅μΌ

```java
// λμλ¬Έμ κ΅¬λΆμ νμ§ μμΌλ―λ‘ μλ¬Έμλ‘ ν΅μΌνλ€.
str1 = str1.toLowerCase();
str2 = str2.toLowerCase();
```

1. ν° λ¬Έμμ΄μ κΈΈμ΄ λ κΈμμ© λλμ΄ μ μ₯ν λ¦¬μ€νΈ 2κ°

```java
// 2κΈμμ© λλ λ¬Έμμ΄μ μ μ₯ν  List Collection
List<String> stringSet1 = new ArrayList<>();
List<String> stringSet2 = new ArrayList<>();
// λ¬Έμμ΄μ 2κΈμμ© λλλ λ©μλ
addSet(str1, stringSet1);
addSet(str2, stringSet2);
```

1. ν©μ§ν© λ° κ΅μ§ν©

```java
// ν©μ§ν©μ΄ λ€μ΄κ° λ¦¬μ€νΈ
List<String> union = new ArrayList<>();
// λ¦¬μ€νΈμ μλ λ¬Έμμ΄ μ λΆ μ μ₯
union.addAll(stringSet1);
union.addAll(stringSet2);

// κ΅μ§ν©μ΄ λ€μ΄κ° λ¦¬μ€νΈ 
List<String> intersect = new ArrayList<>();

// stringSet2μ λ¬Έμμ΄μ stringSet1κ³Ό λΉκ΅
for (int i = 0; i < stringSet2.size(); i++) {
    String cur = stringSet2.get(i);
    // λ§μ½ cur λ¬Έμμ΄μ΄ stringSet1μ μμΌλ©΄
    if (stringSet1.contains(cur)) {
        stringSet1.remove(cur);
        intersect.add(cur);
    }
}

// μ μ²΄ μ§ν©κ³Ό κ΅μ§ν©μ λΉΌλ©΄ ν©μ§ν©.
for (String s : intersect) {
    union.remove(s);
}
```

β μ¬μ€ κ΅μ§ν© κ΅¬νλ λ©μλλ λ μ¬μ΄ λ°©λ²μ΄ μμ κ² κ°μλ° μ’μ²λΌ μκ°μ΄ λμ§ μμ κ°μ₯ μ§κ΄μ μΈ λ°©λ²μΌλ‘ νλ€ (κ²ΉμΉλ λ¬Έμμ΄μ΄ μμΌλ©΄ λ¦¬μ€νΈμμ μμ μ£Όκ³  κ΅μ§ν©μ λ£μ΄μ£ΌκΈ°)

# [[μ½λ]](https://github.com/mungmnb777/java-algorithm/tree/main/code/programmers/Solution_λ΄μ€ν΄λ¬μ€ν°λ§.java)