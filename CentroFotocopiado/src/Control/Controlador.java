
package Control;

import Modelo.BoletaSolicitudDocente;
import Modelo.Curso;
import Modelo.Docente;
import Modelo.Empleado;
import Modelo.Escuela;
import Modelo.TipoDocumento;

/**
 *
 * @author José Mario Naranjo Leiva
 */
public class Controlador {
    
    private final GestorSolicitudes gestorSolicitudes;
    private int idDocente;
    
    public Controlador()
    {
        gestorSolicitudes = new GestorSolicitudes();
        idDocente = 1;
    }
    
    public boolean solicitarCopiasDocente(String pNombreDocente, int pCantOriginales, int pCantJuegos, int pTotalCopias,
                                        int pEscuelaIndex, String pTipoDoc, String pNomCurso, String pCodCurso)
    {
        Escuela escuela = Escuela.values()[pEscuelaIndex];
        Empleado em = new Docente(this.idDocente, pNombreDocente , escuela);

        Curso curso = new Curso(pCodCurso, pNomCurso);      
        TipoDocumento tdoc = Enum.valueOf(TipoDocumento.class, pTipoDoc.replaceAll("\\s", "")); //El replace es para eliminar espacios en blanco del nombre del tipo para su búsqueda
        BoletaSolicitudDocente boleta = new BoletaSolicitudDocente(curso, null, tdoc, pCantOriginales, pCantJuegos, em);
        
        gestorSolicitudes.añadirBoleta(boleta);
        
        return pTotalCopias < 200;
    }
    
}
