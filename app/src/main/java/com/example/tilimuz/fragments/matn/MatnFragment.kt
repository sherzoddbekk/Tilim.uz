package com.example.tilimuz.fragments.matn

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tilimuz.R
import com.example.tilimuz.databinding.FragmentMatnBinding
import viewBinding


class MatnFragment : Fragment(R.layout.fragment_matn) {

    private val binding by viewBinding { FragmentMatnBinding.bind(it) }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        /**
         * text yozilganda sansh uchun
         */
        binding.etWrite.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {

                val length: Int = binding.etWrite.length()
                val convert = length.toString()
                binding.tvCountLetter.text = convert
                if (length == 0)
                    binding.ivLetterCancel.visibility =
                        View.GONE else binding.ivLetterCancel.visibility = View.VISIBLE

            }
        })
        /**
         * clear
         */
        binding.ivLetterCancel.setOnClickListener(View.OnClickListener {
            binding.etWrite.text.clear()
        })


        /**
         * copy
         */
        val clipboardManager = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        binding.ivLetterCopy.setOnClickListener {
            val text = binding.etWrite.text
            val clipData = ClipData.newPlainText("text", text)
            clipboardManager.setPrimaryClip(clipData)
            Toast(requireContext()).showCustomToast(R.drawable.ic_copy_white,"Matndan nusxa olindi.",requireActivity())
        }

        /**
         * change language
         */
        binding.llChangeWritte.setOnClickListener {
            binding.tvLotin.text = if (binding.tvLotin.text == "Lotin") "Крилл" else "Lotin"
            binding.tvKrill.text = if (binding.tvKrill.text == "Крилл") "Lotin" else "Крилл"
        }
        /**
         * listen.__________ will be added soon
         */
        binding.ivListenVoice.setOnClickListener {
            binding.etWrite.text.clear()
            Toast(requireContext()).showCustomToast(R.drawable.ic_information,
                "'Ovoz yozish' ishlab chiqilmoqda.",
                requireActivity()
            )
        }
    }

    fun Toast.showCustomToast( imageView: Int,message: String, activity: Activity) {
        val layout = activity.layoutInflater.inflate(
            R.layout.custom_toast,
            activity.findViewById(R.id.custom_toast)
        )

        // set the text of the TextView of the message
        val textView = layout.findViewById<TextView>(R.id.tv_toast)
        textView.text = message

        val img = layout.findViewById<ImageView>(R.id.iv_toast)
        img.setImageResource(imageView)


        // use the application extension function
        this.apply {
            setGravity(Gravity.CENTER, 0, 40)
            duration = Toast.LENGTH_SHORT
            view = layout
            show()
        }
    }

}

