/**  
 * @Title:  DetallePlan.java   
 * @Package co.edu.usbcali.viajesusb.domain   
 * @Description: description   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:13:11 a. m.   
 * @version V1.0 
 * @Copyright: USB
 */

package co.edu.usbcali.viajesusb.domain;

/**   
 * @ClassName:  DetallePlan   
  * @Description: TODO   
 * @author: JuanPabloCaro     
 * @date:   16/10/2021 8:13:11 a. m.      
 * @Copyright:  USB
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "detalle_plan")
public class DetallePlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_depl")
	public Long idDepl;
	
	@Column(name = "alimentacion", length = 1, nullable = false)
	public String alimentacion;
	
	@Column(name = "hospedaje", length = 1, nullable = false)
	public String hospedaje;
	
	@Column(name = "transporte", length = 1, nullable = false)
	public String transporte;
	
	@Column(name = "traslados", length = 1, nullable = false)
	public String traslados;
	
	@Column(name = "valor", nullable = false)
	public Double valor;
	
	@Column(name = "cantidad_noches", nullable = false)
	public Integer catidadNoches;
	
	@Column(name = "cantidad_dias", nullable = false)
	public Integer catidadDias;
	
	@Column(name = "fecha_creacion", nullable = false)
	public Date fechaCreacion;
	
	@Column(name = "fecha_modificacion" , nullable = true)
	public Date fechaModificacion;
	
	@Column(name = "usu_creador", nullable = false)
	public String usuCreador;
	
	@Column(name = "usu_modificador", nullable = true)
	public String usuModificador;
	
	@Column(name = "estado", nullable = false)
	public String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_plan", nullable = false)
	public Plan plan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_dest", nullable = false)
	public Destino destino;

}
