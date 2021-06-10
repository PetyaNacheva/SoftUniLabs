import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericBox <T extends Comparable<T>>{
        private List<T>values;

    public GenericBox(){
        this.values=new ArrayList<>();
    }
    public void add(T element){
        this.values.add(element);
    }
    public void remove(int index){
        this.values.remove(index);
    }
    public boolean contains (T element){
        if(this.values.contains(element)){
        return true;}
        else return false;
    }
    public void swap(int firstIndex, int secondIndex){
        Collections.swap(this.values,firstIndex,secondIndex);
    }

    public int countGraterThan(T element){
       int count =(int) this.values.stream().filter(e->e.compareTo(element)>0).count();

        return count;
    }
    public T getMax(){
        T first = this.values.get(0);
        T element =(T)this.values.stream().filter(e->e.compareTo(first)>0);
        return element;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : values) {
            sb.append(String.format("%s: %s",value.getClass().getName(),value));
           sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
