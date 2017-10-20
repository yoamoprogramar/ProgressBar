
package dao;

import conexion.Conexion;
import modelo.Usuario;

public class daoUsuario {
    Conexion cx;
    
    
    public daoUsuario(){
        cx=new Conexion();
    }
    
    public String select(){ 
        
        return "x";
    }
    
    public void insert(Usuario piko){
        
    }
    public void delete(int Id){
        
    }
    public void update(Usuario piko){
        
    }
    
}
