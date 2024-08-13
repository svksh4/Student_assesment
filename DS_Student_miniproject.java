//MINIPROJECT
/*
 Shriya Kshirsagar B3
 UCE2022552 
 */
package net.codejava;

import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.LinkedList;




class StudentNode {
private int id;
private String name;
private String email;
private String skills;
private String hobbies;
StudentNode next;

public StudentNode(int id, String name, String email, String skills, String hobbies) {
this.id = id;
this.name = name;
this.email = email;
this.skills = skills;
this.hobbies = hobbies;
this.next = null;
}

public int getId() {
return id;
}

public String getName() {
return name;
}

public String getEmail() {
return email;
}

public String getSkills() {
return skills;
}

public String getHobbies() {
return hobbies;
}

public int getRoll_no() {
return 0;
}

public void setYear(String year) {

}

public void setMail_id(String mail_id) {

}

public void setSkills(String skills2) {

}

public StudentNode getNext() {
return next;
}

public void setNext(StudentNode next) {
this.next = next;
}
}

public class DS_Student_miniproject {
static Scanner scanner = new Scanner(System.in);
static String question_text;
static String[] answerChoices;
static int correctAnswerIndex;

public static void main(String[] args) {
opportunity obj = new opportunity();
// Question que = new Question(question_text, answerChoices,
// correctAnswerIndex);
Quiz quiz = new Quiz();
//ExcelStudentChecker checker = new ExcelStudentChecker();
String year = null;
LinkedList<StudentNode> studentList = new LinkedList<>();
int choice;
do {
System.out.println("What do you want to do?");

System.out.println("1)Student login/signup ");

System.out.println("2)Admin access ");

System.out.println("3)See student details by academic year(only for admin)\n"
+ "4)Opportunities for student\n" + "5)Start your assessment quiz\n" + "6)Exit ");
choice = scanner.nextInt();

switch (choice) {

case 1:
obj.loginOrSignup(year, studentList);
break;

case 2:
obj.AccessFor();
break;
// obj.manageOpportunities();

case 3:
obj.seeStudentDetailsByAcademicYear();
break;

case 4:

obj.student_opportunities();
break;
case 5:
quiz.startQuiz();
break;
case 6:
System.out.println("*****Exiting....*****");
break;

default:

System.out.println("Invalid choice. Please select a valid option.");

}
} while (choice != 6);

}
}


