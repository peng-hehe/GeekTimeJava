package cn.com.supermarket1;

public class Merchandise {
    public String name;//商品名称
    public String id;//商品id
    public int count;//商品数据
    public double soldPrice;//商品售价
    public double purchasePrice;//采购价格
    String madeIn;


    //>> TODO 访问修饰符
    //>> TODO 返回值类型：无需返回值则用void表示，void是Java中的关键字
    //>> TODO 方法名：任意合法的标识符都可以
    //>> TODO 参数列表
    //>> TODO 方法体：方法的代码
    //>> TODO 局部变量：方法体内部的变量

    public void describe(){
        System.out.println("商品的名字：" + name + ",id是：" + id + "。商品的售价是：" + soldPrice + "。商品的进价是：" + purchasePrice +
                "。商品的库存量是：" + count + "。商品销售的毛利润是：" + (soldPrice-purchasePrice) + "。制造地为：" + madeIn);
    }

    //>> TODO 在方法定义中指定方法的返回值类型
    //>> TODO java中一个方法只能有一种返回值。如果不需要返回值则用void表示
    //>> TODO 如果定义了返回值，则必须使用return 语句返回方法的返回值，return 是 java 的关键字
    //>> TODO 可以认为，返回值必须要嫩够用来给返回值类型的变量赋值

    public double calculateProfit(){
        double profit = soldPrice -purchasePrice;

        //>> TODO 这里的return 是if代码块里的return，是return所在代码块的最后一个语句
        if (profit <= 0){
            return 0;
        }
        return profit;    //>> TODO return 语句必须是所有代码块的最后一个语句，否则就是语法错误
    //>> TODO return 一个方法可以有多个返回语句
    }

    //>> TODO 返回值如果是基本类型，则要类型完全相同，或者符合类型自动转换规则
    public double getCurrentCount(){
        return count;
    }

    //>> TODO 如果不符合规则可以使用强制类型转换
    public int getIntSoldPrice(){
        return (int) soldPrice;
    }





}
