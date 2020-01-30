package org.crossnlp.api.controller;

import java.util.HashMap;
import java.util.List;

import org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreAnalyser {

	@GetMapping("/lemmas")
	public List<String> lemmasGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmas();
	}

	@GetMapping("/lemmatizedText")
	public String lemmatizedTextGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmatizedText();
	}

	@GetMapping("/lemmatizedSentences")
	public List<List<String>> lemmatizedSentencesGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmatizedSentences();
	}

	@GetMapping("/lemmatizedSentencesAsText")
	public List<String> lemmatizedSentencesAsTextGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmatizedSentencesAsText();
	}

	@GetMapping("/POS")
	public List<String> POSGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOS();
	}

	@GetMapping("/POSText")
	public String POSTextGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOSText();
	}

	@GetMapping("/POSSentences")
	public List<List<String>> POSSentencesGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOSSentences();
	}

	@GetMapping("/POSSentencesAsText")
	public List<String> POSSentencesAsTextGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOSSentencesAsText();
	}

	@GetMapping("/tokens")
	public List<String> tokensGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokens();
	}

	@GetMapping("/tokenizedText")
	public String tokenizedTextGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokenizedText();
	}

	@GetMapping("/tokenizedSentences")
	public List<List<String>> tokenizedSentencesGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokenizedSentences();
	}

	@GetMapping("/tokenizedSentencesAsText")
	public List<String> tokenizedSentencesAsTextGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokenizedSentencesAsText();
	}

	@GetMapping("/stats")
	public HashMap<String, Integer> statsGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getStats();
	}

	@PostMapping("/lemmas")
	public List<String> lemmasPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmas();
	}

	@PostMapping("/lemmatizedText")
	public String lemmatizedTextPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmatizedText();
	}

	@PostMapping("/lemmatizedSentences")
	public List<List<String>> lemmatizedSentencesPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmatizedSentences();
	}

	@PostMapping("/lemmatizedSentencesAsText")
	public List<String> lemmatizedSentencesAsTextPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getLemmatizedSentencesAsText();
	}

	@PostMapping("/POS")
	public List<String> POSPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOS();
	}

	@PostMapping("/POSText")
	public String POSTextPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOSText();
	}

	@PostMapping("/POSSentences")
	public List<List<String>> POSSentencesPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOSSentences();
	}

	@PostMapping("/POSSentencesAsText")
	public List<String> POSSentencesAsTextPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getPOSSentencesAsText();
	}

	@PostMapping("/tokens")
	public List<String> tokensPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokens();
	}

	@PostMapping("/tokenizedText")
	public String tokenizedTextPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokenizedText();
	}

	@PostMapping("/tokenizedSentences")
	public List<List<String>> tokenizedSentencesPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokenizedSentences();
	}

	@PostMapping("/tokenizedSentencesAsText")
	public List<String> tokenizedSentencesAsTextPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getTokenizedSentencesAsText();
	}

	@PostMapping("/stats")
	public HashMap<String, Integer> statsPOST(@RequestBody String text) {
		NLPCoreAnalyzer coreAnalyzer = new org.eclipse.scava.nlp.tools.core.NLPCoreAnalyzer(text);
		return coreAnalyzer.getStats();
	}

}
