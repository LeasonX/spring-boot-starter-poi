package cn.ehi.excel.controller;

import cn.ehi.excel.controller.annotation.ErrorCode;
import cn.ehi.excel.controller.annotation.ErrorMessage;
import cn.ehi.excel.controller.entity.User;
import cn.ehi.excel.controller.exception.ServiceException;
import cn.ehi.excel.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseResult<User> addUser(@Valid @RequestBody User user){
//        System.out.println(user);
        if(Math.random()>0.5){
            userService.test();
        }
//        throw new ServiceException(ErrorCode.ILLEGAL_PARAMS,"sss");
        return RestResultGenerator.genSuccess(user);
    }

    @GetMapping("/user")
    public void getUser(){
        if(Math.random()>0.5){
            userService.test1();
        }
    }

}
