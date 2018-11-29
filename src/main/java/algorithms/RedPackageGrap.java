package algorithms;

import java.math.BigDecimal;
import java.util.Random;

public class RedPackageGrap {


    public static void main(String[] args) {
        RedPackage redPackage=new RedPackage(5,100.00);
        int len=redPackage.remainingSize;
        for(int i=0;i<len;i++){
            System.out.println(i+":"+getPackageMoney(redPackage));
        }
    }


    static class RedPackage {
        Integer remainingSize;
        Double remainingMoney;

        public RedPackage(Integer remainingSize, Double remainingMoney) {
            this.remainingSize = remainingSize;
            this.remainingMoney = remainingMoney;
        }
    }


    public static Double getPackageMoney(RedPackage redPackage){
        if(redPackage.remainingSize ==1){
            //return (double) Math.round(redPackage.remainingMoney * 100)/100;
            return new BigDecimal(redPackage.remainingMoney).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        Random random=new Random();
        Double min=0.01;
        Double max=redPackage.remainingMoney/redPackage.remainingSize *2;
        Double money= random.nextDouble() * max;
        money= money<=min ? 0.01:money;
        money=new BigDecimal(money).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        redPackage.remainingSize--;
        redPackage.remainingMoney=redPackage.remainingMoney-money;
        return money;
    }







}
