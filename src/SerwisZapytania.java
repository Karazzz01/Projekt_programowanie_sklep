import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class SerwisZapytania {
    public static void dodawanieSerwis() {
        Scanner scaner = new Scanner(System.in);

        String nazwa_produktu, usterka, status, imie, nazwisko, nr_tel;
        int id = 0, id_serwis = 0;

        System.out.println("Podaj nazwe produktu");
        nazwa_produktu = scaner.nextLine();

        System.out.println("Opis usterki");
        usterka = scaner.nextLine();

        System.out.println("Dane klienta");
        System.out.println("Imie");
        imie = scaner.nextLine();

        System.out.println("Nazwisko");
        nazwisko = scaner.nextLine();

        System.out.println("Numer telefonu");
        nr_tel = scaner.nextLine();

        status = "do naprawy";

        LocalDateTime czasDodania = LocalDateTime.now();

        ZapytaniaSQL.executeQuery("INSERT INTO klienci VALUES( NULL,'" + imie + "','" + nazwisko + "','" + nr_tel + "');");

        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT MAX(id_klient) FROM klienci;");
            result.next();
            id = result.getInt(1);
            System.out.println(id);
        } catch (SQLException error) {
            System.out.println("blond");
        }

        ZapytaniaSQL.executeQuery("INSERT INTO serwis VALUES (NULL, " + id + ", '" + nazwa_produktu + "', '" + usterka + "', NULL, '" + czasDodania + "', NULL, '" + status + "', NULL);");

        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT MAX(id_serwis) FROM serwis;");
            result.next();
            id_serwis = result.getInt(1);
            System.out.println(id_serwis);
        } catch (SQLException error) {
            System.out.println("blond");
        }

        System.out.println("Dodano zlecenie naprawy o numerze ewidencyjnym: " + id_serwis);
    }

    public static void wyswietlSerwis(String status) {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_serwis, nazwa_produktu, usterka, status_nap, koszt FROM serwis WHERE status_nap='" + status + "';");
            while (result.next()) {
                System.out.println(result.getInt("id_serwis") + " " + result.getString("nazwa_produktu") + " " + result.getString("usterka") + " " + result.getDouble("koszt") + " PLN " + result.getString("status_nap"));
            }
        } catch (SQLException error) {
            System.out.println("error");
        }
    }

    public static void wyswietlSerwisCaly() {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_serwis, nazwa_produktu, usterka, status_nap FROM serwis");
            while (result.next()) {
                System.out.println(result.getInt("id_serwis") + " " + result.getString("nazwa_produktu") + " " + result.getString("usterka") + " " + result.getString("status_nap"));
            }
        } catch (SQLException error) {
            System.out.println("error");
        }
    }

    public static void naprawa() {
        Scanner scaner = new Scanner(System.in);

        String usterka;
        int id;
        double koszt;

        System.out.println("Podaj id sprzetu do naprawy");
        id = scaner.nextInt();
        scaner.nextLine();

        System.out.println("Opis usterki: " + " ");
        usterka = scaner.nextLine();

        System.out.println("Koszt naprawy");
        koszt = scaner.nextDouble();

        LocalDateTime czasNaprawy = LocalDateTime.now();

        ZapytaniaSQL.executeQuery("UPDATE serwis SET opis_naprawy='" + usterka + "', czas_ukonczenia='" + czasNaprawy + "', status_nap='zrobione', koszt=" + koszt + " WHERE id_serwis = " + id + ";");
    }

    public static void raport(int okres) {

        LocalDateTime dataOkres = LocalDateTime.now();

        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT SUM(koszt) FROM serwis WHERE czas_ukonczenia > '" + dataOkres.minusMonths(okres) + "'");
            while (result.next()) {
                System.out.println("Suma z " + okres + " miesiąca: " + result.getDouble(1));
            }
        } catch (SQLException error) {
            System.out.println("error");
        }
    }
}

