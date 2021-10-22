/**  
 * @Title:  PlanDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:44:28 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.util.Date;



/**
 * @ClassName: PlanDTO
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 16/10/2021 8:44:28 a. m.
 * @Copyright: USB
 */

public class PlanDTO {

	public Long idPlan;
	public String codigo;
	public String descripcionSolicitud;
	public String nombre;
	public Long cantidadPersonas;
	public Date fechaSolicitud;
	public Date fechaInicioViaje;
	public Date fechaFinViaje;
	public Long valorTotal;
	public Date fechaCreacion;
	public Date fechaModificacion;
	public String usuCreador;
	public String usuModificador;
	public String estado;
	
	public Long idCLie;
	public String nombreCliente;
	
	public Long idUsua;
	public String nombreUsuario;

}
