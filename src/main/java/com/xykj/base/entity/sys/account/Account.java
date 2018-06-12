package com.xykj.base.entity.sys.account;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.xykj.base.entity.BaseEntity;
@Alias("Account")
@JsonIgnoreProperties(
    ignoreUnknown = true
)
public class Account extends BaseEntity{
	
	private String accountId;		//账户id
    private String accountName;		//账户名称
    private String password;		//密码
    private String nickName;		//昵称
    private String realName;		//真实姓名
    private String headPicture;		//头像地址
    private String emailAddress;	//邮箱地址
    private String emailPassword;	//邮箱密码
    @DateTimeFormat(
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date createTime;		//创建时间点
    private String createBy;		//创建者
    @DateTimeFormat(
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
    private Date updateTime;		//修改时间点
    private String updateBy;		//修改者	
    private int status;				//状态 0 : 禁用  1 : 正常
    private String description;		//账户描述
    
	public Account() {
		super();
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadPicture() {
		return headPicture;
	}
	public void setHeadPicture(String headPicture) {
		this.headPicture = headPicture;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getEmailPassword() {
		return emailPassword;
	}
	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}
	@DateTimeFormat(
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	@DateTimeFormat(
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "GMT+8"
    )
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", password=" + password
				+ ", nickName=" + nickName + ", realName=" + realName + ", headPicture=" + headPicture
				+ ", emailAddress=" + emailAddress + ", emailPassword=" + emailPassword + ", createTime=" + createTime
				+ ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy=" + updateBy + ", status="
				+ status + ", description=" + description + "]";
	}
	
}