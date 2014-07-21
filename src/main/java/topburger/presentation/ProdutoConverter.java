package topburger.presentation;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import topburger.entitys.Produto;
import topburger.entitys.TipoFuncionario;


@FacesConverter(value = "ProdutoConverter")
public class ProdutoConverter implements Converter {
	
   @Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	   
	   if (value != null){
		   Produto prod = new Produto();
		   String[] produto = value.split("-");
		   prod.setDescricao(produto[0]);
		   prod.setCodigo(Integer.valueOf(produto[1]));
		   return prod;
	   }
	   
				return value;
		
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if(value instanceof Produto){
			return ((Produto)value).toString();
		}
		return null;
		
	}

}
