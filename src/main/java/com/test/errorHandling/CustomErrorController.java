package com.test.errorHandling;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//@Controller
//@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

//    @Autowired
//    private ErrorAttributes errorAttributes;
//    @ResponseBody
//    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
//    public String getErrorPath(HttpServletRequest request, Model model) {
//        WebRequest webRequest = new ServletWebRequest(request);
//        Map<String,Object> map = errorAttributes.getErrorAttributes(webRequest, true);
//        model.addAllAttributes(map);
//        return "error";
//    }

    @Override
    public String getErrorPath() {
        return "";
    }
}
