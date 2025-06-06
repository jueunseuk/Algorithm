# [Platinum V] 소방서의 고민 - 2180 

[문제 링크](https://www.acmicpc.net/problem/2180) 

### 성능 요약

메모리: 72220 KB, 시간: 712 ms

### 분류

그리디 알고리즘, 정렬

### 제출 일자

2025년 3월 31일 13:56:05

### 문제 설명

<p>여기는 울릉도 소방서이다. 소방차가 한 대 밖에 없어서 여러 차례 중앙 정부에 소방차 증차를 요청하였으나 아직도 증차가 실현되지 않고 있다. 그런데 오늘 믿어지지 않는 엄청난 일이 발생하고 말았다. 여러 건의 화재가 동시에 발생한 것이다. 소방서의 고민은 한 대의 소방차를 이용하여 어떤 순서로 화재를 진압하는 것이 모든 화재를 진압하는데 걸리는 시간을 최소화하느냐는 것이다. 지체할 시간이 없다. 그 순서를 아주 빨리 정해야 한다. 당신의 도움이 필요하다.</p>
<p>다행히 다음과 같은 정보를 얻을 수 있다. 한 화재 사건에 소방차 도착이 늦으면 늦을수록 화재를 진압하는데 걸리는 시간이 같거나 길어진다. 화재의 종류에 따라서, 화재 발생 후 소방차가 t초 후에 도착하면 화재를 진압하는데 걸리는 시간은 at +b와 같이 1차 함수의 형태로 나타나게 된다. 물론 a와 b는 음수는 아니다. 화재 종류별로 a, b의 값이 일반적으로 다르게 나타나게 된다.</p>
<p>모든 화재 사건은 시각 0에서 발생하였다. 당신은 모든 화재를 진압하는데 걸리는 최소 시간이 얼마인지를 알고 싶다. 소방차의 이동 시간은 고려하지 않고 0으로 가정하며, 한 화재 진압이 완전히 끝나기 전에는 소방차가 다른 화재 현장으로 이동할 수 없다.</p>

### 입력 

 <p>첫째 줄에 화재 발생 건수 n이 주어진다. n은 200,000 이하의 양의 정수이다. 둘째 줄부터 n개의 줄에 각각 한 줄에 한 쌍씩 a와 b가 입력된다. a와 b는 40,000 이하의 음이 아닌 정수이다.</p>

### 출력 

 <p>첫째 줄에 모든 화재를 진압하는데 걸리는 최소 시간을 40,000으로 나눈 나머지를 출력한다.</p>

