/**  
 * @Title:  DestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 12:21:51 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;

/**   
 * @ClassName:  DestinoService   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 12:21:51 p. m.      
 * @Copyright:  USB
 */

public interface DestinoService {

	/**
	 * 
	 * @Title: findByTipoDestino_Codigo   
	   * @Description: Consulta por tipo destino: codigo 
	 * @param: @param codigoTipoDestino
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<Destino>      
	 * @throws
	 */
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws Exception;
	
	/**
	 * 
	 * @Title: findByEstado   
	   * @Description: Consulta por estado 
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Page<Destino>      
	 * @throws
	 */
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws Exception;

	/**   
	 * @Title: guardarDestino   
	   * @Description: TODO 
	 * @param: @param destinoDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception;

	/**   
	 * @Title: actualizarDestino   
	   * @Description: TODO 
	 * @param: @param destinoDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	
	Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception;

	/**   
	 * @Title: findByID   
	   * @Description: TODO 
	 * @param: @param idDest
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Optional<Destino>      
	 * @throws   
	 */
	
	Destino findByID(Long idDest) throws Exception;

	/**   
	 * @Title: eliminarDestino   
	   * @Description: TODO 
	 * @param: @param destinoDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	
	void eliminarDestino(Long id) throws Exception;
}

	
