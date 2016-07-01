% HELLO WORLD. Works with Sbp (prolog)

hello :-
printstring("HELLO WORLD!!!!").

printstring([]).
printstring([HT]) :- put(H), printstring(T).
