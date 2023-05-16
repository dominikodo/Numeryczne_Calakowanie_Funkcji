import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumeryczneCalkowanie {

    private final ArrayList<Punkt> listaPunktow;

    NumeryczneCalkowanie() {

        listaPunktow = new ArrayList<>();

    }

    void odczytZPliku(String nazwaPliku) {//metoda odczytująca z pliku punkty


        File file = new File(nazwaPliku);//tworzenie obiektu file

        try {
            Scanner scanner = new Scanner(file);
            //System.out.println("test");
            while (scanner.hasNextDouble()) {//dopóki są liczby double w pliku

                Punkt punkt = new Punkt();

                punkt.setLocation(scanner.nextDouble(), scanner.nextDouble());
                listaPunktow.add(punkt);
                System.out.println("punkt: (" + punkt.getX() + "," + punkt.getY() + ")");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku lub nie da się otworzyć");
            System.exit(0);
        } catch (InputMismatchException e) {
            System.out.println("Dane w pliku nie są liczbami");
            System.exit(0);
        }
        //System.out.println(listaPunktow);
    }


    void obliczanieMetedaProstokatowZNiedomiarem() {//metoda obliczająca całkę metodą prostokątów z niedomiarem

        int i = listaPunktow.size();
        double suma = 0;
        double h = listaPunktow.get(1).getX() - listaPunktow.get(0).getX();

        for (int j = 0; j < i - 1; j++) {

            suma += listaPunktow.get(j).getY() * h;
        }

        System.out.println("Całka metodą prostokątów z niedomiarem: " + suma);
    }

    void obliczanieMetedaProstokatowZnadmiarem() {//metoda obliczająca całkę metodą prostokątów z nadmiarem

        int i = listaPunktow.size();
        double suma = 0;
        double h = listaPunktow.get(1).getX() - listaPunktow.get(0).getX();

        for (int j = 1; j < i; j++) {

            suma += listaPunktow.get(j).getY() * h;
        }

        System.out.println("Całka metodą prostokątów z nadmiarem: " + suma);
    }
    void obliczanieMetodaTrapezow() {//metoda obliczająca całkę metodą trapezów

        int i = listaPunktow.size();
        double suma = 0;
        double h = listaPunktow.get(1).getX() - listaPunktow.get(0).getX();

        for (int j = 1; j < i - 1; j++) {

            suma += listaPunktow.get(j).getY() * h;
        }

        suma += (listaPunktow.get(0).getY() + listaPunktow.get(i - 1).getY()) * h / 2;

        System.out.println("Całka metodą trapezów: " + suma);
    }


    void obliczanieMetodaSimpsona() {//metoda obliczająca całkę metodą Simpsona

        int i = listaPunktow.size();
        double suma = 0;
        double h = listaPunktow.get(1).getX() - listaPunktow.get(0).getX();

        for (int j = 1; j < i - 1; j++) {

            if (j % 2 == 0) {
                suma += 2 * listaPunktow.get(j).getY() * h;
            } else {
                suma += 4 * listaPunktow.get(j).getY() * h;
            }
        }

        suma += (listaPunktow.get(0).getY() + listaPunktow.get(i - 1).getY()) * h / 3;

        System.out.println("Całka metodą Simpsona: " + suma);
    }

}
