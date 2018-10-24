package robert.talabishka.dbconfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Robert in 24.10.2018
 */
public class Main {

    public static void main(String[] args) throws SQLException {
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
