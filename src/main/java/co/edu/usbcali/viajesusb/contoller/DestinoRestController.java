/**  
 * @Title:  DestinoRestController.java   
 * @Package co.edu.usbcali.viajesusb.contoller   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:46:34 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Destino;

import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.mapper.DestinoMapper;
import co.edu.usbcali.viajesusb.service.DestinoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**   
 * @ClassName:  DestinoRestController   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:46:34 a. m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/destino")
public class DestinoRestController {
	
	@Autowired
	private DestinoService destinoService;
	@Autowired
	private DestinoMapper destinoMapper;
	
	@PostMapping("/guardarDestino")
	public ResponseEntity<DestinoDTO> guardarDestino(@RequestBody DestinoDTO destinoDTO){
		try {
			Destino destino =  destinoService.guardarDestino(destinoDTO);
			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@DeleteMapping("/eliminarDestino/{id}")
	public ResponseEntity<String> eliminarDestino(@PathVariable("id") Long id){
		try {
			destinoService.eliminarDestino(id);
			return ResponseEntity.ok("Se elimino satisfactoriamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@PutMapping("/editarDestino")
	public ResponseEntity<DestinoDTO> editarDestino(@RequestBody DestinoDTO destinoDTO){
		try {
			Destino destino = destinoService.actualizarDestino(destinoDTO);
			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/encontrarPorCodigoTipoDestino")
	public ResponseEntity<List<DestinoDTO>> encontrarPorCodigoTipoDestino(@RequestParam("codigo") String codigo ){
		try {
			List<Destino> listDestino = destinoService.findByTipoDestino_Codigo(codigo);
			return ResponseEntity.ok(destinoMapper.listDestinoToListDestinoDTO(listDestino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/encontrarPorEstado")
	public ResponseEntity<List<DestinoDTO>> encontrarPorEstado(@RequestParam("estado")String estado){
		try {
			Pageable pageable = PageRequest.of(1, 3);
			Page<Destino> listDestino = destinoService.findByEstado(estado, pageable);
			return ResponseEntity.ok().body(destinoMapper.listDestinoToListDestinoDTO(listDestino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@GetMapping("/encontrarPorId")
	public ResponseEntity<DestinoDTO> encontrarPorId(@RequestParam("id") Long id){
		try {
			Destino destino = destinoService.findByID(id);
			return ResponseEntity.ok().body(destinoMapper.destinoToDestinoDTO(destino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
