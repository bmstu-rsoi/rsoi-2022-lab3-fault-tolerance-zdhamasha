package rsoi.lab2.ticket.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/manage/health")
    public HttpStatus checkHealth(){
        return HttpStatus.OK;
    }
}
