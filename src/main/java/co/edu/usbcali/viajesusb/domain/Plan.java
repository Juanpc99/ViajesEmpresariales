/**  
 * @Title:  Plan.java   
 * @Package co.edu.usbcali.viajesusb.domain   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:12:58 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Plan   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:12:58 a. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name = "plan")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_plan")
	public Long idPlan;
	
	@Column(name = "codigo", length = 5, nullable = false, unique = true)
	public String codigo;
	
	@Column(name = "descripcion_solicitud",nullable = false,  length = 300)
	public String descripcionSolicitud;
	
	@Column(name = "nombre", nullable = false, length = 100)
	public String nombre;
	
	@Column(name = "cantidad_personas", nullable = false)
	public Long cantidadPersonas;
	
	@Column(name = "fecha_solicitud", nullable = false)
	public Date fechaSolicitud;
	
	@Column(name = "fecha_inicio_viaje", nullable = true)
	public Date fechaInicioViaje;
	
	@Column(name = "fecha_fin_vaje", nullable = true)
	public Date fechaFinViaje;
	
	@Column(name = "valor_total", nullable = false)
	public Long valorTotal;
	
	@Column(name = "fecha_creacion", nullable = false)
	public Date fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	public Date fechaModificacion;
	
	@Column(name = "usu_creador", nullable = false, length = 10)
	public String usuCreador;
	
	@Column(name = "usu_modificador", nullable = true, length = 10)
	public String usuModificador;
	
	@Column(name = "estado", nullable = false, length = 1)
	public String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_clie", nullable = false)
	public Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usua", nullable = false)
	public Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
	public List<DetallePlan> detallePlan = new ArrayList<>();
	

}
