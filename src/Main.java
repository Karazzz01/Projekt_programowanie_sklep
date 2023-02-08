import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sterowanie;
        Scanner scaner = new Scanner(System.in);
        Logowanie.logowanie();

        do {
            System.out.println("Witaj w panelu!");
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
                    System.out.println("2. Naprawa sprzętu");
                    System.out.println("3. Rejest napraw");
                    System.out.println("4. Raport dochodów");
                    System.out.println("5. Wstecz");
                    System.out.println();
                    System.out.println("Podaj opcje z menu(1-5):");
                    sterowanie = scaner.nextInt();
                    switch (sterowanie) {
                        case 1:
                            SerwisZapytania.dodawanieSerwis();
                            break;
                        case 2:
                            SerwisZapytania.wyswietSerwis("do naprawy");
                            SerwisZapytania.naprawa();
                            break;
                        case 3:
                            do {
                                System.out.println("1. Po naprawie");
                                System.out.println("2. Do naprawy");
                                System.out.println("3. Wszystkie");
                                System.out.println("4. Wstecz");
                                System.out.println();
                                System.out.println("Podaj opcje z menu(1-4):");
                                sterowanie = scaner.nextInt();
                                switch (sterowanie) {
                                    case 1:
                                        SerwisZapytania.wyswietSerwis("zrobione");
                                        break;
                                    case 2:
                                        SerwisZapytania.wyswietSerwis("do naprawy");
                                        break;
                                    case 3:
                                        SerwisZapytania.wyswietSerwisCaly();
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
            } else if (sterowanie == 2) {
                do {
                    SklepProduktyZapytania SklepZapytania = new SklepProduktyZapytania();

                    System.out.println("1. Sprawdzenie stanu magazynowego");//sklep magazyn
                    System.out.println("2. Zarządzanie produktami w sklepie");//sklep produkty
                    System.out.println("3. Dodanie/usunięcie/edycja kategorii");
                    System.out.println("4. Dodanie/usunięcie/edycja producenta");
                    System.out.println("5. Dodanie produktu do sklepu");
                    System.out.println("6. Wstecz");
                    System.out.println();
                    System.out.println("Podaj opcje z menu(1-6):");
                    sterowanie = scaner.nextInt();
                    switch (sterowanie) {
                        case 1:
                            do {
                                System.out.println("1. Wyświetl ilość poszczególnych produktów");
                                System.out.println("2. Wyświetl ilość produktów w danej kategorii");
                                System.out.println("3. Automatyczne sprawdzenie magazynu");
                                System.out.println("4. Dostawa produktu");
                                System.out.println("5. Wstecz");
                                System.out.println();
                                System.out.println("Podaj opcje z menu(1-5):");
                                sterowanie = scaner.nextInt();
                                switch (sterowanie) {
                                    case 1:
                                        SklepMagazynZapytania.wyswietlIlosc();
                                        break;
                                    case 2:
                                        SklepMagazynZapytania.wyswietIloscWKategori();
                                        break;
                                    case 3:
                                        SklepMagazynZapytania.stanAutomat();
                                        break;
                                    case 4:
                                        SklepMagazynZapytania.dostawa();
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
                                sterowanie = SklepZapytania.wybierzProdukt();
                                if (sterowanie != 7) {
                                    System.out.println("1. Zmiana opisu");
                                    System.out.println("2. Zmiana ceny");
                                    System.out.println("3. Zmiana nazwy");
                                    System.out.println("4. Zmiana producenta");
                                    System.out.println("5. Zmiana kategorii");
                                    System.out.println("6. Usunięcie produktu");
                                    System.out.println("7. Wstecz");
                                    System.out.println();
                                    System.out.println("Podaj opcje z menu(1-7):");
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
                                            SklepKategorieProdukty.wyswietlProducentow();
                                            SklepZapytania.zmianaProducenta();
                                            break;
                                        case 5:
                                            SklepKategorieProdukty.wyswietlKategorie();
                                            SklepZapytania.zmianaKategori();
                                            break;
                                        case 6:
                                            SklepZapytania.usunProdukt();
                                            sterowanie = 7;
                                            break;
                                        case 7:
                                            sterowanie = 7;
                                            break;
                                        default:
                                            System.out.println("Niepoprawna liczba");
                                    }
                                }
                            } while (sterowanie != 7);
                            break;
                        case 3:
                            do {
                                System.out.println("1. Dodaj nową kategorię");
                                System.out.println("2. Usuń kategorię");
                                System.out.println("3. Edytuj kategorię");
                                System.out.println("4. Wstecz");
                                System.out.println();
                                System.out.println("Podaj opcje z menu(1-4):");
                                sterowanie = scaner.nextInt();
                                switch (sterowanie) {
                                    case 1:
                                        SklepKategorieProdukty.dodajKategorie();
                                        break;
                                    case 2:
                                        SklepKategorieProdukty.wyswietlKategorie();
                                        SklepKategorieProdukty.usunKategorie();
                                        break;
                                    case 3:
                                        SklepKategorieProdukty.wyswietlKategorie();
                                        SklepKategorieProdukty.edycjaKategori();
                                        break;
                                    case 4:
                                        sterowanie = 4;
                                        break;
                                    default:
                                        System.out.println("Niepoprawna liczba:");
                                }
                            } while (sterowanie != 4);
                            break;
                        case 4:
                            do {
                                System.out.println("1. Dodaj nowego producenta");
                                System.out.println("2. Usuń producenta");
                                System.out.println("3. Edytuj producenta");
                                System.out.println("4. Wstecz");
                                System.out.println();
                                System.out.println("Podaj opcje z menu(1-3):");
                                sterowanie = scaner.nextInt();
                                switch (sterowanie) {
                                    case 1:
                                        SklepKategorieProdukty.dodajProducenta();
                                        break;
                                    case 2:
                                        SklepKategorieProdukty.wyswietlProducentow();
                                        SklepKategorieProdukty.usunProducent();
                                        break;
                                    case 3:
                                        SklepKategorieProdukty.wyswietlProducentow();
                                        SklepKategorieProdukty.edycjaProducenta();
                                        break;
                                    case 4:
                                        sterowanie = 4;
                                        break;
                                    default:
                                        System.out.println("Niepoprawna liczba:");
                                }
                            } while (sterowanie != 4);
                            break;
                        case 5:
                            SklepZapytania.dodajProdukt();
                            break;
                        case 6:
                            sterowanie = 6;
                            break;
                        default:
                            System.out.println("Niepoprawna liczba");
                    }
                } while (sterowanie != 6);
            } else if (sterowanie == 3) {
                System.out.println("Do widzenia");
            } else {
                System.out.println("niepoprawne dane");
            }
        } while (sterowanie != 3);
    }
}