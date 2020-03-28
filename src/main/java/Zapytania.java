public class Zapytania {
    static String dropTablePrzedmiot = "DROP TABLE przedmiot";
    static String dropTableNauczyciel = "DROP TABLE nauczyciel";
    static String dropTableUczen = "DROP TABLE uczen";
    static String dropTableOcena = "DROP TABLE ocena";
    static String dropTableOcenianie = "DROP TABLE ocenianie";

    static String createTablePrzedmiot = "CREATE TABLE przedmiot (idp integer not null, nazwa_przedmiotu char(20) not null)";
    static String createTableNauczyciel = "CREATE TABLE nauczyciel (idn integer not null, nazwisko_nauczyciela char(30) not null, imie_nauczyciela char(20) not null)";
    static String createTableUczen = "CREATE TABLE uczen (idu integer not null, nazwisko_ucznia char(30) not null, imie_ucznia char(20) not null)";
    static String createTableOcena = "CREATE TABLE ocena (ido integer not null, wartosc_opisowa char(20) not null, wartosc_numeryczna float not null)";
    static String createTableOcenianie = "CREATE TABLE ocenianie (idp integer not null, idn integer not null, idu integer not null, ido integer not null, rodzaj_oceny char(1) not null)";

    static String insertToTablePrzedmiot1 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (1, 'MATEMATYKA')";
    static String insertToTablePrzedmiot2 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (2, 'FIZYKA')";
    static String insertToTablePrzedmiot3 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (3, 'CHEMIA')";
    static String insertToTablePrzedmiot4 = "INSERT INTO przedmiot (idp, nazwa_przedmiotu) VALUES (4, 'BIOLOGIA')";

    static String insertToTableNauczyciel1 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (1, 'KOWALSKI', 'JAN')";
    static String insertToTableNauczyciel2 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (2, 'NOWAK', 'STEFAN')";
    static String insertToTableNauczyciel3 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (3, 'MALINOWSKI', 'JAKUB')";
    static String insertToTableNauczyciel4 = "INSERT INTO nauczyciel (idn, nazwisko_nauczyciela, imie_nauczyciela) VALUES (4, 'PIOTROWSKA', 'ANNA')";

    static String insertToTableUczen1 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (1, 'OLEKSIK', 'MACIEJ')";
    static String insertToTableUczen2 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (2, 'BIERNACKI', 'BOGDAN')";
    static String insertToTableUczen3 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (3, 'KRAWCZYK', 'MATEUSZ')";
    static String insertToTableUczen4 = "INSERT INTO uczen (idu, nazwisko_ucznia, imie_ucznia) VALUES (4, 'KOWALSKA', 'ZUZANNA')";

    static String insertToTableOcena1 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (1, 'PIĘĆ', 5.0)";
    static String insertToTableOcena2 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (2, 'CZTERY', 4.0)";
    static String insertToTableOcena3 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (3, 'DWA', 2.0)";
    static String insertToTableOcena4 = "INSERT INTO ocena (ido, wartosc_opisowa, wartosc_numeryczna) VALUES (4, 'TRZY I PÓŁ', 3.5)";
}
