package rsoi.lab2.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations="classpath:application-test.properties")
class TicketApplicationTests {

    @Test
    void contextLoads() {
    }

}
