package edu.school21.chat.Chat;

import java.util.List;
import java.util.Objects;

public class ChatRoom {

    private Long id;
    private String chatName;
    private UserID chatOwner;
    private List<Message> messages;

    public ChatRoom(Long id, String chatName,UserID chatOwner, List<Message> messages){
        this.id = id;
        this.chatName = chatName;
        this.chatOwner = chatOwner;
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public UserID getChatOwner() {
        return chatOwner;
    }

    public void setChatOwner(UserID chatOwner) {
        this.chatOwner = chatOwner;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatRoom chatRoom = (ChatRoom) o;
        return Objects.equals(id, chatRoom.id) && Objects.equals(chatName, chatRoom.chatName) && Objects.equals(chatOwner, chatRoom.chatOwner) && Objects.equals(messages, chatRoom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatName, chatOwner, messages);
    }

    @Override
    public String toString() {
        return "ChatRoom{" +
                "id=" + id +
                ", chatName='" + chatName + '\'' +
                ", chatOwner='" + chatOwner + '\'' +
                ", messages=" + messages +
                '}';
    }
}
