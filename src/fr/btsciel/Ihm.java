package fr.btsciel;

import clavier.In;

import java.text.DecimalFormat;
import java.util.Random;

@SuppressWarnings("ALL")
public class Ihm {
    static Temperature [] temperatures = new Temperature[7];
    static DecimalFormat df = new DecimalFormat("00.00");
    static Random rd = new Random();
    public static void main(String[] args) {
        int choice = 0;

        fillTemperatures();

        while (choice != 13) {
            System.out.println("Menu...");
            System.out.println("1: afficher tous les temperatures");
            System.out.println("2: afficher tous les temperatures du matin");
            System.out.println("3: afficher tous les temperatures du soir");
            System.out.println("4: afficher le temperature maximale du matin");
            System.out.println("5: afficher le temperature maximale du soir");
            System.out.println("6: afficher le temperature maximale du tous temperatures");
            System.out.println("7: afficher le temperature minimale du matin");
            System.out.println("8: afficher le temperature minimale du soir");
            System.out.println("9: afficher le temperature minimale du tous temperatures");
            System.out.println("10: afficher la moyenne de temperature du matin");
            System.out.println("11: afficher la moyenne de temperature du soir");
            System.out.println("12: afficher la moyenne du tous temperatures");
            System.out.println("13: sortir de programme");

            System.out.print("Votre choix: ");
            choice = In.readInteger();

            switch (choice) {
                case 1:
                    displayAll();
                    break;
                case 2:
                    displayMorning();
                    break;
                case 3:
                    displayEvening();
                    break;
                case 4:
                    System.out.println("Temperature maximale du matin: " + df.format(getMaxMorning()));
                    break;
                case 5:
                    System.out.println("Temperature maximale du soir: " + df.format(getMaxEvening()));
                    break;
                case 6:
                    System.out.println("Temperature maximale du tous temperatures: " + df.format(getMaxAll()));
                    break;
                case 7:
                    System.out.println("Temperature minimale du matin: " + df.format(getMinMorning()));
                    break;
                case 8:
                    System.out.println("Temperature minimale du soir: " + df.format(getMinEvening()));
                    break;
                case 9:
                    System.out.println("Temperature minimale du tous temperatures: " + df.format(getMinAll()));
                    break;
                case 10:
                    System.out.println("La moyenne de temperatures du matin: " + df.format(getAverageMorning()));
                    break;
                case 11:
                    System.out.println("La moyenne de temperatures du soir: " + df.format(getAverageEvening()));
                    break;
                case 12:
                    System.out.println("La moyenne de tous temperatures: " + df.format(getAverageAll()));
                    break;
                case 13:
                    System.out.print("Vous etes sorti de programme");
            }
        }
    }

    public static void fillTemperatures() {
        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = new Temperature();
            temperatures[i].matin = rd.nextDouble(20) - 10;
            temperatures[i].soir = rd.nextDouble(10, 30);
        }
        temperatures[0].jour = "Lundi";
        temperatures[1].jour = "Mardi";
        temperatures[2].jour = "Mercredi";
        temperatures[3].jour = "Jeudi";
        temperatures[4].jour = "Vendredi";
        temperatures[5].jour = "Samedi";
        temperatures[6].jour = "Dimanche";
    }

    public static void displayDays() {
        System.out.print("Jour" + "\t\t");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print(temperatures[i].jour + "\t\t\t");
        }
        System.out.print("\n");
    }
    public static void displayAll() {
        displayDays();
        System.out.print("Matin" + "\t\t");
        for (int j = 0; j < temperatures.length; j++) {
            System.out.print(df.format(temperatures[j].matin) + "°" + "\t\t\t");
            if (j == 2) {
                System.out.print("\t");
            }
            if (j == 4) {
                System.out.print("\t");
            }
        }
        System.out.print("\n");
        System.out.print("Soir" + "\t\t");
        for (int k = 0; k < temperatures.length; k++) {
            System.out.print(df.format(temperatures[k].soir) + "°" + "\t\t\t");
            if (k == 2) {
                System.out.print("\t");
            }
            if (k == 4) {
                System.out.print("\t");
            }
        }
        System.out.print("\n");
    }
    public static void displayMorning() {
        displayDays();
        System.out.print("Matin" + "\t\t");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print(df.format(temperatures[i].matin) + "°" + "\t\t\t");
            if (i == 2) {
                System.out.print("\t");
            }
            if (i == 4) {
                System.out.print("\t");
            }
        }
        System.out.print("\n");
    }
    public static void displayEvening() {
        displayDays();
        System.out.print("Soir" + "\t\t");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.print(df.format(temperatures[i].soir) + "°" + "\t\t\t");
            if (i == 2) {
                System.out.print("\t");
            }
            if (i == 4) {
                System.out.print("\t");
            }
        }
        System.out.print("\n");
    }
    public static double getMaxMorning() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i].matin > max) {
                max = temperatures[i].matin;
            }
        }
        return max;
    }
    public static double getMaxEvening() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i].soir > max) {
                max = temperatures[i].soir;
            }
        }
        return max;
    }

    public static double getMaxAll() {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i].matin > max) {
                max = temperatures[i].matin;
            }
            if (temperatures[i].soir > max) {
                max = temperatures[i].soir;
            }
        }
        return max;
    }

    public static double getMinMorning() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i].matin < min) {
                min = temperatures[i].matin;
            }
        }
        return min;
    }

    public static double getMinEvening() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i].soir < min) {
                min = temperatures[i].soir;
            }
        }
        return min;
    }

    public static double getMinAll() {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i].matin < min) {
                min = temperatures[i].matin;
            }
            if (temperatures[i].soir < min) {
                min = temperatures[i].soir;
            }
        }
        return min;
    }

    public static double getAverageMorning() {
        double average = 0;
        for (int i = 0; i < temperatures.length; i++) {
            average += temperatures[i].matin;
        }
        return average / temperatures.length;
    }

    public static double getAverageEvening() {
        double average = 0;
        for (int i = 0; i < temperatures.length; i++) {
            average += temperatures[i].soir;
        }
        return average / temperatures.length;
    }
    public static double getAverageAll() {
        return (getAverageMorning() + getAverageEvening()) / 2;
    }
}