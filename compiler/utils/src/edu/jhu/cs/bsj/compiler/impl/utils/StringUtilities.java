package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains utilities related to string manipulation.
 * 
 * @author Zachary Palmer
 */
public class StringUtilities
{
    /**
     * Prevents instantiation.
     */
    private StringUtilities()
    {
    }

    /**
     * Removes all characters from the provided string including and after the last instance of the specified character.
     * If that character does not exist in the provided string, it is returned as it is.
     * 
     * @param string The source string.
     * @param ch The character to use as the stripping point.
     * @return The resulting string.
     */
    public static String removeSuffix(String string, char ch)
    {
        int index = string.lastIndexOf(ch);
        if (index == -1)
        {
            return string;
        } else
        {
            return string.substring(0, index);
        }
    }

    /**
     * Retrieves the suffix for the provided string after the last instance of the specified character (but not
     * including it). If that character does not exist in the provided string, it is returned as it is.
     * 
     * @param string The string.
     * @param ch The character to use to find the suffix.
     * @return The suffix.
     */
    public static String getSuffix(String string, char ch)
    {
        int index = string.lastIndexOf(ch);
        if (index == -1)
        {
            return string;
        } else
        {
            return string.substring(index + 1);
        }
    }

    /**
     * Converts a Java camel-case identifier into an upper-case identifier.
     * 
     * @param ident The identifier to convert.
     * @return The resulting identifier.
     */
    public static String convertCamelCaseToUpperCase(String ident)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ident.length(); i++)
        {
            if (i > 0 && Character.isUpperCase(ident.charAt(i)))
            {
                sb.append("_");
            }
            sb.append(Character.toUpperCase(ident.charAt(i)));
        }
        return sb.toString();
    }

    /**
     * Joins the contents of the provided list of objects with the specified delimiter by converting them to strings.
     * 
     * @param list The objects to join.
     * @param delimiter The delimiter in question.
     * @return The resulting string.
     */
    public static String join(Iterable<?> list, String delimiter)
    {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Object o : list)
        {
            if (!first)
            {
                sb.append(delimiter);
            }
            sb.append(String.valueOf(o));
            first = false;
        }
        return sb.toString();
    }

    /**
     * Joins the contents of the provided list of objects with the specified delimiter by converting them to strings.
     * 
     * @param list The objects to join.
     * @param delimiter The delimiter in question.
     * @param prepend The string to prepend onto each element.
     * @param append The string to append onto each element.
     * @return The resulting string.
     */
    public static String join(Iterable<?> list, String delimiter, String prepend, String append)
    {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Object o : list)
        {
            if (!first)
            {
                sb.append(delimiter);
            }
            sb.append(prepend);
            sb.append(String.valueOf(o));
            sb.append(append);
            first = false;
        }
        return sb.toString();
    }

    /**
     * Splits a string into a list of substrings around a given character. This method operates similar to
     * {@link String#split(String)} but runs much faster due to the fact that it is matching only a single character at
     * a time.
     * 
     * @param s The string to split.
     * @param c The character to use for splitting.
     * @return The resulting strings.
     */
    public static List<String> split(String s, char c)
    {
        ArrayList<String> ret = new ArrayList<String>();
        int first = 0;
        int index = 0;
        while (index < s.length())
        {
            if (s.charAt(index) == c)
            {
                ret.add(s.substring(first, index));
                first = index + 1;
            }
            index++;
        }
        if (first != index)
        {
            ret.add(s.substring(first, index));
        }
        ret.trimToSize();
        return ret;
    }
}
