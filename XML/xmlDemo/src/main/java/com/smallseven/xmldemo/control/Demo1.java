/** 
 * @Description: 
 * @Author: smallSeven
 * @Date: 2020-04-03 22:30:39
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-04 10:12:32
 * @FilePath: /xmlDemo/src/main/java/com/smallseven/xmldemo/control/Demo1.java
 */
package com.smallseven.xmldemo.control;

import java.io.File;
import java.util.Iterator;

import org.dom4j.io.SAXReader;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File("src/main/java/com/smallseven/xmldemo/resource/class.xml"));
        Element root = document.getRootElement();
        Iterator<Element> iterator = root.elementIterator();
        while(iterator.hasNext()){
            Element element = iterator.next();
            Attribute attribute = element.attribute("dependencies");
            System.out.println(attribute.getName());
        }
    }
}