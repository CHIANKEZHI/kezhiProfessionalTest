package com.service.testhelloworld.entity;

import java.io.Serializable;

public class UserInfoBean implements Serializable
{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3540816566904625684L;
	
	// 会员编码
    private String               fCusCode;
    
    // 会员名称
    private String               fCusName;
    
    // 手机号码
    private String               fPhone;

	public String getfCusCode() {
		return fCusCode;
	}

	public void setfCusCode(String fCusCode) {
		this.fCusCode = fCusCode;
	}

	public String getfCusName() {
		return fCusName;
	}

	public void setfCusName(String fCusName) {
		this.fCusName = fCusName;
	}

	public String getfPhone() {
		return fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}
}
