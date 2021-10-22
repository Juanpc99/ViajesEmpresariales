/**  
 * @Title:  ClienteRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:03:15 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.repository;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;



/**   
 * @ClassName:  ClienteRepository   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:03:15 p. m.      
 * @Copyright:  USB
 */

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
	/**
	 * 
	 * @Title: findByEstadoOrderByNumeroIdentificacionAsc   
	   * @Description: Consulta todos los clientes por estado. Esta consulta debe ser paginada y ordenada de forma ascendente por numero de identificación 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable) throws SQLException;
	
	/**
	 * 
	 * @Title: findByCorreoIgnoreCase   
	   * @Description: Consultar un cliente por correo electrónico. Esta consulta debe ignorar las mayusculas y minúsculas. 
	 * @param: @param correo
	 * @param: @return      
	 * @return: Cliente      
	 * @throws
	 */
	public Cliente findByCorreoIgnoreCase(String correo)throws SQLException;
	
	/**
	 * 
	 * @Title: findByNumeroIdentificacionLike   
	   * @Description:Consultar cliente por numero de identificación, usando LIKE 
	 * @param: @param numeroID
	 * @param: @return      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public List<Cliente> findByNumeroIdentificacionLike(String numeroID) throws SQLException;
	
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
	public List<Cliente> findByNombreLikeIgnoreCase(String nombre) throws SQLException;
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
	public List<Cliente> findByFechaNacimientoBetween(Date fecha1, Date fecha2) throws SQLException;
	
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
	public Long countByEstado(String estado) throws SQLException;
	
	/**
	 * 
	 * @Title: findByIdTiid   
	   * @Description: Consultar clientes por tipo de identificación. Debe de ser paginado 
	 * @param: @param idTiid
	 * @param: @return      
	 * @return: List<Cliente>      
	 * @throws
	 */
	public Page<Cliente> findByIdTiid_Codigo(String idTiid, Pageable pageable) throws SQLException;
	
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
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido) throws SQLException;
	
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
	public List<ClienteDTO> consultarClientesConFiltros(@Param("pNombre") String nombre)throws SQLException;
}
