package pl.kolbuszewski.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.kolbuszewski.demo.model.ResultDto;
import pl.kolbuszewski.demo.service.UserService;

@RestController
public class DemoRestController {

    private final UserService usersService;

    public DemoRestController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<ResultDto> returnData(@PathVariable String userName) {
        ResultDto resultDto = usersService.getUser(userName);
        if (resultDto == null) {
            return ResponseEntity.notFound()
                                 .build();
        } else {
            return ResponseEntity.ok(resultDto);
        }
    }
}
