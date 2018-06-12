package com.xykj.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xykj.base.dao.BaseDao;
import com.xykj.base.util.Page;

public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
    protected BaseDao<T> baseDao;

    public BaseServiceImpl() {
    	
    }

    public void insert(T o) {
        this.baseDao.insert(o);
    }

    public void delete(T o) {
        this.baseDao.delete(o);
    }

    public void deleteBatch(List<T> os) {
        this.baseDao.deleteBatch(os);
    }

    public void update(T o) {
        this.baseDao.update(o);
    }

    public T find(T o) {
        return this.baseDao.find(o);
    }

    public Page<T> findByPage(Page<T> page,T o) {
    	List<T> list = this.baseDao.findByPage(o, page);
    	page.setResults(list);
        return page;
    }

}
