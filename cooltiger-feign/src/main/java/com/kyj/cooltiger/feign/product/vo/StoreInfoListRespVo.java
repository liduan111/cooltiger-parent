package com.kyj.cooltiger.feign.product.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author liduan
 * Description: 店铺列表信息返回vo
 * date: 2020/8/7 15:16
 */
public class StoreInfoListRespVo {

    //店铺ID
    @JsonProperty("store_id")
    private Integer storeId;
    //店铺code
    @JsonProperty("store_code")
    private String storeCode;
    //店铺名称
    @JsonProperty("store_name")
    private String storeName;
    //店铺logoUrl
    @JsonProperty("store_logo_url")
    private String storeLogoUrl;
    //联系人
    @JsonProperty("relation_name")
    private String relationName;
    //联系电话
    @JsonProperty("relation_tel")
    private String relationTel;
    //店铺地址
    @JsonProperty("store_address")
    private String storeAddress;
    //销售类目
    @JsonProperty("sale_category")
    private String saleCategory;
    //主营产品
    @JsonProperty("main_products")
    private String mainProducts;
    //申请人ID
    @JsonProperty("apply_user_id")
    private Integer applyUserId;
    //银行卡号
    @JsonProperty("bank_card_number")
    private String bankCardNumber;
    //开户行
    @JsonProperty("bank_of_deposit")
    private String bankOfDeposit;
    //账户名
    @JsonProperty("account_name")
    private String accountName;
    //审核状态（0-未审核1-审核通过2-审核未通过）
    @JsonProperty("audit_status")
    private Integer auditStatus;
    //是否签约（0-未签约1-已签约）
    @JsonProperty("sign_status")
    private Integer signStatus;
    //合约起始时间
    @JsonProperty("sign_time_start")
    private Date signTimeStart;
    //合约结束时间
    @JsonProperty("sign_time_end")
    private Date signTimeEnd;
    //创建时间
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    //修改时间
    @JsonProperty("modified_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp modifiedTime;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreLogoUrl() {
        return storeLogoUrl;
    }

    public void setStoreLogoUrl(String storeLogoUrl) {
        this.storeLogoUrl = storeLogoUrl;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getRelationTel() {
        return relationTel;
    }

    public void setRelationTel(String relationTel) {
        this.relationTel = relationTel;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getSaleCategory() {
        return saleCategory;
    }

    public void setSaleCategory(String saleCategory) {
        this.saleCategory = saleCategory;
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts;
    }

    public Integer getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Integer applyUserId) {
        this.applyUserId = applyUserId;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(Integer signStatus) {
        this.signStatus = signStatus;
    }

    public Date getSignTimeStart() {
        return signTimeStart;
    }

    public void setSignTimeStart(Date signTimeStart) {
        this.signTimeStart = signTimeStart;
    }

    public Date getSignTimeEnd() {
        return signTimeEnd;
    }

    public void setSignTimeEnd(Date signTimeEnd) {
        this.signTimeEnd = signTimeEnd;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
