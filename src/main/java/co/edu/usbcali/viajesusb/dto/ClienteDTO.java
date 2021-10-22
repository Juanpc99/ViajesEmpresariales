/**  
 * @Title:  ClienteDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 9:07:22 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;





/**   
 * @ClassName:  ClienteDTO   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 9:07:22 a. m.      
 * @Copyright:  USB
 */
@Data
public class ClienteDTO implements Serializable{

	/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	
	private static final long serialVersionUID = 8650084404524240764L;

	
	
	
	/**   
	 * @Title:  ClienteDTO  
	 * @Author: JuanPabloCaro
	   * @Description:TODO 
	 * @param:  @param nombre
	 * @param:  @param numeroIdentificacion
	 * @param:  @param idTiid
	 * @param:  @param estado  
	 * @throws   
	 */
	/**
	public ClienteDTO(String nombre, String numeroIdentificacion, String idTiid, String estado) {
		super();
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
		this.idTiid = idTiid;
		this.estado = estado;
	}
	*/
	private Long idClie;
	private String numeroIdentificacion;
	private String primerApellido;
	private String segundoApellido;
	private String nombre;
	private String telefono1;
	private String telefono2;
	private String correo;
	private String sexo;
	private Date fechaNacimiento;	
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	
	private Long idTiid;
	private String codigoTipoIdentificacion;
	private String estadoTipoIdentificacion;
	
	
	

	
	
}
