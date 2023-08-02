package com.work.pinkweb.HR.ServiceImpl;

import com.work.pinkweb.Entity.User;
import com.work.pinkweb.HR.Mapper.UserMapper;
import com.work.pinkweb.HR.Service.UserService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer updateAvatarById(Integer uid, String avatar) {

        return userMapper.updateAvatarById(uid,avatar);
    }

    @Select("select a.* " +
            "from apply as a " +
            "left join candidate as c on c.c_id=a.u_id " +
            "left join user as u on u.id=a.u_id " +
            "left join resume as r on r.resume_id=a.r_id " +
            "where u_id = #{u_id};")
    @Override
    public User getUserById(Integer uid) {
        return userMapper.getUserById(uid);
    }
}
