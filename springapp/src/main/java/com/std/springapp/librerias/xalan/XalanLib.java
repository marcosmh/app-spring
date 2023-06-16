package com.std.springapp.librerias.xalan;

import java.io.*;
import java.io.FileOutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.Result;

import javax.xml.XMLConstants;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.xml.utils.DefaultErrorHandler;



public class XalanLib {
	
	
	public static void main(String[] args) {
		
		
		//transformerFactory();
		//testxml(args);
		transformFactory();
		
		
	}
	
	public static void testxml(String[] args)  {
		String stylesheetPathname = args[0];
		String inputPathname = args[1];
	    String outputPathname = args[2];

	    TransformerFactory factory = TransformerFactory.newInstance();
	    Source stylesheetSource = new StreamSource(new File(stylesheetPathname).getAbsoluteFile());
	    Transformer transformer = null;
		try {
			transformer = factory.newTransformer(stylesheetSource);
		} catch (TransformerConfigurationException e) {
			//e.printStackTrace();
			System.out.println("TransformerConfigurationException:  "+e.getMessage());
		}
	    Source inputSource = new StreamSource(new File(inputPathname).getAbsoluteFile());
	    Result outputResult = new StreamResult(new File(outputPathname).getAbsoluteFile());
	    try {
			transformer.transform(inputSource, outputResult);
		} catch (TransformerException e) {
			//e.printStackTrace();
			System.out.println("TransformerException: " + e.getMessage());
		}
	}

	private static void transformerFactory() {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer(new StreamSource("transform.xslt"));
			transformer.transform(new StreamSource("input.xml"), new StreamResult(new FileOutputStream("output.out")));
			System.out.println("************* The result is in output.out *************");
		} catch (Throwable t) {
			//t.printStackTrace();
			System.out.println("Throwable: " + t.getMessage());
		}
	}
	
		
	private static void transformFactory()  {
		
		String XSL = 
				"<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n" +
			            "  <xsl:output method=\"html\"/>\n" +
			            "  <xsl:template match=\"/*\">\n" +
			            "    <th colspan=\"2\"/>\n" +
			            "  </xsl:template>\n" +
			            "</xsl:stylesheet>";
		
	    System.setProperty( "javax.xml.transform.TransformerFactory", 
	    					"org.apache.xalan.processor.TransformerFactoryImpl" );

        TransformerFactory tf = TransformerFactory.newInstance();
        try {
			tf.setFeature( XMLConstants.FEATURE_SECURE_PROCESSING, true);
		} catch (TransformerConfigurationException e) {		
			//e.printStackTrace();
			System.out.println("TransformerConfigurationException: " + e.getMessage());
		}
        tf.setErrorListener( new DefaultErrorHandler( true ) );

        final Source source = new StreamSource( new StringReader( XSL ) );
        try {
			Templates templates = tf.newTemplates( source );
		} catch (TransformerConfigurationException e) {
			//e.printStackTrace();
			System.out.println("TransformerConfigurationException: " + e.getMessage());
		}
	}


}
