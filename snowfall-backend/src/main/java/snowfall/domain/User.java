package snowfall.domain;


import snowfall.domain.telegram.Chat;

public class User {

    private Chat chat;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

}
