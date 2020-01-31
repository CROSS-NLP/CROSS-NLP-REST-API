package org.crossnlp.api.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.crossnlp.api.model.SinglePrediction;
import org.eclipse.scava.nlp.classifiers.requestreplydetector.RequestReplyClassifier;
import org.eclipse.scava.nlp.tools.predictions.singlelabel.SingleLabelPrediction;
import org.eclipse.scava.nlp.tools.predictions.singlelabel.SingleLabelPredictionCollection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestReplyDetection {

	// private final AtomicLong counter = new AtomicLong();

	@GetMapping("/requestReplySingle")
	public SingleLabelPrediction requestReplyGET(@RequestParam(value = "text", defaultValue = "") String text) {
		SingleLabelPrediction prediction = null;
		try {
			prediction = RequestReplyClassifier.predict(text, false, false);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prediction;
	}

	@PostMapping("/requestReplySingle")
	public SingleLabelPrediction requestReplyPOST(@RequestBody String text) {
		SingleLabelPrediction prediction = null;
		try {
			prediction = RequestReplyClassifier.predict(text);
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prediction;
	}

	@GetMapping("/requestReply")
	public List<SingleLabelPrediction> requestReplyGET(@RequestParam(value = "text") String[] texts) {
		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}
		SingleLabelPredictionCollection prediction = null;
		try {
			prediction = RequestReplyClassifier.predict(Arrays.asList(texts));
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@PostMapping("/requestReply")
	public List<SingleLabelPrediction> requestReplyPOST(@RequestBody String[] texts) {
		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}
		SingleLabelPredictionCollection prediction = null;
		try {
			prediction = RequestReplyClassifier.predict(Arrays.asList(texts));
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@GetMapping(value = "/requestReplyIds")
	public List<SingleLabelPrediction> requestReplyGET(@RequestParam(value = "id") String[] ids,
			@RequestParam(value = "text") String[] texts) throws Exception {
		SingleLabelPredictionCollection prediction = new SingleLabelPredictionCollection(ids.length);
		for (int index = 0; index < ids.length; index++) {
			System.out.println(ids[index] + " " + texts[index]);
			prediction.addText(ids[index], texts[index]);
		}
		prediction = RequestReplyClassifier.predict(prediction);
		return prediction.getPredictionCollection();
	}

	@PostMapping(value = "/requestReplyIds")
	public List<SingleLabelPrediction> requestReplyPOST(@RequestBody SinglePrediction[] sps) throws Exception {
		SingleLabelPredictionCollection prediction = new SingleLabelPredictionCollection(sps.length);
		for (SinglePrediction sp : sps) {
			System.out.println(sp.getId() + " " + sp.getSentence());
			prediction.addText(sp.getId(), sp.getSentence());
		}
		prediction = RequestReplyClassifier.predict(prediction);
		return prediction.getPredictionCollection();
	}

}
