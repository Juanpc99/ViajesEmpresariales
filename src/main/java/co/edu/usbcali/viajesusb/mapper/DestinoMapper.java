/**  
 * @Title:  DestinoMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 5:56:43 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;

/**   
 * @ClassName:  DestinoMapper   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 5:56:43 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface DestinoMapper {

	@Mapping(source = "tipoDestino.idTide", target = "idTide")
	@Mapping(source = "tipoDestino.codigo", target = "codigoTipoDestino")
	@Mapping(source = "tipoDestino.nombre", target = "nombreTipoDestino")
	public DestinoDTO destinoToDestinoDTO(Destino destino);
	
	@Mapping(source = "tipoDestino.idTide", target = "idTide")
	@Mapping(source = "tipoDestino.codigo", target = "codigoTipoDestino")
	@Mapping(source = "tipoDestino.nombre", target = "nombreTipoDestino")
	public List<DestinoDTO> listDestinoToListDestinoDTO(List<Destino> listDestino);
	
	@Mapping(source = "tipoDestino.idTide", target = "idTide")
	@Mapping(source = "tipoDestino.codigo", target = "codigoTipoDestino")
	@Mapping(source = "tipoDestino.nombre", target = "nombreTipoDestino")
	public List<DestinoDTO> listDestinoToListDestinoDTO(Page<Destino> pageCliente);
	
	
	
}
