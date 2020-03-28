import java.io.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LoadDriver driver = new LoadDriver();
        driver.loadDriver();
        DatabaseConnect dbcon = new DatabaseConnect();
        Connection polaczenie = dbcon.connect();

        try {
            Statement polecenie = polaczenie.createStatement();
            DatabaseMetaData m = polaczenie.getMetaData();
            ResultSet rsm = m.getTables(null, null, "PRZEDMIOT", null);
            if (rsm.next()) {
                polecenie.executeQuery(Zapytania.dropTablePrzedmiot);
                System.out.println("Tabela Przedmiot usunięta.");
            }
            rsm = m.getTables(null, null, "NAUCZYCIEL", null);
            if (rsm.next()) {
                polecenie.executeQuery(Zapytania.dropTableNauczyciel);
                System.out.println("Tabela Nauczyciel usunięta.");
            }
            rsm = m.getTables(null, null, "UCZEN", null);
            if (rsm.next()) {
                polecenie.executeQuery(Zapytania.dropTableUczen);
                System.out.println("Tabela Uczeń usunięta.");
            }
            rsm = m.getTables(null, null, "OCENA", null);
            if (rsm.next()) {
                polecenie.executeQuery(Zapytania.dropTableOcena);
                System.out.println("Tabela Ocena usunięta.");
            }
            rsm = m.getTables(null, null, "OCENIANIE", null);
            if (rsm.next()) {
                polecenie.executeQuery(Zapytania.dropTableOcenianie);
                System.out.println("Tabela Ocenianie usunięta.");
            }
            rsm.close();

            polecenie.execute(Zapytania.createTablePrzedmiot);
            System.out.println("Tabela Przedmiot utworzona.");
            polecenie.execute(Zapytania.createTableNauczyciel);
            System.out.println("Tabela Nauczyciel utworzona.");
            polecenie.execute(Zapytania.createTableUczen);
            System.out.println("Tabela Uczeń utworzona.");
            polecenie.execute(Zapytania.createTableOcena);
            System.out.println("Tabela Ocena utworzona.");
            polecenie.execute(Zapytania.createTableOcenianie);
            System.out.println("Tabela Ocenianie utworzona.");

            polecenie.execute(Zapytania.insertToTablePrzedmiot1);
            polecenie.execute(Zapytania.insertToTablePrzedmiot2);
            polecenie.execute(Zapytania.insertToTablePrzedmiot3);
            polecenie.execute(Zapytania.insertToTablePrzedmiot4);

            polecenie.execute(Zapytania.insertToTableNauczyciel1);
            polecenie.execute(Zapytania.insertToTableNauczyciel2);
            polecenie.execute(Zapytania.insertToTableNauczyciel3);
            polecenie.execute(Zapytania.insertToTableNauczyciel4);

            polecenie.execute(Zapytania.insertToTableUczen1);
            polecenie.execute(Zapytania.insertToTableUczen2);
            polecenie.execute(Zapytania.insertToTableUczen3);
            polecenie.execute(Zapytania.insertToTableUczen4);

            polecenie.execute(Zapytania.insertToTableOcena1);
            polecenie.execute(Zapytania.insertToTableOcena2);
            polecenie.execute(Zapytania.insertToTableOcena3);
            polecenie.execute(Zapytania.insertToTableOcena4);
            System.out.println("Zakończono tworzenie i uzupełnianie tabel.");

            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String odpowiedz = "T";

            while (!(odpowiedz.equalsIgnoreCase("N"))) {

                System.out.println();
                System.out.println("Podaj idn (Identyfikator nauczyciela): ");
                String idn = bufferedReader.readLine();
                try {
                    Integer.parseInt(idn);
                } catch (Exception e) {
                    System.out.println("Wartość idn musi być liczbą! Wprowadz poprawną wartość.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od początku?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                }

                System.out.println();
                System.out.println("Podaj idu (Identyfikator ucznia): ");
                String idu = bufferedReader.readLine();
                try {
                    Integer.parseInt(idu);
                } catch (Exception e) {
                    System.out.println("Wartość idu musi być liczbą! Wprowadz poprawną wartość.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od początku?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                }

                System.out.println();
                System.out.println("Podaj idp (Identyfikator przedmiotu): ");
                String idp = bufferedReader.readLine();
                try {
                    Integer.parseInt(idp);
                } catch (Exception e) {
                    System.out.println("Wartość idp musi być liczbą! Wprowadz poprawną wartość.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od początku?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                }

                System.out.println();
                System.out.println("Podaj ido (Identyfikator oceny: ");
                String ido = bufferedReader.readLine();
                try {
                    Integer.parseInt(ido);
                } catch (Exception e) {
                    System.out.println("Wartość ido musi być liczbą! Wprowadz poprawną wartość.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od początku?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                }

                System.out.println();
                System.out.println("Podaj rodzaj oceny (C - cząstkowa, S - semestralna): ");
                String rodzajOceny = bufferedReader.readLine();

                if (rodzajOceny.equalsIgnoreCase("C") || rodzajOceny.equalsIgnoreCase("S")) {
                    System.out.println("Dane rodzaju oceny prawidłowe.");
                } else {
                    System.out.println("Dane rodzaju oceny nieprawidłowe! Wprowadz \"C\" lub \"S\".");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od początku?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                }

                System.out.println();
                System.out.println("---------------------------------------");
                System.out.println("Wprowadziłeś następujące dane:");
                System.out.println("Identyfikator nauczyciela: " + idn);
                System.out.println("Identyfikator ucznia: " + idu);
                System.out.println("Identyfikator przedmiotu: " + idp);
                System.out.println("Identyfikator oceny: " + ido);
                System.out.println("Rodzaj oceny: " + rodzajOceny);
                System.out.println();

                int integrityIdn = 0;
                int integrityIdu = 0;
                int integrityIdp = 0;
                int integrityIdo = 0;

                String idnQuery = "SELECT idn FROM nauczyciel WHERE idn = " + idn;
                ResultSet rs = polecenie.executeQuery(idnQuery);
                if (rs.next()) {
                    integrityIdn = 1;
                }

                String iduQuery = "SELECT idu FROM uczen WHERE idu = " + idu;
                ResultSet rs1 = polecenie.executeQuery(iduQuery);
                if (rs1.next()) {
                    integrityIdu = 1;
                }

                String idpQuery = "SELECT idp FROM przedmiot WHERE idp = " + idp;
                ResultSet rs2 = polecenie.executeQuery(idpQuery);
                if (rs2.next()) {
                    integrityIdp = 1;
                }

                String idoQuery = "SELECT ido FROM ocena WHERE ido = " + ido;
                ResultSet rs3 = polecenie.executeQuery(idoQuery);
                if (rs3.next()) {
                    integrityIdo = 1;
                }

                rs.close();
                rs1.close();
                rs2.close();
                rs3.close();

                if (integrityIdn == 0) {
                    System.out.println(
                            "Error report - ORA-02291: naruszono więzy spójności - nie znaleziono klucza nadrzędnego.");
                    System.out.println("Wprowadzony identyfikator nauczyciela nie istnieje w tabeli NAUCZYCIEL.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od nowa?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                } else if (integrityIdu == 0) {
                    System.out.println(
                            "Error report - ORA-02291: naruszono więzy spójności - nie znaleziono klucza nadrzędnego.");
                    System.out.println("Wprowadzony identyfikator ucznia nie istnieje w tabeli UCZEN.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od nowa?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                } else if (integrityIdp == 0) {
                    System.out.println(
                            "Error report - ORA-02291: naruszono więzy spójności - nie znaleziono klucza nadrzędnego.");
                    System.out.println("Wprowadzony identyfikator przedmiotu nie istnieje w tabeli PRZEDMIOT.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od nowa?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                } else if (integrityIdo == 0) {
                    System.out.println(
                            "Error report - ORA-02291: naruszono więzy spójności - nie znaleziono klucza nadrzędnego.");
                    System.out.println("Wprowadzony identyfikator oceny nie istnieje w tabeli OCENA.");
                    System.out.println();
                    System.out.println("Czy chcesz zacząć od nowa?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                    odpowiedz = bufferedReader.readLine();
                    continue;
                } else if (integrityIdn == 1 & integrityIdu == 1 & integrityIdp == 1 & integrityIdo == 1) {
                    System.out.println("Wprowadzone identyfikatory są poprawne");
                    polecenie.execute("INSERT INTO ocenianie (idp, idn, idu, ido, rodzaj_oceny) VALUES (" + idp + ", "
                            + idn + ", " + idu + ", " + ido + ", '" + rodzajOceny + "')");
                    System.out.println("Dodano wiersz do tabeli OCENIANIE.");
                }
                System.out.println();
                System.out.println("Czy chcesz dodać kolejny wiersz?: dowolna litera lub cyfra - TAK, N - ZAKONCZ");
                odpowiedz = bufferedReader.readLine();

                System.out.println();
            }

            polaczenie.close();
        } catch (SQLException e) {
            System.out.println("Nieudane połączenie z bazą danych!");
            e.printStackTrace();
            System.out.println("SQL except.: " + e.getMessage()); // komunikat
            System.out.println("SQL state  : " + e.getSQLState()); // kod standardowy
            System.out.println("Vendor errc: " + e.getErrorCode()); // kod zależny od RDBMS
            return;
        }

        System.out.println("Program zakonczony.");

    }
}

