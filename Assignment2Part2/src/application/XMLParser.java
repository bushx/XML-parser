package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exceptions.EmptyQueueException;
import utilities.*;

/**
 * This is a program for parsing through an xml document using queues stacks in Java.
 * @author Bushra Osman, Jihoon Oh, Jonghan Park, Eunji Lee
 *
 */
public class XMLParser {
	public static void main(String[] args) throws NullPointerException, EmptyQueueException {
		
		if(args.length != 1) {
			System.out.println("XML document must be provided via the command line");
			System.exit(1);
		}
		
		MyStack<String> tagStack = new MyStack<String>();
		String report = "Error Report:\n";
		Scanner loadFile = null;
		
		try {
			loadFile = new Scanner(new File(args[0]));
		} catch(FileNotFoundException e1) {
			System.out.println("The file not found!");
			System.exit(1);
		}
		
			/**
			* Loads the File
			*/
		while(loadFile.hasNextLine()) {       

			String line = loadFile.nextLine();  					// Loads the next Line
			String tag = "";
			String previousTag = "";
			MyStack<Character> starting = new MyStack<Character>(); // Initiates the Starting Stack
			boolean hasError = false;
			boolean hasMoreStarting = false;
			boolean waiting = false;
			
			for(int i = 0; i < line.length(); i++) {				//Runs through the given Line
				switch(line.charAt(i)) {							//Case for i at Line
				case '<':											// open < 
					if(starting.isEmpty()) {
						starting.push(line.charAt(i));
					} else {								// If a tag is <<abc>
						report += "<";
						hasError = true;
						hasMoreStarting = true;
					}
					
					break;
				
				case '>':
					if(!starting.isEmpty()) {
						tag = "<" + tag + ">";
						previousTag = tag;
						
						if(tag.length() > 2 && !hasMoreStarting) {							
							if(!tag.contains("?") && !tag.contains("/")) { // If a tag is start_tag
								tagStack.push(tag);
							}
							
							if(tag.charAt(1) == '/') {					  // If a tag is closing_tag
								String startTag = tag.substring(0, 1) + tag.substring(2, tag.length());
								
								if(tagStack.isEmpty()) {
									report += tag;
									hasError = true;									
								} else if(startTag.equals(tagStack.peek())) {
									tagStack.pop();
								} else if(!startTag.equals(tagStack.peek())) {	
									MyStack<String> errorTag = new MyStack<String>();
									
									if(tagStack.contains(startTag)) {
										while(!tagStack.peek().equals(startTag)) {
											errorTag.push(tagStack.pop());											
										}
										
										errorTag.push(tagStack.pop());
										
										while(!errorTag.isEmpty()) {										
											report += errorTag.pop();
										}
										
										report += tag;
										hasError = true;
									} else {
										report += tag;
										hasError = true;
									}
								}
							} 
						} else {						 // If a tag is <> or <<abc> (< is in errorQ already)
							report += tag;
							hasError = true;
						}
					} else {
						if(previousTag.equals(tagStack.peek())) {	// If a tag is <abc>>
							report += tagStack.pop() + ">";
							hasError = true;
							previousTag = "";
						} else {
							if(previousTag.contains("/")) {			// If a tag is <abc/>>
								report += previousTag + ">";
								hasError = true;
								previousTag = "";
							} else {								// If a tag is <<abc>> (<<abc> is in errorQ already)
								report += ">";
								hasError = true;
							}							
						}						
					}

					tag = "";
					starting.clear();
					hasMoreStarting = false;
					waiting = false;
					
					break;
					
				case ' ':
					if(!starting.isEmpty()) {		// If a tag is <abc name="">
						waiting = true;
					}
					
					break;
				
				default:
					if(!starting.isEmpty() && !waiting) {
						tag += line.charAt(i);
					} else if(!starting.isEmpty() && line.charAt(i) == '/') {
						tag += line.charAt(i);
					}
				}
			}
			
			if(hasError) {
				report += "\n";
			}
		}
		
		loadFile.close();
		
		System.out.println(report);
	}
}