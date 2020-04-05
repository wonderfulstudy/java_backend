/** 
 * @Description: 
 * @Author: smallSeven
 * @Date: 2020-04-04 10:14:28
 * @LastEditors: smallSeven
 * @LastEditTime: 2020-04-04 10:32:07
 * @FilePath: /xmlDemo/src/main/java/com/smallseven/xmldemo/control/Demo2.java
 */
package com.smallseven.xmldemo.control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        // 通过DocumentHelper生成一个Document对象
        Document document = DocumentHelper.createDocument();
        // document.addElement("books").addElement("book").addAttribute("id", "b01");
        // 添加并得到根元素
        Element root = document.addElement("bookd");
        // 为根元素添加属性
        Element book = root.addElement("book");
        // 为book元素添加属性
        book.addAttribute("id", "b01");
        // 为book添加子元素
        Element name = book.addElement("name");
        Element author = book.addElement("author");
        Element price = book.addElement("price");
        // 为子元素添加文本
        name.addText("thinking in java");
        author.addText("lijie");
        price.addText("38");
        // // 将Document输出到XML文件
        // Writer writer = new FileWriter(new File("src/main/java/com/smallseven/xmldemo/resource/book.xml"));
        // document.write(writer);
        // // 关闭资源
        // writer.close();

        // 格式良好的输出
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(new FileWriter("src/main/java/com/smallseven/xmldemo/resource/book.xml"), format);
        writer.write(document);
        writer.close();
    }
}