package com.journal.lockscreentut;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.journal.database.model.Product;
import com.journal.utils.Properties;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 5/7/2018.
 * RecyclerView.Adapter
 *RecyclerView.ViewHolder.ViewHolder
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_entry, parent, false);
        ProductViewHolder holder = new ProductViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.textViewTitle.setText(product.getTitle());
        holder.textViewDesc.setText(product.getBrief());
        holder.textViewRating.setText(String.valueOf(product.getImg()));
        holder.timestamp.setText(String.valueOf(formatDate(product.getTimestamp())));

        if ( product.getPath()!= null && !product.getPath().isEmpty())
        {

            holder.imageView.setImageBitmap(null);
//        note.setText("by Back Uri");
            try {
                Bitmap bm = BitmapFactory.decodeFile(product.getPath());
                holder.imageView.setImageBitmap(bm);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else
        {
            if (product.getImg() != 0)
            {
                holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImg()));
                // loading album cover using Glide library
                Glide.with(mCtx).load(product.getImg()).into(holder.imageView);
            }else
            {
                // loading album cover using Glide library
                Glide.with(mCtx).load(R.drawable.nf).into(holder.imageView);
            }
        }



        /*holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(holder.overflow);
            }
        });*/
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mCtx, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_card, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_info:
                    Toast.makeText(mCtx, "Info", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_settings:
                    Toast.makeText(mCtx, "Setting", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat(Properties.DATE_FORMAT_ALL);
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat(Properties.DATE_FORMAT);
            return fmtOut.format(date);
        } catch (ParseException e) {
            System.out.println( Properties.K_WARNING + " " + e.getMessage());
        }
        return "";
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
//        ImageView overflow;
        TextView textViewTitle, textViewDesc,
                textViewRating, timestamp;
//        TextView textViewPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
//            overflow = itemView.findViewById(R.id.overflow);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
//            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            timestamp = itemView.findViewById(R.id.timestamp);
        }
    }
}
