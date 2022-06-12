import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfoodapp2.FoodActivity
import com.example.myfoodapp2.R
import com.example.myfoodapp2.model.Declaration

class ListAdapter(private val dataSet: List<Declaration>) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    class ListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name_of_food)
        val price: TextView = view.findViewById(R.id.price)
        val image: ImageView = view.findViewById(R.id.imageView)
        val button: Button = view.findViewById(R.id.moreBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val adapterLayout = LayoutInflater.from( parent.context).inflate(R.layout.list_file, parent, false)
        return ListViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = dataSet[position]
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price
        holder.image.setImageResource(currentItem.imageResources)
        holder.button.text
        holder.button.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, FoodActivity::class.java)
            intent.putExtra(FoodActivity.NAME, currentItem.name)
            intent.putExtra(FoodActivity.IMAGE, currentItem.imageResources)
            intent.putExtra(FoodActivity.DETAILS, currentItem.details)
            intent.putExtra(FoodActivity.PRICE, currentItem.price)

            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size
}