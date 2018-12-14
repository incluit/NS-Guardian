package incluit.poc.authzero;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;

import com.auth0.android.Auth0;
import com.auth0.android.authentication.AuthenticationException;
import com.auth0.android.provider.AuthCallback;
import com.auth0.android.provider.WebAuthProvider;
import com.auth0.android.result.Credentials;


public class Auth0Provider {

    private static Auth0 auth0;

    public static void build (Context context, final IAuth0Poc inter) {
        auth0 = new Auth0(context);
        auth0.setOIDCConformant(true);




        WebAuthProvider.init(auth0)
                .withScheme("https")
                .withAudience(String.format("https://%s/userinfo", "naranja-nativescript.auth0.com"))
                .start((Activity) context, new AuthCallback() {
                    @Override
                    public void onFailure(final Dialog dialog) {
                        inter.onFailure();
                    }

                    @Override
                    public void onFailure(final AuthenticationException exception) {
                        inter.onFailure();
                    }

                    @Override
                    public void onSuccess(final Credentials credentials) {
                        inter.onSuccess();
                    }
                });
    }
}
