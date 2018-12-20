package com.example.nirosha.testcart;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ProductWarrantyAdapter extends RecyclerView.Adapter<ProductWarrantyAdapter.ProductViewHolder> {
    private static final String TAG = ProductWarrantyAdapter.class.getSimpleName();
    private Context context;
    private List<WarrantyObject> mWarrantyObjects;
    private int selectedPosition=0;

    public ProductWarrantyAdapter(Context context, List<WarrantyObject> productList) {
        this.context = context;
        this.mWarrantyObjects = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.warranty_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        WarrantyObject productObject = mWarrantyObjects.get(position);
        holder.warrantyDuration.setText(productObject.getDuration());

        if (position==selectedPosition){
            holder.addtocart_layout.setBackgroundResource(R.drawable.warranty_itemadded_selector);
            holder.addcart_text.setCompoundDrawablesWithIntrinsicBounds( R.drawable.ic_check_material, 0, 0, 0);
        }else {
            holder.addtocart_layout.setBackgroundResource(R.drawable.warranty_selector);
            holder.addcart_text.setCompoundDrawablesWithIntrinsicBounds( 0, 0, 0, 0);
        }
    }

    @Override
    public int getItemCount() {
        return mWarrantyObjects.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        public TextView warrantyDuration, warrantyValue,addcart_text;
        private RelativeLayout addtocart_layout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            warrantyDuration = (TextView) itemView.findViewById(R.id.warranty_duration);
            warrantyValue = (TextView) itemView.findViewById(R.id.warranty_cost);
            addcart_text = (TextView) itemView.findViewById(R.id.addcart_text);
            addtocart_layout = (RelativeLayout) itemView.findViewById(R.id.addtocart_layout);

            addtocart_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG,"On click"+getAdapterPosition());
                    selectedPosition=getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }
}