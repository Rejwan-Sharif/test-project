package com.test.errorHandling;

import org.springframework.boot.web.servlet.error.ErrorController;

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
