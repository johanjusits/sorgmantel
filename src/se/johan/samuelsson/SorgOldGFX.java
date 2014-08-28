package se.johan.samuelsson;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

public class SorgOldGFX extends View {
	
	Bitmap gBall;
	float changingY;
	Typeface font;

	public SorgOldGFX(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		gBall = BitmapFactory.decodeResource(getResources(), R.drawable.green_ball);
		changingY = 0;
		font = Typeface.createFromAsset(context.getAssets(), "new_athena_unicode.ttf");
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawColor(Color.BLACK);
		
		Paint textPaint = new Paint();
		textPaint.setColor(Color.YELLOW);
		textPaint.setTextAlign(Align.CENTER);
		textPaint.setTextSize(65);
		textPaint.setTypeface(font);
		canvas.drawText("Sorgmantel", canvas.getWidth()/2, 200, textPaint);
		
		canvas.drawBitmap(gBall, (canvas.getWidth()/2), changingY, null);
		if (changingY < canvas.getHeight()){
			changingY += 10;
		}else{
			changingY = 0;
		}
		Rect middleRect = new Rect();
		middleRect.set(0, 400, canvas.getWidth(), 550);
		Paint ourWhite = new Paint();
		ourWhite.setColor(Color.WHITE);
		canvas.drawRect(middleRect, ourWhite);
		invalidate();
	}
	
	
	
	
}
