package com.kyj.cooltiger.feign.product.vo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author liduan
 * Description: 商户申请入驻参数vo
 * date: 2020/8/5 16:11
 */
public class StoreApplyIntoReqVo {

    //店铺名称
    @JsonProperty("store_name")
    private String storeName;
    //店铺logoUrl
    @JsonProperty("logo_url")
    private String logoUrl;
    //联系人
    @JsonProperty("relation_name")
    private String relationName;
    //联系电话
    @JsonProperty("relation_tel")
    private String relationTel;
    //店铺地址
    @JsonProperty("store_address")
    private String storeAddress;
    //身份证正面url
    @JsonProperty("id_card_main_url")
    private String idCardMainUrl;
    //身份证反面url
    @JsonProperty("id_card_back_url")
    private String idCardBackUrl;
    //销售类目
    @JsonProperty("sale_category")
    private String saleCategory;
    //主营产品
    @JsonProperty("main_products")
    private String mainProducts;
    //银行卡号
    @JsonProperty("bank_card_number")
    private String bankCardNumber;
    //开户行
    @JsonProperty("bank_of_deposit")
    private String bankOfDeposit;
    //账户名
    @JsonProperty("account_name")
    private String accountName;
    //经营资质图片url
    @JsonProperty("license_urls")
    private List<String> licenseUrls;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public String getIdCardMainUrl() {
        return idCardMainUrl;
    }

    public void setIdCardMainUrl(String idCardMainUrl) {
        this.idCardMainUrl = idCardMainUrl;
    }

    public String getIdCardBackUrl() {
        return idCardBackUrl;
    }

    public void setIdCardBackUrl(String idCardBackUrl) {
        this.idCardBackUrl = idCardBackUrl;
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

    public List<String> getLicenseUrls() {
        return licenseUrls;
    }

    public void setLicenseUrls(List<String> licenseUrls) {
        this.licenseUrls = licenseUrls;
    }
}
