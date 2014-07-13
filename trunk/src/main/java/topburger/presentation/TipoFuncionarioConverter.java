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


@FacesConverter(value = "TipoFuncionarioConverter")
public class TipoFuncionarioConverter implements Converter {
	
   @Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	   
	   if (value != null){
		   TipoFuncionario tipo = new TipoFuncionario();
		   String[] tipoFuncionario = value.split("-");
		   tipo.setDescricao(tipoFuncionario[0]);
		   tipo.setCodigo(Integer.valueOf(tipoFuncionario[1]));
		   return tipo;
	   }
	   
				return value;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value instanceof TipoFuncionario){
			return ((TipoFuncionario)value).toString();
		}
		return null;
		
	}

}
