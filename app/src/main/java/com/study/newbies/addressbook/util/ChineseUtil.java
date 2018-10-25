package com.study.newbies.addressbook.util;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.ArrayList;

/**
 *
 * @author NewBies
 * @date 2018/10/12
 */

public class ChineseUtil {

    public static char getChineseFirstChar(char chineseFirstChar){
        String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(chineseFirstChar);
        //当传入的字符不是汉字时，返回传入的字符
        if(pinyinArray == null){
            return chineseFirstChar;
        }
        return pinyinArray[0].charAt(0);
    }

}
