package com.joyce.r2dbc.mysql.constant;

/**
 * @author: Joyce Zhu
 * @date: 2020/11/19
 */
public class DatetimeConstant {

    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String REG_YYYY_MM_DD_HH_MM_SS_SSS = "[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[ ]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}[.]{1}[0-9]{3}";

    public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.S";
    public static final String REG_YYYY_MM_DD_HH_MM_SS_S = "[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[ ]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}[.]{1}[0-9]{1}";

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String REG_YYYY_MM_DD_HH_MM_SS = "[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}[ ]{1}[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String REG_YYYY_MM_DD = "[0-9]{4}[-]{1}[0-9]{2}[-]{1}[0-9]{2}";

    public static final String HH_MM_SS = "HH:mm:ss";
    public static final String REG_HH_MM_SS = "[0-9]{2}[:]{1}[0-9]{2}[:]{1}[0-9]{2}";

    public static final String REG_NUMBER = "[0-9]{1,}";


}
