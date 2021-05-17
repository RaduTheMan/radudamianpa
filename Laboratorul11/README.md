<h1>Laboratorul 11</h1>

<p>Structurea proiectului este urmatoarea:</p>

<ul>
  <li>com.rest.lab11
    <ul>
      <li>Lab11Application.java</li>
    </ul>
  </li>
  <li>com.rest.lab11.configs
    <ul>
      <li>SpringFoxConfig.java</li>
    </ul>
  </li>
  <li>com.rest.lab11.controllers
    <ul>
      <li>PersonController.java</li>
      <li>RelationshipController.java</li>
    </ul>
  </li>
  <li>com.rest.lab11.entities
     <ul>
      <li>Person.java</li>
      <li>Relationship.java</li>
    </ul>
  </li>
  <li>com.rest.lab11.exceptions
     <ul>
      <li>ControllerExceptionHandler.java</li>
      <li>ErrorMsg.java</li>
      <li>PersonNotFoundException.java</li>
    </ul>
  </li>
  <li>com.rest.lab11.problem
    <ul>
      <li>Algorithm.java</li>
      <li>LinearAlgorithm.java</li>
      <li>Solution.java</li>
    </ul>
  </li>
  <li>com.rest.lab11.repositories</li>
</ul>

<p>In cadrul partii de <strong>optional</strong>, implementarea serviciilor pentru a insera o relatie de prietenie si pentru a determina toate relatiile de prietenie din reteaua sociala se regaseste in clasa <em>RelationshipController.</em></p>
<p>Pe de alta parte, implementarea serviciului pentru a determina cele mai populare/mai putin populare k persoane se regaseste in clasa <em>PersonController</em>, metoda avand urmatoarea signatura: getPopular_k(@RequestParam int k, @RequestParam String type), unde type poate lua doua valori: MOST sau LEAST in functie de problema dorita spre a fi rezolvata.(in caz contrar statusul http va fi setat pe BAD_REQUEST)</p>
<p>Integrarea serviciilor in proiectul anterior s-a realizat in felul urmator: in cadrul clasei <em>SocialNetwork</em> se regaseste metoda <em>myRestTemplate(RestTemplateBuilder builder)</em> ce construieste un RestTemplate ce va fi utilizat pentru a apela serviciile REST in metodele corespunzatoare din aceasta clasa(ce se ocupa de persoane si de relatiile de prietenie). De notat faptul ca proiectul anterior a fost adaptat astfel incat sa devina un proiect Spring Boot(au fost adaugate niste dependendente specifice) </p>
<p>Exceptia aleasa pentru a fi tratata utilizand un <em>RestControllerAdvice</em> se refera la cazul in care o persoana nu este gasita in baza de date. Clasele corespunzatoare se gasesc in package-ul  <em>com.rest.lab11.exceptions</em></p>

<p>In cadrul partii de <strong>bonus</strong>, algoritmul implementat pentru a rezolva problema se regaseste <a href="https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/">aici</a>. Clasele aferente se gasesc in package-ul <em>com.rest.lab11.problem</em>, iar implementarea serviciului ce rezolva problema se gaseste in clasa <em>PersonController</em>, avand signatura <em>getImportantPersons()</em></p>

<p>Documentarea serviciilor a fost realizata utilizandu-se Swagger UI(au fost incluse dependente specifice, iar configurarea se realizeaza in cadrul clasei <em>SpringFoxConfig</em> din pachetul <em>com.rest.lab11.configs</em>. Pentru a facilita accesul la aceasta documentatie, proiectul are un home page ce indica link-ul catre aceasta documentatie.</p>

<p>Pentru a securiza serviciile REST, s-a generat un fisier numit <em>bootsecurity.p12</em> ce reprezinta un <em>self signed certificate</em>. Cu ajutorul acestuia s-a inclus in proiect protocolul HTTPS. De asemenea, aplicatia are si o pagina de login generata de <em>Spring Security</em>, credentialele fiind setate in felul urmator: username:"user", password:"password".</p>

