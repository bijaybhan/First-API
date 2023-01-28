package com.avengers.studentManagement;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository
{

    Map<Integer, Student> dB = new HashMap<>();

    public Student getStudent(int id)
    {
        return dB.get(id);
    }

    public String addStudent(Student student)
    {
        int id = student.getAdmnNo();
        dB.put(id,student);

        return "Added Successfully";
    }

    public String deleteStudent(@PathVariable("id") int id)
    {
        if (!dB.containsKey(id))
        {
            return "Invalid Id";
        }

        dB.remove(id);
        return "Student removed Successfully";
    }

    public String updateStudent(int id, int age)
    {
        if (!dB.containsKey(id))
        {
            return null;
        }

//        Student student = dB.get(id);
//        student.setAge(age);
        //dB.put(id,student);
        dB.get(id).setAge(age);

        return  "Age Updated Successfully";
    }

}
