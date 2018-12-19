package com.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.util.JsonUtils;

import java.util.Map;

/**
 * Created by mahailong on 17/5/19.
 */
public class Test {

    public static void main(String[] args) throws JsonProcessingException {
        String s = "{\"rankingSearch\":\"1200\",\"getPoiItemList\":\"400\",\"recommend\":\"500\",\"domesticCityList\":\"1000\",\"getCityById\":\"1000\",\"getSuggest\":\"200\",\"getCitySuggestV2\":\"100\",\"getCitySuggest\":\"100\",\"getSelectorHotword\":\"200\",\"getMixedCateConfAttribute\":\"500\",\"mtMultiSearch\":\"2000\",\"getBrandList\":\"800\",\"listPois\":\"500\",\"listPoiThrift\":\"100\",\"addPoiPreferenceThrift\":\"100\",\"deletePoiPreferenceThrift\":\"100\",\"getOverseaCity\":\"100000\",\"getOverseaCityByCityId\":\"100000\",\"getOverseaArea\":\"500\",\"getSubwayLineList\":\"500\",\"getRegionAreas\":\"500\",\"getOverseaTimezoneByRegionId\":\"300000\",\"getAllRegion\":\"300000\",\"getRegionDetail\":\"300000\",\"getOrCreateVirtualBindByDpUserId\":\"100\",\"getArea\":\"50\",\"getAreaDetail\":\"50\"}";
        Map<String, String> commandAndTimeout = JsonUtils.toBean(s, Map.class);

        System.out.println(commandAndTimeout);
    }
}
