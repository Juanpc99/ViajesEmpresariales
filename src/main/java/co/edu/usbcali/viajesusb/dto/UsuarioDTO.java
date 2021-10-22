/**  
 * @Title:  UsuarioDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:44:38 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.dto;

import java.util.Date;



/**
 * @ClassName: UsuarioDTO
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 16/10/2021 8:44:38 a. m.
 * @Copyright: USB
 */

public class UsuarioDTO {

	public Long idUsua;

	public String login;
	public String password;
	public String nombre;
	public String identificacion;
	public Date fechaCreacion;
	public Date fechaModificacion;
	public String usuCreador;
	public String usuModificador;
	public String estado;
}
