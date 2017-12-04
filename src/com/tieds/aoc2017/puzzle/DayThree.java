package com.tieds.aoc2017.puzzle;

/**
 * Day 3
 * http://adventofcode.com/2017/day/3#
 * @author tieds
 *
 */
public class DayThree {
	
	private static int input = 312051;
	
	private static int RIGHT = 1;
	private static int UP = 2;
	private static int LEFT = 3;
	private static int DOWN = 4;	

	public static void solve(){
		//find size of grid
		double sqrt = Math.sqrt(input);
		int gridSize = (int) Math.ceil(sqrt);
		//make sure size is odd so we have a center square
		if(gridSize % 2 != 1){
			gridSize++;
		}
		//build 2D array of necessary size
		int[][] grid = new int[gridSize][gridSize];
		//set current location to the middle square
		int currentX = (int) Math.ceil(gridSize/2);
		int currentY = (int) Math.ceil(gridSize/2);
		//seed grid with first 2 inputs to get it going in the right direction
		grid[currentY][currentX] = 1;
		currentX++;
		grid[currentY][currentX] = 1;
		currentY--;
		int currentDirection = UP;
		//loop until we get to input
		int count = 3;
		while(count <= input){
			//for puzzle 1, put current number at current location
			//grid[currentY][currentX] = count;	
			//for puzzle 2, put sum of all adjacent squares
			int sum = 
					grid[currentY][currentX+1] +
					grid[currentY][currentX-1] +
					grid[currentY+1][currentX] +
					grid[currentY+1][currentX+1] +
					grid[currentY+1][currentX-1] +
					grid[currentY-1][currentX] +
					grid[currentY-1][currentX+1] +
					grid[currentY-1][currentX-1];
			grid[currentY][currentX] = sum;
			//for puzzle 1 exit once we reach input
			if(count == input){
				break;
			}
			//for puzzle 2 exit once we exceed input
			if(sum > input){
				System.out.println("First value greater than input is: "+sum);
				break;
			}
			//if traveling right, check if cell above has a value - if not, turn
			if(currentDirection == RIGHT){
				if(grid[currentY-1][currentX] <= 0){
					currentDirection = getNextBuildDirection(currentDirection);
					currentY--;
				} else {
					currentX++;
				}
			}
			//if traveling up, check if cell to left has a value - if not, turn
			else if(currentDirection == UP){
				if(grid[currentY][currentX-1] <= 0){
					currentDirection = getNextBuildDirection(currentDirection);
					currentX--;
				}  else {
					currentY--;
				}
			}
			//if traveling left, check if cell below has a value - if not, turn
			else if(currentDirection == LEFT){
				if(grid[currentY+1][currentX] <= 0){
					currentDirection = getNextBuildDirection(currentDirection);
					currentY++;
				} else {
					currentX--;
				}
			}
			//if traveling down, check if cell to right has a value - if not, turn
			else if(currentDirection == DOWN){
				if(grid[currentY][currentX+1] <= 0){
					currentDirection = getNextBuildDirection(currentDirection);
					currentX++;
				} else {
					currentY++;
				}
			}
			count++;
		}
		System.out.println("Final X: "+currentX);
		System.out.println("Final Y: "+currentY);
		System.out.println("Manhattan Distance: "+Math.abs(Math.abs(currentX)-Math.abs(currentY)));
	}
	
	private static int getNextBuildDirection(int currentDirection){
		return currentDirection==4?1:currentDirection+1;
	}
	
}
