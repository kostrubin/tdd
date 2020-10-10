public class CreditCalculator {
    public int calculateMonthlyPayment(int sum, int months, int rate) {
        double monthRate = (double) rate / 100 / 12;

        return (int) (sum * (monthRate + (monthRate / (Math.pow((1 + monthRate), months) - 1))));
    }

    public int calculateFinalSum(int sum, int months, int rate) {
        return calculateMonthlyPayment(sum, months, rate) * months;
    }

    public int calculateTotalOverpayment(int sum, int months, int rate) {
        return calculateFinalSum(sum, months, rate) - sum;
    }
}