class opportunity {

static Scanner s = new Scanner(System.in);
Scanner scanner = new Scanner(System.in);
//ExcelStudentChecker obj1 = new ExcelStudentChecker();
void access() {

	System.out.println("Access this page as Admin/Student:");
	String user = scanner.nextLine();

	if (user.equalsIgnoreCase("Admin")) {

	}

	else if (user.equalsIgnoreCase("Student")) {
		LinkedList<StudentNode> studentList = new LinkedList<>();

		loginOrSignup(year, studentList);

		}

	}

int roll_no;

String user, year, student, admin, name, prog_lang, mail_id, skills;
String opprtunities, AdminPassword, StudentPassword;
StudentNode temp;
// parameters for updated data
String academicYear;
int studentID;
String updatedYear, updatedMailID, updatedSkills;

public void loginOrSignup(String year, LinkedList<StudentNode> studentList) {
Set<String> validOptions = new HashSet<>();
validOptions.add("FY");
validOptions.add("SY");
validOptions.add("TY");
validOptions.add("BTECH");
System.out.println("Do you want to:\n1. Login\n2. Sign up");
int option = scanner.nextInt();
if (option == 1) {
while (true) {
try {
System.out.println("FY/SY/TY/BTECH (please enter in capital letters only)");
System.out.print("Enter your current studying year: ");
year = scanner.next();

if (validOptions.contains(year)) {
break; // Valid input, break out of the loop
} else {
System.out.println("Invalid input. Please enter one of the specified options.");
}
} catch (Exception e) {
System.out.println("Invalid input. Please enter one of the specified options.");
scanner.next(); // Consume the invalid input
}
}
while (true) {
try {
System.out.print("Enter student id: ");
studentID = scanner.nextInt();

if (studentID >= 0) {
break; // Valid input, break out of the loop
} else {
System.out.println("Invalid input. Please enter an integer between 0 and 9.");
}
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter a valid integer.");
scanner.next(); // Consume the invalid input
}
}

if (checkIfStudentExists(  studentList, studentID)) {
System.out.println("Welcome, Student!");
} else {
System.out.println("Invalid ID. Please sign-up.");
}
} else if (option == 2) {
System.out.println("Sign up as a new student.");
inputStudentDetails(year, studentList);
System.out.println("Welcome, Student!");
}
}


public boolean checkIfStudentExists(LinkedList<StudentNode> studentList, int studentId) {
for (StudentNode student : studentList) {
if (student.getId() == studentId) {
return true; // Student exists
}
}
return false; // Student does not exist
}



public void inputStudentDetails(String year, LinkedList<StudentNode> studentList) {

int ch1 = 0;
int id = 0;
String studentName, studentEmail, studentSkills, studentHobbies;
year = "";
Set<String> validOptions = new HashSet<>();
validOptions.add("FY");
validOptions.add("SY");
validOptions.add("TY");
validOptions.add("BTECH");

while (true) {
try {
System.out.println("FY/SY/TY/BTECH (please enter in capital letters only)");
System.out.print("Enter your current studying year: ");
year = scanner.next();

if (validOptions.contains(year)) {
break; // Valid input, break out of the loop
} else {
System.out.println("Invalid input. Please enter one of the specified options.");
}
} catch (Exception e) {
System.out.println("Invalid input. Please enter one of the specified options.");
scanner.next(); // Consume the invalid input
}
}

// student name with validation
do {
System.out.print("Enter Student Name: ");
studentName = scanner.next();

for (int i = 0; i < studentName.length(); i++) {
char ch = studentName.charAt(i);
ch1 = (int) ch; // typecasting character into integer
if ((ch1 < 65 || (ch1 > 90 && ch1 < 97) || ch1 > 122) && ch1 != 32) {// ASCII value of char
System.out.println("Please enter valid name with alphabets only!!");
// a = 1;
break;
}
}
} while ((ch1 < 65 || (ch1 > 90 && ch1 < 97) || ch1 > 122) && ch1 != 32);
scanner.next();
while (true) {
try {
System.out.print("Enter student id: ");
id = scanner.nextInt();

if (id >= 0) {
break; // Valid input, break out of the loop
} else {
System.out.println("Invalid input. Please enter an integer between 0 and 9.");
}
} catch (InputMismatchException e) {
System.out.println("Invalid input. Please enter a valid integer.");
scanner.next(); // Consume the invalid input
}
}
// email with validation
do {
System.out.println("Enter email addresss:");
studentEmail = scanner.next();
String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
Pattern pattern = Pattern.compile(emailRegex);
if (pattern.matcher(studentEmail).matches()) {
break;
} else {
System.out.println("Please enter valid email-ID!!");
}
} while (true);

// student skills

System.out.print("Enter Student skills:");
studentSkills = scanner.next();

System.out.print("Enter Student hobbies:");
studentHobbies = scanner.next();

studentList.add(new StudentNode(id, studentName, studentEmail, studentSkills, studentHobbies));
updateExcelFile(year, studentList);

}

public void updateExcelFile(String year, LinkedList<StudentNode> studentList) {
String fileName = year + "_student_data.xlsx";

try {
Workbook workbook;
Sheet sheet;

File file = new File(fileName);

if (!file.exists() || file.length() == 0) {
workbook = new XSSFWorkbook();
sheet = workbook.createSheet("Students");

Row headerRow = sheet.createRow(0);
headerRow.createCell(0).setCellValue("Student ID");
headerRow.createCell(1).setCellValue("Student Name");
headerRow.createCell(2).setCellValue("Student Email");
headerRow.createCell(3).setCellValue("Student Skills");
headerRow.createCell(4).setCellValue("Student Hobbies");
} else {
FileInputStream inputStream = new FileInputStream(file);
workbook = WorkbookFactory.create(inputStream);
sheet = workbook.getSheetAt(0);
}
for (int i = 0; i < studentList.size(); i++) {
int rowNum = sheet.getLastRowNum() + 1;
Row row = sheet.createRow(rowNum);
StudentNode student = studentList.get(i);
row.createCell(0).setCellValue(student.getId());
row.createCell(1).setCellValue(student.getName());
row.createCell(2).setCellValue(student.getEmail());
row.createCell(3).setCellValue(student.getSkills());
row.createCell(4).setCellValue(student.getHobbies());
}

FileOutputStream outputStream = new FileOutputStream(fileName);
workbook.write(outputStream);
workbook.close();
outputStream.close();
System.out.println("Student data saved to " + fileName);
} catch (Exception e) {
e.printStackTrace();
}
}

public void loadStudentDetailsAndUpdate(String academicYear, int studentID, String updatedYear,
String updatedMailID, String updatedSkills) {
String fileName = academicYear + "_student_data.xlsx";

try {
FileInputStream inputStream = new FileInputStream(fileName);
Workbook workbook = WorkbookFactory.create(inputStream);
Sheet sheet = workbook.getSheetAt(0);

// Search for the student by ID and update the data if found
boolean found = false;
System.out.println("hello");
for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
Row row = sheet.getRow(rowNum);
System.out.println("Cummins");
int id = (int) row.getCell(0).getNumericCellValue(); // Read ID as an integer

if (id == studentID) {
found = true;
System.out.println("hiii");
// Update the student's information
row.getCell(1).setCellValue(updatedYear); // Update the year
row.getCell(2).setCellValue(updatedMailID); // Update the mail ID
row.getCell(3).setCellValue(updatedSkills); // Update the skills

// Save the changes back to the Excel file
try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
workbook.write(fileOut);
}

System.out.println("Student with ID " + studentID + " updated successfully.");
break;

}
}

if (!found) {
System.out.println("Student with ID " + studentID + " not found.");
}

workbook.close();
} catch (FileNotFoundException e) {
System.out.println("File not found. No student data for " + academicYear);
} catch (Exception e) {
e.printStackTrace();
}
}

