import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class mysqls {

    String dbURL;
    Connection con;
    ResultSet rs;
java.sql.Statement st;
    public void mysqlss() throws SQLException{
        dbURL="jdbc:mysql://localhost:3306/akifs";
        con=DriverManager.getConnection(dbURL,"root","akif123");
        st=con.createStatement();
        rs= st.executeQuery("SELECT *FROM bilgi");   

        /*while(rs.next()){
            System.out.println(rs.getString("isim")+rs.getString("soyisim"));
        }*/
    }   
}