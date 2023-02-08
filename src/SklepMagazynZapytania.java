import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SklepMagazynZapytania {
    public static void wyswietIloscWKategori() {

        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT nazwa_typu, SUM(sztuki) FROM produkty INNER JOIN typ_produktu on typ_produktu.id_typ = produkty.id_typ GROUP BY nazwa_typu;");
            while (result.next()) {
                System.out.println(result.getString(1) + " " + result.getString(2) + " sztuk");
            }
        } catch (SQLException error) {
            System.out.println("error");
        }
    }

    public static void wyswietlIlosc() {
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT id_produkt, nazwa_producenta, nazwa_produktu, sztuki FROM produkty INNER JOIN producent ON producent.id_producent=produkty.id_producent;");
            while (result.next()) {
                System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3) + " " + result.getString(4) + " sztuk");
            }
        } catch (SQLException error) {
            System.out.println("error");
        }
    }

    public static void stanAutomat() {
        System.out.println("Te produkty niedługo się skończą");
        try {
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT nazwa_producenta, nazwa_produktu, sztuki FROM produkty INNER JOIN producent ON producent.id_producent=produkty.id_producent WHERE sztuki < 3;");
            while (result.next()) {
                System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " sztuk");
            }
        } catch (SQLException error) {
            System.out.println("error");
        }
    }

    public static void dostawa() {
        Scanner scaner = new Scanner(System.in);

        System.out.println("Podaj id produktu do dostawy: ");
        int id = scaner.nextInt();
        scaner.nextLine();

        System.out.println("Podaj ilość produktów do dostawy:");
        int ilosc = scaner.nextInt();
        scaner.nextLine();

        ZapytaniaSQL.executeQuery("UPDATE produkty SET sztuki = sztuki + " + ilosc + " WHERE id_produkt = " + id + ";");
    }

}
