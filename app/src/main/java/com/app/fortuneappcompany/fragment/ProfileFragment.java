package com.app.fortuneappcompany.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.app.fortuneappcompany.R;
import com.app.fortuneappcompany.activities.ApplyLeaveActivity;
import com.app.fortuneappcompany.activities.NotificaionActivity;
import com.app.fortuneappcompany.activities.ReferEarnActivity;
import com.app.fortuneappcompany.activities.ReferDetailsActivity;
import com.app.fortuneappcompany.activities.UpdateProfileActivity;
import com.app.fortuneappcompany.helper.Constant;
import com.app.fortuneappcompany.helper.Session;


public class ProfileFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

    CardView cardView1;
    ImageView imgMenu;
    Session session;
    Activity activity;
    Button btncopy,btnApplyLeave;


    Button btnReferDetails;

    TextView tvName,tvMobile,tvEarn,tvWithdrawal,tvCodes,tvBalance,tvRefercode,tvTotalRefer,tvReferDescription;


    public ProfileFragment() {
        // Required empty public constructor
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root  =  inflater.inflate(R.layout.fragment_profile, container, false);


//        Window window = requireActivity().getWindow();
//
//// 1. Allow drawing behind system bars
//        WindowCompat.setDecorFitsSystemWindows(window, false);
//
//// 2. Set system bar colors manually
//        window.setNavigationBarColor(ContextCompat.getColor(requireContext(), R.color.primaryColor));
//        window.setStatusBarColor(ContextCompat.getColor(requireContext(), R.color.primaryColor));
//
//// 3. Important: Set transparent system bars flags
//        WindowInsetsControllerCompat insetsController = new WindowInsetsControllerCompat(window, window.getDecorView());
//        insetsController.setAppearanceLightNavigationBars(false); // false = dark nav bar icons (for dark backgrounds), true = light icons for white bg
//        insetsController.setAppearanceLightStatusBars(false); // Same for status bar
//
//
//
//        ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {
//            Insets systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBarsInsets.left, systemBarsInsets.top, systemBarsInsets.right, systemBarsInsets.bottom);
//            return insets;
//        });




        activity = getActivity();
        session = new Session(getActivity());

        cardView1 = root.findViewById(R.id.cardView1);
        imgMenu = root.findViewById(R.id.imgMenu);
        tvName = root.findViewById(R.id.tvName);
        tvMobile = root.findViewById(R.id.tvMobile);
        tvEarn = root.findViewById(R.id.tvEarn);
        tvWithdrawal = root.findViewById(R.id.tvWithdrawal);
        tvCodes = root.findViewById(R.id.tvCodes);
        tvBalance = root.findViewById(R.id.tvBalance);
        btncopy = root.findViewById(R.id.btncopy);
        tvRefercode = root.findViewById(R.id.tvRefercode);
        tvTotalRefer = root.findViewById(R.id.tvTotalRefer);
        tvReferDescription = root.findViewById(R.id.tvReferDescription);
        btnReferDetails = root.findViewById(R.id.btnReferDetails);
        btnApplyLeave = root.findViewById(R.id.btnApplyLeave);

        tvName.setText(session.getData(Constant.NAME));
        tvMobile.setText(session.getData(Constant.MOBILE));
        tvEarn.setText(session.getData(Constant.EARN)) ;
        tvWithdrawal.setText(session.getData(Constant.WITHDRAWAL));
        tvCodes.setText(session.getInt(Constant.TOTAL_CODES) + "");
        tvBalance.setText(session.getData(Constant.BALANCE));
        tvTotalRefer.setText(session.getData(Constant.TOTAL_REFERRALS));
        tvReferDescription.setText(session.getData(Constant.REFER_DESCRIPTION));
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReferEarnActivity.class);
                startActivity(intent);
            }
        });
        btnReferDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ReferDetailsActivity.class);
                startActivity(intent);

            }
        });


        btnApplyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (session.getData(Constant.STATUS).equals("1")){
                    Intent intent = new Intent(activity, ApplyLeaveActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(activity, "Only for Verfied Users", Toast.LENGTH_SHORT).show();
                }

            }
        });



        tvRefercode.setText(" Your Refer Code : "+session.getData(Constant.REFER_CODE));
        String text = tvRefercode.getText().toString();
        btncopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nDOWNLOAD THE APP AND GET UNLIMITED EARNING .you can also Download App from below link and enter referral code while login-"+"\n"+text+"\n";
                    shareMessage = shareMessage +"\n https://play.google.com/store/apps/details?id=com.app.fortuneapp \n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }

            }
        });



        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showpopup(view);
            }
        });




        return root;
    }

    private void showpopup(View v) {

        PopupMenu popup = new PopupMenu(getActivity(),v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.logoutitem){
            session.logoutUser(activity);
        }

        else if (item.getItemId() == R.id.notification){

            Intent intent = new Intent(activity, NotificaionActivity.class);
            startActivity(intent);

        }

        else if (item.getItemId() == R.id.ReferEarn){

            Intent intent = new Intent(activity,ReferEarnActivity.class);
            startActivity(intent);

        }
        else if (item.getItemId() == R.id.Uptdatepofile){

            Intent intent = new Intent(activity, UpdateProfileActivity.class);
            startActivity(intent);

        }
        else if (item.getItemId() == R.id.jobDetails){

            try {
                Uri uri = Uri.parse("" + session.getData(Constant.JOB_DETAILS_LINK)); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }catch (Exception e){

            }

        }
        return false;
    }
}