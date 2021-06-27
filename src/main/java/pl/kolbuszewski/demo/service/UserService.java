package pl.kolbuszewski.demo.service;

import org.springframework.stereotype.Service;
import pl.kolbuszewski.demo.model.ResultDto;
import pl.kolbuszewski.demo.model.UserDto;
import pl.kolbuszewski.demo.model.UserLookUp;
import pl.kolbuszewski.demo.repository.LookupRepository;
import pl.kolbuszewski.demo.repository.UserRepository;
import pl.kolbuszewski.demo.util.ResultCalculator;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LookupRepository lookupRepository;
    private final ResultCalculator resultCalculator;

    public UserService(UserRepository userRepository, LookupRepository lookupRepository, ResultCalculator resultCalculator) {
        this.userRepository = userRepository;
        this.lookupRepository = lookupRepository;
        this.resultCalculator = resultCalculator;
    }

    public ResultDto getUser(String userName) {
        UserDto userDto = userRepository.getUser(userName);
        if (userDto != null) {
            increaseRequestCounter(userDto);
            return resultCalculator.fillUserCalculations(userDto);
        } else {
            return null;
        }
    }

    private void increaseRequestCounter(UserDto userDto) {
        Optional<UserLookUp> userDb = lookupRepository.findByLogin(userDto.getLogin());
        if (userDb.isPresent()) {
            UserLookUp userLookUp = userDb.get();
            long counter = userLookUp.getRequestCount();
            userLookUp.setRequestCount(++counter);
            lookupRepository.save(userLookUp);
        } else {
            UserLookUp newRecord = new UserLookUp();
            newRecord.setLogin(userDto.getLogin());
            newRecord.setRequestCount(1);
            lookupRepository.save(newRecord);
        }
    }

}
