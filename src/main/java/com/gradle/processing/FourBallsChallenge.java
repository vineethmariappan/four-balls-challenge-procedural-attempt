package com.gradle.processing;

import processing.core.PApplet;

public class FourBallsChallenge extends PApplet{
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int BALL_DIAMETER = 10;
    public static final int RGB1 = 255;
    public static final int NO_OF_BALLS = 4;
    int[] ballsPositionY = {1,2,3,4};
    int[] ballsPositionX = {0,0,0,0};
    int[] ballsSpeed = {1,2,3,4};
    public FourBallsChallenge(){
        computeBallsYPositionForTheFrameSize();
    }

    private void computeBallsYPositionForTheFrameSize() {
        for(int ball=0;ball< NO_OF_BALLS;ball++){
            ballsPositionY[ball]*=(HEIGHT/5);
        }

    }

    public static void main(String[] args) {
        PApplet.main("com.gradle.processing.FourBallsChallenge",args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }
    @Override
    public void setup() {
        paintWhite();
    }

    @Override
    public void draw() {
        drawFourBalls();
    }

    private void paintWhite() {
        background(RGB1);
    }
    private void drawFourBalls(){
        for(int ball = 0;ball<4;ball++){
            drawBall(ballsPositionX[ball],ballsPositionY[ball]);
            ballsPositionX[ball]+=ballsSpeed[ball];
        }
    }

    private void drawBall(int ballPositionX, int ballPositionY) {
        ellipse(ballPositionX,ballPositionY, BALL_DIAMETER,BALL_DIAMETER);
    }
}
