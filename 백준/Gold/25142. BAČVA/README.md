# [Gold III] BAČVA - 25142 

[문제 링크](https://www.acmicpc.net/problem/25142) 

### 성능 요약

메모리: 85148 KB, 시간: 904 ms

### 분류

0-1 너비 우선 탐색, 데이크스트라, 그래프 이론, 최단 경로

### 제출 일자

2025년 7월 21일 11:25:46

### 문제 설명

<p><img alt="" src="https://upload.acmicpc.net/8ce8a5ce-4735-4587-a0ab-962e68e74922/-/preview/" style="width: 106px; height: 170px; float: right;">Nakon posjete dalekoj otočnoj zemlji Ivan ima novo omiljeno piće. Toliko ga je zavolio da ga sada kupuje na bačve. Tijekom kupovine uvijek se iznova susreće s istim problemom, a to je transport bačve od trgovine do svog doma.</p>

<p>Bačvu zamišljamo kao valjak koji se sastoji od dvije baze i plašta kao što je vidljivo na slici. Trgovina i Ivanov dom su polja u tablici, a na svakom polju tablice nalazi se praznina ili zapreka. Bačvu pomičemo kroz tablicu na sljedeći način.</p>

<p>Ako je bačva trenutno postavljena tako da pod dodiruje svojom ravnom stranom (bazom) onda Ivan jedino može bačvu prevrnuti na jedno od susjednih polja (polja su susjedna ako imaju zajedničku stranicu). Primijetite da će se, nakon prevrtanja, bačva nalaziti na svojoj obloj strani (na plaštu).</p>

<p>Ako bačva oblom stranom (plaštom) dodiruje pod, Ivan je može ili kotrljati na neko od susjednih polja (tako da i dalje plaštom dodiruje pod) ili prevrnuti na neko od susjednih polja (tako da ona bazom dodiruje pod). Vidi Sliku 1.</p>

<p>Na koje polje može kotrljati, a na koje prevrnuti bačvu ovisi o tome u kojem je smjeru zadnji put prevrnuo bačvu s ravne na oblu stranu. Pa tako, ako je bačvu zadnji put prevrnuo u smjeru gore ili dolje tada od svoje trenutne pozicije u smjeru gore-dolje može bačvu prevrnuti, a u smjeru lijevo-desno kotrljati. Isto vrijedi za obratne smjerove. Vidi Sliku 2.</p>

<table class="table table-bordered td-middle td-center">
	<tbody>
		<tr>
			<td><img alt="" src="https://upload.acmicpc.net/4319397c-95ff-4d51-9f4e-11640c2a6937/-/preview/" style="width: 408px; height: 382px;"></td>
			<td><img alt="" src="https://upload.acmicpc.net/99a74aae-6160-4aaa-a71c-9017001e010c/-/preview/" style="width: 431px; height: 369px;"></td>
		</tr>
		<tr>
			<td>Slika 1.</td>
			<td>Slika 2.</td>
		</tr>
	</tbody>
</table>

<p>Na početku bačva stoji na bazi. Bačva se ne može prevrnuti ili otkotrljati na ćeliju na kojoj se nalazi zapreka. Ivanu je nebitno u kojem će položaju bačva biti kada ju dovede u završnu ćeliju. Pomozite Ivanu i ispišite koliko najmanje prevrtanja bačve treba napraviti da bi doveo bačvu od trgovine do svog doma.</p>

### 입력 

 <p>U prvom retku nalazi se dva prirodna broja N (1 ≤ N ≤ 1000) i M (1 ≤ M ≤ 1000), broj redova i stupaca tablice.</p>

<p>U idućih N redova nalaze se nizovi od M znakova, izgled tablice. Znak može biti ‘S’ (trgovina), ‘F’ (Ivanov dom), ‘.’ (praznina), ‘#’ (zapreka). Znakovi ‘S’ i ‘F’ će se pojaviti točnom jednom u matrici, a primjeri će biti takvi da će Ivan moći dogurati bačvu od trgovine do doma.</p>

### 출력 

 <p>U prvi redak izlaza ispišite prirodni broj - najmanje prevrtanja bačve koje Ivan treba napraviti da bačvu dovede od trgovine do doma.</p>

