/**  
 * @Title:  DestinoDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   28/09/2021 11:14:44 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;


import lombok.Data;

/**   
 * @ClassName:  DestinoDTO   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   28/09/2021 11:14:44 a. m.      
 * @Copyright:  USB
 */

@Data
public class DestinoDTO implements Serializable{

	
	/**   
	   * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	
	private static final long serialVersionUID = 6865915795193482782L;
	
	private Long idDest;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String tierra;
	private String aire;
	private String mar;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;


	private Long idTide;
	private String codigoTipoDestino;
	private String nombreTipoDestino;
}
