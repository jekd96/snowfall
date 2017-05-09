package snowfall.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {

    @JsonProperty("message_id")
    private Long messageId;

    private From from;

    private Chat chat;

    private Long date;

    private String text;

   // private List<String> entities = new ArrayList<>();

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
