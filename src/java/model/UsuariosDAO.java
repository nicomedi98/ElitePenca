/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class UsuariosDAO {
    
    Connection conexion;
    
    public UsuariosDAO(){
        Conexion con = new Conexion();
        conexion = con.getConnection();
    
    }
    
    public List<Usuarios> listarUsuarios(){
        PreparedStatement ps;
        ResultSet rs;
        
        List<Usuarios> lista = new ArrayList<>();
        
        try {
            
            ps = conexion.prepareStatement("SELECT idUsuario, nombre, apellido, email, password, puntos, esAdmin from Usuarios");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int puntos = rs.getInt("puntos");
                boolean esAdmin = rs.getBoolean("esAdmin");
                
                Usuarios usuario = new Usuarios(idUsuario, nombre, apellido, email, password, puntos, esAdmin);
                
                lista.add(usuario);
                
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public Usuarios mostrarUsuario(int _id){
        PreparedStatement ps;
        ResultSet rs;
        
        Usuarios usuario = null;
        
        try {
            
            ps = conexion.prepareStatement("SELECT idUsuario, nombre, apellido, email, password, puntos, esAdmin FROM Usuarios WHERE idUsuario = ?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int puntos = rs.getInt("puntos");
                boolean esAdmin = rs.getBoolean("esAdmin");
                
                usuario = new Usuarios(idUsuario, nombre, apellido, email, password, puntos, esAdmin);

                
            }
            return usuario;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean insertarUsuario(Usuarios usuario){
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO Usuarios (nombre, apellido, email, password) VALUES (?, ?, ?, ?)");
            ps.setString(1, usuario.getNombre()); //idUsuario, nombre, apellido, email, password, puntos, esAdmin 
            ps.setString(2, usuario.getApellido()); //idUsuario, nombre, apellido, email, password, puntos, esAdmin 
            ps.setString(3, usuario.getEmail()); //idUsuario, nombre, apellido, email, password, puntos, esAdmin 
            ps.setString(4, usuario.getPassword()); //idUsuario, nombre, apellido, email, password, puntos, esAdmin 
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean actualizar(Usuarios usuario){
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("UPDATE Usuarios SET nombre = ?, apellido = ?, email = ?, password = ? WHERE idUsuario = ?");
            ps.setString(1, usuario.getNombre()); 
            ps.setString(2, usuario.getApellido()); 
            ps.setString(3, usuario.getEmail());  
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getIdUsuario());
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminar(int _id){
        PreparedStatement ps;
        
        try {
            
            ps = conexion.prepareStatement("DELETE FROM Usuarios WHERE idUsuario = ?");
            ps.setInt(1, _id);
            ps.execute();
            
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
