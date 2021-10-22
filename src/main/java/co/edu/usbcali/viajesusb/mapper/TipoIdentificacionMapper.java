/**  
 * @Title:  TipoIdentificacionMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 11:13:25 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;

/**   
 * @ClassName:  TipoIdentificacionMapper   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 11:13:25 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface TipoIdentificacionMapper {
	
	public TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion);

	public List<TipoIdentificacionDTO> listTipoIdentificacionToListTipoIdentificacionDTO(List<TipoIdentificacion> listTipoIdentificacion);

}
