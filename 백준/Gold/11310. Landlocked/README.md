# [Gold IV] Landlocked - 11310 

[문제 링크](https://www.acmicpc.net/problem/11310) 

### 성능 요약

메모리: 51088 KB, 시간: 412 ms

### 분류

그래프 이론, 그래프 탐색, 너비 우선 탐색, 깊이 우선 탐색, 최단 경로, 데이크스트라, 0-1 너비 우선 탐색

### 제출 일자

2026년 3월 9일 11:20:36

### 문제 설명

<p>Canada is not a landlocked country: the country touches at least one ocean (in fact, it touches three).</p>

<p>There are 46 countries (including Bolivia and Mongolia, for example) which are landlocked. That is, they do not touch an ocean, but by going through one other country, an ocean can be reached. For example, a person in Mongolia can get to an ocean by passing through Russia.</p>

<p>Liechtenstein and Uzbekistan are the only two countries in the world which are land-landlocked. That is, not only are they land-locked, but all countries which surround these two countries are land-locked countries. Thus, one would have to pass through at least two different countries when leaving Uzbekistan before arriving at an ocean.</p>

<p>Your task is to determine how landlocked each country is on a given map. We say that a country is not landlocked (recorded as 0) if it touches water in any adjacent cell in either a horizontal, vertical, or diagonal direction. If a country is landlocked, you must calculate the minimum number of borders that one must cross in order to travel from the country to water. Each step of such a journey must be to a cell that is adjacent in either a horizontal, vertical, or diagonal direction. Crossing a border is defined as taking a step from a cell in one country to an adjacent cell in a different country.</p>

<p>Note that countries may not be connected to themselves (as in a country formed of islands). In this case, the landlocked value for the country is the minimal of each connected region of the country.</p>

### 입력 

 <p>The first line contains N and M (1 ≤ N, M ≤ 1000).</p>

<p>On each of the next N lines, there are M capital letters. Each country will be represented by a unique letter, with the exception that the letter W is reserved to indicate the water in the oceans or seas that will be used to determine the how landlocked each country is.</p>

### 출력 

 <p>The output consists of the country letter followed by a space, followed by the landlockedness for that particular country. Output should be in alphabetical order.</p>

