import java.util.ArrayList;
import java.util.Scanner;

public class NumeryczneCalkowanieTest {
    public static void main(String[] args) {

        while (true) {

            double x=0;

            NumeryczneCalkowanie numeryczneCalkowanie = new NumeryczneCalkowanie();
            Scanner scanner = new Scanner(System.in);

            String nazwaPliku = new String();

            System.out.println("Podaj nazwe ścieżkę pliku: ");

            nazwaPliku = scanner.nextLine();

            numeryczneCalkowanie.odczytZPliku(nazwaPliku);

            numeryczneCalkowanie.obliczanieMetedaProstokatowZNiedomiarem();

            numeryczneCalkowanie.obliczanieMetedaProstokatowZnadmiarem();

            numeryczneCalkowanie.obliczanieMetodaTrapezow();

            numeryczneCalkowanie.obliczanieMetodaSimpsona();


            //C:\Users\piese\Desktop\Metody Obliczeniowe\Numeryczne_Calakowanie_Funkcji\Numeryczne_Calakowanie\plik.txt
        }


    }



}
