package com.ipartek.formacion.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ipartek.formacion.Perro;

/**
 * Leer XML con listado de perros Guardar en ArrayList Mostrar por pantalla
 * 
 * @author ur00
 *
 */
public class LeerPerrosFromXML {

	public static void main(String[] args) throws NumberFormatException, Exception {

		// leer fichero
		ClassLoader classLoader = new LeerPerrosFromXML().getClass().getClassLoader();
		File file = new File(classLoader.getResource("perros.xml").getFile());
		if (file.exists()) {

			// crear builder
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(file);
			// doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();
			System.out.println("Root element :" + root.getNodeName());

			NodeList nodes = doc.getElementsByTagName("perro");
			Node node;
			Perro perro;
			for (int i = 0; i < nodes.getLength(); i++) {

				// elemento = (Element)nodes.item(i);
				node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;

					perro = new Perro();
					perro.setNombre(eElement.getElementsByTagName("nombre").item(0).getTextContent());
					perro.setRaza(eElement.getElementsByTagName("raza").item(0).getTextContent());
					perro.setEdad(Integer.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent()));

					String vacunado = eElement.getElementsByTagName("vacunado").item(0).getTextContent();
					perro.setVacunado(("true".equalsIgnoreCase(vacunado)) ? true : false);

					System.out.println(perro);

				}

			}

		} else {
			System.out.println("No existe fichero");
		}

		// recorrect Document y rellenar ArrayList

		// mostrar por pantalla

	}

}
