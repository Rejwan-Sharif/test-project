package com.test.customInterceptor;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sound.sampled.Line;
import java.util.List;

@Controller
@RequestMapping("/analytics")
@AllArgsConstructor
public class TestController {


    private final RequestRepo requestRepo;

    @GetMapping("/api/v1/home")
    public String getTemplate(Model model){
        List<InfoDto> data = requestRepo.getTracker();
        model.addAttribute("infoData", data);
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "dashboard";
    }
    @GetMapping("/request-data")
    @ResponseBody
    public List<InfoDto>state(){
        return requestRepo.getTracker();
    }

}
