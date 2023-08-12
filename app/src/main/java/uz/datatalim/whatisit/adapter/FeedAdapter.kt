package uz.datatalim.whatisit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.whatisit.R
import uz.datatalim.whatisit.model.ImageModel

class FeedAdapter(val list:ArrayList<ImageModel>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val IMAGE=0
    val NO_IMAGE=1

    override fun getItemViewType(position: Int): Int {

        return if (list[position].postImage==null){

            NO_IMAGE

        }else{

            IMAGE

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view:View
        return when(viewType){

            NO_IMAGE->{

                view=LayoutInflater.from(parent.context).inflate(R.layout.item_feed_text,parent,false)
                FeedViewHolderText(view)

            }

            else->{

                view=LayoutInflater.from(parent.context).inflate(R.layout.item_feed_image,parent,false)
                FeedViewHolderImage(view)

            }
        }

    }

    override fun getItemCount(): Int {

        return list.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is FeedViewHolderImage){

            holder.apply {

                ivProfile.setImageResource(list[position].profile)
                list[position].postImage?.let { ivPostImage.setImageResource(it) }
                tvUsername.text=list[position].username
                tvTitle.text=list[position].title
                if (list[position].follow){

                    tvFollow.text="Followed"

                }else{

                    tvFollow.text="+ Follow"

                }
                tvPostText.text=list[position].post
                tvLikes.text=list[position].likes


            }

        }
        if (holder is FeedViewHolderText){

            holder.apply {



            }

        }

    }
    class FeedViewHolderImage(view:View):RecyclerView.ViewHolder(view){

        val ivProfile=view.findViewById<ImageView>(R.id.iv_Profile_itemImage)
        val tvUsername=view.findViewById<TextView>(R.id.tv_Username_itemImage)
        val tvTitle=view.findViewById<TextView>(R.id.tv_Title_itemImage)
        val tvFollow=view.findViewById<TextView>(R.id.tv_Follow_itemImage)
        val tvPostText=view.findViewById<TextView>(R.id.tv_Post_short_text_itemImage)
        val ivPostImage=view.findViewById<ImageView>(R.id.iv_Image_itemImage)
        val tvLikes=view.findViewById<TextView>(R.id.tv_Likes_itemImage)
        val tvComments=view.findViewById<TextView>(R.id.tv_Comments_itemImage)
        val ivLike=view.findViewById<ImageView>(R.id.iv_Like_itemImage)

    }
    class FeedViewHolderText(view:View):RecyclerView.ViewHolder(view){

        val ivProfile=view.findViewById<ImageView>(R.id.iv_Profile_itemImage)
        val tvUsername=view.findViewById<TextView>(R.id.tv_Username_itemImage)
        val tvTitle=view.findViewById<TextView>(R.id.tv_Title_itemImage)
        val tvFollow=view.findViewById<TextView>(R.id.tv_Follow_itemImage)
        val tvPostText=view.findViewById<TextView>(R.id.tv_Post_short_text_itemImage)
        val tvLikes=view.findViewById<TextView>(R.id.tv_Likes_itemImage)
        val tvComments=view.findViewById<TextView>(R.id.tv_Comments_itemImage)
        val ivLike=view.findViewById<ImageView>(R.id.iv_Like_itemImage)
    }
}