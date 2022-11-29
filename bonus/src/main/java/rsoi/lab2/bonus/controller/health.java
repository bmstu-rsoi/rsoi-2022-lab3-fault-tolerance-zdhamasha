package rsoi.lab2.bonus.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/manage")
public class health {

    private static final Logger LOGGER = LoggerFactory.getLogger(health.class);

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public void checkIsAvailable()
    {

        LOGGER.info("/manage/health received a request to check health");
        return;
    }
}

