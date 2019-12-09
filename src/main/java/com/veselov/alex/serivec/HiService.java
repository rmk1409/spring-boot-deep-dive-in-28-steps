package com.veselov.alex.serivec;

import org.springframework.stereotype.Service;

@Service
public class HiService {
    public String getHiMsg() {
        return "Hi!";
    }
}
