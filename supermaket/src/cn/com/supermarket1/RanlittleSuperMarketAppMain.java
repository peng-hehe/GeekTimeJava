package cn.com.supermarket1;

import java.util.Scanner;

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
            m.purchasePrice =Math.random() * 200;//进价：0~200之间
            m.soldPrice = (1+Math.random()) * 200;//售价
            all[i]=m;
        }

        System.out.println("利润最高的商品");
        littleSuperMarket.getBiggesProfitMerchandise().describe();
        System.out.println("超市开门了");
        Scanner scanner = new Scanner(System.in);
        boolean open = true;
        while (open){
            //打印超市信息
            System.out.println("本店叫做"+littleSuperMarket.superMarketName);
            System.out.println("本店地址"+littleSuperMarket.address);
            System.out.println("共有车位"+littleSuperMarket.parkingCount + "个");
            System.out.println("今天营业额"+littleSuperMarket.incomingSum);
            System.out.println("共有商品"+littleSuperMarket.merchandises.length);

            //顾客
            Customer customer =new Customer();
            customer.name="顾客编号"+((int)Math.random() * 10000);//强制转换数据类型
            customer.money = (1 +  Math.random()) * 1000;//赋值金额
            customer.isDrivingCar = Math.random() > 0.5;//是否开车

            //判断是否开车
            if (customer.isDrivingCar) {
                if (littleSuperMarket.parkingCount > 0){
                    System.out.println("欢迎" + customer.name +"驾车而来，本店已为您安排了免费停车位");
                    littleSuperMarket.parkingCount--;
                }else{
                    System.out.println("非常抱歉，本店停车位已满，欢迎下次光临");
                    continue;
                }
            }else{
                System.out.println("欢迎" + customer.name +"光临本店");
            }

            double totalCost =0;//本次购物共花费多少钱

            //开始购买
            while(true){
                System.out.println("本店提供" + all.length + "种商品，欢迎选购，请输入商品编码");
                int index = scanner.nextInt();

                //判断输入商品编码。输入商品索引为0，表示用户不想购买，退出
                if (index < 0){
                    break;
                }
                if(index >= 200){
                    System.out.println("非常抱歉，本店没有该商品，请输入商品编码为0~" + (all.length-1) + "的商品编码");
                    continue;
                }

                //购买商品索引
                Merchandise m =all[index];
                System.out.println("您选购的编号为"+ index + "的商品名称为" + m.name + "，售价为" + m.soldPrice +"请问您需要购买多少？");

                //购买数量和总计消费金额
                int numToBuy = scanner.nextInt();
                if (numToBuy <= 0){
                    System.out.println("不买看看也好，欢迎继续挑选");
                    continue;
                }
                if (numToBuy > m.count ){
                    System.out.println("本店此商品库存不足，欢迎继续选购");
                    continue;
                }
                if (m.soldPrice * numToBuy + totalCost > customer.money){
                    System.out.println("抱歉，您带的钱不够，欢迎选购");
                    continue;
                }


                totalCost += numToBuy * m.soldPrice;
                //商品剩余数量
                m.count-=numToBuy;
                //商品总计卖出数量
                littleSuperMarket.merchandiseSole[index] += numToBuy;

            }

            customer.money -= totalCost;
            //购买完顾客离开，判断是否开车，车位数量增加
            if(customer.isDrivingCar){
                littleSuperMarket.parkingCount++;
            }

            System.out.println("顾客" + customer.name + "共计消费了" + totalCost);

            //本店收入总和
            littleSuperMarket.incomingSum += totalCost;

            //是否继续营业true，false
            System.out.println("还是否继续营业？true继续营业，false停止营业");
            open = scanner.nextBoolean();

        }

        System.out.println("超市停止业了");

        System.out.println("今天的营业额为" + littleSuperMarket.incomingSum +"营业状况如下");

        for (int i = 0; i < littleSuperMarket.merchandiseSole.length ; i++) {
            Merchandise m =all[i];
            int numsold = littleSuperMarket.merchandiseSole[i];

            if (numsold > 0){
                double incomming = m.soldPrice * numsold; //销售额
                double netIncomming = (m.soldPrice - m.purchasePrice) * numsold; //净利润
                System.out.println("商品" + m.name + "售出了" + numsold +"份,销售额为" + incomming + "净利润为" + netIncomming);
            }
        }

        



    }
}
