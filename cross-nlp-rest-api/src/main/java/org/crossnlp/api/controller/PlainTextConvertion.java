package org.crossnlp.api.controller;

import java.util.List;

import org.eclipse.scava.nlp.tools.plaintext.PlainTextObject;
import org.eclipse.scava.nlp.tools.plaintext.bugtrackers.PlainTextBugTrackerMarkdownBased;
import org.eclipse.scava.nlp.tools.plaintext.bugtrackers.PlainTextBugTrackersOthers;
import org.eclipse.scava.nlp.tools.plaintext.bugtrackers.PlainTextBugzilla;
import org.eclipse.scava.nlp.tools.plaintext.bugtrackers.PlainTextRedmine;
import org.eclipse.scava.nlp.tools.plaintext.commitsmessages.PlainTextCommitsMessagesMarkdownBased;
import org.eclipse.scava.nlp.tools.plaintext.communicationchannels.PlainTextEclipseForums;
import org.eclipse.scava.nlp.tools.plaintext.communicationchannels.PlainTextNewsgroups;
import org.eclipse.scava.nlp.tools.plaintext.communicationchannels.PlainTextNewsgroupsSubject;
import org.eclipse.scava.nlp.tools.plaintext.documentation.PlainTextDocumentationHtmlBased;
import org.eclipse.scava.nlp.tools.plaintext.documentation.PlainTextDocumentationOthers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlainTextConvertion {

	@GetMapping("/plainTextBugTrackerMarkdown")
	public List<String> plainTextBugTrackerMarkdownGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextBugTrackerMarkdownBased.process(text);
		return plain.getPlainTextAsList();
	}
	
	@GetMapping("/repliesBugTrackerMarkdown")
	public boolean repliesBugTrackerMarkdownGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextBugTrackerMarkdownBased.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextBugTrackersOthers")
	public List<String> plainTextBugTrackersOthersGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextBugTrackersOthers.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesBugTrackersOthers")
	public boolean repliesBugTrackersOthersGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextBugTrackersOthers.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextBugzilla")
	public List<String> plainTextBugzillaGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextBugzilla.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesBugzilla")
	public boolean repliesBugzillaGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextBugzilla.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextRedmine")
	public List<String> plainTextRedmineGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextRedmine.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesRedmine")
	public boolean repliesRedmineGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextRedmine.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextCommitsMessagesMarkdownBased")
	public List<String> plainTextCommitsMessagesMarkdownBasedGET(
			@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextCommitsMessagesMarkdownBased.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesCommitsMessagesMarkdownBased")
	public boolean repliesCommitsMessagesMarkdownBasedGET(
			@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextCommitsMessagesMarkdownBased.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextEclipseForums")
	public List<String> plainTextEclipseForumsGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextEclipseForums.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesEclipseForums")
	public boolean repliesEclipseForumsGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextEclipseForums.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextNewsgroups")
	public List<String> plainTextNewsgroupsGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextNewsgroups.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesNewsgroups")
	public boolean repliesNewsgroupsGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextNewsgroups.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextNewsgroupsSubject")
	public String plainTextNewsgroupsSubjectGET(@RequestParam(value = "text", defaultValue = "") String text) {
		return PlainTextNewsgroupsSubject.process(text);
	}

	@GetMapping("/plainTextDocumentationHtmlBased")
	public List<String> plainTextDocumentationHtmlBasedGET(
			@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextDocumentationHtmlBased.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesDocumentationHtmlBased")
	public boolean repliesDocumentationHtmlBasedGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextDocumentationHtmlBased.process(text);
		return plain.hadReplies();
	}

	@GetMapping("/plainTextDocumentationOthers")
	public List<String> plainTextDocumentationOthersGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextDocumentationOthers.process(text);
		return plain.getPlainTextAsList();
	}

	@GetMapping("/repliesDocumentationOthers")
	public boolean repliesDocumentationOthersGET(@RequestParam(value = "text", defaultValue = "") String text) {
		PlainTextObject plain = PlainTextDocumentationOthers.process(text);
		return plain.hadReplies();
	}

	// @PostMapping("/bugsInBitBucket")
	// public Set<String> bugsInBitBucketPOST(@RequestBody String text) {
	// NormalizedReferences references = ReferencesInBitBucket.findReferences(text);
	// return references.getNormalizedBugsReferences();
	// }

	@PostMapping("/plainTextBugTrackerMarkdown")
	public List<String> plainTextBugTrackerMarkdownPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextBugTrackerMarkdownBased.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesBugTrackerMarkdown")
	public boolean repliesBugTrackerMarkdownPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextBugTrackerMarkdownBased.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextBugTrackersOthers")
	public List<String> plainTextBugTrackersOthersPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextBugTrackersOthers.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesBugTrackersOthers")
	public boolean repliesBugTrackersOthersPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextBugTrackersOthers.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextBugzilla")
	public List<String> plainTextBugzillaPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextBugzilla.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesBugzilla")
	public boolean repliesBugzillaPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextBugzilla.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextRedmine")
	public List<String> plainTextRedminePOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextRedmine.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesRedmine")
	public boolean repliesRedminePOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextRedmine.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextCommitsMessagesMarkdownBased")
	public List<String> plainTextCommitsMessagesMarkdownBasedPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextCommitsMessagesMarkdownBased.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesCommitsMessagesMarkdownBased")
	public boolean repliesCommitsMessagesMarkdownBasedPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextCommitsMessagesMarkdownBased.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextEclipseForums")
	public List<String> plainTextEclipseForumsPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextEclipseForums.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesEclipseForums")
	public boolean repliesEclipseForumsPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextEclipseForums.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextNewsgroups")
	public List<String> plainTextNewsgroupsPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextNewsgroups.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesNewsgroups")
	public boolean repliesNewsgroupsPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextNewsgroups.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextNewsgroupsSubject")
	public String plainTextNewsgroupsSubjectPOST(@RequestBody String text) {
		return PlainTextNewsgroupsSubject.process(text);
	}

	@PostMapping("/plainTextDocumentationHtmlBased")
	public List<String> plainTextDocumentationHtmlBasedPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextDocumentationHtmlBased.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesDocumentationHtmlBased")
	public boolean repliesDocumentationHtmlBasedPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextDocumentationHtmlBased.process(text);
		return plain.hadReplies();
	}

	@PostMapping("/plainTextDocumentationOthers")
	public List<String> plainTextDocumentationOthersPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextDocumentationOthers.process(text);
		return plain.getPlainTextAsList();
	}

	@PostMapping("/repliesDocumentationOthers")
	public boolean repliesDocumentationOthersPOST(@RequestBody String text) {
		PlainTextObject plain = PlainTextDocumentationOthers.process(text);
		return plain.hadReplies();
	}
}
