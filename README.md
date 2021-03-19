# radudamianpa
<h1>Radu Damian 2A3 Programare Avansata</h1>

<h2>Laboratorul 1</h2>

<p>Pentru partea de optional am utilizat matricea de adiacenta de tip boolean corespunzatoare grafului random.<p>
<p>Pentru a verifica conexitatea grafului, am implementat un algoritm BFS. </p>

<p>Pentru partea de bonus am utilizat un array pentru a reprezenta un rooted tree, iar pentru a genera un random rooted tree am utilizat un set(acesta avand initial un singur nod, nodul radacina indexat cu 0)
(importate din java.util.\*) in felul urmator: pentru nodul parinte(nodul notat cu 0 initial) am generat un numar random de copii(intre 1 si n-1, unde n este numarul 
de noduri ale arborelui). Dupa aceea am scos nodul parinte din set si am adaugat nodurile copii, acestea avand proprietatea de a fi noduri disponibile ca parinte pentru urmatoarea randomizare
(din acest Set voi alege in mod random un parinte caruia ii voi aloca un numar random de copii). Procedeul continua pana cand nu mai sunt noduri ramase.</p>


<h2>Laboratorul 2</h2>

<p>Algoritmul implementat pentru partea de optional este unul de tip Greedy, in care pentru fiecare depozit se iau cat mai multe unitati din fiecare supply pana cand se satisface demand-ul depozitului respectiv. In acest fel, se obtine o solutie fezabila, dar nu neaparat si optima.
In ceea ce priveste partea de bonus, algoritmul implementat este cel al lui Vogel, urmand indicatiile din link-ul anexat pe pagina laboratorului. ( https://www.geeksforgeeks.org/transportation-problem-set-4-vogels-approximation-method/ )<p>

<h2>Laboratorul 3</h2> 

<p>In cadrul partii de optional, pentru a afisa locatiile ce sunt doar Visitable, am adaugat fiecarei locatii o metoda publica de tip boolean isOnlyVisitable(), iar in cadrul clasei City, am parcurs fiecare locatie din lista. In cazul in care metoda mentionata anterior returneaza favoarea true, atunci stim sigur ca locatia respectiva este Visitable si putem face un upcast la Visitable. Sortarea dupa openingTime s-a realizat prin intermediul unui comparator temporar.
Am adaugat ulterior interfetei Visitable metodele cerute(2 default si una statica).</p>
<p>In cadrul implementarii clasei TravelPlan, pentru ca o instanta a acesteia sa contina un obiect de tipul City, am declarat un membru privat de tip City. Pentru a determina cel mai scurt drum intre doua locatii date, am implementat algoritmul lui Dijkstra.</p>

<h2>Laboratorul 4 </h2> 

<p> Organizarea codurilor sursa am facut-o in felul urmator: </p>

<ul>
  <li>
    com.mycompany.laboratorul4.main 
    <ul>
      <li>Lab4.java</li>
    </ul>
  </li>
  <li>
    com.mycompany.laboratorul4.domain
    <ul>
      <li>School.java</li>
      <li>Student.java</li>
    </ul>
  </li>
  <li>
    com.mycompany.laboratorul4.problems
    <ul>
      <li>EasyProblem.java</li>
      <li>HardProblem.java</li>
      <li>Problem.java</li>
      <li>Solution.java</li>
    </ul>
  </li>
  <li>
    com.mycompany.laboratorul4.algorithms
    <ul>
      <li>Algorithm.java</li>
      <li>EasyAlgorithm.java</li>
      <li>GaleShapley.java</li>
    </ul>
  </li>
</ul>

<p>Clasele le-am conceput in felul urmator: in ceea ce priveste reprezentarea <b>problemei</b>, am creat trei clase, si anume o clasa abstracta <em>Problem</em>, care este extinsa de clasele <em>EasyProblem</em> si <em>HardProblem</em>, corespunzatoare celor doua tipuri de instante de probleme aferente partilor de optional, respectiv bonus.</p>

<p>Pe de alta parte, in cadrul reprezentarii <b>algoritmului</b> am creat trei clase, si anume o interfata functionala <em>Algorithm</em> , care este implementata de clasele <em>EasyAlgorithm</em> si <em>GaleShapley</em>, asociate in mod similar ca in paragraful anterior(i.e. asocierea facandu-se partilor de optional, respectiv bonus)</p>

<p>Bineinteles ca cele doua tipuri de instante ale problemei propuse au solutia reprezentata in acelasi fel, deci a fost suficienta crearea unei singure clase <em>Solution</em>.</p>

<p>Pentru rezolvarea partii de <b>optional</b>, primul querry se gaseste in clasa abstracta <em>Problem</em>, iar al doilea querry se gaseste in clasa <em>HardProblem</em </p>
