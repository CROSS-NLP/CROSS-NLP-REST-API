package org.crossnlp.api.controller;
import java.util.HashMap;

import org.crossnlp.api.model.SinglePrediction;
import org.eclipse.scava.nlp.tools.license.LicenseAnalyser;
import org.eclipse.scava.nlp.tools.license.prediction.LicensePrediction;
import org.eclipse.scava.nlp.tools.license.prediction.LicensePredictionCollection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseDetector {

	@GetMapping("/hasLicense")
	public boolean hasLicenseGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseFound();
	}

	@PostMapping("/hasLicense")
	public boolean hasLicensePOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseFound();
	}

	@GetMapping("/licenseGroup")
	public String licenseGroupGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseGroup();
	}

	@PostMapping("/licenseGroup")
	public String licenseGroupPOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseGroup();
	}

	@GetMapping("/licenseName")
	public String licenseNameGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseName();
	}

	@PostMapping("/licenseName")
	public String licenseNamePOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseName();
	}

	@GetMapping("/isHeader")
	public boolean isHeaderGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getIsHeader();
	}

	@PostMapping("/isHeader")
	public boolean isHeaderPOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getIsHeader();
	}

	@GetMapping("/ngramsMatchedPercent")
	public double ngramsMatchedPercentGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getNgramsMatchedPercent();
	}

	@PostMapping("/ngramsMatchedPercent")
	public double ngramsMatchedPercentPOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getNgramsMatchedPercent();
	}

	@GetMapping("/licenseFound")
	public boolean licenseFoundGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseFound();
	}

	@PostMapping("/licenseFound")
	public boolean licenseFoundPOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getLicenseFound();
	}

	@GetMapping("/predictionScore")
	public double predictionScoreGET(@RequestParam(value = "text", defaultValue = "") String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getScore();
	}

	@PostMapping("/predictionScore")
	public double predictionScorePOST(@RequestBody String text) {
		LicensePrediction prediction = new LicensePrediction(text);
		prediction = LicenseAnalyser.predict(prediction);
		return prediction.getScore();
	}

	@GetMapping("/license")
	public HashMap<Object, String> licenseGET(@RequestParam(value = "text") String[] texts) {
		LicensePredictionCollection collection = new LicensePredictionCollection(texts.length);
		int index = 0;
		for (String text : texts) {
			collection.addText(Integer.toString(index), text);
			System.out.println((++index) + " " + text);
		}
		LicensePredictionCollection prediction = LicenseAnalyser.predict(collection);
		return prediction.getIdsWithPredictedLabel();
	}

	@PostMapping("/license")
	public HashMap<Object, String> licensePOST(@RequestBody String[] texts) {
		LicensePredictionCollection collection = new LicensePredictionCollection(texts.length);
		int index = 0;
		for (String text : texts) {
			collection.addText(Integer.toString(index), text);
			System.out.println((++index) + " " + text);
		}
		LicensePredictionCollection prediction = LicenseAnalyser.predict(collection);
		return prediction.getIdsWithPredictedLabel();
	}

	@GetMapping(value = "/licenseIds")
	public HashMap<Object, String> licenseGET(@RequestParam(value = "id") String[] ids,
			@RequestParam(value = "text") String[] texts) throws Exception {
		LicensePredictionCollection collection = new LicensePredictionCollection(texts.length);
		for (int index = 0; index < ids.length; index++) {
			System.out.println(ids[index] + " " + texts[index]);
			collection.addText(ids[index], texts[index]);
		}
		LicensePredictionCollection prediction = LicenseAnalyser.predict(collection);
		return prediction.getIdsWithPredictedLabel();
	}

	@PostMapping(value = "/licenseIds")
	public HashMap<Object, String> licensePOST(@RequestBody SinglePrediction[] sps) throws Exception {
		LicensePredictionCollection collection = new LicensePredictionCollection(sps.length);
		for (SinglePrediction sp : sps) {
			System.out.println(sp.getId() + " " + sp.getSentence());
			collection.addText(sp.getId(), sp.getSentence());
		}
		LicensePredictionCollection prediction = LicenseAnalyser.predict(collection);
		return prediction.getIdsWithPredictedLabel();
	}

}
