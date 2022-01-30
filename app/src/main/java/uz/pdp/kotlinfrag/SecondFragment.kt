package uz.pdp.kotlinfrag

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    var listener: SecondListener? = null
    lateinit var root: View
    lateinit var second_btn: Button
    lateinit var second_tv: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_second, container, false)
        second_tv = root.findViewById(R.id.second_tv)
        second_btn = root.findViewById(R.id.second_btn)

        second_btn.setOnClickListener {
            listener!!.onSecondSend("PDP")
        }

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        } else {
            throw RuntimeException("$context must implement First Listener")
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface SecondListener {
        fun onSecondSend(s: String)
    }

    fun updateSecondText(s: String) {
        second_tv.text = s
    }

}