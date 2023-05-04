package com.example.billiardball;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.view.View;


public class Billiard extends View {
    ShapeDrawable mBilliardBall;
    int cx = 50;//시작위치 중심좌표
    int cy = 50;
    static final int radius = 50;//반지름

    int dir_x = 1;//방향, 밑으로 이동
    int dir_y = 1;//방향, 밑으로 이동

    int step_x = 5;//x는 한 번 움직일 때 5pixcel
    int step_y = 15;//y는 한 번 움직일 때 15pixcel

    //Resources라는 class에서 시스템 정보 획득하려고 getSystem
    //display와 관련된 정보니까 getDisplayMetrics
    int screen_width = Resources.getSystem().getDisplayMetrics().widthPixels;
    int screen_height = Resources.getSystem().getDisplayMetrics().heightPixels;





    public Billiard(Context context){
        super(context);
        mBilliardBall = new ShapeDrawable(new OvalShape());//타원 만들어
        mBilliardBall.getPaint().setColor(Color.RED);//빨강으로 만들어
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.BLUE);

        if (cx <=radius)//
            dir_x = 1;
        else if (cx >= screen_width - radius)//우측 끝보다 더 오른쪽으로 가면
            dir_x = -1;//좌측으로 움직여
        if (cy <= radius)//cy가 radius보다 작거나 같으면
            dir_y = 1;//밑으로 내려가
        else if (cy >= screen_height-radius)//제일 밑으로 가면
            dir_y = -1;//위로 가

        cx = cx + dir_x * step_x;//현재 x 중싱 좌표
        cy = cy + dir_y * step_y;//현재 y 중심 좌표
        mBilliardBall.setBounds(cx-radius,cy-radius,cx+radius,cy+radius);//cx-r,cy-r&cx+r, cy+r 위치에 생성돼

        invalidate();//onDraw재호출, real time으로 움직여야 하니까
    }
}
