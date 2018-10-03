package com.example.ltch23.sensores;

import android.content.Context;
import android.graphics.Canvas;

public class Luis extends android.support.v7.widget.AppCompatImageView {
    int direction = 0;

    public Luis (Context context) {
        super(context);
        this.setImageResource(R.drawable.goku3);
    }

    // Called when component is to be drawn
    @Override
    public void onDraw(Canvas canvas) { //
        int height = this.getHeight();  //
        int width = this.getWidth();

        canvas.rotate(direction, width / 2, height / 2); //
        super.onDraw(canvas); //
    }

    // Called by Compass to update the orientation
    public void setDirection(int direction) { //
        this.direction = direction;
        this.invalidate(); // request to be redrawn
    }
}
