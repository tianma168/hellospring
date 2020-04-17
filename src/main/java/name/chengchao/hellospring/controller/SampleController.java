package name.chengchao.hellospring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import name.chengchao.hellospring.util.LocalInfoUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    public static final String lineBreak = "\n";

    @RequestMapping("/")
    @ResponseBody
    String root() {
        return "Hello World! @" + new Date();
    }

    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("getAllIpv4NoLoopbackAddresses:" + LocalInfoUtils.getAllIpv4NoLoopbackAddresses());
            sb.append(lineBreak);
            sb.append("HostName:" + LocalInfoUtils.getHostNameForLiunx());
            sb.append(lineBreak);
            sb.append(new Date());
            sb.append(lineBreak);
            response.getWriter().write(sb.toString());
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    @RequestMapping("/test")
    public void test(HttpServletRequest request, HttpServletResponse response) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread());
            response.getWriter().write(sb.toString());
            response.flushBuffer();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

}
