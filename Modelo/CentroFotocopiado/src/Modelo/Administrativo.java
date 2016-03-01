package Modelo;


import java.util.*;

/**
 * 
 */
/**
 * 
 */
public class Administrativo extends Empleado {

        private Departamento departamento;
    
	/**
	 * Default constructor
	 */
	public Administrativo() {
	}
        
        
        /* Falto el constructor con los parametros de empleado y de administrador
           los agrego*/
        public Administrativo(int pCod, String pNom,Departamento pDepto) {
            super(pCod,pNom);
            this.departamento = pDepto;
        }

	/**
	 * @param pDepto 
	 * @return
	 */
	public void setDepto(Departamento pDepto) {
            this.departamento = pDepto;
	}

	/**
	 * @return
	 */
	public Departamento getDepto() {
		return this.departamento;
	}

	/**
	 * @return
	 */
        @Override
	public String toString() {
		// TODO implement here
		return super.toString() + " "+departamento;
	}

}