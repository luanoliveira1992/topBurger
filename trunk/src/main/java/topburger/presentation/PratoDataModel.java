package topburger.presentation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import topburger.entitys.Funcionario;
import topburger.entitys.Prato;

public class PratoDataModel extends LazyDataModel<Prato> {
	
	/**
	 * 
	 */
private static final long serialVersionUID = 3500672166633274026L;
private List<Prato> datasource;
    
@Override
	public List<Prato> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, String> filters) {
	List<Prato> data = new ArrayList<Prato>();

    //filter
    for(Prato fun : datasource) {
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
        Collections.sort(data, new LazySorterPrato(sortField, sortOrder));
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


    
   public PratoDataModel(List<Prato> datasource) {
       this.datasource = datasource;
   }
    
   @Override
   public Prato getRowData(String rowKey) {
       for(Prato prat : datasource) {
           if(prat.getCodigo().equals(rowKey))
               return prat;
       }

       return null;
   }

   @Override
   public Object getRowKey(Prato fun) {
       return fun.getCodigo();
   }

   

}
