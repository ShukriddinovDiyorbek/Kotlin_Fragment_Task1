package uz.pdp.kotlinfrag

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FirstFragment.FirstListener, SecondFragment.SecondListener {
    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_first, firstFragment)
            .commit()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_second, secondFragment)
            .commit()
    }
    override fun onFirstSend(s: String) {
        secondFragment.updateSecondText(s)
    }

    override fun onSecondSend(s: String) {
        firstFragment.updateFirstText(s)
    }
}