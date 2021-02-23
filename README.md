# radudamianpa
Radu Damian 2A3 Programare Avansata

Laboratorul 1

Pentru partea de optional am declarat matricea de adiacenta de tip boolean corespunzatoare grafului random. 
Pentru a verifica conexitatea grafului, am implementat un algoritm BFS. 

Pentru partea de bonus am utilizat un array pentru a reprezenta un rooted tree, iar pentru a genera un random rooted tree am utilizat un set(acesta avand initial un singur nod, nodul radacina indexat cu 0)
(importate din java.util.\*) in felul urmator: pentru nodul parinte(nodul notat cu 0 initial) am generat un numar random de copii(intre 1 si n-1, unde n este numarul 
de noduri ale arborelui). Dupa aceea am scos nodul parinte din set si am adaugat nodurile copii, acestea avand proprietatea de a fi noduri disponibile ca parinte pentru urmatoarea randomizare
(din acest Set voi alege in mod random un parinte caruia ii voi aloca un numar random de copii). Procedeul continua pana cand nu mai sunt noduri ramase.


Laboratorul 2(in progress)
