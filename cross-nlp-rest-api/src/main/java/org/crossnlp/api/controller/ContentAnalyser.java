package org.crossnlp.api.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.crossnlp.api.model.Instance;
import org.eclipse.scava.contentclassifier.opennlptartarus.libsvm.ClassificationInstance;
import org.eclipse.scava.contentclassifier.opennlptartarus.libsvm.Classifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentAnalyser {

	@GetMapping("/contentSingle")
	public String contentGET(@RequestParam(value = "newsgroup", defaultValue = "") String newsgroup,
			@RequestParam(value = "threadId", defaultValue = "") int threadId,
			@RequestParam(value = "positionFromThreadBeginning", defaultValue = "") int positionFromThreadBeginning,
			@RequestParam(value = "subject", defaultValue = "") String subject,
			@RequestParam(value = "text", defaultValue = "") String text) throws IOException {
		Classifier classifier = new Classifier();
		ClassificationInstance instance = new ClassificationInstance();
		instance.setNewsgroupName(newsgroup);
		instance.setThreadId(threadId);
		instance.setPositionFromThreadBeginning(2);
		instance.setSubject(subject);
		instance.setText(text);
		classifier.add(instance);
		classifier.classify();
		return classifier.getClassificationResult(instance);
	}

	@PostMapping("/contentSingle")
	public String contentPOST(@RequestBody Instance inst) throws IOException {
		Classifier classifier = new Classifier();
		ClassificationInstance instance = new ClassificationInstance();
		instance.setNewsgroupName(inst.getNewsgroup());
		instance.setThreadId(inst.getThreadId());
		instance.setPositionFromThreadBeginning(inst.getPositionFromThreadBeginning());
		instance.setSubject(inst.getSubject());
		instance.setText(inst.getText());
		classifier.add(instance);
		classifier.classify();
		return classifier.getClassificationResult(instance);
	}

	@GetMapping("/content")
	public List<String> contentGET(@RequestParam(value = "newsgroup", defaultValue = "") String[] newsgroup,
			@RequestParam(value = "threadId", defaultValue = "") int[] threadId,
			@RequestParam(value = "positionFromThreadBeginning", defaultValue = "") int[] positionFromThreadBeginning,
			@RequestParam(value = "subject", defaultValue = "") String[] subject,
			@RequestParam(value = "text", defaultValue = "") String[] text) throws IOException {
		List<ClassificationInstance> instances = new ArrayList<ClassificationInstance>(text.length);
		Classifier classifier = new Classifier();
		for (int index = 0; index < text.length; index++) {
			ClassificationInstance instance = new ClassificationInstance();
			instance.setNewsgroupName(newsgroup[index]);
			instance.setThreadId(threadId[index]);
			instance.setPositionFromThreadBeginning(positionFromThreadBeginning[index]);
			instance.setSubject(subject[index]);
			instance.setText(text[index]);
			classifier.add(instance);
			instances.add(instance);
		}
		classifier.classify();
		List<String> results = new ArrayList<String>(text.length);
		for (ClassificationInstance instance : instances) {
			results.add(classifier.getClassificationResult(instance));
		}
		return results;
	}

	@PostMapping("/content")
	public List<String> contentPOST(@RequestBody Instance[] insts) throws IOException {
		List<ClassificationInstance> instances = new ArrayList<ClassificationInstance>(insts.length);
		Classifier classifier = new Classifier();
		for (Instance inst : insts) {
			ClassificationInstance instance = new ClassificationInstance();
			instance.setNewsgroupName(inst.getNewsgroup());
			instance.setThreadId(inst.getThreadId());
			instance.setSubject(inst.getSubject());
			instance.setText(inst.getText());
			classifier.add(instance);
			instances.add(instance);
		}
		classifier.classify();
		List<String> results = new ArrayList<String>(insts.length);
		for (ClassificationInstance instance : instances) {
			results.add(classifier.getClassificationResult(instance));
		}
		return results;
	}

}
