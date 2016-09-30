package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfTest {
	private static String fileName = "PdfReport";
	private static String file_suffix = null;
	private static String tempDirectory ="temp";
	private static String ext = ".pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	public static String createPdf(HttpSession session, String contextPath,
			 ResultSet rs, String fileSuffix) {
		Document document = new Document();
		System.out.println(contextPath);
		String filePath = contextPath + "/"+ tempDirectory
				+ "/"+ fileName + "_" + fileSuffix + ext;
		// String filePath = "\\Work\\WebContent\\temp\\test.pdf";
		System.out.println(filePath);
		try {
			/*
			 * File file = new File("\\Work\\WebContent\\temp\\test.txt");
			 * OutputStream os = new FileOutputStream(file);
			 */
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			/*System.out.println("classpath="
					+ System.getProperty("java.class.path"));*/
			System.out.println("Hey");
			document.open();
			addMetaData(document, session);
			addTitlePage(document, session);
			addContent(document, rs);
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return filePath;

	}

	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document, HttpSession session) {
		document.addTitle("System Generated Report");
		// document.addSubject("Generated by "+session.getAttribute("User").toString());
		// document.addKeywords("Java, PDF, iText");
		document.addAuthor(session.getAttribute("id").toString());
		document.addCreator(session.getAttribute("id").toString());
		System.out.println("Hii");
	}

	private static void addTitlePage(Document document, HttpSession session)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		System.out.println("hello");
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Title of the document", catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface
				.add(new Paragraph(
						"Report generated by: " + session.getAttribute("id").toString() + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						smallBold));
		addEmptyLine(preface, 3);
		preface.add(new Paragraph(
				"This is a system generated report for blah blah blah ",
				smallBold));

		addEmptyLine(preface, 8);

		preface
				.add(new Paragraph(
						"This document is a preliminary version and not subject to your license agreement or any other agreement.",
						redFont));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private static void addContent(Document document, ResultSet rs)
			throws DocumentException {

		System.out.println("Ola");
		PdfPTable table = new PdfPTable(11);
		float[] relativeWidths = {0.09f,0.08f,0.08f,0.08f,0.08f,0.08f,0.08f,0.08f,0.08f,0.08f,0.08f};
		table.setWidths(relativeWidths);
		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);
		ResultSetMetaData rsmd = null;

		try {
			rsmd = rs.getMetaData();

			for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
				PdfPCell c1 = new PdfPCell(new Phrase(rsmd.getColumnName(i)));
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(c1);
			}
			table.setHeaderRows(1);

			while (rs.next()) {
				for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {
					table.addCell(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		document.add(table);

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}