package snowfall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import snowfall.domain.User;
import snowfall.domain.telegram.Update;
import snowfall.utils.BotMethod;
import snowfall.utils.MockDB;
import snowfall.utils.TelegramUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class BotService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${telegram.api}")
    private String api;
    @Value("${telegram.bot}")
    private String botToken;

    /*
    * Получаем обновления
    */
    public Update getUpdates() throws URISyntaxException {
        RequestEntity requestEntity = new RequestEntity(HttpMethod.GET, new URI(
                TelegramUtils.generateUrl(api, botToken, BotMethod.GET_UPDATES)
        ));

        ResponseEntity<Update> responseEntity = restTemplate.exchange(requestEntity,Update.class);
        return responseEntity.getBody();
    }

    /*
    * Отправляем текстовое сообщение
    */
    public void sendMessage(String message, String chatId) throws URISyntaxException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(TelegramUtils.generateUrl(api, botToken, BotMethod.SEND_MESSAGE))
                .queryParam("text", message)
                .queryParam("chat_id", chatId);
        RequestEntity requestEntity = new RequestEntity(HttpMethod.POST, builder.build().toUri());
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    /*
    * Отправка сообщение всем пользователям которые подписались на бота
    */
    public void sendMessageAllUsers(String message) {
        List<User> users = MockDB.userList();
        users.forEach(user -> {
            try {
                sendMessage(message, user.getChat().getId().toString());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }

}
