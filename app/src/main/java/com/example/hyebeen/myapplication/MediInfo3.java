package com.example.hyebeen.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import butterknife.BindView;

public class MediInfo3 extends AppCompatActivity {

    private Button btnSearch;


    private static String IP_ADDRESS = "169.254.151.238";


    private static final String TAG_JSON="medicine";
    private static final String TAG_name = "name";
    ArrayList<HashMap<String, String>> mArrayList;
    String[] mediNameList;
    String mJsonString;
//    private TextView mTextViewResult;



    private EditText textSearch;        // 검색어를 입력할 Input 창
    private ArrayAdapter<String> adapter;
    private AutoCompleteTextView autoCompleteTextView;



    //test용
    private Button testbtn;
    private ArrayAdapter<String> adapter2;
    String ex[] =  {"apple", "approach", "appa", "apart", "banana"};



    protected void onCreate(final Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi3_test_search);


        textSearch = (EditText) findViewById(R.id.textSearch);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.textSearch);

//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,ex); //JSON 파일로 받아온 약이름 배열을 연결
//        autoCompleteTextView.setAdapter(adapter);


//        GetData task = new GetData();
//        task.execute("http://"+IP_ADDRESS+"/getjson.php");








        //test
        testbtn = (Button)findViewById(R.id.btnReg);
        adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,ex);
        autoCompleteTextView.setAdapter(adapter2);
        testbtn.setOnClickListener(new MyOnClickListener(this));








        // input창에 검색어를 입력시 "addTextChangedListener" 이벤트 리스너를 정의한다.
        textSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                // input창에 문자를 입력할때마다 호출된다.
                String text = autoCompleteTextView.getText().toString();
            }
        });
    }









    //test
    class MyOnClickListener implements OnClickListener{


        Context context;

        public MyOnClickListener(Context context){
            super();
            this.context = context;

        }

        @Override
        public void onClick(View v) {

            GetData task = new GetData();
            task.execute("http://"+IP_ADDRESS+"/getjson.php");
            adapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item,mediNameList); //JSON 파일로 받아온 약이름 배열을 연결
            autoCompleteTextView.setAdapter(adapter);
        }
    }//test end









    private class GetData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MediInfo3.this,
                    "Please Wait", null, true, true);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
//            mTextViewResult.setText(result);
//            Log.d(TAG, "response  - " + result);

            if (result == null){

//                mTextViewResult.setText(errorString);
            }
            else {

                mJsonString = result;
                mediNameList = showResult();
//                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,mediNameList); //JSON 파일로 받아온 약이름 배열을 연결
//                autoCompleteTextView.setAdapter(adapter);
            }
        }


        @Override
        protected String doInBackground(String... strings) {
            String serverURL = strings[0];

            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.connect();


                int responseStatusCode = httpURLConnection.getResponseCode();


                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }

                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }


                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

//                Log.d(TAG, "InsertData: Error ", e);
//                errorString = e.toString();

                return null;
            }

        }

        private String[] showResult() {
            try {
                JSONObject jsonObject = new JSONObject(mJsonString);
                JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
                int size;
                mArrayList = new ArrayList<>();
                for (size = 0; size < jsonArray.length(); size++) {

                    JSONObject item = jsonArray.getJSONObject(size);

                    String name = item.getString(TAG_name);

                    HashMap<String, String> hashMap = new HashMap<>();

                    hashMap.put(TAG_name, name);

                    mArrayList.add(hashMap);
                }




                String[] mediNameList_tmp = new String[size + 1];

                for (int i = 0; i < size + 1; i++) {

                    for (String mapkey : mArrayList.get(i).keySet()) {
                        mediNameList_tmp[i] = mArrayList.get(i).get(mapkey);
                    }

                }

//                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,mediNameList); //JSON 파일로 받아온 약이름 배열을 연결
//                autoCompleteTextView.setAdapter(adapter);

                return mediNameList_tmp;

            } catch (JSONException e) {

                return null;
//                Log.d(TAG, "showResult : ", e);
            }


        }
}




}
