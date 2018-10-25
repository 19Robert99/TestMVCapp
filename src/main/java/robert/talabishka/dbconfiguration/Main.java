package robert.talabishka.dbconfiguration;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.LogManager;

/**
 * Created by Robert in 24.10.2018
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        try {
            LogManager.getLogManager().readConfiguration(
                    DBConnect.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        Locale.setDefault(Locale.ENGLISH);

        DBConnect dbConnect = new DBConnect();
        ResultSet resultSet = dbConnect.getResult("select * from Users");
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        dbConnect.close();
    }
}
