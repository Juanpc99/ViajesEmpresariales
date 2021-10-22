/**  
 * @Title:  DestinoServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   7/09/2021 12:22:03 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.repository.DestinoRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: DestinoServiceImpl
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 7/09/2021 12:22:03 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class DestinoServiceImpl implements DestinoService {

	@Autowired
	private DestinoRepository destinoRepository;

	@Autowired
	private TipoDestinoService tipoDestinoService = null;

	/**
	 * <p>
	 * Title: findByTipoDestino_Codigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigoTipoDestino
	 * @return
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByTipoDestino_Codigo(java.lang.String)
	 */

	@Override
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws Exception {
		List<Destino> listDestino = null;

		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher mather = pattern.matcher(codigoTipoDestino);
		if (codigoTipoDestino == null || codigoTipoDestino.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		}
		if (mather.find() == false) {
			throw new Exception("Debe ingresar un codigo valido");
		}
		if (codigoTipoDestino.length() > 5) {

			throw new Exception("El codigo debe ser de maximo 5 caracter");
		}

		listDestino = destinoRepository.findByTipoDestino_Codigo(codigoTipoDestino);
		return listDestino;
	}

	/**
	 * <p>
	 * Title: findByEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByEstado(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */

	@Override
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws Exception {
		Page<Destino> pageDestino = null;

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
		pageDestino = destinoRepository.findByEstado(estado, pageable);
		return pageDestino;
	}

	/**
	 * 
	 * @Title: guardarDestino
	 * @Description: Metodo que guarda un destino
	 * @param: @param destino
	 * @return: void
	 * @throws
	 */

	@Override
	public Destino guardarDestino(DestinoDTO destinoDTO) throws Exception {
		Destino destino = null;
		TipoDestino tipoDestino = null;
		// TODO: pendiente validaciones
		if (destinoDTO.getAire() == null || destinoDTO.getAire() == "") {
			throw new Exception("Debe ingresar un valor al atributo aire");
		} else if (destinoDTO.getMar() == null || destinoDTO.getMar() == "") {
			throw new Exception("Debe ingresar un valor al atributo mar");
		} else if (destinoDTO.getTierra() == null || destinoDTO.getTierra() == "") {
			throw new Exception("Debe ingresar un valor al atributo tierra");
		} else if (destinoDTO.getCodigo() == null || destinoDTO.getCodigo() == "") {
			throw new Exception("Debe ingresar un valor al atributo codigo");
		} else if (destinoDTO.getNombre() == null || destinoDTO.getNombre() == "") {
			throw new Exception("Debe ingresar un valor al atributo Nombre");
		} else if (destinoDTO.getDescripcion() == null || destinoDTO.getDescripcion() == "") {
			throw new Exception("Debe ingresar un valor al atributo Descripcion");
		} else if (destinoDTO.getEstado() == null || destinoDTO.getEstado() == "") {
			throw new Exception("Debe ingresar un valor al atributo Estado");
		} else if (destinoDTO.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar un valor al atributo Fecha creacion");
		} else if (destinoDTO.getUsuCreador() == null || destinoDTO.getUsuCreador() == "") {
			throw new Exception("Debe ingresar un valor al atributo UsusCreador");
		} else if (Utilities.soloLetrasMayusculas(destinoDTO.getAire()) == false) {
			throw new Exception("El atributo aire solo recibe letras mayusculas");
		} else if (Utilities.soloLetrasMayusculas(destinoDTO.getMar()) == false) {
			throw new Exception("El atributo Mar solo recibe letras mayusculas");
		} else if (Utilities.soloLetrasMayusculas(destinoDTO.getTierra()) == false) {
			throw new Exception("El atributo tierra solo recibe letras mayusculas");
		} else if (Utilities.isOnlyLetters(destinoDTO.getNombre()) == false) {
			throw new Exception("El atributo nombre solo recibe letras");
		} else if (Utilities.isOnlyLetters(destinoDTO.getDescripcion()) == false) {
			throw new Exception("El atributo descripcion solo recibe letras");
		} else if (Utilities.soloLetrasMayusculas(destinoDTO.getEstado()) == false) {
			throw new Exception("El atributo estado solo recibe letras mayusculas");
		} else if (Utilities.soloLetrasMayusculas(destinoDTO.getUsuCreador()) == false) {
			throw new Exception("El atributo usuCreador solo recibe letras mayusculas");
		}
		destino = new Destino();

		destino.setAire(destinoDTO.getAire());
		destino.setTierra(destinoDTO.getTierra());
		destino.setMar(destinoDTO.getMar());
		destino.setCodigo(destinoDTO.getCodigo());
		destino.setNombre(destinoDTO.getNombre());
		destino.setDescripcion(destinoDTO.getDescripcion());
		destino.setEstado(destinoDTO.getEstado());
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		destino.setUsuCreador(destinoDTO.getUsuCreador());

		// Se consulta el tipo destino dado su id
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoDestino == null) {
			throw new Exception("El tipo destino " + destinoDTO.getCodigoTipoDestino() + " No existe");
		}
		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		return destino;
	}

	@Override
	public Destino actualizarDestino(DestinoDTO destinoDTO) throws Exception {
		Destino destino = null;
		TipoDestino tipoDestino = null;
		// TODO: pendiente validaciones

		destino = findByID(destinoDTO.getIdDest());

		destino.setAire(destinoDTO.getAire());
		destino.setTierra(destinoDTO.getTierra());
		destino.setMar(destinoDTO.getMar());
		destino.setCodigo(destinoDTO.getCodigo());
		destino.setNombre(destinoDTO.getNombre());
		destino.setDescripcion(destinoDTO.getDescripcion());
		destino.setEstado(destinoDTO.getEstado());
		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		destino.setUsuCreador(destinoDTO.getUsuCreador());

		// Se consulta el tipo destino dado su id
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoDestino == null) {
			throw new Exception("El tipo destino " + destinoDTO.getCodigoTipoDestino() + " No existe");
		}
		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		
		return destino;
	}

	@Override
	public Destino findByID(Long idDest) throws Exception {
		if (idDest == null) {
			throw new Exception("Debe ingresar un id destino");
		}
		if (!destinoRepository.findById(idDest).isPresent()) {
			throw new Exception("El destino con id: " + idDest + " no existe");
		}
		return destinoRepository.findById(idDest).get();
	}

	@Override
	public void eliminarDestino(Long id) throws Exception {
		// validar id destino a elminiar

		if (id == null) {
			throw new Exception("El id destino es obligatirio");
		}
		if (destinoRepository.existsById(id) == false) {
			throw new Exception("El destino no se encontro");
		}
		destinoRepository.findById(id).ifPresent(destino -> {
			if (destino.getDetallePlan().isEmpty() == false) {
				throw new RuntimeException("El destino: " + id
						+ " tiene detalles de plan asignados, por lo que no se puede eliminar");
			}
		});
		destinoRepository.deleteById(id);
	}

}
