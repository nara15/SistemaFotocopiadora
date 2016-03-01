package Modelo;

/**
 * 
 */
public class Empleado {

	/**
	 * Default constructor
	 */
	public Empleado() {
	}

	/**
	 * 
	 */
	private int codigo;

	/**
	 * 
	 */
	private String nombre;

	/**
	 * 
	 */
	private boolean estaActivo;


	/**
	 * 
	 */
	public void Empleado() {
		// TODO implement here
	}

	/**
	 * @param pCod 
	 * @param pNom
	 */
	public Empleado(int pCod, String pNom) {
            this.codigo = pCod;
            this.nombre = pNom;
            this.estaActivo = true;
            
	}

	/**
	 * @param pCod
         * El parametro String pCod, String pNom) y el atributo es int codigo, cambio el String del parametro por un int
	 */
	public void setCodigo(int pCod) {
		this.codigo = pCod;
	}

	/**
	 * @param pNom 
	 * @return
	 */
	public void setNombre(String pNom) {
		this.nombre = pNom;
	}

	/**
	 * @return int codigo
         * El return es String pero el atributo es un int, cambio el return del get
	 */
	public int getCodido() {
		return this.getCodido();
	}

	/**
	 * @return string nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * @return 
	 */
	public boolean estaActivo() {
		return this.estaActivo;
	}

	/**
	 * @return
	 */
	public void activar() {
		this.estaActivo = true;
	}

	/**
	 * @return
	 */
	public void desactivar() {
		this.estaActivo = false;
		
	}

	/**
	 * @return
	 */
        @Override
	public String toString() {
		
                String empleado = "Codigo "+this.codigo + " nombre " + this.getNombre();
                
		return empleado;
	}

}