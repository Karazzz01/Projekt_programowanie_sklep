import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sklep informatyczny");
        System.out.println();
        System.out.println("Logowanie...");

        Logowanie.logowanie();

        int menu = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1. Sklep");
            System.out.println("2. Serwis");
            System.out.println("3. Wyjście");

            menu = scanner.nextInt();

            if (menu == 1) {
                System.out.println("1. Stan magazynowy produtków");
                System.out.println("2. Stan magazynowy produtków");
                System.out.println("3. Stan magazynowy produtków");

                menu = scanner.nextInt();

                //sklep
            } else if (menu == 2) {

                //serwis

            } else if (menu == 3) {
                break;
            } else {
                System.out.println("Podaj właściwą opcję");
                menu = 0;
            }

        } while (menu == 0);


        try {
            ResultSet resultSet = ZapytaniaSQL.executeSelect("SELECT id_produkt, id_typ, id_producent, nazwa_produktu, opis, cena, sztuki FROM produkty");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("nazwa_produktu") + " " + resultSet.getString("cena") + " " + resultSet.getInt("sztuki"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
