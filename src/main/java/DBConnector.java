import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBConnector implements Connectable{
    private static String myDriver = "org.sqlite.JDBC";
    private static String urlDB = "jdbc:sqlite:Database.db";

    private static final DBConnector instance = new DBConnector();

    static public DBConnector getInstance() {
        return instance;
    }

    private DBConnector() {}

    @Override
    public ObservableList<Data> viewHistory() {
        ObservableList<Data> datas = FXCollections.observableArrayList();
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(urlDB);
            if (connection != null) {
                String query = "select * from Data";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    String type = resultSet.getString("Type");
                    String detail = resultSet.getString("Description");
                    String money = resultSet.getString("Amount");
                    datas.add(new Data(type, detail, money));
                }
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return datas;
    }

    @Override
    public void add(String type, String detail, String amount) {
        try {
            Class.forName(myDriver);
            Connection connection = DriverManager.getConnection(urlDB);
            if (connection != null) {
                String query = "insert into Data (Type, Description, Amount) values ('" + type + "' , '" + detail + "' , '" + amount + "')";
                PreparedStatement p = connection.prepareStatement(query);
                p.executeUpdate();
            }
            connection.close();
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
