package com.zsx.crawler.pojo;

public class CompanyInfo {

    private Long id;
    private String companyName;//公司名称
    private String legalPerson;//法人
    private String registeredFund;//注册资本
    private String registeredTime;//注册时间
    private String phone;//电话
    private String email;//邮箱
    private String address;//注册地址
    private String qita;//其他

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getRegisteredFund() {
        return registeredFund;
    }

    public void setRegisteredFund(String registeredFund) {
        this.registeredFund = registeredFund;
    }

    public String getRegisteredTime() {
        return registeredTime;
    }

    public void setRegisteredTime(String registeredTime) {
        this.registeredTime = registeredTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQita() {
        return qita;
    }

    public void setQita(String qita) {
        this.qita = qita;
    }

    public CompanyInfo(){
        super();
    }

    public CompanyInfo(String companyName, String legalPerson, String registeredFund, String registeredTime, String phone, String email, String address, String qita) {
        this.companyName = companyName;
        this.legalPerson = legalPerson;
        this.registeredFund = registeredFund;
        this.registeredTime = registeredTime;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.qita = qita;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", registeredFund='" + registeredFund + '\'' +
                ", registeredTime='" + registeredTime + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", qita='" + qita + '\'' +
                '}';
    }
}
