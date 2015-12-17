package com.example.multiable.demo_bmob.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.multiable.demo_bmob.R;
import com.example.multiable.demo_bmob.config.Config;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.exception.BmobException;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;

public class MainActivity extends AppCompatActivity {
    private EditText et_code;
    private Button bt_verify,bt_request ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BmobSMS.initialize(MainActivity.this, Config.APPLICATION_ID);
        setContentView(R.layout.activity_main);

        initView() ;
//        final Person p2 = new Person();
//        p2.setName("clement");
//        p2.setAddress("深圳");
//        p2.setPhoneNumber("13570320979");
//        p2.save(this, new SaveListener() {
//            @Override
//            public void onSuccess() {
//                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this,"添加数据成功，返回objectId为："+p2.getObjectId()
//                        ,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(int code, String msg) {
//                // TODO Auto-generated method stub
//                Toast.makeText(MainActivity.this,"创建数据失败："+msg
//                        ,Toast.LENGTH_SHORT).show();
//            }
//        });

    }
    private void initView(){
        et_code = (EditText)findViewById(R.id.et_code) ;
        bt_verify = (Button)findViewById(R.id.bt_verify) ;
        bt_request = (Button)findViewById(R.id.bt_request) ;
        bt_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BmobSMS.requestSMSCode(MainActivity.this, "13570320979", "模板名称",new RequestSMSCodeListener() {
                    @Override
                    public void done(Integer smsId,BmobException ex) {
                        // TODO Auto-generated method stub
                        if(ex==null){//验证码发送成功
                            Toast.makeText(MainActivity.this,"验证码发送成功 "+smsId
                                    ,Toast.LENGTH_SHORT).show();
                            Log.i("bmob", "短信id："+smsId);//用于查询本次短信发送详情
                        }
                        Toast.makeText(MainActivity.this,"失败 "
                                ,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        bt_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = et_code.getText().toString();
                BmobSMS.verifySmsCode(MainActivity.this,"13570320979", code,
                        new VerifySMSCodeListener() {

                    @Override
                    public void done(BmobException ex) {
                        // TODO Auto-generated method stub
                        if(ex==null){//短信验证码已验证成功
                            Toast.makeText(MainActivity.this,"验证通过"
                        ,Toast.LENGTH_SHORT).show();
                            Log.i("bmob", "验证通过");
                        }else{
                            Toast.makeText(MainActivity.this,"验证失败"
                                    ,Toast.LENGTH_SHORT).show();
                            Log.i("bmob", "验证失败：code ="+ex.getErrorCode()+",msg = "+ex.getLocalizedMessage());
                        }
                    }
                });
            }
        });
    }

}
