package m2i.formation.dao;

import java.util.List;

public interface IDAO <T, PK> {
	List<T> findAll();
	T findById(PK id);
	public void create(T t);
	public void update(T t);
	public void delete(PK t);
}