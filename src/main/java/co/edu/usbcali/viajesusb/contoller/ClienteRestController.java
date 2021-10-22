/**  
 * @Title:  ClienteRestController.java   
 * @Package co.edu.usbcali.viajesusb.contoller   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:46:59 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.contoller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.mapper.ClienteMapper;
import co.edu.usbcali.viajesusb.service.ClienteService;

/**   
 * @ClassName:  ClienteRestController   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:46:59 a. m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {

	@Autowired
	ClienteService clienteService;
	@Autowired
	ClienteMapper clienteMapper;
	
	@GetMapping("/encontrarPorEstadoOrdenandoAsc")
	public ResponseEntity<List<ClienteDTO>> encontrarPorEstadoOrdenandoAscendente(@RequestParam("estado")String estado){
		try {
			Pageable pageable = PageRequest.of(0, 2);
			Page<Cliente> pageCliente = clienteService.findByEstadoOrderByNumeroIdentificacionAsc(estado, pageable);
			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(pageCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/encontrarPorCorreoIgnoreCase")
	public ResponseEntity<ClienteDTO> encontrarPorCorreoIgnoreCase (@RequestParam("correo")String correo){
		try {
			Cliente cliente = clienteService.findByCorreoIgnoreCase(correo);
			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	@GetMapping("/econtrarPorNumeroIdentificacionLike")
	public ResponseEntity<List<ClienteDTO>> encontrarPorNuemroIdentificacionLike(@RequestParam("numeroID")String numeroID){
		try {
			List<Cliente> listCliente = clienteService.findByNumeroIdentificacionLike(numeroID);
			return ResponseEntity.ok(clienteMapper.listClienteToListClienteDTO(listCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/encontrarPorNombre")
	public ResponseEntity<List<ClienteDTO>> encontrarPorNombreLike(@RequestParam("nombre") String nombre){
		try {
			List<Cliente> listCliente = clienteService.findByNombreLikeIgnoreCase(nombre);
			
			return ResponseEntity.ok(clienteMapper.listClienteToListClienteDTO(listCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/entreDosFechas")
	public ResponseEntity<List<ClienteDTO>> encontrarEntreDosFechas(@RequestParam("fechaInicio")Date fechaInicio, @RequestParam("fechaFin") Date fechafin){
		try {
			List<Cliente> listCliente = clienteService.findByFechaNacimientoBetween(fechaInicio, fechafin);
			return ResponseEntity.ok(clienteMapper.listClienteToListClienteDTO(listCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/contarPorEstado")
	public ResponseEntity<Long> contarPorEstado(@RequestParam("estado")String estado){
		try {
			return ResponseEntity.ok(clienteService.countByEstado(estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/encontrarPorCodigoDeTiid")
	public ResponseEntity<List<ClienteDTO>> encontrarPorCodigoDeTiid(@RequestParam("codigo")String codigo){
		try {
			Pageable pageable = PageRequest.of(0, 2);
			Page<Cliente> pageCliente = clienteService.findByIdTiid_Codigo(codigo, pageable);
			return ResponseEntity.ok(clienteMapper.listClienteToListClienteDTO(pageCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/encontrarPorPrimerOSegindoApellido")
	public ResponseEntity<List<ClienteDTO>> encontrarPorPrimerOSegundoApellido(@RequestParam("primerApellido")String primerApellido, @RequestParam("segundoApellido")String segundoApellido){
		try {
			List<Cliente> listCliente = clienteService.findByPrimerApellidoOrSegundoApellido(primerApellido, segundoApellido);
			return ResponseEntity.ok(clienteMapper.listClienteToListClienteDTO(listCliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/encontrarPorFiltros")
	public ResponseEntity<List<ClienteDTO>> encontrarPorFiltros(@RequestParam("nombre")String nombre){
		try {
			List<ClienteDTO> listClienteDTO = clienteService.consultarClientesConFiltros(nombre);
			return ResponseEntity.ok(listClienteDTO);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@PostMapping("/guardarCliente")
	public ResponseEntity<ClienteDTO> guardarCliente(@RequestBody ClienteDTO clienteDTO){
		try {
			Cliente cliente = clienteService.guardarCliente(clienteDTO);
			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@PutMapping("/editarCliente")
	public ResponseEntity<ClienteDTO> EditarCliente(@RequestBody ClienteDTO clienteDTO){
		try {
			Cliente cliente = clienteService.actualizarCliente(clienteDTO);
			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@DeleteMapping("/eliminarCliente")
	public ResponseEntity<String> eliminarCliente(@RequestParam("id") Long id){
		try {
			clienteService.eliminarCliente(id);
			return ResponseEntity.ok("Se elimino correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
}
