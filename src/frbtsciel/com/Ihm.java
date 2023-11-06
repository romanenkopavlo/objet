package frbtsciel.com;

import java.text.DecimalFormat;
import java.util.Random;

public class Ihm {
    static Temperature [] temperatures = new Temperature[7];
    public static void main(String[] args) {
        Random rd = new Random();
        DecimalFormat df = new DecimalFormat("##.##");

        for (int i = 0; i < temperatures.length; i++) {
            temperatures[i] = new Temperature();
            temperatures[i].matin = rd.nextDouble(10) - 10;
            temperatures[i].soir = rd.nextDouble(10) + 21;
        }

        temperatures[0].jour = "Lundi";
        temperatures[1].jour = "Mardi";
        temperatures[2].jour = "Mercredi";
        temperatures[3].jour = "Jeudi";
        temperatures[4].jour = "Vendredi";
        temperatures[5].jour = "Samedi";
        temperatures[6].jour = "Dimanche";

        for (Temperature temperature : temperatures) {
            System.out.println(temperature.jour + " Matin: " + df.format(temperature.matin) + " Soir: " + df.format(temperature.soir));
        }
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
            if (temperatures[i].matin < min) {
                min = temperatures[i].matin;
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
}