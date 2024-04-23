package edu.school21.chat.Main;
import edu.school21.chat.Chat.Message;

import edu.school21.chat.Repository.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;

import java.util.Optional;






public class Program {

    public static void main(String[] args) throws SQLException {
        DBUtils dataSource = new DBUtils();
        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(DBUtils.getDataSource());

        Optional<Message> messageOptional = messagesRepository.findById(11L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setText("Bye");
            message.setDateTime(null);
            messagesRepository.update(message);
        }

    }

}
