package pat_nick.dao;

import java.util.List;

public interface GenericDao <T> {
    List<T> getList();
    T getById(int id);
    T getByUsername(String username);
    List<T> getByUserId(int id);
    void insert(T t);
    void delete(T t);
}
