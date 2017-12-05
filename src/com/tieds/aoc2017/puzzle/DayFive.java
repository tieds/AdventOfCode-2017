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
public class DayFive {
	
	public static void solve() throws IOException {
		int steps = 0;
		List<Integer> input = new ArrayList<Integer>();
		//open input file
		FileInputStream fstream = new FileInputStream("day5-input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		//make the list
		String line = null;
		while((line = br.readLine()) != null){
			input.add(Integer.parseInt(line));
		}		
		//close file stream
		br.close();
		//do work
		int currentLoc = 0;
		while(currentLoc < input.size()){
			steps++;
			int val = input.get(currentLoc);
			int jumpDistance = new Integer(val);
			if(jumpDistance >= 3){
				input.set(currentLoc, val-1);
			} else {
				input.set(currentLoc, val+1);
			}			
			currentLoc += jumpDistance;
		}
		//print total
		System.out.println("Day 5 - Puzzle 1 - Solution: "+steps);
	}
	
}
