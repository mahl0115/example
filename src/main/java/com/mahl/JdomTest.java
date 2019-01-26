package com.mahl;//package com.mahl;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.StringReader;
//import java.util.List;
//
//import org.apache.commons.lang3.StringUtils;
//import org.jdom.Attribute;
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;
//import org.jdom.output.Format;
//import org.jdom.output.XMLOutputter;
//
///**
// * Jdom����xml
// * documentתstring
// * @author mahl
// * 2015��11��12������11:58:24
// */
//public class JdomTest {
//
//	public static void main(String[] args) {
//		File file = new File("src/user.xml");
//		//���Ӳ��·��
//		System.out.println(file.getAbsolutePath());
//		BufferedReader br = null;
//		try {
//			br = new BufferedReader(new FileReader(file));
//			String s;
//			String str = "";
//			while(( s = br.readLine()) != null){
//				str += s;
//			}
//			//����xml����
//			System.out.println(str);
//			//��stringת��Ϊxml
//			SAXBuilder sax = new SAXBuilder();
//			Document doc = null;
//			if(StringUtils.isNotBlank(str)){
//				//��ȥxml��ͷ
//				str = str.substring(str.lastIndexOf("?>")+2, str.length());
//				//����������תΪdocument����
//				doc = sax.build(new StringReader(str));
//				//��ȡ���root�ڵ�
//				Element root = doc.getRootElement();
//				//��ȡroot�ڵ����������ӽڵ�
//				List<Element> list = doc.getRootElement().getChildren();
//
//				for (Element e : list) {
//					//��ȥ���Զ���
//					Attribute a = e.getAttribute("id");
//					//��ȡ����ֵ
//					String attrValue = e.getAttributeValue("id");
//					//��ȡĳ�ڵ�ڵ������
//					String eValue = e.getChildText("username");
//				}
//				//��Document����ת�����ַ�
//				String xmlStr = xml2String(doc, "utf-8");
//				System.out.println(xmlStr);
//			}
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("ϵͳ�ҵ�����ָ���ļ�");
//		} catch (IOException e) {
//			e.printStackTrace();
//			System.out.println("��ȡ�ļ�����");
//		} catch (JDOMException e) {
//			e.printStackTrace();
//		}
//		String xmlStr = "";
//	}
//
//	/**
//	 * documentתstring
//	 * @author mahl
//	 * 2015��11��12������2:22:59
//	 */
//	public static String xml2String(Object xml, String encoding) {
//        if (xml == null)
//            return null;
//        try {
//            Format xmlfmt = Format.getPrettyFormat();
//            if (encoding != null && !encoding.equalsIgnoreCase("UTF-8"))
//                xmlfmt.setEncoding(encoding);
//            if (xml instanceof Document)
//                return new XMLOutputter(xmlfmt).outputString((Document) xml);
//            else if (xml instanceof Element)
//                return new XMLOutputter(xmlfmt).outputString((Element) xml);
//            else if (xml instanceof List)
//                return new XMLOutputter(xmlfmt).outputString((List) xml);
//            else return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
