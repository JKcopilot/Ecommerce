package com.syntellect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GenerateTicket {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter the number of rows: ");
			int rows = scanner.nextInt();

			System.out.print("Enter the number of columns: ");
			int columns = scanner.nextInt();
			int[][] ticket = generateHousieTicket(rows, columns);
			printHousieTicket(ticket);
		}
    }

    public static int[][] generateHousieTicket(int rows, int columns) {
        int[][] ticket = new int[rows][columns];
        Random random = new Random();

        // Generate numbers for each column
        for (int col = 0; col < columns; col++) {
            List<Integer> numbers = new ArrayList<>();
            int start = col * 10 + 1;
            int end = col * 10 + 10;
        // column between 1-10, 11-20....81-90
            for (int i = start; i <= end; i++) {
                numbers.add(i);
            }
            
            // Fill max 2 cells in each column
            int cellsFilled = 0;
            while (cellsFilled < 2) {
                int randomRow = random.nextInt(rows);
                if (countCellsInRow(ticket, randomRow, columns) < 5) {
                    ticket[randomRow][col] = numbers.get(cellsFilled);
                    cellsFilled++;
                }
            }
        }

        return ticket;
    }
      // Fill cells in each row
    public static int countCellsInRow(int[][] ticket, int row, int columns) {
        int count = 0;
        for (int col = 0; col < columns; col++) {
            if (ticket[row][col] != 0) {
                count++;
            }
        }
        return count;
    }

    public static void printHousieTicket(int[][] ticket) {
        System.out.println("Housie Ticket:");
        System.out.println("------------------");

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                if (ticket[row][col] != 0) {
                    System.out.print(" "+ ticket[row][col]);
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

    }
}
