<p>Organizarea codurilor sursa s-a facut in felul urmator:</p>

<ul>
  <li>com.mycompany.laboratorul12
    <ul>
      <li>Main.java</li>
      <li>MyClassLoader.java</li>
      <li>MyTestFramework.java</li>
      <li>Report.java</li>
    </ul>
  </li>
  <li>com.mycompany.laboratorul12.utils
    <ul>
      <li>MyJarUtil.java</li>
      <li>MyRandomUtil.java</li>
    </ul>
  </li>
</ul>

<p>In esenta, programul functioneaza in felul urmator: in clasa MyTestFramework exista metoda <em>beginTest(String inputFile)</em> care primeste o cale catre un fisier
de input ce contine pe fiecare linie cai ori catre fisiere .class, ori catre fisiere .jar, iar input-ul standard de la tastatura este redirectat catre acest fisier(daca exista). Acest fisier se gaseste in root-ul proiectului.</p>

<p>De precizat faptul ca in folder-ul <em>dummyProject</em> se regaseste un proiect folosit pentru a testa functionalitatile in cadrul acestui laborator.</p>

<p>Partea de <strong>compulsory</strong> se realizeaza atunci cand de la input se primeste o cale catre un fisier .class . In cadrul metodei <em>tryToLoadClass(String classStr)</em> se verifica daca poate fi incarcata in memorie clasa indicata de cale, verificandu-se cu ajutorul unui <em>MyClassLoader</em> toate variantele posibile de CLASSPATH-uri si de package-uri ale clasei. In caz afirmativ, se va returna un obiect de tipul <em>Class&lt;?&gt;</em> ce nu va fi <em>null</em>. Dupa accea se vor incarca sa se invoce toate metodele adnotate cu @Test fara niciun parametru.</p>

<p>In cadrul partii de <strong>optional</strong>, explorarea unui fisier .jar se face cu ajutorul clasei <em>MyJarUtil</em>, unde se va executa cu ajutorul unui <em>ProcessBuilder</em>  comanda "jar -tf 'cale_catre_fisier_jar'", iar continutul furnizat va fi filtrat, returnandu-se o lista cu String-uri ce contin numai package-uri catre fisiere .class . De mentionat faptul ca acest procedeu depinde de sistemul de operare(in cazul de fata Windows), deoarece variabila PATH_TO_JAR_COMMAND retine calea catre executabilul <em>jar.exe</em>  </p>

<p>In ceea ce priveste crearea unui prototip cat mai asemanator cu ceea cu furnizeaza utilitarul <em>javap</em>, o instanta de tip <em>Report</em> va prelua o clasa incarcata in memorie si va incerca sa obtina cat mai multe informatii posibile(numele clasei, numele superclasei, constructorii cu nume si signatura, campuri cu access modifiers, tip si nume, metode cu access modifiers, tip de return, nume si signatura.) ce vor fi utilizate de metoda <em>toString()</em> pentru a reprezenta un obiect de tipul <em>Report</em></p>

<p>In ceea ce priveste invocarea metodelor publice adnotate cu @Test, fie ele statice sau nu, s-a impus urmatoarea constrangere: metoda(sau constructorul) ori sa nu aiba parametrii, ori sa aiba parametrii(oricati) de tipul <em>int</em> sau <em>String</em>. In cadrul clasei <em>MyTestFramework</em> exista metoda <em>invokeTestMethods(Class&lt;?&gt;)</em> ce va incerca invocarea metodelor unei clase incarcate in memorie in felul urmator: in primul rand, se va incerca instantierea clasei, parcurgandu-se toti constructorii pana se gaseste unul care satisface constrangerea mentionata anterior. In cazul in care are parametrii, clasa <em>MyRandomUtil</em> ofera sprijin in furnizarea unor valori mock pentru int sau String. Dupa aceea se vor parcurge toate metodele si in mod asemanator cu procedeul de la constructori, se vor invoca doar acele metode ce satisfac constrangerea. </p>
