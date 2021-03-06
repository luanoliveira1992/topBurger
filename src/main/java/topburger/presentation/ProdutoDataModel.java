package topburger.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import topburger.entitys.Funcionario;
import topburger.entitys.Produto;

public class ProdutoDataModel extends LazyDataModel<Produto> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3500672166633274026L;
private List<Produto> datasource;
    
@Override
	public List<Produto> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
	List<Produto> data = new ArrayList<Produto>();

    //filter
    for(Produto fun : datasource) {
        boolean match = true;

        if (filters != null) {
            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                try {
                    String filterProperty = it.next();
                    Object filterValue = filters.get(filterProperty);
                    String fieldValue = String.valueOf(fun.getClass().getField(filterProperty).get(fun));

                    if(filterValue == null || fieldValue.startsWith(filterValue.toString())) {
                        match = true;
                }
                else {
                        match = false;
                        break;
                    }
                } catch(Exception e) {
                    match = false;
                }
            }
        }

        if(match) {
            data.add(fun);
        }
    }

    //sort
    if(sortField != null) {
        Collections.sort(data, new LazySorterProduto(sortField, sortOrder));
    }

    //rowCount
    int dataSize = data.size();
    this.setRowCount(dataSize);

    //paginate
    if(dataSize > pageSize) {
        try {
            return data.subList(first, first + pageSize);
        }
        catch(IndexOutOfBoundsException e) {
            return data.subList(first, first + (dataSize % pageSize));
        }
    }
    else {
        return data;
    }
	}


    
   public ProdutoDataModel(List<Produto> datasource) {
       this.datasource = datasource;
   }
    
   @Override
   public Produto getRowData(String rowKey) {
       for(Produto fun : datasource) {
           if(fun.getCodigo().equals(rowKey))
               return fun;
       }

       return null;
   }

   @Override
   public Object getRowKey(Produto fun) {
       return fun.getCodigo();
   }

   

}
