# Unicorn Storage
System zarządzania magazynem.
## Opis projektu
Unicorn Storage to desktopowa aplikacja napisana w języku **Java** z wykorzystaniem **JavaFX** i **Scene Buildera**. Jej celem jest wspomaganie zarządzania danymi magazynowymi. 
Nasza aplikacja umożliwia przechowywanie, przeglądanie oraz wyszukiwanie informacji o produktach zapisanych w bazie danych **MySQL**.

### Działanie aplikacji
Wszystkie operacje na danych realizowane są poprzez wysyłanie zapytań **SQL** (kwerend) do bazy danych. Aplikacja komunikuje się z serwerem za pomocą JDBC, co umożliwia bezpośrednie 
wykonywanie zapytań **SELECT* oraz filtrowanie danych po stronie bazy danych.
Poniższy link przekierowuje do bazy danych:

`https://projekt-programowanie.5v.pl/?fbclid=IwY2xjawPgNVtleHRuA2FlbQIxMQBzcnRjBmFwcF9pZAEwAAEeru4lkuzMZ5LnA4bhvnotGjSlZuLvyGrn_KcGHS9SigV2Unlw5x8qSYqQ9gE_aem_rXUC4bEyJJMaGXBGIV1VtQ`

Nasze archiwum działa na serwerze obsługiwanym przez **PHP (XAMPP, phpMyAdmin)**, który odpowiada za przechowywanie i zarządzanie danymi. Aplikacja Java pełni rolę klienta, który wysyła zapytania do serwera i odbiera wyniki w czasie rzeczywistym. Główne elementy sterujące aplikacji zostały zrealizowane w postaci przycisków oraz pola wyszukiwania.
Dane pobierane z bazy prezentowane są w komponencie TableView, a mechanizm wyszukiwania umożliwia automatyczne filtrowanie rekordów na podstawie fraz wpisywanych przez użytkownika.

W trakcie wpisywania tekstu apliakcja wysyła zapytania SQL do załączonej bazy danych umożliwiając wyszukiwanie produktów m.in po:
- nazwie
- producencie
- kategorii
- podkategorii
- ilości
- ID

  #### Przycisk Ostrzeżenia
  Przycisk służy do wyświetlenia produktów, których stan magazynowy spełnia warunki ostrzegawcze tzn. mają niski poziom ilości. Po jego użyciu aplikacja wykonuje odpowiednie zapytanie do SQL, filtrując rekordy.
  <img width="598" height="111" alt="image" src="https://github.com/user-attachments/assets/eea6e633-166d-4b08-b6b1-b6fad950e762" />

  #### Przycisk Braki
  Przycisk umożliwia szybkie wyświetlanie prduktów, których ilość w magazynie wynosi zero. Funkcja ta pozwala na bieżące monitorowanie braków magazynowych i ułatwia planowanie uzupełnień.
  
  <img width="380" height="108" alt="image" src="https://github.com/user-attachments/assets/db7912f8-7afb-4282-96fb-79d9915b101d" />

  #### Przycisk Reset
  Przycisk przywraca domyślny widok tabeli, usuwając wszystkie aktywne filtry. Po jego użyciu aplikacja ponownie pobiera pełny zestaw danych.
  
  <img width="255" height="111" alt="image" src="https://github.com/user-attachments/assets/dae2db71-7698-4ee2-a2b0-ae02de328f43" />


### Technologie użyte w projekcie
- Java
- JavaFX
- FXML
- MySQL
- PHP
- Maven
- Scene Builder

