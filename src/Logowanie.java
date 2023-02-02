import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Logowanie {
    public static void logowanie() {
        String login, haslo, hasloZwrot, loginZwrot;

        int menu = 0;

        Scanner scaner = new Scanner(System.in);

        do {

            System.out.println("Podaj login:");
            login = scaner.nextLine();

            System.out.println("Podaj hasło:");
            haslo = scaner.nextLine();

            try {

                ResultSet result = ZapytaniaSQL.executeSelect("SELECT nazwa_uzytkownika, haslo FROM uzytkownicy WHERE nazwa_uzytkownika = '" + login + "' AND haslo='" + haslo + "';");
                result.next();

                loginZwrot = result.getString("nazwa_uzytkownika");
                hasloZwrot = result.getString("haslo");

                if (login.equals(loginZwrot) && haslo.equals(hasloZwrot)) {
                    System.out.println("Udało sie");
                    menu = 0;
                }

            } catch (SQLException error) {
                System.out.println("Złe dane");

                menu = 1;
            }
        } while (menu == 1);
    }
}
