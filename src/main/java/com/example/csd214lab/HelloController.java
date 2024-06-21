package com.example.csd214lab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    public TableView<user> userTable;
    public TableColumn<user, Integer> userID; // Changed from 'id' to 'userID'
    public TableColumn<user, String> username;
    public TableColumn<user, String> useremail;
    public TableColumn<user, String> userpassword;
    public TextField uid;
    public TextField uusername;
    public TextField uuseremail;
    public TextField uuserpassword;
    @FXML
    private Label welcomeText;

    ObservableList<user> list = FXCollections.observableArrayList();

    @FXML
    protected void onHelloButtonClick() {
        loadData();
    }

    private void loadData() {
        list.clear();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csdlab";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                int userID = resultSet.getInt("userID"); // Changed from 'id' to 'userID'
                String username = resultSet.getString("username");
                String useremail = resultSet.getString("useremail");
                String userpassword = resultSet.getString("userpassword");
                userTable.getItems().add(new user(userID, username, useremail, userpassword));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userID.setCellValueFactory(new PropertyValueFactory<>("userID")); // Changed from 'id' to 'userID'
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        useremail.setCellValueFactory(new PropertyValueFactory<>("useremail"));
        userpassword.setCellValueFactory(new PropertyValueFactory<>("userpassword"));
        userTable.setItems(list);
    }

    public void InsertData(ActionEvent actionEvent) {
        String username = uusername.getText();
        String useremail = uuseremail.getText();
        String userpassword = uuserpassword.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csdlab";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to insert data into the database
            String query = "INSERT INTO `user`( `username`, `useremail`, `userpassword`) VALUES ('" + username + "','" + useremail + "','" + userpassword + "')";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void UpdateData(ActionEvent actionEvent) {
        String userID = uid.getText(); // Changed from 'id' to 'userID'
        String username = uusername.getText();
        String useremail = uuseremail.getText();
        String userpassword = uuserpassword.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/csdlab";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to update data in the database
            String query = "UPDATE `user` SET `username`='" + username + "',`useremail`='" + useremail + "',`userpassword`='" + userpassword + "' WHERE userID='" + userID + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void DeleteData(ActionEvent actionEvent) {
        String userID = uid.getText(); // Changed from 'id' to 'userID'

        String jdbcUrl = "jdbc:mysql://localhost:3306/csdlab";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to delete data from the database
            String query = "DELETE FROM `user` WHERE userID='" + userID + "'";
            Statement statement = connection.createStatement();
            statement.execute(query);
            // Populate the table with data from the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void LoadData(ActionEvent actionEvent) {
        String userID = uid.getText(); // Changed from 'id' to 'userID'

        String jdbcUrl = "jdbc:mysql://localhost:3306/csdlab";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            // Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM user WHERE userID='" + userID + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            // Populate the table with data from the database
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String useremail = resultSet.getString("useremail");
                String userpassword = resultSet.getString("userpassword");

                uusername.setText(username);
                uuseremail.setText(useremail);
                uuserpassword.setText(userpassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
