package com.xykj.base.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.xykj.base.util.Page;
public interface BaseService<T> {
	void insert(T var1);

	void delete(T var1);

	void deleteBatch(List<T> var1);

	void update(T var1);

	T find(T var1);

	Page<T> findByPage(Page<T> page,T var1);
}
