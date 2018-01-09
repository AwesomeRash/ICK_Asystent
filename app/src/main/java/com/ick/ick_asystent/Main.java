package com.ick.ick_asystent;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TYLKO DO TESTOWANIA/USUWANIA RZECZY.
        DBHelper myDB = new DBHelper(getApplicationContext());
        myDB.resetDB();
        myDB.close();

      prepareDB();


    }

    public void onClick_Leki(View view){ startActivity(new Intent(this, Leki.class)); }

    public void onClick_Zakupy(View view){
        startActivity(new Intent(this, Zakupy.class));
    }

    public void onClick_Rachunki(View view){
        startActivity(new Intent(this, Rachunki.class));
    }

    public void onClick_Jedzenie(View view){
        startActivity(new Intent(this, Jedzenie.class));
    }

    public void onClick_Przypomnienie(View view){ startActivity(new Intent(this, Przypomnienia.class)); }

    public void onClick_Profil(View view){
        startActivity(new Intent (this, Profil.class));
    }

    public void onClick_Emergency(View view){
        startActivity(new Intent(this, Raportowanie.class ));
    }

    public void prepareDB(){
        // TODO: Wypełnić sensownymi danymi, na tyle żeby pokazać działanie aplikacji.
        DBHelper myDB = new DBHelper(getApplicationContext());
        myDB.createPrzepis("Klopsiki z warzywami", "Latwy", "20 min", "mięso indyka 400 g bułka kajzerka 1 szt. kapary 2 łyżka jajko 1 szt. Fix Naturalnie Smaczne Klopsiki w sosie pomidorowym Knorr 1 opak. bakłażan 1 szt. cukinia 1 szt. cebula 1 szt. papryka czerwona 1 szt. pomidory pelati pokrojone w kostkę 1 puszka ", "Krok 1\n" +
                "Kapary drobno posiekaj. Bakłażana, cebulę , czerwoną paprykę i cukinię pokrój w drobną kosteczkę. Pokrojone warzywa przełóż do żeliwnego garnka i wstaw do nagrzanego do 200° C piekarnika na 20 minut, aby się upiekły.\n" +
                "Klopsiki z warzywami – krok 2\n" +
                "Krok 2\n" +
                "Bułkę namocz w wodzie, a gdy zrobi się miękka, połącz z mięsem mielonym, jajkiem i posiekanymi kaparami. Z mięsa uformuj małe kulki i wstaw je do piekarnika nagrzanego do 200° C na 10 minut.\n" +
                "Klopsiki z warzywami – krok 3\n" +
                "Krok 3\n" +
                "Upieczone warzywa przełóż do garnka, dodaj pomidory z puszki i Fix Knorr Naturalnie smaczne - Klopsiki w sosie pomidorowym. Całość gotuj dwie minuty, a następnie do powstałego sosu dodaj podpieczone klopsiki. Wszystko razem gotuj jeszcze kolejne dwie minuty.", R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Jajka zapiekane ze szpinakiem", "Latwy","30 min", "4 jajka\n" +
                "1/2 szpinaku świeżego lub mrożonego (najlepiej całych liści)\n" +
                "10 dag fety\n" +
                "2 ząbki czosnku\n" +
                "szczypta świeżo zmielonej gałki muszkatołowej\n" +
                "sól\n" +
                "świeżo zmielony czarny pieprz\n" +
                "2 łyżki masła\n" +
                "\n" +
                "do wysmarowania kokilek:\n" +
                "1 łyżka masła ", "\n" +
                "    Jeśli masz szpinak świeży: przebierz liście, odetnij grube ogonki. Zagotuj wodę z solę i wrzuć liście, gotuj przez minutę, odcedź, przelej zimną wodą, odstaw na chwilę od odcieknięcia.\n" +
                "    Jeśli masz szpinak mrożony: nic z nim nim na razie nie rób :)\n" +
                "    Obrany czosnek pokrój na cienkie plasterki.\n" +
                "    W dużej patelni rozpuść masło, dodaj czosnek, smaż przez minutę, dodaj szpinak (zamrożony lub świeży, wcześniej przygotowany według punktu pierwszego). Smaż świeży przez kilka chwil, a mrożony, aż całkowicie się rozmrozi. Dopraw solą, pieprzem oraz gałką. Odstaw na bok.\n" +
                "    Kokilki wysmaruj masłem.\n" +
                "    Do szpinaku dodaj pokruszą na raczej większe niż mniejsze kawałki fetę, szybko wymieszaj.\n" +
                "    Do kokilek nałóż porcje szpinaku, zrób w nim wgłębienie, wbij jajko.\n" +
                "    Wstaw do piekarnika nagrzanego do 180 stopni. Zapiekaj, aż żółtko się zetnie - trwa to zwykle od 6 do 8 minut.\n" +
                "    Podawaj z białym pieczywem.\n" +
                "    Czyż to nie wspaniały pomysł na początek letniego, leniwego poranka?\n",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Gołąbki","Latwy", "120 min", "kapusta - zwarta, śliczna główka o wadze około 1,2 kg\n" +
                "nadzienie:\n" +
                "kilogram mielonego mięsa\n" +
                "2 szklanki ryżu ugotowanego na twardo (czyli około 20 dag ryżu suchego przed gotowaniem)\n" +
                "2 średniej wielkości cebule\n" +
                "2 jajka\n" +
                "garść posiekanej natki pietruszki\n" +
                "4 łyżki tartej bułki\n" +
                "2 łyżki oleju\n" +
                "sól\n" +
                "świeżo zmielony pieprz\n" +
                "sos:\n" +
                "4 łyżki przecieru pomidorowego\n" +
                "2 szklanki bulionu\n" +
                "2 łyżki mąki pszennej\n" +
                "sól\n" +
                "świeżo zmielony pieprz ", "Z kapusty obrywam wierzchnie, podniszczone liście i za pomocą bardzo ostrego noża, wykrawam głąb.\n" +
                "W wielkim garze, tak dużym, że zmieści się w nim cała kapusta zagotowuję wodę z solą i do gotującej się wody wkładam kapustę - wody powinno być tyle, by cała główka była zanurzona. W trakcie gotowania, za pomocą dwóch widelców, oddzielam wierzchnie liście z kapusty i pozwalam im się gotować przez 2-3 minuty.\n" +
                "Podgotowane liście wyjmuję na talerz - po kilku minutach liście z kapusty w garze same zaczną się oddzielać od główki.\n" +
                "\n" +
                "Kiedy już wszystkie liście są oddzielone, zabieram się za nadzienie: cebulę obieram i siekam na drobną kostkę. Cebulę szklę na oliwie i dodaję do mielonego mięsa wraz z ryżem, jajkami, tartą bułkę, natką pietruszki i przyprawami. Dokładnie wszystko mieszam (niestety należy to zrobić rękoma). Sprawdzam, czy dobrze doprawione.\n" +
                "\n" +
                "W tym momencie liście kapusty powinny już wystygnąć - na każdy liść nakładam słuszną porcję nadzienia i zwijając brzeg liścia do środka, formuję gołąbki. Kilka liści - tych najmniejszych i porwanych zostawiam do wyłożenie prodiża. Gołąbki układam w prodiżu, który wcześniej wysmarowałem olejem i wyłożyłem na dnie, i po bokach ugotowanymi liśćmi kapusty - tymi małymi i tymi, które się porwały podczas gotowania.\n" +
                "\n" +
                "Kiedy już wszystkie gołąbki są zrobione - wychodzi ich co najmniej 2 warstwy, przygotowuję sos poprzez dokładne wymieszanie wszystkich jego składników. Sosem zalewam gołąbki i na wierzch kładę kilka liści kapusty. Gołąbki piekę około godziny.\n" +
                "\n" +
                "Można je również przygotować w garnku i gotować na średnim ogniu, co jakiś czas sprawdzając, czy się nie przypalają.\n" +
                "\n" +
                "Są gotowe, kiedy kapusta prawie miękka - ale nie powinna być rozgotowana, a sos gęsty.\n" +
                "\n" +
                "Pyszne z ziemniakami piure, albo z pszenną bułką. ",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Ryba po grecku","Latwy", "90 min", "kilogram filetów - mogą być jakiekolwiek, byleby bez ości\n" +
                "4 średniej wielkości marchewki - około pół kilograma\n" +
                "2 średniej wielkości pietruszki - około 20 dag\n" +
                "seler średniej wielkości - około 20 dag\n" +
                "3 średniej wielkości cebule\n" +
                "4 ziarna ziela angielskiego\n" +
                "2 liście laurowe\n" +
                "5 ziaren czarnego pieprzu\n" +
                "dwie czubate łyżki albo i trzy przecieru pomidorowego\n" +
                "pół szklanki oleju\n" +
                "sól\n" +
                "pieprz\n" +
                "sok z połowy cytryny", "To danie bardziej warzywne niż rybne. Doskonale na gorąco jak i na zimno. Nadają się do niego wszystkie ryby - nawet tej niby gorszej jakości wspaniale smakują.\n" +
                "\n" +
                "Filety ryby [jak były mrożone, to po rozmrożeniu] skrapiam sokiem z cytryny i odstawiam na bok.\n" +
                "\n" +
                "Czas na sos - a w zasadzie na warzywa. Cebulę obieram i kroję raczej w drobną kostkę.\n" +
                "\n" +
                "Pozostałe warzywa też obieram i ścieram na grubych oczkach [używam do tego malaksera, a jak go nie mam, to męczę się ze zwykłą tarką]. Na patelni rozgrzewam dwie łyżki oleju, wrzucam liście laurowe, ziele angielskie, pieprz w ziarenkach i smażę je przez około pół minuty. Teraz dodaję posiekaną cebulę i smażę ją, cały czas mieszając, aż stanie się szklista. Cebulę wraz z przyprawami wrzucam do garnka, w którym szklanka wody wraz z połówką kostki bulionowej. Garnek stawiam na ogień i zabieram się za warzywa.\n" +
                "\n" +
                "Podsmażam je przez kilka dwie - trzy minuty na patelni na silnie rozgrzanej oliwie - trzeba to robić partiami, z całą pewnością nie zmieszczą się za jednym razem. Warzywa powinny lekko zmienić kolor i stać się bardziej miękkie. Warzywa dorzucam do garnka, w którym cebula, dodaję przecier pomidorowy i gotuję na średnim ogniu, często mieszając, aż będą miękkie, i wody trochę odparuje - sos powinien być gesty i mocno pomidorowy. Warzywa doprawiam solą i pieprzem - jeśli są zbyt kwaśne, dodaję odrobinę cukru.\n" +
                "\n" +
                "Teraz czas na finisz - rybę wycieram z soku papierowym ręcznikiem, solę, pieprzę i smażę krótko na oleju, tak by przestała być surowa, a nie się zrumieniła. W dużym naczyniu żaroodpornym układam warstwę warzyw - około 1-2 cm grubości powinna mieć, Na warzywach kładę kawałki ryby, na rybę warzywa. Warstw zwykle bywa nie więcej niż 5 - na górze oczywiście warzywa. Naczynie przykrywam i wstawiam do piekarnika nagrzanego do 180 stopnie na około 40 minut - ten zabiega sprawi, iż warzywa będą rozkosznie miękkie, a ryba silnie przejdzie ich aromatem.\n" +
                "\n" +
                "Doskonałe na bardzo gorąco z bagietką i kieliszkiem różowego wina. Albo na zimno do kieliszka jeszcze zimniejszej przedniej wódki!",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Pierś kaczki z zielonymi hiszpańskimi oliwkami ","średni", "50 min", "2 piersi z kaczki, 15-20 dużych hiszpańskich oliwekbez pestek, 6 - 8 szalotek (można zastąpić 3 cebulami),1 szklanka wina typu moscatel (białe słodkie), 2 łyżki stołowe hiszpańskiej oliwy z oliwek, sól i pieprz. ", "Na skórze piersi zrób skośne nacięcia, tak, aby powstały romby. Posól i popieprz. Na rozgrzanej patelni z oliwą usmaż piersi zaczynając od strony ze skórą.Smaż do momentu kiedy piersi będą dobrze zrumienione po obu stronach. Wewnątrz pierś powinna zostać różowa. Zdejmij z patelni. Oliwki potnij na ćwiartki. Obierz szalotki, potnij je w ćwiartki i ręcznie rozwarstw na piórka. Na tej samej patelni zrumień szalotki. Następnie podlej winem i dodaj oliwki. Smaż jeszcze przez 2-3 minuty. Piersi podziel na filety i podawaj z gorącymi szalotkami i oliwkami. ",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Pierogi ruskie","średni", "120 min", "na farsz:\n" +
                "- 1 kg półtłustego białego sera (suchego, niemielonego!!!),\n" +
                "- 1,7 kg ziemniaków o suchej konsystencji i dużej zawartości skrobi np. gatunku Bryza lub gracja\n" +
                "- 3 średnie cebule,\n" +
                "- 4 łyżki margaryny,\n" +
                "- 1 łyżka soli do gotowania ziemniaków,\n" +
                "- sól i pieprz do smaku,\n" +
                "na ciasto:\n" +
                "- 1 kg maki pszennej,\n" +
                "- 1/2 l wody cieplej,\n" +
                "- 1 jajko,\n" +
                "- 2 łyżki oliwy lub oleju,\n" +
                "- 1/2 łyżeczki soli ", "Ziemniaki gotujemy z łyżką soli dzień wcześniej. Jeśli macie gatunek o dużej zawartości skrobi, mający tendencje do rozsypywania się w trakcie gotowania, to możecie ugotować je w \\\"mundurku\\\" i ostygnięte obrać. Wybierajcie ziemniaki średnie bez skaz o mniej więcej tej samej wielkości. Ugotowane ziemniaki odstawcie na noc nieprzykryte, mogą nawet lekko podeschnąć. Ser w kostce niemielony fabrycznie - najlepiej wybierajcie jak najtwardszy - oraz ziemniaki zmielcie na sitku o średnich oczkach. Cebule pokroić w drobna kostkę, zarumienić na margarynie na zloty kolor. Odsączyć całkowicie tłuszcz!!! - to ważne, gdyż tłuszcz rozrzedza farsz. \\\"Zagnieść\\\" farsz dokładnie ręką z odpowiednia ilością soli i świeżo mielonego pieprzu tak aby miał jednolita konsystencje - łyżką się niestety nie da bo farsz jest suchy i \\\"masny\\\". Dodać cebule i wymieszać - teraz już można łyżką ;D.\n" +
                "\n" +
                "Ja wyrabiam ciasto w garnku nie na stolnicy i potem je tam trzymam pod przykryciem by nie schło odcinając po kawałku. Wy możecie zrobić jak wolicie. Usypuję z 2/3 paczki mąki kopiec w środku robię dziurkę wlewam 2 łyżki oliwy, wpijam 1 jajko i dodaje 1/2 łyżeczki soli (solę lekko ciasto, gdyż nadwyżki ciasta rozwałkowuję i piekę podpłomyki na blaszy, moje dzieci uwielbiają je jeść z mlekiem :D ) . Rozprowadzam jajko w oliwie palcami żeby później równomiernie rozeszło się w cieście. mieszam jajko delikatnie ręką ruchem wirowym (można nożem siekając jeśli macie wprawę) stopniowo dodając wodę tak aby w miarę absorbowania maki nie tworzyły się twarde kluski, ciasto ma mieć cały czas konsystencje średnio -luźnego blotka. Kiedy większość maki zostanie wchłonięta (ciasto możne wam wchłonąć więcej wody niż podałam, 1/2 l to ilość orientacyjna!) przenieście je na stolnice oproszoną maka i wyrabiajcie dosypując maki w miarę jak ciasto będzie się nam stawało pod rekami wilgotne i trochę lepkie. Nie podsypujcie na raz zbyt dużo mąki bo trudno ja będzie wam wrobić. Kiedy wrobicie resztę pozostawionej mąki i ciasto będzie miało konsystencje plasteliny odetnijcie kawałek wielkości pieści. Z ciasta uformujcie palcami plaski krążek, rozwałkujcie na grubość 3mm smarując ciasto maka jak tylko zacznie sie lepić. Na wykrojone krążki, nakładam 2 łyżeczki farszu. Sklejam delikatnie ale nie na końcach rozpłaszczam lekko dłonią na stolnicy, żeby wyszło powietrze, dociskam brzegi. A teraz gotowanie, ważna cześć ceremoniału, która może zepsuć cały wysiłek. Bierzemy najszerszy garnek jaki macie w domu ja mam niezbyt wysoki rondel ale o średnicy 40 cm. Pierogi nie lubią ścisku wiec nie potrzebują głębokiego gara ale miejsca, kiedy wypłyną na wierzch nie mogą gotować sie jedne na drugich bo robi sie nam w garnku mamałyga. Mnie zwykle wchodzi do garnka 12, 13 pierogów. Wrzucamy pierogi do mocno gotującej sie, lekko osolonej wody, przykrywamy rondel pokrywka (gaz na full, największy palnik) czekamy az same wypłyną, nie mieszamy, kiedy pierogi wypłyną mieszamy je a jeśli któryś sie przykleił do dna delikatnie odrywamy go łyżka cedzakowa. Doprowadzamy pierogi do wżenia pod przykryciem po czym zmniejszamy całkowicie aby pierogi lekko \\\"mrugały\\\" i uchylamy przykrywkę. Gotujemy pierogi 5 min przewracając je ze 2 razy w trakcie. Ugotowane pierogi można poznać po tym że ciasto nam wyraźnie zbieleje, stanie się lśniące a brzegi lekko przeźroczyste. Pierogi wyjmujemy na durszlak przelewamy chłodną wodą, która nam zahartuje lekko ciasto dzięki czemu łatwiej nam będzie przełożyć pierogi. Pierogi natychmiast przekładamy na talerze aby się nie skleiły lub przelewamy tłuszczem.\n" +
                "\n" +
                "Wyśmienicie smakują z kefirem czy maślanka, moje dzieci uwielbiają maczać je w kwaśnej śmietanie. Na drugi dzień można usmażyć je na rumiano ",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Lasagne","średni", "120 min", "lazania - pudełko\n" +
                "mielone mięso - około trzy czwarte kilograma [kiedyś używałem wołowiny pół na pół z wieprzowiną, od niedawna z wiadomych powodów mieszam wieprzowinę z mielonym kurczakiem]\n" +
                "marchewka\n" +
                "cebula\n" +
                "seler\n" +
                "korzeń pietruszki\n" +
                "przecier pomidorowy\n" +
                "śmietana i jeszcze kilka rzeczy, które zawsze powinny być w lodówce ", "Potrawa to troszku skomplikowana i czasochłonna, ale zdecydowanie robiąca wrażenie na gościach.Podstawą dobrej lazanii jest... dobra lazania - znaczy się makaron. A można już, można kupić w sklepach dobrą lazanię - między innymi Malma [droga Malmo, czy ty wiesz, że tu twoja reklama?!] robi bardzo dobrą lazanię.\n" +
                "\n" +
                "Sekret tej potrawy tkwi w tym, by lazanii nie gotować, tylko zapiekać - dzięki temu zyska niepowtarzalnej faktury i pełnego smaku.\n" +
                "\n" +
                "Przygotowanie potrawy zaczynam od sprawdzenia jakiej jakości mam mięso - jeśli jest tłuste - a takie najczęściej mięso mielone można kupić w sklepie niestety, podsmażam je cały czas energicznie mieszając, by nie porobiły się zbyt duże grudy.\n" +
                "\n" +
                "Kiedy mięso całkowicie zmieni kolor ze swojego pierwotnego - znaczy się czerwono białego na bliżej nieokreślony kolor mięsa smażonego, wrzucam je do cedzaka i pozwalam odpłynąć tłuszczowi - robię to oczywiście w zlewie. Jeśli mięso nie jest zbyt tłuste to i tak usuwam w ten sposób nadmiar tłuszczu.\n" +
                "\n" +
                "Kiedy z mięsa odcieka tłuszcz, przygotowuję warzywa - ze dwie znaczniejsze cebule kroję na piórka i podsmażam do zeszklenia na oliwie. Tak samo czynię z dwoma marchewkami i jedną pietruszką oraz selerem - z tym, że te warzywa ścieram na tarce o najgrubszych oczkach.\n" +
                "\n" +
                "Mięso i warzywa wrzucam do dużego garnka, dolewam tyle wody by to wszystko przykryła, dodaję kilka łyżek przecieru pomidorowego, liść laurowy, ze 2 ziarnka ziela angielskiego. Teraz to wszystko gotuję na małym ogniu przez jakąś godzinę - często mieszam i uzupełniam wodę, bo się lubi przypalać, a przypalenizna to nie jest to co tygrysy lubią najbardziej.\n" +
                "\n" +
                "Kiedy zawartość garnka nabierze mniej więcej jednolitego aromatu, dodaję porządną porcję tłustej śmietany - jakąś szklankę. Żeby śmietana się nie \"zwarzyła\", przed wlaniem mieszam ją z kilkoma łyżkami zawartości garnka. To wszystko w garnku trzymam jeszcze na ogniu, aż będzie gęste - tak gęste, jak śmietana, która się tam wcześniej znalazła.\n" +
                "\n" +
                "Kiedy to się dzieje, przyrządzam sos - najpierw szklę na oliwie ze trzy cebule pokrojone dosyć drobno - kiedy cebula jest miękka, dodaję do niej przecier pomidorowy, trochę wody, pieprz, oregano, sól i odrobinę cukru do smaku. Duszę to wszystko do momentu, aż cebula będzie się \"rozłazić\" po naciśnięciu jej widelcem. Sos miksuję na jedwabistą masę za pomocą mechanicznego miksera. Sosu powinno być raczej dużo, a raczej zawsze go jest za mało. A tak na poważnie - powinna go być co najmniej połowa ilości mięsa w garnku.\n" +
                "\n" +
                "Czas na finiszowanie. Naczynie do zapiekania smaruję dokładnie masłem. Na dno wylewam kilka łyżek sosu, na który układam kawałki lazanii - staram się dokładnie zakryć dno. Lazanii oczywiście prosto z pudełka, surowej, łamliwej. Na lazanię wkładam trochę mięsa - nie rozkładam go zbyt dokładnie, bo po co? - jak nie jest zbyt równo wygląda przecież efektowniej.\n" +
                "\n" +
                "Na mięso ląduje następna porcja lazanii, na lazanii sos i da capo senza fina - na wierzchu znajduje się lazania, którą obficie polewam resztą sosu. I teraz ten myk, który sprawia, że danie będzie wspaniałe - lazanię odstawiam na jakieś pół godziny, by makaron nasiąkł sosem. Po tej pół godzinie potrawę posypuję startym żółtym serem i wstawiam do pieca. Zapiekam w temperaturze 160 stopni przez około 45 minut - ale jestem w tym przepisie dokładny, nieprawdaż - a tak naprawdę - czas pieczenia zależy od ilości warstw - im ich więcej, tym dłużej należy piec potrawę.\n" +
                "\n" +
                "Ta przygotowana lazania jest doskonała - makaron jest jędrny, ślicznie pofałdowany i ma swój smak - znaczy się odróżnia się znacznie od nadzienia.\n" +
                "\n" +
                "Do tego nic innego nie pasuje jak sałata z sosem vinegrette. W wersji burżujskiej do sałaty dodaję koreczki anchois - znaczy się maleńkie, okropnie słone rybeczki oraz oliwki zielone. A jak te oliwki w środku z migdałami, to mamy extra burżujską wersję. O winie chyba nie musze wspominać.",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Risotto ze szparagami","Latwy", "30 min", "1 i 1/2 szklanki ryżu arborio\n" +
                "pęczek zielonych szparagów (około 20 dag), mogą być również białe\n" +
                "średniej wielkości cebula\n" +
                "3-4 szklanki warzywnego bulionu (ostatecznie można użyć bulionu z kostki)\n" +
                "szczypta szafranu (nie jest konieczny, jego dodatek wpływa na kolor, smaku zaś praktycznie nie zmienia)\n" +
                "1 szklanka drobno startego parmezanu\n" +
                "2 czubate łyżki masła\n" +
                "łyżka oliwy\n" +
                "świeżo zmielony pieprz\n" +
                "sól ", "\n" +
                "    Ze szparagów odetnij stwardniałe końcówki, jeśli trzeba, obierz końce ze skóry. Pokrój na kawałki o długości 2-3 cm. Odziel kawałki łodyg od czubków.\n" +
                "    Zagotuj bulion, wrzuć kawałki łodyg szparagów i gotuj przez 2 minuty - powinny zostać jędrne. Wyjmij łyżką cedzakową i przełóż do miseczki. Do wrzącego bulionu dodaj teraz czubki szparagów - gotuj przez minutę, wyjmij i przełóż do drugiej miseczki.\n" +
                "    Obraną cebulą pokrój na drobną kostkę.\n" +
                "    Na patelni rozgrzej łyżkę masła z oliwą, dodaj cebulę i smaż na średnim ogniu 2-3 minuty, cały czas mieszając. Gdy cebula stanie się szklista (ale nie zrumieniona!) dodaj ryż. Całość mieszając smaż, aż wszystkie ziarenka pokryją się tłuszczem.\n" +
                "    Dodaj pierwszą szklankę bulionu i dalej gotuj na średnim ogniu cały czas mieszając, aż do wchłonięcia płynu. Wlewaj porcjami pozostały bulion - za każdym razem po wchłonięciu poprzedniej porcji.\n" +
                "    Po około 15-20 minutach takiego gotowania i mieszania czas by spróbować risotto - jeśli ryż jeszcze twardy, znak, że należy dodać trochę płynu i pogotować.\n" +
                "    Jeśli zaś jego twardość jest w sam raz (ziarenka powinny być jędrne) zestaw risotto z ognia, dodaję połowę parmezanu, kawałki szparagów oraz masło i odrobinę pieprzu, wymieszaj. Przykryj i pozostaw na 2 minuty, by smaki się połączyły.\n" +
                "    Porcje przełóż na talerze, posyp parmezanem i udekoruj czubkami szparagów.\n",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Bakłażan marynowany w chermouli","średbi", "140 min", "Składniki.\n" +
                "1 bakłażan\n" +
                "sól\n" +
                "oliwa z oliwek\n" +
                "\n" +
                "Chermoula.\n" +
                "1 łyżka kminku\n" +
                "1 łyżeczka cynamonu\n" +
                "1 łyżeczka ziela ang. mielonego\n" +
                "1/4 łyżeczki pieprzu cayenne\n" +
                "2 ząbki czosnku rozgniecione\n" +
                "3 łyżki soku z cytryny\n" +
                "4 łyżki oliwy z oliwek\n" +
                "3 łyżki kolendry świeżej, posiekanej\n" +
                "2 łyżki mięty świeżej, posiekanej", "Bakłażana pokroić w plastry, posolić i odstawić na 30minut.\n" +
                "Opłukać i osuszyć.\n" +
                "Plastry bakłażana dobrze przepędzlować oliwką i opiec na grillu\n" +
                "(patelni grillowej).\n" +
                "Osuszyć na papierze kuchennym.\n" +
                "Przygotować chermoulę --wymieszać wszystkie jej składniki.\n" +
                "Następnie plastry bakłażana wymieszać w chermouli i marynować przez 1 h\n" +
                "w lodówce.\n" +
                "Podajemy w temperaturze pokojowej. Wyśmienicie smakują z grzankami lub\n" +
                "po prostu na kawałku chleba.",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Krokiet z pajdy chleba","Latwy", "10 min", "1 pajda chleba\n" +
                "2 łyżki majonez\n" +
                "4 plastry ser żółty\n" +
                "2 plastry szynka wędzona\n" +
                "1 pomidor\n" +
                "chilli\n" +
                "1 jajko\n" +
                "bułka tarta\n" +
                "olej do smażenia", "Z pajdy pszennego chleba, odkroić skórkę, rozwałkować na folii spożywczej.\n" +
                "Tak przygotowany chleb, posmarować majonezem, rozłożyć żółty ser, oprószyć\n" +
                "chilli i położyć po dwa plasterki szynki wędzonej.\n" +
                "Pomagając sobie folią, zrolować.\n" +
                "Jajko roztrzepać, posolić i pędzlem posmarować nasze ruloniki z chleba, a\n" +
                "następnie obtoczyć w bułce tartej. Smażyć z każdej strony na oleju. Osączyć\n" +
                "na papierze kuchennym. Pokroić w plastry, podać z pomidorem.",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Żurek z leśnymi grzybami","Latwy", "190 min", "50 dag grzyby leśne\n" +
                "30 dag kiełbasa biała\n" +
                "10 dag szynka wiejska wędzona\n" +
                "2 cebule\n" +
                "5 ząbków czosnku\n" +
                "250 ml zakwas żurku\n" +
                "200 ml śmietana 18%\n" +
                "2 łyżki natka pietruszki\n" +
                "1,5 l bulion drobiowy\n" +
                "2 liść laurowy\n" +
                "5 ziaren ziele angielskie\n" +
                "sól\n" +
                "pieprz\n" +
                "majeranek\n" +
                "masło\n" +
                "olej do smażenia", "Do bulionu dodać liście laurowe i ziele angielskie i ugotować białą\n" +
                "kiełbasę. Wyjąć i pokroić w plasterki.\n" +
                "Czosnek, cebulę i szynkę wędzoną pokroić w kostkę i przesmażyć na maśle z\n" +
                "dodatkiem oleju, w trakcie smażenia dołożyć pokrojoną białą kiełbasę. Całość\n" +
                "dodać do gotującego sie na małym ogniu bulionu. Chwilę pogotować, dodać\n" +
                "zakwas.\n" +
                "Grzyby leśne pokroić na dosyć duże kawałki, przesmażyć na maśle z oliwą,\n" +
                "posolić, oprószyć świeżo zmielonym pieprzem i dodać do gotującej się zupy.\n" +
                "Gotujący się żurek doprawić do smaku, majerankiem i pieprzem. Śmietanę\n" +
                "wymieszać z kilkoma łyżkami zupy i połączyć z żurkiem. Doprowadzić do\n" +
                "zagotowania, ale ze śmietaną już nie gotować. Na koniec dodać natkę\n" +
                "pietruszki. Umrzyj, bo tu som muchomory, lol\n",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Barszcz dudkowy","Latwy", "50 min", "-Płucka(kupuję 1 płuco)\n" +
                "\n" +
                "-biały barszcz lub żurek (ja daję żurek z butelki)\n" +
                "\n" +
                "-majeranek\n" +
                "\n" +
                "-liść laurowy\n" +
                "\n" +
                "-czosnek\n" +
                "\n" +
                "-śmietana", "Płucka wołowe lub wieprzowe (mogą być cielęce, ale te są wyjatkowo delikatne smakowo), po dokładnym wymoczeniu w kilku zimnych wodach, gotuję je do miękkości, odcedzam .\n" +
                "\n" +
                "Wywar zostawiam, a płucka kroję w kostkę.\n" +
                "\n" +
                "Zagotowuję wywar , dodaję pokrojone płucka i zaprawiam albo białym barszczem lub żurkiem,\n" +
                "\n" +
                "dodatkowo przyprawiam; majeranek, czosnek, listek + zabielam kwaśną śmietaną.\n" +
                "====================\n" +
                "\n" +
                "Podaję go osobno z ziemniakami z przysmażoną cebulą.\n" +
                "\n" +
                "\n" +
                "\n" +
                "Zamiast żurku w torebce,wlałam trochę żurku z butelki. ",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Błyskawiczna zupa pomidorowa","Latwy", "20 min", "3 marchewki średniej wielkości (około 30 dag)\n" +
                "kawałek selera (około 15 dag)\n" +
                "2 korzenie pietruszki (około 20 dag)\n" +
                "biała część pora\n" +
                "3 czubate łyżki przecieru pomidorowego\n" +
                "1 łyżka masła\n" +
                "4 łyżki oleju słonecznikowego lub oliwy\n" +
                "1/4 szklanki słodkiej śmietanki\n" +
                "szczypta cukru\n" +
                "sól\n" +
                "świeżo zmielony czarny pieprz\n" +
                "\n" +
                "drobno posiekana natka pietruszki do podania", "\n" +
                "    Wszystkie warzywa obierz, opłucz, następnie drobno poszatkuj w malakserze, lub zetrzyj na tarce o grubych oczkach. Pora pokrój na cienkie plasterki.\n" +
                "    Zagotuj wodę w czajniku (możesz też użyć bulionu - ale nie z kostki).\n" +
                "    W dużym rondlu rozgrzej olej, wrzuć warzywa i cały czas mieszając smaż przez 4 minuty, aż staną się lekko szkliste. Wlej 4 szklanki wrzątku. Doprowadź do wrzenia i gotuj na średnim ogniu, aż warzywa będą prawie miękkie.\n" +
                "    W małej patelni rozpuść masło, dodaj przecier pomidorowy i cały czas mieszając smaż przez dwie minuty. Dodaj do zupy, wymieszaj i gotuj jeszcze kilka minut. Dopraw solą, pieprzem i szczyptą cukru.\n" +
                "    Zupę zestaw z ognia, dodaj śmietankę i wymieszaj. Odstaw na kilka minut.\n" +
                "    Podawaj udekorowaną natką pietruszki z ryżem lub makaronem. Świetnie smakuje także z czosnkowymi grzankami.\n",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Śniadaniowa sałatka jajeczna","Latwy", "30 min", "8 jajek\n" +
                "puszka kukurydzy (400 g)\n" +
                "puszka groszku (400 g)\n" +
                "mała cebula cukrowa\n" +
                "6 łyżek żółtego startego sera\n" +
                "4 łyżki majonezu\n" +
                "1/2 łyżeczki musztardy\n" +
                "sól\n" +
                "świeżo zmielony pieprz\n" +
                "\n" +
                "do podania:\n" +
                "drobno pokrojony szczypiorek ", "\n" +
                "    Jajka ugotuj na twardo (6 minut od zawrzenia wody), ostudź, obierz i pokrój na niezbyt drobną kostę (ja kroję jajka na ćwiartki, następnie każdą ćwiartkę na trzy kawałki).\n" +
                "    Groszek i kukurydzę odcedź z zalewy. Obraną cebulę pokrój na drobną kostkę.\n" +
                "    Majonez wymieszaj z musztardą, dopraw solą i pieprzem.\n" +
                "    Do miski włóż pokrojone jajka, dodaj groszek, kukurydzę, cebulę oraz sos. Wszystko dokładnie, ale delikatnie wymieszaj.\n" +
                "    Porcje sałatki wykładaj na talerze, każdą posyp żółtym serem i udekoruj szczypiorkiem.\n",R.drawable.ic_launcher_foreground);

        myDB.createPrzepis("Sałatka z grillowanej cukinii z halloumi","Latwy", "20 min", "cukinia o wadze około 20 dag\n" +
                "1 opakowanie sera halloumi (250g)\n" +
                "2 pomidory\n" +
                "\n" +
                "sos:\n" +
                "6 łyżek oliwy\n" +
                "sok z połowy cytryny\n" +
                "sól\n" +
                "świeżo zmielony czarny pieprz\n" +
                "1/2 łyżeczki cukru\n" +
                "2 łyżki wody mineralnej\n" +
                "\n" +
                "świeże listki bazylii do podania ", "\n" +
                "    Umytą cukinię pokrój na ukośne plastry o grubości 1 cm. Usmaż na lekko skropionej oliwą patelnii grillowej.\n" +
                "    Pomidory umyj, pokrój na plastry. Halloumi pokrój na drobną kostkę.\n" +
                "    Sos przygotuj poprzez dokładne wymieszanie wszystkich składników (np. w zakręconym słoiczku).\n" +
                "    Na talerzach rozłóż plastry cukinii, na nich ułóż plastry pomidorów, posyp kawałkami sera. Polej sosem i od razu podawaj.\n" +
                "    Smakuje pysznie z bagietką i biały, wytrawnym winem.\n" +
                "\n",R.drawable.ic_launcher_foreground);

        myDB.createPosilek("Sniadanie", 0, "11:00");
        myDB.createPosilek("Obiad", 1, "17:00");

        myDB.createSetting("telefon", "123456789");
        myDB.close();
    }

}
