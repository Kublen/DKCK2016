zdanie(move(X, Y, Z)) --> orz(X), okpaczki(X, Y), ok_sposobu(X, Z).
zdanie(move(X, Y, Z)) --> orz(X), ok_sposobu(X, Z), okokier(X, Y).

zdanie() --> 
zdanie() --> 


orz(drive) --> [przenies].
orz(drive) --> [przewiez].
orz(drive) --> [przesun].
orz(drive) --> [zawiez].
orz(drive) --> [dostarcz].
orz(drive) --> [przestaw].
orz(drive) --> [zwiez].
orz(drive) --> [przeloz].

okkier(to) --> [na].
okkier(from) --> [z].

okpaczki(small, rectangular, grey) --> [mala, prostokatna, szara].
okpaczki(small, rectangular, yellow) --> [mala, prostokatna, zolta].
okpaczki(small, rectangular, white) --> [mala, prostokatna, biala].

okpaczki(medium, rectangular, grey) --> [srednia, prostokatna, szara].
okpaczki(medium, rectangular, yellow) --> [srednia, prostokatna, zolta].
okpaczki(medium, rectangular, white) --> [srednia, prostokatna, biala].

okpaczki(big, rectangular, grey) --> [duza, prostokatna, szara].
okpaczki(big, rectangular, yellow) --> [duza, prostokatna, zolta].
okpaczki(big, rectangular, white) --> [duza, prostokatna, biala].

okpaczki(small, round, grey) --> [mala, prostokatna, szara].
okpaczki(small, round, yellow) --> [mala, prostokatna, zolta].
okpaczki(small, round, white) --> [mala, prostokatna, biala].

okpaczki(medium, round, grey) --> [srednia, prostokatna, szara].
okpaczki(medium, round, yellow) --> [srednia, prostokatna, zolta].
okpaczki(medium, round, white) --> [srednia, prostokatna, biala].

okpaczki(big, round, grey) --> [duza, prostokatna, szara].
okpaczki(big, round, yellow) --> [duza, prostokatna, zolta].
okpaczki(big, round, white) --> [duza, prostokatna, biala].


rampa(in) --> [rampy wejsciowej]
rampa(out) --> [rampe wyjsciowa]

sektor(left) --> [lewy].
sektor(middle) --> [srodkowy].
sektor(right) --> [prawy].

polka(first) --> [pierwsza].
polka(second) --> [druga].
polka(third) --> [trzecia].




