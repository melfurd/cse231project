package edu.oakland.production.ClassProject.Display;

import edu.oakland.production.ClassProject.Middleware.Middleware;

import java.util.*;

/**
 * 
 * @author Display Group
 * @version 4.0 Actually closer to working.
 * @since 3/30/2015
 */
public class Display {
	private boolean runnable;
	private boolean isFirstRun = true;
	private boolean arrayList;
	private boolean binaryOption;
	private boolean hashTableOption;
	private boolean studentOption;
	private boolean searchOption;
	private Scanner scan;
	private int menuKey;
	private String menuString;
	private Middleware middleware = new Middleware();
	private long returnTime;
	
	StringBuilder sb = new StringBuilder();

	// First, second, and third search values.
	private int a = -1;
	private int b;
	private int c;

	private final int E_100K = 100;
	private final int E_200K = 200;
	private final int E_400K = 400;

	public Display(String jUnitTesting) {
		this.runnable = true;
		this.scan = new Scanner(jUnitTesting);
	}

	public Display() {
		this.runnable = true;
		this.scan = new Scanner(System.in);
	}

	private int getNumOfElements(String menuString) {
		int numOfElements;

		switch (menuString) {
		case "1":
			numOfElements = E_100K;
			break;
		case "2":
			numOfElements = E_200K;
			break;
		case "3":
			numOfElements = E_400K;
			break;
		default:
			System.out.println("That was not a valid input. Please try again!");
			numOfElements = -1;
			break;
		}

		return numOfElements;
	}

	private void printElementChoices() {
		System.out.println("1. 100 elements.");
		System.out.println("2. 200 elements.");
		System.out.println("3. 400 elements.");
	}

