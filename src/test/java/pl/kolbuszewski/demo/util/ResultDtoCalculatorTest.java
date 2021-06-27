package pl.kolbuszewski.demo.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.kolbuszewski.demo.model.ResultDto;
import pl.kolbuszewski.demo.model.UserDto;


public class ResultDtoCalculatorTest {

    private ResultCalculator resultCalculator;
    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        resultCalculator = new ResultCalculator();
        userDto = new UserDto();
    }

    @DisplayName("Ensure calculation works correctly")
    @Test
    public void testCalculationShouldReturn12() {
        userDto.setFollowers(1);
        userDto.setPublicRepos(0);

        ResultDto resultDto = resultCalculator.fillUserCalculations(userDto);

        Assertions.assertEquals(12, resultDto.getCalculations());
    }

    @Test
    public void testShouldThrowAritmeticException() {
        userDto.setFollowers(0);
        userDto.setPublicRepos(0);

        Assertions.assertThrows(ArithmeticException.class, () -> resultCalculator.fillUserCalculations(userDto));
    }

}
