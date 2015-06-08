package inyeccion;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Data;

@Data
public class ExampleCollectionsBean {

	private Properties entorno;
	
	private List<String> nombres;
	
	private Map<String, String> identificacion;
	
	private Set<String> escuderias;
	
	private Set<String> frutas;

}
