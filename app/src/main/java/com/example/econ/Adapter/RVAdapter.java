package com.example.econ.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.econ.Model.Lessons;
import com.example.econ.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by jerome on 8/15/2016.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView txtTitle;
        TextView txtDescription;
        LinearLayout linearLayout;
        Button btnLearnMore;
        Context context;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            txtDescription = (TextView)itemView.findViewById(R.id.txtDescription);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.lessonBackground);
            btnLearnMore = (Button)itemView.findViewById(R.id.btnLearnMore);
            context = itemView.getContext();

            setFont(txtTitle);
        }

        private void setFont(TextView textView){
            Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf");
            textView.setTypeface(myTypeface);
        }
    }

    List<Lessons> lessons;

    public RVAdapter(List<Lessons> lessons){
        this.lessons = lessons;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_learn, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PersonViewHolder personViewHolder, final int i) {

        personViewHolder.txtTitle.setText(lessons.get(i).title);
        personViewHolder.txtDescription.setText(lessons.get(i).description);
        personViewHolder.linearLayout.setBackgroundResource(lessons.get(i).background);

        personViewHolder.btnLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personViewHolder.context.startActivity(lessons.get(i).activity);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }
}
