package DataPoolSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Practice {

    public static void main(String[] args) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connnectionURL = "jdbc:sqlserver://192.168.0.17:1433;database=DataPoolTest1;user=sa;password=Ctek2314;";
        Connection con = DriverManager.getConnection(connnectionURL);

        System.out.println("Conexion realizada");

    }

}
