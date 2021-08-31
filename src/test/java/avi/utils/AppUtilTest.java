package avi.utils;

import avi.component.LoanDetails;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


public class AppUtilTest {

    @Test
    public void testCalculateRepaymentAmount_returnsExpectedValue() {
        LoanDetails loanDetails = new LoanDetails("Test", 1000, 12, 2);
        double repaymentAmount = AppUtil.calculateRepaymentAmount(loanDetails);
        assertEquals(     47.07, repaymentAmount);
    }

    @Test
    public void testInputLinesRead_withWrongFilePath() {
        assertThrows(NoSuchFileException.class,
                () -> AppUtil.getInputLines("./wrong/path/prospects.txt"));
    }

    @Test
    public void testInputLinesRead_withCorrectFilePath() throws IOException {
        Stream<String> inputLines = AppUtil.getInputLines("./src/main/resources/prospects.txt");
        assertTrue(inputLines.findFirst().isPresent());
    }

}
