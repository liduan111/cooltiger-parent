package com.kyj.cooltiger.cooltigerfeign.product.vo;

import java.util.List;

/**
 * @author liduan
 * Description: 添加商品vo
 * date: 2020/8/3 10:05
 */
public class ProductInfoAddReqVo {

    //商品标题
    private String title;
    //分类ID
    private String categoryId;
    //商品运费
    private ProductFreight productFreight;
    //发货地ID
    private Integer addressFromId;
    //预计送达时间
    private Integer aboutDeliverTime;
    //服务ID（多个用,分隔）
    private String serviceIds;
    //自定义服务
    private List<String> customService;
    //商品参数
    private List<ProductParam> productParams;
    //上架状态：0下架1上架
    private Integer shelfStatus;


    //商品运费
    public class ProductFreight{
        //运费方式（0-包邮1-固定运费2-满减包邮3-满件包邮4-重量计费）
        private Integer productFreightType;
        //满减包邮|满件包邮条件（满多少元|满多少件）
        private Integer condition;
        //运费（固定运费|不满足满减包邮|不满足满件包邮|重量计费首重）
        private Double preightPrice;
        //重量计费_首重（kg）
        private Double firsWeight;
        //续重（元/kg）
        private Double continueWeight;
        //不足一千克是否按一千克计算（0-否1-是）
        private Integer whetherKg;

        public Integer getProductFreightType() {
            return productFreightType;
        }

        public void setProductFreightType(Integer productFreightType) {
            this.productFreightType = productFreightType;
        }

        public Integer getCondition() {
            return condition;
        }

        public void setCondition(Integer condition) {
            this.condition = condition;
        }

        public Double getPreightPrice() {
            return preightPrice;
        }

        public void setPreightPrice(Double preightPrice) {
            this.preightPrice = preightPrice;
        }

        public Double getFirsWeight() {
            return firsWeight;
        }

        public void setFirsWeight(Double firsWeight) {
            this.firsWeight = firsWeight;
        }

        public Double getContinueWeight() {
            return continueWeight;
        }

        public void setContinueWeight(Double continueWeight) {
            this.continueWeight = continueWeight;
        }

        public Integer getWhetherKg() {
            return whetherKg;
        }

        public void setWhetherKg(Integer whetherKg) {
            this.whetherKg = whetherKg;
        }
    }

    //商品参数
    public class ProductParam{
        //参数名称
        private String paramName;
        //商品参数值
        private String paramValue;

        public String getParamName() {
            return paramName;
        }

        public void setParamName(String paramName) {
            this.paramName = paramName;
        }

        public String getParamValue() {
            return paramValue;
        }

        public void setParamValue(String paramValue) {
            this.paramValue = paramValue;
        }
    }
}
