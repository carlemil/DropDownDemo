
package se.kjellstrand.dropdowndemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    /** Layout holding the droddown view */
    private LinearLayout mDropdownFoldOutMenu;

    /** Textview holding the title of the droddown */
    private TextView mDropdownTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mDropdownFoldOutMenu = ((LinearLayout) findViewById(R.id.dropdown_foldout_menu));
        mDropdownTitle = ((TextView) findViewById(R.id.dropdown_textview));

        final TextView dropDownTextView = (TextView) findViewById(R.id.dropdown_textview);
        final TextView alt0 = (TextView) findViewById(R.id.dropdown_alt0);
        final TextView alt1 = (TextView) findViewById(R.id.dropdown_alt1);
        final TextView alt2 = (TextView) findViewById(R.id.dropdown_alt2);

        dropDownTextView.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDropdownFoldOutMenu.getVisibility() == View.GONE) {
                            openDropdown();
                        } else {
                            closeDropdown();
                        }
                    }
                });

        alt0.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt0);
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                                R.drawable.icn_dropdown_checked, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        Toast.makeText(getBaseContext(), R.string.alt0, Toast.LENGTH_SHORT).show();
                    }
                });

        alt1.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt1);
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                                R.drawable.icn_dropdown_checked, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        Toast.makeText(getBaseContext(), R.string.alt1, Toast.LENGTH_SHORT).show();
                    }
                });

        alt2.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dropDownTextView.setText(R.string.alt2);
                        closeDropdown();
                        alt0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        alt1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        alt2.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                                R.drawable.icn_dropdown_checked, 0);
                        Toast.makeText(getBaseContext(), R.string.alt2, Toast.LENGTH_SHORT).show();
                    }
                });
    }

    /**
     * Animates in the dropdown list
     */
    private void openDropdown() {
        if (mDropdownFoldOutMenu.getVisibility() != View.VISIBLE) {
            ScaleAnimation anim = new ScaleAnimation(1, 1, 0, 1);
            anim.setDuration(getResources().getInteger(R.integer.dropdown_amination_time));
            mDropdownFoldOutMenu.startAnimation(anim);
            mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.icn_dropdown_close, 0);
            mDropdownFoldOutMenu.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Animates out the dropdown list
     */
    private void closeDropdown() {
        if (mDropdownFoldOutMenu.getVisibility() == View.VISIBLE) {
            ScaleAnimation anim = new ScaleAnimation(1, 1, 1, 0);
            anim.setDuration(getResources().getInteger(R.integer.dropdown_amination_time));
            anim.setAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    mDropdownFoldOutMenu.setVisibility(View.GONE);
                }
            });
            mDropdownTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0,
                    R.drawable.icn_dropdown_open, 0);
            mDropdownFoldOutMenu.startAnimation(anim);
        }
    }
}
