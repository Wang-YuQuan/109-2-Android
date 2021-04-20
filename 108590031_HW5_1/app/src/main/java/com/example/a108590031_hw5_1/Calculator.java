package com.example.a108590031_hw5_1;

public class Calculator {
    public enum Operator{ADD,SUB,DIV,MUL,POW}

    public double Add(double f_in, double t_in){
        return f_in + t_in ;
    }

    public double Sub(double f_in,double t_in){
        return f_in - t_in ;
    }

    public double Div(double f_in,double t_in){
        if(t_in == 0){
            throw new IllegalArgumentException("You cannot divide by zero");
        }
        return f_in / t_in;
    }

    public double Mul(double f_in,double t_in){
        return f_in * t_in;
    }

    public double Pow(double f_in,double t_in){
        return Math.pow(f_in, t_in);
    }
}
