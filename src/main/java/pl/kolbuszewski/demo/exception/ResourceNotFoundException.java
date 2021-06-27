package pl.kolbuszewski.demo.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String s){
        super(s);
    }
    public ResourceNotFoundException(String s, Throwable t){
        super(s,t);
    }
}
