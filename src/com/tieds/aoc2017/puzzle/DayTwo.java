package com.tieds.aoc2017.puzzle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Day 2 
 * http://adventofcode.com/2017/day/2#
 * @author tieds
 *
 */
public class DayTwo {
	
	public static void solve() throws IOException {
		int sum1 = 0;
		int sum2 = 0;
		//open input file
		FileInputStream fstream = new FileInputStream("day2-input.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		//process each line
		String line = null;
		while((line = br.readLine()) != null){
			boolean foundZeroRemainder = false;
			int highval = 0;
			int lowval = Integer.MAX_VALUE;
			//tokenize the line
			StringTokenizer st = new StringTokenizer(line);
			while(st.hasMoreTokens()){
				int val = Integer.parseInt(st.nextToken().trim());
				if(val > highval){
					highval = val;
				}
				if(val < lowval){
					lowval = val;
				}
				//for puzzle two, loop again through the line to look for evenly divisible values
				if(!foundZeroRemainder){
					StringTokenizer st2 = new StringTokenizer(line);
					while(st2.hasMoreTokens()){
						int val2 = Integer.parseInt(st2.nextToken().trim());
						//dont check itself
						if(val == val2){
							continue;
						}
						//check for even divisibility
						if(val2 % val == 0){
							sum2 += val2 / val;
							foundZeroRemainder = true;
							break;
						}
						if(val % val2 == 0){
							sum2 += val / val2;
							foundZeroRemainder = true;
							break;
						}
					}
				}
			}
			sum1 += highval - lowval;
		}
		//close file stream
		br.close();
		//print total
		System.out.println("Day 2 - Puzzle 1 - Solution: "+sum1);
		System.out.println("Day 2 - Puzzle 2 - Solution: "+sum2);
	}
	
}
