/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author hanss
 */

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TareasDAO {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List cargar(){
        List listaTareas = new ArrayList();       
        String sql="SELECT * FROM tb_tarea";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
                Tareas ta=new Tareas();
                ta.setId(rs.getInt("id"));
                ta.setTarea(rs.getString("tarea"));
                ta.setCompletado(rs.getString("completado"));
                
                listaTareas.add(ta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTareas;
    }
    
    public void agregar(Tareas tarea) {
        String sql="INSERT INTO tb_tarea (tarea) VALUES (?);";
        try {
            con=cn.conexion();           
            ps=con.prepareStatement(sql);
            ps.setString(1, tarea.getTarea());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }
    
    public void eliminar (Tareas tarea) {
        String sql="DELETE FROM tb_tarea WHERE id = (?);";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, tarea.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void actualizar(Tareas tarea) {
        String sql="UPDATE tb_tarea SET completado=(?) WHERE id =(?);";
        try {
            con=cn.conexion();           
            ps=con.prepareStatement(sql);
            ps.setString(1, tarea.getCompletado());
            ps.setInt(2, tarea.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }
    
}
