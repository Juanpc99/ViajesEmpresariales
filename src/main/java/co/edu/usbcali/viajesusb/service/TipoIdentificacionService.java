/**  
 * @Title:  TipoIdentificacion.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   20/09/2021 11:33:22 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.util.List;


import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;

/**   
 * @ClassName:  TipoIdentificacion   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   20/09/2021 11:33:22 p. m.      
 * @Copyright:  USB
 */

public interface TipoIdentificacionService {

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
	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws Exception;
	
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
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception;
	/**
	 * 
	 * @Title: guardarTipoIdentificacion   
	   * @Description: TODO 
	 * @param: @param tipoIdentificacionDTO
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws
	 */
	public void guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;

	public void actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;


	public TipoIdentificacion findById(Long idTide) throws Exception; 


	public void eliminarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception;
}
