package com.donghua;

import com.donghua.entity.IUser;
import com.donghua.entity.User;
import com.donghua.entity.UserService;

import java.math.BigInteger;

public class MySqlDemo {

    public static void main(String[] args) {
        try {

            IUser userService = new UserService();
            //查询指定账户信息
            System.out.println(userService.queryByAccount("20200711001"));
            //开户功能
            User user = new User();
            user.setAccount("20200711002");
            user.setName("李四");
            user.setCard_type("护照");
            user.setCard_id("61052866666666");
            user.setPwd("145222");
            user.setMoney(BigInteger.valueOf(5000000));
            userService.add(user);


        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }
    }
}
