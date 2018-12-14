package incluit.poc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import incluit.poc.authzero.Auth0Provider;
import incluit.poc.authzero.IAuth0Poc;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Auth0Provider.build(this, new IAuth0Poc() {
            @Override
            public void onFailure() {

            }


            public void onSuccess() {

            }
        });
    }
}
