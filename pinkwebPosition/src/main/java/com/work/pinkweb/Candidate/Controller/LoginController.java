package com.work.pinkweb.Candidate.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.work.pinkweb.Candidate.Service.LoginService;
import com.work.pinkweb.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    //求职者登录
    @RequestMapping(value = "/premise/candidate_login",method = RequestMethod.POST)
    @ResponseBody
    public String applyLogin(@RequestBody Map<String, Map> para) throws JsonProcessingException {
        String phone=para.get("data").get("phone").toString();
        String password=para.get("data").get("password").toString();
//        int type = (int) para.get("data").get("type");
//        System.out.println(phone+" "+password+" "+type );
        String state = loginService.candidateLogin(phone,password);
        System.out.println("state="+state);
        return state;
    }

    //通过电话获取个人信息
    @RequestMapping(value = "/premise/candidate_login/{phone}",method = RequestMethod.GET)
    @ResponseBody
    public User getUserInfo(@PathVariable("phone") String phone) throws JsonProcessingException {
        return loginService.getUserInfo(phone);
    }
}
