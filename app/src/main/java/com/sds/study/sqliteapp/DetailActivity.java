package com.sds.study.sqliteapp;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by student on 2016-11-18.
 */

public class DetailActivity extends AppCompatActivity {
    ImageView img;
    LinearLayout layout;

    EditText editTxt_id;
    EditText editTxt_pwd;

    Member member;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        member = intent.getParcelableExtra("data");

        img = (ImageView) findViewById(R.id.img);
        AnimationDrawable drawable = (AnimationDrawable) img.getDrawable();
        drawable.start();

        layout = (LinearLayout) findViewById(R.id.layout);
        AnimationDrawable back = (AnimationDrawable) layout.getBackground();
        back.start();

        editTxt_id = (EditText) findViewById(R.id.editTxt_id);
        editTxt_pwd = (EditText) findViewById(R.id.editTxt_pwd);


        editTxt_id.setText(member.getId());
        editTxt_pwd.setText(member.getPassword());
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_list:

            case R.id.btn_edit:
                Member edit_member = new Member();
                edit_member.setMember_id(member.getMember_id());
                edit_member.setId(editTxt_id.getText().toString());
                edit_member.setPassword(editTxt_pwd.getText().toString());
                MyListAdapter.memberList.set(edit_member.getMember_id(), edit_member);
                Toast.makeText(this, "수정되었습니다.", Toast.LENGTH_SHORT).show();

            case R.id.btn_delete:
                MyListAdapter.memberList.remove(member.getMember_id());
                //MyListAdapter.db.
                Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
