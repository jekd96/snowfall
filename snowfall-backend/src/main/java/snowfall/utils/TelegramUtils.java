package snowfall.utils;

public class TelegramUtils {

    public static String generateUrl(String api, String botToken, BotMethod botMethod) {
        String url = api.concat("/")
                .concat(botToken)
                .concat("/");
        if (BotMethod.GET_ME.equals(botMethod)) {
            url = url.concat(BotMethod.GET_ME.getTitle());
        }

        if (BotMethod.GET_UPDATES.equals(botMethod)) {
            url = url.concat(BotMethod.GET_UPDATES.getTitle());

        }

        if (BotMethod.SEND_MESSAGE.equals(botMethod)) {
            url = url.concat(BotMethod.SEND_MESSAGE.getTitle());
        }
        return url;
    }

}
