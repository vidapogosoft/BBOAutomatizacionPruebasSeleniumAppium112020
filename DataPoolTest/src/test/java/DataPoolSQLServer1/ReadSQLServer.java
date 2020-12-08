package DataPoolSQLServer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadSQLServer
{
    public String GetValueTable (int Parametro) throws ClassNotFoundException, SQLException
    {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String conectionUrl = "jdbc:sqlserver://192.168.0.190:1433;database=DataPoolTest1;user=sa;password=Ctek2314;";
        //String conectionUrl = "jdbc:sqlserver://192.168.0.127:1433;database=DataPoolTest1;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(conectionUrl);

        System.out.println("Conexion Realizada");

        //Consultas del valor
        String DatoTest1 = "";

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("Select DatoTest1 from SetDatos1 Where IdRegistro = " + Parametro );

        while (rs.next())
        {
            DatoTest1 = rs.getString(1);

            System.out.println(DatoTest1 );

        }

        return DatoTest1;
    }


}
