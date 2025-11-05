-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Lis 05, 2025 at 01:52 PM
-- Wersja serwera: 10.11.14-MariaDB-0+deb12u2
-- Wersja PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wiktorowski_projekt-programowanie`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `magazyn`
--

CREATE TABLE `magazyn` (
  `id` int(11) NOT NULL,
  `ilosc` int(11) NOT NULL,
  `ilosc_ostrzezenie` int(11) NOT NULL,
  `nazwa` varchar(200) NOT NULL,
  `producent` varchar(100) NOT NULL,
  `kategoria` varchar(100) NOT NULL,
  `podkategoria` varchar(100) NOT NULL,
  `opis` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `magazyn`
--

INSERT INTO `magazyn` (`id`, `ilosc`, `ilosc_ostrzezenie`, `nazwa`, `producent`, `kategoria`, `podkategoria`, `opis`) VALUES
(1, 13, 8, 'Zmywarka Beko HygieneIntense', 'Beko', 'AGD', 'Zmywarki', 'Wyższa temperatura'),
(2, 4, 8, 'Akcesorium Logitech M185 mysz', 'Logitech', 'Komputery', 'Akcesoria', 'Mały stan, mysz bezprzewodowa'),
(3, 18, 10, 'Wkrętarka Parkside PABS 12A', 'Parkside', 'Elektronarzędzia', 'Wkrętarki', 'Do podstawowych napraw'),
(4, 13, 10, 'Wkrętarka DeWalt DCD776', 'DeWalt', 'Elektronarzędzia', 'Wkrętarki', 'Z udarem do lżejszych kotew'),
(5, 0, 8, 'PC Dell Vostro MT', 'Dell', 'Komputery', 'PC', 'Stacjonarny do działu technicznego'),
(6, 15, 9, 'PC Dell Micro 7010', 'Dell', 'Komputery', 'PC', 'Mały, do szafek sterowniczych'),
(7, 5, 9, 'Wiertarka Parkside UD-13', 'Parkside', 'Elektronarzędzia', 'Wiertarki', 'Uniwersalna, mała ilość w magazynie'),
(8, 17, 10, 'Akcesorium Lenovo adapter USB-C', 'Lenovo', 'Komputery', 'Akcesoria', 'Do nowych laptopów'),
(9, 4, 9, 'Szlifierka Makita GA5030', 'Makita', 'Elektronarzędzia', 'Szlifierki', 'Do obróbki metalu, mały stan'),
(10, 15, 10, 'PC HP Compaq 600', 'HP', 'Komputery', 'PC', 'Do prostych aplikacji'),
(11, 14, 9, 'Mikrofalówka Samsung SlimFry', 'Samsung', 'AGD', 'Mikrofale', 'Do lekkiego smażenia'),
(12, 11, 9, 'Wkrętarka Bosch GSR 180', 'Bosch', 'Elektronarzędzia', 'Wkrętarki', 'Mocniejsza, 2 biegi'),
(13, 0, 9, 'Mikrofalówka Samsung MS23K3513', 'Samsung', 'AGD', 'Mikrofale', 'Do podgrzewania gotowych dań'),
(14, 5, 9, 'PC Lenovo Tiny M720q', 'Lenovo', 'Komputery', 'PC', 'Mała sztuka, mały stan'),
(15, 16, 10, 'Mikrofalówka Amica retro', 'Amica', 'AGD', 'Mikrofale', 'Do kuchni stylizowanych'),
(16, 14, 9, 'Laptop HP ZBook Firefly', 'HP', 'Komputery', 'Laptopy', 'Do pracy projektowej'),
(17, 16, 10, 'Zmywarka Whirlpool PowerClean', 'Whirlpool', 'AGD', 'Zmywarki', 'Dodatkowe dysze'),
(18, 16, 9, 'Wkrętarka DeWalt DCD796', 'DeWalt', 'Elektronarzędzia', 'Wkrętarki', 'Lżejsza, popularny model'),
(19, 13, 9, 'PC Dell OptiPlex 5090', 'Dell', 'Komputery', 'PC', 'Nowszy model biurowy'),
(20, 15, 10, 'PC HP ProDesk DM', 'HP', 'Komputery', 'PC', 'Mały desktop do kiosków'),
(21, 13, 9, 'Mikrofalówka Whirlpool MWP 253', 'Whirlpool', 'AGD', 'Mikrofale', 'Z grillem kwarcowym'),
(22, 14, 8, 'Akcesorium Logitech K120 klawiatura', 'Logitech', 'Komputery', 'Akcesoria', 'Prosta klawiatura USB do stanowisk'),
(23, 0, 10, 'Zmywarka Amica EGSPV', 'Amica', 'AGD', 'Zmywarki', 'Do małej zabudowy'),
(24, 13, 9, 'Wiertarka Makita DHP482', 'Makita', 'Elektronarzędzia', 'Wiertarki', 'Wersja popularna w serwisach'),
(25, 13, 9, 'Akcesorium HP klawiatura zestaw', 'HP', 'Komputery', 'Akcesoria', 'Dla nowych pracowników'),
(26, 14, 10, 'Wkrętarka Metabo BS 18', 'Metabo', 'Elektronarzędzia', 'Wkrętarki', 'Do prac serwisowych'),
(27, 15, 9, 'Szlifierka DeWalt DWE492', 'DeWalt', 'Elektronarzędzia', 'Szlifierki', 'Do cięższych prac'),
(28, 9, 7, 'Pralka Bosch Serie 6', 'Bosch', 'AGD', 'Pralki', 'Większa 8 kg'),
(29, 15, 9, 'Zmywarka Whirlpool SupremeClean', 'Whirlpool', 'AGD', 'Zmywarki', 'Czyszczenie intensywne'),
(30, 15, 9, 'Akcesorium Lenovo torba 15.6', 'Lenovo', 'Komputery', 'Akcesoria', 'Do wydawania z laptopami'),
(31, 16, 10, 'Akcesorium Kingston SSD 512GB', 'Kingston', 'Komputery', 'Akcesoria', 'Dodatkowy dysk do wymian'),
(32, 13, 9, 'Wkrętarka Makita DHP453', 'Makita', 'Elektronarzędzia', 'Wkrętarki', 'Do standardowych prac'),
(33, 12, 8, 'Laptop Dell Latitude 5520', 'Dell', 'Komputery', 'Laptopy', 'Dla serwisu mobilnego'),
(34, 13, 9, 'Wkrętarka Makita DF331', 'Makita', 'Elektronarzędzia', 'Wkrętarki', 'Do drewna i blachy'),
(35, 13, 9, 'Pralka Amica DAW 7123', 'Amica', 'AGD', 'Pralki', 'Polski model, 7 kg'),
(36, 13, 9, 'Wiertarka Makita MT-080', 'Makita', 'Elektronarzędzia', 'Wiertarki', 'Do majsterkowania'),
(37, 5, 9, 'Mikrofalówka Amica AMGF 20', 'Amica', 'AGD', 'Mikrofale', 'Model biurowy, niski stan'),
(38, 15, 10, 'Wiertarka Metabo BE 751', 'Metabo', 'Elektronarzędzia', 'Wiertarki', 'Regulacja obrotów, prace serwisowe'),
(39, 14, 10, 'Szlifierka Metabo W 750', 'Metabo', 'Elektronarzędzia', 'Szlifierki', 'Do cieńszych profili'),
(40, 10, 7, 'Pralka Beko SteamCure', 'Beko', 'AGD', 'Pralki', 'Para do odświeżania'),
(41, 14, 10, 'Wkrętarka DeWalt DCD708', 'DeWalt', 'Elektronarzędzia', 'Wkrętarki', 'Kompaktowa, 18V'),
(42, 17, 9, 'Wiertarka DeWalt XR Drill', 'DeWalt', 'Elektronarzędzia', 'Wiertarki', 'Seria XR, trwała'),
(43, 14, 9, 'Zmywarka Samsung WaterWall', 'Samsung', 'AGD', 'Zmywarki', 'Listwa wodna'),
(44, 11, 8, 'Mikrofalówka Bosch MS23', 'Bosch', 'AGD', 'Mikrofale', '23 l, do biura'),
(45, 10, 7, 'PC Lenovo ThinkCentre M710e', 'Lenovo', 'Komputery', 'PC', 'Do biura'),
(46, 15, 9, 'Mikrofalówka Whirlpool Jet Defrost', 'Whirlpool', 'AGD', 'Mikrofale', 'Szybkie rozmrażanie'),
(47, 13, 9, 'Wkrętarka Makita DDF482', 'Makita', 'Elektronarzędzia', 'Wkrętarki', 'Do drewna i płyt GK'),
(48, 17, 10, 'Szlifierka Metabo W 13-125', 'Metabo', 'Elektronarzędzia', 'Szlifierki', 'Do obróbki konstrukcji'),
(49, 11, 9, 'Wiertarka Bosch GSR 10', 'Bosch', 'Elektronarzędzia', 'Wiertarki', 'Lekka, poręczna'),
(50, 10, 8, 'Zmywarka Bosch Serie 6', 'Bosch', 'AGD', 'Zmywarki', 'Z oświetleniem wnętrza'),
(51, 11, 8, 'Mikrofalówka Bosch Serie 4', 'Bosch', 'AGD', 'Mikrofale', 'Łatwa obsługa'),
(52, 14, 10, 'Zmywarka Whirlpool WIO 3O33', 'Whirlpool', 'AGD', 'Zmywarki', 'Do zabudowy w słupku'),
(53, 12, 8, 'Pralka Beko WRE 6512', 'Beko', 'AGD', 'Pralki', 'Prosta automatyczna'),
(54, 13, 9, 'Zmywarka Samsung AutoOpen', 'Samsung', 'AGD', 'Zmywarki', 'Samoistne uchylenie drzwi'),
(55, 4, 9, 'Zmywarka Amica ZIM 428', 'Amica', 'AGD', 'Zmywarki', 'Wąska, mały stan'),
(56, 12, 9, 'Szlifierka Makita GA5040', 'Makita', 'Elektronarzędzia', 'Szlifierki', 'Antywibracyjna'),
(57, 13, 9, 'Akcesorium HP mysz przewodowa', 'HP', 'Komputery', 'Akcesoria', 'Do zestawów biurowych'),
(58, 9, 7, 'Pralka Bosch Serie 4 WAN2007', 'Bosch', 'AGD', 'Pralki', 'Do domu, 7 kg wsadu'),
(59, 13, 9, 'Laptop HP ProBook 450', 'HP', 'Komputery', 'Laptopy', 'Do działu administracji'),
(60, 12, 8, 'Laptop Lenovo Slim 7', 'Lenovo', 'Komputery', 'Laptopy', 'Do prezentacji'),
(61, 14, 9, 'Pralka Samsung WW8', 'Samsung', 'AGD', 'Pralki', 'Większy bęben'),
(62, 14, 10, 'Wiertarka Metabo SBE 650', 'Metabo', 'Elektronarzędzia', 'Wiertarki', 'Do wiercenia w stali do 13 mm'),
(63, 16, 10, 'Akcesorium HP hub USB 4-port', 'HP', 'Komputery', 'Akcesoria', 'Rozbudowa stanowisk'),
(64, 16, 10, 'Wiertarka Parkside PSBM 750', 'Parkside', 'Elektronarzędzia', 'Wiertarki', 'Domowe wiercenie w drewnie i stali'),
(65, 12, 8, 'Mikrofalówka Beko MWB 2310', 'Beko', 'AGD', 'Mikrofale', 'Z funkcją rozmrażania'),
(66, 15, 10, 'Zmywarka Samsung AquaIntense', 'Samsung', 'AGD', 'Zmywarki', 'Mocne mycie garnków'),
(67, 11, 8, 'Pralka Bosch WAN2820', 'Bosch', 'AGD', 'Pralki', 'Standardowy model'),
(68, 15, 9, 'Wkrętarka DeWalt DCD701', 'DeWalt', 'Elektronarzędzia', 'Wkrętarki', 'Kompakt do ciasnych miejsc'),
(69, 14, 10, 'Mikrofalówka Amica AMMF20', 'Amica', 'AGD', 'Mikrofale', 'Do kuchni socjalnych'),
(70, 11, 8, 'Zmywarka Beko CornerIntense', 'Beko', 'AGD', 'Zmywarki', 'Mycie w rogach'),
(71, 5, 9, 'Wkrętarka Parkside PAS 12', 'Parkside', 'Elektronarzędzia', 'Wkrętarki', 'Zapasowa, niski stan'),
(72, 12, 8, 'PC Lenovo M75s', 'Lenovo', 'Komputery', 'PC', 'Do magazynu, pod systemy'),
(73, 12, 8, 'Wkrętarka Bosch GSR 120', 'Bosch', 'Elektronarzędzia', 'Wkrętarki', 'Do skręcania mebli'),
(74, 18, 10, 'Akcesorium Logitech słuchawki H390', 'Logitech', 'Komputery', 'Akcesoria', 'Do rozmów online'),
(75, 17, 10, 'Wkrętarka Metabo LTX 18', 'Metabo', 'Elektronarzędzia', 'Wkrętarki', 'Mocniejsza, dla fachowca'),
(76, 10, 7, 'Pralka Bosch WAN2829', 'Bosch', 'AGD', 'Pralki', 'Cicha, do mieszkań'),
(77, 15, 9, 'Laptop Dell G15', 'Dell', 'Komputery', 'Laptopy', 'Mocniejszy, testy oprogramowania'),
(78, 12, 9, 'Wiertarka Bosch GSB 16 RE', 'Bosch', 'Elektronarzędzia', 'Wiertarki', 'Udar, szybkozaciskowy uchwyt'),
(79, 5, 9, 'Szlifierka Parkside PWS 700', 'Parkside', 'Elektronarzędzia', 'Szlifierki', 'Ma zapas części, niski stan'),
(80, 14, 10, 'Zmywarka Amica DIM 636', 'Amica', 'AGD', 'Zmywarki', 'Do mniejszych kuchni'),
(81, 12, 8, 'PC Lenovo Edge', 'Lenovo', 'Komputery', 'PC', 'Uniwersalny biurowy'),
(82, 4, 9, 'Akcesorium Lenovo zasilacz 65W', 'Lenovo', 'Komputery', 'Akcesoria', 'Zapasowy do serwisu'),
(83, 16, 10, 'Wkrętarka Parkside Perf 20', 'Parkside', 'Elektronarzędzia', 'Wkrętarki', 'Do użytku domowego'),
(84, 13, 10, 'Szlifierka DeWalt DWE4057', 'DeWalt', 'Elektronarzędzia', 'Szlifierki', 'Do prac serwisowych'),
(85, 14, 10, 'Mikrofalówka Whirlpool Crisp', 'Whirlpool', 'AGD', 'Mikrofale', 'Do zapiekanek'),
(86, 14, 9, 'Laptop HP Pavilion 14', 'HP', 'Komputery', 'Laptopy', 'Domowy multimedialny'),
(87, 12, 9, 'Szlifierka Bosch GWS 11-125', 'Bosch', 'Elektronarzędzia', 'Szlifierki', 'Mocniejsza do stali'),
(88, 13, 9, 'Pralka Whirlpool TDLR 60210', 'Whirlpool', 'AGD', 'Pralki', 'Ładowana od góry'),
(89, 11, 8, 'Mikrofalówka Bosch z grillem', 'Bosch', 'AGD', 'Mikrofale', 'Dla pracowników'),
(90, 15, 9, 'Laptop Dell Vostro 3510', 'Dell', 'Komputery', 'Laptopy', 'Do małej firmy'),
(91, 19, 10, 'Akcesorium Kingston czytnik kart', 'Kingston', 'Komputery', 'Akcesoria', 'Do zgrywania danych'),
(92, 16, 10, 'Wiertarka Parkside PBD 100', 'Parkside', 'Elektronarzędzia', 'Wiertarki', 'Zapas do magazynu gospodarczego'),
(93, 11, 8, 'Laptop Dell Latitude 5410', 'Dell', 'Komputery', 'Laptopy', 'Biznesowy, do pracy w terenie'),
(94, 13, 9, 'Szlifierka Makita GA6021', 'Makita', 'Elektronarzędzia', 'Szlifierki', 'Do większych tarcz'),
(95, 12, 9, 'Wkrętarka Bosch GSR 12V-15', 'Bosch', 'Elektronarzędzia', 'Wkrętarki', 'Mała, lekka, do szafek'),
(96, 3, 8, 'Pralka Beko WUE6511', 'Beko', 'AGD', 'Pralki', 'Podstawowa, wąska, mały stan'),
(97, 11, 8, 'Szlifierka Bosch Professional 900', 'Bosch', 'Elektronarzędzia', 'Szlifierki', 'Do intensywnej pracy'),
(98, 18, 10, 'Wiertarka Metabo Profi 800', 'Metabo', 'Elektronarzędzia', 'Wiertarki', 'Do metalu i konstrukcji'),
(99, 15, 10, 'Zmywarka Amica DIM 437', 'Amica', 'AGD', 'Zmywarki', 'Zmywarka 45 cm'),
(100, 12, 8, 'Laptop Lenovo ThinkPad L14', 'Lenovo', 'Komputery', 'Laptopy', 'Trwała obudowa, praca serwisowa'),
(101, 11, 8, 'PC Dell Precision SFF', 'Dell', 'Komputery', 'PC', 'Do CAD o mniejszej skali'),
(102, 14, 9, 'Pralka Amica DreamWash', 'Amica', 'AGD', 'Pralki', 'Do mniejszych rodzin'),
(103, 16, 10, 'PC Lenovo ThinkStation kompakt', 'Lenovo', 'Komputery', 'PC', 'Do zadań technicznych'),
(104, 13, 9, 'Szlifierka Makita 9558HN', 'Makita', 'Elektronarzędzia', 'Szlifierki', 'Korpus smukły, wygodny'),
(105, 14, 9, 'Akcesorium Dell soundbar', 'Dell', 'Komputery', 'Akcesoria', 'Dodatkowe audio do monitorów'),
(106, 15, 10, 'Mikrofalówka Amica AMG20', 'Amica', 'AGD', 'Mikrofale', 'Do gospodarstwa domowego'),
(107, 18, 10, 'Akcesorium Logitech kamera C270', 'Logitech', 'Komputery', 'Akcesoria', 'Do wideokonferencji'),
(108, 11, 8, 'Zmywarka Bosch SilencePlus', 'Bosch', 'AGD', 'Zmywarki', 'Cicha praca'),
(109, 10, 7, 'PC Lenovo ThinkCentre M720s', 'Lenovo', 'Komputery', 'PC', 'Komputer biurowy SFF'),
(110, 11, 8, 'Szlifierka Bosch GWS 750', 'Bosch', 'Elektronarzędzia', 'Szlifierki', 'Kątowa 125 mm do cięcia'),
(111, 12, 8, 'Pralka Samsung EcoBubble', 'Samsung', 'AGD', 'Pralki', 'Technologia piany'),
(112, 15, 10, 'Wkrętarka Metabo BS 14.4', 'Metabo', 'Elektronarzędzia', 'Wkrętarki', 'Do serwisu urządzeń'),
(113, 4, 8, 'Laptop Lenovo Yoga 7', 'Lenovo', 'Komputery', 'Laptopy', '2w1, dotykowy, niski stan'),
(114, 16, 10, 'Szlifierka Parkside PWS 1000', 'Parkside', 'Elektronarzędzia', 'Szlifierki', 'Uniwersalna, dla majsterkowicza'),
(115, 15, 10, 'Akcesorium Dell P2219H monitor', 'Dell', 'Komputery', 'Akcesoria', 'Monitor do biura 22 cale'),
(116, 12, 8, 'Zmywarka Beko Fast+', 'Beko', 'AGD', 'Zmywarki', 'Szybsze programy'),
(117, 11, 8, 'Pralka Beko EWUE 6511', 'Beko', 'AGD', 'Pralki', 'Do gospodarstw domowych'),
(118, 10, 7, 'Laptop HP 255 G9', 'HP', 'Komputery', 'Laptopy', 'Do podstawowych zadań'),
(119, 12, 8, 'Wiertarka Bosch EasyImpact', 'Bosch', 'Elektronarzędzia', 'Wiertarki', 'Do domu, z udarem'),
(120, 14, 9, 'PC HP 400 G9', 'HP', 'Komputery', 'PC', 'Do pracy z dokumentami'),
(121, 4, 9, 'Wkrętarka Makita DF457D', 'Makita', 'Elektronarzędzia', 'Wkrętarki', '18V, mało w magazynie'),
(122, 15, 9, 'Wiertarka DeWalt DWD112', 'DeWalt', 'Elektronarzędzia', 'Wiertarki', 'Bezudarowa, serwisowa'),
(123, 15, 10, 'Szlifierka Parkside PWS 125', 'Parkside', 'Elektronarzędzia', 'Szlifierki', 'Domowe cięcie płytek i stali'),
(124, 11, 8, 'Pralka Samsung WW70TA026', 'Samsung', 'AGD', 'Pralki', 'Silnik inwerterowy'),
(125, 18, 10, 'Wiertarka Parkside B2 Pro', 'Parkside', 'Elektronarzędzia', 'Wiertarki', 'Do gospodarstwa i warsztatu'),
(126, 14, 10, 'PC Lenovo V530s', 'Lenovo', 'Komputery', 'PC', 'Do pracy z bazami'),
(127, 12, 9, 'Zmywarka Samsung DW60', 'Samsung', 'AGD', 'Zmywarki', 'Do zabudowy'),
(128, 15, 10, 'Wkrętarka Parkside PABS 20-Li', 'Parkside', 'Elektronarzędzia', 'Wkrętarki', 'Do gospodarstwa'),
(129, 12, 8, 'Mikrofalówka Beko z panelem dotykowym', 'Beko', 'AGD', 'Mikrofale', 'Prosta obsługa'),
(130, 14, 9, 'Akcesorium Dell klawiatura multimedialna', 'Dell', 'Komputery', 'Akcesoria', 'Dla użytkowników multimediów'),
(131, 9, 6, 'Laptop Lenovo V15 G3', 'Lenovo', 'Komputery', 'Laptopy', 'Nowa rewizja, biurowy'),
(132, 12, 9, 'Szlifierka Bosch GWS 880', 'Bosch', 'Elektronarzędzia', 'Szlifierki', 'Silniejsza, 880 W'),
(133, 11, 8, 'Laptop Dell XPS 13', 'Dell', 'Komputery', 'Laptopy', 'Smukły, premium'),
(134, 16, 10, 'Akcesorium Kingston SSD 1TB', 'Kingston', 'Komputery', 'Akcesoria', 'Do magazynu części'),
(135, 16, 9, 'Szlifierka DeWalt DWE4206', 'DeWalt', 'Elektronarzędzia', 'Szlifierki', 'Do cięcia i fazowania'),
(136, 3, 8, 'PC HP ProDesk 400 G6', 'HP', 'Komputery', 'PC', 'Niski stan, uzupełnić'),
(137, 11, 8, 'Mikrofalówka Bosch FEM513', 'Bosch', 'AGD', 'Mikrofale', 'Do zabudowy'),
(138, 15, 9, 'Pralka Whirlpool FreshCare', 'Whirlpool', 'AGD', 'Pralki', 'Funkcja odświeżania'),
(139, 17, 10, 'Wkrętarka Metabo PowerMaxx', 'Metabo', 'Elektronarzędzia', 'Wkrętarki', 'Mała, instalatorska'),
(140, 11, 8, 'Laptop Lenovo IdeaPad 3', 'Lenovo', 'Komputery', 'Laptopy', 'Dla studentów'),
(141, 12, 8, 'Mikrofalówka Beko MGF23', 'Beko', 'AGD', 'Mikrofale', 'Do podgrzewania w kuchni'),
(142, 4, 8, 'Mikrofalówka Beko MOC20100', 'Beko', 'AGD', 'Mikrofale', 'Podstawowy model, mały stan'),
(143, 15, 10, 'Wiertarka DeWalt DCD776', 'DeWalt', 'Elektronarzędzia', 'Wiertarki', 'Do konstrukcji drewnianych'),
(144, 15, 9, 'Pralka Whirlpool Supreme Care', 'Whirlpool', 'AGD', 'Pralki', 'Do częstego prania'),
(145, 3, 8, 'Wiertarka Makita HP1640', 'Makita', 'Elektronarzędzia', 'Wiertarki', 'Z udarem, do betonu i cegły'),
(146, 16, 9, 'Laptop Lenovo Legion 5', 'Lenovo', 'Komputery', 'Laptopy', 'Do zadań wymagających mocy'),
(147, 13, 9, 'Wiertarka Makita HP1631K', 'Makita', 'Elektronarzędzia', 'Wiertarki', 'Do wiercenia w murze'),
(148, 12, 9, 'PC Dell OptiPlex 3070', 'Dell', 'Komputery', 'PC', 'Do biura, z SSD'),
(149, 9, 6, 'Laptop Lenovo V15 G2', 'Lenovo', 'Komputery', 'Laptopy', 'Do biura, 8 GB RAM'),
(150, 15, 10, 'Mikrofalówka Samsung MC28', 'Samsung', 'AGD', 'Mikrofale', 'Tryb pieczenia'),
(151, 16, 10, 'Pralka Amica AutoSense', 'Amica', 'AGD', 'Pralki', 'Dopasowuje wodę'),
(152, 18, 10, 'Szlifierka Parkside PWS Pro', 'Parkside', 'Elektronarzędzia', 'Szlifierki', 'Do amatorskich napraw'),
(153, 12, 8, 'Pralka Whirlpool FWSL 61053', 'Whirlpool', 'AGD', 'Pralki', 'Do małej łazienki'),
(154, 19, 10, 'Akcesorium Kingston pendrive 64GB', 'Kingston', 'Komputery', 'Akcesoria', 'Nośnik na backupy'),
(155, 14, 8, 'Akcesorium Logitech K280e klawiatura', 'Logitech', 'Komputery', 'Akcesoria', 'Cichsza klawiatura biurowa'),
(156, 15, 9, 'Akcesorium Dell U2419H monitor', 'Dell', 'Komputery', 'Akcesoria', 'Do stanowisk graficznych'),
(157, 3, 8, 'Zmywarka Beko DFN26420', 'Beko', 'AGD', 'Zmywarki', 'Mały stan, popularna'),
(158, 10, 8, 'Zmywarka Bosch SMS25', 'Bosch', 'AGD', 'Zmywarki', '60 cm, do kuchni'),
(159, 13, 9, 'PC Lenovo ThinkCentre M920', 'Lenovo', 'Komputery', 'PC', 'Dla działu księgowości'),
(160, 4, 8, 'Pralka Amica AWN 610D', 'Amica', 'AGD', 'Pralki', 'Starszy model, mały stan'),
(161, 12, 8, 'Wkrętarka Bosch GSB 180-LI', 'Bosch', 'Elektronarzędzia', 'Wkrętarki', 'Z udarem do montażu'),
(162, 14, 10, 'Wiertarka DeWalt DWD024', 'DeWalt', 'Elektronarzędzia', 'Wiertarki', 'Mocniejsza do warsztatu'),
(163, 15, 10, 'Szlifierka Metabo W 1100', 'Metabo', 'Elektronarzędzia', 'Szlifierki', 'Do tarcz 125 mm'),
(164, 13, 9, 'Zmywarka Whirlpool WFC3', 'Whirlpool', 'AGD', 'Zmywarki', 'Automatyczne programy'),
(165, 15, 9, 'PC Dell OptiPlex Micro', 'Dell', 'Komputery', 'PC', 'Do montażu za monitorem'),
(166, 13, 9, 'Laptop Lenovo ThinkPad E15', 'Lenovo', 'Komputery', 'Laptopy', 'Do pracy zdalnej'),
(167, 17, 10, 'Szlifierka Metabo W 850-125', 'Metabo', 'Elektronarzędzia', 'Szlifierki', 'Do zakładu'),
(168, 14, 10, 'PC HP EliteDesk 800', 'HP', 'Komputery', 'PC', 'Do pracy ciągłej'),
(169, 14, 9, 'Pralka Samsung AddWash', 'Samsung', 'AGD', 'Pralki', 'Dodawanie prania w trakcie'),
(170, 16, 10, 'Mikrofalówka Whirlpool Supreme Chef', 'Whirlpool', 'AGD', 'Mikrofale', 'Do gotowania na parze'),
(171, 17, 10, 'Wiertarka Metabo BE 1100', 'Metabo', 'Elektronarzędzia', 'Wiertarki', 'Mocniejsza, warsztatowa'),
(172, 11, 8, 'Zmywarka Bosch Serie 2', 'Bosch', 'AGD', 'Zmywarki', 'Podstawowy model'),
(173, 10, 7, 'Laptop Dell Inspiron 15', 'Dell', 'Komputery', 'Laptopy', 'Do domu i internetu'),
(174, 13, 9, 'Mikrofalówka Samsung TDS', 'Samsung', 'AGD', 'Mikrofale', 'Równomierne grzanie'),
(175, 14, 9, 'Laptop HP EliteBook 840', 'HP', 'Komputery', 'Laptopy', 'Lekki, biurowy'),
(176, 11, 8, 'PC HP 280 G5', 'HP', 'Komputery', 'PC', 'Do sekretariatu'),
(177, 17, 10, 'Akcesorium Lenovo stacja dokująca', 'Lenovo', 'Komputery', 'Akcesoria', 'Do laptopów firmowych'),
(178, 14, 10, 'Szlifierka DeWalt DWE4217', 'DeWalt', 'Elektronarzędzia', 'Szlifierki', 'Do serwisu i budowy'),
(179, 2, 7, 'Laptop HP 250 G8', 'HP', 'Komputery', 'Laptopy', 'Podstawowy, mała ilość'),
(180, 12, 8, 'Wiertarka Bosch GSB 13', 'Bosch', 'Elektronarzędzia', 'Wiertarki', 'Do lekkich prac montażowych'),
(181, 5, 8, 'PC Lenovo H412', 'Lenovo', 'Komputery', 'PC', 'Komputer osobisty');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `magazyn`
--
ALTER TABLE `magazyn`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `magazyn`
--
ALTER TABLE `magazyn`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=182;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
