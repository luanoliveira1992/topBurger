package topburger.presentation;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import topburger.entitys.Prato;
import topburger.entitys.Produto;

public class LazySorterProduto implements Comparator<Produto> {
	 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorterProduto(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Produto prat1, Produto prat2) {
        try {
            Object value1 = Prato.class.getField(this.sortField).get(prat1);
            Object value2 = Prato.class.getField(this.sortField).get(prat2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
