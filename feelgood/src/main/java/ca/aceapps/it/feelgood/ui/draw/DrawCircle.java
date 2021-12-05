package ca.aceapps.it.feelgood.ui.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.view.View;

public class DrawCircle extends View {

    private Paint paint = new Paint();

    public DrawCircle(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.MULTIPLY);

        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        canvas.drawCircle(550,500,150,paint);
    }
}
