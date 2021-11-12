package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.CategoryUser;
import model.User;

public class QueryController {
    
    DatabaseHandler conn = new DatabaseHandler();
    
    public boolean insertUser(User user) {
        conn.connect();
        String query = "INSERT INTO `user`(`name`, `email`, `password`, `id_category`) VALUES ('?','?','?','?')";
        try {
            PreparedStatement stmt = conn.conn.prepareStatement(query);
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getIdCategory());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public User getUser(String email, String password) {
        conn.connect();
        String query = "SELECT `id_user`, `name`, `email`, `password`, `id_category` FROM `user` WHERE email='" + email + "' AND password='" + password + "'";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            User user = new User();

            while (result.next()) {
                user.setIdUser(result.getInt("id_user"));
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setPassword(result.getString("password"));
                user.setIdCategory(result.getInt("id_category"));
            }

            if (user.getIdUser() != 0) {
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<String> getCategoryUser() {
        conn.connect();
        String query = "SELECT `id_category`, `name` FROM `categoryuser` WHERE 1";
        try {
            Statement stmt = conn.conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            ArrayList<String> categories = new ArrayList<>();
            
            while (result.next()) {
                // CategoryUser categoryUser = new CategoryUser();
                // categoryUser.setIdCategory(result.getInt("id_category"));
                // categoryUser.setName(result.getString("name"));
                categories.add(result.getString("name"));
            }

            return categories;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
