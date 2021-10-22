/**  
 * @Title:  TipoIdentificacionRestController.java   
 * @Package co.edu.usbcali.viajesusb.contoller   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:47:56 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.mapper.TipoIdentificacionMapper;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;

/**   
 * @ClassName:  TipoIdentificacionRestController   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   18/10/2021 9:47:56 a. m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/tipoIdentificacion")
public class TipoIdentificacionRestController {
	@Autowired
	TipoIdentificacionService tipoIdentificacionService;
	@Autowired
	TipoIdentificacionMapper tipoIdentificacionMapper;
	
	@GetMapping("/encontrarPorEstadoOrdenarPorNombre")
	public ResponseEntity<List<TipoIdentificacionDTO>> encontrarPorEstadoOrdenarPorNombre(@RequestParam("estado")String estado){
		try {
			List<TipoIdentificacion> listTipoIdentificacion = tipoIdentificacionService.findByEstadoOrderByNombreAsc(estado);
			return ResponseEntity.ok(tipoIdentificacionMapper.listTipoIdentificacionToListTipoIdentificacionDTO(listTipoIdentificacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	@GetMapping("/encontrarPorEstadoYCodigo")
	public ResponseEntity<TipoIdentificacionDTO> encontrarPorEstadoYCodigo(@RequestParam("estado")String estado, @RequestParam("codigo") String codigo){
		try {
			TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(codigo ,estado);
			return ResponseEntity.ok(tipoIdentificacionMapper.tipoIdentificacionToTipoIdentificacionDTO(tipoIdentificacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	@PostMapping("/guardar")
	public ResponseEntity<TipoIdentificacionDTO> guardar(@RequestBody TipoIdentificacionDTO tipoIdentificacionDTO){
		try {
			TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.guardarTipoIdentificacion(tipoIdentificacionDTO);
			return ResponseEntity.ok(tipoIdentificacionMapper.tipoIdentificacionToTipoIdentificacionDTO(tipoIdentificacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}

}
