package com.yuanyang.lession21;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建一个可以拍照的应用：
 * 1，在清单文件中申明拍照特性，让google play在没有摄像头的设备上面不显示
 */


public class MainActivity extends AppCompatActivity {

    private static final int REUQESTCODE_CAMERA = 0x110;
    private static final String TAG = "MainActivity";

    private Uri imageUri;

    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 这种方式取出来的是照片的缩略图
     *
     * @param v
     */
    public void takePhoto(View v) {
        try {
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            File imageFile = getImageFile();
            imagePath = imageFile.getAbsolutePath();
            imageUri = Uri.fromFile(imageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, REUQESTCODE_CAMERA);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private File getImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmsss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        //关于  getExternalFilesDir():https://developer.android.com/reference/android/content/Context.html#getExternalFilesDir(java.lang.String)
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, "jpg", storageDir);
        return image;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REUQESTCODE_CAMERA && resultCode == RESULT_OK) {
            notifyScanner();
            Log.i(TAG, imageUri.toString());
        }
    }

    /**
     * 通知扫描器扫描，此时可能无权限
     */
    private void notifyScanner() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(imagePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);

    }
}
