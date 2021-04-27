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

<p>Bineinteles ca cele doua tipuri de instante ale problemei propuse au <b>solutia</b> reprezentata in acelasi fel, deci a fost suficienta crearea unei singure clase <em>Solution</em>.</p>

<p>Pentru rezolvarea partii de <b>optional</b>, primul querry se gaseste in clasa abstracta <em>Problem</em>(in cadrul metodei <em>querry1()</em>), iar al doilea querry se gaseste in clasa <em>HardProblem</em>(in cadrul metodei <em>querry2()</em>). Implementarea algoritmului pentru aceasta parte se regaseste in clasa <em>EasyAlgorithm</em> in cadrul metodei <em>solve()</em>. De mentionat faptul ca am randomizat mediile studentilor, cat si capacitatile scolilor(acestea din urma intr-un interval de la 1 la 4) </p>

<p>Pentru rezolvarea partii de <b>bonus</b>, implementarea algoritmului s-a realizat in clasa <em>GaleShapley</em> in cadrul aceleiasi metode <em>solve()</em>.</p>

<h2>Laboratorul 5</h2>

<p> Organizarea codurilor sursa am facut-o in felul urmator: </p>

<ul>
  <li>
    com.mycompany.laboratorul5.main 
    <ul>
      <li>Main.java</li>
    </ul>
  </li>
  <li>
    com.mycompany.laboratorul5.domain
    <ul>
      <li>Catalog.java</li>
      <li>CatalogUtil.java</li>
      <li>Item.java</li>
      <li>Song.java</li>
      <li>Movie.java</li>
    </ul>
  </li>
  <li>
    com.mycompany.laboratorul5.commands
    <ul>
      <li>Shell.java</li>
      <li>Comand.java</li>
      <li>AddCommand.java</li>
      <li>CreateCommand.java</li>
      <li>ListCommand.java</li>
      <li>LoadCommand.java</li>
      <li>PlayCommand.java</li>
      <li>ReportCommand.java</li>
      <li>SaveCommand.java</li>
    </ul>
  </li>
  <li>
    com.mycompany.laboratorul5.exceptions
    <ul>
      <li>InvalidCommandException.java</li>
      <li>InvalidMyPathException.java</li>
      <li>InvalidRatingException.java</li>
      <li>InvalidYearException.java</li>
    </ul>
  </li>
</ul>

<p>Pentru partea de compulsory am extins modalitatea de salvare initiala a catalogului(format binar) prin utilizarea de fisiere XML. In clasa CatalogUtil am definit metodele statice <em>saveWithBinary(Catalog catalog)</em>, <em>saveWithXML(Catalog catalog)</em>, <em>loadWithBinary(String path)</em>, <em>loadWithXML(String path)</em> </p>

<p>In cadrul partii de optional, in afara de clasele aferente fiecarei comenzi, am definit si o clasa <em>Shell</em>, care tine evidenta tuturor cataloagelor ce se pot forma intr-o sesiune de shell. Metoda principala a acestei clase este <em>run()</em>, unde se cere input de la tastatura linie cu linie, se verifica daca comenzile sunt corecte d.p.d.v sintactic si se utilizeaza clasele aferente comenzilor, fiecare din acestea avand o metoda <em>execute(List<String> arguments)</em> care este implementata in principiu utilizand implementarile de la partea de compulsory. </p>
  
<h2>Laboratorul 6</h2>

In cadrul acestui laborator, am rezolvat partea de compulsory.

<h2>Laboratorul 7</h2>

<p>Codurile sursa sunt urmatoarele:</p>
 
<ul>
  <li>Main.java</li>
  <li>Game.java</li>
  <li>Player.java</li>
  <li>BotPlayer.java</li>
  <li>ManualPlayer.java</li>
</ul>

<p>Am considerat jetoanele ca fiind muchii ale unui graf complet. Pentru a reprezenta tabela de joc, am declarat un Map&lt;String, Integer&gt; in cadrul clasei <em>Game</em>, unde cheia reprezinta o muchie a unui graf complet sub forma unui String(de exemplu: "1,2" sau "2,4"), iar valoarea este practic cea a jetonului. </p>

