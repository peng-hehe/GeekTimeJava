package cn.com.supermarket1;

public class  RanlittleSuperMarketAppMain {
    public static void main(String[] args) {
        LittleSuperMarket littleSuperMarket =new LittleSuperMarket();
        littleSuperMarket.address="世纪大道888号";
        littleSuperMarket.superMarketName="朕的江山";
        littleSuperMarket.parkingCount=200;
        littleSuperMarket.merchandises = new Merchandise[200];
        littleSuperMarket.merchandiseSole =new int[littleSuperMarket.merchandises.length];

        Merchandise[] all =littleSuperMarket.merchandises;
        for (int i = 0; i < all.length; i++) {
            Merchandise m =new Merchandise();
            m.count = 200;
            m.id="ID"+i;
            m.name="商品"+i;
            m.purchasePrice =Math.random() * 200;
            m.soldPrice = (1+Math.random()) * 200;
            all[i]=m;
        }
        System.out.println("超市开门了");

        boolean open = true;
        while (open){
            System.out.println("本店叫做"+littleSuperMarket.superMarketName);
            System.out.println("本店地址"+littleSuperMarket.address);
            System.out.println("共有车位"+littleSuperMarket.parkingCount + "个");
            System.out.println("今天营业额"+littleSuperMarket.incomingSum);
            System.out.println("共有商品"+littleSuperMarket.merchandises.length);

            Customer customer =new Customer();
            customer.name="顾客编号" +
        }
    }
}
