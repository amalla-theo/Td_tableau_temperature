import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("00.0");
        double[] dTemperatures = new double[14];
        double dMinimumMatin = 50.0;
        double dMaximumMatin = -50.0;
        double dMinimumAprem = 50.0;
        double dMaximumAprem = -50.0;
        double dMaximum = 0.0;
        double dMinimum = 0.0;
        double dMoyenneMatin = 0.0;
        double dMoyenneAprem = 0.0;
        double dMoyenne = 0.0;


        for (int i = 0; i < dTemperatures.length; i = i+2) {
            dTemperatures[i] = Math.random() * 20.00 - 10;
            dMoyenneMatin += dTemperatures[i];
            if (dTemperatures[i] < dMinimumMatin) {
                dMinimumMatin = dTemperatures[i];
            }
            if (dTemperatures[i] > dMaximumMatin) {
                dMaximumMatin = dTemperatures[i];
            }
        }

        for (int i = 1; i < dTemperatures.length; i= i+2) {
            dTemperatures[i] = Math.random() * 20.00 + 10;
            dMoyenneAprem += dTemperatures[i];
            if (dTemperatures[i] < dMinimumAprem) {
                dMinimumAprem = dTemperatures[i];
            }
            if (dTemperatures[i] > dMaximumAprem) {
                dMaximumAprem = dTemperatures[i];
            }
        }

        if (dMaximumMatin < dMaximumAprem) {
            dMaximum = dMaximumAprem;
        }else{
            dMaximum = dMaximumMatin;
        }

        if (dMinimumMatin < dMinimumAprem) {
            dMinimum = dMinimumMatin;
        }else{
            dMinimum = dMinimumAprem;
        }


        dMoyenne = (dMoyenneMatin + dMoyenneAprem) / dTemperatures.length;
        dMoyenneMatin = dMoyenneMatin / (dTemperatures.length / 2);
        dMoyenneAprem = dMoyenneAprem / (dTemperatures.length / 2);


        System.out.print("\u001b[1mTempératures:  ");
        for (int i = 0; i < dTemperatures.length; i++) {
            System.out.print(df.format(dTemperatures[i]) + "   ");
        }

        System.out.print("\nTempératures matin:   ");
        for (int i = 0; i < dTemperatures.length; i= i+2) {
            System.out.print(df.format(dTemperatures[i]) + "   ");
        }
        System.out.print("\nTempératures après-midi:   ");
        for (int i = 1; i < dTemperatures.length; i= i+2) {
            System.out.print(df.format(dTemperatures[i]) + "   ");
        }
        System.out.println("\u001b[31m\n\nTempérature maximale matin:   " + df.format(dMaximumMatin));
        System.out.println("Température maximale après-midi: " + df.format(dMaximumAprem));
        System.out.println("Température maximale: " + df.format(dMaximum));

        System.out.println("\u001b[36m\n\nTempérature minimale matin:   " + df.format(dMinimumMatin));
        System.out.println("Température minimale après-midi: " + df.format(dMinimumAprem));
        System.out.println("Température minimale: " + df.format(dMinimum));

        System.out.println("\u001b[32m\n\nTempérature moyenne matin:   " + df.format(dMoyenneMatin));
        System.out.println("Température moyenne après-midi: " + df.format(dMoyenneAprem));
        System.out.println("Température moyenne: " + df.format(dMoyenne) + "\u001b[0m");

    }
}