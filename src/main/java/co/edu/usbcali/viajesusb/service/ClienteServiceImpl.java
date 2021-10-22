/**  
 * @Title:  ClienteService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   20/09/2021 11:32:01 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;
import co.edu.usbcali.viajesusb.utils.Utilities;

/**
 * @ClassName: ClienteService
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 20/09/2021 11:32:01 p. m.
 * @Copyright: USB
 */
@Scope("singleton")
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	TipoIdentificacionService tipoIdentificacionService;

	/**
	 * <p>
	 * Title: findByEstadoOrderByNumeroIdentificacionAsc
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByEstadoOrderByNumeroIdentificacionAsc(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */

	@Override
	public Page<Cliente> findByEstadoOrderByNumeroIdentificacionAsc(String estado, Pageable pageable) throws Exception {
		Page<Cliente> pageCliente = null;

		if (estado == null || estado.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		} else if (pageable == null) {
			throw new Exception("El atributo pageable no debe ser nulo");
		} else if (Utilities.soloLetrasMayusculas(estado) == false) {
			throw new Exception("Debe ingresar un estado valido");
		} else if (estado.length() > 1) {

			throw new Exception("El estado debe ser de un solo caracter");
		}
		pageCliente = clienteRepository.findByEstadoOrderByNumeroIdentificacionAsc(estado, pageable);
		return pageCliente;
	}

	/**
	 * <p>
	 * Title: findByCorreoIgnoreCase
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param correo
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByCorreoIgnoreCase(java.lang.String)
	 */

	@Override
	public Cliente findByCorreoIgnoreCase(String correo) throws Exception {
		Cliente cliente = null;
		if (correo == null || correo.trim().equals("")) {
			throw new Exception("Debe ingresar un correo");
		} else if (Utilities.formatoCorreoValido(correo) == false) {
			throw new Exception("El correo no es valido");
		}
		cliente = clienteRepository.findByCorreoIgnoreCase(correo);

		return cliente;
	}

	/**
	 * <p>
	 * Title: findByNumeroIdentificacionLike
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param numeroID
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByNumeroIdentificacionLike(java.lang.String)
	 */

	@Override
	public List<Cliente> findByNumeroIdentificacionLike(String numeroID) throws Exception {

		List<Cliente> listCliente = null;

		if (numeroID == null || numeroID.trim().equals("")) {
			throw new Exception("Debe ingresar un ID");
		} else if (!Utilities.validarUnLike(numeroID)) {
			throw new Exception("Debe ingresar un ID valido");
		}
		listCliente = clienteRepository.findByNumeroIdentificacionLike(numeroID);
		return listCliente;
	}

	/**
	 * <p>
	 * Title: findByNombreLikeIgnoreCase
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByNombreLikeIgnoreCase(java.lang.String)
	 */

	@Override
	public List<Cliente> findByNombreLikeIgnoreCase(String nombre) throws Exception {
		List<Cliente> listCliente = null;
		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("Debe ingresar un nombre!");
		} else if (Utilities.isOnlyLetters(nombre) == false) {
			throw new Exception("Debe ingresar un nombre valido");
		} else if (nombre.length() > 100) {
			throw new Exception("El nombre no debe tener más de 100 caracteres");
		}
		listCliente = clienteRepository.findByNombreLikeIgnoreCase(nombre);
		return listCliente;
	}

	/**
	 * <p>
	 * Title: findByFechaNacimientoBetween
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fecha1
	 * @param fecha2
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByFechaNacimientoBetween(java.util.Date,
	 *      java.util.Date)
	 */

	@Override
	public List<Cliente> findByFechaNacimientoBetween(Date fechaInicio, Date fechaFin) throws Exception {
		List<Cliente> listCliente = null;
		if (fechaInicio == null || fechaFin == null) {
			throw new Exception("Debe ingresar las fechas");
		} else if (fechaInicio.compareTo(fechaFin) == 0) {
			throw new Exception("Las fechas no pueden ser iguales");
		} else if (fechaInicio.compareTo(fechaFin) >= 1) {
			throw new Exception("La fecha inicio no puede ser mayor que la fecha fin");
		} else if (fechaInicio.compareTo(new Date()) >= 0 || fechaFin.compareTo(new Date()) >= 0) {
			throw new Exception("Las fechas no deben ser mayores o iguales a la actual");
		}
		listCliente = clienteRepository.findByFechaNacimientoBetween(fechaInicio, fechaFin);
		return listCliente;
	}

	/**
	 * <p>
	 * Title: countByEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#countByEstado(java.lang.String)
	 */

	@Override
	public Long countByEstado(String estado) throws Exception {
		Long numero = null;

		if (estado == null || estado.trim().equals("")) {
			throw new Exception("Debe ingresar un estado!");
		} else if (Utilities.soloLetrasMayusculas(estado) == false) {
			throw new Exception("El estado solo debe tener una letra mayuscula");
		} else if (estado.length() > 1) {

			throw new Exception("El estado debe ser de un solo caracter");
		}
		numero = clienteRepository.countByEstado(estado);
		return numero;
	}

	/**
	 * <p>
	 * Title: findByIdTiid_Codigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param idTiid
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByIdTiid_Codigo(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */

	@Override
	public Page<Cliente> findByIdTiid_Codigo(String idTiid, Pageable pageable) throws Exception {
		Page<Cliente> pageCliente = null;
		if (idTiid == null || idTiid.trim().equals("")) {
			throw new Exception("Debe ingresar un id");
		} else if (pageable == null) {
			throw new Exception("El atributo pageable no debe ser nulo");
		} else if (Utilities.soloLetrasMayusculas(idTiid) == false) {
			throw new Exception("Debe ingrsar solo letras mayusculas");
		}
		pageCliente = clienteRepository.findByIdTiid_Codigo(idTiid, pageable);
		return pageCliente;
	}

	/**
	 * <p>
	 * Title: findByPrimerApellidoOrSegundoApellido
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param primerApellido
	 * @param segundoApellido
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByPrimerApellidoOrSegundoApellido(java.lang.String,
	 *      java.lang.String)
	 */

	@Override
	public List<Cliente> findByPrimerApellidoOrSegundoApellido(String primerApellido, String segundoApellido)
			throws Exception {
		List<Cliente> listCliente = null;

		if (primerApellido == null || primerApellido.trim().equals("") || segundoApellido == null
				|| segundoApellido.trim().equals("")) {
			throw new Exception("Debe ingresar un nombre!");
		} else if (Utilities.isOnlyLetters(primerApellido) == false) {
			throw new Exception("Debe ingresar apellidos validos");
		} else if (Utilities.isOnlyLetters(segundoApellido) == false) {
			throw new Exception("El segundo apellido solo puede contener letras");
		} else if (primerApellido.length() > 100) {
			throw new Exception("El primer apellido no debe tener más de 100 caracteres");
		} else if (segundoApellido.length() > 100) {
			throw new Exception("El segundo apellido no debe tener más de 100 caracteres");
		}
		listCliente = clienteRepository.findByPrimerApellidoOrSegundoApellido(primerApellido, segundoApellido);
		return listCliente;
	}

	/**
	 * <p>
	 * Title: consultarClientesConFiltros
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param nombre
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#consultarClientesConFiltros(java.lang.String)
	 */

	@Override
	public List<ClienteDTO> consultarClientesConFiltros(String nombre) throws Exception {
		List<ClienteDTO> listClienteDTO;
		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("Debe ingresar un nombre!");
		} else if (Utilities.isOnlyLetters(nombre) == false) {
			throw new Exception("Debe ingresar un nombre valido");
		} else if (nombre.length() > 100) {
			throw new Exception("El nombre no debe tener más de 100 caracteres");
		}
		listClienteDTO = clienteRepository.consultarClientesConFiltros(nombre);
		return listClienteDTO;
	}

	/**
	 * <p>
	 * Title: guardarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#guardarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */

	@Override
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws Exception {

		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;
		// TODO: pendiente validacion
		// if(clienteDTO.getIdClie() == null ) {
		// throw new Exception("Debe ingresar un id");
		// }
		if (clienteDTO.getCorreo().trim() == null || clienteDTO.getCorreo().trim() == "") {
			throw new Exception("Debe ingresar un correo");
		}
		if (clienteDTO.getNumeroIdentificacion().trim() == null || clienteDTO.getNumeroIdentificacion().trim() == "") {
			throw new Exception("Debe ingresar un numero de identificacion");
		}
		if (clienteDTO.getPrimerApellido().trim() == null || clienteDTO.getPrimerApellido().trim() == "") {
			throw new Exception("Debe ingresar un apellido");
		}
		if (clienteDTO.getSegundoApellido().trim() == null || clienteDTO.getSegundoApellido().trim() == "") {
			throw new Exception("Debe ingresar un apellido");
		}
		if (clienteDTO.getNombre().trim() == null || clienteDTO.getNombre().trim() == "") {
			throw new Exception("Debe ingresar un nombre");
		}
		if (clienteDTO.getTelefono1().trim() == null || clienteDTO.getTelefono1().trim() == "") {
			throw new Exception("Debe ingresar un telefono");
		}
		if (clienteDTO.getTelefono2().trim() == null || clienteDTO.getTelefono2().trim() == "") {
			throw new Exception("Debe ingresar un telefono");
		}
		if (clienteDTO.getFechaNacimiento() == null) {
			throw new Exception("Debe ingresar una fecha de nacimiento");
		}
		if (clienteDTO.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha creacion");
		}
		if (clienteDTO.getUsuCreador().trim() == null || clienteDTO.getUsuCreador().trim() == "") {
			throw new Exception("Debe ingresar un usuario creador");
		}
		if (clienteDTO.getEstado().trim() == null || clienteDTO.getEstado().trim() == "") {
			throw new Exception("Debe ingresar un estado");
		}
		if (clienteDTO.getSexo().trim() == null || clienteDTO.getSexo().trim() == "") {
			throw new Exception("Debe ingresar un estado");
		}
		if (Utilities.isValidEmail(clienteDTO.getCorreo()) == false) {
			throw new Exception("Debe ingresar un correo valido");
		}
		if (Utilities.isNumeric(clienteDTO.getNumeroIdentificacion()) == false) {
			throw new Exception("Debe ingresar un numero identificacion valido");
		}
		if (Utilities.isOnlyLetters(clienteDTO.getPrimerApellido()) == false) {
			throw new Exception("Debe ingresar un primer apellido valido");
		}
		if (Utilities.isOnlyLetters(clienteDTO.getSegundoApellido()) == false) {
			throw new Exception("Debe ingresar un segundo apellido valido");
		}
		if (clienteRepository.findByNumeroIdentificacionLike(clienteDTO.getNumeroIdentificacion()).isEmpty() == false) {
			throw new Exception("El tipo identificacion " + clienteDTO.getNumeroIdentificacion() + " ya existe");
		}
		if (clienteDTO.getCodigoTipoIdentificacion() == null || clienteDTO.getCodigoTipoIdentificacion() == "") {
			throw new Exception("Debe ingresar el codigo tipo identificacion");
		}
		if (clienteDTO.getEstadoTipoIdentificacion() == null || clienteDTO.getEstadoTipoIdentificacion() == "") {
			throw new Exception("Debe ingresar el estado tipo identificacion");
		}
		if (Utilities.isOnlyLetters(clienteDTO.getNombre()) == false) {
			throw new Exception("Debe ingresar un nombre valido");
		}
		if (Utilities.isNumeric(clienteDTO.getTelefono1()) == false) {
			throw new Exception("Debe ingresar un telefono1 valido");
		}
		if (Utilities.isNumeric(clienteDTO.getTelefono2()) == false) {
			throw new Exception("Debe ingresar un telefonos valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getUsuCreador()) == false) {
			throw new Exception("Debe ingresar un usuario creador valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getEstado()) == false) {
			throw new Exception("Debe ingresar un estado valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getSexo()) == false) {
			throw new Exception("Debe ingresar un sexo valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getCodigoTipoIdentificacion()) == false) {
			throw new Exception("Debe ingresar un codigo tipo identificacion valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getEstadoTipoIdentificacion()) == false) {
			throw new Exception("Debe ingresar un estado de tipo identificacion valido");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getNumeroIdentificacion(), 15) == false) {
			throw new Exception("El numero identificacion no debe ser mayor a 15 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getPrimerApellido(), 100) == false) {
			throw new Exception("El primer apellido no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getSegundoApellido(), 100) == false) {
			throw new Exception("El segundo apellido no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getNombre(), 100) == false) {
			throw new Exception("El  nombre no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getTelefono1(), 15) == false) {
			throw new Exception("El telefono1 no debe ser mayor a 15 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getTelefono2(), 15) == false) {
			throw new Exception("El telefono2 no debe ser mayor a 15 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getCorreo(), 100) == false) {
			throw new Exception("El correo no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getSexo(), 1) == false) {
			throw new Exception("El sexo no debe ser mayor a 1 caractere");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getUsuCreador(), 10) == false) {
			throw new Exception("El usuario creador no debe ser mayor a 10 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getCodigoTipoIdentificacion(), 5) == false) {
			throw new Exception("El codigo de tipo identificacion no debe ser mayor a 5 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getEstadoTipoIdentificacion(), 1) == false) {
			throw new Exception("El estado de tipo identificacion no debe ser mayor a 1 caractere");
		}

		cliente = new Cliente();

		cliente.setIdClie(clienteDTO.getIdClie());
		cliente.setCorreo(clienteDTO.getCorreo());
		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setTelefono1(clienteDTO.getTelefono1());
		cliente.setTelefono2(clienteDTO.getTelefono2());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setUsuCreador(clienteDTO.getUsuCreador());
		cliente.setEstado(clienteDTO.getEstado());
		cliente.setSexo(clienteDTO.getSexo());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				clienteDTO.getEstadoTipoIdentificacion());
		if (tipoIdentificacion == null) {
			throw new Exception("El tipo identificacion " + clienteDTO.getIdTiid() + " no existe");
		}
		cliente.setIdTiid(tipoIdentificacion);

		clienteRepository.save(cliente);
		
		return cliente;

	}

	/**
	 * <p>
	 * Title: actualizarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#actualizarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */

	@Override
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws Exception {

		if (clienteDTO.getIdClie() == null) {
			throw new Exception("Debe ingresar un id");
		}
		if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo() == "") {
			throw new Exception("Debe ingresar un correo");
		}
		if (clienteDTO.getNumeroIdentificacion() == null || clienteDTO.getNumeroIdentificacion() == "") {
			throw new Exception("Debe ingresar un numero de identificacion");
		}
		if (clienteDTO.getPrimerApellido() == null || clienteDTO.getPrimerApellido() == "") {
			throw new Exception("Debe ingresar un apellido");
		}
		if (clienteDTO.getSegundoApellido() == null || clienteDTO.getSegundoApellido() == "") {
			throw new Exception("Debe ingresar un apellido");
		}
		if (clienteDTO.getNombre() == null || clienteDTO.getNombre() == "") {
			throw new Exception("Debe ingresar un nombre");
		}
		if (clienteDTO.getTelefono1() == null || clienteDTO.getTelefono1() == "") {
			throw new Exception("Debe ingresar un telefono");
		}
		if (clienteDTO.getTelefono2() == null || clienteDTO.getTelefono2() == "") {
			throw new Exception("Debe ingresar un telefono");
		}
		if (clienteDTO.getFechaNacimiento() == null) {
			throw new Exception("Debe ingresar una fecha de nacimiento");
		}
		if (clienteDTO.getFechaCreacion() == null) {
			throw new Exception("Debe ingresar una fecha creacion");
		}
		if (clienteDTO.getUsuCreador() == null || clienteDTO.getUsuCreador() == "") {
			throw new Exception("Debe ingresar un usuario creador");
		}
		if (clienteDTO.getEstado() == null || clienteDTO.getEstado() == "") {
			throw new Exception("Debe ingresar un estado");
		}
		if (clienteDTO.getSexo() == null || clienteDTO.getSexo() == "") {
			throw new Exception("Debe ingresar un estado");
		}
		if (Utilities.isValidEmail(clienteDTO.getCorreo()) == false) {
			throw new Exception("Debe ingresar un correo valido");
		}
		if (Utilities.isNumeric(clienteDTO.getNumeroIdentificacion()) == false) {
			throw new Exception("Debe ingresar un numero identificacion valido");
		}
		if (Utilities.isOnlyLetters(clienteDTO.getPrimerApellido()) == false) {
			throw new Exception("Debe ingresar un primer apellido valido");
		}
		if (Utilities.isOnlyLetters(clienteDTO.getSegundoApellido()) == false) {
			throw new Exception("Debe ingresar un segundo apellido valido");
		}
		if (clienteDTO.getCodigoTipoIdentificacion() == null || clienteDTO.getCodigoTipoIdentificacion() == "") {
			throw new Exception("Debe ingresar el codigo tipo identificacion");
		}
		if (clienteDTO.getEstadoTipoIdentificacion() == null || clienteDTO.getEstadoTipoIdentificacion() == "") {
			throw new Exception("Debe ingresar el estado tipo identificacion");
		}
		if (clienteRepository.findByNumeroIdentificacionLike(clienteDTO.getNumeroIdentificacion()).isEmpty() == false) {
			throw new Exception("El tipo identificacion " + clienteDTO.getNumeroIdentificacion() + " ya existe");
		}
		if (Utilities.isOnlyLetters(clienteDTO.getNombre()) == false) {
			throw new Exception("Debe ingresar un nombre valido");
		}
		if (Utilities.isNumeric(clienteDTO.getTelefono1()) == false) {
			throw new Exception("Debe ingresar un telefono1 valido");
		}
		if (Utilities.isNumeric(clienteDTO.getTelefono2()) == false) {
			throw new Exception("Debe ingresar un telefonos valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getUsuCreador()) == false) {
			throw new Exception("Debe ingresar un usuario creador valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getEstado()) == false) {
			throw new Exception("Debe ingresar un estado valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getSexo()) == false) {
			throw new Exception("Debe ingresar un sexo valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getCodigoTipoIdentificacion()) == false) {
			throw new Exception("Debe ingresar un codigo tipo identificacion valido");
		}
		if (Utilities.soloLetrasMayusculas(clienteDTO.getEstadoTipoIdentificacion()) == false) {
			throw new Exception("Debe ingresar un estado de tipo identificacion valido");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getNumeroIdentificacion(), 15) == false) {
			throw new Exception("El numero identificacion no debe ser mayor a 15 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getPrimerApellido(), 100) == false) {
			throw new Exception("El primer apellido no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getSegundoApellido(), 100) == false) {
			throw new Exception("El segundo apellido no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getNombre(), 100) == false) {
			throw new Exception("El  nombre no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getTelefono1(), 15) == false) {
			throw new Exception("El telefono1 no debe ser mayor a 15 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getTelefono2(), 15) == false) {
			throw new Exception("El telefono2 no debe ser mayor a 15 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getCorreo(), 100) == false) {
			throw new Exception("El correo no debe ser mayor a 100 caracteres");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getSexo(), 1) == false) {
			throw new Exception("El sexo no debe ser mayor a 1 caractere");
		}
		if (Utilities.checkWordAndCheckWithlength(clienteDTO.getUsuCreador(), 10) == false) {
			throw new Exception("El usuario creador no debe ser mayor a 10 caracteres");
		} else if (Utilities.checkWordAndCheckWithlength(clienteDTO.getCodigoTipoIdentificacion(), 5) == false) {
			throw new Exception("El codigo de tipo identificacion no debe ser mayor a 5 caracteres");
		} else if (Utilities.checkWordAndCheckWithlength(clienteDTO.getEstadoTipoIdentificacion(), 1) == false) {
			throw new Exception("El estado de tipo identificacion no debe ser mayor a 1 caractere");
		}
		Cliente cliente = new Cliente();
		TipoIdentificacion tipoIdentificacion = null;

		cliente = findById(clienteDTO.getIdClie());
		cliente.setCorreo(clienteDTO.getCorreo());
		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setTelefono1(clienteDTO.getTelefono1());
		cliente.setTelefono2(clienteDTO.getTelefono2());
		cliente.setFechaNacimiento(cliente.getFechaNacimiento());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setUsuCreador(clienteDTO.getUsuCreador());
		cliente.setEstado(clienteDTO.getEstado());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(), Constantes.ACTIVO);
		if (tipoIdentificacion == null) {
			throw new Exception("El tipo identificacion " + clienteDTO.getIdTiid() + " no existe");
		}
		cliente.setIdTiid(tipoIdentificacion);

		clienteRepository.save(cliente);
		return cliente;
	}

	/**
	 * <p>
	 * Title: findById
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param idClie
	 * @return
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findById(java.lang.Long)
	 */

	@Override
	public Cliente findById(Long idClie) throws Exception {
		if (idClie == null) {
			throw new Exception("Debe ingresar un id cliente");
		}
		if (!clienteRepository.findById(idClie).isPresent()) {
			throw new Exception("El cliente con id: " + idClie + " no existe");
		}
		return clienteRepository.findById(idClie).get();
	}

	/**
	 * <p>
	 * Title: eliminarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#eliminarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */

	@Override
	public void eliminarCliente(Long id) throws Exception {
		if (id == null ) {
			throw new Exception("El id cliente es obligatirio");
		}
		if (clienteRepository.existsById(id) == false) {
			throw new Exception("El cliente no se encontro");
		}
		clienteRepository.findById(id).ifPresent(cliente -> {
			if (cliente.getPlan().isEmpty() == false) {
				throw new RuntimeException("El cliente: " + id
						+ " tiene planes asignados, por lo que no se puede eliminar");
			}
		});
		clienteRepository.deleteById(id);
	}

	
}
