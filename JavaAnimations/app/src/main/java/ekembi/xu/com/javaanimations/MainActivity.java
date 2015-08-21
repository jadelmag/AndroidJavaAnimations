package ekembi.xu.com.javaanimations;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {

    ImageView mImageView;

    Animation scaleAnim;
    Animation translateAnim;
    Animation alphaAnim;
    Animation rotateAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupVariables();
    }

    private void setupVariables() {
        mImageView = (ImageView) findViewById(R.id.football);
    }

    /***** Methods Animations *****/

    public void scaleAnimation(View view) {

        scaleAnim = new ScaleAnimation(
            1.0f,                       2.0f,
            1.0f,                       2.0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        );
        scaleAnim.setDuration(1000);
        scaleAnim.setAnimationListener(this);
        mImageView.startAnimation(scaleAnim);
    }

    public void translateAnimation(View view) {
        translateAnim = new TranslateAnimation(
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 300f
        );
        translateAnim.setDuration(1000);
        translateAnim.setFillAfter(true);
        translateAnim.setAnimationListener(this);
        mImageView.startAnimation(translateAnim);
    }

    public void alphaAnimation(View view) {
        alphaAnim = new AlphaAnimation(1.0f, 0.0f);
        alphaAnim.setDuration(1000);
        alphaAnim.setAnimationListener(this);
        mImageView.startAnimation(alphaAnim);
    }

    public void rotateAnimation(View view) {
        rotateAnim = new RotateAnimation(
                0.0f,                       -200f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setDuration(1000);
        rotateAnim.setRepeatMode(Animation.REVERSE);
        rotateAnim.setRepeatCount(2);
        rotateAnim.setAnimationListener(this);
        mImageView.startAnimation(rotateAnim);
    }

    /***** Animation Listener *****/

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(MainActivity.this, "Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(MainActivity.this, "Ended", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        Toast.makeText(MainActivity.this, "Repeated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            launchWebsite();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchWebsite() {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekembi.com/"));
        startActivity(browserIntent);
    }
}

