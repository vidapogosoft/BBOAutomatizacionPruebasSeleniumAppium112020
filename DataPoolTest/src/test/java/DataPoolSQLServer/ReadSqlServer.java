package DataPoolSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;


public class ReadSqlServer {

    public String GetValue (int Parametro) throws ClassNotFoundException, SQLException
    {
        String DataTest1 = " ";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connnectionURL = "jdbc:sqlserver://192.168.0.17:1433;database=DataPoolTest1;user=sa;password=Ctek2314;";
        Connection con = DriverManager.getConnection(connnectionURL);

        System.out.println("Conexion realizada");

        //Consultas
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select DatoTest1 from SetDatos1 where IdRegistro = " + Parametro);

        while (rs.next())
        {
            DataTest1 = rs.getString(1);

            System.out.println(DataTest1 );

        }

        return DataTest1;
    }

}

