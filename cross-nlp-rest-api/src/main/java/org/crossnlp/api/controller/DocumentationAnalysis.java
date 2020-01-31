package org.crossnlp.api.controller;

import org.eclipse.scava.nlp.classifiers.documentation.DocumentationClassifier;
import org.eclipse.scava.nlp.tools.predictions.multilabel.MultiLabelPrediction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentationAnalysis {

	// private final AtomicLong counter = new AtomicLong();

	@GetMapping("/documentation")
	public MultiLabelPrediction documentationGET(@RequestParam(value = "text", defaultValue = "") String text) {
		MultiLabelPrediction prediction = new MultiLabelPrediction(text);
		prediction = DocumentationClassifier.classify(prediction, false);
		return prediction;
	}

	@PostMapping("/documentation")
	public MultiLabelPrediction requestReplyPOST(@RequestBody String text) {
		MultiLabelPrediction prediction = new MultiLabelPrediction(text);
		prediction = DocumentationClassifier.classify(prediction, false);
		return prediction;
	}

}
