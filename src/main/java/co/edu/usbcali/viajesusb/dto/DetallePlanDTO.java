/**  
 * @Title:  DetallePlanDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:44:11 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.util.Date;


/**
 * @ClassName: DetallePlanDTO
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 16/10/2021 8:44:11 a. m.
 * @Copyright: USB
 */

public class DetallePlanDTO {

	public Long idDepl;
	public String alimentacion;
	public String hospedaje;
	public String transporte;
	public String traslados;
	public Double valor;
	public Integer catidadNoches;
	public Integer catidadDias;
	public Date fechaCreacion;
	public Date fechaModificacion;
	public String usuCreador;
	public String usuModificador;
	public String estado;
	
	public Long idPlan;
	public String nombrePlan;
	
	public Long idDest;
	public String nombreDestino;
}
