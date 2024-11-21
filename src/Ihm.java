import java.text.DecimalFormat;

class Ihm {

    public static Temperature [] temperatures = new Temperature[7];
    public static void main(String[] args){

        double matinMax = -50;
        double apremMax = -50;
        double max = 0;
        double matinMin = 50;
        double apremMin = 50;
        double min = 0;
        double matinMoy = 0;
        double apremMoy = 0;
        double moy = 0;

        DecimalFormat df = new DecimalFormat("+#,#00.0;-#");

        String[]jour = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};
        for(int i=0; i<temperatures.length; i++){
            temperatures[i] = new Temperature();
            temperatures[i].matin = (Math.random() * -25) + 5;
            temperatures[i].aprem = Math.random() * 20.00 + 10;
            temperatures[i].jour = jour[i];

            // Calcul de la température minimale et maximal du matin et de l'après-midi
            if (temperatures[i].matin > matinMax){
                matinMax = temperatures[i].matin;
            }
            if (temperatures[i].aprem > apremMax){
                apremMax = temperatures[i].aprem;
            }
            if (temperatures[i].matin < matinMin){
                matinMin = temperatures[i].matin;
            }
            if (temperatures[i].aprem <apremMin){
                apremMin = temperatures[i].aprem;
            }
            // Ici, les variables sont pour le moment que la somme des températures matin ou soir
            matinMoy += temperatures[i].matin;
            apremMoy += temperatures[i].aprem;

        }

        // Calcul de la température minimale et de la maximale
        if (matinMax < apremMax){
            max = apremMax;
        }else{
            max = matinMin;
        }
        if (matinMin < apremMin){
            min = matinMin;
        }else{
            min = apremMin;
        }

        // Calcul de la moyenne
        moy = (matinMoy + apremMoy) / (temperatures.length * 2);
        matinMoy = matinMoy / temperatures.length;
        apremMoy = apremMoy / temperatures.length;



        System.out.println("Températures: ");
        for(int i=0; i<temperatures.length; i++) {
            System.out.print(temperatures[i].jour + " ");
            System.out.print(df.format(temperatures[i].matin) + " ");
            System.out.print(df.format(temperatures[i].aprem) + "   ");
        }

        System.out.println("\n\nTempératures matin: ");
        for(int i=0; i<temperatures.length; i++) {
            System.out.print(temperatures[i].jour + " ");
            System.out.print(df.format(temperatures[i].matin) + "   ");
        }

        System.out.println("\n\nTempératures après-midi: ");
        for(int i=0; i<temperatures.length; i++) {
            System.out.print(temperatures[i].jour + " ");
            System.out.print(df.format(temperatures[i].aprem) + "   ");
        }

        System.out.println("\n\n\u001b[31mTempérature maximale matin: " + df.format(matinMax));
        System.out.println("Température maximale après-midi: " + df.format(apremMax));
        System.out.println("Température maximale: " + df.format(max) + "\u001b[0m");

        System.out.println("\n\u001b[34mTempératures minimale matin: " + df.format(matinMin));
        System.out.println("Température minimale après-midi: " + df.format(apremMin));
        System.out.println("Température minimale: " + df.format(min) + "\u001b[0m");

        System.out.println("\n\u001b[32mTempérature moyenne matin: " + df.format(matinMoy));
        System.out.println("Température moyenne après-midi : " + df.format(apremMoy));
        System.out.println("Température moyenne: " + df.format(moy) + "\u001b[0m");

    }
}