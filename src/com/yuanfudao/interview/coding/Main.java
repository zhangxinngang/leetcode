package com.yuanfudao.interview.coding;

public class Main {
    static class Signal{
        public String sign;
        public Signal(String sign) {
            this.sign = sign;
        }
    }

    static class Pthread extends Thread{
        public Character print;
        public Character signal;

        public Pthread(Character print, Character singal){
            this.print = print;
            this.signal = singal;
        }

        @Override
        public void run(){
            while(true){
                if (signal == print){
                    System.out.println(print);
                    if (signal == 'A'){
                        signal = 'B';
                    }else if (signal == 'B'){
                        signal = 'C';
                    }else{
                        signal = 'A';
                    }
                }else{
                    continue;
                }
            }
        }

    }

    public static void main(String[] args) {
        Signal signal1 = new Signal("A");
        String sing = "A";

        System.out.println(sing == "A");
        System.out.println(sing.equals("A"));

        Character c = 'A';

        Pthread pA = new Pthread('A',c);
        Pthread pB = new Pthread('B',c);
        Pthread pC = new Pthread('C',c);

        pB.start();
        pC.start();
        pA.start();

        try{
            Thread.sleep(100000);
        }catch(Exception e){

        }
        System.out.println("sss");
    }
}