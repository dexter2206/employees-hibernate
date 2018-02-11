# Employees - wersja z Hibernatem
## Wstęp
Repozytorium do zajęć z Hibernate. Do uruchomienia tego projektu nie trzeba żadnej dodatkowej bazy danych - przykładowa baza
powinna się utworzyć sama przy jego uruchomieniu. 
Baza danych używana w tym projekcie jest dużo prostsza niż ta używana na zajęciach z JDBC - jest to celowy zabieg, bo omawiane
zagadnienia są bardziej skomplikowane.
## Instalacja
1. Sklonuj repozytorium
2. Podmień następujące własności (w tagach "property") na odpowiadające połączeniu z Twoją bazą: hibernate.connection.url,
hibernate.connection.username, hibernate.connection.password
3. Zmień (chwilowo) propercję hbm2ddl.auto z "update" na "create"
4. Odpal klasę PrefillDB
5. Jeżeli wykonanie zakończyło się błędem - zgłoś to, w przeciwnym razie zmień z powrotem hbm2ddl.auto na update i zapomnij
w ogóle o klasie PrefillDB.
## Proponowane zadania związane z tym projektem
1. Napisać program wyświetlający najgorzej zarabiającego pracownika z każdego działu.
2. Napisać program wypisujący średnią zarobków z każdego z projektów.
3. Napisać program dodający nowy dział, oraz dwóch nowych pracowników do niego.
4. Napisać program dodający nowy projekt oraz dodanych w poprzednim punkcie pracowników do tego projektu.
5. Napisać program pobierający od użytkownika nazwę działu 
## Duże zadanie - Library
Proszę zaprojektować strukturę danych i stworzyć projekt, modelujący bazę danych książek, oraz aplikacje do interagowania z nim.
Projekt powinien wspierać odczytywanie i dodawanie takich informacji jak tytuły i autorów ksiażek, ich wydawnictwa oraz wydania.


