/**  
 * @Title:  ClienteService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   20/09/2021 11:32:51 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**   
 * @ClassName:  ClienteService   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   20/09/2021 11:32:51 p. m.      
 * @Copyright:  USB
 */

public interface ClienteService {
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNumeroIdentificacionAsc   
	   * @Description: Consulta todos los clientes por estado. Esta consulta debe ser paginada y ordenada de forma ascendente por numero de identificación 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws Exception 
	 * @throws
	 */
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable) throws Exception;
	
	/**
	 * 
	 * @Title: findByCorreoIgnoreCase   
	   * @Description: Consultar un cliente por correo electrónico. Esta consulta debe ignorar las mayusculas y minúsculas. 
	 * @param: @param correo
	 * @param: @return      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByCorreoIgnoreCase(String correo)throws Exception;
	
	/**
	 * 
	 * @Title: findByNumeroIdentificacionLike   
	   * @Description:Consultar cliente por numero de identificación, usando LIKE 
	 * @param: @param numeroID
	 * @param: @return      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByNumeroIdentificacionLike(String numeroID) throws Exception;
	
	/**
	 * 
	 * @Title: findByNombreLikeIgnoreCase   
	   * @Description: Consultar cliente por nombre, ignorando Mayusculas y minúsculas, usando LIKE. 
	 * @param: @param nombre
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByNombreLikeIgnoreCase(String nombre) throws Exception;
	/**
	 * 
	 * @Title: findByFechaNacimientoBetween   
	   * @Description: Consultar clientes por rango de fecha (Se debe pasar dos fechas y traer los clientes cuya fecha de nacimiento se encuentre entre el rango ingresado). 
	 * @param: @param fecha1
	 * @param: @param fecha2
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByFechaNacimientoBetween(Date fecha1, Date fecha2) throws Exception;
	
	/**
	 * 
	 * @Title: countByEstado   
	   * @Description: Consultar total de clientes por estado. 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Cliente      
	 * @throws
	 */
	public Long countByEstado(String estado) throws Exception;
	
	/**
	 * 
	 * @Title: findByIdTiid   
	   * @Description: Consultar clientes por tipo de identificación. Debe de ser paginado 
	 * @param: @param idTiid
	 * @param: @return      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByIdTiid_Codigo(String idTiid, Pageable pageable) throws Exception;
	
	/**
	 * 
	 * @Title: findByPrimerApellidoAndSegundoApellido   
	   * @Description: Consultar clientes por apellidos 
	 * @param: @param primerApellido
	 * @param: @param segundoApellido
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido) throws Exception;
	
	
	/**
	 * 
	 * @Title: guardarCliente   
	   * @Description: Guarda clientes 
	 * @param: @param clienteDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception;
	/**
	 * 
	 * @Title: actualizarCliente   
	   * @Description: TODO 
	 * @param: @param clienteDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception;
	/**
	 * 
	 * @Title: findById   
	   * @Description: TODO 
	 * @param: @param idClie
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findById(Long idClie) throws Exception; 
	/**
	 * 
	 * @Title: eliminarCliente   
	   * @Description: TODO 
	 * @param: @param clienteDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void eliminarCliente(Long id) throws Exception;
	/**
	 * 
	 * @Title: consultarTipoDestinoPorEstado   
	   * @Description: TODO 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoDestinoDTO>      
	 * @throws
	 */
	@Query(nativeQuery = true)
	public List<ClienteDTO> consultarClientesConFiltros(@Param("pNombre") String nombre)throws Exception;
	
	
}
