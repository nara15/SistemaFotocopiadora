/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrofotocopiado;
import Modelo.Administrativo;
import Modelo.BoletaSolicitudDocente;
import Modelo.Departamento;
import Modelo.Docente;
import Modelo.EstadoSolicitud;
import Modelo.Empleado;
import Modelo.Escuela;
import Modelo.TipoDocumento;
import Control.GestorSolicitudes;
import java.util.Date;
import java.util.Hashtable;
/**
 *
 * @author Ativ Book 4
 */
public class CentroFotocopiado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado em = new Docente(1,"c",Escuela.Administración);
        Empleado em2 = new Docente(2,"a",Escuela.Administración);
        Empleado em3 = new Docente(3,"b",Escuela.Construcción);
        Empleado em4 = new Docente(4,"d",Escuela.Computación);
        GestorSolicitudes ges = new GestorSolicitudes();
        BoletaSolicitudDocente boleta = new BoletaSolicitudDocente(null, null, TipoDocumento.Examen, 12, 10, em);
        BoletaSolicitudDocente boleta2 = new BoletaSolicitudDocente(null, null, TipoDocumento.Examen, 1230, 10, em3);
        BoletaSolicitudDocente boleta3 = new BoletaSolicitudDocente(null, null, TipoDocumento.Examen, 1230, 10, em2);
        BoletaSolicitudDocente boleta4 = new BoletaSolicitudDocente(null, null, TipoDocumento.Examen, 1230, 10, em2);
        BoletaSolicitudDocente boleta5 = new BoletaSolicitudDocente(null, null, TipoDocumento.Examen, 1230, 10, em4);
        ges.añadirBoleta(boleta);
        ges.añadirBoleta(boleta2);
        ges.añadirBoleta(boleta3);
        ges.añadirBoleta(boleta4);
        ges.añadirBoleta(boleta5);
        System.out.println(ges.generarReporte());
        //System.out.println(ges.generarEmpMasCopias());
//        float var = (float)1/3;
        //System.out.println(boleta3.getTotalCopias());
  /*      Hashtable<String, Integer> listaFacultadGastos = new Hashtable<>();
        listaFacultadGastos.put(((Docente)em).getEscuela().toString(), 5);
        listaFacultadGastos.put("hola2", 15);
        listaFacultadGastos.put("hola", 15);
        Integer contador = listaFacultadGastos.get("hola");
        contador +=contador;
        listaFacultadGastos.put("hola", contador);
        System.out.println(listaFacultadGastos.get(((Docente)em).getEscuela().toString())==null);/**/
    } 
}
