package org.crossnlp.api.controller;

import org.eclipse.scava.nlp.tools.readability.Readability;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadabilityAnalyser {

	@GetMapping("/readability")
	public double readabilityGET(@RequestParam(value = "text", defaultValue = "") String text) {
		return Readability.calculateDaleChall(text);
	}

	@PostMapping("/readability")
	public double readabilityPOST(@RequestBody String text) {
		return Readability.calculateDaleChall(text);
	}

}
