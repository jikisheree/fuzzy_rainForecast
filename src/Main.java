public class Main {
    public static void main(String[] args) {
        double wind_input = 8;
        double temp_input = 30;

        FuzzyLogic alg = new FuzzyLogic(temp_input, wind_input);
        alg.run();

    }

}
