package lanqiao.model;


//import com.taru.wxhsh.util.DateUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Product {
    private String productId;

    private String productCode;

    private String productName;

    private String productStandard;

    private String productSmallUnit;

    private BigDecimal productSmallPrice;

    private String productLargerUnit;

    private BigDecimal productLargerPrice;

    private String productCategoryId;

    private String productBrandId;

    private String productPhoto;

    private Byte productIsSale;

    private Byte productIsLack;

    private Byte productStatus;

    private Integer productOrder;

    private String productDateTime;

    private String  productLargerStandard;
    private    BigDecimal     productSuggestPrice;

    private  Category  category;

    public String getProductLargerStandard() {
        return productLargerStandard;
    }

    public void setProductLargerStandard(String productLargerStandard) {
        this.productLargerStandard = productLargerStandard;
    }

    public BigDecimal getProductSuggestPrice() {
        return productSuggestPrice;
    }

    public void setProductSuggestPrice(BigDecimal productSuggestPrice) {
        this.productSuggestPrice = productSuggestPrice;
    }

    public String getProductDateTime() {
		return productDateTime;
	}

	public void setProductDateTime(String productDateTime) {
		this.productDateTime = productDateTime;
	}

	//鍔ㄦ��
    public List<HashMap> getOtherDatas() {
        return otherDatas;
    }

    public void setOtherDatas(List<HashMap> otherDatas) {
        this.otherDatas = otherDatas;
    }

    private  List<HashMap> otherDatas;


    public List<OtherData> getParams() {
        return params;
    }

    public void setParams(List<OtherData> params) {
        this.params = params;
    }

    private List<OtherData>  params;




    public void setCategory(Category category){
        this.category=category;
    }

    public Category  getCategory(){
        return this.category;
    }



    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductStandard() {
        return productStandard;
    }

    public void setProductStandard(String productStandard) {
        this.productStandard = productStandard == null ? null : productStandard.trim();
    }

    public String getProductSmallUnit() {
        return productSmallUnit;
    }

    public void setProductSmallUnit(String productSmallUnit) {
        this.productSmallUnit = productSmallUnit == null ? null : productSmallUnit.trim();
    }

    public BigDecimal getProductSmallPrice() {
        return productSmallPrice;
    }

    public void setProductSmallPrice(BigDecimal productSmallPrice) {
        this.productSmallPrice = productSmallPrice;
    }

    public String getProductLargerUnit() {
        return productLargerUnit;
    }

    public void setProductLargerUnit(String productLargerUnit) {
        this.productLargerUnit = productLargerUnit == null ? null : productLargerUnit.trim();
    }

    public BigDecimal getProductLargerPrice() {
        return productLargerPrice;
    }

    public void setProductLargerPrice(BigDecimal productLargerPrice) {
        this.productLargerPrice = productLargerPrice;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId == null ? null : productCategoryId.trim();
    }

    public String getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(String productBrandId) {
        this.productBrandId = productBrandId == null ? null : productBrandId.trim();
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto == null ? null : productPhoto.trim();
    }

    public Byte getProductIsSale() {
        return productIsSale;
    }

    public void setProductIsSale(Byte productIsSale) {
        this.productIsSale = productIsSale;
    }

    public Byte getProductIsLack() {
        return productIsLack;
    }

    public void setProductIsLack(Byte productIsLack) {
        this.productIsLack = productIsLack;
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Integer productOrder) {
        this.productOrder = productOrder;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productStandard='" + productStandard + '\'' +
                ", productSmallUnit='" + productSmallUnit + '\'' +
                ", productSmallPrice=" + productSmallPrice +
                ", productLargerUnit='" + productLargerUnit + '\'' +
                ", productLargerPrice=" + productLargerPrice +
                ", productCategoryId='" + productCategoryId + '\'' +
                ", productBrandId='" + productBrandId + '\'' +
                ", productPhoto='" + productPhoto + '\'' +
                ", productIsSale=" + productIsSale +
                ", productIsLack=" + productIsLack +
                ", productStatus=" + productStatus +
                ", productOrder=" + productOrder +
                ", productDateTime='" + productDateTime + '\'' +
                ", productLargerStandard='" + productLargerStandard + '\'' +
                ", productSuggestPrice=" + productSuggestPrice +
                ", category=" + category +
                ", otherDatas=" + otherDatas +
                ", params=" + params +
                '}';
    }
}