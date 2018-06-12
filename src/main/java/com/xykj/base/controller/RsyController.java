package com.xykj.base.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class RsyController <T> implements ApplicationContextAware{
	public static ApplicationContext applicationContext;

    public RsyController() {
    }

    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        applicationContext = arg0;
    }
}
