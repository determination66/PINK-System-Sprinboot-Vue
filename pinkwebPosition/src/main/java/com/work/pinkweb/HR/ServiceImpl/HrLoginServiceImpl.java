package com.work.pinkweb.HR.ServiceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.pinkweb.Candidate.Mapper.LoginMapper;
import com.work.pinkweb.Candidate.Service.LoginService;
import com.work.pinkweb.Entity.User;
import com.work.pinkweb.HR.Mapper.HrLoginMapper;
import com.work.pinkweb.HR.Service.HrLoginService;
import com.work.pinkweb.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class HrLoginServiceImpl implements HrLoginService {
    @Autowired
    private HrLoginMapper hrLoginMapper;

    @Override
    public String hrLogin(String phone, String password) throws JsonProcessingException {
        User user = hrLoginMapper.hrLogin(phone);
        System.out.println(user);
        System.out.println("*********************************************************");
        if(user==null) {
            return "用户不存在";
        }
        else{
            //密码匹配并且type=1身份为HR时
            if(password.equals(user.getPassword())&&user.getType().intValue()==1){
                String token= TokenUtil.sign(user);
                HashMap<String,Object> hs=new HashMap<>();
                hs.put("token",token);
                ObjectMapper objectMapper=new ObjectMapper();
                return objectMapper.writeValueAsString(hs);
            }else if(user.getType().intValue()!=1){
                System.out.println(user.getType().intValue());
                return "身份不符";
            }
            else {
                return "账号或密码错误";
            }
        }


    }

    @Override
    public User getHrInfo(String phone) {
        return hrLoginMapper.hrLogin(phone);
    }
}
