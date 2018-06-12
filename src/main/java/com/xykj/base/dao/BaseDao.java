package com.xykj.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xykj.base.util.Page;

public interface BaseDao<T> {
	void insert(T var1);

	void delete(T var1);

	void update(T var1);

	void deleteBatch(List<T> var1);

	T find(T var1);

	List<T> findByPage(@Param("param") T var1, Page<T> var2);
}
