package com.ebit.testcode.service;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;

@Service
public class PdfGenerationService {

	String str1 = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<style>\r\n" + "table, th, td {\r\n"
			+ "  border:1px solid black;\r\n" + "}\r\n" + "</style>\r\n" + "<body>\r\n" + "\r\n"
			+ "<h2>TH elements define table headers</h2>\r\n" + "\r\n" + "<table style=\"width:100%\">\r\n"
			+ "  <tr>\r\n" + "    <th>Person 1</th>\r\n" + "    <th>Person 2</th>\r\n" + "    <th>Person 3</th>\r\n"
			+ "  </tr>\r\n" + "  <tr>\r\n" + "    <td>Emil</td>\r\n" + "    <td>Tobias</td>\r\n"
			+ "    <td>Linus</td>\r\n" + "  </tr>\r\n" + "  <tr>\r\n" + "    <td>16</td>\r\n" + "    <td>14</td>\r\n"
			+ "    <td>10</td>\r\n" + "  </tr>\r\n" + "</table>\r\n" + "\r\n"
			+ "<p>To understand the example better, we have added borders to the table.</p>\r\n" + "\r\n"
			+ "</body>\r\n" + "</html>\r\n" + "\r\n";



	public byte[] generatePdfFromHtmlTemplate() throws FileNotFoundException {
		try (PdfWriter writer = new PdfWriter("output.pdf")) {
			PdfDocument pdfDocument = new PdfDocument(writer);
//			InputStream inputStream = new ByteArrayInputStream(str1.getBytes());
			ConverterProperties converterProperties = new ConverterProperties();
			HtmlConverter.convertToPdf(str1, pdfDocument, converterProperties);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			HtmlConverter.convertToPdf(str1, outputStream);
			return outputStream.toByteArray();

		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
			return null;
		}
	}

}