public void manageOpportunities() {
System.out.print("This domain is accessible to only Admin.\nSo enter Admin accessible password : ");
String password = s.next();
if (password.equals("admin@123")) {
while (true) {

System.out.println("Select an opportunity type to manage:");

System.out.println("1. Internships");

System.out.println("2. Hackathons");

System.out.println("3. Courses");

System.out.println("4. Back to main menu");

int choice = scanner.nextInt();

switch (choice) {

case 1:

manageOpportunityType("internship");

break;

case 2:

manageOpportunityType("hackathon");

break;

case 3:

manageOpportunityType("course");

break;

case 4:

return;

default:

System.out.println("Invalid choice. Please select a valid option.");

}

}
}
}

public void manageOpportunityType(String opportunityType) {

while (true) {

System.out.println("Manage " + opportunityType + " opportunities:");

System.out.println("1. Add");

System.out.println("2. Delete");

System.out.println("3. Display");

System.out.println("4. Back to previous menu");

int choice = scanner.nextInt();

switch (choice) {

case 1:

addOpportunity(opportunityType);

break;

case 2:

deleteOpportunity(opportunityType);

break;

case 3:

displayOpportunity(opportunityType);

break;

case 4:

return;

default:

System.out.println("Invalid choice. Please select a valid option.");

}

}

}

