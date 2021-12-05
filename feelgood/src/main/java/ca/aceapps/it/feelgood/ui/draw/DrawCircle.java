package ca.aceapps.it.feelgood.ui.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawCircle extends View {

    private Paint paint = new Paint();
    private Paint paint1 = new Paint();

    public DrawCircle(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(10);
        canvas.drawCircle(550,0,100,paint);
        paint1.setColor(Color.GRAY);
        paint1.setStrokeWidth(10);
        canvas.drawCircle(510,0,100,paint1);

    }
}
