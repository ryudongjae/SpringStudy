package ryudongjae.core.web;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ryudongjae.core.common.MyLogger;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        System.out.println("myLogger =" +myLogger.getClass());
        String requestURL = request.getRequestURL().toString();
        myLogger.setRequestUrl(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("test id");
        return "OK";
    }
}
