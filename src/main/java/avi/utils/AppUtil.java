package avi.utils;

import avi.component.LoanDetails;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.stream.Stream;

public class AppUtil {

    public static double calculateRepaymentAmount(LoanDetails loanDetails) {
        double U = loanDetails.getLoanAmount();
        double b = loanDetails.getMonthlyInterestRate();
        int p = loanDetails.getNumberOfPayments();
        double temp = calculatePowerOfANumber((b + 1), p);

        double monthlyAmount = (U * (b * temp)) / (temp - 1);
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(monthlyAmount).replace(',', '.'));
    }

    private static double calculatePowerOfANumber(double number, double power) {
        double result = 1;
        while(power != 0) {
            result *= number;
            power--;
        }
        return result;
    }

    public static void showDetails(String[] inputs) {
        if (inputs.length != 4) {
            return;
        }

        try {
            LoanDetails loanDetails = new LoanDetails(inputs[0], Double.parseDouble(inputs[1]),
                    Float.parseFloat(inputs[2]), Integer.parseInt(inputs[3]));
            double repaymentAmount = calculateRepaymentAmount(loanDetails);

            System.out.println(inputs[0] + " wants to borrow " + inputs[1] + " € for a period of " +
                    inputs[3] + " years and pay " + repaymentAmount + " € each month");

        } catch (Exception exception) {
            System.out.println("Wrong Input : " + exception);
        }

    }

    public static Stream<String> getInputLines(String path) throws IOException {
        Stream<String> lines = Files.lines(Path.of(path));
        return lines;
    }

}
