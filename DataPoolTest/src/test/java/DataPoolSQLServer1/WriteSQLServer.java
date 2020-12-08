package DataPoolSQLServer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class WriteSQLServer {

    public void WriteValueTable(int ParametroId, String ParametroResultado) throws ClassNotFoundException, SQLException
    {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String conectionUrl = "jdbc:sqlserver://192.168.0.190:1433;database=DataPoolTest1;user=sa;password=Ctek2314;";
        //String conectionUrl = "jdbc:sqlserver://192.168.0.127:1433;database=DataPoolTest1;integratedSecurity=true;";
        Connection con = DriverManager.getConnection(conectionUrl);

        System.out.println("Conexion Realizada");

        //Actualizacion

        Statement upd = con.createStatement();
        upd.execute("update SetDatos1 set ResultadoDatoTest1 = '"
                + ParametroResultado + "' where IdRegistro = " + ParametroId);


    }


}
