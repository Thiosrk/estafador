package com.module.service.Impl;

import com.module.mapper.KstockMapper;
import com.module.pojo.Kstock;
import com.module.service.calculateservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xuyafan on 2017/7/8.
 */
@Service
public class calculateimpl implements calculateservice {


    String[] codelist = {"000001", "002142", "002807", "002839", "600000"
            , "600015", "600016", "600036", "600908", "600919", "600926", "601009", "601128",
            "601166", "601169", "601229", "601288", "601328", "601398", "601818", "601939",
            "601988", "601997", "601998", "603323"};




    @Autowired
    KstockMapper kstockMapper;


//    for (int i=0;i<list.length;++i){
//        if (i<daycount){
//            continue;
//        }
//        double sum = 0;
//        for (int j=0;j<daycount;++j){
//            sum +=Double.parseDouble(list[i-j].getClose());
//        }
//        ma[i] = sum/daycount;
//    }

    @Override
    public void calculateMA(int daycount) {
        for (int i=0;i<codelist.length;i++){
            List<Kstock> kstocks = kstockMapper.selectByCode(codelist[i]);


            for (int j=daycount;j<kstocks.size();j++){
                Kstock kstock = kstocks.get(j);

                double sum = 0.0;
                for (int t=0;t<daycount;t++){
                    sum +=Double.parseDouble(kstocks.get(j-t).getClose());
                }
                double result =sum/daycount;

                switch (daycount){
                    case 5:
                        kstock.setMA5(result);
                        kstockMapper.updateByPrimaryKey(kstock);
                        break;
                    case 10:
                        kstock.setMA10(result);
                        kstockMapper.updateByPrimaryKey(kstock);
                        break;
                    case 20:
                        kstock.setMA20(result);
                        kstockMapper.updateByPrimaryKey(kstock);
                        break;
                    case 30:
                        kstock.setMA30(result);
                        kstockMapper.updateByPrimaryKey(kstock);
                        break;


                }


            }

        }

    }

    //乖离率=[(当日收盘价-N日平均价)/N日平均价]*100% n=5
    @Override
    public void calculateBias() {
        for(int i=0;i<codelist.length;i++){
            List<Kstock> kstocks = kstockMapper.selectByCode(codelist[i]);
            for(int j=5;j<kstocks.size();j++){
                Kstock kstock =kstocks.get(j);

                double result=(Double.parseDouble(kstock.getClose())-kstock.getMA5())/kstock.getMA5();
                kstock.setBIAS(result);
                kstockMapper.updateByPrimaryKey(kstock);


            }
        }

    }



    //威廉指标 WR(N) = 100 * [ HIGH(N)-C ] / [ HIGH(N)-LOW(N) ] n=5
    // C：当日收盘价
    // HIGH(N)：N日内的最高价
    // LOW(n)：N日内的最低价
    @Override
    public void calculateWR() {
        for(int i=0;i<codelist.length;i++) {
            List<Kstock> kstocks = kstockMapper.selectByCode(codelist[i]);
            for (int j = 5; j < kstocks.size(); j++) {
                Kstock kstock =kstocks.get(j);

                double high_5 =Double.parseDouble(kstock.getHigh());
                double low_5 =Double.parseDouble(kstock.getLow());
                for(int t=1;t<5;t++){

                    double temp_high =Double.parseDouble(kstocks.get(j-t).getHigh());
                    if(temp_high>high_5){
                        high_5=temp_high;
                    }

                    double temp_low =Double.parseDouble(kstocks.get(j-t).getLow());
                    if(temp_low<low_5){
                        low_5=temp_low;
                    }
                }

                double result =100*(high_5-Double.parseDouble(kstock.getClose()))/(high_5-low_5);
                kstock.setWR(result);
                kstockMapper.updateByPrimaryKey(kstock);


            }
        }

    }



    //n日RSV=（Cn－Ln）/（Hn－Ln）×100

    //公式中，Cn为第n日收盘价；Ln为n日内的最低价；Hn为n日内的最高价。

    //其次，计算K值与D值：

    //当日K值=2/3×前一日K值+1/3×当日RSV

    //当日D值=2/3×前一日D值+1/3×当日K值

    //若无前一日K值与D值，则可分别用50来代替。

    //J值=3*当日K值-2*当日D值
    @Override
    public void calculateKDJ() {
        for(int i=0;i<codelist.length;i++) {
            List<Kstock> kstocks = kstockMapper.selectByCode(codelist[i]);
            for (int j = 5; j < kstocks.size(); j++) {
                Kstock kstock =kstocks.get(j);


                double high_5 =Double.parseDouble(kstock.getHigh());
                double low_5 =Double.parseDouble(kstock.getLow());
                for(int t=1;t<5;t++){

                    double temp_high =Double.parseDouble(kstocks.get(j-t).getHigh());
                    if(temp_high>high_5){
                        high_5=temp_high;
                    }

                    double temp_low =Double.parseDouble(kstocks.get(j-t).getLow());
                    if(temp_low<low_5){
                        low_5=temp_low;
                    }
                }

                if(j==5){
                    kstock.setKDJ_K(50);
                    kstock.setKDJ_D(50);
                }

                double rsv =(Double.parseDouble(kstock.getClose())-low_5)/(high_5-low_5);
                double kdj_k =kstocks.get(j-1).getKDJ_K()*2/3.0+rsv/3.0;
                double kdj_d=kstocks.get(j-1).getKDJ_D()*2/3.0+kdj_k/3.0;
                double kdj_j =3*kdj_k-2*kdj_d;
                kstock.setKDJ_K(kdj_k);
                kstock.setKDJ_D(kdj_d);
                kstock.setKDJ_J(kdj_j);

                kstockMapper.updateByPrimaryKey(kstock);


            }
        }


    }




}
