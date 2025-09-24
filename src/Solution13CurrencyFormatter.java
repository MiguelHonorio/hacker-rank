import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution13CurrencyFormatter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double amount = input.nextDouble();

        String eua = NumberFormat.getCurrencyInstance(Locale.US).format(amount);
        System.out.println("US: " + eua);

        Locale localIndia = new Locale("en", "IN");
        String ind = NumberFormat.getCurrencyInstance(localIndia).format(amount);
        System.out.println("India: " + ind);

        String chn = NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
        System.out.println("China: " + chn);

        String frc = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount);
        System.out.println("France: " + frc);



//        Locale.setDefault(Locale.US);
//        Scanner input = new Scanner(System.in);
//        double amount = input.nextDouble();
//
//        String eua = NumberFormat.getCurrencyInstance(Locale.US).format(amount);
//        System.out.println("US: " + eua);
//
//        Locale indiaLocale = new Locale("en", "IN");
//        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
//        DecimalFormatSymbols dfs = ((java.text.DecimalFormat) indiaFormat).getDecimalFormatSymbols();
//        dfs.setCurrencySymbol("Rs.");
//        ((java.text.DecimalFormat) indiaFormat).setDecimalFormatSymbols(dfs);
//        String india = indiaFormat.format(amount);
//        System.out.println("India: " + india);
//
//        String chn = NumberFormat.getCurrencyInstance(Locale.CHINA).format(amount);
//        System.out.println("China: " + chn);
//
//        String frc = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(amount);
//        System.out.println("France: " + frc);



//
//            Locale.setDefault(Locale.US);
//            Scanner input = new Scanner(System.in);
//            double amount = input.nextDouble();
//
//            String eua = NumberFormat.getCurrencyInstance(Locale.US).format(amount);
//            System.out.println("US: " + eua);
//
//            Locale indiaLocale = new Locale("en", "IN");
//            NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
//            DecimalFormatSymbols dfs = ((java.text.DecimalFormat) indiaFormat).getDecimalFormatSymbols();
//            dfs.setCurrencySymbol("Rs.");
//            ((java.text.DecimalFormat) indiaFormat).setDecimalFormatSymbols(dfs);
//            String india = indiaFormat.format(amount);
//            System.out.println("India: " + india);
//
//            DecimalFormat chinaFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.CHINA);
//            DecimalFormatSymbols chinaSymbols = chinaFormat.getDecimalFormatSymbols();
//            chinaSymbols.setCurrencySymbol("￥");
//            chinaFormat.setDecimalFormatSymbols(chinaSymbols);
//            String chn = chinaFormat.format(amount);
//            System.out.println("China: " + chn);
//
//            DecimalFormat franceFormat = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.FRANCE);
//            DecimalFormatSymbols franceSymbols = franceFormat.getDecimalFormatSymbols();
//            franceSymbols.setGroupingSeparator(' ');
//            franceFormat.setDecimalFormatSymbols(franceSymbols);
//            String frc = franceFormat.format(amount);
//            System.out.println("France: " + frc);

        //        Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
//        scanner.close();
//
//        NumberFormat nfUS = NumberFormat.getCurrencyInstance(Locale.US);
//        NumberFormat nfIN = NumberFormat.getCurrencyInstance(new Locale("en","IN"));
//        NumberFormat nfCH = NumberFormat.getCurrencyInstance(Locale.CHINA);
//        NumberFormat nfFR = NumberFormat.getCurrencyInstance(Locale.FRANCE);
//
//        String us = nfUS.format(payment);
//        String india = nfIN.format(payment);
//        String china = nfCH.format(payment);
//        String france = nfFR.format(payment);
//
//
//        System.out.println("US: " + us);
//        System.out.println("India: " + india);
//        System.out.println("China: " + china);
//        System.out.println("France: " + france);
    }

}
