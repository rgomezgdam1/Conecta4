package com.aetxabao.connect4;

/**
 * @author Rubén Gómez García
 */
public class Tablero {

    public final static char O = 'O';
    public final static char X = 'X';
    public final static char L = ' ';
    private final static int W = 7;
    private final static int H = 6;
    private int contador;
    private char turno;
    private final int ancho;
    private final int alto;
    private final char[][] m;

    public Tablero() {
        contador = 0;
        turno = O;
        ancho = W;
        alto = H;
        m = new char[ancho][alto];
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                m[i][j] = L;
            }
        }
    }

    public Tablero(char[][] m) {
        this.m = m;
        contador =0;
        ancho = m.length;
        alto = m[0].length;
        int countX = 0;
        int count0 = 0;

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if (m[i][j] == X){
                    countX ++;
                    contador++;
                }
                else if (m[i][j] == O){
                    count0 ++;
                    contador++;
                }
            }
        }
        if (count0 > countX) {
            turno = X;
        }
        else{
            turno = O;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public int getContador() {
        return contador;
    }

    public char[][] getMatriz(){
        return m;
    }

    public char getTurno() {
        return turno;
    }

    public void iniciaTurno() {
        int n = (int)Math.round(Math.random());
        if (n == 0){
            turno = X;
        }
        else{
            turno = O;
        }
    }

    public void cambiaTurno() {
        if(turno == X){
            turno = O;
        }
        else if (turno == O) {
            turno = X;
        }
    }

    public boolean estaColumnaLibre(int columna) {
        if(columna < 0 || columna > m[0].length -1){
            return false;
        }
        for (int i = 0; i < m[columna].length; i++) {
            if (m[columna][i] == L){
                return true;
            }
        }
        return false;
        }


    public void inserta(char ficha, int columna) {
            for (int i = 0; i < m[1].length; i++) {
                if (m[columna][i] == L){
                    switch (ficha){
                        case X: m[columna][i] = X;
                                contador ++;
                        break;
                        case O: m[columna][i] = O;
                                contador ++;
                        break;
                    }
                    break;
                }
            }
    }

    public boolean estaLleno() {
        return contador == m.length*m[0].length;
    }

    public boolean gana(char jugador) {
        boolean b;
        b = ganaHorizontal(jugador);
        b = b || ganaVertical(jugador);
        b = b || ganaDiagonalArriba(jugador);
        b = b || ganaDiagonalAbajo(jugador);
        return b;
    }

    private boolean ganaHorizontal(char jugador) {
        for (int i = 0; i < m.length -3; i++) {
            for (int j = 0; j < m[j].length; j++) {
                if(hay4Horizontales(i, j, jugador)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){

        int tmp = 0;
        char aux = jugador;
        for (int i = 0; i < 4; i++) {
           if (m[columna][fila] == aux){
               tmp++;
               columna++;
           }
        }
        return tmp == 4;
    }

    private boolean ganaVertical(char jugador) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length - 3; j++) {
                if (hay4Verticales(i,j,jugador)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        int tmp = 0;
        char aux = jugador;
        for (int i = 0; i < 4; i++) {
            if (m[columna][fila] == aux){
                tmp++;
                fila++;
            }
        }
        return tmp == 4;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        for (int i = 0; i < m.length -3; i++) {
            for (int j = 0; j < m[j].length - 3; j++) {
                if(hay4DiagonalesArriba(i, j, jugador)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        int tmp = 0;
        char aux = jugador;
        for (int i = 0; i < 4; i++) {
            if (m[columna][fila] == aux){
                tmp++;
                columna++;
                fila++;
            }
        }
        return tmp == 4;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        for (int i = 0; i < 4; i++) {
            for (int j = m[0].length - 1; j >= 3; j--) {
                if(hay4DiagonalesAbajo(i, j, jugador)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador){
        int tmp = 0;
        char aux = jugador;
        for (int i = 0; i < 4; i++) {
            if (m[columna][fila] == aux){
                tmp++;
                columna++;
                fila--;
            }
        }
        return tmp == 4;
    }

    public boolean estaFinalizado() {
        return gana(X) || gana(O) || estaLleno();
    }

}
