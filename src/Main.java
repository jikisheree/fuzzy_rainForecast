public class Main {
    public static void main(String[] args) {
        double wind_input = 8;
        double temp_input = 30;
        double humid_input = 50;

        FuzzyLogic alg = new FuzzyLogic(temp_input, wind_input, humid_input);
        alg.run();

    }

}
