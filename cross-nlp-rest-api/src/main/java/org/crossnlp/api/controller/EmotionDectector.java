package org.crossnlp.api.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.crossnlp.api.model.SinglePrediction;
import org.eclipse.scava.nlp.classifiers.emotionclassifier.EmotionClassifier;
import org.eclipse.scava.nlp.tools.predictions.multilabel.MultiLabelPrediction;
import org.eclipse.scava.nlp.tools.predictions.multilabel.MultiLabelPredictionCollection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmotionDectector {

	// private final AtomicLong counter = new AtomicLong();

	@GetMapping("/emotionSingle")
	public MultiLabelPrediction emotionGET(@RequestParam(value = "text", defaultValue = "") String text) {
		try {
			return EmotionClassifier.predict(text);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/emotionSingle")
	public MultiLabelPrediction emotionPOST(@RequestBody String text) {
		// return new SLPrediction(counter.incrementAndGet(), sentence);
		try {
			return EmotionClassifier.predict(text);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/emotion")
	public List<MultiLabelPrediction> emotionGET(@RequestParam(value = "text") String[] texts) {

		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}

		MultiLabelPredictionCollection prediction = null;
		try {
			prediction = EmotionClassifier.predict(Arrays.asList(texts));
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@PostMapping("/emotion")
	public List<MultiLabelPrediction> emotionPOST(@RequestBody String[] texts) {

		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}

		MultiLabelPredictionCollection prediction = null;
		try {
			prediction = EmotionClassifier.predict(Arrays.asList(texts));
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@GetMapping(value = "/emotionIds")
	public List<MultiLabelPrediction> emotionGET(@RequestParam(value = "id") String[] ids,
			@RequestParam(value = "sentence") String[] texts) throws Exception {

		MultiLabelPredictionCollection prediction = new MultiLabelPredictionCollection(ids.length);
		for (int index = 0; index < ids.length; index++) {
			System.out.println(ids[index] + " " + texts[index]);
			prediction.addText(ids[index], texts[index]);
		}

		try {
			prediction = EmotionClassifier.predict(prediction);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@PostMapping(value = "/emotionIds")
	public List<MultiLabelPrediction> emotionPOST(@RequestBody SinglePrediction[] sps) throws Exception {

		MultiLabelPredictionCollection prediction = new MultiLabelPredictionCollection(sps.length);
		for (SinglePrediction sp : sps) {
			System.out.println(sp.getId() + " " + sp.getSentence());
			prediction.addText(sp.getId(), sp.getSentence());
		}

		try {
			prediction = EmotionClassifier.predict(prediction);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

}
