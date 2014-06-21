package topburger.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import topburger.entitys.Funcionario;

public class FuncionarioDataModel extends LazyDataModel<Funcionario> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3500672166633274026L;
private List<Funcionario> datasource;
    
@Override
	public List<Funcionario> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
	List<Funcionario> data = new ArrayList<Funcionario>();

    //filter
    for(Funcionario fun : datasource) {
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
        Collections.sort(data, new LazySorterFuncionario(sortField, sortOrder));
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


    
   public FuncionarioDataModel(List<Funcionario> datasource) {
       this.datasource = datasource;
   }
    
   @Override
   public Funcionario getRowData(String rowKey) {
       for(Funcionario fun : datasource) {
           if(fun.getCodigo().equals(rowKey))
               return fun;
       }

       return null;
   }

   @Override
   public Object getRowKey(Funcionario fun) {
       return fun.getCodigo();
   }

   

}
