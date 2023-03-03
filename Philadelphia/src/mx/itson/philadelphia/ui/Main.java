
package mx.itson.philadelphia.ui;

import java.util.Date;
import mx.itson.philadelphia.persistencia.ConductorDAO;

public class Main {
    
    public static void main(String[] args) {
        
        ConductorDAO c = new ConductorDAO();
        c.obtenerTodos();
        c.guardar("Ricardo Garcia", "32874", new Date() );
    }
}
