/**  
 * @Title:  TipoDestinoTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   31/08/2021 11:20:24 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb;

//import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.service.TipoDestinoService;

/**   
 * @ClassName:  TipoDestinoTest   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   31/08/2021 11:20:24 a. m.      
 * @Copyright:  USB
 */
@SpringBootTest
@Rollback(false)
class TipoDestinoTest {
	
	@Autowired
	private TipoDestinoService tipoDestinoService;
	private TipoDestino tipoDestino = null;
	
	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorCodigo() {
		
		
		
		try {
			tipoDestino=tipoDestinoService.findByCodigo("PLAYA");
			System.out.println(tipoDestino.getCodigo() + " " + tipoDestino.descripcion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorCodigoEstado() {
			try {
				tipoDestino=tipoDestinoService.findByCodigo("PLAYA");
				System.out.println(tipoDestino.getCodigo());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 

	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorEstadoOrdenadoAlfabeticamente() {
		
		List<TipoDestino> listTipoDestino = null;
		try {
			listTipoDestino = tipoDestinoService.findByEstadoOrderByNombre("A");
			
			for(TipoDestino tipoDestino: listTipoDestino) {
				System.out.println(tipoDestino.getCodigo());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	@Test
	@Transactional
	void debeAgregarUnTipoDestino() {
		try {
			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
			
			tipoDestinoDTO.setIdTide(5L);
			tipoDestinoDTO.setCodigo("NUEVO");
			tipoDestinoDTO.setNombre("NUEVO");
			tipoDestinoDTO.setDescripcion("Es algo nuevo");
			tipoDestinoDTO.setFechaCreacion(new Date());
			tipoDestinoDTO.setUsuCreador("YO");
			tipoDestinoDTO.setEstado("A");
			
			tipoDestinoService.guardarTipoDestino(tipoDestinoDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	@Transactional
	void debeActualizarUnTipoDestino() {
		try {
			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
			
			tipoDestinoDTO.setIdTide(1L);
			tipoDestinoDTO.setCodigo("NUE");
			tipoDestinoDTO.setNombre("NUEVO");
			tipoDestinoDTO.setDescripcion("Es algo nuevo");
			tipoDestinoDTO.setFechaCreacion(new Date());
			tipoDestinoDTO.setUsuCreador("YO");
			tipoDestinoDTO.setEstado("A");
			
			tipoDestinoService.actualizarTipoDestino(tipoDestinoDTO);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Test
	@Transactional
	void debeEliminarUnTipoDestino() {
		try {
			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
			tipoDestinoDTO.setIdTide(1L);
			
			tipoDestinoService.eliminarTipoDestino(tipoDestinoDTO);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
/**
	@Test
	@Transactional
    void consultarTipoDestinoPorEstado() {
		
		//Se consultan los tipos de destino por estado
		List<TipoDestinoDTO> listTipoDestino = null;
		try {
			listTipoDestino = tipoDestinoRepository.consultarTipoDestinoPorEstado("A");
			for (TipoDestinoDTO tipoDestino : listTipoDestino) {
				System.out.println("Tipo de destino - ID: " + tipoDestino.getIdTide() + " - Nombre: " + tipoDestino.getNombre() + tipoDestino.getCodigo() + tipoDestino.getDescripcion());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
}
