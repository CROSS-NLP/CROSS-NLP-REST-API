package org.crossnlp.api.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.crossnlp.api.model.SinglePrediction;
import org.eclipse.scava.nlp.classifiers.sentimentanalyzer.SentimentAnalyzer;
import org.eclipse.scava.nlp.tools.predictions.singlelabel.SingleLabelPrediction;
import org.eclipse.scava.nlp.tools.predictions.singlelabel.SingleLabelPredictionCollection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentimentAnalyser {

	// private final AtomicLong counter = new AtomicLong();

	@GetMapping("/sentimentSingle")
	public SingleLabelPrediction sentimentGET(@RequestParam(value = "text", defaultValue = "") String text) {
		// return new SLPrediction(counter.incrementAndGet(), sentence);
		try {
			return SentimentAnalyzer.predict(text);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping("/sentimentSingle")
	public SingleLabelPrediction sentimentPOST(@RequestBody String text) {
		// return new SLPrediction(counter.incrementAndGet(), sentence);
		try {
			return SentimentAnalyzer.predict(text);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/sentiment")
	public List<SingleLabelPrediction> sentimentGET(@RequestParam(value = "text") String[] texts) {

		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}

		SingleLabelPredictionCollection prediction = null;
		try {
			prediction = SentimentAnalyzer.predict(Arrays.asList(texts));
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@PostMapping("/sentiment")
	public List<SingleLabelPrediction> sentimentPOST(@RequestBody String[] texts) {

		int index = 0;
		for (String text : texts) {
			System.out.println((++index) + " " + text);
		}

		SingleLabelPredictionCollection prediction = null;
		try {
			prediction = SentimentAnalyzer.predict(Arrays.asList(texts));
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@GetMapping(value = "/sentimentIds")
	public List<SingleLabelPrediction> sentimentGET(@RequestParam(value = "id") String[] ids,
			@RequestParam(value = "sentence") String[] texts) throws Exception {

		SingleLabelPredictionCollection prediction = new SingleLabelPredictionCollection(ids.length);
		for (int index = 0; index < ids.length; index++) {
			System.out.println(ids[index] + " " + texts[index]);
			prediction.addText(ids[index], texts[index]);
		}

		try {
			prediction = SentimentAnalyzer.predict(prediction);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

	@PostMapping(value = "/sentimentIds")
	public List<SingleLabelPrediction> sentimentPOST(@RequestBody SinglePrediction[] sps) throws Exception {

		SingleLabelPredictionCollection prediction = new SingleLabelPredictionCollection(sps.length);
		for (SinglePrediction sp : sps) {
			System.out.println(sp.getId() + " " + sp.getSentence());
			prediction.addText(sp.getId(), sp.getSentence());
		}

		try {
			prediction = SentimentAnalyzer.predict(prediction);
		} catch (IOException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return prediction.getPredictionCollection();
	}

}
