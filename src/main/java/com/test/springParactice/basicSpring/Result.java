package com.test.springParactice.basicSpring;


import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@ToString
@Component
public class Result {

//    @Type(resultType = ResultType.GOOD)
    private String type;
    private Student student;

    @Autowired
    public Result(@Type(resultType = ResultType.GOOD) String type, Student student){
        this.type = type;
        this.student = student;
    }


}