	public String runMainMenu() {

		while (runnable) {
			if (isFirstRun) {
				System.out
						.println("Hello. Please press the corresponding key to enter the JCF container: ");
				this.isFirstRun = false;
			} else {
				System.out
						.println("\nHello again! Please press the corresponding key to enter the JCF container: ");
			}

			System.out.println("1. ArrayList and Linked List"); // Part 1: A
			System.out.println("2. BinaryTree"); // Part 1: B
			System.out.println("3. Hash Table"); // Part 1: C
			System.out.println("4. Enter Students."); // Part 2
			System.out.println("5. Exit.");

			System.out.print(">> ");
			menuString = scan.next();
			switch (menuString) {
			case "1": // / Part 1: A
				arrayList = true;
				while (arrayList) {
					System.out
							.println("You have selected ArrayList and LinkedList. Please select the number of elements: ");

					// / How many elements does the user want?
					printElementChoices();
					System.out.print(">> ");

					// / Store entered value as int
					int numOfElements = getNumOfElements(scan.next());

					// / If invalid input, try again
					if (numOfElements == -1)
						continue;

					System.out.println("You have selected "
							+ String.format("%,d", numOfElements)
							+ " elements.");
					middleware.setNumberOfElements(numOfElements);

					middleware.createArrayList();
					returnTime = middleware.sortArrayList(true);
					System.out
							.println("The search time for arrayList selection sort was: "
									+ returnTime + " ms");
					returnTime = middleware.sortLinkedList(true);
					System.out
							.println("The time for LinkedList selection sort was: "
									+ returnTime + " ms");

					// /Show Big Oh
					System.out.println("The big o data is: \n\t ArrayList: "
							+ middleware.bigOAL(true) + "\n\t Linked List: "
							+ middleware.bigOLL(true));

					// /Show Big Oh
					// int [] BigO = middleware.getBigOData();
					// System.out.println("The big oh data is: ");
					// for (int i = 0; i < BigO.length; i++){
					// System.out.println(BigO[i];
					// }

					// System.out.println("The big O dependency is " +
					// middleware.bigO);

					returnTime = middleware.sortLinkedList(false);
					System.out
							.println("The time for LinkedList bubble sort was: "
									+ returnTime + " ms");
					returnTime = middleware.sortArrayList(false);
					System.out
							.println("The search time for arrayList bubble sort was: "
									+ returnTime + " ms");
					// System.out.println("The search time for LinkedListbubble sort was: "
					// + returnTime);

					// Show Big Oh
					System.out.println("The big O data is:\n\t ArrayList: "
							+ middleware.bigOAL(false) + "\n\t Linked List: "
							+ middleware.bigOLL(false));

					searchOption = true;
					while (searchOption) {
						System.out
								.println("What is the value you want to search for?");
						System.out.print(">> ");
						menuString = scan.next();
						try {
							int searchInt = Integer.parseInt(menuString);
							if (searchInt >= 100 && searchInt <= 1000) {
								// Linear Search
								returnTime = middleware.searchLinkedList(
										searchInt, false);
								System.out
										.println("The time for LinkedList Linear search was: "
												+ returnTime + " ms");
								returnTime = middleware.searchArrayList(
										searchInt, false);
								System.out
										.println("The time for ArrayList Linear search was: "
												+ returnTime + " ms");
								// Binary Search
								returnTime = middleware.searchLinkedList(
										searchInt, true);
								System.out
										.println("The time for LinkedList Binary search was: "
												+ returnTime + " ms");
								returnTime = middleware.searchArrayList(
										searchInt, true);
								System.out
										.println("The time for LinkedList Binary search was: "
												+ returnTime + " ms");

								searchOption = false;
							} else {
								System.out.println("Not a valid value.");
							}
						} catch (Exception e) {
							System.out.println("Not a numerical value.");
						}
					}

					arrayList = false;
					break;

				}
				break;

			case "2": // Part 1: B
				binaryOption = true;
				while (binaryOption) {
					System.out
							.println("You have selected a Binary Tree. Please select the number of elements: ");

					// / How many elements does the user want?
					printElementChoices();
					System.out.print(">> ");

					// / Store entered value as int
					int numOfElements = getNumOfElements(scan.next());

					// / If invalid input, try again
					if (numOfElements == -1)
						continue;

					System.out.println("You have selected "
							+ String.format("%,d", numOfElements)
							+ " elements.");
					// middleware.createBinary(numOfElements);

					if (a == -1) {
						searchOption = true;
						while (searchOption) {
							System.out
									.println("What is the first int to search?");
							System.out.print(">> ");
							try {
								this.a = scan.nextInt();
								if (a == -1) {
									searchOption = true;
								} else {
									searchOption = false;
								}
							} catch (Exception e) {
								System.out.println("Enter a valid value");
							}
						}

						searchOption = true;
						while (searchOption) {
							System.out
									.println("What is the 2nd int to search?");
							System.out.print(">> ");
							try {
								this.b = scan.nextInt();
								searchOption = false;
							} catch (Exception e) {
								System.out.println("Enter a valid value");
							}
						}

						searchOption = true;
						while (searchOption) {
							System.out
									.println("What is the 3rd int to search?");
							System.out.print(">> ");
							try {
								this.c = scan.nextInt();
								searchOption = false;
							} catch (Exception e) {
								System.out.println("Enter a valid value");
							}
						}
					}

					// PREORDER SEARCH
					// ORDER SEARCH

					binaryOption = false;
				}
				break;
			case "3":
				hashTableOption = true;
				while (hashTableOption) {
					System.out
							.println("You have selected Hash Tables. Please select the number of elements: ");

					// / How many elements does the user want?
					printElementChoices();
					System.out.print(">> ");

					// / Store entered value as int
					int numOfElements = getNumOfElements(scan.next());

					// / If invalid input, try again
					if (numOfElements == -1)
						continue;

					System.out.println("You have selected "
							+ String.format("%,d", numOfElements)
							+ " elements.");

					middleware.createHashTable(numOfElements);

					if (a == -1) {
						searchOption = true;
						while (searchOption) {
							System.out
									.println("What is the first int to search?");
							System.out.print(">> ");
							try {
								this.a = scan.nextInt();
								if (a == -1) {
									searchOption = true;
								} else {
									searchOption = false;
								}
							} catch (Exception e) {
								System.out.println("Enter a valid value");
							}
						}

						searchOption = true;
						while (searchOption) {
							System.out
									.println("What is the 2nd int to search?");
							System.out.print(">> ");
							try {
								this.b = scan.nextInt();
								searchOption = false;
							} catch (Exception e) {
								System.out.println("Enter a valid value");
							}
						}

						searchOption = true;
						while (searchOption) {
							System.out
									.println("What is the 3rd int to search?");
							System.out.print(">> ");
							try {
								this.c = scan.nextInt();
								searchOption = false;
							} catch (Exception e) {
								System.out.println("Enter a valid value");
							}
						}
					}

					returnTime = middleware.searchValuesAndGetTime(a);
					System.out.println("Searched: " + a
							+ "\tHash Search Took: " + returnTime + " ms");
					returnTime = middleware.searchValuesAndGetTime(b);
					System.out.println("Searched: " + b
							+ "\tHash Search Took: " + returnTime + " ms");
					returnTime = middleware.searchValuesAndGetTime(c);
					System.out.println("Searched: " + c
							+ "\tHash Search Took: " + returnTime + " ms");

					/*
					 * System.out.println("For " + a + " " +
					 * middleware.value1time + " " +
					 * middleware.value1itemsearched + " " +
					 * middleware.value1counter + " " + middleware.value1bigO);
					 * System.out.println("For " + a + " " +
					 * middleware.value2time + " " +
					 * middleware.value2itemsearched + " " +
					 * middleware.value2counter + " " + middleware.value2bigO);
					 * System.out.println("For " + a + " " +
					 * middleware.value3time + " " +
					 * middleware.value3itemsearched + " " +
					 * middleware.value3counter + " " + middleware.value3bigO);
					 */

					hashTableOption = false;

				}
				break;

			case "44":
			case "4":
				System.out
						.println("You have selected class schedule. Please enter students data: ");

				if (menuString.equals("4"))
					createClass();
				else
					// (menuString == "44")
					createClass2();


				
				boolean flagExit = false;
				boolean stayIn = true;
				String tempToParse;
				String returnStuff;
				// CUT CLASS
				studentOption = true;
				while (studentOption) {
					System.out.println("Do you want to cut students?");
					System.out.println("1.) Continue");
					System.out.println("2.) Exit (You will lose everything)");
					System.out.print(">> ");
					
					menuString = scan.next();
					switch (menuString) {
					case "1":
						System.out.println("How many students do you want to cut?");
						tempToParse = scan.next();
						while (stayIn){
							try {
								cutStudentAmount = Integer.parseInt(tempToParse);
								stayIn = false;
							} catch (Exception e) {
								System.out.println(
										"Need to enter valid number to cut students.");
								System.out.print(">> ");
								tempToParse = scan.next();
							}
						}
						stayIn = true;

						System.out.println("The following students were cut: ");
						System.out.println();

						returnStuff = middleware.cutStudents(cutStudentAmount, true, 0);
						System.out.println(returnStuff);
						
						//FOR JUNIT TEST
						sb.append(returnStuff.trim());

						
						System.out.println("The following students were not cut: ");
						System.out.println();
						
						returnStuff = middleware.cutStudents(cutStudentAmount, false, 0);
						System.out.println(returnStuff);
						//sb.append(returnStuff);
						
						studentOption = false;
						break;
					case "2":
						flagExit = true;
						studentOption = false;
						break;
					default:
						System.out.println("Invalid entry.");
						continue;
					}
				}
				if (flagExit) {
					break;
				}

				// Process Scholarship
				studentOption = true;
				while (studentOption) {
					System.out.println("Do you want to Process Scholarships?");
					System.out.println("1.) Process Scholarships for students");
					System.out.println("2.) Exit (You will lose everything)");
					System.out.print(">> ");
					menuString = scan.next();
					switch (menuString) {
					case "1":
						System.out.println("Process scholarships the class");
						
						System.out.println("How many students do you want to get scholarship?");
						tempToParse = scan.next();
						while (stayIn){
							try {
								scholarshipStudent = Integer.parseInt(tempToParse);
								if (scholarshipStudent > (totalStudentCount - cutStudentAmount)){
									System.out.println(
											"There are too many scholarships compared to students.");
									System.out.print(">> ");
									tempToParse = scan.next();									
								}
								else {
								stayIn = false;
								}
								
							} catch (Exception e) {
								System.out.println(
										"Need to enter valid number to cut students.");
								System.out.print(">> ");
								tempToParse = scan.next();
							}
						}
						stayIn = true;

						
						System.out.println("The following students received scholarships: ");
						System.out.println();
						returnStuff = (middleware.cutStudents(totalStudentCount - cutStudentAmount - scholarshipStudent, false, cutStudentAmount));
						System.out.println(returnStuff);
						sb.append(returnStuff.trim());
						
						System.out.println("The following students did not receive scholarships: ");
						System.out.println();
						returnStuff = (middleware.cutStudents(totalStudentCount - cutStudentAmount - scholarshipStudent, true, cutStudentAmount));
						System.out.println(returnStuff);
						//sb.append(returnStuff);
						
						studentOption = false;
						break;
					case "2":
						flagExit = true;
						studentOption = false;
						break;
					default:
						System.out.println("Invalid entry.");
						continue;
					}
				}
				if (flagExit) {
					break;
				}
				
				// reinstate class
				studentOption = true;
				while (studentOption) {
					System.out.println("Do you want to reinstate to class?");
					System.out.println("1.) Reinstate to Class");
					System.out.println("2.) Exit (You will lose everything)");
					System.out.print(">> ");
					menuString = scan.next();
					switch (menuString) {
					case "1":
						System.out.println("Reinstate to class");
						
						returnStuff = (middleware.getThesis());
						System.out.println(returnStuff);
						//sb.append(returnStuff);
						
						studentOption = false;
						break;
					case "2":
						flagExit = true;
						studentOption = false;
						break;
					default:
						System.out.println("Invalid entry.");
						continue;
					}
				}

				break;
			case "5":
				runnable = false;
				System.out.println("Goodbye!");
				break;
			default:
				System.out
						.println("That was not a valid input. Please try again!");
				continue;
			}
			


		}
		return sb.toString();
	}


