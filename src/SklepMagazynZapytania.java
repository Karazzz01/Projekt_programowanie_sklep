import java.sql.ResultSet;
import java.sql.SQLException;

public class SklepMagazynZapytania {
    public static void wyswietlIloscWKategori() {

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
            ResultSet result = ZapytaniaSQL.executeSelect("SELECT nazwa_producenta, nazwa_produktu, sztuki FROM produkty INNER JOIN producent ON producent.id_producent=produkty.id_producent;");
            while (result.next()) {
                System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3) + " sztuk");
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

}

