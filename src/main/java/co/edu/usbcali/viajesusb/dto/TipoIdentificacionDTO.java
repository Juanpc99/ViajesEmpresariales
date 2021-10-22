/**  
 * @Title:  TipoIdentificacionDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   4/10/2021 11:36:58 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.util.Date;



import lombok.Data;

/**   
 * @ClassName:  TipoIdentificacionDTO   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   4/10/2021 11:36:58 p. m.      
 * @Copyright:  USB
 */
@Data
public class TipoIdentificacionDTO {
	
	public Long idTiid;
	public String codigo;
	public String nombre;
	public Date fechaCreacion;
	public Date fechaModificacion;
	public String usuCreador;
	public String usuModificador;
	public String estado;

}
