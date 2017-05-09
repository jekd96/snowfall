package snowfall.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import snowfall.service.BotService;

@Component
public class MainController {

    @Autowired
    private BotService botService;

    @FXML
    private TextArea message;

    @FXML
    public void initialize() {
    }

    public void sendMessage() {
        botService.sendMessage(message.getText());
    }



}
