/**
 * created by
 * Date:2019/4/19
 **/
package com.signInStart.Utils;

import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Field;


/**
 * 对数据操作工具
 */
@Log4j2
public class DataUtils {
    /**
     * 复制数据，将source中的非空数据拷贝到target中
     * @param source
     * @param target
     * @return
     */
    public static Boolean copyProperty(Object source, Object target) {
        Class s = source.getClass();
        Class t = target.getClass();

        Field[] declaredFields = s.getDeclaredFields();
        try {
            for (Field dfield : declaredFields) {
                Field property = s.getDeclaredField(dfield.getName()); //获取属性
                property.setAccessible(true);
                Object value = property.get(source);
                if (value == null || "".equals(value.toString())) {  //去掉空值
                    continue;
                }
                Field newProperty = t.getDeclaredField(dfield.getName());
                newProperty.setAccessible(true);
                newProperty.set(target, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 判断字符串是否为空
     * @param s
     * @return
     */
    public static Boolean isEmptyString(String s) {
        return s == null || "".equals(s);
    }

}