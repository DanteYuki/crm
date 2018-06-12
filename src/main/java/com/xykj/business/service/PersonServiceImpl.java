package com.xykj.business.service;

import org.springframework.stereotype.Service;

import com.xykj.base.service.BaseServiceImpl;
import com.xykj.business.entity.Person;

@Service("PersonService")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService{

}
