package topburger.presentation;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import topburger.entitys.Funcionario;
import topburger.entitys.Prato;

public class LazySorterPrato implements Comparator<Prato> {
	 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorterPrato(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Prato prat1, Prato prat2) {
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
