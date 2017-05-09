package snowfall.utils;

import snowfall.domain.telegram.Chat;
import snowfall.domain.User;

import java.util.ArrayList;
import java.util.List;

public class MockDB {

    private static List<User> userList = new ArrayList<>();

    public static void createUser(Chat chat) {
        Long countUsers = userList.stream().filter(user -> user.getChat().getId().equals(chat.getId())).count();
        if (countUsers == 0) {
            User user = new User();
            user.setChat(chat);
            userList.add(user);
        }
    }

    public static void deleteUser(Long chatId) {
        User deleteUser = userList.stream().filter(user -> user.getChat().getId().equals(chatId)).findFirst().get();
        userList.remove(deleteUser);
    }

    public static List<User> userList() {
        return userList;
    }

}
