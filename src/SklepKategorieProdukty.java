import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SklepKategorieProdukty {
    public static void wyswietlKategorie() {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_typ, nazwa_typu FROM typ_produktu");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("błąd");
        }
    }

    public static void wyswietlProducentow() {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_producent, nazwa_producenta FROM producent");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("błąd");
        }
    }

    public static void dodajKategorie() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj nazwę kategorii: ");
        String kategoria = scaner.nextLine();
        ZapytaniaSQL.executeQuery("INSERT INTO typ_produktu VALUES (NULL, '" + kategoria + "')");
    }

    public static void dodajProducenta() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj nazwę producenta: ");
        String producent = scaner.nextLine();
        ZapytaniaSQL.executeQuery("INSERT INTO producent VALUES (NULL, '" + producent + "')");
    }

    public static void edycjaProducenta() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj id producenta: ");
        int id = scaner.nextInt();
        scaner.nextLine();
        System.out.println("Podaj nową nazwę producenta: ");
        String producent = scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE producent SET nazwa_producenta = '" + producent + "' WHERE id_producent = " + id + ";");
    }

    public static void edycjaKategori() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj id kategorii: ");
        int id = scaner.nextInt();
        scaner.nextLine();
        System.out.println("Podaj nową nazwę kategorii: ");
        String kategoria = scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE typ_produktu SET nazwa_typu = '" + kategoria + "' WHERE id_typ = " + id + ";");
    }

    public static void usunKategorie() {
        Scanner scaner = new Scanner(System.in);
        int sterowanie;
        System.out.println("Podaj id kategorii do usunięcia: ");
        int id = scaner.nextInt();
        scaner.nextLine();
        System.out.println("Usunięcie kategorii spowoduje usunięcie powiazanych z nią produktów");
        String decyzja;
        do {
            sterowanie = 0;
            System.out.println("Czy na pewno chcesz usunąć kategorię (TAK/NIE): ");
            decyzja = scaner.nextLine();
            if (decyzja.equals("TAK")) {
                ZapytaniaSQL.executeQuery("DELETE FROM typ_produktu WHERE id_typ = " + id + ";");
                System.out.println("Kategoria została usunięta");
            } else if (decyzja.equals("NIE")) {
                System.out.println("Kategoria nie została usunięta");
            } else {
                System.out.println("zła odpowiedz");
                sterowanie = 10;
            }
        } while (sterowanie == 10);
    }

    public static void usunProducent() {
        Scanner scaner = new Scanner(System.in);
        int sterowanie;
        System.out.println("Podaj id producenta do usunięcia: ");
        int id = scaner.nextInt();
        scaner.nextLine();
        System.out.println("Usunięcie producenta spowoduje usunięcie powiazanych z nim produktów");
        String decyzja;
        do {
            sterowanie = 0;
            System.out.println("Czy na pewno chcesz usunąć producenta (TAK/NIE): ");
            decyzja = scaner.nextLine();
            if (decyzja.equals("TAK")) {
                ZapytaniaSQL.executeQuery("DELETE FROM producent WHERE id_producent = " + id + ";");
                System.out.println("Producent został usunięty");
            } else if (decyzja.equals("NIE")) {
                System.out.println("Producent nie został usunięty");
            } else {
                System.out.println("zła odpowiedz");
                sterowanie = 10;
            }
        } while (sterowanie == 10);
    }
}
