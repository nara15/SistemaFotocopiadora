package Control;
import Modelo.BoletaSolicitud;
import Modelo.BoletaSolicitudDocente;
import Modelo.Docente;
import Modelo.Empleado;
import Modelo.EstadoSolicitud;
import Modelo.TipoDocumento;
import java.util.*;
import static java.util.Comparator.comparing;

public class GestorSolicitudes  {
    
    private ArrayList<BoletaSolicitud> listaAnuladas;
    private ArrayList<BoletaSolicitud> listaAprobadas;
    private ArrayList<BoletaSolicitud> listaProcesadas;
    
    public GestorSolicitudes() 
    {
        listaAnuladas = new ArrayList<>();
        listaAprobadas = new ArrayList<>();
        listaProcesadas = new ArrayList<>();
    }
   
    /*Determina el total de copias hechas en el dia.*/
    public int generarCierre() {
        int totalCopias = 0;
        for (BoletaSolicitud listaAnulada : listaAnuladas) {
            //System.out.println(listaAnulada.getIdentificador());
            listaProcesadas.add(listaAnulada);
        }
            listaAnuladas = new ArrayList<>();
        for (BoletaSolicitud listaAprobada : listaAprobadas) {
            totalCopias += listaAprobada.getTotalCopias();
            listaProcesadas.add(listaAprobada);
        }
            listaAprobadas= new ArrayList<>();
        listaProcesadas.sort(comparing((boletaSolicitud) -> boletaSolicitud.getIdentificador()));
        return totalCopias;
    }

    public String generarFacultadMayorGasto() {
        ArrayList<BoletaSolicitudDocente> boletasDocente = new ArrayList<>();
//        System.out.println(listaAprobadas.size());
        for (BoletaSolicitud listaAprobada : listaAprobadas) {
            
            if (listaAprobada.getClass().getName().equals("Modelo.BoletaSolicitudDocente")) {
                boletasDocente.add((BoletaSolicitudDocente)listaAprobada);
            }
        }
        Hashtable<String, Integer> listaFacultadGastos = new Hashtable<>();
        
        for (BoletaSolicitudDocente boletasDocente1 : boletasDocente) {
            if(listaFacultadGastos.get(((Docente)boletasDocente1.getSolicitante()).getEscuela().toString())==null){
                listaFacultadGastos.put(((Docente)boletasDocente1.getSolicitante()).getEscuela().toString()
                        , boletasDocente1.getTotalCopias());
//                System.out.println("entra "+boletasDocente1.getTotalCopias()+((Docente)boletasDocente1.getSolicitante()).getEscuela().toString());
            }
            else{
                Integer contadorCopias = listaFacultadGastos.get(((Docente)boletasDocente1.getSolicitante()).getEscuela().toString());
                contadorCopias += boletasDocente1.getTotalCopias();
                //System.out.println("entra suma");
                listaFacultadGastos.put(((Docente)boletasDocente1.getSolicitante()).getEscuela().toString(), contadorCopias);
            }
        }
        String key= "No hay datos";
        Integer value =0;
        for (Map.Entry<String, Integer> entrySet : listaFacultadGastos.entrySet()) {
//            System.out.println(key+"-"+value);
            if (entrySet.getValue() > value) {
                key = entrySet.getKey();
                value = entrySet.getValue();
            }
            
                       
        }
        return key + " con: " + value;
    }

   public String generarEmpMasCopias() {
        Hashtable<Empleado,Integer> copiasPorEmpleado = generarRegistroCopias(); //generamos el registro de empleados y copias
        Enumeration<Empleado> llaves = copiasPorEmpleado.keys();                 
        Empleado clave; //para recorrer el hastable
        Empleado masCopias = new Empleado(); //empleado con mas copias
        int copias = 0; //cantidad de copias para ir comparando y sacar al mayor
        while(llaves.hasMoreElements()) { //recorrido del hashtable
            clave = llaves.nextElement(); 
            if(copiasPorEmpleado.get(clave) > copias) {
                copias = copiasPorEmpleado.get(clave);
                masCopias = clave;
            }
        }
        String msj = masCopias.toString();
        return msj;
    }
    