	/*
	 * private boolean createClass2() { middleware.createStudent(1, "1", "1", 1,
	 * 1); middleware.createStudent(2, "2", "2", 2, 2);
	 * middleware.createStudent(3, "3", "3", 3, 3); middleware.createStudent(4,
	 * "4", "4", 4, 4); middleware.createStudent(5, "5", "5", 5, 5);
	 * middleware.createStudent(6, "6", "6", 6, 6); middleware.createStudent(7,
	 * "7", "7", 7, 7); middleware.createStudent(8, "8", "8", 8, 8);
	 * middleware.createStudent(9, "9", "9", 9, 9); middleware.createStudent(10,
	 * "10", "10", 10, 10); return true; }
	 */

	private boolean createClass2() {
		this.totalStudentCount = 10;
		middleware.setStackSize(this.totalStudentCount);
		middleware.createStudent(677422, "1. Jones", "IT", 3.82, 95);
		middleware.createStudent(177993, "2. Smith", "IT", 3.47, 78);
		middleware.createStudent(444811, "3. Breaux", "CS", 3.95, 98);
		middleware.createStudent(113625, "4. Brady", "CS", 3.77, 92);
		middleware.createStudent(382707, "5. Rominske", "CS", 3.82, 79);
		middleware.createStudent(447447, "6. Hardy", "IT", 3.68, 99);
		middleware.createStudent(661284, "7. Kominsky", "IT", 3.23, 70);
		middleware.createStudent(855462, "8. O'Brien", "IT", 3.44, 85);
		middleware.createStudent(223344, "9. Chamberlain", "CS", 3.99, 96);
		middleware.createStudent(348689, "10. Grant", "CS", 3.88, 99);

		return true;
	}

	
	private int totalStudentCount = 0;
	private int cutStudentAmount = 0;
	private int scholarshipStudent = 0;
	
