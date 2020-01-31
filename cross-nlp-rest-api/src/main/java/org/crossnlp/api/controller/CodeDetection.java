package org.crossnlp.api.controller;

import java.util.Arrays;
import java.util.List;

import org.crossnlp.api.model.SinglePrediction;
import org.eclipse.scava.nlp.classifiers.codedetector.CodeDetector;
import org.eclipse.scava.nlp.tools.predictions.singlelabel.SingleLabelPrediction;
import org.eclipse.scava.nlp.tools.predictions.singlelabel.SingleLabelPredictionCollection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class CodeDetection {
	

	// private final AtomicLong counter = new AtomicLong();

	@GetMapping("/codeSingle")
	public SingleLabelPrediction codeGET(@RequestParam(value = "text", defaultValue = "") String text) {
		return CodeDetector.predict(text);
	}

	@PostMapping("/codeSingle")
	public SingleLabelPrediction codePOST(@RequestBody String text) {
		return CodeDetector.predict(text);
	}
	@ApiOperation(notes = "classifies text as natural laguage or code", value = "text")
	@GetMapping("/code")
	public List<SingleLabelPrediction> codeGET(@RequestParam(value = "text") String[] texts) {
		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}
		SingleLabelPredictionCollection prediction = CodeDetector.predict(Arrays.asList(texts));
		return prediction.getPredictionCollection();
	}

	@PostMapping("/code")
	public List<SingleLabelPrediction> codePOST(@RequestBody String[] texts) {
		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}
		SingleLabelPredictionCollection prediction = CodeDetector.predict(Arrays.asList(texts));
		return prediction.getPredictionCollection();
	}

	@GetMapping(value = "/codeIds")
	public List<SingleLabelPrediction> codeGET(@RequestParam(value = "id") String[] ids,
			@RequestParam(value = "t") String[] texts) throws Exception {
		SingleLabelPredictionCollection prediction = new SingleLabelPredictionCollection(ids.length);
		for (int index = 0; index < ids.length; index++) {
			System.out.println(ids[index] + " " + texts[index]);
			prediction.addText(ids[index], texts[index]);
		}
		prediction = CodeDetector.predict(prediction);
		return prediction.getPredictionCollection();
	}

	@PostMapping(value = "/codeIds")
	public List<SingleLabelPrediction> codePOST(@RequestBody SinglePrediction[] sps) throws Exception {
		SingleLabelPredictionCollection prediction = new SingleLabelPredictionCollection(sps.length);
		for (SinglePrediction sp : sps) {
			System.out.println(sp.getId() + " " + sp.getSentence());
			prediction.addText(sp.getId(), sp.getSentence());
		}
		prediction = CodeDetector.predict(prediction);
		return prediction.getPredictionCollection();
	}

}
