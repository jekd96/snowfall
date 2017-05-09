package snowfall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import snowfall.domain.telegram.Result;
import snowfall.domain.telegram.Update;
import snowfall.utils.MockDB;

import java.net.URISyntaxException;

@Service
public class CachingService {

    @Autowired
    private BotService botService;

    //Todo добавить реализацию WebhookInfo(Возможно, но не точно)
    @Async
    @Scheduled(fixedDelay = 10000)
    public void sync() throws URISyntaxException {
        cachingDB();
    }

    private void cachingDB () throws URISyntaxException {
        Update update = botService.getUpdates();
        for (Result result : update.getResult()) {
            MockDB.createUser(result.getMessage().getChat());
        }

    }

}
