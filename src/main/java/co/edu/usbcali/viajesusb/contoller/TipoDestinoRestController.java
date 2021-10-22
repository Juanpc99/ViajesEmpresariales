/**  
 * @Title:  TipoDestinoRestController.java   
 * @Package co.edu.usbcali.viajesusb.contoller   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:46:48 a. m.   
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.mapper.TipoDestinoMapper;
import co.edu.usbcali.viajesusb.service.TipoDestinoService;

/**
 * @ClassName: TipoDestinoRestController
 * @Description: TODO
 * @author: JuanPabloCaro
 * @date: 18/10/2021 9:46:48 a. m.
 * @Copyright: USB
 */
@RestController
@RequestMapping("/api/tipoDestino")
public class TipoDestinoRestController {
	@Autowired
	private TipoDestinoService tipoDestinoService;

	@Autowired
	private TipoDestinoMapper tipoDestinoMapper;

	@PostMapping("/guardarTipoDestino")
	public ResponseEntity<TipoDestinoDTO> guardarTipoDestino(@RequestBody TipoDestinoDTO tipoDestinoDTO){
		try {
			TipoDestino tipoDestino = tipoDestinoService.guardarTipoDestino(tipoDestinoDTO);
			return ResponseEntity.ok(tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/editarTipoDestino")
	public ResponseEntity<TipoDestinoDTO> editarTipoDestino(@RequestBody TipoDestinoDTO tipoDestinoDTO){
		try {
			TipoDestino tipoDestino = tipoDestinoService.actualizarTipoDestino(tipoDestinoDTO);
			return ResponseEntity.ok(tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/eliminarTipodestino")
	public ResponseEntity<String> eliminarTipoDestino(@RequestParam("id")Long id){
		try {
			tipoDestinoService.eliminarTipoDestino(id);
			return ResponseEntity.ok("Se elimino correctamente");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/getTipoDestinoPorCodigo")
	public ResponseEntity<TipoDestinoDTO> buscarTipoDestinoPorCodigo(@RequestParam("codigo") String codigo) {
		try {
			TipoDestino tipoDestino = tipoDestinoService.findByCodigo(codigo);
			return ResponseEntity.ok().body(tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/encontrarPorCodigoYEstado")
	public ResponseEntity<TipoDestinoDTO> encontrarPorCodigoYEstado(@RequestParam("codigo")String codigo, @RequestParam("estado") String estado){
		try {
			TipoDestino tipoDestino =  tipoDestinoService.findByCodigoAndEstado(codigo, estado);
			return ResponseEntity.ok(tipoDestinoMapper.tipoDestinoToTipoDestinoDTO(tipoDestino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@GetMapping("/consultarTipoDestinoPorEstado")
	public ResponseEntity<List<TipoDestinoDTO>> consultarTipoDestinoAlfabetico(@RequestParam("estado") String estado) {
		try {
			List<TipoDestino> listTipoDestino = tipoDestinoService.findByEstadoOrderByNombre(estado);
			

			return ResponseEntity.ok().body(tipoDestinoMapper.listTipoDestinoToListTipoDestinoDTO(listTipoDestino));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	
	
}
