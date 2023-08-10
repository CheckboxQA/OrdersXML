import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TextView.*
import androidx.recyclerview.widget.RecyclerView
import com.example.ordersxml.R
import com.example.test.Product

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int = productList.size

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.item_name)
        private val barcodeTextView: TextView = itemView.findViewById(R.id.item_barcode)
        private val totalSumTextView: TextView = itemView.findViewById(R.id.item_total_sum)
        private val quantityTextView: TextView = itemView.findViewById(R.id.item_quantity)

        fun bind(product: Product) {
            nameTextView.text = product.name
            barcodeTextView.text = product.barcode
            totalSumTextView.text = product.totalSum
            quantityTextView.text = product.quantity
            if (product.barcode == null) {
                barcodeTextView.visibility = View.GONE
            } else {
            barcodeTextView.visibility = View.VISIBLE
        }
        }
    }
}
