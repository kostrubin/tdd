import org.junit.Test;
import org.junit.Assert;

public class TestCreditCalculator {
    CreditCalculator cc = new CreditCalculator();
    int sum = 150000;
    int months = 36;
    int rate = 15;
    double monthRate = 0.0125;
    int monthlyPayment = (int) (sum * (monthRate + (monthRate / (Math.pow((1 + monthRate), months) - 1))));

    @Test
    public void testMonthlyPayment() {
        int expected = monthlyPayment;
        int result = cc.calculateMonthlyPayment(sum, months, rate);

        Assert.assertTrue(
            String.format("Wrong monthly payment.\nExpected: %d\nGot: %d\n", expected, result),
    result == expected
        );
    }

    @Test
    public void testFinalSum() {
        int expected = monthlyPayment * months;
        int result = cc.calculateFinalSum(sum, months, rate);

        Assert.assertTrue(
            String.format("Wrong total sum.\nExpected: %d\nGot: %d\n", expected, result),
    result == expected
        );
    }

    @Test
    public void testTotalOverpayment() {
        int expected = monthlyPayment * months - sum;
        int result = cc.calculateTotalOverpayment(sum, months, rate);

        Assert.assertTrue(
            String.format("Wrong total overpayment.\nExpected: %d\nGot: %d\n", expected, result),
    result == expected
        );
    }
}
