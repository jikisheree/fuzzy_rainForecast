import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuzzyLogic {

    private final double[][] rain_fuzzy = new double[5][];
    private final double[] rain_value = new double[101];
    private final int ruleNum = 25;
    private final double temp_input;
    private final double wind_input;
    private final double humid_input;
    private final Membership_function mem_func;


    public FuzzyLogic(double temp_input, double wind_input, double humid_input){
        setRain_fuzzy();
        this.temp_input = temp_input;
        this.wind_input = wind_input;
        this.humid_input = humid_input;
        this.mem_func = new Membership_function();

    }

    public void run(){

        // main operation
        double output = df_toNum(find_max_output());
        System.out.println("================================================================");
        System.out.println("The probability of raining is "+output+" %");

    }

    private double[] output_byRule(int num){

        double[] output = new double[101];

        // switch case
        switch (num) {
            // here: need to be fixed
            case 1 -> output = find_output(wind_membership_func("nl"), temp_membership_func("nl"), "nl");
            case 2 -> output = find_output(wind_membership_func("nl"), temp_membership_func("ns"), "nl");
            case 3 -> output = find_output(wind_membership_func("nl"), temp_membership_func("ze"), "ns");
            case 4 -> output = find_output(wind_membership_func("nl"), temp_membership_func("ps"), "ns");
            case 5 -> output = find_output(wind_membership_func("nl"), temp_membership_func("pl"), "ze");
            case 6 -> output = find_output(wind_membership_func("ns"), temp_membership_func("nl"), "nl");
            case 7 -> output = find_output(wind_membership_func("ns"), temp_membership_func("ns"), "nl");
            case 8 -> output = find_output(wind_membership_func("ns"), temp_membership_func("ze"), "ns");
            case 9 -> output = find_output(wind_membership_func("ns"), temp_membership_func("ps"), "ze");
            case 10 -> output = find_output(wind_membership_func("ns"), temp_membership_func("pl"), "ze");
            case 11 -> output = find_output(wind_membership_func("ze"), temp_membership_func("nl"), "ns");
            case 12 -> output = find_output(wind_membership_func("ze"), temp_membership_func("ns"), "ns");
            case 13 -> output = find_output(wind_membership_func("ze"), temp_membership_func("ze"), "ze");
            case 14 -> output = find_output(wind_membership_func("ze"), temp_membership_func("ps"), "ze");
            case 15 -> output = find_output(wind_membership_func("ze"), temp_membership_func("pl"), "ps");
            case 16 -> output = find_output(wind_membership_func("ps"), temp_membership_func("nl"), "ns");
            case 17 -> output = find_output(wind_membership_func("ps"), temp_membership_func("ns"), "ze");
            case 18 -> output = find_output(wind_membership_func("ps"), temp_membership_func("ze"), "ze");
            case 19 -> output = find_output(wind_membership_func("ps"), temp_membership_func("ps"), "ps");
            case 20 -> output = find_output(wind_membership_func("ps"), temp_membership_func("pl"), "ps");
            case 21 -> output = find_output(wind_membership_func("pl"), temp_membership_func("nl"), "ze");
            case 22 -> output = find_output(wind_membership_func("pl"), temp_membership_func("ns"), "ze");
            case 23 -> output = find_output(wind_membership_func("pl"), temp_membership_func("ze"), "ps");
            case 24 -> output = find_output(wind_membership_func("pl"), temp_membership_func("ps"), "ps");
            case 25 -> output = find_output(wind_membership_func("pl"), temp_membership_func("pl"), "pl");
            default -> System.out.println("There are unmatched rule number!!!");
        }

        // return sets of relations for each inputs
        System.out.println("output num" + num +":"+ Arrays.toString(output));
        return output;
    }

    private void setRain_fuzzy() {

        rain_fuzzy[0] = new double[101];   // Poor
        for(int i=1; i<=100; i++){
            if(i<=4)
                rain_fuzzy[0][i] = 0.1*i;
            else if(i<=10)
                rain_fuzzy[0][i] = 1.11-(0.11*i);
            else
                rain_fuzzy[0][i] = 0;
        }

        rain_fuzzy[1] = new double[101];   // Low
        for(int i=1; i<=100; i++){
            if(i>=10 && i<=14)
                rain_fuzzy[1][i] = (0.25*i)-2.5;
            else if(i<=20 && i>=14)
                rain_fuzzy[1][i] = 3.33-(0.17*i);
            else
                rain_fuzzy[1][i] = 0;
        }

        rain_fuzzy[2] = new double[101];   // Medium
        for(int i=1; i<=100; i++){
            if(i>=20 && i<=30)
                rain_fuzzy[2][i] = (0.1*i)-2;
            else if(i<=40 && i>=30)
                rain_fuzzy[2][i] = 3-(0.07*i);
            else
                rain_fuzzy[2][i] = 0;
        }

        rain_fuzzy[3] = new double[101];     // High
        for(int i=1; i<=100; i++){
            if(i>=43 && i<=50)
                rain_fuzzy[3][i] = (0.14*i)-6.14;
            else if(i<=65 && i>=50)
                rain_fuzzy[3][i] = 4.33-(0.07*i);
            else
                rain_fuzzy[3][i] = 0;
        }

        rain_fuzzy[4] = new double[101];         // Very High
        for(int i=1; i<=100; i++){
            if(i>=60)
                rain_fuzzy[4][i] = (0.025*i)-1.5;
            else
                rain_fuzzy[4][i] = 0;
        }

        for(int i=0; i<=100; i++){
            rain_value[i] = i;
        }
    }

    private double[][] find_outputs(){

        double[][] output_list = new double[ruleNum][];
        // do something
        for(int i=0; i<ruleNum; i++){
            output_list[i] = output_byRule(i+1);
        }

        return output_list;
    }


    private double[] find_max_output(){

        System.out.println("Fuzzy output: ");
        double[] output = new double[101];
         for (int i=0; i<101; i++){
            output[i] = 0;
        }
        double[][] output_list = find_outputs();
        // call find_output function
        for (int i=0; i<ruleNum; i++){
            for (int j=0; j<101; j++){
                if(output[j] <= output_list[i][j] )
                    output[j] =  output_list[i][j];
            }

        }
        System.out.println("output");
        System.out.println(Arrays.toString(output));
        return output;
    }

    private double df_toNum(double[] fuzzy_output){

        double return_output;
        double max = 0.0;
        List<Double> x = new ArrayList<>();

        // mode
        for (double v : fuzzy_output) {
            if (v > max)
                max = v;
        }
        for (int j = 0; j < fuzzy_output.length; j++) {
            if (fuzzy_output[j] == max) {
                max = fuzzy_output[j];
                x.add(rain_value[j]);
            }
        }
        double sum = 0.0;
        for (Double aDouble : x) {
            sum += aDouble;
        }

        return_output = sum/x.size();

        return return_output;

    }

    private double wind_membership_func(String type){

        return mem_func.wind_function1(type, wind_input);
    }

    private double temp_membership_func(String type){

        return mem_func.temp_function1(type, temp_input);
    }

    private double humid_membership_func(String type){

        return mem_func.humid_function1(type, humid_input);
    }

    private double[] find_output(double a, double b, double c, String fuzzy_var){

        System.out.println("cut_a " + a + " "  +  "cut_b " + b);

        int fuzzy_in = switch (fuzzy_var) {
            case "poor" -> 0;
            case "low" -> 1;
            case "med" -> 2;
            case "high" -> 3;
            default -> 0;
        };

        double[] output = new double[101];
        double alpha = Math.min(a, b);
        alpha = Math.min(alpha, c);
        for (int i=0; i<101; i++) {
            output[i] = Math.min(alpha, rain_fuzzy[fuzzy_in][i]);
        }
        return output;
    }
}
