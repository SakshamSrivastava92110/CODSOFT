import java.util.Scanner;
public class Student_Grade_Calculator {
    Scanner sc= new Scanner(System.in);
    int Number_of_Subjects ;
    String Subject[];
    int Marks[];
    int Total_Marks;
    int Max_Marks;
    float Average_Percentage;
    Student_Grade_Calculator(){
        System.out.println("Enter the Number of Subjects : ");
        Number_of_Subjects = sc.nextInt();
        Subject = new String[Number_of_Subjects];
        Marks = new int[Number_of_Subjects];
        Total_Marks = 0;
        Average_Percentage = 0;
    }
    void input(){
        System.out.println("Enter the Subjects : ");
        for(int i=0 ; i<Subject.length ; i++)
            Subject[i] = sc.next();
        System.out.println("Enter the marks in each subject : ");
        for(int i=0 ; i<Marks.length ; i++)
            Marks[i] = sc.nextInt();
    }
    float calculate(){
        for(int i=0 ; i<Marks.length ; i++){
            System.out.println(Marks[i]);
            Total_Marks += Marks[i];
    }
    Max_Marks = 100*Number_of_Subjects;
        Average_Percentage = ((float)Total_Marks/Max_Marks)*100;
        return Average_Percentage;
    }
    char Grade(){
        float x = calculate();
            if (x > 90) return 'A';
            else if (x > 85 && x <= 90) return 'B' ;
            else if (x > 80 && x <= 85) return 'C' ;
            else if (x > 70 && x <= 80) return 'D' ;
            else if (x > 60 && x <= 70) return 'E' ;
            else  return 'F' ;
    }
    void display(){
        char gr = Grade();
        System.out.println("Total Marks : "+Total_Marks);
        System.out.println("Average percentage : "+Average_Percentage+"%");
        System.out.println("Grade : "+gr);
    }
    public static void main(String[] args) {
        Student_Grade_Calculator obj = new Student_Grade_Calculator();
        obj.input();
        obj.display();
    }
}
