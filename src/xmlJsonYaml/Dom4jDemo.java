package xmlJsonYaml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public class Dom4jDemo {
    public static void main(String[] args) throws MalformedURLException, DocumentException {
        /*
        标准打法：
        申明reader，从reader拿document对象，document取根节点后遍历
         */
        SAXReader reader=new SAXReader();
        Document document=reader.read(new URL("https://www.runoob.com/try/xml/cd_catalog.xml"));
        Element root=document.getRootElement();

        for(Iterator<Element> it=root.elementIterator();it.hasNext();){
            Element element=it.next();
            System.out.println(element.getName());
            System.out.println(element.isTextOnly());
            System.out.println(element.getStringValue());
        }
        printValue(root);
    }
    //遍历节点，打印标签
    public static void printValue(Element element){
        if(element.isTextOnly()){
            System.out.println("<"+element.getName()+">"+element.getText()+"</"+element.getName()+">");
        }else{
            for(Iterator<Element> it=element.elementIterator();it.hasNext();){
                Element e=it.next();
                printValue(e);
            }
        }
    }

}
