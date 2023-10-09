package com.getTema.tma.lyrric;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.getTema.tma.lyrric.ui.ConsoleMode;
import com.getTema.tma.lyrric.ui.MainFrame;
import org.apache.http.client.methods.HttpGet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2020-07-21.
 *
 * @author wangxiaodong
 */
public class Main {

    private  static  final Logger logger = LogManager.getLogger(Main.class);

    public static  void main(String[] args) throws IOException, ParseException, InterruptedException {
//        logger.info("=================程序开始运行=================");
//        if(args.length > 0 && "-c".equals(args[0].toLowerCase())){
//            new ConsoleMode().start();
//        }else{
//            new MainFrame();
//        }
//        logger.info("=================程序运行结束=================");

        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\jqg\\Desktop\\项目总结\\预约导入数据1.2.xls"));
        List<List<Object>> list=reader.read();
         List<Object> zzresult=new ArrayList<>();
        List<Object> zzresultf=new ArrayList<>();
int i=0;
        SimpleDateFormat hm=new SimpleDateFormat("HH:mm");
        SimpleDateFormat ydm=new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat ydmhm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(List <Object> vos:list){

//            testVo vo=new testVo(vos.get(0),vos.get(5),vos.get(2),vos.get(3));
            String sbs="";
           if(i!=0 && ObjectUtil.isNotEmpty(vos.get(3))){

                 sbs= hm.format(ydmhm.parse(vos.get(3).toString()));
                 if(vos.get(5).toString().contains(";")){
                     for(String vs:vos.get(5).toString().split(";")){
                         List<Object> result=new ArrayList<Object>(){{
                             add(vos.get(0)) ;
                             add(vs);
                             add(vos.get(2));
                             add(1);
                         }};
                         result.add(sbs);
                         String  ff=result.stream().map(Object::toString).collect(Collectors.joining("#"));
                         zzresult.add(ff);
                     }
                 }else {
                     List<Object> result=new ArrayList<Object>(){{
                         add(vos.get(0));
                         add(ydm.format(ydm.parse(ydmhm.format(vos.get(5)))));
                         add(vos.get(2));
                         add(1);
                     }};
                     result.add(sbs);

                     String  ff=result.stream().map(Object::toString).collect(Collectors.joining("#"));
                     zzresult.add(ff);
                     zzresultf.add(ff);
                 }




            }else {

               System.out.println("为空"+i+"==》"+vos.get(3));

           }
           String xbtime="";
            if(i!=0 && ObjectUtil.isNotEmpty(vos.get(4))){
                xbtime= hm.format(ydmhm.parse(vos.get(4).toString()));
                if(vos.get(6).toString().contains(";")){
                    for(String vs:vos.get(6).toString().split(";")){
                        List<Object> xbresult=new ArrayList<Object>(){{
                            add(vos.get(0).toString().trim());
                            add(vs.toString().trim());
                            add(vos.get(2).toString().trim());
                            add(2);

                        }};  if(vos.get(2).toString().length()>10){
                            System.out.println("=========="+vos.get(2));
                        }
                        xbresult.add(xbtime.toString().trim());
                        String  ff2=xbresult.stream().map(Object::toString).collect(Collectors.joining("#"));
                        zzresult.add(ff2);
                    }
                }else {
                    List<Object> xbresult=new ArrayList<Object>(){{
                        add(vos.get(0).toString().trim());
                        add(ydm.format(ydm.parse(ydmhm.format(vos.get(6)))));
                        add(vos.get(2).toString().trim());
                        add(2);
                    }};
                    xbresult.add(xbtime.toString().trim());
                    String  ff2=xbresult.stream().map(Object::toString).collect(Collectors.joining("#"));
                    zzresult.add(ff2);
                    zzresultf.add(ff2);

                }


            }else {

                System.out.println("为空"+i+"==》"+vos.get(4));
            }
           i++;



        }
        String a=  JSON.toJSONString(zzresult);
//        System.out.println(JSON.toJSONString(zzresultf));
        System.out.println(a);
       List<String> relist= JSON.parseArray(a,String.class);
       for(String s:relist){
           String []f=s.split("#");
           if(f[1].length()!=10){
               System.out.println(s);
           }
           if(s.split("#").length!=5){
               System.out.println(s);
           }
       }
//        System.out.println(i);
//        System.out.println(reader.read());

    }

}
