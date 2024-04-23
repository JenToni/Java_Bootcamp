package edu.school21.chat.Main;

import edu.school21.chat.Repository.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;

import java.util.Scanner;




public class Program {

    public static void main(String[] args) throws SQLException {

        MessagesRepositoryJdbcImpl messagesRepository = new MessagesRepositoryJdbcImpl(DBUtils.getDataSource());
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(true) {
            System.out.println("Enter a message ID");
            System.out.print("-> ");
            str = scanner.nextLine();
            if(str.equals("exit")) {
                System.out.println("Bye, bye!!!!");
                System.exit(-1);
            }
            long id = Long.parseLong(str);
            messagesRepository.findById(id);
        }
    }

}
