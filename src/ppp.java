import java.sql.*;

public class ppp {
    public static void main(String[] args) {

        try{
            //  class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pledge","root","1775");
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT *FROM login");
            while(rs.next()) {
String data=rs.getString(1);
   data= rs.getString("username");
   System.out.println(data);
            }
        }catch(Exception ep){
            ep.printStackTrace();
        }
    }
}