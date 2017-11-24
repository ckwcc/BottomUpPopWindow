package com.ckw.zfsoft.widgetpopupwindow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import com.ckw.zfsoft.widgetpopupwindow.popviews.BottomUpPopView
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast



class MainActivity : AppCompatActivity() {

    private var mButton: Button? = null
    private var mPopView: BottomUpPopView? = null

    private val mItemClickListener = View.OnClickListener { v ->
        when (v.id) {
            R.id.tv_bottom_up_first_item -> {
                Toast.makeText(this@MainActivity, "点击了第一个item", Toast.LENGTH_SHORT).show()
            }
            R.id.tv_bottom_up_second_item -> {
                Toast.makeText(this@MainActivity,"点击了第二个item",Toast.LENGTH_SHORT).show()
            }
            R.id.tv_bottom_up_third_item ->{
                Toast.makeText(this@MainActivity,"点击了第三个item",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButton = findViewById<Button>(R.id.btn_pop) //查找控件的方式一

        val mNames = ArrayList<String>()
        mNames.add("赞同")
        mNames.add("反对")
        mNames.add("弃权")


        mPopView = BottomUpPopView(this,mNames,mItemClickListener)

        //查找控件的方式二：直接对应xml中的用户名
        btn_pop.setOnClickListener { _ ->
            mPopView?.showAtLocation(findViewById(R.id.cl_main), Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL,0,0)
            mPopView?.backgroundAlpha(0.5f)
        }
    }
}
