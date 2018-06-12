package com.xykj.base.interceptor.mybatis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.PropertyException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import com.github.pagehelper.parser.impl.SqlServerParser;
import com.xykj.base.util.Page;
import com.xykj.base.util.ReflectUtil;

@Intercepts({@Signature(
    method = "prepare",
    type = StatementHandler.class,
    args = {Connection.class}
)})
public class PageInterceptor implements Interceptor {
    private static String databaseType = "";

    public PageInterceptor() {
    }

    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler handler = (RoutingStatementHandler)invocation.getTarget();
        StatementHandler delegate = (StatementHandler)ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        Object params = boundSql.getParameterObject();
        Page page = null;
        if (params instanceof Page) {
            page = (Page)params;
        } else if (params instanceof ParamMap) {
            ParamMap paramMap = (ParamMap)params;
            Iterator var8 = paramMap.keySet().iterator();

            while(var8.hasNext()) {
                Object key = var8.next();
                if (paramMap.get(key) instanceof Page) {
                    page = (Page)paramMap.get(key);
                    break;
                }
            }
        }

        if (page != null) {
            MappedStatement mappedStatement = (MappedStatement)ReflectUtil.getFieldValue(delegate, "mappedStatement");
            Connection connection = (Connection)invocation.getArgs()[0];
            String sql = boundSql.getSql();
            this.setTotalRecord(page, (ParamMap)params, mappedStatement, connection);
            String pageSql = this.getPageSql(page, sql);
            ReflectUtil.setFieldValue(boundSql, "sql", pageSql);
        }

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties p) {
        databaseType = p.getProperty("databaseType");
        if (StringUtils.isEmpty(databaseType)) {
            try {
                throw new PropertyException("databaseType is not found!");
            } catch (PropertyException var3) {
                var3.printStackTrace();
            }
        }

    }

    private String getPageSql(Page<?> page, String sql) {
        StringBuffer sqlBuffer = new StringBuffer(sql);
        if ("mysql".equalsIgnoreCase(databaseType)) {
            return this.getMysqlPageSql(page, sqlBuffer);
        } else if ("oracle".equalsIgnoreCase(databaseType)) {
            return this.getOraclePageSql(page, sqlBuffer);
        } else {
            return sqlBuffer.toString();
        }
    }


    private String getMysqlPageSql(Page<?> page, StringBuffer sqlBuffer) {
        int offset = (page.getPageNum() - 1) * page.getPageSize();
        sqlBuffer.append(" limit ").append(offset).append(",").append(page.getPageSize());
        return sqlBuffer.toString();
    }

    private String getOraclePageSql(Page<?> page, StringBuffer sqlBuffer) {
        int offset = (page.getPageNum() - 1) * page.getPageSize() + 1;
        sqlBuffer.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(offset + page.getPageSize());
        sqlBuffer.insert(0, "select * from (").append(") where r >= ").append(offset);
        return sqlBuffer.toString();
    }

    private void setTotalRecord(Page<?> page, ParamMap params, MappedStatement mappedStatement, Connection connection) {
        BoundSql boundSql = mappedStatement.getBoundSql(params);
        String sql = boundSql.getSql();
        String countSql = this.getCountSql(sql);
        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), countSql, parameterMappings, params);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, params, countBoundSql);
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(countSql);
            parameterHandler.setParameters(pstmt);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int totalRecord = rs.getInt(1);
                page.setTotalRecord(totalRecord);
            }
        } catch (SQLException var22) {
            var22.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException var21) {
                var21.printStackTrace();
            }

        }
    }
    private String getCountSql(String sql) {
        return "SELECT COUNT(*) FROM (" + sql + ") AS countRecord";
    }
}
