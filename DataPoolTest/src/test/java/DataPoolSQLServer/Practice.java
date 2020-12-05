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

        //Consultas
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from SetDatos1");

        while (rs.next())
        {
          int IdRegistro = rs.getInt(1);
          String DataTest1 = rs.getString(2);

            System.out.println(IdRegistro + "-"+ DataTest1 );

        }

        //Actualizacion
        String Dato = "'456vpr'";

        Statement upd = con.createStatement();
        upd.execute("update SetDatos1 set ResultadoDatoTest1 = " + Dato + "where  DatoTest1 = 'dresses' ");

        //otra forma consulta
        ResultSet resul = null;
        Statement sel = con.createStatement();
        String selectsql = "select * from SetDatos1 where IdRegistro = 1";
        resul = sel.executeQuery(selectsql);

        while(resul.next())
        {
            int IdRegistro = resul.getInt(1);
            String DataTest1 = resul.getString(2);
            String ResultadoDatoTest1 = resul.getString(3);

            System.out.println(IdRegistro + "-" + DataTest1 + "-" + ResultadoDatoTest1 );
        }

        //insercion
        String Dato1 = "'dresses'";

        Statement ins = con.createStatement();
        ins.execute("insert into SetDatos1 (DatoTest1, ResultadoDatoTest1, DatoTest2, ResultadoDatoTest2) values (" + Dato1 + ",null,null,null)");



    }

}
