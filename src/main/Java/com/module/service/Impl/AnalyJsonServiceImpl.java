package com.module.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.module.mapper.KstockMapper;
import com.module.pojo.Kstock;
import com.module.service.AnalysizeJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2017/6/10.
 */
public class AnalyJsonServiceImpl implements AnalysizeJsonService {

    @Autowired
    KstockMapper kstockMapper;

    @Override
    public List<Kstock[]> getStockInto() {
        String[] codelist = {"000001", "002142", "002807", "002839", "600000"
                , "600015", "600016", "600036", "600908", "600919", "600926", "601009", "601128",
                "601166", "601169", "601229", "601288", "601328", "601398", "601818", "601939",
                "601988", "601997", "601998", "603323"};
        Kstock[] list;
        List<Kstock[]> stocklist = new ArrayList<Kstock[]>();

        for (int index = 0; index < codelist.length; index++) {
        BufferedReader br = null;// 读取原始json文件
        String path = "D:\\Tencent\\QQDownload\\kstock\\kstock\\stock" +codelist[index] + ".json";
        try {
            br = new BufferedReader(new FileReader(
                    path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String jsoninfo = null;
        try {
            jsoninfo = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jo = JSON.parseObject(jsoninfo);
        Set<String> keys = jo.keySet();
        List<String> keyslist = new ArrayList<String>(keys);

        list = new Kstock[jo.size()];
        for (int i = 0; i < jo.size(); i++) {
            list[i] = new Kstock();
            list[i].setDate(keyslist.get(i));
            JSONObject temp=jo.getJSONObject(keyslist.get(i));
            list[i].setOpen(temp.getString("open"));
            list[i].setHigh(temp.getString("high"));
            list[i].setClose(temp.getString("close"));
            list[i].setLow(temp.getString("volume"));
            list[i].setPriceChange(temp.getString("price_change"));
            list[i].setpChange(temp.getString("p_change"));
            list[i].setMa5(temp.getString("ma5"));
            list[i].setMa10(temp.getString("ma10"));
            list[i].setMa20(temp.getString("ma20"));
            list[i].setvMa5(temp.getString("v_ma5"));
            list[i].setvMa10(temp.getString("v_ma10"));
            list[i].setvMa20(temp.getString("v_ma20"));
            list[i].setTurnover(temp.getString("turnover"));


        }

        stocklist.add(list);

        }

        return stocklist;
    }

    public void test(){

        Kstock a = new Kstock();
        a.setDate("2017-02-03");

        a.setOpen("55");
        a.setHigh("55");
        a.setClose("22");
        a.setLow("33");
        a.setPriceChange("22");
        a.setpChange("44");
        a.setMa5("11");
        a.setMa10("3");
        a.setMa20("1");
        a.setvMa5("3");
        a.setvMa10("31");
        a.setvMa20("31");
        a.setTurnover("4");
        kstockMapper.insert(a);
    }

    public int load2db(List<Kstock[]> kstocks) {

        mysqlImpl mysqlimpl;
        mysqlimpl = new mysqlImpl();

        int stocksize;//存放的Arraylist的长度
        int arraysize;//存放一只股票的数组的长度

        String[] codelist = {"sz000001", "sz002142", "sz002807", "sz002839", "sh600000"
                , "sh600015", "sh600016", "sh600036", "sh600908", "sh600919", "sh600926", "sh601009", "sh601128",
                "sh601166", "sh601169", "sh601229", "sh601288", "sh601328", "sh601398", "sh601818", "sh601939",
                "sh601988", "sh601997", "sh601998", "sh603323"};

        stocksize=kstocks.size();
        System.out.println(stocksize+"stocksize");
        for (int i=0;i<stocksize;i++){
            Kstock[] kstock=kstocks.get(i);
            arraysize=kstock.length;
//            System.out.println(arraysize+"arraysize");
            for(int index=0;index<arraysize;index++){
//                System.out.println(kstock[index].getDate()+"sssssss");
                String code=codelist[i];
                String date=kstock[index].getDate();
                String open=kstock[index].getOpen();
                String high=kstock[index].getHigh();
                String close=kstock[index].getClose();
                String low=kstock[index].getLow();
                String volume=kstock[index].getVolume();
                String price_change=kstock[index].getPriceChange();
                String p_change=kstock[index].getpChange();
                String ma5=kstock[index].getMa5();
                String ma10=kstock[index].getMa10();
                String ma20=kstock[index].getMa20();
                String v_ma5=kstock[index].getvMa5();
                String v_ma10=kstock[index].getvMa10();
                String v_ma20=kstock[index].getvMa20();
                String turnover=kstock[index].getTurnover();
                String insert="INSERT INTO kstock (code,date,open,high,close,low,volume,price_change,p_change" +
                        ",ma5,ma10,ma20,v_ma5,v_ma10,v_ma20,turnover) VALUES('"+code+"',"+"'"+date+"',"+"'"+open+"',"+"'"+high
                        +"',"+"'"+close+"',"+"'"+low+"',"+"'"+volume+"',"+"'"+price_change+"',"+"'"+p_change+"',"
                        +"'"+ma5+"',"+"'"+ma10+"',"+"'"+ma20+"',"+"'"+v_ma5+"',"+"'"+v_ma10+"',"+"'"+v_ma20+"',"
                        +"'"+turnover+"')";
                System.out.println(insert);
                try {
                    mysqlimpl.update(insert);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        AnalyJsonServiceImpl a = new AnalyJsonServiceImpl();
        a.load2db(a.getStockInto());

//        System.out.println();
//        a.test();

    }
}
