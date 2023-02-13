package org.uv.practicaclase1cc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fermin
 */
public class PracticaClase1CC {

    public static void main(String[] args) {
        
        Connection con=null;
        Statement str=null;
        try {
            String url="jdbc:postgresql://localhost:7000/ejemplo";
            String usr="postgres";
            String pwd="postgres";
            String sql="INSERT INTO empleado(id,nombre,direccion,telefono) "
                    + "VALUES ('3','Antonio','Avenida 2','2223334441');";
            
            con=DriverManager.getConnection(url,usr,pwd);
            Logger.getLogger(PracticaClase1CC.class.getName()).log(Level.INFO,"Se conecto...");
            
            str=con.createStatement();
            boolean res= str.execute(sql);
            
            if (!res){
                Logger.getLogger(PracticaClase1CC.class.getName()).log(Level.INFO,"Se guardo...");
            }
            else{
                Logger.getLogger(PracticaClase1CC.class.getName()).log(Level.INFO,"No se guardo...");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PracticaClase1CC.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if (str!=null) 
                    try {
                        str.close();
            } catch (SQLException ex) {
                Logger.getLogger(PracticaClase1CC.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con!=null) 
                    con.close();               
            } catch (SQLException ex) {
                Logger.getLogger(PracticaClase1CC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
