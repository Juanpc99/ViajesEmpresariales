package co.edu.usbcali.viajesusb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import lombok.Data;


@NamedNativeQueries({
		@NamedNativeQuery(name="TipoDestino.consultarTipoDestinoPorEstado", query="", resultSetMapping = "consultarTipoDestinoPorEstado")
	})
	@SqlResultSetMappings({
		@SqlResultSetMapping(name="consultarTipoDestinoPorEstado", 
				classes= {@ConstructorResult(targetClass = TipoDestinoDTO.class,
				columns = {
						@ColumnResult(name="idTid", type = Integer.class),
						@ColumnResult(name="codigo", type = String.class),
						@ColumnResult(name="nombre", type = String.class),
						@ColumnResult(name="descripcion", type = String.class)
								
								
				})
				})
	})




@Data
@Entity
@Table(name="tipo_destino")
public class TipoDestino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tide")
	public Long idTide;
	
	@Column(name="codigo" ,unique = true,nullable = false, length = 5)
	public String codigo;
	
	@Column(name="nombre",unique = true, nullable = false, length = 100)
	public String nombre;
	
	@Column(name="descripcion", length = 300, nullable = false)
	public String descripcion;
	
	@Column(name="fecha_creacion", nullable = false)
	public Date fechaCreacion;
	
	@Column(name="fecha_modificacion")
	public Date fechaModificacion;
	
	@Column(name="usu_creador", nullable = false, length = 10)
	public String usuCreador;
	
	@Column(name="usu_modificador")
	public String usuModificador;
	
	@Column(name="estado", nullable = false, length = 1)
	public String estado;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDestino")
	public List<Destino> destino = new ArrayList<>();
	
}
