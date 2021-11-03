package bakery.repositories.interfaces;

import java.util.Collection;
import java.util.Collections;

public interface Repository<T> {

    Collection<T> getAll();

    void add(T model);

}
