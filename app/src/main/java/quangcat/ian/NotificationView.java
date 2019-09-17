package quangcat.ian;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by QuangCV on 17-Sep-2019
 **/

public class NotificationView extends TextView {

    private final int DURATION = 2500;
    private AnimatorSet showAnimator;
    private AnimatorSet dismissAnimator;

    public NotificationView(Context context) {
        super(context);

        setGravity(Gravity.TOP);
        setBackgroundColor(Color.GREEN);
        setPadding(20, 20, 20, 20);

        Animator s1 = ObjectAnimator.ofFloat(this, "translationY", -100, 0);
        Animator s2 = ObjectAnimator.ofFloat(this, "alpha", 0, 1);
        showAnimator = new AnimatorSet();
        showAnimator.playTogether(s1, s2);

        Animator d1 = ObjectAnimator.ofFloat(this, "translationY", 0, -100);
        Animator d2 = ObjectAnimator.ofFloat(this, "alpha", 1, 0);
        dismissAnimator = new AnimatorSet();
        dismissAnimator.playTogether(d1, d2);
    }

    public void show(String message) {
        setText(message);

        if (!showAnimator.isRunning()) {
            boolean visible = dismissAnimator.isStarted();
            dismissAnimator.cancel();
            if (!visible) {
                showAnimator.start();
            }
            dismissAnimator.setStartDelay(DURATION);
            dismissAnimator.start();
        }
    }

}