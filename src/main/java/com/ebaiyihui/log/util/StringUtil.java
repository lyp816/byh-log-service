package com.ebaiyihui.log.util;


/**
 * Created by threenoodles on 2015/9/21.
 */

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * String 工具类
 * @author lyp
 */
@Slf4j
public class StringUtil {

    private static boolean ipLocal = false;
    private static File file = null;
    private static DbConfig config;

    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    public static final String EMPTY_STRING = "";

    private StringUtil() {

    }


    static {
        SpringContextHolder.addCallBacks(() -> {
            StringUtil.ipLocal = SpringContextHolder.getProperties("ip.local-parsing", false, Boolean.class);
            if (ipLocal) {
                /*
                 * 此文件为独享 ，不必关闭
                 */
                String path = "ip2region/ip2region.db";
                String name = "ip2region/ip2region.db";
                try {
                    config = new DbConfig();
                    file = FileUtil.inputStreamToFile(new ClassPathResource(path).getInputStream(), name);
                } catch (Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
    }


    public static String getBrowser(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        return browser.getName();
    }

    /**
     * 根据ip获取详细地址
     */
    public static String getCityInfo(String ip) {
        if (ipLocal) {
            return getLocalCityInfo(ip);
        } else {
            return getHttpCityInfo(ip);
        }
    }


    /**
     * 根据ip获取详细地址
     */
    public static String getHttpCityInfo(String ip) {
        String api = String.format("http://whois.pconline.com.cn/ipJson.jsp?ip=%s&json=true", ip);
        JSONObject object = JSONUtil.parseObj(HttpUtil.get(api));
        return object.get("addr", String.class);
    }

    /**
     * 根据ip获取详细地址
     */
    public static String getLocalCityInfo(String ip) {
        try {
            DataBlock dataBlock = new DbSearcher(config, file.getPath())
                    .binarySearch(ip);
            String region = dataBlock.getRegion();
            String address = region.replace("0|", "");
            char symbol = '|';
            if (address.charAt(address.length() - 1) == symbol) {
                address = address.substring(0, address.length() - 1);
            }
            return address.equals("内网IP|内网IP") ? "内网IP" : address;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return "";
    }
    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str) {

        return !StringUtil.isEmpty(str);
    }

    /**
     * 字符串trim 后是否为空
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        if (str == null || str.trim().length() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotBlank(String str) {

        return !StringUtil.isBlank(str);
    }

    /*string 转换成 long*/
    public static long toLongValue(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        String str = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = String.valueOf(obj);
        }
        if (StringUtil.isBlank(str)) {
            return 0;
        } else if ("null".equals(str)) {
            return 0;
        }
        try {
            return Long.valueOf(str);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }

    /*string 转换成 long*/
    public static int toIntValue(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        String str = null;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = String.valueOf(obj);
        }
        if (StringUtil.isBlank(str)) {
            return 0;
        } else if ("null".equals(str)) {
            return 0;
        }
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return 0;
    }


    /**
     * 字符串trim 去掉字符串两端的空格
     *
     * @param str
     * @return
     */
    public static String trim(String str) {
        if (str == null || str.length() <= 0) {
            return StringUtil.EMPTY_STRING;
        } else {
            return str.trim();
        }
    }


    /**
     * 首字母转小写
     *
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder())
                    .append(Character.toLowerCase(s.charAt(0)))
                    .append(s.substring(1)).toString();
        }
    }

    /**
     * 首字母转大写
     *
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0))) {
            return s;
        } else {
            return (new StringBuilder())
                    .append(Character.toUpperCase(s.charAt(0)))
                    .append(s.substring(1)).toString();
        }
    }

    /**
     * replace:(替换字符串函数)
     *
     * @param strSource 源字符串
     * @param strFrom   要替换的子串
     * @param strTo     替换为的字符串
     * @return
     * @since JDK 1.7
     */
    public static String replace(String strSource, String strFrom,
                                 String strTo) {
        // 如果要替换的子串为空，则直接返回源串
        if (strFrom == null || strFrom.equals(""))
            return strSource;
        String strDest = "";
        // 要替换的子串长度
        int intFromLen = strFrom.length();
        int intPos;
        // 循环替换字符串
        while ((intPos = strSource.indexOf(strFrom)) != -1) {
            // 获取匹配字符串的左边子串
            strDest = strDest + strSource.substring(0, intPos);
            // 加上替换后的子串
            strDest = strDest + strTo;
            // 修改源串为匹配子串后的子串
            strSource = strSource.substring(intPos + intFromLen);
        }
        // 加上没有匹配的子串
        strDest = strDest + strSource;
        // 返回
        return strDest;
    }

    /**
     * String类型日期转为Date类型
     *
     * @param dateStr
     * @return
     * @throws ParseException
     * @throws Exception
     */
    public static Date dateConvertFormat(String dateStr) throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date = format.parse(dateStr);
        return date;
    }


    //去重合并两个字符串数组
    public static String[] mergeStrArray(String []a,String []b) {
        int j =0;
        Map<String,String> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i],a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            map.put(b[i],b[i]);
        }
        Collection<String> values = map.values();
        Iterator<String> iterator = values.iterator();
        String c [] = new String[values.size()];
        while (iterator.hasNext()){
            c[j++] = iterator.next();
        }
        return c;
    }


}
