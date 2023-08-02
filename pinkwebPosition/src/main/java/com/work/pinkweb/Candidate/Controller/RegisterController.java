package com.work.pinkweb.Candidate.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.work.pinkweb.Candidate.Service.LoginService;
import com.work.pinkweb.Candidate.Service.RegisterService;
import com.work.pinkweb.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    //注册账号1
    @RequestMapping(value = "/premise/candidate_register/step_1",method = RequestMethod.POST)
    @ResponseBody
    public Integer candidateRegister(@RequestBody Map<String, Map> para) throws JsonProcessingException {
        String phone=para.get("data").get("phone").toString();
        String password=para.get("data").get("password").toString();
        return registerService.candidateRegister(phone,password);
    }

    //注册账号2
    @RequestMapping(value = "/premise/candidate_register/step_2",method = RequestMethod.POST)
    @ResponseBody
    public Integer udateUserBase(@RequestBody Map<String,Map> para) throws JsonProcessingException, ParseException {
        //取出传入的电话，姓名，性别，生日
        String phone=para.get("data").get("phone").toString();
        String name=para.get("data").get("name").toString();
        Integer sex=Integer.valueOf(para.get("data").get("sex").toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = para.get("data").get("birthday").toString();
        Date date = simpleDateFormat.parse(birthday);
        return registerService.perfectCandidateInfo(phone,name,sex,date);
    }
}
