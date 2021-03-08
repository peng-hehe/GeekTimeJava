package cn.com.supermarket1;

public class MerchandiseV2DescAppMain {
    public static void main(String[] args) {
        Merchandise merchandise = new Merchandise();

        merchandise.name="书桌";
        merchandise.soldPrice=998;
        merchandise.purchasePrice=388;
        merchandise.count=99;
        merchandise.id="DESK8293";
        merchandise.madeIn="China";

        merchandise.describe();

    }
}
