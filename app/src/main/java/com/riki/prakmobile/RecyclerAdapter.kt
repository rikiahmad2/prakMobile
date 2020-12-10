package com.riki.prakmobile

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(private val context: Context, var titles: List<String>, private var details:List<String>, private var images:List<Int>) :
RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTitle: TextView = itemView.findViewById(R.id.tv_title)
        val itemDetail: TextView = itemView.findViewById(R.id.tv_description)
        val itemPicture: ImageView = itemView.findViewById(R.id.iv_image)

        init{
            itemView.setOnClickListener { v :View->
                val position: Int = adapterPosition

                if (position+1 == 1){
                    Toast.makeText(itemView.context, "Resep Ayam Katsu", Toast.LENGTH_SHORT).show()
                    val intent = (Intent(context, AyamGeprekActivity::class.java))
                    intent.putExtra("AYAM_KATSU", "- 3 bh Paha ayam \n - 1 bks Sajiku® Tepung Bumbu \n - 4 bh Cabai merah besar" +
                            "\n - 5 bh Cabai rawit hijau \n - 1 bh Tomat ukuran sedang \n - 2 siung Bawang putih \n - 3 siung Bawang merah \n - Minyak untuk menggoreng")
                    intent.putExtra("TITLE", itemTitle.text)
                    intent.putExtra("GAMBAR", "2")
                    context.startActivity(intent)
                }
                if (position+1 == 2){
                    Toast.makeText(itemView.context, "Resep Ayam Geprek", Toast.LENGTH_SHORT).show()
                    val intent = (Intent(context, AyamGeprekActivity::class.java))
                    intent.putExtra("AYAM_KATSU", "- 200g dada ayam tanpa kulit (2 bh) \n - 1 bks Sajiku® Tepung Bumbu \n - - 25 ml air es" +
                            "\n - Minyak goreng secukupnya. \n - Mayumi® Pedas \n - Irisan wortel \n - Lobak secukupnya \n - Minyak untuk menggoreng")
                    intent.putExtra("TITLE", itemTitle.text)
                    intent.putExtra("GAMBAR", "1")
                    context.startActivity(intent)
                }
                if (position+1 == 3){
                    Toast.makeText(itemView.context, "Resep Seblak Bandung", Toast.LENGTH_SHORT).show()
                    val intent = (Intent(context, AyamGeprekActivity::class.java))
                    intent.putExtra("AYAM_KATSU", "- 150gr Makaroni Rebus \n - 1 bks Masako®  Rasa Ayam \n - 2 btr Telur Ayam" +
                            "\n - 50 gr Kol \n - Mayumi® Pedas \n - 50 gr Wortel \n - 50 gr Sawi Hijau \n - 750 ml Air")
                    intent.putExtra("TITLE", itemTitle.text)
                    intent.putExtra("GAMBAR", "3")
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemPicture.setImageResource(images[position])
    }

}