
package Control;

import Modelo.Administrativo;
import Modelo.BoletaSolicitud;
import Modelo.BoletaSolicitudDocente;
import Modelo.Curso;
import Modelo.Departamento;
import Modelo.Docente;
import Modelo.Empleado;
import Modelo.Escuela;
import Modelo.TipoDocumento;
import java.util.Date;

/**
 *
 * @author José Mario Naranjo Leiva
 */
public class Controlador {
    
    private final GestorSolicitudes gestorSolicitudes;
    private int idDocente;
    private int idAdministrativo;
    
    public Controlador()
    {
        gestorSolicitudes = new GestorSolicitudes();
        idDocente = 1;
        idAdministrativo = 1;
    }
    
    /* Método para realizar una solicitud docente */
    public boolean solicitarCopiasDocente(String pNombreDocente, int pCantOriginales, int pCantJuegos,
                                        int pEscuelaIndex, String pTipoDoc, String pNomCurso, String pCodCurso)
    {
        Escuela escuela = Escuela.values()[pEscuelaIndex];
        Empleado em = new Docente(this.idDocente, pNombreDocente , escuela);
        this.idDocente ++;

        Curso curso = new Curso(pCodCurso, pNomCurso);      
        TipoDocumento tdoc = Enum.valueOf(TipoDocumento.class, pTipoDoc.replaceAll("\\s", "")); //El replace es para eliminar espacios en blanco del nombre del tipo para su búsqueda
        BoletaSolicitudDocente boleta = new BoletaSolicitudDocente(curso, new Date(), tdoc, pCantOriginales, pCantJuegos, em);
        
        gestorSolicitudes.añadirBoleta(boleta);
        
        return (pCantJuegos * pCantOriginales) < 200;
    }
    
     /* Método para realizar una solicitud administrativa */
    public boolean solicitarCopiasAdministrativas(String pNombreAdministrativo, int pCantOriginales, int pCantJuegos,
                                                    int pDeptoIndex, String pTipoDoc)
    {
        Departamento depto = Departamento.values()[pDeptoIndex];
        Administrativo admi = new Administrativo(this.idAdministrativo, pNombreAdministrativo, depto);
        this.idAdministrativo ++;
        
       
        TipoDocumento tdoc = Enum.valueOf(TipoDocumento.class, pTipoDoc.replaceAll("\\s", ""));
        BoletaSolicitud boleta = new BoletaSolicitud(new Date(), tdoc, pCantOriginales, pCantJuegos, admi);
        
        gestorSolicitudes.añadirBoleta(boleta);
        
        return (pCantJuegos * pCantOriginales) < 200;
    }
    
    
    public String generarReporte()
    {
        return gestorSolicitudes.generarReporte();
    }
    
}
