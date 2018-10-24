package robert.talabishka.dbconfiguration;

import java.sql.*;
import java.util.logging.*;

/**
 * Created by Robert in 23.10.2018
 */
public class DBConnect {


    static private Logger LOGGER = Logger.getLogger(DBConnect.class.getName());

    private Connection connection;
    private Statement st;

    private Connection connect() {

        String host = "localhost";
        int port = 1521;
        String sid = "XE";
        String user = "robert";
        String pwd = "p1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.WARNING, "Oracle JDBC Driver is not found", e);
        }

        String url = String.format("jdbc:oracle:thin:@%s:%d:%s", host, port, sid);

        try {
            connection = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "Connection Failed", e);
        }

        if (connection != null) {
            return connection;
        } else {
            LOGGER.log(Level.WARNING, "Connection is empty");
            throw new IllegalArgumentException();//Тут уже надо писать свою реализацию exception (EmptyConnectionException)
        }

    }

    public ResultSet getResult(String query) {

        ResultSet rs = null;
        try {
            st = connect().createStatement();
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
        return rs;
    }

    public void close() {
        try {
            st.close();
            connection.close();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage(), e);
        }
    }
}
