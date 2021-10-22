package co.edu.usbcali.viajesusb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbcali.viajesusb.domain.Destino;

/**
 * 
 * @ClassName:  DestinoRepository   
  * @Description: Repository Destino
 * @author: JuanPabloCaro     
 * @date:   31/08/2021 11:04:55 a. m.      
 * @Copyright:  USB
 */

public interface DestinoRepository extends JpaRepository<Destino, Long>{

	/**
	 * 
	 * @Title: findByTipoDestino_Codigo   
	   * @Description: Consulta todos los destinos que pertenecen a un tipo destino 
	 * @param: @param codigoTipoDestinp
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<Destino>      
	 * @throws
	 */
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws Exception;
	
	/**
	 * 
	 * @Title: findByEstado   
	   * @Description: Retorna una pagina de la lista de destinos por estado
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<Destino>      
	 * @throws
	 */
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws Exception;


}
