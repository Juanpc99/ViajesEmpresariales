/**  
 * @Title:  TIpoDestinoDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 1:48:58 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;



/**   
 * @ClassName:  TIpoDestinoDTO   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 1:48:58 a. m.      
 * @Copyright:  USB
 */
@Data
public class TipoDestinoDTO implements Serializable{


	/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	
	private static final long serialVersionUID = 3020863555434544774L;

	/**   
	 * @Title:  TIpoDestinoDTO  
	 * @Author: JuanPabloCaro
	   * @Description:TODO 
	 * @param:  @param idTide
	 * @param:  @param codigo
	 * @param:  @param nombre
	 * @param:  @param descripcion  
	 * @throws   
	 */
	/**
	public TipoDestinoDTO(long idTide, String codigo, String nombre, String descripcion) {
		super();
		this.idTide = idTide;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	*/
	private Long idTide;
	private String codigo;
	private String nombre;
	private String descripcion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	
	

	
	
	
}
