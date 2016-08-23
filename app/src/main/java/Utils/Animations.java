package Utils;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.example.econ.R;

/**
 * Created by jerome on 8/17/2016.
 */
public class Animations {

    private Context mContext;
    private Animation animationFadeIn, animationFadeOut;

    public Animations(Context mContext){
        this.mContext = mContext;

        initialize();
    }

    private void initialize(){
        animationFadeIn = AnimationUtils.loadAnimation(mContext, R.anim.fadein);
        animationFadeOut = AnimationUtils.loadAnimation(mContext, R.anim.fadeout);
    }

    public void setAnimationFadeIn(RelativeLayout relativeLayout){
        relativeLayout.startAnimation(animationFadeIn);
    }

    public void setAnimationFadeOut(RelativeLayout relativeLayout){
        relativeLayout.startAnimation(animationFadeOut);
    }
}
