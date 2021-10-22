/**  
 * @Title:  TipoIdentificacionRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:03:42 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.SQLException;
import java.util.List;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

/**   
 * @ClassName:  TipoIdentificacionRepository   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:03:42 p. m.      
 * @Copyright:  USB
 */

public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long>{
	
	/**
	 * 
	 * @Title: findByEstadoAsc   
	   * @Description: Consulta todos los tipo de identificación por estado ordenados alfabeticamente. 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoIdentificacion      
	 * @throws
	 */
	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws SQLException;
	
	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: Consultar tipo de identificación por código y estado. 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoIdentificacion>      
	 * @throws
	 */
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws SQLException;
}