public void addOpportunity(String opportunityType) {

System.out.println("Enter opportunity details:");

System.out.println("ID: ");

int id = scanner.nextInt();

scanner.nextLine(); // Consume the newline character

System.out.println("Name: ");

String name = scanner.nextLine();

// Define the file name based on the opportunity type and academic year.

String fileName = "sy_" + opportunityType + ".xlsx";

try {

Workbook workbook;

Sheet sheet;

File file = new File(fileName);

if (!file.exists() || file.length() == 0) {

workbook = new XSSFWorkbook();

sheet = workbook.createSheet(opportunityType);

// Create the header row

Row headerRow = sheet.createRow(0);

headerRow.createCell(0).setCellValue("ID");

headerRow.createCell(1).setCellValue("Name");

} else {

FileInputStream inputStream = new FileInputStream(file);

workbook = WorkbookFactory.create(inputStream);

sheet = workbook.getSheetAt(0);

}

// Add opportunity data to the Excel file

int rowNum = sheet.getLastRowNum() + 1;

Row row = sheet.createRow(rowNum);

row.createCell(0).setCellValue(id);

row.createCell(1).setCellValue(name);

// Write the workbook to the file

FileOutputStream outputStream = new FileOutputStream(fileName);

workbook.write(outputStream);

workbook.close();

outputStream.close();

System.out.println("Opportunity added to " + fileName);

} catch (Exception e) {

e.printStackTrace();

}

}

public void deleteOpportunity(String opportunityType) {

System.out.println("Enter the ID of the opportunity you want to delete:");

int idToDelete = scanner.nextInt();

// Define the file name based on the opportunity type and academic year.

String fileName = "sy_" + opportunityType + ".xlsx";

try {

FileInputStream inputStream = new FileInputStream(fileName);

Workbook workbook = WorkbookFactory.create(inputStream);

Sheet sheet = workbook.getSheetAt(0);

// Find and remove the opportunity with the specified ID

for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {

Row row = sheet.getRow(rowNum);

int id = (int) row.getCell(0).getNumericCellValue();

if (id == idToDelete) {

sheet.removeRow(row);

break;

}

}

// Shift rows to remove the deleted row completely

sheet.shiftRows(sheet.getLastRowNum(), sheet.getLastRowNum(), -1);

// Write the updated workbook back to the file

FileOutputStream outputStream = new FileOutputStream(fileName);

workbook.write(outputStream);

workbook.close();

outputStream.close();

System.out.println("Opportunity with ID " + idToDelete + " deleted from " + fileName);

} catch (Exception e) {

e.printStackTrace();

}

}

public void displayOpportunity(String opportunityType) {

// Define the file name based on the opportunity type and academic year.

String fileName = "sy_" + opportunityType + ".xlsx";

try {

FileInputStream inputStream = new FileInputStream(fileName);

Workbook workbook = WorkbookFactory.create(inputStream);

Sheet sheet = workbook.getSheetAt(0);

// Display all opportunities in the Excel file

System.out.println("Opportunities in " + opportunityType + ":");

for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {

Row row = sheet.getRow(rowNum);

int id = (int) row.getCell(0).getNumericCellValue();

String name = row.getCell(1).getStringCellValue();

System.out.println("ID: " + id + ", Name: " + name);

}

workbook.close();

} catch (Exception e) {

e.printStackTrace();
}
}

public void AccessFor() {

opportunity obj = new opportunity();

System.out.println("Enter admin if you are admin else enter student : ");
user = s.next();
if (user.equalsIgnoreCase("Admin")) {
System.out.println("User is Admin ");
System.out.println("What is your username ? ");
admin = s.next();
System.out.println("Enter the password to login : ");
AdminPassword = s.next();
if (AdminPassword.equals("admin@123")) {
int choice;
do {

System.out.println("Welcome\nYou have the access of following details : ");

System.out.println("1.Update the list of existing opportunites");
System.out.println("Enter your choice : ");
choice = s.nextInt();
switch (choice) {
// case 2:
// obj.loadStudentDetailsAndUpdate(academicYear, studentID, updatedYear, updatedMailID,
// updatedSkills);
// break;
case 1:
obj.manageOpportunities();
break;

}

} while (choice != 0);

}

} else {
System.out.println("Sorry! You are not admin so you cannot proceed!!");
// if wrong password ask if stu/adm
}
}

