package com.thrift.impl;//package com.thrift.impl;
//
//import com.thrift.thrift.TUser;
//import com.thrift.thrift.TUserService;
//import org.apache.thrift.TException;
//
///**
// * Created by mahailong on 16/9/6.
// */
//public class UserServiceImpl implements TUserService.Iface {
//    @Override
//    public boolean login(TUser tUser) throws TException {
//        //数据库验证用户名和密码
//        if("root".equals(tUser.getUserName()) && "123456".equals(tUser.getPassword())){
//            return true;
//        }
//        return false;
//    }
//}
