package Evalution_6;

import javafx.scene.transform.Scale;

import java.sql.*;
import java.util.Scanner;

public class MenuFuntionality {
    Scanner sc = new Scanner(System.in);
    Connection con = Connectivity.connection();

    Statement statement;

    {
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void retrive()
    {
        System.out.println("whoes data you want to retrive");
        System.out.println("1 for teacher\n2 for student");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                try {
                    ResultSet resultSet = statement.executeQuery("select * from teacherdata");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5)+" "+resultSet.getInt(6));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    ResultSet resultSet = statement.executeQuery("select * from studentdata");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+" "+resultSet.getInt(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getInt(5));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

    void update(){
        System.out.println("whoes data you want to update");
        System.out.println("1 for update teacher salary\n2 for update student marks");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("enter the teacher id whoes salary want to update");
                int tid = sc.nextInt();
                System.out.println("enter the salary");
                int salary = sc.nextInt();
                try {
                    PreparedStatement preparedStatement = con.prepareStatement("update teacherdata set salary="+salary+" where tid="+tid);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("enter the student id whoes Marks want to update");
                int sid = sc.nextInt();
                System.out.println("enter the Marks");
                int marks = sc.nextInt();
                try {
                    PreparedStatement preparedStatement = con.prepareStatement("update studentdata set marks="+marks+"where id="+sid);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }

    void delete(){
        System.out.println("whoes data you want to delete");
        System.out.println("1 for delete teacher record\n2 for delete student record");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("enter the teacher id");
                int tid = sc.nextInt();

                try {
                    PreparedStatement preparedStatement = con.prepareStatement("delete from teacherdata where tid="+tid);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println("enter the student id");
                int sid = sc.nextInt();
                try {
                    PreparedStatement preparedStatement = con.prepareStatement("delete from studentdata where id="+sid);
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
    }
    void studentQ(){
        try {
            ResultSet resultSet = statement.executeQuery("select name from studentdata where name like'z%'");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void insert(){
        System.out.println("whoes data you want to insert");
        System.out.println("1 for insert teacher data\n2 for insert student data");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                System.out.println("Insert the below data");
                System.out.println("Enter the id");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the name");
                String name =sc.nextLine();
                System.out.println("enter the subject");
                String subject = sc.nextLine();

                break;
            case 2:
                break;
        }
    }

    void teachQ(){
        try {
            ResultSet resultSet = statement.executeQuery("select name from teacherdata where experience>=5 and salary>=5000;");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void Quer(){
        try {
            ResultSet resultSet = statement.executeQuery("select s.name from studentdata s join teacherdata t on t.tid=s.tid where t.city in('pune','mumbai') and t.name like('a%')");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
