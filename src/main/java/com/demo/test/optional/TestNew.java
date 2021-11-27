package com.demo.test.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author jonyliu
 * @date 2021/11/25 16:26
 */
public class TestNew {


    @Test
    public void test01(){
        User user = null;
        user = new User();
        user.setName("hello");
        user = Optional.ofNullable(user).orElse(createUser());
        user = Optional.ofNullable(user).orElseGet(() -> createUser());
    }

    public User createUser(){
        User user = new User();
        user.setName("zhangsan");
        return user;
    }

    @Test
    public void test02(){
        try{
            User user = null;
            Optional.ofNullable(user).orElseThrow(()->new Exception("用户不存在"));
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void test03(){
        User user = new User();
        user.setName("zhangsan");
        String city = Optional.ofNullable(user).map(u-> u.getName()).get();
        System.out.println(city);
    }

    public String getCity(User user)  throws Exception{
        if(user!=null){
            if(user.getAddress()!=null){
                Address address = user.getAddress();
                if(address.getCity()!=null){
                    return address.getCity();
                }
            }
        }
        throw new Exception("取值错误");
    }


    public String getCityNew(User user) throws Exception{
        return Optional.ofNullable(user)
                .map(u-> u.getAddress())
                .map(a->a.getCity())
                .orElseThrow(()->new Exception("取指错误"));
    }

    @Test
    public void test04() throws Exception{
        User user = createUser();
        Address address = new Address();
        address.setCity("shanghai");
        user.setAddress(address);
        System.out.println(getCityNew(user));
    }

    @Test
    public void test05(){
        User user = createUser();
        Optional.ofNullable(user)
                .ifPresent(u->{
                    System.out.println("something");
                });
    }

    public User getUser(User user) {
        return Optional.ofNullable(user)
                .filter(u->"zhangsan".equals(u.getName()))
                .orElseGet(()-> {
                    User user1 = new User();
                    user1.setName("zhangsan");
                    return user1;
                });
    }

    @Test
    public void test06(){
        User user = new User();
        user.setName("hello");
        user = getUser(null);
        System.out.println(user.getName());
    }

}
