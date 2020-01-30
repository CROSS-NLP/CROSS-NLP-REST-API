package org.crossnlp.api.controller;

import java.util.Set;

import org.crossnlp.api.model.TextOwnerRepository;
import org.crossnlp.api.model.TextUrl;
import org.eclipse.scava.nlp.tools.references.NormalizedReferences;
import org.eclipse.scava.nlp.tools.references.bitbucket.ReferencesInBitBucket;
import org.eclipse.scava.nlp.tools.references.bugzilla.ReferencesInBugzilla;
import org.eclipse.scava.nlp.tools.references.git.ReferencesInGitSVN;
import org.eclipse.scava.nlp.tools.references.github.ReferencesInGitHub;
import org.eclipse.scava.nlp.tools.references.gitlab.ReferencesInGitLab;
import org.eclipse.scava.nlp.tools.references.jira.ReferencesInJira;
import org.eclipse.scava.nlp.tools.references.redmine.ReferencesInRedmine;
import org.eclipse.scava.nlp.tools.references.sourceforge.ReferencesInSourceforge;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReferencesDetector {

	@GetMapping("/bugsInBitBucket")
	public Set<String> bugsInBitBucketGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NormalizedReferences references = ReferencesInBitBucket.findReferences(text);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInBitBucket")
	public Set<String> commitsInBitBucketGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NormalizedReferences references = ReferencesInBitBucket.findReferences(text);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInBugzilla")
	public Set<String> bugsInBugzillaGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInBugzilla.findReferences(text, url);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInBugzilla")
	public Set<String> commitsInBugzillaGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInBugzilla.findReferences(text, url);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInGitSVN")
	public Set<String> bugsInGitSVNGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInGitSVN.findReferences(text, url);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInGitSVN")
	public Set<String> commitsInGitSVNGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInGitSVN.findReferences(text, url);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInGitHub")
	public Set<String> bugsInGitHubGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "owner", defaultValue = "") String owner,
			@RequestParam(value = "repository", defaultValue = "") String repository) {
		NormalizedReferences references = ReferencesInGitHub.findReferences(text, owner, repository);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInGitHub")
	public Set<String> commitsInGitHubGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "owner", defaultValue = "") String owner,
			@RequestParam(value = "repository", defaultValue = "") String repository) {
		NormalizedReferences references = ReferencesInGitHub.findReferences(text, owner, repository);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInGitLab")
	public Set<String> bugsInGitLabGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInGitLab.findReferences(text, url);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInGitLab")
	public Set<String> commitsInGitLabGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInGitLab.findReferences(text, url);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInJira")
	public Set<String> bugsInJiraGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url,
			@RequestParam(value = "repository", defaultValue = "") String repository) {
		NormalizedReferences references = ReferencesInJira.findReferences(text, url, repository);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInJira")
	public Set<String> commitsInJiraGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url,
			@RequestParam(value = "repository", defaultValue = "") String repository) {
		NormalizedReferences references = ReferencesInJira.findReferences(text, url, repository);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInRedmine")
	public Set<String> bugsInRedmineGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInRedmine.findReferences(text, url);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInRedmine")
	public Set<String> commitsInRedmineGET(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "url", defaultValue = "") String url) {
		NormalizedReferences references = ReferencesInRedmine.findReferences(text, url);
		return references.getNormalizedCommitsReferences();
	}

	@GetMapping("/bugsInSourceforge")
	public Set<String> bugsInSourceforgeGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NormalizedReferences references = ReferencesInSourceforge.findReferences(text);
		return references.getNormalizedBugsReferences();
	}

	@GetMapping("/commitsInSourceforge")
	public Set<String> commitsInSourceforgeGET(@RequestParam(value = "text", defaultValue = "") String text) {
		NormalizedReferences references = ReferencesInSourceforge.findReferences(text);
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInBitBucket")
	public Set<String> bugsInBitBucketPOST(@RequestBody String text) {
		NormalizedReferences references = ReferencesInBitBucket.findReferences(text);
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInBitBucket")
	public Set<String> commitsInBitBucketPOST(@RequestBody String text) {
		NormalizedReferences references = ReferencesInBitBucket.findReferences(text);
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInBugzilla")
	public Set<String> bugsInBugzillaPOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInBugzilla.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInBugzilla")
	public Set<String> commitsInBugzillaPOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInBugzilla.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInGitSVN")
	public Set<String> bugsInGitSVNPOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInGitSVN.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInGitSVN")
	public Set<String> commitsInGitSVNPOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInGitSVN.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInGitHub")
	public Set<String> bugsInGitHubPOST(@RequestBody TextOwnerRepository input) {
		NormalizedReferences references = ReferencesInGitHub.findReferences(input.getText(), input.getOwner(),
				input.getRepository());
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInGitHub")
	public Set<String> commitsInGitHubPOST(@RequestBody TextOwnerRepository input) {
		NormalizedReferences references = ReferencesInGitHub.findReferences(input.getText(), input.getOwner(),
				input.getRepository());
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInGitLab")
	public Set<String> bugsInGitLabPOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInGitLab.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInGitLab")
	public Set<String> commitsInGitLabPOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInGitLab.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInJira")
	public Set<String> bugsInJiraPOST(@RequestBody TextOwnerRepository input) {
		NormalizedReferences references = ReferencesInJira.findReferences(input.getText(), input.getOwner(),
				input.getRepository());
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInJira")
	public Set<String> commitsInJiraPOST(@RequestBody TextOwnerRepository input) {
		NormalizedReferences references = ReferencesInJira.findReferences(input.getText(), input.getOwner(),
				input.getRepository());
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInRedmine")
	public Set<String> bugsInRedminePOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInRedmine.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInRedmine")
	public Set<String> commitsInRedminePOST(@RequestBody TextUrl input) {
		NormalizedReferences references = ReferencesInRedmine.findReferences(input.getText(), input.getUrl());
		return references.getNormalizedCommitsReferences();
	}

	@PostMapping("/bugsInSourceforge")
	public Set<String> bugsInSourceforgePOST(@RequestBody String text) {
		NormalizedReferences references = ReferencesInSourceforge.findReferences(text);
		return references.getNormalizedBugsReferences();
	}

	@PostMapping("/commitsInSourceforge")
	public Set<String> commitsInSourceforgePOST(@RequestBody String text) {
		NormalizedReferences references = ReferencesInSourceforge.findReferences(text);
		return references.getNormalizedCommitsReferences();
	}

}
