package phi.dao.to;

import java.io.Serializable;

import service.EncodingTool;

@SuppressWarnings("serial")
public class Members implements Serializable{
	private String account;
	private String password;
	private String mid;
	private String memberType;
	private String memberRank;
	private String memberName;
	private String memberSex;
	private String memberCid;
	private String auth;
	private String validateCode;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getMemberRank() {
		return memberRank;
	}
	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}
	public String getMemberName() {
		if(memberName != null){
			return EncodingTool.encodeStr(memberName);
		}	
		return null;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberSex() {
		return memberSex;
	}
	public void setMemberSex(String memberSex) {
		this.memberSex = memberSex;
	}
	public String getMemberCid() {
		return memberCid;
	}
	public void setMemberCid(String memberCid) {
		this.memberCid = memberCid;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
