/**  
 * @Title:  TipoIdentificacionImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   20/09/2021 11:33:06 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: TipoIdentificacionImpl
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 20/09/2021 11:33:06 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {
	@Autowired
	TipoIdentificacionRepository tipoIdentificacionRepository;

	/**
	 * <p>
	 * Title: findByEstadoOrderByNombreAsc
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findByEstadoOrderByNombreAsc(java.lang.String)
	 */

	@Override
	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws Exception {
		List<TipoIdentificacion> listTipoIdentificacion = null;
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(estado);
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		}
		if (mather.find() == false) {
			throw new Exception("Debe ingresar un estado valido");
		}
		if (estado.length() > 1) {

			throw new Exception("El estado debe ser de un solo caracter");
		}
		listTipoIdentificacion = tipoIdentificacionRepository.findByEstadoOrderByNombreAsc(estado);
		return listTipoIdentificacion;
	}

	/**
	 * <p>
	 * Title: findByCodigoAndEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findByCodigoAndEstado(java.lang.String,
	 *      java.lang.String)
	 */

	@Override
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws Exception {
		TipoIdentificacion tipoIdentificacion = null;
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(estado);
		Matcher mather2 = pattern.matcher(codigo);
		if (estado == null || estado.trim().equals("") || codigo == null || codigo.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		}
		if (mather.find() == false) {
			throw new Exception("Debe ingresar un estado valido");
		}
		if (mather2.find() == false) {
			throw new Exception("Debe ingresar un codigo valido");
		}
		if (estado.length() > 1) {

			throw new Exception("El estado debe ser de un solo caracter");
		}
		if (codigo.length() > 5) {
			throw new Exception("El codigo debe ser de umaximo 4 caracteres");
		}
		tipoIdentificacion = tipoIdentificacionRepository.findByCodigoAndEstado(codigo, estado);
		return tipoIdentificacion;
	}

	/**
	 * <p>
	 * Title: guardarTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacionDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#guardarTipoIdentificacion(co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO)
	 */

	@Override
	public void guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {

		if (tipoIdentificacionDTO.getIdTiid() == null) {
			throw new Exception("Debe ingresar un id");
		}
		if (tipoIdentificacionDTO.getCodigo() == null || tipoIdentificacionDTO.getCodigo() == "") {
			throw new Exception("Debe ingresar un codigo");
		}
		if (tipoIdentificacionDTO.getNombre() == null || tipoIdentificacionDTO.getNombre() == "") {
			throw new Exception("Debe ingresar un nombre");
		}
		if (tipoIdentificacionDTO.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha de creacion");
		}
		if (tipoIdentificacionDTO.getUsuCreador() == null || tipoIdentificacionDTO.getUsuCreador() == "") {
			throw new Exception("Debe ingresar unn usuario creador");
		}
		if (tipoIdentificacionDTO.getEstado() == null || tipoIdentificacionDTO.getEstado() == "") {
			throw new Exception("Debe ingresar un estado");
		}
		if (Utilities.soloLetrasMayusculas(tipoIdentificacionDTO.getCodigo()) == false) {
			throw new Exception("El codigo solo debe contener letras en mayuscula");
		}
		if (Utilities.isOnlyLetters(tipoIdentificacionDTO.getNombre()) == false) {
			throw new Exception("El nombre solo debe contener letras");
		}
		if (Utilities.soloLetrasMayusculas(tipoIdentificacionDTO.getUsuCreador()) == false) {
			throw new Exception("El usuario creador solo debe contener letras en mayuscula");
		}
		if (Utilities.soloLetrasMayusculas(tipoIdentificacionDTO.getEstado()) == false) {
			throw new Exception("El estado solo debe contener letras en mayuscula");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getCodigo(), 5) == false) {
			throw new Exception("El codigo puede tener maximo 5 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getNombre(), 100) == false) {
			throw new Exception("El nombre puede tener maximo 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getUsuCreador(), 10) == false) {
			throw new Exception("El usuario creador puede tener maximo 10 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getEstado(), 1) == false) {
			throw new Exception("El estado puede tener maximo 1 caractere");
		}

		TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
		tipoIdentificacion.setIdTiid(tipoIdentificacionDTO.getIdTiid());
		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());
		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());

		tipoIdentificacionRepository.save(tipoIdentificacion);

	}

	/**
	 * <p>
	 * Title: actualizarTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacionDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#actualizarTipoIdentificacion(co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO)
	 */

	@Override
	public void actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {
		if (tipoIdentificacionDTO.getIdTiid() == null) {
			throw new Exception("Debe ingresar un id");
		}
		if (tipoIdentificacionDTO.getCodigo() == null || tipoIdentificacionDTO.getCodigo() == "") {
			throw new Exception("Debe ingresar un codigo");
		}
		if (tipoIdentificacionDTO.getNombre() == null || tipoIdentificacionDTO.getNombre() == "") {
			throw new Exception("Debe ingresar un nombre");
		}
		if (tipoIdentificacionDTO.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha de creacion");
		}
		if (tipoIdentificacionDTO.getUsuCreador() == null || tipoIdentificacionDTO.getUsuCreador() == "") {
			throw new Exception("Debe ingresar unn usuario creador");
		}
		if (tipoIdentificacionDTO.getEstado() == null || tipoIdentificacionDTO.getEstado() == "") {
			throw new Exception("Debe ingresar un estado");
		}
		if (Utilities.soloLetrasMayusculas(tipoIdentificacionDTO.getCodigo()) == false) {
			throw new Exception("El codigo solo debe contener letras en mayuscula");
		}
		if (Utilities.isOnlyLetters(tipoIdentificacionDTO.getNombre()) == false) {
			throw new Exception("El nombre solo debe contener letras");
		}
		if (Utilities.soloLetrasMayusculas(tipoIdentificacionDTO.getUsuCreador()) == false) {
			throw new Exception("El usuario creador solo debe contener letras en mayuscula");
		}
		if (Utilities.soloLetrasMayusculas(tipoIdentificacionDTO.getEstado()) == false) {
			throw new Exception("El estado solo debe contener letras en mayuscula");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getCodigo(), 5) == false) {
			throw new Exception("El codigo puede tener maximo 5 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getNombre(), 100) == false) {
			throw new Exception("El nombre puede tener maximo 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getUsuCreador(), 10) == false) {
			throw new Exception("El usuario creador puede tener maximo 10 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(tipoIdentificacionDTO.getEstado(), 1) == false) {
			throw new Exception("El estado puede tener maximo 1 caractere");
		}
		TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();

		tipoIdentificacion = findById(tipoIdentificacionDTO.getIdTiid());

		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());
		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());

		tipoIdentificacionRepository.save(tipoIdentificacion);

	}

	/**
	 * <p>
	 * Title: findById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param idTide
	 * @return
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findById(java.lang.Long)
	 */

	@Override
	public TipoIdentificacion findById(Long idTide) throws Exception {
		if (idTide == null) {
			throw new Exception("Debe tipo identificacion un id tipo identificacion");
		}
		if (!tipoIdentificacionRepository.findById(idTide).isPresent()) {
			throw new Exception("El tipo identificacion con id: " + idTide + " no existe");
		}
		return tipoIdentificacionRepository.findById(idTide).get();
	}

	/**
	 * <p>
	 * Title: eliminarTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacionDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#eliminarTipoIdentificacion(co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO)
	 */

	@Override
	public void eliminarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws Exception {
		if (tipoIdentificacionDTO == null || tipoIdentificacionDTO.getIdTiid() == null) {
			throw new Exception("El id tipo identificacion es obligatirio");
		}
		// Optional<TipoIdentificacion> tipoIdentificacionBD =
		// tipoIdentificacionRepository.findById(tipoIdentificacionDTO.getIdTiid());

		if (tipoIdentificacionRepository.existsById(tipoIdentificacionDTO.getIdTiid()) == false) {
			throw new Exception("El tipo identificacion no se encontro");
		}
		tipoIdentificacionRepository.findById(tipoIdentificacionDTO.getIdTiid()).ifPresent(tipoIdentificacion -> {
			if (tipoIdentificacion.getCliente().isEmpty() == false) {
				throw new RuntimeException("El tipo de identificacion " + tipoIdentificacionDTO.getIdTiid()
						+ " tiene clientes asignados, por lo que no se puede eliminar");
			}
		});

		tipoIdentificacionRepository.deleteById(tipoIdentificacionDTO.getIdTiid());

	}

}
