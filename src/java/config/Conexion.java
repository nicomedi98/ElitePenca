/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Conexion {
    
    public Connection getConnection(){
        
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/pencadb", "root", "Noviembre2018");
            return conexion;
        } catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
       
    }
    
}