<p>Thread-urile corespunzatoare jucatorilor sunt pornite in cadrul clasei <em>Game</em> in metoda <em>startGame()</em>. Pentru a asigura faptul ca fiecare jucator
  isi face mutarea doar cand este randul lui, am utilizat in cadrul metodei <em>run()</em>, suprascrisa din interfata <em>Runnable</em>, un synchronized block 
  avand ca monitor instanta aferenta clasei <em>Game</em>, unde verific daca indicele jucatorului este egal cu cel al turei curente.</p>

<p>Pentru a modela strategiile jucatorilor, am definit o clasa abstracta <em>Player</em> si clasele aferente care o extind pe aceasta: <em>BotPlayer</em>, <em>ManualPlayer</em>. Metoda abstracta <em>chooseToken()</em> indica modul in care fiecare tip de jucator isi alege jetonul.</p>

<p>Pentru a implementa modalitatea prin care se decide clasamentul(implicit castigatorul), am considerat ca fiecare jucator sa aiba asignat un scor la finalul 
jocului, si anume suma valorilor jetoanelor din toate circuitele care se pot forma din jetoanele alese de fiecare jucator. Jucatorul cu scorul cel mai mare castiga. Pentru a determina circuitele unui graf neorientat, am utilizat algoritmul din acest <a href="https://www.geeksforgeeks.org/print-all-the-cycles-in-an-undirected-graph/">link</a> in cadrul metodelor <em>determineSequences(...)</em> si  <em>dfs(...)</em> din clasa <em>Game</em>. In final, voi sorta lista de jucatori din aceeasi clasa <em>Game</em> utilizand un comparator ca fiind metoda statica <em>compareByScore(...)</em> din clasa <em>Player</em>. De precizat ca implementarea pentru a afisa clasamentul se face in metoda <em>startGame()</em>.  </p>

<h2>Laboratorul 8</h2>

<p>Organizarea codurilor sursa am facut-o astfel:</p>

<ul>
  <li>com.mycompany.laboratorul8.daoimplementations
    <ul>
      <li>ActorDaoImpl.java</li>
      <li>DirectorDaoImpl.java</li>
      <li>GenreDaoImpl.java</li>
      <li>MovieDaoImpl.kava</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul8.daointerface
    <ul>
      <li>ActorDao.java</li>
      <li>DirectorDao.java</li>
      <li>GenreDao.java</li>
      <li>MovieDao.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul8.domain
    <ul>
      <li>Actor.java</li>
      <li>Director.java</li>
      <li>Genre.java</li>
      <li>Movie.java</li>
      <li>Person.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul8.main
    <ul>
      <li>Main.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul8.singleton
    <ul>
      <li>DbConnection.java</li>
    </ul>
  </li>
</ul>

<p>Toate interfetele DAO au aceleasi metode, care se diferentiaza prin clasele targetate(e.g. Actor, Director). In general, acestea au metodele:</p>

<ul>
  <li>getAllObjects()</li>
  <li>getObject(int id)</li>
  <li>updateOject(Object object)</li>
  <li>deleteObject(Object object)</li>
</ul>

<p>unde Object poate fi Actor, Director, Genre sau Movie.</p>

<p>Implementarile acestor metode sunt relativ asemanatoare(ce se regasesc in implementarile interfetelor, de exemplu in clasele ActorDaoImpl, MovieDaoImpl), fiind diferentiate de clasele targetate si de tabele.</p>

<p>In cadrul bazei de date, pentru a gestiona actorii si directorii, am creat tabelele <em>actors</em>, <em>directors</em>, <em>actor_movie_assoc</em>, <em>director_movie_assoc</em>. Scriptul sql aferent este <em>creare_filme.sql</em></p>

<p>Ultimele doua tabele mentionate evidentiaza asocierile intre actori si filme, respectiv intre directori si filme.</p>

<h2>Laboratorul 9</h2>

