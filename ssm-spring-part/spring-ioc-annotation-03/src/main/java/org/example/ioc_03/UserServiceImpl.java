package org.example.ioc_03;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public String show() {
        return "UserServiceImp.show() called!";
    }
}
