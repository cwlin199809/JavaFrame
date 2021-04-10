package com.cwlin.demo01;

//代理角色：中介
public class Proxy implements Rent{
    private Host host;
    public Proxy() {}
    public Proxy(Host host) { this.host = host;}

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        signContract();
        charge();
    }

    //看房
    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    //签合同
    public void signContract(){
        System.out.println("中介签租赁合同");
    }
    //收中介费
    public void charge(){
        System.out.println("中介收中介费");
    }
}
