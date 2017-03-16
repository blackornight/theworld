package com.pengyang.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Component;

import com.pengyang.entity.User;
@Component
public class Util {
	public Util(){
		
	}
	/**
	 * 将一个User的list存储为xml文件
	 * @param users
	 * @return
	 */
	public boolean UsersToXml(List<User> users){
		try{
			XMLWriter writer = new XMLWriter();
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement(Constant.loginRoot);
			for(User u:users){
				root.addElement(u.getName()).addText(u.getPassword());
			}
			FileOutputStream fos = new FileOutputStream(Constant.login);
			writer.setOutputStream(fos);
			writer.write(doc);
			writer.close();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	/**
	 * 将一个xml解析为UserList
	 * @return
	 */
	public List<User> XmlToUsers(){
		List<User> userList =null;
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(getClass().getClassLoader().getResourceAsStream(Constant.login));
			Element root = doc.getRootElement();
			List<Element> elements = root.elements();
			userList= new ArrayList<User>();
			for(Element m:elements){
				userList.add(new User(m.getName(),m.getText()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return userList;
	}
	
	/**
	 * 将UserList转化为map
	 * @param userList
	 * @return
	 */
	public Map<String,String> UserListToMap(List<User> userList){
		Map<String,String> map = new HashMap<String,String>();
		for(User u:userList){
			map.put(u.getName(), u.getPassword());
		}
		return map;
	}
	
	/**
	 * 检查用户密码是否正确
	 */
	public boolean checkLogin(String name,String password){
		Map<String,String> user = UserListToMap(XmlToUsers());
		String pwd = user.get(name);
		if(pwd==null){
			return false;
		}
		if(pwd.equals(password)){
			return true;
		}
		return false;
	}
}