    /* Obtiene los empleados y las copias que estos han sacado. Los ordena en un
       Hashtable.*/
    private Hashtable<Empleado, Integer> generarRegistroCopias() {
         Hashtable<Empleado, Integer> copiasPorEmpleado = new Hashtable<Empleado, Integer>();
        int cantProcesadas = this.listaProcesadas.size();
        int cantFotocopias;
        Empleado empleado;
        //obtencion de los empleados....
        for(int indice = 0; indice < cantProcesadas; indice++) {      
            BoletaSolicitud boleta = this.listaProcesadas.get(indice);           //Boleta actual.             
            if(boleta.getEstado() != EstadoSolicitud.Anulada) {                  //no se cuentan las anuladas
                empleado = boleta.getSolicitante(); 
                cantFotocopias = boleta.getTotalCopias(); 

                copiasPorEmpleado.putIfAbsent(empleado, 0);                          //Si no se tiene registro del empleado en el hash, se abre uno.
                int nuevoValor = copiasPorEmpleado.get(empleado) + cantFotocopias;   //suammos...
                copiasPorEmpleado.put(empleado, nuevoValor);                         //guardamos...   
            }    
        }
        return copiasPorEmpleado;
    }     

    public String generarPorcentajes() {
        ArrayList<BoletaSolicitud> listaDocentesAprobados = new ArrayList<>();
        ArrayList<BoletaSolicitud> listaDocentesAnuladas = new ArrayList<>();
        for (BoletaSolicitud listaAprobada : listaAprobadas) {
            if (listaAprobada.getClass().getName().equals("Modelo.BoletaSolicitudDocente")) {
                listaDocentesAprobados.add(listaAprobada);
            }
        }
       
        for (BoletaSolicitud listaAnulada : listaAnuladas) {
            if (listaAnulada.getClass().getName().equals("Modelo.BoletaSolicitudDocente")) {
                listaDocentesAnuladas.add(listaAnulada);
            }
        }
            int totales = listaDocentesAnuladas.size() + listaDocentesAprobados.size();
            float porcetajeAprobadas = ((float)listaDocentesAprobados.size()/totales)*100, 
                    porcentajeAnuladas= ((float)listaDocentesAnuladas.size()/totales)*100;
            String retornar = "";
            retornar += "El total de copias fue de: "+totales + "\n";
            retornar += "El total de copias aprobadas fue de: "+
                    listaDocentesAprobados.size() + "\n";
            retornar += "El total de copias anuladas fue de: "+
                    listaDocentesAnuladas.size() + "\n";
            retornar += "El total de copias en porcentaje anuladas fue de: "
                    +porcentajeAnuladas + "\n";
            retornar += "El total de copias en procentajes aprobadas  fue de: "
                    +porcetajeAprobadas + "\n";
            return retornar;
    }

    public String generarReporte() {
  
            int solicitudesTotales =0; // cantidad de solicitudes totales
            int solicitudesAprobadas = this.listaAprobadas.size(); // cantidad de solicitudes atendidas
            int solicitudesAnuladas = this.listaAnuladas.size(); // cantidad de solicitudes anuladas
            int solicitudesSinAutorizacion =0; // cantidad de solicitudes sin autorizacion 
            int solicitudesAutorizadas =0; // cantidad de solicitudes con Autorizacion
            
            
            
            for(int i=0; i < this.listaAprobadas.size(); i++){
                
                if(listaAprobadas.get(i).getEstado() == EstadoSolicitud.Atendida){
                    solicitudesSinAutorizacion++;
                }else{
                   solicitudesAutorizadas++; 

                }
                
            }// fin del for
            
            
            // Suma la cantidad de solicitudes anuladas mas la cantidad de solicitudes atendidas
            solicitudesTotales = solicitudesAnuladas + solicitudesAprobadas;
            
            // 
            String Resultado = "Num Solicitudes Totales: " + Integer.toString(solicitudesTotales) + "\n" +
                               "Num Solicitudes Aprobadas: " + Integer.toString(solicitudesAprobadas) + "\n" +
                               "Num Solicitudes Anuladas: " + Integer.toString(solicitudesAnuladas) + "\n" +
                               "Num Solicitudes Aprobadas Sin Autorizacion: " + Integer.toString(solicitudesSinAutorizacion) + "\n" +
                               "Num Solicitudes Aprobadas Con Autorizacion: " + Integer.toString(solicitudesAutorizadas);
   
            return Resultado;
            
 }//Fin del metodo
    public void añadirBoleta(BoletaSolicitud pBoleta){
        if (pBoleta.getEstado() == EstadoSolicitud.Anulada) {
            listaAnuladas.add(pBoleta);
        }
        else{
            listaAprobadas.add(pBoleta);
        }
    }
}