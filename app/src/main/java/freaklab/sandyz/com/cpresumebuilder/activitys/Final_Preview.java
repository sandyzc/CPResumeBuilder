package freaklab.sandyz.com.cpresumebuilder.activitys;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import freaklab.sandyz.com.cpresumebuilder.Database.Basic_Info_Database;
import freaklab.sandyz.com.cpresumebuilder.R;

public class Final_Preview extends AppCompatActivity {

    WebView webView;
    String base64;
    Basic_Info_Database basic_info_database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final__preview);
        basic_info_database=new Basic_Info_Database(this);


        webView=findViewById(R.id.webview);
        String html = "";

        String url ="srt-resume.html";
        String name= basic_info_database.getname();

        try {
            Document document = Jsoup.parse(this.getAssets().open(url), "UTF-8", "");
            document.getElementById("profession").html(name);

            document.getElementById("profession").html(basic_info_database.getProfession());
            document.getElementById("email").html(basic_info_database.getEmail());
            document.getElementById("phone_number").html(basic_info_database.getphone_number());
            document.getElementById("objective").html(basic_info_database.getObjective());
            document.getElementById("Skills").html(basic_info_database.getStreet());
            document.getElementById("skill_list1").html();
            document.getElementById("skill_list2").html();
                document.getElementById("skill_list3").html();
                document.getElementById("prof_company1").html();
                document.getElementById("prof_company1_desig").html();



            String stylesheet= "file:///android_asset/resume.css";
            document.head().appendElement("link").attr("rel", "stylesheet").attr("type", "text/css").attr("href", stylesheet);
            html = document.outerHtml();
            html = document.outerHtml();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
             base64=android.util.Base64.encodeToString(html.getBytes("UTF-8"), Base64.DEFAULT);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
      //  String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";

        webView.loadDataWithBaseURL("file:///android_asset/.",html,"text/html","UTF-8",null);
      //  webView.loadData(html,"text/html; charset=UTF-8",null);

       // webView.loadUrl("file:///android_asset/srt-resume.html");
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setInitialScale(50);
       // printResume(webView,this);
    }
    public static void printResume(WebView webView, Context context){
        PrintManager printManager = (PrintManager) context.getSystemService(Context.PRINT_SERVICE);
        PrintDocumentAdapter printAdapter = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            printAdapter = webView.createPrintDocumentAdapter("Resume");
        } else if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            printAdapter = webView.createPrintDocumentAdapter();
        }

        String jobName = context.getString(R.string.app_name) + " Resume";
        PrintAttributes.Builder builder= new PrintAttributes.Builder();
        builder.setMediaSize(PrintAttributes.MediaSize.ISO_A4);

        PrintJob printJob = printManager.print(jobName, printAdapter, builder.build());
    }
}
