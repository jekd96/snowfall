package snowfall.utils;

public enum BotMethod {

    /*
    * Получить данные о боте
    */
    GET_ME("getMe"),

    /*
    * Получить все обновления
    */
    GET_UPDATES("getUpdates"),

    /*
    * Отправить сообщение
    */
    SEND_MESSAGE("sendMessage");

    String title;

    BotMethod(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
