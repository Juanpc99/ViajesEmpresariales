/**  
 * @Title:  TIpoDestinoMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 11:58:10 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  TIpoDestinoMapper   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 11:58:10 a. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface TipoDestinoMapper {

	public TipoDestinoDTO tipoDestinoToTipoDestinoDTO(TipoDestino tipoDestino);
	
	public List<TipoDestinoDTO> listTipoDestinoToListTipoDestinoDTO(List<TipoDestino> tipoDestino);
}
