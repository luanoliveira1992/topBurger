package topburger.presentation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import topburger.business.ITipoFuncionarioControler;
import topburger.entitys.TipoFuncionario;
import topburger.infraestrutura.Filtro;


@FacesConverter(value = "TelefoneConverter")
public class TelefoneConverter implements Converter {
	
   @Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	   
	   String numero = null; 
       if (value!= null && !value.equals("")){
    	   numero = value.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\-", "");
       }
      String string = numero.trim();  
       while (string.contains(" ")) {  
           string = string.replaceAll(" ", "");  
       }  
        
     return  Long.valueOf(string);
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		
				return String.valueOf(value);
		
		
	}

}
