package com.xykj.base.entity.sys.config;

import org.apache.ibatis.type.Alias;

import com.xykj.base.entity.BaseEntity;

@Alias("Config")
public class Config extends BaseEntity{
	private String ktype;
	private int kkey;
	private String kvalue;
	public String getKtype() {
		return ktype;
	}
	public void setKtype(String ktype) {
		this.ktype = ktype;
	}
	public int getKkey() {
		return kkey;
	}
	public void setKkey(int kkey) {
		this.kkey = kkey;
	}
	public String getKvalue() {
		return kvalue;
	}
	public void setKvalue(String kvalue) {
		this.kvalue = kvalue;
	}
	
}
