package DataPoolSQLServer1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticaSQL {

    public static void main (String[] args) throws ClassNotFoundException, SQLException
    {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String conectionUrl = "jdbc:sqlserver://192.168.0.190:1433;database=DataPoolTest1;user=sa;password=Ctek2314;";
            //String conectionUrl = "jdbc:sqlserver://192.168.0.127:1433;database=DataPoolTest1;integratedSecurity=true;";
            Connection con = DriverManager.getConnection(conectionUrl);

            System.out.println("Conexion Realizada");



            //Actualizacion
            String result = "'MisCambios'";

            Statement upd = con.createStatement();
            upd.execute("update SetDatos1 set ResultadoDatoTest1 = " + result + " where DatoTest1 = 'dresses'");


            String dato = "'MiRegistro'";
            Statement ins = con.createStatement();
            ins.execute("insert into SetDatos1 (DatoTest1, ResultadoDatoTest1, DatoTest2, ResultadoDatoTest2) values (" + dato + ",null,null,null)" );


            Statement st = con.createStatement();

            //Consultas
            ResultSet rs = st.executeQuery("Select * from SetDatos1");

            while (rs.next())
            {
                int IdRegistro = rs.getInt(1);
                String DatoTest1 = rs.getString(2);

                System.out.println(IdRegistro + "-"+ DatoTest1 );

            }

    }

}
