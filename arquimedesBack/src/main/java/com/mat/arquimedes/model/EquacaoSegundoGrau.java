package com.mat.arquimedes.model;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class EquacaoSegundoGrau {
    double a; double b; double c; double delta; double x1; double x2;

    public EquacaoSegundoGrau() {
    }

    public EquacaoSegundoGrau(double a, double b, double c, double delta, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delta = delta;
        this.x1 = x1;
        this.x2 = x2;
    }

    public EquacaoSegundoGrau calcularEquacaoSegundoGrau(double a, double b, double c){
        double delta = (Math.pow(b,2)) - 4*a*c;
        double x1 = (-b + Math.sqrt(delta)) / (2*a);
        double x2 = (-b - Math.sqrt(delta)) / (2*a);
        return new EquacaoSegundoGrau(a, b, c, delta, x1,x2) ;
    }


    @Override
    public String toString() {
        return "EquacaoSegundoGrau{" +
                "a=" + getA() +
                ", b=" + getB() +
                ", c=" + getC() +
                ", delta=" + getDelta() +
                ", x1=" + getX1() +
                ", x2=" + getX2() +
                '}';
    }

}
