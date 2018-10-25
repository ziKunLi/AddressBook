package com.study.newbies.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 *
 * @author NewBies
 * @date 2018/9/1
 */

public class StringUtil {

    public static boolean isNull(String value){
        return value == null||value.trim().equals("");
    }

    /**
     * 汉字转拼音
     * @param chinese
     * @return
     */
    public static String chineseToPinYin(String chinese){
        if(isNull(chinese)){
            return null;
        }
        return PinyinHelper.toHanyuPinyinStringArray(chinese.charAt(0))[0];
    }
}
