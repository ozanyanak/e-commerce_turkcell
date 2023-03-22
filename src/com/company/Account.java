package com.company;

public class Account {
    int id;
    String name;

    private int bakiye;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.bakiye=5000;
    }
    public Account(int id, String name, int bakiye) {
        this.id = id;
        this.name = name;
        this.bakiye = bakiye;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public void plus(int money){
        this.bakiye=this.bakiye+money;
    }
    public void down(int money){
        this.bakiye=this.bakiye-money;
    }

    @Override
    public String toString() {
        return "hesabın: \n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bakiye=" + bakiye +
                '}';
    }
}
