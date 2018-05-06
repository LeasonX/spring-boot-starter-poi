package cn.ehi.excel.controller.service;

import cn.ehi.excel.controller.exception.ServiceException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void test(){
        throw new ServiceException(200,"222222");
    }

    public void test1(){
        String s = null;
        System.out.println(s.toUpperCase());
    }

}