public void loadStudentDetails(String academicYear) {
String fileName = academicYear + "_student_data.xlsx";

try {
FileInputStream inputStream = new FileInputStream(fileName);
Workbook workbook = WorkbookFactory.create(inputStream);
Sheet sheet = workbook.getSheetAt(0);

// Display all students in the Excel file for the selected academic year
System.out.println("Student details for " + academicYear + ":");

for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
Row row = sheet.getRow(rowNum);

int id = (int) row.getCell(0).getNumericCellValue(); // Read ID as an integer
String name = row.getCell(1).getStringCellValue();

System.out.println("ID: " + id);
System.out.println("Name: " + name);
System.out.println();
}

workbook.close();
} catch (FileNotFoundException e) {
System.out.println("File not found. No student data for " + academicYear);
} catch (Exception e) {
e.printStackTrace();
}
}

public void seeStudentDetailsByAcademicYear() {
System.out.println("See student details according to their studying year : ");
System.out.println("Enter Admin accessible password : ");
System.out.println("Enter the password to login : ");
AdminPassword = s.next();
if (AdminPassword.equals("admin@123")) {
int choice;

System.out.println("Enter your year:\n1. FY\n2. SY\n3. TY\n4. BTECH\n0. Exit");

choice = s.nextInt();

String year = "";

switch (choice) {

case 1:

year = "FY";

break;

case 2:

year = "SY";

break;

case 3:

year = "TY";

break;

case 4:

year = "BTECH";

break;

case 0:

System.out.println("Exiting...");

return;

default:

System.out.println("Invalid choice. Please select a valid option.");

return;

}

loadStudentDetails(year);
}

}

