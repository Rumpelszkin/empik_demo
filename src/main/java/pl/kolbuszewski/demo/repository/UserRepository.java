package pl.kolbuszewski.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.kolbuszewski.demo.model.UserDto;

@Repository
public class UserRepository {

    private final static String repoPath = "https://api.github.com/users/%s";

    public UserDto getUser(String userName) {
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto;
        try {
            userDto = restTemplate.getForObject(String.format(repoPath, userName), UserDto.class);
        } catch (HttpClientErrorException e) {
            userDto = null;
        }
        return userDto;
    }
}
