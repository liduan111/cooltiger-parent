package com.kyj.cooltiger.feign.product.vo;

/**
 * @author liduan
 * Description: 店铺信息参数vo
 * date: 2020/8/5 16:11
 */
public class StoreApplyIntoReqVo {

    //店铺名称
    private String store_name;
    //联系人
    private String relation_name;
    //联系电话
    private String relation_tel;
    //店铺地址
    private String store_address;
    //销售类目
    private String sale_category;
    //主营产品
    private String main_products;
    //银行卡号
    private String bank_card_number;
    //开户行
    private String bank_of_deposit;
    //账户名
    private String account_name;

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getRelation_name() {
        return relation_name;
    }

    public void setRelation_name(String relation_name) {
        this.relation_name = relation_name;
    }

    public String getRelation_tel() {
        return relation_tel;
    }

    public void setRelation_tel(String relation_tel) {
        this.relation_tel = relation_tel;
    }

    public String getStore_address() {
        return store_address;
    }

    public void setStore_address(String store_address) {
        this.store_address = store_address;
    }

    public String getSale_category() {
        return sale_category;
    }

    public void setSale_category(String sale_category) {
        this.sale_category = sale_category;
    }

    public String getMain_products() {
        return main_products;
    }

    public void setMain_products(String main_products) {
        this.main_products = main_products;
    }

    public String getBank_card_number() {
        return bank_card_number;
    }

    public void setBank_card_number(String bank_card_number) {
        this.bank_card_number = bank_card_number;
    }

    public String getBank_of_deposit() {
        return bank_of_deposit;
    }

    public void setBank_of_deposit(String bank_of_deposit) {
        this.bank_of_deposit = bank_of_deposit;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }
}
