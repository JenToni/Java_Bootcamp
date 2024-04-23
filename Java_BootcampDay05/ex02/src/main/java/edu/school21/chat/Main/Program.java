package edu.school21.chat.Main;
import edu.school21.chat.Chat.Message;

import edu.school21.chat.Repository.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import edu.school21.chat.Chat.ChatRoom;
import edu.school21.chat.Chat.UserID;




public class Program {

    public static void main(String[] args) throws SQLException {
        DBUtils dataSource = new DBUtils();
        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(DBUtils.getDataSource());

        UserID creator = new UserID(7L, "user", "user", new ArrayList(), new ArrayList());
        UserID author = creator;
        ChatRoom room = new ChatRoom(8L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        messagesRepository.save(message);
        System.out.println(message.getId()); // ex. id == 11

    }

}
