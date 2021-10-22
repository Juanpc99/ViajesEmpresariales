/**  
 * @Title:  ClienteMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 11:13:11 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**   
 * @ClassName:  ClienteMapper   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 11:13:11 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {

	@Mapping(source = "idTiid.idTiid", target = "idTiid")
	@Mapping(source = "idTiid.codigo", target = "codigoTipoIdentificacion")
	@Mapping(source = "idTiid.estado", target = "estadoTipoIdentificacion")
	public ClienteDTO clienteToClienteDTO(Cliente cliente);
	
	@Mapping(source = "idTiid.idTiid", target = "idTiid")
	@Mapping(source = "idTiid.codigo", target = "codigoTipoIdentificacion")
	@Mapping(source = "idTiid.estado", target = "estadoTipoIdentificacion")
	public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> listCliente);
	
	@Mapping(source = "idTiid.idTiid", target = "idTiid")
	@Mapping(source = "idTiid.codigo", target = "codigoTipoIdentificacion")
	@Mapping(source = "idTiid.estado", target = "estadoTipoIdentificacion")
	public List<ClienteDTO> listClienteToListClienteDTO(Page<Cliente> pageCliente);
	
}
