import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SklepProduktyZapytania {
    private int idProduktu;


    public int wybierzProdukt() {
        Scanner scaner = new Scanner(System.in);

        int sterowanie;

        do {
            System.out.println("1. Wyświetl wszystkie produkty i podaj id");
            System.out.println("2. Podaj id produktu");
            System.out.println("3. Wstecz");
            sterowanie = scaner.nextInt();
            if (sterowanie == 1) {
                SklepMagazynZapytania.wyswietlIlosc();
                pobieranieID();
            } else if (sterowanie == 2) {
                pobieranieID();
            } else if (sterowanie == 3) {
                sterowanie = 7;
            } else {
                System.out.println("nie wybrano właściwej liczby");
                sterowanie = 10;
            }
        } while (sterowanie == 10);
        return sterowanie;
    }

    public void pobieranieID() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj ID: ");
        int id = scaner.nextInt();

        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_produkt, id_typ, id_producent FROM produkty WHERE id_produkt = " + id + ";");
            result.next();
            this.idProduktu = result.getInt("id_produkt");
        } catch (SQLException e) {
            System.out.println("Takiego konta nie mam w systemie");
        }
    }

    public void wyswietlProdukt(String wys) {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT " + wys + " FROM produkty WHERE id_produkt = " + idProduktu + ";");
            result.next();
            System.out.println(result.getString(1));
        } catch (SQLException e) {
            System.out.println("błąd");
        }
    }

    public void zmianaOpis() {
        Scanner scaner = new Scanner(System.in);
        wyswietlProdukt("opis");
        System.out.println("Podaj nowy opis: ");
        String opis = scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET opis = '" + opis + "' WHERE id_produkt = " + idProduktu + ";");
    }

    public void zmianaCeny() {
        Scanner scaner = new Scanner(System.in);
        wyswietlProdukt("cena");
        System.out.println("Podaj nową cene: ");
        try {
            double cena = scaner.nextDouble();
            ZapytaniaSQL.executeQuery("UPDATE produkty SET cena = " + cena + " WHERE id_produkt = " + idProduktu + ";");
        } catch (Exception e) {
            System.out.println("Operacja nie powiodła się ");
            System.out.println("Wartość musi być podana z przecinkiem");
            System.out.println();
        }

    }

    public void zmianaNazwy() {
        Scanner scaner = new Scanner(System.in);
        wyswietlProdukt("nazwa_produktu");
        System.out.println("Podaj nową nazwę produktu: ");
        String nazwa = scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET nazwa_produktu = '" + nazwa + "' WHERE id_produkt = " + idProduktu + ";");
    }

    public void zmianaKategori() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj id kategorii:");
        int id = scaner.nextInt();
        scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET id_typ=" + id + " WHERE id_produkt=" + idProduktu + "");
    }

    public void zmianaProducenta() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj id producenta:");
        int id = scaner.nextInt();
        scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET id_producent=" + id + " WHERE id_produkt=" + idProduktu + "");
    }

    public void dodajProdukt() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Wybierz kategorie z listy:");
        SklepKategorieProdukty.wyswietlKategorie();
        int idkategori = scaner.nextInt();
        scaner.nextLine();

        System.out.println("Wybierz producenta z listy:");
        SklepKategorieProdukty.wyswietlProducentow();
        int idproducent = scaner.nextInt();
        scaner.nextLine();

        System.out.println("Podaj nazwę produktu: ");
        String nazwa_produktu = scaner.nextLine();

        System.out.println("Podaj opis: ");
        String opis = scaner.nextLine();

        System.out.println("Podaj cene: ");
        try {
            double cena = scaner.nextDouble();
            scaner.nextLine();

            System.out.println("Podaj ilość sztuk w magazynie: ");
            int sztuki = scaner.nextInt();
            scaner.nextLine();

            ZapytaniaSQL.executeQuery("INSERT INTO produkty VALUES (NULL, " + idkategori + ", " + idproducent + ", '" + nazwa_produktu + "', '" + opis + "', " + cena + ", NULL, " + sztuki + ");");
        } catch (Exception e) {
            System.out.println("Operacja nie powiodła się ");
            System.out.println("Wartość musi być podana z przecinkiem");
            System.out.println();
        }
    }

    public void usunProdukt() {
        Scanner scaner = new Scanner(System.in);
        int sterowanie;
        String decyzja;
        do {
            sterowanie = 0;
            System.out.println("Czy na pewno chcesz usunąć produkt (TAK/NIE): ");
            decyzja = scaner.nextLine();
            if (decyzja.equals("TAK")) {
                ZapytaniaSQL.executeQuery("DELETE FROM produkty WHERE id_produkt = " + idProduktu + ";");
                System.out.println("Produkt został usunięty");
            } else if (decyzja.equals("NIE")) {
                System.out.println("Produkt nie został usunięty");
            } else {
                System.out.println("zła odpowiedz");
                sterowanie = 10;
            }
        } while (sterowanie == 10);
    }
}
