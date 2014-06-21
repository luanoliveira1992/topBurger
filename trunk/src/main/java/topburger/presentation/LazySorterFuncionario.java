package topburger.presentation;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import topburger.entitys.Funcionario;

public class LazySorterFuncionario implements Comparator<Funcionario> {
	 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public LazySorterFuncionario(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
 
    public int compare(Funcionario fun1, Funcionario fun2) {
        try {
            Object value1 = Funcionario.class.getField(this.sortField).get(fun1);
            Object value2 = Funcionario.class.getField(this.sortField).get(fun2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}
