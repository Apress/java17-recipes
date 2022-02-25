package org.java17recipes.chapter15.recipe15_01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
 

public class DocWriter {

	public void run(String outputFile) throws FileNotFoundException, XMLStreamException,
	IOException {
		List<Patient> patients = new ArrayList<>();
		Patient p1 = new Patient();
		Patient p2 = new Patient();
		Patient p3 = new Patient();
		p1.setId(BigInteger.valueOf(1));
		p1.setName("John Smith");
		p1.setDiagnosis("Common Cold");
		p2.setId(BigInteger.valueOf(2));
		p2.setName("Jane Doe");
		p2.setDiagnosis("Broken Ankle");
		p3.setId(BigInteger.valueOf(3));
		p3.setName("Jack Brown");
		p3.setDiagnosis("Food Allergy");
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		XMLOutputFactory factory = XMLOutputFactory.newFactory();
		try (FileOutputStream fos = new FileOutputStream(outputFile)) {
			XMLStreamWriter writer = factory.createXMLStreamWriter(fos, "UTF-8");
			writer.writeStartDocument();
			writer.writeCharacters("\n");
			writer.writeStartElement("patients");
			writer.writeCharacters("\n");
			for (Patient p : patients) {
				writer.writeCharacters("\t");
				writer.writeStartElement("patient");
				writer.writeAttribute("id", String.valueOf(p.getId()));
				writer.writeCharacters("\n\t\t");
				writer.writeStartElement("name");
				writer.writeCharacters(p.getName());
				writer.writeEndElement();
				writer.writeCharacters("\n\t\t");
				writer.writeStartElement("diagnosis");
				writer.writeCharacters(p.getDiagnosis());
				writer.writeEndElement();
				writer.writeCharacters("\n\t");
				writer.writeEndElement();
				writer.writeCharacters("\n");
			}
			writer.writeEndElement();
			writer.writeEndDocument();
			writer.close();
		}

	}

	public static void main(String[] args) {
		String fileName = null;
		if (args.length != 1) {
			System.out.printf("Usage: java org.java17recipes.chapter15.recipe15_01.DocWriter <outputXmlFile>\n");
			fileName = "patients.xml";
		} else {
			fileName = args[0];
		}
		DocWriter app = new DocWriter();
		try {
			app.run(fileName);
		} catch (FileNotFoundException|XMLStreamException ex) {
			Logger.getLogger(DocWriter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(DocWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

