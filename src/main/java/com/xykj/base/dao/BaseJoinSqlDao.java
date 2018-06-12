package com.xykj.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface BaseJoinSqlDao {
	public List<Map<String , Object>> findByJoinSql(String value);
}
