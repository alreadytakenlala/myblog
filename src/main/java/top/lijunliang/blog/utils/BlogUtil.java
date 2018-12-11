package top.lijunliang.blog.utils;

import top.lijunliang.blog.entity.bo.Article;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BlogUtil
{
    /**
     * 数组添加元素
     */
    public static Object[] addElement(Object[] array1, Object element)
    {
        for (int i = 0; i < array1.length; i++)
        {
            if (array1[i] == null)
            {
                array1[i] = element;
                break;
            }
        }

        return array1;
    }
}
