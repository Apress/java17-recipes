package org.java17recipes.chapter15.recipe15_04;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ValidateXml {

	public void run(String xmlFile, String validationFile) {
		boolean valid = true;
		SchemaFactory sFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
			Schema schema = sFactory.newSchema(new File(validationFile));
			Validator validator = schema.newValidator();
			Source source = new StreamSource(new File(xmlFile));
			validator.validate(source);
		} catch (SAXException | IOException | IllegalArgumentException ex) {
			valid = false;
		}
		System.out.printf("XML file is %s.\n", valid ? "valid" : "invalid");
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java org.java17recipes.chapter15.recipe15_04.ValidateXml <xmlFile> <validationFile>");
			System.exit(1);
		}
		ValidateXml app = new ValidateXml();
		app.run(args[0], args[1]);
	}
}