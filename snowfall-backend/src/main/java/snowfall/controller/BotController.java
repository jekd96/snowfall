package snowfall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import snowfall.domain.dto.MessageDTO;
import snowfall.domain.telegram.Update;
import snowfall.service.BotService;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    private BotService botService;

    @GetMapping(value = "/updates")
    public Update getUpdates() throws URISyntaxException {
        return botService.getUpdates();
    }


    @PostMapping(value = "/message")
    public void sendMessage(@RequestBody MessageDTO message) throws URISyntaxException {
        botService.sendMessage(message.getText(), message.getText());
    }


    @PostMapping(value = "/message/all")
    public void sendMessageAllUsers(@RequestBody MessageDTO message) {
        botService.sendMessageAllUsers(message.getText());
    }

}
