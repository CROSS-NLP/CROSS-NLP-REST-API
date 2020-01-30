/*******************************************************************************
 * Copyright (c) 2019 Edge Hill University
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package org.eclipse.scava.nlp.tools.plaintext.bugtrackers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import org.eclipse.scava.nlp.tools.plaintext.PlainTextObject;
import org.eclipse.scava.nlp.tools.plaintext.utils.IntermadiatePlainTextObject;
import org.eclipse.scava.nlp.tools.plaintext.utils.ReplyLineDetection;
import org.eclipse.scava.nlp.tools.preprocessor.htmlparser.HtmlParser;
import org.eclipse.scava.nlp.tools.preprocessor.markdown.MarkdownParser;

public class PlainTextBugTrackerMarkdownBased
{
	private static Pattern newlines;
	private static Pattern escapedNewline;
	
	static
	{
		newlines=Pattern.compile("\\\\r\\\\n");
		escapedNewline = Pattern.compile("(\\\\n|\\\\r)");
	}
	
	public static PlainTextObject process(String text)
	{
		if(text==null)
			return new PlainTextObject(new ArrayList<String>(Arrays.asList("")));
		text=newlines.matcher(text).replaceAll("\n");
		IntermadiatePlainTextObject intermadiatePlainTextObject= ReplyLineDetection.process(text);
		text= MarkdownParser.parse(intermadiatePlainTextObject.getPlainText());
		//In case the text contain escaped newlines
		text=escapedNewline.matcher(text).replaceAll("");
		return new PlainTextObject(HtmlParser.parse(text), intermadiatePlainTextObject.hadReplies());
	}

	
	
	public static void main(String[] args) {
	PlainTextObject x = 	PlainTextBugTrackerMarkdownBased.process("When trying to use \\\"grimoire/full\\\" with ES 7.X it doesn't work, see\",\"Start grimoire stack:\",\"docker run -e RUN_MORDRED=NO -it grimoirelab/full\",\"Start ES 7.X: \",\"docker run -p 9200:9200 -p 9300:9300 -e \\\"discovery.type=single-node\\\" docker.elastic.co/elasticsearch/elasticsearch:7.5.1\",\"Shell into \",\"grimoire/full\",\": \",\"docker exec -it b26c4856cf8e env TERM=xterm /bin/bash\",\"Inside the grimoire try to use ES 7.X: \",\"p2o.py --enrich --index raw1 --index-enrich enrich1 -e http://172.17.0.1:9200 git https://github.com/lukaszgryglicki/csqconv\",\"It returns error:\",\"grimoirelab@b26c4856cf8e:~$ p2o.py --enrich --index raw1 --index-enrich enrich1 -e http://172.17.0.1:9200 git https://github.com/lukaszgryglicki/csqconv2020-01-15 07:48:11,505 Error creating ES mappings {\\\"error\\\":{\\\"root_cause\\\":[{\\\"type\\\":\\\"illegal_argument_exception\\\",\\\"reason\\\":\\\"Types cannot be provided in put mapping requests, unless the include_type_name parameter is set to true.\\\"}],\\\"type\\\":\\\"illegal_argument_exception\\\",\\\"reason\\\":\\\"Types cannot be provided in put mapping requests, unless the include_type_name parameter is set to true.\\\"},\\\"status\\\":400}. Mapping:          {            \\\"dynamic\\\":true,            \\\"properties\\\": {                \\\"data\\\": {                    \\\"properties\\\": {                        \\\"message\\\": {                            \\\"type\\\": \\\"text\\\",                            \\\"index\\\": true                        }                    }                }            }        }        2020-01-15 07:48:11,505 Error feeding raw from git (https://github.com/lukaszgryglicki/csqconv): 400 Client Error: Bad Request for url: http://172.17.0.1:9200/raw1/items/_mappingTraceback (most recent call last):  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/elk.py\\\", line 154, in feed_backend    elastic_ocean = get_elastic(url, es_index, clean, ocean_backend, es_aliases)  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/utils.py\\\", line 260, in get_elastic    analyzers=analyzers, aliases=es_aliases)  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/elastic.py\\\", line 101, in __init__    self.create_mappings(map_dict)  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/elastic.py\\\", line 318, in create_mappings    res.raise_for_status()  File \\\"/usr/local/lib/python3.5/dist-packages/requests/models.py\\\", line 940, in raise_for_status    raise HTTPError(http_error_msg, response=self)requests.exceptions.HTTPError: 400 Client Error: Bad Request for url: http://172.17.0.1:9200/raw1/items/_mapping2020-01-15 07:48:11,507 [git] Done collection for https://github.com/lukaszgryglicki/csqconv2020-01-15 07:48:11,507 Backend feed completed2020-01-15 07:48:11,537 Error creating ES mappings {\\\"error\\\":{\\\"root_cause\\\":[{\\\"type\\\":\\\"illegal_argument_exception\\\",\\\"reason\\\":\\\"Types cannot be provided in put mapping requests, unless the include_type_name parameter is set to true.\\\"}],\\\"type\\\":\\\"illegal_argument_exception\\\",\\\"reason\\\":\\\"Types cannot be provided in put mapping requests, unless the include_type_name parameter is set to true.\\\"},\\\"status\\\":400}. Mapping:         {            \\\"properties\\\": {               \\\"message_analyzed\\\": {                    \\\"type\\\": \\\"text\\\",                    \\\"index\\\": true               }           }        }2020-01-15 07:48:11,538 Error enriching ocean from git (https://github.com/lukaszgryglicki/csqconv): 400 Client Error: Bad Request for url: http://172.17.0.1:9200/enrich1/items/_mappingTraceback (most recent call last):  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/elk.py\\\", line 599, in enrich_backend    elastic_enrich = get_elastic(url, enrich_index, clean, enrich_backend, es_enrich_aliases)  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/utils.py\\\", line 260, in get_elastic    analyzers=analyzers, aliases=es_aliases)  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/elastic.py\\\", line 101, in __init__    self.create_mappings(map_dict)  File \\\"/usr/local/lib/python3.5/dist-packages/grimoire_elk/elastic.py\\\", line 318, in create_mappings    res.raise_for_status()  File \\\"/usr/local/lib/python3.5/dist-packages/requests/models.py\\\", line 940, in raise_for_status    raise HTTPError(http_error_msg, response=self)requests.exceptions.HTTPError: 400 Client Error: Bad Request for url: http://172.17.0.1:9200/enrich1/items/_mapping2020-01-15 07:48:11,538 [git] Done enrichment for https://github.com/lukaszgryglicki/csqconv2020-01-15 07:48:11,538 Enrich backend completed2020-01-15 07:48:11,538 Finished in 0.00 min\",\"This is due to unsupported ES 7.x, when I build a new docker image containing entire grimoire stack it runs on 7.X flawlessly:\",\"root@29d96691518a:/# p2o.py --enrich --index raw1 --index-enrich enrich1 -e http://172.17.0.1:9200 git https://github.com/lukaszgryglicki/csqconv2020-01-15 07:51:34,037 [git] Incremental from: 2020-01-11 16:07:44+00:00 for https://github.com/lukaszgryglicki/csqconv2020-01-15 07:51:36,675 [git] Done collection for https://github.com/lukaszgryglicki/csqconv2020-01-15 07:51:36,675 Backend feed completed2020-01-15 07:51:37,261 [git] Done enrichment for https://github.com/lukaszgryglicki/csqconv2020-01-15 07:51:37,262 Enrich backend completed2020-01-15 07:51:37,262 Finished in 0.06 minroot@29d96691518a:/# \",\"This means that docker image(s) for grimoire stack are outdated comapring to their corresponding GitHub repos.\"");
	System.out.println(x.getPlainTextAsList());
	}
}
