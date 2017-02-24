package com.bjsx.spring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {
	private Map<String, Object> beans =  new HashMap<String, Object>();

	public ClassPathXmlApplicationContext() throws Exception {
		// TODO Auto-generated constructor stub
		SAXBuilder sBuilder = new SAXBuilder();
		Document document = sBuilder.build(this.getClass().getClassLoader().getResourceAsStream("beans.xml"));
		Element root = document.getRootElement();
		List list = root.getChildren("bean");
		for(int i = 0; i < list.size(); i++){
			Element element = (Element)list.get(i);
			String id = element.getAttributeValue("id");
			String clazz = element.getAttributeValue("class");
			System.out.println(id+" : "+clazz);
			Object object = Class.forName(clazz).newInstance();
			beans.put(id, object);
			
			for(Element propertyElement : (List<Element>)element.getChildren("property")){
				String name = propertyElement.getAttributeValue("name");
				String bean = propertyElement.getAttributeValue("bean");
				Object beanObject = beans.get(bean);
				
				String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
				System.out.println("method name= "+methodName);
				
				Method method = object.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
				method.invoke(object, beanObject);
				
			}
		}
	}
	
	@Override
	public Object getBean(String name) {
		return this.beans.get(name);
	}
	
}
