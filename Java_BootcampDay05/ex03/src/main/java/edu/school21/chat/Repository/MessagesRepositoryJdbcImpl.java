package edu.school21.chat.Repository;

import edu.school21.chat.Chat.ChatRoom;
import edu.school21.chat.Chat.Message;
import edu.school21.chat.Chat.UserID;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private static Connection connection;

    public MessagesRepositoryJdbcImpl(DataSource dataSource)  {
        try {
            MessagesRepositoryJdbcImpl.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Statement userStatement = connection.createStatement();
        ResultSet resultSet = userStatement.executeQuery("SELECT * FROM chat.message WHERE messageid = " + id );
        resultSet.next();
            System.out.println("Message : {");
            System.out.println("id = " + resultSet.getInt( 1));
            System.out.println("author = " + findUserById(resultSet.getLong( 2)));
            System.out.println("room = " +  findRoomById(resultSet.getLong(3)));
            System.out.println("text = \"" + resultSet.getString( 4) + "\"");
            System.out.println("dateTime = " + resultSet.getString( 5));
            System.out.println("}");


        return Optional.empty();
    }

    @Override
    public void save(Message message) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO chat.Message (messageuserid, messageroomid, messagetext, messagedate) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        statement.setLong(1, message.getAuthor().getId());
        statement.setLong(2, message.getRoom().getId());
        statement.setString(3, message.getText());
        statement.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));

        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        message.setId(resultSet.getLong(1));
    }

    @Override
    public void update(Message message) {
        Long messageId = message.getId();
        Long userId = message.getAuthor().getId();
        Long roomId = message.getRoom().getId();
        Timestamp localDateTime = Timestamp.valueOf(message.getDateTime());
        String messageText = message.getText();
        try (PreparedStatement chatRoomStatement = connection.prepareStatement("UPDATE chat.message SET messageuserid=?, messageroomid=?, messagetext=?, messagedate=? WHERE messageid=?")) {
            chatRoomStatement.setLong(1, userId);
            chatRoomStatement.setLong(2, roomId);
            chatRoomStatement.setString(3, messageText);
            chatRoomStatement.setTimestamp(4, localDateTime);
            chatRoomStatement.setLong(5, messageId);
            chatRoomStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
        }
    }

    private UserID findUserById(Long id) throws SQLException {
        Statement userStatement = connection.createStatement();
        ResultSet resultSet = userStatement.executeQuery("SELECT * FROM chat.user WHERE userid = " + id);
        resultSet.next();
        return new UserID(resultSet.getLong(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    null,
                   null
            );
    }
    private ChatRoom findRoomById(Long id) throws SQLException {
        Statement userStatement = connection.createStatement();
        ResultSet resultSet = userStatement.executeQuery("SELECT * FROM chat.chatroom WHERE roomid = " + id);
        resultSet.next();
        return new ChatRoom(resultSet.getLong(1),
                    resultSet.getString(2),
                null,
                null
            );


    }


}