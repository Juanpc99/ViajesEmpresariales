/**  
 * @Title:  DestinoTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   31/08/2021 12:52:59 p. m.   
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.service.DestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**   
 * @ClassName:  DestinoTest   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   31/08/2021 12:52:59 p. m.      
 * @Copyright:  USB
 */

@SpringBootTest
@Rollback(false)
class DestinoTest {

	@Autowired
	private DestinoService destinoService;

	@Test
	@Transactional
	void debeConsultarDestinosPorTipoDestino() {
		
		List<Destino> listDestino= null;
		
		try {
			
			listDestino = destinoService.findByTipoDestino_Codigo("PLAYA");
			
			for(Destino destino: listDestino) {
				System.out.println(destino.getCodigo());				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarDestinosPorEstadoPaginado() {
		
		Page<Destino> pageDestino= null;
		
		try {
			Pageable pageable = PageRequest.of(0, 1);
			pageDestino = destinoService.findByEstado("A", pageable);
			
			for(Destino destino: pageDestino.getContent()) {
				System.out.println(destino.getCodigo());				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	@Test
	@Transactional
	void debeGuardarElDestinoSanAndres() {
		try {
			DestinoDTO destinoDTO = new DestinoDTO();
			
			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setMar(Constantes.NO);
			destinoDTO.setTierra(Constantes.SI);
			
			destinoDTO.setNombre("Juan");
			destinoDTO.setCodigo("EWFE");
			destinoDTO.setDescripcion("WFE");
			destinoDTO.setEstado(Constantes.ACTIVO);
			destinoDTO.setFechaCreacion(new Date());
			destinoDTO.setUsuCreador("JUANPC");
			
			destinoDTO.setCodigoTipoDestino("BOSQU");
			destinoDTO.setNombreTipoDestino("NATURALEZA, BOSQUE Y AIRE");
			
			destinoService.guardarDestino(destinoDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	void debeActualizarElDestinoSanAndres() {
		try {
			DestinoDTO destinoDTO = new DestinoDTO();
			
			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setIdDest(2L);
			destinoDTO.setMar(Constantes.NO);
			destinoDTO.setTierra(Constantes.SI);
			
			destinoDTO.setNombre("San Andreeeees");
			destinoDTO.setCodigo("SANDI");
			destinoDTO.setDescripcion("San andres islas");
			destinoDTO.setEstado(Constantes.ACTIVO);
			destinoDTO.setFechaCreacion(new Date());
			destinoDTO.setUsuCreador("JUANP");
			
			destinoDTO.setCodigoTipoDestino("PLAYA");
			destinoDTO.setNombreTipoDestino("PLAYA Y MAR");
			
			destinoService.actualizarDestino(destinoDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	@Transactional
	void debeEliminarElDestinoSanAndres() {
		try {
			DestinoDTO destinoDTO = new DestinoDTO();
			
			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setIdDest(1L);
			
			
			destinoService.eliminarDestino(destinoDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
*/
}
