package org.crossnlp.api.controller;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.scava.severityclassifier.opennlptartarus.libsvm.Classifier;
import org.eclipse.scava.severityclassifier.opennlptartarus.libsvm.ClassifierMessage;
import org.crossnlp.api.model.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeverityPrediction {

	@GetMapping("/severitySingle")
	public String severityGET(@RequestParam(value = "newsgroup", defaultValue = "") String newsgroup,
			@RequestParam(value = "threadId", defaultValue = "") int threadId,
			@RequestParam(value = "subject", defaultValue = "") String subject,
			@RequestParam(value = "text", defaultValue = "") String text) {
		Classifier classifier = new Classifier();
		ClassifierMessage msg = new ClassifierMessage();
		msg.setNewsgroupName(newsgroup);
		msg.setThreadId(threadId);
		msg.setSubject(subject);
		msg.setText(text);
		classifier.add(msg);
		classifier.classify();
		return classifier.getClassificationResult(msg);
	}

	@PostMapping("/severitySingle")
	public String severityPOST(@RequestBody Message message) {
		Classifier classifier = new Classifier();
		ClassifierMessage msg = new ClassifierMessage();
		msg.setNewsgroupName(message.getNewsgroup());
		msg.setThreadId(message.getThreadId());
		msg.setSubject(message.getSubject());
		msg.setText(message.getText());
		classifier.add(msg);
		classifier.classify();
		return classifier.getClassificationResult(msg);
	}

	@GetMapping("/severity")
	public List<String> severityGET(@RequestParam(value = "newsgroup", defaultValue = "") String[] newsgroup,
			@RequestParam(value = "threadId", defaultValue = "") int[] threadId,
			@RequestParam(value = "subject", defaultValue = "") String[] subject,
			@RequestParam(value = "text", defaultValue = "") String[] text) {
		List<ClassifierMessage> msgs = new ArrayList<ClassifierMessage>(text.length);
		Classifier classifier = new Classifier();
		for (int index = 0; index < text.length; index++) {
			ClassifierMessage msg = new ClassifierMessage();
			msg.setNewsgroupName(newsgroup[index]);
			msg.setThreadId(threadId[index]);
			msg.setSubject(subject[index]);
			msg.setText(text[index]);
			classifier.add(msg);
			msgs.add(msg);
		}
		classifier.classify();
		List<String> results = new ArrayList<String>(text.length);
		for (ClassifierMessage msg : msgs) {
			results.add(classifier.getClassificationResult(msg));
		}
		return results;
	}

	@PostMapping("/severity")
	public List<String> severityPOST(@RequestBody Message[] messages) {
		List<ClassifierMessage> msgs = new ArrayList<ClassifierMessage>(messages.length);
		Classifier classifier = new Classifier();
		for (Message message : messages) {
			ClassifierMessage msg = new ClassifierMessage();
			msg.setNewsgroupName(message.getNewsgroup());
			msg.setThreadId(message.getThreadId());
			msg.setSubject(message.getSubject());
			msg.setText(message.getText());
			classifier.add(msg);
			msgs.add(msg);
		}
		classifier.classify();
		List<String> results = new ArrayList<String>(messages.length);
		for (ClassifierMessage msg : msgs) {
			results.add(classifier.getClassificationResult(msg));
		}
		return results;
	}

}
