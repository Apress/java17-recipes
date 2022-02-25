package org.java17recipes.chapter15.recipe15_02;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class DocReader {

	public void run(String xmlFile) throws FileNotFoundException, IOException, XMLStreamException {
		cursorReader(xmlFile);
		eventReader(xmlFile);
	}

	public void cursorReader(String xmlFile) throws FileNotFoundException, IOException, XMLStreamException {
		XMLInputFactory factory = XMLInputFactory.newFactory();
		try (FileInputStream fis = new FileInputStream(xmlFile)) {
			XMLStreamReader reader = factory.createXMLStreamReader(fis);
			boolean inName = false;
			boolean inDiagnosis = false;
			String id = null;
			String name = null;
			String diagnosis = null;

			while (reader.hasNext()) {
				int event = reader.next();
				switch (event) {
				case XMLStreamConstants.START_ELEMENT:
					String elementName = reader.getLocalName();
					switch (elementName) {
					case "patient":
						id = reader.getAttributeValue(0);
						break;
					case "name":
						inName = true;
						break;
					case "diagnosis":
						inDiagnosis = true;
						break;
					default:
						break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					String elementname = reader.getLocalName();
					if (elementname.equals("patient")) {
						System.out.printf("Patient: %s\nName: %s\nDiagnosis: %s\n\n",id, name, diagnosis);
						id = name = diagnosis = null;
						inName = inDiagnosis = false;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					if (inName) {
						name = reader.getText();
						inName = false;
					} else if (inDiagnosis) {
						diagnosis = reader.getText();
						inDiagnosis = false;
					}
					break;
				default:
					break;
				}
			}
			reader.close();
		}        
	}

	public void eventReader(String xmlFile) throws FileNotFoundException, IOException, XMLStreamException {
		XMLInputFactory factory = XMLInputFactory.newFactory();
		XMLEventReader reader = null;
		try(FileInputStream fis = new FileInputStream(xmlFile)) {
			reader = factory.createXMLEventReader(fis);
			boolean inName = false;
			boolean inDiagnosis = false;
			String id = null;
			String name = null;
			String diagnosis = null;

			while(reader.hasNext()) {
				XMLEvent event = reader.nextEvent();
				String elementName = null;
				switch(event.getEventType()) {
				case XMLEvent.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					elementName = startElement.getName().getLocalPart();
					switch(elementName) {
					case "patient":
						id = startElement.getAttributeByName(QName.valueOf("id")).getValue();
						break;
					case "name":
						inName = true;
						break;
					case "diagnosis":
						inDiagnosis = true;
						break;
					default:
						break;
					}
					break;
				case XMLEvent.END_ELEMENT:
					EndElement endElement = event.asEndElement();
					elementName = endElement.getName().getLocalPart();
					if (elementName.equals("patient")) {
						System.out.printf("Patient: %s\nName: %s\nDiagnosis: %s\n\n",id, name, diagnosis);
						id = name = diagnosis = null;
						inName = inDiagnosis = false;
					}
					break;                        
				case XMLEvent.CHARACTERS:
					String value = event.asCharacters().getData();
					if (inName) {
						name = value;
						inName = false;
					} else if (inDiagnosis) {
						diagnosis = value;
						inDiagnosis = false;
					}
					break;
				}
			}
		}
		if(reader != null) {
			reader.close();
		}

	}


	public static void main(String[] args) {
		String fileName = null;
		if (args.length != 1) {
			System.out.printf("Usage: java org.java8recipes.chapter20.recipe20_2.DocReader <xmlFile>\n");
			fileName = "patients.xml";
		} else {
			fileName = args[0];
		}
		DocReader app = new DocReader();
		try {
			app.run(fileName);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException | XMLStreamException ioex) {
			ioex.printStackTrace();
		}

	}
}
