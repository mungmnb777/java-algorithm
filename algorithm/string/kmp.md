# KMP 알고리즘

# 0. 개요

싸피에서 3주 동안 진행된 알고리즘 커리큘럼의 마지막 시간,,, 문자열 패턴 매칭 알고리즘에 대해 배웠다. 라빈-카프 알고리즘, 보이어-무어 알고리즘, KMP 알고리즘으로 총 3개를 배웠는데 그 중 KMP 알고리즘이 가장 어려웠고 이해가 잘 되지 않는 부분이 있어서 글로써 한 번 정리해보고자 한다!!

# 1. Knuth-Morris-Pratt Algorithm

- 우리는 불일치가 발생한 문자열의 앞 부분에 어떤 문자가 있는지를 미리 알고 있다. 그래서 검색하고자 하는 패턴을 전처리하여 부분일치 테이블 배열 pi[k]을 구해서 잘못된 시작을 최소화하고자 하는 것이 목적이다
- 부분 일치 테이블은 접두사이면서 접미사인 최대 문자열의 길이가 얼마나 되는지 패턴의 길이마다 저장해놓은 테이블이다.

# 2. 부분 일치 테이블

```java
pi[] : 부분 일치 테이블
pattern[] : 문자열 패턴
patternLength : pattern의 길이
header: 접두사 포인터 (초기값 0)
footer: 접미사 포인터 (초기값 1)

for footer from 1 to patternLength
	while header > 0 && pattern[header] != pattern[footer]
		header = pi[header - 1]
	end while

	if (pattern[header] == pattern[footer])
		pi[footer] = ++header;
	else
		pi[footer] = 0;
	end if
end for
```

여기서 나는 while 부분을 이해하는데 정말 오랜 시간이 걸렸다. 이거를 이해해보려고 그림을 몇 번 그렸는지 모르겠다,,, 우선 while문의 조건이 들어있는 부분을 해석해보자.

- `footer > 0`
    
    header의 초기값은 0이다. 이러한 header가 0보다 큰 시점이 언제일까? 밑에 조건문을 보면 header가 가리키는 문자와 footer가 가리키는 문자가 같을 때 footer는 비로소 1 증가하게 된다.
    
    결국 이 조건의 뜻은 현재 header와 footer가 바라보고 있는 지점의 직전에는 점두사와 접미사가 같은 부분이 있었다는 뜻이 된다.
    
- `pattern[header] != pattern[footer]`
    
    이 조건은 말 그대로 현재 header와 footer가 바라보고 있는 지점의 문자가 서로 다르다는 뜻이다. 결국 이때의 접두사와 접미사는 다르므로 header를 처리해줘야 하는데 그 방법은 바로
    
- `header = pi[header - 1]`
    
    이거다. 그런데 이 부분은 내가 느끼기로는 뭔가 이상하다. 분명 배울 때는 header는 패턴에서 접두사를 가리키는 **포인터**고 pi[]는 접두사와 접미사가 일치하는 문자열의 **최대 길이**인데 왜 포인터에다가 길이에 관한 정보를 대입하는 걸까??
    
    우선 그 의미를 해석하기 전에 이 코드가 도대체 어떤 기능을 해주는지 한번 확인해보자.
    

![패턴 문자열 1](kmp/image/kmp1.png)

여기 문자열 패턴과 각각의 인덱스에 해당하는 부분 일치 테이블이 있다. 이때 header는 5번 인덱스를, footer는 11번 인덱스를 가리키는 시점을 한번 보자.

이 시점에는 while문에 들어가는 두 가지 조건을 다 만족하므로 `header = pi[header - 1]` 을 실행하게 된다.

그럼 현재 pi[4]는 1이므로 header가 1번 인덱스로 옮겨가게 된다. 

![패턴 문자열 2](kmp/image/kmp2.png)

그런데 이 때 header와 footer를 다시 비교해보니 둘 다 ‘a’로 문자가 같다. 그래서 pi[11]은 header에 1을 더한 값인 2가 된다.

이렇게 보니 왜 이 코드가 필요한 지에 대해서는 알게 되었다. header와 footer가 가리키는 문자가 다르더라도 **실제 세계**에서는 접두사와 접미사의 길이가 줄어들기만 하고 일치하는 경우가 있을 수 있기 때문이었다.

그렇다면 다시 돌아와서 왜 header에 pi[]라는 의미가 다른 값을 대입하는 걸까?
우선 실제 세계에서 현재 우리가 코드에서 사용하는 변수들을 해석해보면 header는 실제 세계에서 접두사 그 자체이다.
그렇다면 footer는 뭘까? 처음에는 단순하게 접미사라고 생각했다. 그런데 곰곰이 생각해보니 footer는 단순한 인덱스 값인데 이것만으로는 접미사 정보를 도출해낼 수가 없었다. 결국 footer는 패턴 문자열에서 0부터 footer 인덱스까지의 문자열을 추출한 substring이라는 것을 알 수 있었다. 위의 사진으로 예를 들면 패턴에서 뒤에 bc를 제외한 `babcbcbabcba`가 footer가 지니고 있는 실제 세계의 정보인 것이다.
pi[]는 내가 해석하기에는 footer가 가지고 있는 substring에서 접두사와 접미사가 같은 길이가 최대인 문자열에 대한 정보가 들어있다고 생각한다. 이것도 위의 사진으로 예를 들면 `babcbcbabcba`라는 substring에서 pi[]는 실제 세계에서 `ba`인 것이다. 결국 pi[]가 접미사에 대한 정보를 가지고 있다는 것이다.

자 그러면 새로운 사진과 함께 다시 pi[header - 1]에 대해서 생각해보자.

![패턴 문자열 3](kmp/image/kmp3.png)

이 사진을 보면 0 ~ header의 substring(`babcbc`)과 header + 1 ~ footer의 substring(`babcba`)은 다르지만 그 직전 포인터까지의 substring(`babcb`)은 같다는 것을 알 수 있다.
그러면 header - 1(`babcb`)이 접미사를 가지고 있다면 그 시점에서의 접두사 또한 존재했다는 뜻이고, footer 또한 그 접두사를 가질 수 있다.
말로 설명하기 어려우니 그림으로 표현해보겠다.

![패턴 문자열 4](kmp/image/kmp4.png)

그리고 pi[header - 1]이 곧 babcb일 때 다음 header의 위치이므로 그 위치에 header를 옮겨 준 후 다시 header와 footer를 비교하는 것이다

![패턴 문자열 5](kmp/image/kmp5.png)

이걸 위해 그 while문을 사용하는 것이다.

그 이후 텍스트 문자열과 패턴을 비교하는 코드는 다른 블로그에도 많으니 따로 적지는 않겠다. 원래 내가 모르는 부분만 정리하려고 했기 때문에...

# 3. 고찰

블로그에 정리해보면서 KMP에 대해서 조금 더 깊은 이해를 할 수 있게 된 것 같다. 다만 글쓰는 능력이 부족해서 나중에 친구들에게 설명을 하라고 했을 때 블로그를 보여줘서 이해시키기는 어려울 것 같다.. 블로그도 자주 쓰면서 글 쓰는 연습을 자주 하고, 내 생각을 깔끔하게 정리하는 법도 연습을 많이 해야겠다.

github : https://github.com/mungmnb777/java-algorithm/blob/main/code/boj/Main_1786_찾기.java