package snowfall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String api = "https://api.telegram.org";
    private static final String botToken = "bot336412869:AAGB7L9fTMzLok2-wjWUNcd9Eowno6S6aCs";

    //Todo пока Id Сереги, в будущем поправить сервис что-бы отправлять группе лиц
    private final Long chatId = 232104740L;

    public void sendMessage(String message) {
        String method = "sendMessage";
        String textParam = "text";
        String chatParam = "chat_id";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        restTemplate.exchange(
                api
                        .concat("/")
                        .concat(botToken)
                        .concat("/")
                        .concat(method)
                        //Todo разобраться как передавать параметры не в строке
                        .concat("?")
                        .concat(textParam)
                        .concat("=")
                        .concat(message)
                        .concat("&")
                        .concat(chatParam)
                        .concat("=")
                        .concat(chatId.toString())
                ,
                HttpMethod.POST,
                entity,
                String.class);
    }

}
