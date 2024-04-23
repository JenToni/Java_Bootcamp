package edu.school21.chat;

import java.util.List;
import java.util.Objects;

public class UserID {

    private Long id;
    private String login;
    private String password;
    private List<ChatRoom> createdRooms;
    private List<ChatRoom> socializeRooms;


    public UserID(Long id, String login, String password, List<ChatRoom> createdRooms, List<ChatRoom> socializeRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.socializeRooms = socializeRooms;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ChatRoom> getCreatedRooms() {
        return createdRooms;
    }

    public void setCreatedRooms(List<ChatRoom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public List<ChatRoom> getSocializeRooms() {
        return socializeRooms;
    }

    public void setSocializeRooms(List<ChatRoom> socializeRooms) {
        this.socializeRooms = socializeRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserID userID = (UserID) o;
        return Objects.equals(id, userID.id) && Objects.equals(login, userID.login) && Objects.equals(password, userID.password) && Objects.equals(createdRooms, userID.createdRooms) && Objects.equals(socializeRooms, userID.socializeRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, socializeRooms);
    }

    @Override
    public String toString() {
        return "UserID{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", socializeRooms=" + socializeRooms +
                '}';
    }
}
