package pl.kolbuszewski.demo.util;

import org.springframework.stereotype.Component;
import pl.kolbuszewski.demo.model.ResultDto;
import pl.kolbuszewski.demo.model.UserDto;

@Component
public class ResultCalculator {

    public ResultDto fillUserCalculations(UserDto userDto) {
        ResultDto resultDto = new ResultDto(userDto.getId(), userDto.getLogin(), userDto.getName(), userDto.getType(), userDto.getAvatarUrl(), userDto.getCreatedAt());
        resultDto.setCalculations(calculate(userDto));
        return resultDto;
    }

    private double calculate(UserDto userDto) {
        if (userDto.getFollowers() == 0) throw new ArithmeticException("Dont divide by 0!");
        double result = (double) 6 / userDto.getFollowers() * (2 + userDto.getPublicRepos());
        return result;
    }
}
