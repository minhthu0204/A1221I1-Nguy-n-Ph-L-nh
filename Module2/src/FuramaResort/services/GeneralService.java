package FuramaResort.services;

import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();

    void add(T t);

    void edit(T t);
}
