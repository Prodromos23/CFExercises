package ch9.Exersise;

import java.io.*;

public class GradesAssignment {

    public static void main(String[] args) {
        String line = "";
        String[] student_grade1;
        String[] student_grade2;
        double average;
        String student_name;
        String[] student;
        String regex = "^\\s*\\S+\\s+\\S+\\s+(\\d+)\\s+(\\d+)";
        try (BufferedReader bf = new BufferedReader(new FileReader("/Users/prodromos/Documents/CodingFactory/Java/CodingFactory/CodingFactory_Courses/CodingFactoryC/src/ch9/Excersise/Grades.txt"));) {
            while ((line = bf.readLine()) != null){
                student = line.split("[^A-Za-z]"); //find the name of the student
                student_name = student[0] + " " + student[1];
                    if (line.matches(regex)) {
                        int firstGrade = Integer.parseInt(line.replaceAll(regex, "$1"));
                        int secondGrade = Integer.parseInt(line.replaceAll(regex, "$2"));
                        if (isValidInt(firstGrade) && isValidInt(secondGrade)){
                            average = (double) (firstGrade + secondGrade) /2 ;
                            System.out.println(average);
                            writeToFile(student_name,average);
                        } else {
                          writeIfFalse(false,student[0]);
                        }
                    }
            }
        } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static boolean isValidInt(int num){
        return num <= 10 && num >= 0;
    }

    public static void writeToFile(String name, double avg) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/prodromos/Documents/CodingFactory/Java/CodingFactory/CodingFactory_Courses/CodingFactoryC/src/ch9/Excersise/primOut.txt", true));
            writer.write("The average grade of "+ name +" is " + avg + "\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
        }
    }

    public static void writeIfFalse(boolean result, String value ) {
        if (!result){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/prodromos/Documents/CodingFactory/Java/CodingFactory/CodingFactory_Courses/CodingFactoryC/src/ch9/Excersise/log.txt", true));
            writer.write("Invalid value for: " + value);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
            e.printStackTrace();
            }
        }
        System.out.println("No error!");

    }



    }

