package am.example.wraplayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import am.widget.wraplayout.WrapLayout;

public class WrapLayoutActivity extends AppCompatActivity implements
        SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener{

    private WrapLayout lytWrap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wraplayout);
        Toolbar mToolbar = findViewById(R.id.wly_toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
        }
        lytWrap = findViewById(R.id.wly_lyt_warp);
        final RadioGroup rgGravity = findViewById(R.id.wly_rg_gravity);
        rgGravity.setOnCheckedChangeListener(this);
        rgGravity.check(R.id.wly_rb_top);
        final SeekBar sbHorizontal = findViewById(R.id.wly_sb_horizontal);
        sbHorizontal.setOnSeekBarChangeListener(this);
        sbHorizontal.setProgress(15);
        final SeekBar sbVertical = findViewById(R.id.wly_sb_vertical);
        sbVertical.setOnSeekBarChangeListener(this);
        sbVertical.setProgress(15);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.wly_rb_top:
                lytWrap.setGravity(WrapLayout.GRAVITY_TOP);
                break;
            case R.id.wly_rb_center:
                lytWrap.setGravity(WrapLayout.GRAVITY_CENTER);
                break;
            case R.id.wly_rb_bottom:
                lytWrap.setGravity(WrapLayout.GRAVITY_BOTTOM);
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.wly_sb_horizontal:
                int horizontal = (int) (progress * getResources().getDisplayMetrics().density);
                lytWrap.setHorizontalSpacing(horizontal);
                break;
            case R.id.wly_sb_vertical:
                int vertical = (int) (progress * getResources().getDisplayMetrics().density);
                lytWrap.setVerticalSpacing(vertical);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
