/**  
 * @Title:  TipoDestinoImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 11:53:23 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;


import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.TipoDestino;

import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.repository.TipoDestinoRepository;


/**   
 * @ClassName:  TipoDestinoImpl   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 11:53:23 a. m.      
 * @Copyright:  USB
 */
@Scope("singleton")
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService{
	
	@Autowired
	private TipoDestinoRepository tipoDestinorepository;
	/**   
	 * <p>Title: findByCodigo</p>   
	 * <p>Description: </p>   
	 * @param codigo
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigo(java.lang.String)   
	 */
	
	@Override
	public TipoDestino findByCodigo(String codigo) throws Exception {
		TipoDestino tipoDestino = null;
	
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(codigo);
		if(codigo == null || codigo.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		}
		if(mather.find() == false) {
			throw new Exception("Debe ingresar un codigo valido");
		}
		if(codigo.length() > 5) {
			
			throw new Exception("El codigo debe ser de maximo 5 caracter");
		}
		tipoDestino=tipoDestinorepository.findByCodigo(codigo);
		return tipoDestino;
	}
	/**   
	 * <p>Title: findByCodigoAndEstado</p>   
	 * <p>Description: </p>   
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigoAndEstado(java.lang.String, java.lang.String)   
	 */
	
	@Override
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws Exception {
		
		TipoDestino tipoDestino = null;
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(estado);
		Matcher mather2 = pattern.matcher(codigo);
		if(estado == null || estado.trim().equals("") || codigo == null || codigo.trim().equals("")) {
			throw new Exception("Debe ingresar un estado y codigo!");
		}
		if(mather.find() == false || mather2.find() == false) {
			throw new Exception("Debe ingresar un estado y codigo valido");
		}
		if(estado.length() > 1 || codigo.length() > 5) {
			
			throw new Exception("El estado debe ser de un solo caracter o el codigo de maximo 5 caracteres");
		}
		
		tipoDestino=tipoDestinorepository.findByCodigoAndEstado(codigo, estado);
		return tipoDestino;
	}
	/**   
	 * <p>Title: findByEstadoOrderByNombre</p>   
	 * <p>Description: </p>   
	 * @param estado
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByEstadoOrderByNombre(java.lang.String)   
	 */
	
	@Override
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws Exception {
		List<TipoDestino> listTipoDestino = null;
		
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(estado);
		if(estado == null || estado.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		}
		if(mather.find() == false) {
			throw new Exception("Debe ingresar un estado valido");
		}
		if(estado.length() > 1) {
			
			throw new Exception("El estado debe ser de un solo caracter");
		}
		listTipoDestino = tipoDestinorepository.findByEstadoOrderByNombre(estado);
		return listTipoDestino;
	}
	/**   
	 * <p>Title: consultarTipoDestinoPorEstado</p>   
	 * <p>Description: </p>   
	 * @param estado
	 * @return
	 * @throws SQLException   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#consultarTipoDestinoPorEstado(java.lang.String)   
	 */
	/**
	@Override
	public List<TipoDestinoDTO> consultarTipoDestinoPorEstado(String estado) throws Exception {
		List<TipoDestinoDTO> listTipoDestinoDTO = null;
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(estado);
		if(estado == null || estado.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		}
		if(mather.find() == false) {
			throw new Exception("Debe ingresar un estado valido");
		}
		if(estado.length() > 1) {
			
			throw new Exception("El estado debe ser de un solo caracter");
		}
		listTipoDestinoDTO = tipoDestinorepository.consultarTipoDestinoPorEstado(estado);
		return listTipoDestinoDTO;
	}
	*/
	/**   
	 * <p>Title: guardarTipoDestino</p>   
	 * <p>Description: </p>   
	 * @param tipoDestinoDTO
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#guardarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)   
	 */
	
	@Override
	public TipoDestino guardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception {
		TipoDestino tipoDestino = new TipoDestino();
		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());
		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());
		
		tipoDestinorepository.save(tipoDestino);
		return tipoDestino;
		
	}
	/**   
	 * <p>Title: actualizarTipoDestino</p>   
	 * <p>Description: </p>   
	 * @param tipoDestinoDTO
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#actualizarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)   
	 */
	
	@Override
	public TipoDestino actualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws Exception {
		TipoDestino tipoDestino = new TipoDestino();
		
		tipoDestino = findById(tipoDestinoDTO.getIdTide());
		
		tipoDestino.setIdTide(tipoDestinoDTO.getIdTide());
		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());
		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());
		
		tipoDestinorepository.save(tipoDestino);
		return tipoDestino;
	}
	/**   
	 * <p>Title: findById</p>   
	 * <p>Description: </p>   
	 * @param idTide
	 * @return
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findById(java.lang.Long)   
	 */
	
	@Override
	public TipoDestino findById(Long idTide) throws Exception {
		if(idTide == null) {
			throw new Exception("Debe ingresar un id tipo destino");
		}
		if(!tipoDestinorepository.findById(idTide).isPresent()) {
			throw new Exception("El tipo destino con id: " + idTide + " no existe");
		}
		return tipoDestinorepository.findById(idTide).get();
	}
	/**   
	 * <p>Title: eliminarTipoDestino</p>   
	 * <p>Description: </p>   
	 * @param tipoDestinoDTO
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#eliminarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)   
	 */
	
	@Override
	public void eliminarTipoDestino(Long id) throws Exception {
		if(id == null) {
			throw new Exception("El id tipo destino es obligatirio");
		}
		Optional<TipoDestino> tipoDestinoBD = tipoDestinorepository.findById(id);
		
		if(tipoDestinoBD.isPresent()) {
			tipoDestinorepository.delete(tipoDestinoBD.get());
		}else {
			throw new Exception("El tipo destino no se encontro");
		}
		
	}
	
}

	
	
	
