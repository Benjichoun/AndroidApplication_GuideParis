package org.esiea.badelon_batista.androidapplication_guideparis;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**Service permettant de recuperer un .json en ligne
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetArrInfoServices extends IntentService {

    public static final String TAG = "GetArrInfoServices";
    private static final String ACTION_GET_ALL_ARRINFO = "ACTION_GET_ALL_ARRINFO"; //Permet de vérifier si on a bien recuper l'info de l'Intent
    public String urlString;
    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    public static void startActionArrInfo(Context context, String url) {
        Intent intent = new Intent(context, GetArrInfoServices.class);//Création de l'intent pour passer de startActionArrInfo à onHandleIntent
        intent.setAction(ACTION_GET_ALL_ARRINFO);//Set action
        intent.putExtra("url", url); //On met le lien provenant de l'activity
        context.startService(intent);//On lance le service

    }


    public GetArrInfoServices() {
        super("GetArrInfoServices");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent != null) {
            final String action = intent.getAction();//Récupération de l'action
            if (ACTION_GET_ALL_ARRINFO.equals(action)) {//Verification
                setUrlString(intent.getStringExtra("url"));//Set du lien à télécharger
                handleActionArrInfo();//Lancement de la récuperation du json
            }

        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */

    private void handleActionArrInfo() {
        Log.d(TAG, "Thread service name:" + Thread.currentThread().getName());
        URL url = null;

        try {
            url = new URL(getUrlString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if(HttpURLConnection.HTTP_OK == conn.getResponseCode()){
                copyInputStreamToFile(conn.getInputStream(), //copie du fichier
                        new File(getCacheDir(), "arr.json")); //Création du fichier dans le cache
                Log.d(TAG, "arr json downloaded !");
                LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(ArrondissementsActivity.ARRINFO_UPDATE));//Envoie a l'activity arrondissements
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyInputStreamToFile( InputStream in, File file ) { //Methode pour copier le fichier récuperé
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf))>0){
                out.write(buf,0,len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//Getter setter d'UrlString
    public void setUrlString(String urlString) {
        this.urlString = urlString;
    }

    public String getUrlString() {
        return urlString;
    }
}