public void student_opportunities() {
int oppor_year;

int oppor_choice;

do

{

System.out.println("Enter your year:\n1.Sy\n"

+ "2.TY");

oppor_year = s.nextInt();

if (oppor_year == 1) {

System.out.println("1.Internship\n2.Hackathon\n3.Courses\nChoose an option:");

oppor_choice = s.nextInt();

switch (oppor_choice) {

case 1:

try {

// Provide only the name of your Excel file

String fileName = "sy_internship.xlsx";

FileInputStream excelFile = new FileInputStream(fileName);

// Create a Workbook object for the Excel file

Workbook workbook = new XSSFWorkbook(excelFile);

// Specify the name of the sheet you want to read

String sheetName = "Sheet1"; // Change this to the desired sheet name

Sheet sheet = workbook.getSheet(sheetName);

if (sheet != null) {

// Iterate through the rows and columns to print the data

for (Row row : sheet) {

for (Cell cell : row) {

switch (cell.getCellType()) {

case STRING:

System.out.print(cell.getStringCellValue());

break;

case NUMERIC:

System.out.print(cell.getNumericCellValue());

break;

case BOOLEAN:

System.out.print(cell.getBooleanCellValue());

break;

case BLANK:

System.out.print(" ");

break;

default:

System.out.print(" ");

break;

}

System.out.print("\t"); // Separate cells with a tab

}

System.out.println(); // Move to the next row

}

} else {

System.out.println("Sheet not found: " + sheetName);

}

// Close the Excel file

excelFile.close();

} catch (IOException e) {

e.printStackTrace();

}

break;

case 2:

try {

// Provide only the name of your Excel file

String fileName = "sy_internship.xlsx";

FileInputStream excelFile = new FileInputStream(fileName);

// Create a Workbook object for the Excel file

Workbook workbook = new XSSFWorkbook(excelFile);

// Specify the name of the sheet you want to read

String sheetName = "Sheet2"; // Change this to the desired sheet name

Sheet sheet = workbook.getSheet(sheetName);

if (sheet != null) {

// Iterate through the rows and columns to print the data

for (Row row : sheet) {

for (Cell cell : row) {

switch (cell.getCellType()) {

case STRING:

System.out.print(cell.getStringCellValue());

break;

case NUMERIC:

System.out.print(cell.getNumericCellValue());

break;

case BOOLEAN:

System.out.print(cell.getBooleanCellValue());

break;

case BLANK:

System.out.print(" ");

break;

default:

System.out.print(" ");

break;

}

System.out.print("\t"); // Separate cells with a tab

}

System.out.println(); // Move to the next row

}

} else {

System.out.println("Sheet not found: " + sheetName);

}

// Close the Excel file

excelFile.close();

} catch (IOException e) {

e.printStackTrace();

}

break;

case 3:

try {

// Provide only the name of your Excel file

String fileName = "sy_internship.xlsx";

FileInputStream excelFile = new FileInputStream(fileName);

// Create a Workbook object for the Excel file

Workbook workbook = new XSSFWorkbook(excelFile);

// Specify the name of the sheet you want to read

String sheetName = "Sheet3"; // Change this to the desired sheet name

Sheet sheet = workbook.getSheet(sheetName);

if (sheet != null) {

// Iterate through the rows and columns to print the data

for (Row row : sheet) {

for (Cell cell : row) {

switch (cell.getCellType()) {

case STRING:

System.out.print(cell.getStringCellValue());

break;

case NUMERIC:

System.out.print(cell.getNumericCellValue());

break;

case BOOLEAN:

System.out.print(cell.getBooleanCellValue());

break;

case BLANK:

System.out.print(" ");

break;

default:

System.out.print(" ");

break;

}

System.out.print("\t"); // Separate cells with a tab

}

System.out.println(); // Move to the next row

}

} else {

System.out.println("Sheet not found: " + sheetName);

}

// Close the Excel file

excelFile.close();

} catch (IOException e) {

e.printStackTrace();

}

break;

default:

System.out.println("Invalid choice!");

}

}

else if (oppor_year == 2) {

System.out.println("1.Internship\n2.Hackathon\nChoose an option:");

oppor_choice = s.nextInt();

switch (oppor_choice) {

case 1:

try {

// Provide only the name of your Excel file

String fileName = "ty_internship.xlsx";

FileInputStream excelFile = new FileInputStream(fileName);

// Create a Workbook object for the Excel file

Workbook workbook = new XSSFWorkbook(excelFile);

// Specify the name of the sheet you want to read

String sheetName = "Sheet1"; // Change this to the desired sheet name

Sheet sheet = workbook.getSheet(sheetName);

if (sheet != null) {

// Iterate through the rows and columns to print the data

for (Row row : sheet) {

for (Cell cell : row) {

switch (cell.getCellType()) {

case STRING:

System.out.print(cell.getStringCellValue());

break;

case NUMERIC:

System.out.print(cell.getNumericCellValue());

break;

case BOOLEAN:

System.out.print(cell.getBooleanCellValue());

break;

case BLANK:

System.out.print(" ");

break;

default:

System.out.print(" ");

break;

}

System.out.print("\t"); // Separate cells with a tab

}

System.out.println(); // Move to the next row

}

} else {

System.out.println("Sheet not found: " + sheetName);

}

// Close the Excel file

excelFile.close();

} catch (IOException e) {

e.printStackTrace();

}

break;

case 2:

try {

// Provide only the name of your Excel file

String fileName = "ty_internship.xlsx";

FileInputStream excelFile = new FileInputStream(fileName);

// Create a Workbook object for the Excel file

Workbook workbook = new XSSFWorkbook(excelFile);

// Specify the name of the sheet you want to read

String sheetName = "Sheet2"; // Change this to the desired sheet name

Sheet sheet = workbook.getSheet(sheetName);

if (sheet != null) {

// Iterate through the rows and columns to print the data

for (Row row : sheet) {

for (Cell cell : row) {

switch (cell.getCellType()) {

case STRING:

System.out.print(cell.getStringCellValue());

break;

case NUMERIC:

System.out.print(cell.getNumericCellValue());

break;

case BOOLEAN:

System.out.print(cell.getBooleanCellValue());

break;

case BLANK:

System.out.print(" ");

break;

default:

System.out.print(" ");

break;

}

System.out.print("\t"); // Separate cells with a tab

}

System.out.println(); // Move to the next row

}

} else {

System.out.println("Sheet not found: " + sheetName);

}

// Close the Excel file

excelFile.close();

} catch (IOException e) {

e.printStackTrace();

}

break;

default:

System.out.println("Invalid choice!");

}

}

else {

System.out.println("Invalid choice!");

}

} while (oppor_year != 1 && oppor_year != 2);
}

}

