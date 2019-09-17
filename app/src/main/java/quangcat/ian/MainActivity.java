package quangcat.ian;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * Created by QuangCV on 17-Sep-2019
 **/

public class MainActivity extends Activity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView v = new TextView(this);
        v.setGravity(Gravity.CENTER);
        v.setText("Press any key to show notification");
        setContentView(v);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        InAppNotification.showNotification(this, "Hello #" + counter++);
        return true;
    }

}