package com.soft;

import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.Scanner;

public class HousieGenProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter How Many Tickets you want and Number of Rows In Each Ticket:");
		int number = sc.nextInt();
		

		if (number < 1) {
			throw new RuntimeException("Invalid Number !! Please Give Valid Number");
		}
		

		int noOfRows = sc.nextInt();

		if (noOfRows < 1) {
			throw new RuntimeException("Invalid Number !! Please Give Valid Number Of Rows !! Generally it have 3 Rows");
		}
		
		

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();
		List<Integer> l5 = new ArrayList<>();
		List<Integer> l6 = new ArrayList<>();
		List<Integer> l7 = new ArrayList<>();
		List<Integer> l8 = new ArrayList<>();
		List<Integer> l9 = new ArrayList<>();

		// 1
		for (int i = 1; i < 10; i++) {
			l1.add(i);
		}

		// 2
		for (int i = 11; i < 20; i++) {
			l2.add(i);
		}
		// 3
		for (int i = 21; i < 30; i++) {
			l3.add(i);
		}

		// 4
		for (int i = 31; i < 40; i++) {
			l4.add(i);
		}
		// 5
		for (int i = 41; i < 50; i++) {
			l5.add(i);
		}
		// 6
		for (int i = 51; i < 60; i++) {
			l6.add(i);
		}
		// 7
		for (int i = 61; i < 70; i++) {
			l7.add(i);
		}
		// 8
		for (int i = 71; i < 80; i++) {
			l8.add(i);
		}
		// 9
		for (int i = 81; i < 90; i++) {
			l9.add(i);
		}

		List<List<Integer>> columns = new ArrayList<>();
		columns.add(l1);
		columns.add(l2);
		columns.add(l3);
		columns.add(l4);
		columns.add(l5);
		columns.add(l6);
		columns.add(l7);
		columns.add(l8);
		columns.add(l9);

		// creating the numbers from to the list
		List<HouTicket> listoftickets = new ArrayList<>();
		for (int tickets = 0; tickets < number; tickets++) {
			HouTicket rows = new HouTicket();
			for (int rowsize = 0; rowsize < noOfRows; rowsize++) {

				HouTicketRows row = new HouTicketRows();

				for (int i = 0; i < columns.size(); i++) {
					List<Integer> column = columns.get(i);
					//int randomindex = genrandomNumber(0, column.size() - 1);
					int randomindex = genUnusedRandomNumber(rows.getTicketRows(), column.size(), i, column);
					// int randomNumber = column.get(randomindex);

					// System.out.print(randomindex+" -"+randomNumber);
					row.addNumber(column.get(randomindex));

				}
				rows.add(row);
			}
			listoftickets.add(rows);
		}

		displayTicket(listoftickets);

		for (HouTicket ticket : listoftickets) {
			for (HouTicketRows row : ticket.getTicketRows()) {
				List<Object> column = row.getcloumns();
				int count = 1;
				List<Integer> indexs = new ArrayList<>();
				while (count < 5) {
					int randomeindex = genrandombyincolumn(0, column.size() - 1);
					if (!indexs.contains(randomeindex)) {
						indexs.add(randomeindex);
						column.remove(randomeindex);
						column.add(randomeindex, " ");
						count++;
					} else if (indexs.contains(randomeindex)) {

						continue;
					}

				}
			}

		}

		displayTicket(listoftickets);
		
		
	}

	
	
	public static int genrandomNumber(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	public static int genrandombyincolumn(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	public static void displayTicket(List<HouTicket> tickets) {

		int totalticket = 0;
		for (HouTicket tk : tickets) {
			totalticket++;
			System.out.println(" Ticket is : " + totalticket);
			System.out.println("  ");
			for (HouTicketRows row : tk.getTicketRows()) {

				for (Object row1 : row.getcloumns()) {
					System.out.print(row1);
					System.out.print(",");
				}
				System.out.println();
				// System.out.println(row.getcloumns().toString());
			}

			System.out.println("  ");
		}

	}

	private static int genUnusedRandomNumber(List<HouTicketRows> existingRows, int max, int curColumn,
			List<Integer> srcColumn) {

		int randomindex = genrandomNumber(0, max - 1);

		boolean isMatchFound = false;
		for (HouTicketRows rowObj : existingRows) {
			List<Object> columnsList = rowObj.getcloumns();

			if (Integer.parseInt(columnsList.get(curColumn).toString()) == Integer
					.parseInt(srcColumn.get(randomindex).toString())) {
				isMatchFound = true;
			}
		}

		if (!isMatchFound) {
			return randomindex;
		} else {
			isMatchFound = false;
			return genUnusedRandomNumber(existingRows, max, curColumn, srcColumn);
		}

	}

}
