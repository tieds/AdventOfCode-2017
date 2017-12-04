package com.tieds.aoc2017.puzzle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Day 2 
 * http://adventofcode.com/2017/day/2#
 * @author tieds
 *
 */
public class DayFour {
	
	public static void solve() throws IOException {
		int sum1 = 0;
		int sum2 = 0;
		//open input file
		FileInputStream fstream = new FileInputStream("day4-input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		//process each line
		String line = null;
		while((line = br.readLine()) != null){
			Set<String> phrases = new HashSet<String>();
			Set<String> phrasesSorted = new HashSet<String>();
			//tokenize the line
			StringTokenizer st = new StringTokenizer(line);
			boolean validToken = true;
			boolean validToken2 = true;
			while(st.hasMoreTokens()){
				String phrase = st.nextToken();
				//hack together a sorted version
				List<String> chars = new ArrayList<String>();
				String sortedPhrase = "";
				Iterator i = phrase.chars().iterator();
				while(i.hasNext()){
					chars.add(String.valueOf(i.next()));
				}
				Collections.sort(chars);
				for(String c : chars){
					sortedPhrase += c;
				}
				//add to set if doesn't exist
				if(!phrases.contains(phrase)){
					phrases.add(phrase);
				}
				//exists already
				else {
					validToken = false;
				}
				//add to set if doesn't exist
				if(!phrasesSorted.contains(sortedPhrase)){
					phrasesSorted.add(sortedPhrase);
				}
				//exists already
				else {
					validToken2 = false;
				}
			}
			if(validToken){
				sum1 += 1;
			}
			if(validToken2){
				sum2 += 1;
			}
		}
		//close file stream
		br.close();
		//print total
		System.out.println("Day 4 - Puzzle 1 - Solution: "+sum1);
		System.out.println("Day 4 - Puzzle 2 - Solution: "+sum2);
	}
	
}
