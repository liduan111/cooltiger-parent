package com.kyj.cooltiger.cooltigerfeign.product.vo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author liduan
 * Description: 店铺信息返回vo
 * date: 2020/8/6 13:07
 */
public class StoreInfoRespVo {

    //店铺ID
    private Integer storeId;
    //店铺code
    private String storeCode;
    //店铺名称
    private String storeName;
    //店铺logoUrl
    private String logoUrl;
    //联系人
    private String relationName;
    //联系电话
    private String relationTel;
    //店铺地址
    private String storeAddress;
    //身份证正面url
    private String idCardMainUrl;
    //身份证反面url
    private String idCardBackUrl;
    //销售类目
    private String saleCategory;
    //主营产品
    private String mainProducts;
    //申请人ID
    private Integer applyUserId;
    //银行卡号
    private String bankCardNumber;
    //开户行
    private String bankOfDeposit;
    //账户名
    private String accountName;
    //审核状态（0-未审核1-已审核）
    private Integer auditStatus;
    //是否签约（0-未签约1-已签约）
    private Integer signStatus;
    //合约起始时间
    private Date signTimeStart;
    //合约结束时间
    private Date signTimeEnd;
    //创建时间
    private Timestamp createTime;
    //修改时间
    private Timestamp modifiedTime;
    //商品图片集合
    private List<Picture> pictures;

    public class Picture{
        //商品图片ID
        private Integer id;
        //图片类型（1-营业资质2-合约内容）
        private Integer pictureType;
        //图片url
        private String url;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getPictureType() {
            return pictureType;
        }

        public void setPictureType(Integer pictureType) {
            this.pictureType = pictureType;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

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

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
