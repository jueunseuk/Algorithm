# [Gold IV] 두 단계 최단 경로 1 - 23793 

[문제 링크](https://www.acmicpc.net/problem/23793) 

### 성능 요약

메모리: 45052 KB, 시간: 600 ms

### 분류

그래프 이론, 최단 경로, 데이크스트라

### 제출 일자

2025년 7월 23일 19:04:52

### 문제 설명

<p>서준이는 아빠로부터 생일선물로 세계 지도를 받아서 매우 기뻤다. 세계 지도에서 최단 경로를 찾는 프로그램을 개발해서 아빠께 감사의 마음을 전달하려고 한다. 세계 지도는 도시를 정점으로 갖고 도시 간의 도로를 간선으로 갖는 방향성 그래프이며(directed graph), 도로의 길이가 간선의 가중치이다. 도시의 번호는 1부터 N까지이다. 출발 정점 X에서 출발하여 중간 정점 Y를 거쳐서 도착 정점 Z에 도달하는 최단 거리, 출발 정점 X에서 출발하여 중간 정점 Y를 거치지 않고 도착 정점 Z에 도달하는 최단 거리를 각각 구해서 우리 서준이를 도와주자.</p>

### 입력 

 <p>첫째 줄에 정점의 수 <em>N</em> (1 ≤ <em>N</em> ≤ 100,000), 간선의 수 <em>M</em> (1 ≤ <em>M</em> ≤ 200,000)이 주어진다.</p>

<p>다음 <em>M</em>개 줄에 간선 정보 <code>u v w</code>가 주어지며 도시 u에서 도시 v로 가중치가 w인 단방향 도로를 나타낸다. (1 ≤ u, v ≤ <em>N</em>, u ≠ v, 1 ≤ w ≤ 10,000, w는 정수) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.</p>

<p>다음 줄에 <code>X Y Z</code>가 주어진다. (1 ≤ X, Y, Z ≤ <em>N</em>, X ≠ Y, X ≠ Z, Y ≠ Z)</p>

### 출력 

 <p>첫째 줄에 두 정수를 출력한다. 첫 번째 정수는 정점 X에서 출발해서 정점 Y를 거쳐서 정점 Z에 도달하는 최단 거리를 의미한다. 두 번째 정수는 정점 X에서 출발해서 정점 Y를 거치지 않고 정점 Z에 도달하는 최단 거리를 의미한다.</p>

<p>만약, 정점 Z에 도달할 수 없는 경우 -1을 출력한다.</p>

