package Modelo;


import java.util.*;

/**
 * 
 */
public class BoletaSolicitud {

    /**
     * Default constructor
     * @param fecha
     * @param tipoDoc
     * @param cantOriginales
     * @param cantJuegos
     * @param solicitante
     */
    public BoletaSolicitud(Date fecha, TipoDocumento tipoDoc, int cantOriginales, int cantJuegos, Empleado solicitante) {
        this.fecha = fecha;
        this.tipoDoc = tipoDoc;
        this.cantOriginales = cantOriginales;
        this.cantJuegos = cantJuegos;
        int probTotalCopias = cantJuegos*cantOriginales;
        this.totalCopias = probTotalCopias;
        if (probTotalCopias >= 200) {
            this.estado = autorizar();
        }
        else{
            this.estado = EstadoSolicitud.Atendida;
        }
        this.solicitante = solicitante;
        identificador = numero;
        numero++;
        
    }
    
	private static int numero;

        private int identificador;
	/**
	 * 
	 */
	private Date fecha;

	/**
	 * 
	 */
	private TipoDocumento tipoDoc;

	/**
	 * 
	 */
	private int cantOriginales;

	/**
	 * 
	 */
	private int totalCopias;

	/**
	 * 
	 */
	private int cantJuegos;

	/**
	 * 
	 */
	private EstadoSolicitud estado;



	/**
	 * 
	 */
	private Empleado solicitante;


	/**
	 * 
     * @return 
	 */
	

        public Empleado getSolicitante() {
            return solicitante;
        }

	/**
	 * @param pFecha 
	 * @return
	 */
	public void setFecha(Date pFecha) {
		fecha = pFecha;
		
	}

	/**
	 * @param pTipo 
	 * @return
	 */
	public void setTipoDoc(TipoDocumento pTipo) {
		tipoDoc = pTipo;
		
	}

	/**
	 * @param pCant 
	 * @return
	 */
	public void setCantOriginales(int pCant) {
            cantOriginales = pCant;
            totalCopias = cantJuegos * cantJuegos;
		
	}

	/**
	 * @param pCant 
	 * @return
	 */
//	public void setTotalCopias(int pCant) {
//		totalCopias = pCant;
//		
//	}

	/**
	 * @param pCant 
	 * @return
	 */
	public void setCantJuegos(int pCant) {
		cantJuegos = pCant;
                totalCopias = cantJuegos * cantOriginales;
		
	}

	/**
	 * @param pEstado 
	 * @return
	 */
	public void setEstado(EstadoSolicitud pEstado) {
		estado = pEstado;
		
	}

	/**
	 * @return
	 */
	public Date getFecha() {
		// TODO implement here
		return fecha;
	}

	/**
	 * @return
	 */
	public TipoDocumento getTipoDoc() {
		// TODO implement here
		return tipoDoc;
	}

	/**
	 * @return
	 */
	public int getCantOriginales() {
		// TODO implement here
		return cantOriginales;
	}

	/**
	 * @return
	 */
	public int getTotalCopias() {
		// TODO implement here
		return totalCopias;
	}

	/**
	 * @return
	 */
	public int getCantJuegos() {
		// TODO implement here
		return cantJuegos;
	}

	/**
	 * @return
	 */
	public EstadoSolicitud getEstado() {
		// TODO implement here
		return estado;
	}

	/**
	 * @return
	 */
	public int getNumeroBoleta() {
		// TODO implement here
		return numero;
	}

    public int getIdentificador() {
        return identificador;
    }

	/**
	 * @return
	 */
	public String getTipoSolicitante() {
            String retornar = "";
            String nombre = solicitante.getClass().getName();
            retornar += nombre.substring(7, nombre.length());
            return retornar;
	}

	/**
	 * 
	 */
	public void anular() {
		this.estado = EstadoSolicitud.Anulada;
	}

        public EstadoSolicitud autorizar(){
            int variable = (int)(Math.random()*10);
            
            if (variable < 5) {
                return EstadoSolicitud.AtentidaConAutorización;
            }
            else{
                return EstadoSolicitud.Anulada;
            }
        
        }
	/**
	 * @return
	 */
//	public boolean estaProcesada() {
//		// TODO implement here
//		return true;
//	}

	/**
	 * @return
	 */
    @Override
	public String toString() {
            String retornar = "";
            retornar += "Boleta número: "+ identificador+"\n";
            retornar += "Fecha: "+ fecha+"\n";
            retornar += "Tipo documento: "+ tipoDoc +"\n";
            retornar += "Cantidad de hojas originales: "+ cantOriginales+"\n";
            retornar += "Cantidad de juegos: "+ cantJuegos+"\n";
            retornar += "Cantidad de copias: "+ totalCopias+"\n";
            retornar += "El estado: "+ estado+"\n";
            retornar += "Solicitante es: "+ solicitante +"\n";
            
            return retornar;
	}

}