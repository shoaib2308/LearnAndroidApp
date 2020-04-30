package simplycodinghub.learnandroidapp.Utils;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Base64;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import androidx.appcompat.app.AlertDialog;
import simplycodinghub.learnandroidapp.R;

public class MyUtils {
    /**
     * get date in UTC time format
     *
     * @param date
     * @return
     */
    public static String current_datetime_To_UTC(Date date) {
        SimpleDateFormat actualdate_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        actualdate_format.setTimeZone(TimeZone.getTimeZone("UTC"));
        String Utc_Time = actualdate_format.format(date);
        return Utc_Time;
    }

    /**
     * Use to expand view
     *
     * @param v
     */

    public static void expand(final View v) {
        v.measure(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        final int targtetHeight = v.getMeasuredHeight();

        v.getLayoutParams().height = 0;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? ActionBar.LayoutParams.WRAP_CONTENT
                        : (int) (targtetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        a.setDuration(600);
//        a.setDuration((int)(targtetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    /**
     * Use to collapse view
     *
     * @param v
     */


    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration(600);
        //a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    /**
     * To fetch base64 of image.
     * @param bitmapInput
     * @return
     */

    public static String getBase64ofBitmap(Bitmap bitmapInput) {
        String encoded = "";
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapInput.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            encoded = Base64.encodeToString(byteArray, Base64.NO_WRAP);

        } catch (Exception e) {
           // Log.d("Exception in getBase64ofBitmap:"+e.getLocalizedMessage());
        }

        return encoded;
    }

    public static int getDeviceWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        int width = display.getWidth();
        return width;
    }


    /**
     * Convert date in string format to another string format
     *
     * @param stringdate
     * @param inputFormat
     * @param outFormat
     * @return
     */
    public static String convertStringDate(String stringdate, String inputFormat, String outFormat) {

        String strDateTime = "";
        try {
            DateFormat inputFormatter = new SimpleDateFormat(inputFormat, Locale.getDefault());
            Date da = (Date) inputFormatter.parse(stringdate);
//            System.out.println("==Date is ==" + da);

            DateFormat outputFormatter = new SimpleDateFormat(outFormat, Locale.getDefault());
            strDateTime = outputFormatter.format(da);
//            System.out.println("==String date is : " + strDateTime);
            return strDateTime;
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return strDateTime;

    }

    /**
     * Get Hours from string date
     *
     * @param stringdate
     * @return
     */

    public static int getHoursFromStringDate(String stringdate, String inputFormat) {
        int hours_24 = 0;

        try {
            DateFormat inputFormatter = new SimpleDateFormat(inputFormat, Locale.getDefault());
            Date date = (Date) inputFormatter.parse(stringdate);
            hours_24 = date.getHours(); // int

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return hours_24;
    }

    /**
     * This method returns any json as String to calling method
     * @param context
     * @return
     */
    public static String readJsonForMe(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.rashid_alafasy);
        System.out.println(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();
    }

    /**
     * Check internet connection before calling any code which requires internet to proceed
     * (e.g Calling Webservice
     * @param context
     * @return
     */
    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    /**
     * Display custom Toast
     * @param context
     * @param message
     */
    public static void showToast(Context context,String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    /**
     * DEmo internet connection alert
     * @param context
     */
    public static void showAlert(Context context) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        // set title
        alertDialogBuilder.setTitle("Connection Error");
        // set dialog message
        alertDialogBuilder
                .setMessage("No Internet Connection Available")
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        dialog.cancel();
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
    /**
     * Hide keyboard
     */

    public static void hideKeyboard(Activity activity) {

        if (activity.getCurrentFocus() != null) {

            InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * To dial number
     * @param context
     * @param number
     */
    public static void call(Context activity, String number) {
        if (number != null && number.length() > 2) {
            String uri = "tel:" + number;
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse(uri));
            activity.startActivity(intent);
        } else {
            Toast.makeText(activity, "CANNT_CALL_THIS_NUMBER", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Text message / SMS
     * @param context
     * @param number
     */

    public static void message(Context context, String number) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", number);
        smsIntent.putExtra("sms_body", "Body of Message");
        context.startActivity(smsIntent);
    }

    /**
     * To display the difference between current time and time from server response.
     * Take care before using this method as this mrthod was for my specific requirement.
     * @param current
     * @param end
     * @return
     */


    public static String calcDifference(Date current, Date end) {
        String left = "";

        try {
            long diff = current.getTime() - end.getTime();
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000);
            int diffInDays = (int) (diff) / (1000 * 60 * 60 * 24);


            if (diffInDays > 2) {
               // left = Utility.getDateInString(end, date_yyyy_MM_dd);
            } else if (diffInDays > 1 && diffInDays <= 2) {
                left = diffInDays + " days ago";
            } else if (diffInDays == 1) {
                left = diffInDays + " day ago";
            } else if (diffHours > 0 && diffHours < 24) {

                if (diffHours == 1) {
                    left = diffHours + " hour ago";
                } else {
                    left = diffHours + " hours ago";
                }
            } else if ((diffMinutes >= 1) && (diffMinutes < 60)) {

                if (diffMinutes == 1) {
                    left = diffMinutes + " minute ago";
                } else {
                    left = diffMinutes + " minutes ago";
                }
            } else {
                left = "just now";
            }
        } catch (Exception e) {
            e.printStackTrace();
            //Debug.e(TAG,"calcDifference exception=="+e.toString());
        }

        return left;
    }

    /**  VVVVV IMP
     * New way of Retrofit Network call
     *  ApiClient  iRestClient = ApiClient.getRetrofit().create(ApiClient.class);
     *                     Call<LoginResponse> call = iRestClient.userLogin(params);
     *                     call.enqueue(new Callback<LoginResponse>() {
     *                         @Override
     *                         public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
     *                           //Utils.showToast(StartActivity.this, ""+response.body().getUserId(), Toast.LENGTH_LONG);
     *                         }
     *                         @Override
     *                         public void onFailure(Call<LoginResponse> call, Throwable t) {
     *                             hideLoading();
     *                             Utils.showToast(StartActivity.this, "Request failed : " + t, Toast.LENGTH_LONG);
     *                         }
     *                     });
     *
     *
     *    ApiCLient.java
     *    public static Retrofit getRetrofit() {
     *         HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
     *         loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
     *
     *         OkHttpClient client = new OkHttpClient.Builder()
     *                 .addInterceptor(loggingInterceptor)
     *                 .build();
     *
     *         Retrofit retrofit = new Retrofit.Builder()
     *                 .baseUrl("http://api.learn2crack.com")
     *                 .addConverterFactory(GsonConverterFactory.create())
     *                 .client(client)
     *                 .build();
     *         return retrofit;
     *
     *      }
     *
     *
     */


   /* MOST VVVVVV IMP*/

    /*doBackendJSONRequest("GET", "room/OACs", params, new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) throws JSONException {
                Gson gson = new Gson();
                OACs oaCsList = gson.fromJson(String.valueOf(result), OACs.class);
                if (oaCsList.getSuccess()) {
                    hideLoading();

                    OACsAdapter oaCsAdapter = new OACsAdapter(, OACsListActivity.this);
                    OACsRecyclerView.setLayoutManager(new LinearLayoutManager(OACsListActivity.this));
                    OACsRecyclerView.hasFixedSize();
                    OACsRecyclerView.setAdapter(oaCsAdapter);
                    oaCsAdapter.notifyDataSetChanged();

                } else {
                    Utils.showToast(OACsListActivity.this, "Something went wrong", Toast.LENGTH_SHORT);
                }

            }

            @Override
            public void onFailure(int errorCode, String error) {
                Utils.log("Failed getting OACs List. Please try again later");
                Utils.showToast(OACsListActivity.this, "Request failed : " + error, Toast.LENGTH_SHORT);
            }
        }, new DefaultRetryPolicy(8000, 0, 1));
        */




    // For Refernce
    // IRestService iRestService = retrofit.create(IRestService.class);
    // Call<LoginResponse> userLogin(@Field("mobileNo") String mobileNo, @Field("password") String password);






}