class Question {

public String question_text;

public String[] answerChoices;

public int correctAnswerIndex;

public Question(String question_text, String[] answerChoices, int correctAnswerIndex) {

this.question_text = question_text;

this.answerChoices = answerChoices;

this.correctAnswerIndex = correctAnswerIndex;

}

public String displayQuestion() {

return question_text;

}

public String[] answerChoice() {

return answerChoices;

}

public int correctAnswer() {

return correctAnswerIndex;

}

}

class Quiz {

public void startQuiz() {

Queue<Question> questionQueue = new LinkedList<>();

initializeQuestions(questionQueue);

Scanner sc = new Scanner(System.in);

int score = 0;

while (!questionQueue.isEmpty()) {

Question currentQuestion = questionQueue.poll();

System.out.println(currentQuestion.displayQuestion());

for (int i = 0; i < currentQuestion.answerChoice().length; i++) {

System.out.println((i + 1) + ": " + currentQuestion.answerChoice()[i]);

}

int choice = 0;

boolean validInput = false;

while (!validInput) {

try {

System.out.print("Enter your choice (1-4): ");

choice = sc.nextInt();

if (choice < 1 || choice > 4) {

System.out.println("Invalid input. Please enter a correct option (1-4).");

} else {

validInput = true;

}

} catch (InputMismatchException e) {

sc.nextLine(); // Clear the invalid input

System.out.println("Invalid input. Please enter a correct option (1-4).");

}

}

if (choice == currentQuestion.correctAnswer()) {

System.out.println("Yay!!! You got it right!!!");

score++;

} else {

System.out.println("Oops, wrong answer. The correct answer is: " +

currentQuestion.answerChoice()[currentQuestion.correctAnswer() - 1]);

}

System.out.println();

}

System.out.println("Quiz completed. Your score: " + score + " out of " + questionCount());

if (score == 5) {

System.out.println("Good job!!! Keep it up!!!");

}

if (score >= 2 && score <= 4) {

System.out.println("You are almost there!!! Keep practicing!!!");

} else {

System.out.println("You need more practice!!!");

}

}

public void initializeQuestions(Queue<Question> questionQueue) {

questionQueue.offer(new Question(

"What is the time complexity of insert in a hashtable?",

new String[] { "O(1)", "O(n)", "O(2n)", "None" },

1 // Correct answer index

));

questionQueue.offer(new Question(

"Which type of binary search tree is designed to maintain balance and ensure "

+ "O(logn) height?",

new String[] { "Hash Table", "Splay Tree", "AVL Tree", "Binary Heap" },

3 // Correct answer

));

questionQueue.offer(new Question(

"Which programming language is often associated with a high level of abstraction?",

new String[] { "Java", "Python", "C++", "C" },

2 // Correct answer

));

questionQueue.offer(new Question(

"How can you restrict access to the attribute of a class in Java?",

new String[] { "By declaring them as private", "By declaring them as protected",
"By declaring them as public", "None" },

1 // Correct answer

));

questionQueue.offer(new Question(

"What function is used to append a character at the back of the string?",

new String[] { "add_at_end()", "join_end()", "append()", "push_back()" },

4 // Correct answer

));

}

private static int questionCount() {

return 5;

}

}

