public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }

        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialInvestment = 1000;
        double annualGrowthRate = 0.05;
        int yearsToForecast = 10;

        double futureValue = calculateFutureValue(initialInvestment, annualGrowthRate, yearsToForecast);
        System.out.printf("Future value after %d years: $%.2f%n", yearsToForecast, futureValue);
    }
}