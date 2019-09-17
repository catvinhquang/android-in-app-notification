package quangcat.ian;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

/**
 * Created by QuangCV on 17-Sep-2019
 **/

public class InAppNotification {

    public static void showNotification(final Activity activity, String message) {
        if (activity == null || activity.getWindow() == null || TextUtils.isEmpty(message)) {
            return;
        }

        Window window = activity.getWindow();
        NotificationView notificationView = window.findViewById(R.id.notification_view);
        if (notificationView == null) {
            notificationView = new NotificationView(activity);
            notificationView.setId(R.id.notification_view);
            notificationView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(activity, "Clicked", Toast.LENGTH_SHORT).show();
                }
            });

            try {
                FrameLayout decorView = (FrameLayout) window.getDecorView();
                decorView.addView(notificationView,
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }

        notificationView.show(message);
    }

}