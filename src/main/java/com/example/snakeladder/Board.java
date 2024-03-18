package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer, Integer>> positionCoordinates;

    ArrayList<Integer> snakeLaderPosition;

    public Board() {
        positionCoordinates = new ArrayList<>();
        populatePositionCordinates();
        populateSnakelader();

    }

    private void populatePositionCordinates() {
        positionCoordinates.add(new Pair<>(0, 0));
        for (int i = 0; i < SnakeLader.height; i++) {
            for (int j = 0; j < SnakeLader.width; j++) {
                //x cordinates
                int xCord = 0;
                if(i%2 == 0){
                    xCord = j*SnakeLader.tileSize + SnakeLader.tileSize/2;
                }
                else{
                    xCord = SnakeLader.tileSize * SnakeLader.height - (j * SnakeLader.tileSize) - SnakeLader.tileSize / 2;
                }
                //y cordinates
                int yCord = SnakeLader.tileSize * SnakeLader.height - (i * SnakeLader.tileSize) - SnakeLader.tileSize / 2;
                positionCoordinates.add(new Pair<>(xCord, yCord));
            }
        }
    }

    private void populateSnakelader(){
        snakeLaderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLaderPosition.add(i);
        }
        snakeLaderPosition.set(4,25);
        snakeLaderPosition.set(13,46);
        snakeLaderPosition.set(27,5);
        snakeLaderPosition.set(33,49);
        snakeLaderPosition.set(40,3);
        snakeLaderPosition.set(42,63);
        snakeLaderPosition.set(43,18);
        snakeLaderPosition.set(50,69);
        snakeLaderPosition.set(54,31);
        snakeLaderPosition.set(62,81);
        snakeLaderPosition.set(66,45);
        snakeLaderPosition.set(76,58);
        snakeLaderPosition.set(74,92);
        snakeLaderPosition.set(89,53);
        snakeLaderPosition.set(99,41);
    }

    public int getNewPosition(int currentPosition){
        if(currentPosition > 0 && currentPosition <= 100){
            return snakeLaderPosition.get(currentPosition);
        }
        return -1;
    }
    int getXCoordinate(int position){
        if(position >= 1 && position <= 100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }

    int getYCoordinate(int position){
        if(position >= 1 && position <= 100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }

    public static void main(String[] args) {
        Board board = new Board();
        for (int i = 0; i < board.positionCoordinates.size(); i++) {
            System.out.println(i + "$ x :" + board.positionCoordinates.get(i).getKey() +
                    "    y : " + board.positionCoordinates.get(i).getValue());
        }
    }
}
