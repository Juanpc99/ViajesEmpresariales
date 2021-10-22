/**  
 * @Title:  TipoIdentificacionTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:20:35 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;

/**   
 * @ClassName:  TipoIdentificacionTest   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:20:35 p. m.      
 * @Copyright:  USB
 */

@SpringBootTest
@Rollback(false)
class TipoIdentificacionTest {

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	
	
	@Test
	@Transactional
	void debeConsultarTiposIdentificacionPorEstado(){
		List<TipoIdentificacion> listaTipoIdentificacion = null;
		
		try {
			listaTipoIdentificacion = tipoIdentificacionService.findByEstadoOrderByNombreAsc("A");
			
			for(TipoIdentificacion tipoId: listaTipoIdentificacion) {
				
				System.out.println("Nombre: " + tipoId.getNombre() + " Estad: " + tipoId.getEstado());
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarTiposIdentificacionPorCodigoYEstado(){
		TipoIdentificacion tipoIdentificacion = null;
		
		try {
			tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado("CC", "A");
			
				
				System.out.println(tipoIdentificacion.getNombre() + " Estado: " + tipoIdentificacion.getEstado() + " Codigo: " + tipoIdentificacion.getCodigo());
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@Transactional
	void debeGuardarUntipoIdentificacion() {
		TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
		try {
		tipoIdentificacionDTO.setIdTiid(6L);
		tipoIdentificacionDTO.setCodigo("PI");
		tipoIdentificacionDTO.setFechaCreacion(new Date());
		tipoIdentificacionDTO.setUsuCreador("YO");
		tipoIdentificacionDTO.setEstado("A");
		tipoIdentificacionDTO.setNombre("NO IDENTIFICADO");
		
		tipoIdentificacionService.guardarTipoIdentificacion(tipoIdentificacionDTO);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	@Test
	@Transactional
	void debeActualizarTipoIdentificacion() {
		TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
		try {
			tipoIdentificacionDTO.setIdTiid(5L);
			tipoIdentificacionDTO.setCodigo("TIIIIIIIIIII");
			tipoIdentificacionDTO.setFechaCreacion(new Date());
			tipoIdentificacionDTO.setUsuCreador("YO");
			tipoIdentificacionDTO.setEstado("A");
			tipoIdentificacionDTO.setNombre("TARJETA DE IDENTIDAD");
			
			tipoIdentificacionService.actualizarTipoIdentificacion(tipoIdentificacionDTO);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}
	@Test
	@Transactional
	void debeELiminarTipoIdentificacion() {
		try {
			TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
			
			tipoIdentificacionDTO.setIdTiid(1L);
			tipoIdentificacionService.eliminarTipoIdentificacion(tipoIdentificacionDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
*/
}
