package Modelo;



/**
 * 
 */
import java.util.*;

/**
 * 
 */
public class Docente extends Empleado {

    
        private Escuela escuelaPerteneciente;
	/**
	 * Default constructor
	 */
	public Docente() {
	}
        
        /* Falto el constructor con los parametros de empleado y de docente
           los agrego*/
        public Docente(int pCod, String pNom, Escuela pEsc){
            
            super(pCod,pNom);
            this.escuelaPerteneciente = pEsc;
            
        }
        

	/**
	 * @param pNom 
	 * @return
	 */
	public void setEscuela(Escuela pNom) {
		this.escuelaPerteneciente = pNom;
	}

	/**
	 * @return
	 */
	public Escuela getEscuela() {
		return this.escuelaPerteneciente;
	}

	/**
	 * @return
	 */
        @Override
	public String toString() {
		
		return super.toString() +" "+" de "+ escuelaPerteneciente;
	}

}