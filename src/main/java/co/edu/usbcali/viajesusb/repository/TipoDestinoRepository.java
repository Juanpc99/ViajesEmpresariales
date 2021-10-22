package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**
 * 
 * @ClassName:  TipoDestinoRepository   
  * @Description: Repository TipoDestino   
 * @author: JuanPabloCaro     
 * @date:   31/08/2021 11:07:52 a. m.      
 * @Copyright:  USB
 */
public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Long>{
	
	/**
	 * 
	 * @Title: findByCodigo   
	   * @Description: Consulta un tipo destino por codigo 
	 * @param: @param codigo
	 * @param: @return      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigo(String codigo) throws SQLException;

	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: Consulta un tipo destino por codigo y estado 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigoAndEstado (String codigo, String estado) throws SQLException;
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNombre   
	   * @Description: Consulta estado ordenado por el nombre 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoDestino>      
	 * @throws
	 */
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws SQLException;
	
	/**
	 * 
	 * @Title: consultarTipoDestinoPorEstado   
	   * @Description: TODO 
	 * @param: @param estado
	 * @param: @return      
	 * @return: List<TIpoDestinoDTO>      
	 * @throws
	 */
	@Query(nativeQuery = true)
	public List<TipoDestinoDTO> consultarTipoDestinoPorEstado(@Param("pEstado") String estado)throws SQLException;
}
