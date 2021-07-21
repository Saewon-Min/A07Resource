package com.kosmo.a07resource;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
/*
res디렉토리 : 안드로이드에서 리소스로 취급되는 레이아웃, 이미지, 문자열
    등을 저장하는 디렉토리
    - drawable : 이미지, xml 파일등이 저장됨
    - values : 문자열, 배열, 색상, 크기 등을 정의한 xml 파일이 저장됨


    [레이아웃용 xml에서 리소스를 참조할 경우]
    drawable디렉토리 -> @drawable/이미지파일명
    values디렉토리
        -> 문자열 : @string/name속성값
        -> 색상 : @color/name속성값
        -> 크기 : @dimen/name속성값
        -> 배열 : @array/name속성값
    형태로 사용한다.

    [java코드에서 참조할 경우]
    Resources resource = getResources();
    drawable디렉토리
        -> resource.getDrawable(R.drawable시작하는 리소스아이디)
    values디렉토리
        -> 문자열 : resource.getString(R.string.리소스아이디);
        -> 색상 : ContextCompat.getColor(Context, R.color.리소스아이디);
        -> 크기 : resource.getDimension(R.dimen.리소스아이디); */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 가져오기
        TextView textViewCode = (TextView)findViewById(R.id.code_textview);
        ImageView imageViewCode = (ImageView)findViewById(R.id.code_imageview);
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);

        /*
        텍스트뷰에 리소스에서 가져온 값 설정하기위한
        Resource객체 생성
         */
        final Resources resources = getResources();

        // 텍스트 설정
        textViewCode.setText(R.string.code_message);
        // 텍스트 크기 설정
        textViewCode.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                resources.getDimension(R.dimen.dimenXml));
        // 텍스트 컬러 설정
        textViewCode.setTextColor(ContextCompat.getColor(this,
                R.color.colorXml));
        /*
        XML 레이아웃 파일에서 사용하는 속성 앞에 set을 붙이면 대부분
        설정 메소드가 된다.

        ex] text -> setText
         */
        // 이미지뷰에 Jav코드로 이미지 설정하기
        imageViewCode.setImageResource(R.drawable.grandmother);


        // int형 배열을 출력하는 버튼
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*
                res 의 arrays.xml에서 int_array 항목을 가져와서 문자열로
                변경한 후 토스트로 출력한다.
                 */
                Toast.makeText(view.getContext(),
                        Arrays.toString(resources.getIntArray(R.array.int_array)),
                        Toast.LENGTH_LONG).show();
            }
        });

        /*
        String형 배열을 출력하는 버튼
         */
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*
                리소스를 읽어와서 String형 배열에 저장
                 */
                String[] idolArr =
                        resources.getStringArray(R.array.str_array);

                /*
                StringBuffer를 통해 내용을 하나의 문자열로 만들어줌
                 */
                StringBuffer buf = new StringBuffer();
                for(String idol:idolArr){
                    buf.append(idol+"\r\n");
                }

                Toast.makeText(view.getContext(),
                        buf,
                        Toast.LENGTH_LONG).show();
            }
        });
    }//// onCreate() 끝
}//// MainActivity 끝