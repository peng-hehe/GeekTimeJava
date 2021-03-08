package cn.com.supermarket1;

public class LittleSuperMarket {
    public String superMarketName;//超市名称
    public String address;//超市地址
    public int parkingCount;//停车位数量
    public double incomingSum;//收入总和
    public Merchandise[] merchandises;//商品集合
    public int[] merchandiseSole;//相同索引下商品卖出数量


    public Merchandise getBiggesProfitMerchandise(){
        Merchandise curr =null;
        for (int i = 0; i < merchandises.length; i++) {
            Merchandise m =merchandises[i];
            if (curr == null){
                curr=m;
                continue;
            }else {
                if (curr.calculateProfit() < m.calculateProfit()){
                    curr = m;
                }
            }


        }
        return curr;

    }

}
