package com.demo.test.optional;

/**
 * @author jonyliu
 * @date 2021/11/25 16:25
 */
public class TestOld {

    public static void main(String[] args) {

        User user = null;

        if(user!=null){
            Address address = user.getAddress();
            if(address!=null){
                String province = address.getProvince();
            }
        }
    }

}
