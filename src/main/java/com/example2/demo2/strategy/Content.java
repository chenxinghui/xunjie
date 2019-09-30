package com.example2.demo2.strategy;

public class Content {
    private Strategy strategy;

    public Content(Strategy strategy){
        this.strategy = strategy;
    }
    public void excuter(){
        strategy.say();
    }

    public static void main(String[] args){
        Content content;
        System.out.println("开始执行策略");
        content = new Content(new BringStrategy());
        content.excuter();
        System.out.println("开始执行第二个策略");
        content = new Content(new ComeStrategy());
        content.excuter();
    }
}
