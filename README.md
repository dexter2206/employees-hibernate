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
