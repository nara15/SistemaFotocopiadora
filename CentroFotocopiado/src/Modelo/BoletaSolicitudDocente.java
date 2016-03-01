package Modelo;



/**
 * 
 */
import java.util.*;

/**
 * 
 */
public class BoletaSolicitudDocente extends BoletaSolicitud {

    /**
     * Default constructor
     * @param cursoSolicitante
     */
    public BoletaSolicitudDocente(Curso cursoSolicitante, Date fecha, TipoDocumento tipoDoc, int cantOriginales, int cantJuegos , Empleado solicitante) 
    {
        super(fecha, tipoDoc, cantOriginales, cantJuegos, solicitante);
        this.cursoSolicitante = cursoSolicitante;
    }

    

	private Curso cursoSolicitante;

	/**
	 * @param pCurso
	 */
//	public void BoletaSolicitudDocente(Curso pCurso) {
//		// TODO implement here
//	}

	/**
	 * @return
	 */
	public String getNomCurso() {
		String retornar = "";
		retornar += cursoSolicitante.getNombre();
                return retornar;
	}

	/**
	 * @return
	 */
	public String getCodCurso() {
		String retornar = "";
		retornar += cursoSolicitante.getCodigo();
                return retornar;
	}

	/**
	 * @return
	 */
	public String getNomEscuela() {
            String retornar = "";
            //String nombreClase = super.getSolicitante().getClass().getName();
           // retornar += nombreClase.substring(7, nombreClase.length());
            Docente doc = (Docente) super.getSolicitante();
            retornar += doc.getEscuela();
            return retornar;
	}
        
        
        
        public String toString (){
            String retornar = "";
            retornar += super.toString();
            retornar += "Curso: "+ cursoSolicitante.toString();
            return retornar;
        }

}