	private boolean createClass() {

		boolean stayIn = true;
		boolean notSuccessful = true;
		int counter = 0;
		String tempToParse;
		String temp;
		int grizzlyID = -1;
		String name;
		String major;
		double gpa = -1;
		int thesisGrade = -1;
		
		System.out.println("How many students do you want to add?");
		tempToParse = scan.next();
		while (stayIn){
			try {
				this.totalStudentCount = Integer.parseInt(tempToParse);
				if (this.totalStudentCount < 10){
					System.out.println("Min class is 10 students, How many students do you want to add?");
					tempToParse = scan.next();
				}
				else{
				stayIn = false;
				}
			} catch (Exception e) {
				System.out.println(
						"Not a valid number. How many students do you want to add?");
				System.out.print(">> ");
				tempToParse = scan.next();
			}
		}
		stayIn = true;

		middleware.setStackSize(this.totalStudentCount);
		
		while (stayIn) {
			System.out.println("Enter student data:");
			System.out.println("What is the student's Grizzly ID?");
			System.out.print(">> ");
			tempToParse = scan.next();
			
			while (notSuccessful){
				try {
					grizzlyID = Integer.parseInt(tempToParse);
					notSuccessful = false;
				} catch (Exception e) {
					System.out.println(
							"ID Entered is not a valid number,"
							+ " What is the student's Grizzly ID?");
					System.out.print(">> ");
					tempToParse = scan.next();
				}
			}
			notSuccessful = true;

			System.out.println("What is the student's name?");
			System.out.print(">> ");
			name = scan.next();
			System.out.println("What is the major of the student");
			System.out.print(">> ");
			major = scan.next();

			System.out.println("What is the GPA");
			System.out.print(">> ");
			tempToParse = scan.next();
			do {
				try {
					gpa = Double.parseDouble(tempToParse);
					notSuccessful = false;
				} catch (Exception e) {
					System.out.println(
							"GPA Entered is not a valid number, "
							+ "What is the GPA?");
					System.out.print(">> ");
					tempToParse = scan.next();
				}
			} while (notSuccessful);
			notSuccessful = true;
			System.out.println("Thesis grade?");
			System.out.print(">> ");
			tempToParse = scan.next();
			do {
				try {
					thesisGrade = Integer.parseInt(tempToParse);
					notSuccessful = false;
				} catch (Exception e) {
					System.out.println(
								"Thesis Entered is not a valid number, "
								+ "What is the student's thesis grade?");
					System.out.print(">> ");
					tempToParse = scan.next();
				}
			} while (notSuccessful);
			notSuccessful = true;

			// / Create the student
			middleware.createStudent(grizzlyID, name, major, gpa, thesisGrade);

			counter++;
			if (counter >= this.totalStudentCount) {
				stayIn = false;
			}
		} 
		return true;
	}

	/**
	 * Prints a string while checking if it is being tested.
	 * 
	 * @param strtoPrint
	 *            String that is considered for being printed.
	 * @return String to print, if being tested.
	 */
	/*
	 * private String print(String strToPrint) { if(testing) { // private
	 * boolean testing; Doesn't exist yet. Would be set in the Display()
	 * constructor. return strToPrint; } else System.out.print(strtoPrint); //
	 * Would require manual use of newlines. }
	 */
	// For this to work, mainMenu() would have to be of type string.
	// Tests classes would do str = display.mainMenu();
	// They would then process str for whatever information they need.
	// Important information would be printed out using print()
	// Which would either transparently print the information or
	// add it to a string for mainMenu() to return when it completes.
	// This may not be the best idea, which is why I haven't implemented it
	// myself. However, I believe it would at least work.

}