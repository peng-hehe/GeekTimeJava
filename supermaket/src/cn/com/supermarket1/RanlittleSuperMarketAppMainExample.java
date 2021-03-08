package cn.com.supermarket1;

import java.util.Scanner;

public class RanlittleSuperMarketAppMainExample {

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
            m.purchasePrice =Math.random() * 200;//进价：0~200之间
            m.soldPrice = (1+Math.random()) * 200;//售价
            all[i]=m;
        }

        System.out.println("利润最高的商品是：");
        littleSuperMarket.getBiggesProfitMerchandise().describe();
        System.out.println("超市开门了");
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("今日商品大降价，全品商品第二件半价了，请输入要购买的商品索引");
            int index = scanner.nextInt();
            if (index <0) {
                break;
            }
            if (index >= all.length){
                System.out.println("商品索引超出界限");
                continue;
            }

            Merchandise m = all[index];
            System.out.println("商品：" + m.name + "。售价：" + m.soldPrice +"请问购买几个？");

            int numTobuy = scanner.nextInt();

            if (numTobuy > m.count){
                System.out.println("库存不足");
                continue;
            }

            int fullPriceCount = numTobuy / 2 + numTobuy % 2;
            int halfPriceCount = numTobuy - fullPriceCount;

            double totalCost =fullPriceCount * m.soldPrice + (halfPriceCount * m.soldPrice/2);

            m.count -= numTobuy;

            System.out.println("商品总价为：" + totalCost);



        }

    }
}
