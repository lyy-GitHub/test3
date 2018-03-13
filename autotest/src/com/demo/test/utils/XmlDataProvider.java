package com.demo.test.utils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.DataProvider;

public class XmlDataProvider {        
    
    private List l;
    public XmlDataProvider() {    
   	 l = parser3Xml(new File("data/demotest.xml").getAbsolutePath());   
   } 
    public List parser3Xml(String fileName) {
        File inputXml = new File(fileName);    
        List list=new ArrayList();                
        int count = 1;
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);
            Element employees = document.getRootElement();
            for (Iterator i = employees.elementIterator(); i.hasNext();) {
                Element employee = (Element) i.next();
                Map map = new HashMap();
                Map tempMap = new HashMap();
                for (Iterator j = employee.elementIterator(); j.hasNext();) {
                    Element node = (Element) j.next();                    
                    tempMap.put(node.getName(), node.getText());                    
                }
                map.put(employee.getName(), tempMap);
                list.add(map);
            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }    
     
    
    

    @DataProvider(name="providerMethod")
    public Object[][] providerMethod(Method method){        
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();        
        for (int i = 0; i < l.size(); i++) {
            Map m = (Map) l.get(i);    
            if(m.containsKey(method.getName())){                            
                Map<String, String> dm = (Map<String, String>) m.get(method.getName());
                result.add(dm);    
            }
        }  
        Object[][] files = new Object[result.size()][];
        for(int i=0; i<result.size(); i++){
            files[i] = new Object[]{result.get(i)};
        }        
        return files;
    }
    

}