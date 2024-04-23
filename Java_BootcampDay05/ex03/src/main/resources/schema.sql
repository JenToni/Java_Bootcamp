DROP SCHEMA IF EXISTS chat CASCADE;
CREATE SCHEMA IF NOT EXISTS chat;

CREATE TABLE IF NOT EXISTS chat.User (
    UserId SERIAL PRIMARY KEY,
    Login VARCHAR(50) NOT NULL UNIQUE,
    Password VARCHAR(50) NOT NULL);

CREATE TABLE IF NOT EXISTS chat.Chatroom (
    RoomId SERIAL PRIMARY KEY,
    RoomName VARCHAR(50) NOT NULL UNIQUE,
    RoomeOwnerID INT NOT NULL,
    FOREIGN KEY (RoomeOwnerId) REFERENCES chat.User(UserId));

CREATE TABLE IF NOT EXISTS chat.Message (
    MessageId SERIAL PRIMARY KEY,
    MessageUserId INT NOT NULL,
    MessageRoomId INT NOT NULL,
    MessageText TEXT NOT NULL,
    MessageDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (MessageUserId) REFERENCES chat.User(UserId),
    FOREIGN KEY (MessageRoomId) REFERENCES chat.Chatroom(RoomId));