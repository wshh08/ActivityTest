package com.example.wshh08.activitytest;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by wshh08 on 15-10-18.
 */
public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer mRenderer;

    private final float TOUCH_SCALE_FACTOR = 180.0f / 1080;
    private float mPreviousX;
    private float mPreviousY;

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);
        mRenderer = new MyGLRenderer();
        //Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
        //Render the View only when there is a change in the drawing data
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
            case MotionEvent.ACTION_MOVE:
                float dx = x - mPreviousX;
                float dy = x - mPreviousY;
                // reverse direction of rotation above the mid-line
                if (y > getHeight() / 2) {
                    dx = dx * -1 ;
                }
                // reverse direction of rotation to left of the mid-line
                if (x < getWidth() / 2) {
                    dy = dy * -1 ;
                }
                mRenderer.mAngle += (dx + dy) * TOUCH_SCALE_FACTOR; // = 180.0f /320
                requestRender();
        }
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
