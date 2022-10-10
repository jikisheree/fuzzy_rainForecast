public class Main {
    public static void main(String[] args) {
        double wind_input = 1;
        double temp_input = 14;

        FuzzyLogic alg = new FuzzyLogic(temp_input, wind_input);
        alg.run();

    }

}
