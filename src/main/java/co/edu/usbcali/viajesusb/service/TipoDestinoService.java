/**  
 * @Title:  TipoDestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 11:50:53 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.util.List;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  TipoDestinoService   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 11:50:53 a. m.      
 * @Copyright:  USB
 */

public interface TipoDestinoService {
	
	
	/**
	 * 
	 * @Title: findByCodigo   
	   * @Description: Un tipo de destino dado el codigo
	 * @param: @param codigo
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigo(String codigo) throws Exception;
	
	/**
	 * 
	 * @Title: findByCodigoAndEstado   
	   * @Description: Un tipo destino por codigo y estado 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception;
	
	/**
	 * 
	 * @Title: findByEstadoOrderByNombre   
	   * @Description: Lista de tipo destino por estado y ordenado por nombre 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<TipoDestino>      
	 * @throws
	 */
	
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws Exception;
	
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
	public List<TipoDestinoDTO> consultarTipoDestinoPorEstado(String estado)throws Exception;
	/**
	 * 
	 * @Title: guardarTipoDestino   
	   * @Description: TODO 
	 * @param: @param tipoDestinoDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public TipoDestino guardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception;
	/**
	 * 
	 * @Title: actualizarTipoDestino   
	   * @Description: TODO 
	 * @param: @param tipoDestinoDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public TipoDestino actualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception;

	/**
	 * 
	 * @Title: findById   
	   * @Description: TODO 
	 * @param: @param idTide
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: TipoDestino      
	 * @throws
	 */
	public TipoDestino findById(Long idTide) throws Exception; 
	/**
	 * 
	 * @Title: eliminarTipoDestino   
	   * @Description: TODO 
	 * @param: @param tipoDestinoDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */

	public void eliminarTipoDestino(Long id) throws Exception;
 }
