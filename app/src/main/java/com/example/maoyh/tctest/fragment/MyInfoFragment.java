package com.example.maoyh.tctest.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.maoyh.tctest.R;
import com.example.maoyh.tctest.until.AppUtils;
import com.example.maoyh.tctest.view.PopviewChoosePic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by MAOYH on 2016/3/9.
 */
public class MyInfoFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.imagev_front)
    ImageView mImagevFront;
    @Bind(R.id.imagev_back)
    ImageView mImagevBack;
    @Bind(R.id.imagev_commit)
    ImageView mImagevCommit;
    @Bind(R.id.edit_name)
    EditText mEditName;
    @Bind(R.id.edit_idcard)
    EditText mEditIdcard;
    @Bind(R.id.edit_address)
    EditText mEditAddress;
    @Bind(R.id.edit_phone)
    EditText mEditPhone;


    /**
     * 图片路径
     **/
    private String mCurrentPhotoStr;
    private Bitmap mPhotoImage;
    private static final int TAKE_PHOTO_FRONT = 1;
    private static final int TAKE_PHOTO_BACK = 3;
    private static final int GET_PHOTO_FRONT = 2;
    private static final int GET_PHOTO_BCAK = 4;
    private File filePath = new File(Environment.getExternalStorageDirectory() + "/Tangcan");
    private File outputImageFront = new File(Environment.getExternalStorageDirectory() + "/Tangcan/tempImage1.jpg");
    private File outputImageBack = new File(Environment.getExternalStorageDirectory() + "/Tangcan/tempImage2.jpg");

    /**
     * 需要传递参数时有利于解耦
     */
    public static MyInfoFragment newInstance() {
        Bundle args = new Bundle();
        MyInfoFragment fragment = new MyInfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private Activity getMyActivity() {
        Activity act = getActivity();
        if (act == null) {
            act = AppUtils.getActivity();
        }
        return act;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_myinfo, null);
        ButterKnife.bind(this, v);
        mImagevFront.setOnClickListener(this);
        mImagevBack.setOnClickListener(this);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        if (outputImageFront.exists()) {
            mImagevFront.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/Tangcan/tempImage1.jpg"));

        }
        if (outputImageBack.exists()) {
            mImagevBack.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/Tangcan/tempImage2.jpg"));
        }
        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    @Override
    public void onClick(View view) {
        showChoosePop(view);
    }

    private void showChoosePop(final View view) {
        final PopviewChoosePic myPopview = new PopviewChoosePic(getActivity());
        myPopview.showAtLocation(LayoutInflater.from(getMyActivity()).inflate(R.layout.fragment_myinfo, null), Gravity.BOTTOM, 0, 0);
        myPopview.setPopviewclickListener(new PopviewChoosePic.PopviewclickListener() {
            @Override
            public void OnTopClick() {
                //相机拍照
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                switch (view.getId()) {
                    case R.id.imagev_front:
                        if (outputImageFront.exists()) {
                            outputImageFront.delete();
                            try {
                                outputImageFront.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Uri imageUriFront = Uri.fromFile(outputImageFront);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriFront);
                        Log.e("uri", imageUriFront.toString());
                        startActivityForResult(intent, TAKE_PHOTO_FRONT);
                        break;
                    case R.id.imagev_back:
                        if (outputImageBack.exists()) {
                            outputImageBack.delete();
                            try {
                                outputImageBack.createNewFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        Uri imageUriBack = Uri.fromFile(outputImageBack);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUriBack);
                        Log.e("uri", imageUriBack.toString());
                        startActivityForResult(intent, TAKE_PHOTO_BACK);
                }

            }

            @Override
            public void OnMiddleClick() {
                //图库选取
                Intent intent2 = new Intent(Intent.ACTION_PICK, null);
                intent2.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                switch (view.getId()) {
                    case R.id.imagev_front:
                        startActivityForResult(intent2, GET_PHOTO_FRONT);
                        break;
                    case R.id.imagev_back:
                        startActivityForResult(intent2, GET_PHOTO_BCAK);

                }

            }

            @Override
            public void OnBottomClick() {
                myPopview.dismiss();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        getActivity();

        if (requestCode == TAKE_PHOTO_FRONT && resultCode == Activity.RESULT_OK) {
           // Bundle bundle = data.getExtras();
            //Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // 直接设置它的压缩率，表示1/2
            Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/Tangcan/tempImage1.jpg", options);
            mImagevFront.setImageBitmap(bitmap);        // 将图片显示在ImageView里
        }
        if (requestCode == GET_PHOTO_FRONT && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            // cursor游标
            Cursor cursor = getActivity().getContentResolver().query(uri, null, null,
                    null, null);
            cursor.moveToFirst();
            int idx = cursor
                    .getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            mCurrentPhotoStr = cursor.getString(idx);
            cursor.close();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // 直接设置它的压缩率，表示1/2
            mPhotoImage = BitmapFactory.decodeFile(mCurrentPhotoStr, options);
            if (outputImageFront.exists()) {
                outputImageFront.delete();
                try {
                    outputImageFront.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileOutputStream out = new FileOutputStream(outputImageFront);
                mPhotoImage.compress(Bitmap.CompressFormat.PNG, 100, out);//png类型
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mImagevFront.setImageBitmap(mPhotoImage);
        }

        if (requestCode == TAKE_PHOTO_BACK && resultCode == Activity.RESULT_OK) {
           // Bundle bundle = data.getExtras();
            //Bitmap bitmap = (Bitmap) bundle.get("data");// 获取相机返回的数据，并转换为Bitmap图片格式
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 3; // 直接设置它的压缩率，表示1/2
            Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/Tangcan/tempImage2.jpg", options);
            mImagevBack.setImageBitmap(bitmap);        // 将图片显示在ImageView里
        }
        if (requestCode == GET_PHOTO_BCAK && resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            // cursor游标
            Cursor cursor = getActivity().getContentResolver().query(uri, null, null,
                    null, null);
            cursor.moveToFirst();
            int idx = cursor
                    .getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            mCurrentPhotoStr = cursor.getString(idx);
            cursor.close();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2; // 直接设置它的压缩率，表示1/2
            mPhotoImage = BitmapFactory.decodeFile(mCurrentPhotoStr, options);
            if (outputImageBack.exists()) {
                outputImageBack.delete();
                try {
                    outputImageBack.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileOutputStream out = new FileOutputStream(outputImageBack);
                mPhotoImage.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("图片路径", Environment.getExternalStorageDirectory().toString());
            mImagevBack.setImageBitmap(mPhotoImage);
        }
    }

    @OnClick(R.id.imagev_turn_back)
    public void turnbackClick() {
        getMyActivity().finish();
    }

    @OnClick(R.id.imagev_commit)
    public void commitClick() {
        mEditName.setEnabled(true);
        mEditName.setText(mEditName.getText().toString());


    }
}
