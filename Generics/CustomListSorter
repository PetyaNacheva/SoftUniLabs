package Advanced.Generics.CustomListSorter;

public class Main {
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CustomList<T extends Comparable<T>> {
        private List<T> values;

        public CustomList(){
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
        public T Max(){
            if(this.values.isEmpty()){
                throw new IllegalStateException("Empty list!");
            }
            T max = this.values.get(0);
            for (int i = 0; i <this.values.size() ; i++) {
                T current = this.values.get(i);
                if(current.compareTo(max)>0){
                    max=current;
                }
            }
            return max;
        }
        public T Min(){

            return Collections.min(this.values);
        }
        public void sort(){
            Collections.sort(this.values);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (T value : values) {
                sb.append(String.format("%s%n",value));

            }
            return sb.toString();
        }
    }

