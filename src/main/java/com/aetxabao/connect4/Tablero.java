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
        //TODO: Tablero(m)
        ancho = W;
        alto = H;
        int countX = 0;
        int count0 = 0;
        char[][] n = new char[ancho][alto];

        if (m.length != n.length || m[0].length != n[0].length){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                n[i][j] = m[i][j];
                if (n[i][j] == X){
                    countX ++;
                }
                else if (n[i][j] == O){
                    count0 ++;
                }
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
        this.m = n;
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
        //TODO: iniciaTurno
        int n = (int)Math.random();
        if (n == 0){
            turno = X;
        }
        else{
            turno = O;
        }
    }

    public void cambiaTurno() {
        //TODO: cambiaTurno
        if(turno == X){
            turno = O;
        }
        else if (turno == O) {
            turno = X;
        }
    }

    public boolean estaColumnaLibre(int columna) {
        //TODO: estaColumnaLibre
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
        //TODO: insertar
    }

    public boolean estaLleno() {
        //TODO: estaLleno
        return contador == alto*ancho;
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
        //TODO: ganaHorizontal
        boolean b = false;
        return b;
    }

    private boolean hay4Horizontales(int columna, int fila, char jugador){
        //TODO: hay4Horizontales
        return true;
    }

    private boolean ganaVertical(char jugador) {
        //TODO: ganaVertical
        boolean b = false;
        return b;
    }

    private boolean hay4Verticales(int columna, int fila, char jugador){
        //TODO: hay4Verticales
        return true;
    }

    private boolean ganaDiagonalArriba(char jugador) {
        //TODO: ganaDiagonalArriba
        boolean b = false;
        return b;
    }

    private boolean hay4DiagonalesArriba(int columna, int fila, char jugador){
        //TODO: hay4DiagonalesArriba
        return true;
    }

    private boolean ganaDiagonalAbajo(char jugador) {
        //TODO: ganaDiagonalAbajo
        boolean b = false;
        return b;
    }

    private boolean hay4DiagonalesAbajo(int columna, int fila, char jugador){
        //TODO: hay4DiagonalesAbajo
        return true;
    }

    public boolean estaFinalizado() {
        //TODO: finalizado
        return false;
    }

}
