package com.ipartek.formacion.xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;


/**
 * Ejercicio para aprender a parsear y trabajar con XML
 * @see https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
 * @author ur00
 *
 */
public class EstudiantesXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {


		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		// StringBuilder Similar a String pero preparado para trabajar 
		// con String grandes o ficheros texto
		StringBuilder xmlStringBuilder = new StringBuilder();
		
		xmlStringBuilder.append("<?xml version=\"1.0\"?><perro class=\"rojo\"><nombre>Rataplan</nombre><edad>45</edad></perro>");
		ByteArrayInputStream input = new ByteArrayInputStream(
		   xmlStringBuilder.toString().getBytes("UTF-8"));
		Document doc = builder.parse(input);
		
		Element elementPerro = doc.getDocumentElement();
		NodeList nodes = elementPerro.getChildNodes();
		
		String nombre = nodes.item(0).getTextContent();
		String edad = nodes.item(1).getTextContent();		
		String contentidoTextoCompleto = elementPerro.getTextContent();
		
		System.out.println("Perro " + nombre + " " + edad);
		System.out.println("HAber que sacamos del perro " + contentidoTextoCompleto);
		

	}

}
