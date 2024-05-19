package sakura.xforward

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.widget.Toast

@SuppressLint("CustomSplashScreen")
class LaunchActivity: Activity() {

    override fun onResume() {
        super.onResume()

        val data = intent.data

        if(data == null) {
            Toast.makeText(this, "intent.data is null", Toast.LENGTH_SHORT).show()
        }
        else {
            var scheme = data.scheme
            if(scheme == "x") {
                scheme = "twitter"
            }

            var host = data.host
            if (host != null) {
                host = host.replace("x.com", "twitter.com")
            }

            val link = "${scheme}://${host}${data.path}"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            intent.setPackage("com.twitter.android")
            startActivity(intent)
        }

        finish()
    }


}