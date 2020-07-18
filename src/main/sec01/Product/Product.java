package main.sec01.Product;

public class Product {

    private String prodId;
    private String vendId;
    private String prodName;
    private String price;
    private String desc;

    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getVendId() {
        return vendId;
    }

    public void setVendId(String vendId) {
        this.vendId = vendId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "{" +
                "prodId='" + prodId + '\'' +
                ", vendId='" + vendId + '\'' +
                ", prodName='" + prodName + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }
}
