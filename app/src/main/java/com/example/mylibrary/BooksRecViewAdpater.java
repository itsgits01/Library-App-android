package com.example.mylibrary;

import static com.example.mylibrary.BookActivity.BOOK_ID_KEY;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdpater extends RecyclerView.Adapter<BooksRecViewAdpater.ViewHolder> {
    private static final String TAG = "BooksRecViewAdpater";

    private ArrayList<Book> books= new ArrayList<>();
    private Context mContext;

    public BooksRecViewAdpater(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_books,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getImageUrl())
                .into(holder.imgBook);
        
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY,books.get(position).getId());
//                intent.putExtra("bookName",books.get(position).getName());
                mContext.startActivity(intent);
                v.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
            }
        });
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtDescrp.setText(books.get(position).getShortDesc());

        if (books.get(position).isExpanded()){
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downarrow.setVisibility(View.GONE);
        }else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downarrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook;
        private TextView txtName;
        private ImageView downarrow;
        private ImageView uparrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor,txtDescrp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent=itemView.findViewById(R.id.paret);
            imgBook=itemView.findViewById(R.id.imgBook);
            txtName=itemView.findViewById(R.id.txtName);
            downarrow=itemView.findViewById(R.id.btndownArrow);
            uparrow=itemView.findViewById(R.id.btnUparrow);
            expandedRelLayout=itemView.findViewById(R.id.expandedRelLayout);
            txtAuthor=itemView.findViewById(R.id.txtAuthor);
            txtDescrp=itemView.findViewById(R.id.txtShortDesc);

            downarrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book= books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    v.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                    notifyItemChanged(getAdapterPosition());
                }
            });

            uparrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book= books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    v.performHapticFeedback(HapticFeedbackConstants.CONFIRM);
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }
}
