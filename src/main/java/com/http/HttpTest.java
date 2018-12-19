package com.http;

/**
 * Created by mahailong on 17/4/17.
 */
public class HttpTest {

    public static void main(String[] args) {
        String brands = "EDITION,Renaissance,Bvlgari,Marriott,Autograph Collection Hotels,Delta,Gaylord Hotels,Protea Hotel,Moxy Hotel,St.Regis,The luxury Collection,Tribute Portfolio,Sheraton,Westin,Four Points,W Hotels,Aloft,Element,Design Hotels,Le MERIDIEN,丽思卡尔顿,丽兹卡尔顿,艾迪逊,万丽,万豪,傲途格精选,德尔塔,盖洛德,万怡,万枫,瑞吉,豪华精选,福朋,雅乐轩,源宿,喜来登,宝格丽,威斯汀,艾美,spring hill,towne place suites";
        int allBrandsPoiIdCount = 0;
        for (String brand : brands.split(",")) {
            String response = HttpUtil.httpGet("http://10.5.215.191:8080/test/getPoiIds?brand=" + brand);
            if (response != null) {
                allBrandsPoiIdCount += Integer.parseInt(response);
            }
        }
        System.out.println(allBrandsPoiIdCount);
    }
}
