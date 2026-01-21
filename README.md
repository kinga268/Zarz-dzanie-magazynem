# Unicorn Storage
System zarządzania magazynem.
## Opis projektu
Unicorn Storage to desktopowa aplikacja napisana w języku **Java** z wykorzystaniem **JavaFX** i **Scene Buildera**. Jej celem jest wspomaganie zarządzania danymi magazynowymi. 
Nasza aplikacja umożliwia przechowywanie, przeglądanie oraz wyszukiwanie informacji o produktach zapisanych w bazie danych **MySQL**.

Wszystkie operacje na danych realizowane są poprzez wysyłanie zapytań **SQL** (kwerend) do bazy danych. Aplikacja komunikuje się z serwerem za pomocą JDBC, co umożliwia bezpośrednie 
wykonywanie zapytań **SELECT* oraz filtrowanie danych po stronie bazy danych.

Nasze archiwum działa na serwerze obsługiwanym przez **PHP (XAMPP, phpMyAdmin)**, który odpowiada za przechowywanie i zarządzanie danymi. Aplikacja Java pełni rolę klienta, który wysyła zapytania do serwera i odbiera wyniki w czasie rzeczywistym. Główne elementy sterujące aplikacji zostały zrealizowane w postaci przycisków oraz pola wyszukiwania.
