/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Tareas;
import Modelo.TareasDAO;
import java.util.List;

/**
 *
 * @author hanss
 */
public class TareaControlador {
    TareasDAO tdao=new TareasDAO();
    
    public List<Tareas> cargar(){
        return tdao.cargar();
    }
    
    //public void agregar(String tarea){
        //Tareas nuevaTarea = new Tareas();
        //nuevaTarea.setTarea(tarea);
        
       // tdao.agregar(nuevaTarea);
    //}
}
