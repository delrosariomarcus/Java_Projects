/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Java_StudentInfoSystem;

import java.util.ArrayList;

/**
 *
 * @author delro
 */
public class StudentInfoSystem 
{
    private class Node
    {
        String ID;
        String lname;
        String fname;
        String phone;
        String major;
        double gpa;
        int year;
        int month;
        int day;
        String address;
        Node next;
        Node prev;
        
        
        public Node(String id, String ln, String fn, String ph, String mj, double gp, int y, int m, int d, String addie)
        {
            ID = id;
            lname = ln;
            fname = fn;
            phone = ph;
            major = mj;
            gpa = gp;
            year = y;
            month = m;
            day = d;
            address = addie;
            next = null;
            prev = null;
        }
    }
    private int length;
    private Node head;
    private Node tail;
    private Node currPos;
    
    public StudentInfoSystem()
    {
        head = tail = currPos = null;
        length = 0;
    }
    
    public void addStudents (String id, String ln, String fn, String ph, String mj, double gp, int y, int m, int d, String addr)
    {
        Node newNode = new Node(id, ln, fn, ph, mj, gp, y, m, d, addr);
        if(tail!=null)
        {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        length++;
        if (length==1)
        {
            head = newNode;
        }
    }
    
    public String deleteStudent(String id)
    {
        if(length==0)
            return null;
        boolean found = false;
        Node curr = head;
       
        if (length==1)
        {
            if (curr.ID.equals(id))
            {
            curr=null;
            length--;
            return "Student Deleted";
            }
             else
                return "Error, ID cannot be detected";
        }
        while (!found && curr!=null)
        {
            if (id.equals(curr.ID))
            {
                found = true;
                break;
            }
            curr = curr.next;
        }
        if (found)
        {
            if(curr==head)
            {
                head = curr.next;
                head.prev= null;
            }
            else if (curr==tail)
            {
                tail=curr.prev;
                tail.next=null;
            }
            else
            {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            }
            length--;
            deleteStudent(id);
            return "Student deleted";
        }
        else
            return "ID not found";
            
    }
    
    public void listStudent(String comp, String info)
    {
        Node curr = head;
        if(comp.equals("StudentID"))
        {
            while(curr!=null)
            {
                if(curr.ID.equals(info))
                    System.out.println(curr.lname + " " + curr.fname);
                curr = curr.next;
            }
        }
        else if(comp.equals("Major"))
        {
            while(curr!=null)
            {
                if(curr.major.equals(info))
                    System.out.println(curr.lname + " " + curr.fname);
                curr = curr.next;
            }
        }
        
    }
    
    public void sortList(String choice, String s)
    {
        if(s.equals("ID"))
            sortID(choice);
        else if(s.equals("GPA"))
            sortGPA(choice);
        else if(s.equals("Birthday"))
            sortBday(choice);
    }
    private void sortID(String choice)
    {
        if(choice.equalsIgnoreCase("ascending"))
        {
            for (int i=0;i<=length-2;i++)
            {
                Node curr = tail;
                while (curr!=head)
                {
                    if (Integer.parseInt(curr.ID) < Integer.parseInt(curr.prev.ID))
                        swapInfo(curr);
                    else
                        curr = curr.prev;
                }
            }
        }
        else if(choice.equalsIgnoreCase("descending"))
        {
            for (int i=0;i<=length-2;i++)
            {
                Node curr = tail;
                while (curr!=head)
                {
                    if (Integer.parseInt(curr.ID) > Integer.parseInt(curr.prev.ID))
                        swapInfo(curr);
                    else
                        curr = curr.prev;
                }
            }
        }
    }
    
    private void sortGPA(String choice)
    {
        if(choice.equalsIgnoreCase("ascending"))
        {
            for (int i=0;i<=length-2;i++)
            {
                Node curr = tail;
                while (curr!=head)
                {
                    if (curr.gpa < curr.prev.gpa)
                        swapInfo(curr);
                    else
                        curr = curr.prev;
                }
            }
        }
        else if(choice.equalsIgnoreCase("descending"))
        {
            for (int i=0;i<=length-2;i++)
            {
                Node curr = tail;
                while (curr!=head)
                {
                    if (curr.gpa > curr.prev.gpa)
                        swapInfo(curr);
                    else
                        curr = curr.prev;
                }
            }
        }
    }
    
    private void sortBday(String choice)
    {
        if(choice.equalsIgnoreCase("ascending"))
        {
            for (int i=0;i<=length-2;i++)
            {
                Node curr = tail;
                while (curr!=head)
                {
                    if (curr.year == curr.prev.year)
                    {
                        if(curr.month == curr.prev.month)
                        {
                            if(curr.day < curr.prev.day)
                            {
                                swapInfo(curr);
                            }
                            else
                            {
                                curr = curr.prev;
                            }
                        }
                        else if(curr.month < curr.prev.month)
                        {
                            swapInfo(curr);
                        }
                        else
                            curr = curr.prev;
                    }
                    else if(curr.year < curr.prev.year)
                    {
                        swapInfo(curr);
                    }
                    else
                        curr = curr.prev;
                }
            }
        }
        else if(choice.equalsIgnoreCase("descending"))
        {
            for (int i=0;i<=length-2;i++)
            {
                Node curr = tail;
                while (curr!=head)
                {
                    if (curr.year == curr.prev.year)
                    {
                        if(curr.month == curr.prev.month)
                        {
                            if(curr.day > curr.prev.day)
                            {
                                swapInfo(curr);
                            }
                            else
                            {
                                curr = curr.prev;
                            }
                        }
                        else if(curr.month > curr.prev.month)
                        {
                            swapInfo(curr);
                        }
                        else
                            curr = curr.prev;
                    }
                    else if(curr.year > curr.prev.year)
                    {
                        swapInfo(curr);
                    }
                    else
                        curr = curr.prev;
                }
            }
        }
    }
    private void swapInfo(Node curr)
    {
        String tempID = curr.ID;
        String tempLName = curr.lname;
        String tempFName = curr.fname;
        String tempPhone = curr.phone;
        String tempMajor = curr.major;
        double tempGPA = curr.gpa;
        int tempYear = curr.year;
        int tempMonth = curr.month;
        int tempDay = curr.day;
        String tempAddress = curr.address;
        curr.ID = curr.prev.ID;
        curr.lname = curr.prev.lname;
        curr.fname = curr.prev.fname;
        curr.phone = curr.prev.phone;
        curr.major = curr.prev.major;
        curr.gpa = curr.prev.gpa;
        curr.year = curr.prev.year;
        curr.month = curr.prev.month;
        curr.day = curr.prev.day;
        curr.address = curr.prev.address;
        curr.prev.ID = tempID;
        curr.prev.lname = tempLName;
        curr.prev.fname = tempFName;
        curr.prev.phone = tempPhone;
        curr.prev.major = tempMajor;
        curr.prev.gpa = tempGPA;
        curr.prev.year = tempYear;
        curr.prev.month = tempMonth;
        curr.prev.day = tempDay;
        curr.prev.address = tempAddress;
    }
    @Override
    public String toString()
    {
        String output = "There are "+this.length+" students in the system\n";
        Node curr = head;
        while(curr!=null)
        {
            String temp = "ID number: " + curr.ID + " Last Name: " + curr.lname +
                    " First Name: " + curr.fname + " Phone Number: " + curr.phone +
                    " Major: " + curr.major + " GPA: " + curr.gpa + " Birthday: " + curr.year +"/" 
                    + curr.month +"/"+ curr.day + " Address: " + curr.address + "\n";
            output= output + temp + "\n";
            curr = curr.next;
        }
        return output;
    }
}

