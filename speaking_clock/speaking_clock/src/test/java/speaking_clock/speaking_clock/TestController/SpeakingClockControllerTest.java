package speaking_clock.speaking_clock.TestController;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpeakingClockControllerTest {


    HttpHeaders headers;

    @MockBean
    private RestTemplate restTemplate;

    @Before
    public void _setupBefore() {
        headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    }

    @Test
     public  void getCurrentTime() {
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<?> resultEntity = restTemplate.exchange("/clock/getCurrentTime",HttpMethod.GET,requestEntity, String.class);
        Assert.assertEquals(HttpStatus.OK, resultEntity.getStatusCode());
}

    @Test
    public  void handleDateInput() {
       String time = "10:15";
        Map map = new HashMap<>();
        map.put("time", time);
        HttpEntity<?> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<?> resultEntity = restTemplate.exchange("/clock/handleDateInput?time={time}",HttpMethod.GET,requestEntity, Map.class,map);
        Assert.assertEquals(HttpStatus.ACCEPTED, resultEntity.getStatusCode());
    }
}
