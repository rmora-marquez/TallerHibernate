
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author user10
 */
public class UsarBasedeDatos {

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost/orm",
                            "root", "");
            Statement cmd = con.createStatement();
            ResultSet rs  = cmd.executeQuery("Select * from productos");            
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                System.out.println(id + "," +nombre + ","+ precio + ","+ cantidad );
            }
            rs.close();
            cmd.close();
            con.close();
        }catch(SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
}