/* OUTPUT OF THE CODE:
 * 
 * 
 * 
 What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

1

Do you want to:

1. Login

2. Sign up

2

Sign up as a new student.

FY/SY/TY/BTECH (please enter in capital letters only)

Enter your current studying year: SY

Enter Student Name: 81293nmnms,d

Please enter valid name with alphabets only!!

Enter Student Name: Sanika Mane

Enter student id: aaaa

Invalid input. Please enter a valid integer.

Enter student id: 113

Enter email addresss:

qqweewwe!!

Please enter valid email-ID!!

Enter email addresss:

sanika@123

Please enter valid email-ID!!

Enter email addresss:

sanika@gmail.in

Enter Student skills:Java

Enter Student hobbies:Dance

Student data saved to SY_student_data.xlsx

Welcome, Student!

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

1

Do you want to:

1. Login

2. Sign up

1

FY/SY/TY/BTECH (please enter in capital letters only)

Enter your current studying year: SY

Enter student id: 113

Welcome, Student!

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

4

Enter your year:

1.Sy

2.TY

1

1.Internship

2.Hackathon

3.Courses

Choose an option:

2

Sheet not found: Sheet2

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

5

What is the time complexity of insert in a hashtable?

1: O(1)

2: O(n)

3: O(2n)

4: None

Enter your choice (1-4): 1

Yay!!! You got it right!!!



Which type of binary search tree is designed to maintain balance and ensure O(logn) height?

1: Hash Table

2: Splay Tree

3: AVL Tree

4: Binary Heap

Enter your choice (1-4): 2

Oops, wrong answer. The correct answer is: AVL Tree



Which programming language is often associated with a high level of abstraction?

1: Java

2: Python

3: C++

4: C

Enter your choice (1-4): 3

Oops, wrong answer. The correct answer is: Python



How can you restrict access to the attribute of a class in Java?

1: By declaring them as private

2: By declaring them as protected

3: By declaring them as public

4: None

Enter your choice (1-4): 4

Oops, wrong answer. The correct answer is: By declaring them as private



What function is used to append a character at the back of the string?

1: add_at_end()

2: join_end()

3: append()

4: push_back()

Enter your choice (1-4): 6

Invalid input. Please enter a correct option (1-4).

Enter your choice (1-4): 2

Oops, wrong answer. The correct answer is: push_back()



Quiz completed. Your score: 1 out of 5

You need more practice!!!

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

3

See student details according to their studying year : 

Enter Admin accessible password : 

Enter the password to login : 

sanika@123

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

2

Enter admin if you are admin else enter student : 

admin

User is Admin 

What is your username ? 

Admin

Enter the password to login : 

admin111

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

2

Enter admin if you are admin else enter student : 

admin

User is Admin 

What is your username ? 

Admin

Enter the password to login : 

admin@123

Welcome

You have the access of following details : 

1.Update the list of existing opportunites

Enter your choice : 

1

This domain is accessible to only Admin.

So enter Admin accessible password : admin@123

Select an opportunity type to manage:

1. Internships

2. Hackathons

3. Courses

4. Back to main menu

2

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

1

Enter opportunity details:

ID: 



12

Name: 

SIH HACKATHON

Opportunity added to sy_hackathon.xlsx

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

3

Opportunities in hackathon:

ID: 12, Name: SIH HACKATHON

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

1

Enter opportunity details:

ID: 

13

Name: 

GOOGLE STEP INTERN HACKATHON

Opportunity added to sy_hackathon.xlsx

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

3

Opportunities in hackathon:

ID: 12, Name: SIH HACKATHON

ID: 13, Name: GOOGLE STEP INTERN HACKATHON

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

2

Enter the ID of the opportunity you want to delete:

12

Opportunity with ID 12 deleted from sy_hackathon.xlsx

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

3

Opportunities in hackathon:

ID: 13, Name: GOOGLE STEP INTERN HACKATHON

Manage hackathon opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

4

Select an opportunity type to manage:

1. Internships

2. Hackathons

3. Courses

4. Back to main menu

3

Manage course opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

1

Enter opportunity details:

ID: 

22

Name: 

Udemy

Opportunity added to sy_course.xlsx

Manage course opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

3

Opportunities in course:

ID: 3, Name: er

ID: 22, Name: Udemy

Manage course opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

2

Enter the ID of the opportunity you want to delete:

3

Opportunity with ID 3 deleted from sy_course.xlsx

Manage course opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

2

Enter the ID of the opportunity you want to delete:

2

Opportunity with ID 2 deleted from sy_course.xlsx

Manage course opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

3

Opportunities in course:

Manage course opportunities:

1. Add

2. Delete

3. Display

4. Back to previous menu

4

Select an opportunity type to manage:

1. Internships

2. Hackathons

3. Courses

4. Back to main menu

4

Welcome

You have the access of following details : 

1.Update the list of existing opportunites

Enter your choice : 

0

What do you want to do?

1)Student login/signup 

2)Admin access 

3)See student details by academic year(only for admin)

4)Opportunities for student

5)Start your assessment quiz

6)Exit 

6

*****Exiting....***** 
 */
 