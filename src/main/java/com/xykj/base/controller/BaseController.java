package com.xykj.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.xykj.base.util.PageData;
import com.xykj.base.util.UuidUtil;

public class BaseController<T> extends RsyController<T> {
	public BaseController() {
    }


    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }
    
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    
    public String get32UUID() {
        return UuidUtil.get32UUID();
    }

    public <T> Page<T> getPage() {
        return new Page();
    }
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }
    
    private void setPage(Page<T> page) {
        String rows = this.getRequest().getParameter("rows");
        String startPage = this.getRequest().getParameter("page");
        if(rows != null) {
            page.setPageSize(Integer.valueOf(rows).intValue());
        }

        if(startPage != null) {
            page.setPageNum(Integer.valueOf(startPage).intValue());
        }
    }
}