<p>Organizarea codurilor sursa am facut-o in felul urmator(sunt incluse si cele de la laboratorul anterior):</p>
<ul>
  <li>com.mycompany.laboratorul9.jdbc.daoimplementations
    <ul>
      <li>ActorDaoImpl.java</li>
      <li>DirectorDaoImpl.java</li> 
      <li>GenreDaoImpl.java</li> 
      <li>MovieDaoImpl.java</li> 
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.jdbc.daointerface
    <ul>
      <li>ActorDao.java</li>  
      <li>DirectorDao.java</li> 
      <li>GenreDao.java</li> 
      <li>MovieDao.java</li> 
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.jdbc.domain
    <ul>
      <li>Actor.java</li>
      <li>Director.java</li>
      <li>Genre.java</li>
      <li>Movie.java</li>
      <li>Person.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.jdbc.singleton
    <ul>
      <li>DbConnection.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.jpa.converters
     <ul>
       <li>DurationConverter.java //converter folosit pentru a converti tipul de date Duration in tipul de date INTERVAL DAY TO SECOND</li>
     </ul>
  </li>
  <li>com.mycompany.laboratorul9.jpa.entityclasses
    <ul>
      <li>AbstractEntity.java</li>
      <li>Actor.java</li>
      <li>Chart.java</li>
      <li>Director.java</li>
      <li>Genre.java</li>
      <li>Movie.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.jpa.repoclasses
    <ul>
      <li>AbstractRepository.java</li>
      <li>ActorDaoImpl.java</li>
      <li>ChartDaoImpl.java</li>
      <li>DirectorDaoImpl.java</li>
      <li>GenreDaoImpl.java</li>
      <li>MovieDaoImpl.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.jpa.singleton
    <ul>
      <li>EntityManagerSingleton.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.main
    <ul>
      <li>Main.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.problem
    <ul>
      <li>Algorithm.java</li>
      <li>GreedyAlgorithm.java</li>
      <li>Pair.java</li>
      <li>Solution.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul9.tools
    <ul>
      <li>ImportData.java //tool folosit pentru a importa date din dataset-ul de filme IMDb de pe <a href="https://www.kaggle.com/stefanoleone992/imdb-extensive-dataset">kaggle</a></li>
    </ul>
  </li>
</ul>

<p>Pentru rezolvarea partii de <strong>optional</strong>, suportul pentru <strong>chart-uri</strong> se regaseste prin identificarea entitatii <em>Chart</em> si a clasei
  DAO aferente <em>ChartDaoImpl</em>(aceasta din urma reprezinta o extindere a clasei abstracte generice <em>AbstractRepository</em>). Pentru a asigura faptul ca
  filmele sunt ordonate(in functie de scor), am pus urmatoarea adnotare in cadrul clasei <em>Chart</em> corespunzatoare campului <em>private List&lt;Movie&gt; movieList</em> : @OrderBy("score DESC"). </p>
  
<p>Pentru a crea clasa abstracta <strong>AbstractRepository</strong>, am creat initial clasa abstracta <em>AbstractEntity</em> care contine campurile comune fiecarei entitati(id si nume), iar entitatile aferente tabelelor din baza de date vor extinde aceasta clasa abstracta cu campurile si functionalitatile lor specifice.</p>

<p>Clasa abstracta <em>AbstractRepository</em> contine in mod generic implementarile metodelor <em>findById(int id)</em>, <em>findByName(String name)</em> si <em>create(T entity)</em>, iar fiecare clasa repository ce extinde aceasta clasa abstracta va prelua implicit metodele mentionate anterior.</p>

<p>Pentru rezolvarea partii de <strong>bonus</strong>, clasele aferente se gasesc in pachetul <em>com.mycompany.laboratorul9.problem</em>. Doua filme sunt considerate "inrudite"(adiacente) daca au cel putin un regizor in comun. Pentru a rezolva problema, am implementat un algoritm <em>Greedy</em> care verifica pentru fiecare muchie din graf(o muchie este reprezentata de un <em>Pair</em>) daca poate fi adaugat in cuplajul curent.</p>

<p>Pentru a testa problema pe input-uri relativ mari, am importat 30 000 de filme din dataset-ul mentionat mai sus si le-am introdus in baza de date, impreuna cu actorii(maxim 5 per film), genurile si regizorii aferenti(si bineinteles, asocierile dintre acestea).</p>


