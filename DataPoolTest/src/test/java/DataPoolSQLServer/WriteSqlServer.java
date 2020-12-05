package DataPoolSQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class WriteSqlServer {

    public void WriteValue (int ParametroId, String ParametroResultado) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connnectionURL = "jdbc:sqlserver://192.168.0.17:1433;database=DataPoolTest1;user=sa;password=Ctek2314;";
        Connection con = DriverManager.getConnection(connnectionURL);

        System.out.println("Conexion realizada");

        //Actualizacion

        Statement upd = con.createStatement();
        upd.execute("update SetDatos1 set ResultadoDatoTest1 = '"
                + ParametroResultado + "' where IdRegistro = " + ParametroId);

    }



}
