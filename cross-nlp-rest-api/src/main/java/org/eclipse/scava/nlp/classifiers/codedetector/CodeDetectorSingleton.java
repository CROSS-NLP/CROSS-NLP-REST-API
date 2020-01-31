/*******************************************************************************
 * Copyright (C) 2018 Edge Hill University
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package org.eclipse.scava.nlp.classifiers.codedetector;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import cc.fasttext.FastText;

class CodeDetectorSingleton
{
	private static CodeDetectorSingleton singleton = new CodeDetectorSingleton();
	private FastText codeDetector;
	private String modelPath="model_Mixed_sentences_all.bin";
	
	private CodeDetectorSingleton()
	{
		System.out.println("nlp.classifiers.codedetector");
		try {
			codeDetector = getModelBin();
			System.out.println("Model has been sucessfully loaded");
		} catch (IllegalArgumentException | IOException e) {
			System.err.println("Error while loading the model:");
			e.printStackTrace();
		}
	}
	
	private FastText getModelBin() throws IllegalArgumentException, IOException
	{
		FastText.Factory factory = FastText.DEFAULT_FACTORY;
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
		FastText classifier = factory.load(resource);
		resource.close();
		return classifier;
	}
	
	public static CodeDetectorSingleton getInstance()
	{
		return singleton;
	}
	
	public FastText getCodeDetector()
	{
		return codeDetector;
	}
}
