import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sklep informatyczny");
        System.out.println("Logowanie");
        System.out.println();

        int sterowanie;

        Scanner scaner = new Scanner(System.in);

        Logowanie.logowanie();

        do {
            System.out.println("Witaj w panelu");
            System.out.println();
            System.out.println("1. Panel serwisu");
            System.out.println("2. Administracja sklepem");
            System.out.println("3. Wyjscie");
            System.out.println();
            System.out.println("Podaj opcje z menu(1-3):");
            sterowanie = scaner.nextInt();

            if (sterowanie == 1) {
                do {
                    System.out.println("1. Przyjęcie zamówiena naprawy");
                    System.out.println("2. Naprawa sprzetu");
                    System.out.println("3. Rejest napraw");
                    System.out.println("4. Raport");
                    System.out.println("5. Wstecz");
                    System.out.println();
                    System.out.println("Podaj opcje z menu(1-5):");

                    sterowanie = scaner.nextInt();

                    switch (sterowanie) {
                        case 1:
                            SerwisZapytania.dodawanieSerwis();
                            break;
                        case 2:
                            SerwisZapytania.wyswietlSerwis("do naprawy");
                            SerwisZapytania.naprawa();
                            break;
                        case 3:
                            do {
                                System.out.println("1. Po naprawie");
                                System.out.println("2. Do naprawy");
                                System.out.println("3. Wszystkie");
                                System.out.println("4. Wstecz");

                                sterowanie = scaner.nextInt();

                                switch (sterowanie) {
                                    case 1:
                                        SerwisZapytania.wyswietlSerwis("zrobione");
                                        break;
                                    case 2:
                                        SerwisZapytania.wyswietlSerwis("do naprawy");
                                        break;
                                    case 3:
                                        SerwisZapytania.wyswietlSerwisCaly();
                                        break;
                                    case 4:
                                        sterowanie = 4;
                                        break;
                                    default:
                                        System.out.println("Niepoprawna liczba");
                                }
                            } while (sterowanie != 4);
                            break;
                        case 4:
                            SerwisZapytania.raport(1);
                            SerwisZapytania.raport(3);
                            SerwisZapytania.raport(6);
                            break;
                        case 5:
                            sterowanie = 5;
                            break;
                        default:
                            System.out.println("Niepoprawna liczba");
                    }
                } while (sterowanie != 5);
            }
            if (sterowanie == 2) {
                do {
                    System.out.println("1. Sprawdzenie stanu magazynowego");
                    System.out.println("2. Zarzadzanie produktami w sklepie");
                    System.out.println("3. Ustawianie promocji");
                    System.out.println("4. Wstecz");
                    System.out.println();
                    System.out.println("Podaj opcje z menu(1-4):");

                    sterowanie = scaner.nextInt();

                    switch (sterowanie) {
                        case 1:
                            do {
                                System.out.println("1. Wyświetl ilość poszczególnych produktów");
                                System.out.println("2. Wyświetl ilość produktów w danej kategorii");
                                System.out.println("3. Automatyczne sprawdzenie magazynu");
                                System.out.println("4. Dostawa produktu");
                                System.out.println("5. Wstecz");

                                sterowanie = scaner.nextInt();

                                switch (sterowanie) {
                                    case 1:
                                        SklepMagazynZapytania.wyswietlIlosc();
                                        break;
                                    case 2:
                                        SklepMagazynZapytania.wyswietlIloscWKategori();
                                        break;
                                    case 3:
                                        SklepMagazynZapytania.stanAutomat();
                                        break;
                                    case 4:
                                        //
                                        break;
                                    case 5:
                                        sterowanie = 5;
                                        break;
                                    default:
                                        System.out.println("Niepoprawna liczba");
                                }
                            } while (sterowanie != 5);
                            break;
                        case 2:
                            do {
                                SklepProduktyZapytania SklepZapytania = new SklepProduktyZapytania();
                                SklepZapytania.wybierzProdukt();

                                System.out.println("1. Zamiana opisu");
                                System.out.println("2. Zmiana ceny");
                                System.out.println("3. Zmiana nazwy");
                                System.out.println("4. Zmiana producenta");
                                System.out.println("5. Dodawanie nowego produktu");
                                System.out.println("6. Dodanie nowej kategorii");
                                System.out.println("7. Wstecz");

                                sterowanie = scaner.nextInt();

                                switch (sterowanie) {
                                    case 1:
                                        SklepZapytania.zmianaOpis();
                                        break;
                                    case 2:
                                        SklepZapytania.zmianaCeny();
                                        break;
                                    case 3:
                                        SklepZapytania.zmianaNazwy();
                                        break;
                                    case 4:
                                        //
                                        break;
                                    case 5:
                                        //
                                        break;
                                    case 6:
                                        SklepZapytania.wyswietlKategorie();
                                        SklepZapytania.dodajKategorie();
                                        break;
                                    case 7:
                                        sterowanie = 7;
                                        break;
                                    default:
                                        System.out.println("Niepoprawna liczba");
                                }
                            } while (sterowanie != 5);
                            break;
                        case 3:

                            break;
                        case 4:
                            sterowanie = 5;
                            break;
                        default:
                            System.out.println("Niepoprawna liczba");
                    }
                } while (sterowanie != 5);
            } else {
                System.out.println("niepoprawne dane");
            }
        } while (sterowanie != 1 && sterowanie != 2);
    }
}