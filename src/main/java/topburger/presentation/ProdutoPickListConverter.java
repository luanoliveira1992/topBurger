package topburger.presentation;



import javax.faces.convert.FacesConverter;

import topburger.entitys.Produto;

@FacesConverter(value = "ProdutoPickListConverter")
public class ProdutoPickListConverter{

    
    protected Produto checkEntity(String id, Produto entity) {
        if (id.equals(String.valueOf(entity.getCodigo()))) {
            return entity;
        }
        return null;
    }

    
    protected String getString(Produto arg) {
        return String.valueOf(arg.getCodigo());
    }
}
