package org.crossnlp.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.scava.nlp.resources.sentinet5.SenticNet5;
import org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SenticnetAnalyser {

	@GetMapping("/analysis")
	public List<Entry<String, HashMap<String, Double>>> analysisGET(
			@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return SenticNet5.analyzeText(coreAnalyzer);
	}

	@PostMapping("/analysis")
	public List<Entry<String, HashMap<String, Double>>> analysisPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return SenticNet5.analyzeText(coreAnalyzer);
	}

}
