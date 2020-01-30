/*******************************************************************************
 * Copyright (c) 2019 Edge Hill University
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package org.eclipse.scava.nlp.classifiers.emotionclassifier;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import vasttext.Vasttext;

class EmotionClassifierSingleton
{
	private static EmotionClassifierSingleton singleton = new EmotionClassifierSingleton();
	private Vasttext emotionClassifier;
	private String modelPath="Sentic_no_lemma_Vasttext_model.zip";
	
	private EmotionClassifierSingleton()
	{
		System.out.println("nlp.classifiers.emotionclassifier");
		emotionClassifier=new Vasttext();
		try {
			loadModel();
			System.out.println("Model has been sucessfully loaded");
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error while loading the model:");
			e.printStackTrace();
		}
	}
	
	private void loadModel() throws ClassNotFoundException, IOException
	{
		ClassLoader cl = getClass().getClassLoader();
		InputStream resource = cl.getResourceAsStream(modelPath);
		if(resource==null)
		{
			String path = getClass().getProtectionDomain().getCodeSource().getLocation().getFile();
			if (path.endsWith("bin/"))
				path = path.substring(0, path.lastIndexOf("bin/"));
			if (path.endsWith("target/classes/"))
				path = path.substring(0, path.lastIndexOf("target/classes/"));
			File file= new File(path+modelPath);
			if(!Files.exists(file.toPath()))
				throw new FileNotFoundException("The file "+modelPath+" has not been found");
			else
				resource=new FileInputStream(file);
		}
		emotionClassifier.loadModel(resource);
		resource.close();
	}
	
	public static EmotionClassifierSingleton getInstance()
	{
		return singleton;
	}
	
	public Vasttext getEmotionClassifier()
	{
		return emotionClassifier;
	}
}
