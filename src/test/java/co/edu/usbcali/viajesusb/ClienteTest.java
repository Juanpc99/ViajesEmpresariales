/**  
 * @Title:  ClienteTest.java   
 * @Package co.edu.usbcali.viajesusb   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:20:50 p. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.viajesusb.domain.Cliente;

import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.service.ClienteService;


/**   
 * @ClassName:  ClienteTest   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   6/09/2021 9:20:50 p. m.      
 * @Copyright:  USB
 */

@SpringBootTest
@Rollback(false)
class ClienteTest {

		@Autowired
		private ClienteService clienteService;
		
		@Test
		@Transactional
		void debeConsultarLosClientesPorEstadoOrdenandoDeFormaAscendentePorNumeroDeIdentificacion() {
			
			Page<Cliente> pageCliente = null;
			
			
			try {
				Pageable pageable = PageRequest.of(0,2);
				pageCliente = clienteService.findByEstadoOrderByNumeroIdentificacionAsc("A", pageable);
				
				for(Cliente cliente: pageCliente) {
					System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
				}
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
		void debeConsultarClientePorCorreoIgnorandoMayusculas() {
			
			Cliente cliente = null;
			
			try {
				
				cliente = clienteService.findByCorreoIgnoreCase("juancaro2010@hotmail.com");
				System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido()+ " " +cliente.getCorreo());
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		@Test
		@Transactional
		void debeConsultarClientePorNumeroIdentificacionConLike() {
			List<Cliente> listCliente = null;
			
			try {
				listCliente = clienteService.findByNumeroIdentificacionLike("1%");
				for(Cliente cliente: listCliente ) {
					System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		@Test
		@Transactional
		void debeConsultarClientePorNombreConLikeEIgnorandoMayusculasYMinusculas() {
			List<Cliente> listCliente = null;
			
			try {
				listCliente = clienteService.findByNombreLikeIgnoreCase("Juan");
				for(Cliente cliente: listCliente ) {
					System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		@Test
		@Transactional
		void debeConsultarClientePorRangoDeFechas() {
			List<Cliente> listCliente = null;
			Calendar fecha1 = new GregorianCalendar(2022, 12, 12);
			Calendar fecha2 = new GregorianCalendar(2022, 12, 12);
			try {
				listCliente = clienteService.findByFechaNacimientoBetween(fecha1.getTime(), fecha2.getTime());
				for(Cliente cliente: listCliente ) {
					System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido() + " fecha: " + cliente.getFechaNacimiento());
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		@Test
		@Transactional
		void debeCalcularElTotalDeClientesPorEstado() {
			Long cliente = null;
			
			try {
				cliente = clienteService.countByEstado("A");
				
				System.out.println("El total es: " + cliente);
				
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		@Test
		@Transactional
		void debeConsultarCLientesPorTipoIdentificacionPaginando() {
			
			Page<Cliente> pageCliente= null;
			
			try {
				Pageable pageable = PageRequest.of(0, 2);
				pageCliente = clienteService.findByIdTiid_Codigo("CC", pageable);
				
				for(Cliente cliente: pageCliente.getContent()) {
					System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());				
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test
		@Transactional
		void debeConsultarClientePorApellidos() {
			List<Cliente> listCliente = null;
			try {
				listCliente = clienteService.findByPrimerApellidoOrSegundoApellido("ergergerg", "15516151");
				for(Cliente cliente: listCliente ) {
					System.out.println(cliente.getNombre() + " "  + cliente.getPrimerApellido() + " " + cliente.getSegundoApellido());
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		@Test
		@Transactional
		void debeConsultarClienteConFiltrosYLike() {
			List<ClienteDTO> listCliente = null;
			try {
				listCliente = clienteService.consultarClientesConFiltros("Ju");
				for(ClienteDTO cliente: listCliente ) {
					System.out.println(cliente.getNombre() + " " + cliente.getNumeroIdentificacion() + " " + cliente.getEstado() + " " +cliente.getIdTiid());
				}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		/**
		@Test
		@Transactional
		void debeGuardarElCLiente() {
			try {
				ClienteDTO clienteDTO = new ClienteDTO();
				Calendar fecha1 = new GregorianCalendar(1888, 01, 02);
				//clienteDTO.setIdClie(15L);
				clienteDTO.setCorreo("juanpc999@gmail.com");
				clienteDTO.setNumeroIdentificacion("1000575950");
				clienteDTO.setPrimerApellido("Caro");
				clienteDTO.setSegundoApellido("Vargas");
				clienteDTO.setNombre("Juan");
				clienteDTO.setTelefono1("3121515156");
				clienteDTO.setTelefono2("3157204214");
				clienteDTO.setFechaNacimiento(fecha1.getTime());
				clienteDTO.setFechaCreacion(new Date());
				clienteDTO.setUsuCreador("YO");
				clienteDTO.setEstado("B");
				clienteDTO.setSexo("M");
				
				clienteDTO.setCodigoTipoIdentificacion("CC");
				clienteDTO.setEstadoTipoIdentificacion("A");
				clienteService.guardarCliente(clienteDTO);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		@Test
		@Transactional
		void debeActualizarElCliente() {
			ClienteDTO clienteDTO = new ClienteDTO();
			Calendar fecha1 = new GregorianCalendar(1888, 01, 02);
			try {
			clienteDTO.setIdClie(17L);
			clienteDTO.setCorreo("juanito@gmail.com");
			clienteDTO.setNumeroIdentificacion("2645656456");
			clienteDTO.setPrimerApellido("Hola");
			clienteDTO.setSegundoApellido("Palacios");
			clienteDTO.setNombre("Camilo");
			clienteDTO.setTelefono1("3121515156");
			clienteDTO.setTelefono2("3157204214");
			clienteDTO.setFechaNacimiento(fecha1.getTime());
			clienteDTO.setFechaCreacion(new Date());
			clienteDTO.setUsuCreador("YO");
			clienteDTO.setEstado("B");
			clienteDTO.setSexo("M");
			
			clienteDTO.setCodigoTipoIdentificacion("TI");
			clienteDTO.setEstadoTipoIdentificacion("A");
			clienteService.actualizarCliente(clienteDTO);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		@Test
		@Transactional
		void debeEliminarUnCliente() {
			try {
				ClienteDTO clienteDTO = new ClienteDTO();
				
				clienteDTO.setIdClie(17L);
				
				clienteService.eliminarCliente(clienteDTO);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

*/
}



