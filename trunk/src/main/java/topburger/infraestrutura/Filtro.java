package topburger.infraestrutura;

import java.util.HashMap;
import java.util.Map;

public class Filtro {
	  Map<String,Object> valores = new HashMap<String,Object>();
	  
	  public Map<String, Object> getValores() {
		return valores;
	}
	  public void setValores(Map<String, Object> valores) {
		this.valores = valores;
	}

}
