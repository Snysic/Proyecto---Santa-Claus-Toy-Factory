package newyearproject.db;

import java.util.List;

public interface IDatabase<E> {

    void save(E entity); 

    List<E> getToys(); 
}