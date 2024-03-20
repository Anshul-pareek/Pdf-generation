package com.ebit.testcode.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebit.testcode.service.PdfGenerationService;

@RestController
@RequestMapping("/pdf")
public class PdfController {

	@Autowired
	private PdfGenerationService pdfGenerationService;

	@GetMapping(value = "/generate", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<byte[]> generatePdf() {
		try {
			byte[] pdfBytes = pdfGenerationService.generatePdfFromHtmlTemplate();
			return ResponseEntity.ok().body(pdfBytes);
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(null);
		}
	}
}