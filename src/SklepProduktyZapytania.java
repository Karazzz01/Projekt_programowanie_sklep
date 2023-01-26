import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SklepProduktyZapytania {
    private int idProduktu;
    private int idKategoria;
    private int idProducent;


    public void wybierzProdukt() {

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
            }
            if (sterowanie == 2) {
                pobieranieID();
            }
            if (sterowanie == 3) {
                sterowanie = 2;
            } else {
                System.out.println("nie wybrono właściwej liczby");
            }
        } while (sterowanie != 1 && sterowanie != 2);
    }

    public void pobieranieID() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj ID:");
        int id = scaner.nextInt();

        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_produkt, id_typ, id_producent FROM produkty WHERE id_produkt = " + id + ";");
            result.next();
            this.idProduktu = result.getInt("id_produkt");
            this.idKategoria = result.getInt("id_typ");
            this.idProducent = result.getInt("id_producent");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Takiego konta nie mam w systemie");
        }
    }

    public void wyswietlProdukt(String wys) {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT " + wys + " FROM produkty WHERE id_produkt = " + idProduktu + ";");
            result.next();
            System.out.println(result.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
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
        double cena = scaner.nextDouble();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET cena = " + cena + " WHERE id_produkt = " + idProduktu + ";");
    }

    public void zmianaNazwy() {
        Scanner scaner = new Scanner(System.in);
        wyswietlProdukt("nazwa_produktu");
        System.out.println("Podaj nową nazwę produktu: ");
        String nazwa = scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET nazwa_produktu = '" + nazwa + "' WHERE id_produkt = " + idProduktu + ";");
    }

    public void zmianaProducent() {
        Scanner scaner = new Scanner(System.in);
        wyswietlProdukt("nazwa_produktu");
        System.out.println("Podaj nową nazwę produktu: ");
        String nazwa = scaner.nextLine();
        ZapytaniaSQL.executeQuery("UPDATE produkty SET nazwa_produktu = '" + nazwa + "' WHERE id_produkt = " + idProduktu + ";");
    }

    public void wyswietlKategorie() {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_typ, nazwa_typu FROM typ_produktu");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dodajKategorie() {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Podaj nazwę kategori");
        String kategoria = scaner.nextLine();
        ZapytaniaSQL.executeQuery("INSERT INTO typ_produktu VALUES (NULL, '" + kategoria + "')");
    }
//    public void dodajProdukt(){
//        Scanner scaner = new Scanner(System.in);
//        String producent = scaner.nextLine();
//        String  = scaner.nextLine();
//    }

}

