import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FuzzyLogic {

    private final double[][] rain_fuzzy = new double[5][];
    private final double[] rain_value = new double[]{10,20,30,40,50,60,70,80,90,100};
    private final int ruleNum = 25;
    private final double temp_input;
    private final double wind_input;
    private final Membership_function mem_func;


    public FuzzyLogic(double temp_input, double wind_input){
        setRain_fuzzy();
        this.temp_input = temp_input;
        this.wind_input = wind_input;
        this.mem_func = new Membership_function();

    }

    public void run(){

        // main operation
        double output = df_toNum(find_max_output());
        System.out.println("================================================================");
        System.out.println("The probability of raining is "+output+" %");

    }

    private double[] output_byRule(int num){

        double[] output = new double[10];

        // switch case
        switch (num) {
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

        rain_fuzzy[0] = new double[]{1,1,0.5,0.5,0.2,0.1,0,0,0,0};       // NL
        rain_fuzzy[1] = new double[]{0.1,0.2,0.5,1,0.5,0.2,0.1,0,0,0};   // NS
        rain_fuzzy[2] = new double[]{0,0,0.1,0.2,0.5,1,0.5,0.2,0.1,0};   // ZE
        rain_fuzzy[3] = new double[]{0,0,0,0,0.1,0.2,0.5,1,0.5,0.2};     // PS
        rain_fuzzy[4] = new double[]{0,0,0,0,0,0,0.1,0.2,0.5,1};         // PL

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
        double[] output = new double[10];
         for (int i=0; i<10; i++){
            output[i] = 0;
        }
        double[][] output_list = find_outputs();
        // call find_output function
        for (int i=0; i<ruleNum; i++){
            for (int j=0; j<10; j++){
                if(output[j] <= output_list[i][j] ) output[j] =  output_list[i][j];
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

    private double[] find_output(double a, double b, String fuzzy_var){

        System.out.println("cut_a " + a + " "  +  "cut_b " + b);

        int fuzzy_in = switch (fuzzy_var) {
            case "nl" -> 0;
            case "ns" -> 1;
            case "ze" -> 2;
            case "ps" -> 3;
            case "pl" -> 4;
            default -> 0;
        };


        double[] output = new double[10];
        double alpha = Math.min(a, b);
        for (int i=0; i<10; i++) {
            output[i] = Math.min(alpha, rain_fuzzy[fuzzy_in][i]);
        }
        return output;
    }
}
