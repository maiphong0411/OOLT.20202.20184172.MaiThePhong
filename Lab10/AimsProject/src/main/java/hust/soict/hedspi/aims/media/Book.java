/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.Set;



public class Book extends Media {
    
	private List<String> authors = new ArrayList<String>();
    private String content;
    private List<String> contentTokens = new ArrayList<String>();
    private Map<String,Integer> wordFrequency = new TreeMap<String,Integer>();
    
    public Book() {
    }
    
    public Book(int ID, String title, String category, float cost) throws Exception {
    	super(ID, title, category, cost);
    	if (ID <= 0 || title.length() == 0 || category.length() == 0 || cost <= 0) {
    		throw new Exception("Don't let information empty");
    	}
    }
    
    public Book(int ID, String title, String category, float cost,String content) throws Exception {
    	this(ID, title,  category, cost);
    	if (content.length() == 0) {
    		throw new Exception("Don't let information empty");
    	}
    	else {this.content = content;}
    }
    
    public String getContent() {
		return content;
	}

	public void setContent(String content) throws Exception {
		if (content.length() == 0) {
			throw new Exception("Content of length is empty");
		}
		else {
			this.content = content;
		}
	}

	public String getAuthors() {
        String authors = "";
        return this.authors.stream().map(author -> author + " ").reduce(authors, String::concat);
    }
	
    public void addAuthor(String authorName) throws Exception {
    	if (authorName.length() == 0) {
    		throw new Exception("Length of string is zero");
    	}
        if (!authors.contains(authorName)) { // Check duplication
            authors.add(authorName);
        }
    }
    
    public void removeAuthor(String authorName) {
        authors.remove(authorName); 
    }
    
    @Override
    public void show() {
        System.out.println("Book: " + this.getID() + " " + this.getTitle() + " " + this.getCategory() 
                + " " + this.getCost() + "$ " + this.getAuthors());
    }
    
    @Override
    public String toString() {
    	this.wordFrequency = sortByKeys(this.wordFrequency);
    	for(Entry<String, Integer> entry : this.wordFrequency.entrySet()) {
    		String key = entry.getKey();
    		int value = entry.getValue();
    		System.out.println("Token: " + key + " the number of tokens: " + value);
    	}
    	return "The number of tokens " + this.contentTokens.size();
    }
    
    // unsorted
    public void processBook() {
    	String[] storeWord = this.content.split(" |\t");
    	int[] wordFreq;
    	for(int i = 0; i < storeWord.length; i++) {
    		if(!this.wordFrequency.containsKey(storeWord[i])) {
    			this.wordFrequency.put(storeWord[i], 1);
    		}
    		else {
    			this.wordFrequency.replace(storeWord[i], this.wordFrequency.get(storeWord[i]), this.wordFrequency.get(storeWord[i]) + 1);
    		}
    	}
    	this.contentTokens.addAll(this.wordFrequency.keySet());
    	Collections.sort(this.contentTokens);
    }
    
    public void printContentTokens() {
    	this.contentTokens.forEach(System.out::println);
    }
    
    public static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap)
    {
        // construct a `TreeMap` from the given map and return it
        return new TreeMap<>(unsortedMap);
    }
}
