# [Gold III] 총깡 총깡 - 14618 

[문제 링크](https://www.acmicpc.net/problem/14618) 

### 성능 요약

메모리: 14636 KB, 시간: 148 ms

### 분류

데이크스트라, 그래프 이론, 최단 경로

### 제출 일자

2025년 7월 31일 06:32:46

### 문제 설명

<p dir="ltr">동물 애호가 진서는 총깡총깡 뛰는 동물과 짝폴짝폴 뛰는 동물들을 K마리씩 키운다. 타지로 취업하게 된 진서는 내일 이사를 한다.</p>

<p dir="ltr">이사하게 될 집에서 같이 살게 될 룸메이트 일호는 동물을 싫어하기 때문에 진서는 근처의 집에 동물들을 한마리씩 맡길 예정이다.</p>

<p dir="ltr">진서가 동물들을 맡길 수 있는 집의 종류는 A형 집과 B형 집 2종류 이다.</p>

<p>우연하게도 짝폴짝폴 뛰는 동물과 총깡총깡 뛰는 동물, A형 집, B형 집의 수는 모두 같다.</p>

<p style="text-align: center;"><img alt="" src="https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/14618/1.png" style="height:554px; width:460px"></p>

<p dir="ltr">진서는 총깡총깡 뛰는 동물들과 짝폴짝폴 뛰는 동물들을 같은 종류의 집에 통일 시켜 맡기고 싶다.</p>

<p dir="ltr">하지만 진서는 총깡총깡 뛰는 동물들을 약간 더 좋아하므로 각 집에서 동시에 출발하여 진서네 집으로 가장 빨리 도착하는 동물이 총깡총깡 뛰는 동물이길 원한다.</p>

<p dir="ltr">진서가 살게 될 집, A형 집, B형 집, A형 집도 B형 집도 아닌 집이 있는 지도가 주어질 때 총깡총깡 뛰는 동물이 A형 집에 살아야 할 지 B형집에 살아야 할지 출력하고 가장 빨리 도착하는 총깡총깡 뛰는 동물이 진서네 집으로 부터 얼마만큼 떨어져 있는지 출력하라.</p>

<p>(만약 총깡총깡 뛰는 동물들이 A형집에 살던 B형집에 살던 상관이 없는 경우는 A형집에 살기로 한다.)</p>

### 입력 

 <p dir="ltr">입력의 첫 번째 줄에 전체 집의 수 N과 집과 집사이를 연결하는 도로 M이 공백으로 주어진다. (3 ≤ N ≤ 5,000, 3 ≤ M ≤ 20,000)</p>

<p dir="ltr">입력의 둘째 줄에 진서의 집 J가 주어진다 (1 ≤ J ≤ N)</p>

<p dir="ltr">입력의 셋째 줄에 종류별 동물의 수 K가 주어진다. (2*K ≤ N)</p>

<p dir="ltr">입력의 넷째 줄에 K개의 A형 집이 공백으로 구분되어 주어진다.</p>

<p dir="ltr">입력의 다섯 번째 줄에 K개의 B형 집이 공백으로 구분되어 주어진다.</p>

<p>이후 M개의 줄에 X Y Z(1 ≤ X, Y ≤ N, 1 ≤ Z ≤ 100)가 주어진다. 이는 X번 집과 Y번 집 사이에 Z의 길이를 가지는 도로가 존재한다는 것이다.</p>

### 출력 

 <p dir="ltr">총깡총깡 뛰는 동물이 살게 될 집의 종류를 말한 뒤 다음줄에 거리를 출력한다.</p>

<p>A형 집에서만 진서의 집에 갈 수 있는 경우 A를 출력한 뒤 다음 줄에 거리를 출력, B형 집에서만 진서의 집에 갈 수 있는 경우 B를 출력한 뒤 다음 줄에 거리를 출력, A형 집, B형 집 둘다 진서의 집에 갈 수 없는 경우에는 –1을 출력한다.</p>

